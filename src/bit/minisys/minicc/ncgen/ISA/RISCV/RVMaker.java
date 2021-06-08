package bit.minisys.minicc.ncgen.ISA.RISCV;

import bit.minisys.minicc.icgen.internal.IRBuilder;
import bit.minisys.minicc.ncgen.BasicBlockInfo.BasicBlock;
import bit.minisys.minicc.ncgen.BasicBlockInfo.FunctionContent;
import bit.minisys.minicc.ncgen.BasicBlockInfo.WzcIRScanner;
import bit.minisys.minicc.ncgen.IR.IRInstruction.*;
import bit.minisys.minicc.ncgen.IR.Symbol.Sy_PolyItem;
import bit.minisys.minicc.ncgen.IR.Symbol.Sy_PolyVar;
import bit.minisys.minicc.ncgen.ISA.RISCV.instructions.*;
import bit.minisys.minicc.ncgen.Util.JudgeConstant;
import bit.minisys.minicc.ncgen.WzcTargetMaker;
import bit.minisys.minicc.pp.internal.R;
import bit.minisys.minicc.pp.internal.V;

import java.util.*;

public class RVMaker implements WzcTargetMaker
{
    LinkedList<FunctionContent> Functions;
    String Output = "";
    LinkedList<IR_instruction> header;
    LinkedList<String> FuncRVCode;
    Boolean[] TReg;
    Boolean[] AReg;
    Boolean[] SReg;

    HashMap<String, String> V2P_Reg_Map;//虚拟寄存器到物理寄存器的映射

    int NOW_USED_S_REG = 1;
    LinkedList<RV_instruction> NOW_FUNC_CODE;
    LinkedList<String> NOW_USING_V_Reg;
    int NOW_FRAME_SIZE = 0;

    /*
    寄存器分配算法：
        使用

     */
    String GetReg()
    {
        for (int i = 0; i < TReg.length; i++)
        {
            if (TReg[i])
            {
                TReg[i] = false;
                return "t" + i;
            }
        }
        for (int i = AReg.length - 1; i > 0; i--)
        {
            if (AReg[i])
            {
                AReg[i] = false;
                return "a" + i;
            }
        }
        for (int i = 1; i < SReg.length; i++)
        {
            if (TReg[i])
            {
                TReg[i] = false;
                return "t" + i;
            }
        }
        //spill
        String release_vreg = NOW_USING_V_Reg.peek();
        ReleaseVReg(NOW_USING_V_Reg.peek());
        V2P_Reg_Map.replace(V2P_Reg_Map.get(release_vreg), "-" + NOW_FRAME_SIZE);
        NOW_FRAME_SIZE += 4;

        return GetReg();
    }

    String GetReg(String V_Reg)
    {
        if (JudgeConstant.isNumeric(V_Reg))
        {
            if (Integer.parseInt(V_Reg) == 0)
            {
                return "zero";
            }
            String dest = GetReg();
            NOW_FUNC_CODE.add(new RV_addi(dest, "zero", Integer.parseInt(V_Reg)));
            ReleasePReg(dest);
            return dest;
        }
        if (V2P_Reg_Map.containsKey(V_Reg))
        {
            return V2P_Reg_Map.get(V_Reg);
        }
        String P_reg = GetReg();
        V2P_Reg_Map.put(V_Reg, P_reg);
        NOW_USING_V_Reg.add(V_Reg);
        return P_reg;
    }

    String GetAddr(String V_Reg)
    {
        return V2P_Reg_Map.get(V_Reg);
    }

    void ReleaseVReg(String vreg)
    {
        NOW_USING_V_Reg.remove(vreg);
        ReleasePReg(V2P_Reg_Map.get(vreg));
    }

