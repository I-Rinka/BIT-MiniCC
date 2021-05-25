package bit.minisys.minicc.icgen;

import bit.minisys.minicc.internal.util.MiniCCUtil;
import bit.minisys.minicc.parser.CParser;
import bit.minisys.minicc.parser.WzcListenr;
import bit.minisys.minicc.parser.ast.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

public class WzcLLVMIR extends WzcListenr
{
    private String OpenFile;
    public String target_data_layout = "e-m:e-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128";
    public String target_triple = "x86_64-pc-linux-gnu";

    private LinkedList<IRInstruction> InsBuffer; //存放一个函数中要输出的所有指令，函数节点退栈时输出。
    private HashMap<String, IdentifierSymbol> LocalSyTable;
    private HashMap<String, IdentifierSymbol> GlobalSyTable;


    private int register_count = 0;
    //如何表示符号表？使用栈？ 变量符号表：1.全局变量 2.函数变量   变量需要记录的：1.符号名 2.符号地址（虚拟寄存器）

    //Function会进入declaration list,这个东西有且仅有函数声明有; 然后不带block的function list在functionDeclarator中。本次实验先不管这种情况，默认所有的function都有block
    //进入Function definition的时候要不要先推入个东西？退出Function definition的时候信息都收集好了。Specifiers对应了
    //进入的时候队列加入一个define（作为action） null（action type） null（src1，全部的剩余信息   ）


    @Override
    public void enterFunctionDefinition(CParser.FunctionDefinitionContext ctx)
    {
        //todo 注意基本块！是否进入函数后的一瞬间，或者是退出parameter的时候要把reg号增加一下
        this.register_count = 0;
        InsBuffer = new LinkedList<>();
        LocalSyTable = new HashMap<>();//用个object的多态，理论上应该可以支持多种符号表
        super.enterFunctionDefinition(ctx);
    }

    /*
        需要更新符号表的（更新前查找是否有重复定义）：
            +

        需要查找符号表的（查找对应的哈希表，看变量是否存在）：
            +
    */

    @Override
    public void exitDeclaration(CParser.DeclarationContext ctx)
    {
        //todo 1.注意查重复定义,
        //     2.注意在全局变量的scope施工✔
        //     3.block中的局部变量应该如何支持（push指定的数目后，再清除？）
        ASTDeclaration thisNode = (ASTDeclaration) super.nodeStack.peek();
        super.exitDeclaration(ctx);//现在才收集完?

        HashMap<String, IdentifierSymbol> thisTable = null;

        //看是全局变量还是临时变量
        if (LocalSyTable == null)
        {
            thisTable = GlobalSyTable;
        }
        else
        {
            thisTable = LocalSyTable;
        }

        String type = thisNode.specifiers.get(0).value.toString();//int 之类的

        //todo 整一个拓展性好的类型映射表，不然太捞了
        if (type.equals("int"))
        {
            type = "i32";
        }

        for (ASTInitList il :
                thisNode.initLists)
        {
            if (il.declarator instanceof ASTVariableDeclarator)
            {
                // 全局变量的初始化要放在另外的地方
                if (LocalSyTable != null)
                {
                    int now_reg = GetRegCount();
                    //新增一个变量的流程 todo Hashmap查重复变量
                    thisTable.put(((ASTVariableDeclarator) il.declarator).identifier.value.toString(), new IdentifierSymbol(now_reg, type));
                    InsBuffer.add(new IRInstruction("%" + now_reg, "alloca", type, null, null));
                }
            }
        }

    }

    @Override
    public void exitParameterDeclaration(CParser.ParameterDeclarationContext ctx)
    {
        ASTParamsDeclarator thisNode = (ASTParamsDeclarator) super.nodeStack.peek();
        super.exitParameterDeclaration(ctx);

        String type = thisNode.specfiers.get(0).value.toString();//int 之类的
        if (type.equals("int"))
        {
            type = "i32";
        }

        if (thisNode.declarator instanceof ASTVariableDeclarator)
        {
            // 全局变量的初始化要放在另外的地方
            if (LocalSyTable != null)
            {
                int now_reg = GetRegCount();
                //新增一个变量的流程 todo Hashmap查重复变量
                LocalSyTable.put(((ASTVariableDeclarator) thisNode.declarator).identifier.value.toString(), new IdentifierSymbol(now_reg, type));
                //参数不输出
                //InsBuffer.add(new IRInstruction("%" + now_reg, "alloca", type, null, null));
            }
        }

        //从这里算是函数的基本块，所以让reg自增1试试
    }

