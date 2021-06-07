package bit.minisys.minicc.ncgen.IRInstruction;

import bit.minisys.minicc.ncgen.Symbol.Sy_Str;

public class IR_gobal_strdec implements IR_instruction
{
    Sy_Str str;

    public IR_gobal_strdec(Sy_Str str)
    {
        this.str = str;
    }

    @Override
    public String toString()
    {
        return "@" + str.GetName() + " = " + str.GetLType() + " " + "\"" + str.content + "\"";
    }

    int GetLen()
    {
        return str.content.length();
    }

    String GetName()
    {
        return str.GetName();
    }

    String GetContent()
    {
        return "\"" + str + "\"";
    }
}