    void ReleasePReg(String preg)
    {
        if (preg.contains("t"))
        {

            TReg[Integer.parseInt(preg.substring(1))] = true;
        }
        else if (preg.contains("a"))
        {
            AReg[Integer.parseInt(preg.substring(1))] = true;
        }
        else if (preg.contains("s"))
        {
            SReg[Integer.parseInt(preg.substring(1))] = true;
        }
    }

    public RVMaker(LinkedList<FunctionContent> Functions, LinkedList<IR_instruction> dec)
    {
        this.Functions = Functions;
        this.header = dec;
        this.FuncRVCode = new LinkedList<>();
        Run();
    }

    void Run()
    {
        for (FunctionContent content :
                Functions)
        {
            String RV_CODE = ContentHandler(content);

            if (content.name.equals("main"))
            {
                FuncRVCode.push(RV_CODE);
            }
            else
            {
                FuncRVCode.add(RV_CODE);
            }
        }
    }

    String ContentHandler(FunctionContent functionContent)//todo: FunctionContent的类型
    {
        //可用寄存器初始化
        this.TReg = new Boolean[7];
        this.AReg = new Boolean[8];
        this.SReg = new Boolean[12];
        for (int i = 0; i < 7; i++)
        {
            TReg[i] = true;
        }
        for (int i = 0; i < 8; i++)
        {
            AReg[i] = true;
        }
        for (int i = 1; i < 12; i++)
        {
            SReg[i] = false;
        }

        HashMap<String, String> LLVM2RVIns = new HashMap<>();
        LLVM2RVIns.put("load", "lw");
        LLVM2RVIns.put("store", "sw");
        LLVM2RVIns.put("add", "add");
        LLVM2RVIns.put("sub", "sub");
        LLVM2RVIns.put("srem", "rem");
        //比较反着来
        LLVM2RVIns.put("slt", "bge");
        LLVM2RVIns.put("sle", "bgt");
        LLVM2RVIns.put("sgt", "ble");
        LLVM2RVIns.put("sge", "blt");
        LLVM2RVIns.put("eq", "bne");
        LLVM2RVIns.put("ne", "beq");

        LLVM2RVIns.put("sdiv", "div");
        LLVM2RVIns.put("mul", "mul");

        LinkedList<String> Tag2Print = new LinkedList<>();

        this.V2P_Reg_Map = new HashMap<>(); // 释放时，从中移除

        WzcIRScanner func_info = new WzcIRScanner(functionContent.GetFunctionInstruction());
        func_info.ScanInfo();

        //把所有alloca都映射了
        //V2P_Reg_Map中只有两种情况：相对于fp的指针、以及物理寄存器
        for (String para : functionContent.used_param) // todo: 参数多于8的情况
        {
            V2P_Reg_Map.put(para, "a" + para.substring(1));
        }
        for (HashMap.Entry<String, Integer> met : func_info.GetAllocaMap().entrySet())
        {
            V2P_Reg_Map.put(met.getKey(), "-" + (met.getValue() + 2) * 4);
        }
        NOW_FRAME_SIZE = (func_info.FuncAllocaCount) * 4;
        NOW_USING_V_Reg = new LinkedList<>();
        NOW_FUNC_CODE = new LinkedList<>();

        //开始真正遍历基本块，
        for (int b = 0; b < func_info.GetBasicBlocks().size(); b++)
        {
            BasicBlock block = func_info.GetBasicBlocks().get(b);
            if (block.GetVRegReleaseInfo() == null) //这个块不可达 todo: 添加不可达块的支持！
            {
                continue;
            }
            for (int i = 0; i < block.DAGS.size(); i++)
            {
                IR_instruction instruction = block.DAGS.get(i);

                if (!(instruction instanceof IR_compare))
                {
                    ReleaseNowReg(block, i);
                }

                if (instruction instanceof IR_op)
                {
                    IR_op op = (IR_op) instruction;
                    if (JudgeConstant.isNumeric(op.src2)) //todo: 如果是a=1+1,a=1+a
                    {
                        if (op.op.equals("sub"))
                        {
                            NOW_FUNC_CODE.add(new RV_addi(GetReg(op.dest), GetReg(op.src1), -Integer.parseInt(op.src2)));

                        }
                        else
                        {
                            NOW_FUNC_CODE.add(new RV_addi(GetReg(op.dest), GetReg(op.src1), Integer.parseInt(op.src2)));
                        }
                    }
                    else
                    {
                        NOW_FUNC_CODE.add(new RV_3addr_ins(LLVM2RVIns.get(op.op), GetReg(op.dest), GetReg(op.src1), GetReg(op.src2)));
                    }
                }

                else if (instruction instanceof IR_store)
                {
                    IR_store store = (IR_store) instruction;
                    int offset = Integer.parseInt(GetAddr(store.dest));
                    NOW_FUNC_CODE.add(new RV_store(GetReg(store.src), "fp", offset));

                }

                else if (instruction instanceof IR_load)
                {
                    IR_load load = (IR_load) instruction;
                    int offset = Integer.parseInt(GetAddr(load.src));
                    NOW_FUNC_CODE.add(new RV_load(GetReg(load.dest), "fp", offset));
                }
                else if (instruction instanceof IR_call)
                {
                    IR_call call = (IR_call) instruction;
                    String[] paras = ((IR_call) instruction).para_list;
                    //todo: 注意保护现场！
                    for (int j = 0; j < paras.length; j++)
                    {
                        NOW_FUNC_CODE.add(new RV_mv("a" + j, GetReg(paras[j])));
                    }
                    NOW_FUNC_CODE.add(new RV_call(call.func_name));
                    if (call.dest != null)
                    {
                        V2P_Reg_Map.put(call.dest, "a0");
                        NOW_USING_V_Reg.add(call.dest);
                    }
                }

                else if (instruction instanceof IR_compare)
                {
                    IR_compare compare = (IR_compare) instruction;
                    i++;
                    IR_branch branch = (IR_branch) block.DAGS.get(i);
                    NOW_FUNC_CODE.add(new RV_branch(LLVM2RVIns.get(compare.op), GetReg(compare.src1), GetReg(compare.src2), ".L" + branch.false_dest.substring(1)));
                    ReleaseNowReg(block, i); //这里有个特例，因为CMP可能从右值中载入，此时不能让同样在右边的寄存器释放……
                    Tag2Print.add(".L" + branch.false_dest.substring(1));
                }

                else if (instruction instanceof IR_branch)//无条件跳转
                {
                    IR_branch branch = (IR_branch) instruction;
                    if (func_info.GetBasicBlocks().size() > b + 1)
                    {
                        if (func_info.GetBasicBlocks().get(b + 1).tag.equals(branch.dest.substring(1)))
                        {
                            continue;
                        }
                    }
                    if (!branch.is_conditional)
                    {
                        NOW_FUNC_CODE.add(new RV_jmp(".L" + branch.dest.substring(1)));
                        Tag2Print.add(".L" + branch.dest.substring(1));
                    }
                }

                else if (instruction instanceof IR_tag)
                {
                    NOW_FUNC_CODE.add(new RV_tag(".L" + ((IR_tag) instruction).target_label));
                }

                else if (instruction instanceof IR_getelementptr)
                {
                    //todo: search poly item's type
                    IR_getelementptr getelementptr = (IR_getelementptr) instruction;
                    if (getelementptr.get_ptr_sentence instanceof Sy_PolyVar)
                    {
                        Sy_PolyVar polyVar = (Sy_PolyVar) getelementptr.get_ptr_sentence;
                        String size = GetReg(getelementptr.offset);
                        while (polyVar.GetInsideItem() instanceof Sy_PolyVar)
                        {
                            i++;
                            polyVar = (Sy_PolyVar) polyVar.GetInsideItem();
                        }

                    }
                    else
                    {
                        //字符串
                    }

                }

                else if (instruction instanceof IR_ret)
                {
                    //todo:如果是main，就使用别的方式退出
                    NOW_FUNC_CODE.add(new RV_load("ra", "sp", NOW_FRAME_SIZE));
                    NOW_FUNC_CODE.add(new RV_load("fp", "sp", NOW_FRAME_SIZE - 4));
                    NOW_FUNC_CODE.add(new RV_addi("sp", "sp", NOW_FRAME_SIZE + 4));

                    if (functionContent.name.equals("main"))
                    {
                        NOW_FUNC_CODE.add(new RV_addi("a7", "zero", 10));
                        NOW_FUNC_CODE.add(new RV_ecall());
                    }
                    else
                    {
                        NOW_FUNC_CODE.add(new RV_ret());
                    }
                }
            }
        }

        StringBuilder rt_str = new StringBuilder();
        rt_str.append(functionContent.name).append(":").append("\n");
        //栈帧初始化
        NOW_FUNC_CODE.push(new RV_addi("fp", "sp", NOW_FRAME_SIZE));

        for (int i = 1; i < NOW_USED_S_REG; i++)
        {
            NOW_FUNC_CODE.push(new RV_store("s" + i, "sp", NOW_FRAME_SIZE - 4 * (i + 2)));
        }

        NOW_FUNC_CODE.push(new RV_store("fp", "sp", NOW_FRAME_SIZE - 4));
        NOW_FUNC_CODE.push(new RV_store("ra", "sp", NOW_FRAME_SIZE));
        NOW_FUNC_CODE.push(new RV_addi("sp", "sp", -NOW_FRAME_SIZE + 4));

        for (RV_instruction ins :
                NOW_FUNC_CODE)
        {
            if (ins instanceof RV_tag)
            {
                if (Tag2Print.contains(((RV_tag) ins).tag_name))
                {
                    rt_str.append(ins.toString());
                }
            }
            else
            {
                rt_str.append("  ").append(ins.toString());
            }
        }
        return rt_str.toString() + "\n";
    }

