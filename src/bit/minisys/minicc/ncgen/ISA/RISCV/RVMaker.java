package bit.minisys.minicc.ncgen.ISA.RISCV;

import bit.minisys.minicc.ncgen.BasicBlockInfo.BasicBlock;
import bit.minisys.minicc.ncgen.BasicBlockInfo.FunctionContent;
import bit.minisys.minicc.ncgen.BasicBlockInfo.WzcIRScanner;
import bit.minisys.minicc.ncgen.IR.IRInstruction.*;
import bit.minisys.minicc.ncgen.ISA.RISCV.instructions.*;
import bit.minisys.minicc.ncgen.Util.JudgeConstant;
import bit.minisys.minicc.ncgen.WzcTargetMaker;

import java.util.*;

public class RVMaker implements WzcTargetMaker
{
    LinkedList<FunctionContent> Functions;
    String Output = "";
    LinkedList<IR_instruction> header;
    LinkedList<String> FuncRVCode;
    PriorityQueue<Integer> TReg;
    PriorityQueue<Integer> AReg;
    PriorityQueue<Integer> SReg;
    HashMap<String, String> V2P_Reg_Map;//虚拟寄存器到物理寄存器的映射

    LinkedList<RV_instruction> NOW_FUNC_CODE;
    LinkedList<String> NOW_USING_V_Reg;
    int NOW_FRAME_SIZE = 0;

    String GetReg() //得到寄存器的顺序：t系列，a系列，s系列
    {
        if (!TReg.isEmpty())
        {
            return "t" + TReg.poll();
        }
        else
        {
            if (!AReg.isEmpty())
            {
                return "a" + TReg.poll();
            }
            else
            {
                return "s" + SReg.poll(); // todo: 栈帧增加,抛弃处理
            }
        }
    }

    String GetReg(String V_Reg) //先不考虑spill
    {
        NOW_USING_V_Reg.add(V_Reg);
        if (JudgeConstant.isNumeric(V_Reg))
        {
            if (V_Reg.equals("0"))
            {
                return "zero";
            }
            else
            {
                String tmp_reg = GetReg();
                ReleaseReg(tmp_reg);
                NOW_FUNC_CODE.add(new RV_li(tmp_reg, Integer.parseInt(V_Reg)));
                return tmp_reg;
            }
        }
        if (V2P_Reg_Map.containsKey(V_Reg))
        {
            String reg = V2P_Reg_Map.get(V_Reg); // todo: 如果是地址，则说明spill
            if (JudgeConstant.isNumeric(reg))
            {
                String addr = reg;
                reg = GetReg();
                NOW_FUNC_CODE.add(new RV_load(reg, "fp", Integer.parseInt(addr)));
                return reg;
            }
            return V2P_Reg_Map.get(V_Reg);
        }
        String p_reg = GetReg();
        V2P_Reg_Map.putIfAbsent(V_Reg, p_reg);
        return p_reg;
    }

    String GetAddr(String V_Reg)
    {
        return V2P_Reg_Map.get(V_Reg);
    }

    void ReleaseReg(String reg)
    {
        if (reg.contains("t"))
        {
            TReg.add(Integer.parseInt(reg.substring(1)));
        }
        else if (reg.contains("a") && !reg.equals("anull"))
        {
            AReg.add(Integer.parseInt(reg.substring(1)));
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
        this.TReg = new PriorityQueue<>();
        this.SReg = new PriorityQueue<>();
        this.AReg = new PriorityQueue<>(new Comparator<Integer>()
        {
            @Override
            public int compare(Integer integer, Integer t1)
            {
                return t1 - integer;
            }
        }); //A用大根堆
        for (int i = 0; i < 7; i++)
        {
            TReg.add(i);
        }
        for (int i = 0; i < 8; i++)
        {
            if (!functionContent.used_param.contains("%" + i))
            {
                AReg.add(i);
            }
        } // SReg好像还用不到

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
        NOW_FRAME_SIZE = func_info.FuncAllocaCount * 4;
        NOW_USING_V_Reg = new LinkedList<>();
        NOW_FUNC_CODE = new LinkedList<>();

        //开始真正遍历基本块，
        for (BasicBlock block : func_info.GetBasicBlocks())
        {
            if (block.GetVRegReleaseInfo() == null) //这个块不可达 todo: 添加不可达块的支持！
            {
                continue;
            }
            for (int i = 0; i < block.DAGS.size(); i++)
            {
                IR_instruction instruction = block.DAGS.get(i);

                Iterator<String> iterator = NOW_USING_V_Reg.iterator();
                while (iterator.hasNext())
                {
                    String vreg = iterator.next();
                    if (block.GetVRegReleaseInfo().get(vreg) != null) // 释放物理寄存器
                    {
                        if (block.GetVRegReleaseInfo().get(vreg) >= i)
                        {
                            ReleaseReg(V2P_Reg_Map.get(vreg));
                        }
                    }
                    else
                    {
                        iterator.remove();
                    }
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

                else if (instruction instanceof IR_alloca)
                {
                    V2P_Reg_Map.put(((IR_alloca) instruction).dest, "-" + NOW_FRAME_SIZE);
                    NOW_FRAME_SIZE += 4;

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
                    Tag2Print.add(".L" + branch.false_dest.substring(1));
                }

                else if (instruction instanceof IR_branch)
                {

                }

                else if (instruction instanceof IR_tag)
                {
                    NOW_FUNC_CODE.add(new RV_tag(".L" + ((IR_tag) instruction).target_label));
                }

                else if (instruction instanceof IR_getelementptr)
                {
                    //todo: search poly item's type

                }

                else if (instruction instanceof IR_ret) //todo: change support
                {
                    NOW_FUNC_CODE.add(new RV_ret());
                }
            }
        }

        StringBuilder rt_str = new StringBuilder();
        rt_str.append(functionContent.name).append(":").append("\n");
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
        return rt_str.toString();
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
        //这里把字符串输出搞定
        Output += GetCodeHeader(this.header);
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
