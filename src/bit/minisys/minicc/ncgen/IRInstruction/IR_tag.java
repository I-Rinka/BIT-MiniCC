package bit.minisys.minicc.ncgen.IRInstruction;

public class IR_tag implements IR_instruction
{
    String dest;

    public IR_tag(String dest_origin)
    {
        this.dest = dest_origin;
    }

    @Override
    public String toString()
    {
        return dest + ":";
    }
}