    @Override
    public void exitFunctionDefinition(CParser.FunctionDefinitionContext ctx)
    {
        ASTFunctionDefine thisNode = (ASTFunctionDefine) super.nodeStack.peek(); //维护下本节点的值
        super.exitFunctionDefinition(ctx);

        String func_out_header = "define ";

        //从本节点取出关键信息

        // 先只支持取一个specifier
        String func_rt_type = thisNode.specifiers.get(0).value.toString();

        if (func_rt_type.equals("int"))
        {
            func_rt_type = "i32";
        }

        func_out_header += func_rt_type;


        String func_name = " @";

        ASTFunctionDeclarator ast_func_declarator = (ASTFunctionDeclarator) thisNode.declarator;

        if (ast_func_declarator.declarator instanceof ASTVariableDeclarator)
        {
            func_name += ((ASTVariableDeclarator) ast_func_declarator.declarator).identifier.value.toString();
        }


        func_out_header += func_name + "(";

        int param_count = 0;

        //todo 从FunctionDeclarator 取值
        //注意，params中的东西应该从符号表中取,来自declaration
        for (ASTParamsDeclarator params :
                ast_func_declarator.params
        )
        {
//            String para_type=params.specfiers.get(0).value.toString();
            //todo 不知道还有没有除了variableDeclarator之外的类型
            String id_name = ((ASTVariableDeclarator) params.declarator).identifier.value.toString();
            int reg = LocalSyTable.get(id_name).reg_num;
            String para_type = LocalSyTable.get(id_name).i_type;

            if (param_count != 0)
            {
                func_out_header += ", ";
            }
            func_out_header += para_type + " %" + reg;
            param_count++;
        }

        func_out_header += ") #0 {\n";//开始前的最后一句

        WriteLine(func_out_header);

        //这里要不加个label表示函数起来了，这样就不用额外的搞个基本块
        WriteLine(func_name.substring(2)+"_start:\n");

        //打印所有中间语句
        while (!InsBuffer.isEmpty())
        {
            WriteLine("  "+InsBuffer.pop());//顺便搞个缩进
        }


        //todo 增加return语句是否添加检查
        // 一般return是从哪个默认寄存器读值？
        WriteLine("  ret "+func_rt_type);
        if (!func_rt_type.equals("void"))
        {
            WriteLine(" "+0+"\n");
        }

        WriteLine("}\n\n");//输出一个函数的结尾

        LocalSyTable = null;//清零后，后续出现的所有值都是不在老变量表中了。仅存的符号表其实只有全局的了
    }

    //返回目前的值，并让其自增1
    int GetRegCount()
    {
        int t = this.register_count;
        register_count++;
        return t;
    }

    void WriteIRHeader()
    {
        String cFile = MiniCCUtil.removeAllExt(OpenFile) + ".c";
        String header = "source_filename = " + "\"" + cFile + "\"\n" +
                "target datalayout = \"" + target_data_layout + "\"\n" +
                "target triple = \"" + target_triple + "\"\n";

        FileOutputStream fileOutputStream = null;
        try
        {
            fileOutputStream = new FileOutputStream(OpenFile, false);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        try
        {
            fileOutputStream.write(header.getBytes());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        try
        {
            fileOutputStream.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    WzcLLVMIR(String oFileName) throws IOException
    {
        OpenFile = oFileName;
        this.GlobalSyTable = new HashMap<>();
        WriteIRHeader();
    }

    private void WriteLine(Object obj)
    {
        this.WriteLine(obj.toString());
    }

    private void WriteLine(String OutputStr)
    {
        FileOutputStream fileOutputStream = null;
        try
        {
            fileOutputStream = new FileOutputStream(OpenFile, true);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        try
        {
            fileOutputStream.write(OutputStr.getBytes());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        try
        {
            fileOutputStream.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}

//这个东西得不停改
class IdentifierSymbol
{
    public int reg_num;
    public String i_type;

    IdentifierSymbol(int reg_num, String i_type)
    {
        this.reg_num = reg_num;
        this.i_type = i_type;
    }
}

class IRInstruction
{
    public String dest_var = null;

    public String action = null;
    public String action_type = null;

    public String src_var1 = null;
    public String src_var2 = null;

    IRInstruction(String dest, String instruction, String instruction_type, String src1, String src2)
    {
        this.dest_var = dest;
        this.action = instruction;
        this.action_type = instruction_type;
        this.src_var1 = src1;
        this.src_var2 = src2;
    }

    @Override
    public String toString()
    {
        String Out = "";
        if (dest_var != null)
        {
            Out = dest_var + " = ";
        }
        Out = Out + action + " " + action_type;
        if (src_var1 != null)
        {
            Out = Out + " " + src_var1;
        }
        if (src_var2 != null)
        {
            Out = Out + ", " + src_var2;
        }
        return Out + "\n";
    }
}