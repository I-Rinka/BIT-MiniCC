package bit.minisys.minicc.ncgen.IRInfo;

import bit.minisys.minicc.ncgen.IRInstruction.IR_instruction;

import java.util.LinkedList;

public class FunctionContent
{
    public String name;
    public String ltype;
    LinkedList<IR_instruction> InsBuffer;
    public FunctionContent(String func_name,LinkedList<IR_instruction>InsBuffer)
    {
        this.name=func_name;
        this.InsBuffer=InsBuffer;
    }
}
