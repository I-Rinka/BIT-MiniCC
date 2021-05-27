package bit.minisys.minicc.semantic;

public class SemanticErrorHandler
{
    public static void ES01(boolean isIdentifier, String Name)
    {
        if (isIdentifier)
        {
            System.out.println("ES01 >> Identifier: " + Name + " is not defined.\n");
        }
        else
        {
            System.out.println("ES01 >> Function: " + Name + " is not defined.\n");
        }
    }

    public static void ES02(boolean isIdentifier, String Name)
    {
        if (isIdentifier)
        {
            System.out.println("ES02 >> Declaration: " + Name + " has been declared.\n");
        }
        else
        {
            System.out.println("ES02 >> Function: " + Name + " has been declared.\n");
        }
    }

    public static void ES03()
    {
        System.out.println("ES3 >> BreakStatement: must be in a LoopStatement.\n");
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

    public static void ES08(String func_name)
    {
        System.out.println("ES08 >> Function: " + func_name + " must have a return in the end.\n");
    }
}