    void ReleaseNowReg(BasicBlock block, int line) //右值可以使用释放的，但是左值不行
    {
        for (int j = NOW_USING_V_Reg.size() - 1; j >= 0; j--)
        {
            String V_Reg = NOW_USING_V_Reg.get(j);
            if (null != block.GetVRegReleaseInfo().get(V_Reg))
            {
                if (line >= block.GetVRegReleaseInfo().get(V_Reg))
                {
                    ReleaseVReg(V_Reg);
                }
            }
            else
            {
                System.out.println("Outch!\n");
            }
        }
    }

    /*
     * 使用WzcIRScanner扫描一个函数内的信息，得到一些必要的寄存器表等
     *
     * */
    @Override
    public String GetCodeHeader(LinkedList<IR_instruction> declaration)
    {
        return null;
    }

    String Lib_Function = "";

    public void AddLibFunctionBody(String body)
    {
        Lib_Function += body;
    }

    @Override
    public String GetTargetCode()
    {
        //todo: 这个只是临时支持
        String lib_rv = "" +
                "Mars_PrintStr:\n" +
//                "  li a7,4\n" +
//                "  ecall\n" +
                "  ret\n" +

                "Mars_GetInt:\n" +
                "  li a7,5\n" +
                "  ecall\n" +
                "  ret\n" +

                "Mars_PrintInt:\n" +
                "  li a7,1\n" +
                "  ecall\n" +
                "  ret\n";
        AddLibFunctionBody(lib_rv);
        //这里把字符串输出搞定
        Output += GetCodeHeader(this.header);
        if (Output.equals("null"))
        {
            Output = "";
        }
        //在这里应该加上一个返回的GetCodeHeader
        for (String func_code :
                FuncRVCode)
        {
            Output += func_code;
        }

        return Output + Lib_Function;
        //这里还要把库函数的函数体写上去
    }
}
