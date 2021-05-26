package bit.minisys.minicc.semantic;

public class SemanticErrorHandler
{
    public static void ES01(boolean isIdentifier, String Name)
    {
        if (isIdentifier)
        {
            System.out.println("ES01 >> Identifier: " + Name + " is not defined.\n");
        }
    }

    public static void ES02(boolean isIdentifier, String Name)
    {
        if (isIdentifier)
        {
            System.out.println("ES02 >> Declaration: " + Name + " has been declared.\n");
        }
    }

    public static void ES03()
    {
    }

    public static void ES04()
    {
    }

    public static void ES05()
    {
    }

    public static void ES06()
    {
    }

    public static void ES07()
    {
    }

    public static void ES08()
    {
    }
}
