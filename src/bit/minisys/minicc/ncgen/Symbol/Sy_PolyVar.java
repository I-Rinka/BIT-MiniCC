package bit.minisys.minicc.ncgen.Symbol;

import bit.minisys.minicc.semantic.SemanticErrorHandler;

public class Sy_PolyVar implements Sy_Item
{
    Sy_Item inside_Item;
    int item_count = 0;
    public int self_index = 0;
    String name;
    String reg_addr;

    public Sy_PolyVar(String name, String reg_addr, Sy_Item inside_Item, int repeat_count)
    {
        this.name = name;
        this.inside_Item = inside_Item;
        this.item_count = repeat_count;
        this.reg_addr = reg_addr;
    }

    public String GetElementPrt(int index)
    {
        String rt_str = "getelementptr";
        rt_str += " " + GetLType() + ", " + GetLType() + "*" + " " + reg_addr + ", i32 " + self_index + ", i32" + index;
        if (index > item_count)
        {
            SemanticErrorHandler.ES06();
        }
        return rt_str;
    }

    public Sy_Item GetInsideItem()
    {
        return inside_Item;
    }

    @Override
    public String GetName()
    {
        return name;
    }

    @Override
    public String GetLType()
    {
        return "[" + item_count + " x " + inside_Item.GetLType() + "]";
    }
}
