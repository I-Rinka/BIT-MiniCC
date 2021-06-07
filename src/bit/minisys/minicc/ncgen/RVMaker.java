package bit.minisys.minicc.ncgen;

import bit.minisys.minicc.ncgen.BasicBlockInfo.FunctionContent;
import bit.minisys.minicc.ncgen.IRInstruction.IR_instruction;

import java.util.LinkedList;

public class RVMaker implements WzcTargetMaker
{
    LinkedList<FunctionContent> Functions;

    public RVMaker(LinkedList<FunctionContent> Functions, LinkedList<IR_instruction> dec)
    {
        this.Functions = Functions;
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
        //在这里应该加上一个返回的GetCodeHeader
        return Functions.getLast().GetFunctionIRString();

        //这里还要把库函数的函数体写上去
    }
}
