package bit.minisys.minicc.ncgen.Symbol;

public class Sy_Str implements Sy_Item
{
    String name;
    String content;
    int char_count;

    public Sy_Str(int nameless_count, String str_content)
    {
        char_count = str_content.length();
        name = ".str." + nameless_count;
        content = str_content;
    }

    public String GetAddr()
    {
        String type = "[" + char_count + " x " + "i8" + "]";
        return "getelementptr" + "(" + type + ", " + type + "* " + "@" + name + ", " + "i32 0, i32 0" + ")";
    }

    @Override
    public String GetName()
    {
        return name;
    }

    @Override
    public String GetLType()
    {
        return "i8*";
    }
}
