package bit.minisys.minicc.ncgen.BasicBlockInfo;

import bit.minisys.minicc.ncgen.IRInstruction.IR_branch;
import bit.minisys.minicc.ncgen.IRInstruction.IR_instruction;
import bit.minisys.minicc.semantic.SemanticErrorHandler;

import java.util.LinkedList;

public class FunctionContent
{
    public String name;
    public String ltype;
    public String head_str;
    LinkedList<IR_instruction> InsBuffer;
    LinkedList<String> used_param;

    public FunctionContent(String func_name, LinkedList<IR_instruction> InsBuffer, LinkedList<String> used_param)
    {
        this.name = func_name;
        this.InsBuffer = InsBuffer;
        this.used_param = used_param;
    }

    public String GetFunctionIRString()
    {
        String out_str = head_str;
        //输出符号
        for (IR_instruction instruction :
                InsBuffer)
        {
            out_str += "  " + instruction.toString() + "\n";
        }
        return out_str + "}\n";
    }

    public LinkedList<IR_instruction> GetFunctionInstruction()
    {
        return InsBuffer;
    }
}
