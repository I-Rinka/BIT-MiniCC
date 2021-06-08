package bit.minisys.minicc.ncgen.RISCV;

import bit.minisys.minicc.ncgen.BasicBlockInfo.BasicBlock;
import bit.minisys.minicc.ncgen.BasicBlockInfo.FunctionContent;
import bit.minisys.minicc.ncgen.BasicBlockInfo.WzcIRScanner;
import bit.minisys.minicc.ncgen.IRInstruction.*;
import bit.minisys.minicc.ncgen.Util.JudgeConstant;
import bit.minisys.minicc.ncgen.WzcTargetMaker;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

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

    String GetReg() //得到寄存器的顺序：t系列，a系列，s系列
    {
        return "t" + TReg.poll();
    }

    String GetReg(String V_Reg) //注册到ReleaseReg队列里
    {
        String p_reg = GetReg();
        V2P_Reg_Map.put(V_Reg, p_reg);
        return p_reg;
    }

    void ReleaseReg(String reg)
    {
        if (reg.contains("t"))
        {
            TReg.add(Integer.parseInt(reg.substring(1)));
        }
        else if (reg.contains("a"))
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
        StringBuilder FUNC_CODE = new StringBuilder();
        FUNC_CODE.append("\n").append(functionContent.name).append(":").append("\n");
        this.TReg = new PriorityQueue<>();
        this.AReg = new PriorityQueue<>();
        this.SReg = new PriorityQueue<>();
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

        this.V2P_Reg_Map = new HashMap<>(); // 释放时，从中移除

        WzcIRScanner func_info = new WzcIRScanner(functionContent.GetFunctionInstruction());
        func_info.ScanInfo();

        //把所有alloca都映射了
        for (HashMap.Entry<String, Integer> met : func_info.GetAllocaMap().entrySet())
        {
            V2P_Reg_Map.put(met.getKey(), "-" + (met.getValue() + 2) * 4 + "(fp)");
        }
        for (String para : functionContent.used_param) // todo: 参数多于8的情况
        {
            V2P_Reg_Map.put(para, "a" + para.substring(1));
        }

        HashMap<String, String> LLVM2RVIns = new HashMap<>();
        LLVM2RVIns.put("load", "lw");
        LLVM2RVIns.put("store", "sw");
        LLVM2RVIns.put("add", "add");
        LLVM2RVIns.put("sub", "sub");
        //反着来
        LLVM2RVIns.put("slt", "bge");
        LLVM2RVIns.put("sle", "bgt");
        LLVM2RVIns.put("sgt", "ble");
        LLVM2RVIns.put("sge", "blt");

        LLVM2RVIns.put("sdiv", "div");
        LLVM2RVIns.put("mul", "mul");


        //开始真正遍历基本块，
        for (BasicBlock block : func_info.GetBasicBlocks())
        {
            if (block.GetRegReleaseInfo()==null) //这个块不可达 todo: 添加不可达块的支持！
            {
                continue;
            }
            for (int i = 0; i < block.DAGS.size(); i++)
            {
                LinkedList<String> remove_v_reg = new LinkedList<>();
                IR_instruction instruction = block.DAGS.get(i);

                for (HashMap.Entry<String, String> reg_map : V2P_Reg_Map.entrySet())
                {
                    Integer life = block.GetRegReleaseInfo().get(reg_map.getKey());
                    if (life != null)
                    {
                        //查看是否可以删除
                        if (life >= i)
                        {
                            ReleaseReg(reg_map.getValue());//释放物理寄存器。哈希表的释放要在结束后再开始
                            remove_v_reg.add(reg_map.getKey());
                        }
                    }
                }

                if (instruction instanceof IR_op)
                {
                    V2P_Reg_Map.put(((IR_op) instruction).dest, GetReg(((IR_op) instruction).dest));
                    if (!JudgeConstant.isNumeric(((IR_op) instruction).src2) && !JudgeConstant.isNumeric(((IR_op) instruction).src1))
                    {
                        FUNC_CODE.append(LLVM2RVIns.get(((IR_op) instruction).op)).append(" ").append(V2P_Reg_Map.get(((IR_op) instruction).dest));
                        FUNC_CODE.append(",").append(V2P_Reg_Map.get(((IR_op) instruction).src1)).append(",").append(V2P_Reg_Map.get(((IR_op) instruction).src2)).append("\n");
                    }
                    else
                    {
                        String instant = ((IR_op) instruction).src2;
                        if (((IR_op) instruction).op.equals("sub"))
                        {
                            if (instant.contains("-"))
                            {
                                instant = instant.substring(1);
                            }
                            else
                            {
                                instant = "-" + instant;
                            }
                        }
                        FUNC_CODE.append("addi").append(" ").append(V2P_Reg_Map.get(((IR_op) instruction).dest));
                        FUNC_CODE.append(",").append(V2P_Reg_Map.get(((IR_op) instruction).src1)).append(",").append(instant).append("\n");
                    }
                }
                else if (instruction instanceof IR_getelementptr)
                {
                    //先支持一维数组
                    String reg = ((IR_getelementptr) instruction).offset;
                }
                else if (instruction instanceof IR_call)
                {
                    //破坏性操作
                    //mov 操作
                    if (((IR_call) instruction).dest != null)
                    {
                        String dest_reg = GetReg(((IR_call) instruction).dest);
                        FUNC_CODE.append(dest_reg).append(dest_reg).append("\n");
                    }
                }
                else if (instruction instanceof IR_compare)
                {
                    //跳过一个指令
                    i++;
                    IR_branch branch = (IR_branch) block.DAGS.get(i);
                    FUNC_CODE.append(LLVM2RVIns.get(((IR_compare) instruction).op)).append(" ").append(V2P_Reg_Map.get(((IR_compare) instruction).src1)).append(",").append(V2P_Reg_Map.get(((IR_compare) instruction).src2));
                    FUNC_CODE.append(",").append(".L").append(branch.false_dest.substring(1)).append("\n");
                }
                else if (instruction instanceof IR_branch)
                {
                    if (!((IR_branch) instruction).is_conditional)
                    {
                        FUNC_CODE.append("jal x0,").append(".L").append(((IR_branch) instruction).dest.substring(1)).append("\n");
                    }
                }
                else if (instruction instanceof IR_tag)
                {
                    FUNC_CODE.append(".L").append(((IR_tag) instruction).toString()).append("\n");
                }
                else if (instruction instanceof IR_store)
                {
                    String store_src = null;
                    if (JudgeConstant.isNumeric(((IR_store) instruction).src))
                    {
                        String tmp = GetReg();
                        ReleaseReg(tmp);
                        FUNC_CODE.append("li ").append(tmp).append(",").append(Integer.parseInt(((IR_store) instruction).src)).append("\n");
                        store_src = tmp;
                    }
                    else
                    {
                        store_src = V2P_Reg_Map.get(((IR_store) instruction).src);
                    }
                    FUNC_CODE.append(LLVM2RVIns.get("store")).append(" ").append(store_src).append(",").append(V2P_Reg_Map.get(((IR_store) instruction).dest)).append("\n");
                }
                else if (instruction instanceof IR_ret)
                {
                    if (functionContent.name.equals("main"))
                    {
                        FUNC_CODE.append("li a7,10").append("\n");
                        FUNC_CODE.append("ecall").append("\n");
                    }
                    else
                    {
                        //提升栈帧
                        //mov结果
                        FUNC_CODE.append("提升栈帧");
                        FUNC_CODE.append("ret");
                    }
                }
                for (String rm_v_reg :
                        remove_v_reg)
                {
                    V2P_Reg_Map.remove(rm_v_reg);
                }
            }
        }


        return FUNC_CODE.toString();
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

    @Override
    public String GetTargetCode()
    {
        //这里把字符串输出搞定

        //在这里应该加上一个返回的GetCodeHeader
        for (String func_code :
                FuncRVCode)
        {
            Output += func_code;
        }

        return Output;
        //这里还要把库函数的函数体写上去
    }
}
