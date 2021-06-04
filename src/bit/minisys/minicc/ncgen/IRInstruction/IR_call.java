package bit.minisys.minicc.ncgen.IRInstruction;

public class IR_call implements IR_instruction
{
    String dest;
    String type;
    String func_name;
    String para_list = null;

    public IR_call(String dest, String ltype, String func_name, String para_list)
    {
        this.dest = dest;
        this.type = ltype;
        this.func_name = func_name;
        this.para_list = para_list;
    }

    @Override
    public String toString()
    {
        String rt_str = "";
        if (dest != null)
        {
            rt_str += dest + " = ";
        }
        rt_str += "call" + " " + type + " " + func_name + "(";
        if (para_list != null)
        {
            rt_str += para_list;
        }
        rt_str += ")";
        return rt_str;
    }
}
