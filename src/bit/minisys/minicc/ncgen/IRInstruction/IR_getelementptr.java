package bit.minisys.minicc.ncgen.IRInstruction;

import bit.minisys.minicc.ncgen.Symbol.Sy_PolyItem;

public class IR_getelementptr implements IR_instruction
{
    Sy_PolyItem get_ptr_sentence;
    public int offset;
    String base;
    String dest;

    public IR_getelementptr(String dest, String base, int offset, Sy_PolyItem polyItem)
    {
        this.get_ptr_sentence = polyItem;
        this.base = base;
        this.dest = dest;
        this.offset = offset;
    }

    @Override
    public String toString()
    {
        return dest + " = " + get_ptr_sentence.GetElementPrt(offset);
    }
}
