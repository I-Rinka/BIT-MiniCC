package bit.minisys.minicc.ncgen.ISA.RISCV.instructions;

public class RV_ret implements RV_instruction
{
    int frame_size;
    String return_reg;
    String return_str = "";

    public RV_ret(int frame_size, String return_reg)
    {
        this.return_reg=return_reg;
        this.frame_size = frame_size;
        return_str += "lw ra," + (frame_size - 4) + "(sp)\n";
        return_str += "lw ra," + (frame_size - 8) + "(sp)\n";
        return_str += "add a0,zero," + return_reg + "\n";
        return_str += "addi sp,sp" + frame_size + "\n";
        return_str += "ret\n";
    }

    public RV_ret(int frame_size)
    {
        this.frame_size = frame_size;
        return_str += "lw ra," + (frame_size - 4) + "(sp)\n";
        return_str += "lw ra," + (frame_size - 8) + "(sp)\n";
        return_str += "addi sp,sp" + frame_size + "\n";
        return_str += "ret\n";
    }

    public RV_ret()
    {
        return_str += "ret\n";
    }

    @Override
    public String toString()
    {
        return return_str;
    }
}
