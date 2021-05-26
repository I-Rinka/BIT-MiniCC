package bit.minisys.minicc.icgen;

import bit.minisys.minicc.internal.util.MiniCCUtil;
import bit.minisys.minicc.parser.CParser;
import bit.minisys.minicc.parser.WzcListenr;
import bit.minisys.minicc.parser.ast.*;
import org.python.util.InteractiveConsole;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Stack;

public class WzcLLVMIR extends WzcListenr
{
    private String OpenFile;
    public String target_data_layout = "e-m:e-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128";
    public String target_triple = "x86_64-pc-linux-gnu";

    private LinkedList<IRInstruction> InsBuffer; //存放一个函数中要输出的所有指令，函数节点退栈时输出。
    private Stack<LinkedList<IRInstruction>> InsBufferStack;
    private HashMap<String, String> OperatorMap;

    private HashMap<String, IdentifierSymbol> SyTable;
    private Stack<HashMap<String, IdentifierSymbol>> SyTableStack;

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
//        LocalSyTable = new HashMap<>();//用个object的多态，理论上应该可以支持多种符号表
        super.enterFunctionDefinition(ctx);
    }

    /*
        需要更新符号表的（更新前查找是否有重复定义）：
            +

        需要查找符号表的（查找对应的哈希表，看变量是否存在）：
            +
    */
/*
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

                    if (il.exprs.size() > 0)
                    {
                        if (il.exprs.get(0) instanceof ASTIntegerConstant)
                        {
                            InsBuffer.add(new IRInstruction(null, "store", "i32", ((ASTIntegerConstant) il.exprs.get(0)).value.toString(), "i32* " + "%" + now_reg));
                        }
                        else
                        {
                            String expression_reg = InsBuffer.get(InsBuffer.size() - 2).dest_var;
                            InsBuffer.add(new IRInstruction(null, "store", "i32", expression_reg, "i32* " + "%" + now_reg));
                        }
                    }
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

*/
    @Override
    public void enterSelectionStatement(CParser.SelectionStatementContext ctx)
    {
        super.enterSelectionStatement(ctx);
    }

    @Override
    public void exitSelectionStatement(CParser.SelectionStatementContext ctx)
    {
        super.exitSelectionStatement(ctx);
    }

    @Override
    public void enterCompoundStatement(CParser.CompoundStatementContext ctx)
    {
        //compoundStatement有个特点就是后进先出，因此可能需要用一个栈来对其数据收集进行保存，而且这个是宏观的
        //1. 新的符号表
        //2. 新的指令表 todo: 顶层节点，即function的那个compound里面增加一个指令栈，直接在最底层那里

        this.SyTableStack.push(new HashMap<>());

        //新的指令表
        LinkedList<IRInstruction> ins_segment = new LinkedList<>();

        InsBufferStack.push(ins_segment);
        this.InsBuffer = ins_segment;

        super.enterCompoundStatement(ctx);
    }

    @Override
    public void exitCompoundStatement(CParser.CompoundStatementContext ctx)
    {
        //收集信息? iter和另外几个也要收集信息
        //todo:先不要把自己push！
        //收集信息后退栈，然后现在才在上一个地方留下自己的痕迹 //原则:只有退出时才向原来的地方写入
        this.InsBuffer = InsBufferStack.pop();
        IRInstruction n_IRBuffer = new IRInstruction(null, null, null, null, null);
        this.InsBuffer.push(n_IRBuffer);
        n_IRBuffer.insBufferPointer = this.InsBuffer;
        this.InsBuffer = InsBufferStack.peek();

        SyTableStack.pop();
        super.exitCompoundStatement(ctx);
    }

    public String TraverseExpression(ASTExpression expression) //递归调用
    {
        //叶节点1: 整形
        if (expression instanceof ASTIntegerConstant || expression instanceof ASTStringConstant || expression instanceof ASTCharConstant || expression instanceof ASTFloatConstant)
        {
            return null;
        }
        else if (expression instanceof ASTBinaryExpression)
        {
            ASTBinaryExpression thisNode = (ASTBinaryExpression) expression;
            String src1 = TraverseExpression(thisNode.expr1);
            //先全考虑整型
            if (src1 == null) //constant todo 添加constant判断，先假定所有的都是i32
            {
                src1 = ((ASTIntegerConstant) thisNode.expr1).value.toString();
            }
            String src2 = TraverseExpression(thisNode.expr2);
            if (src2 == null) //constant
            {
                src2 = ((ASTIntegerConstant) thisNode.expr2).value.toString();
            }

            //操作符判断
            String op = "";
            String type = "";

            String rt_reg = "%" + GetRegCount();
            InsBuffer.add(new IRInstruction(rt_reg, op, type, src1, src2));
            return rt_reg;
        }
        //叶节点2: 变量
        else if (expression instanceof ASTIdentifier)
        {
            ASTIdentifier thisNode = (ASTIdentifier) expression;
            //未声明使用报错
            IdentifierSymbol detail = GetSymbolDetail(thisNode.value.toString());
            String src = "";
            String type = "";
            if (detail == null) //未出现，进行报错
            {
                SemanticError.ES01(true, thisNode.value.toString());
                String new_reg = "%" + GetRegCount();

                InsBuffer.add(new IRInstruction(new_reg, "add", "i32", "0", "0"));
                return new_reg;//todo 把这里临时alloca出一个来
            }
            else
            {
                src = "%" + detail.reg_num;
                //todo: 写个C语言到llvm的类型映射
                if (detail.i_type.equals("int"))
                {
                    type = "i32";
                }
                String new_reg = "%" + GetRegCount();
                InsBuffer.add(new IRInstruction(new_reg, "load", type, null, type + "* " + src));
                return new_reg;
            }

        }
        //todo 添加其他操作类型的支持

        return "none";
    }

    /*
        @Override
        public void exitExpressionNode()
        {
            ASTExpression thisNode = (ASTExpression) super.nodeStack.peek();
            super.exitExpressionNode();


            if (thisNode instanceof ASTBinaryExpression)
            {
                String src1 = null;
                String src2 = null;
                String op = ((ASTBinaryExpression) thisNode).op.value.toString();


                int last = InsBuffer.size() - 1;

                if (((ASTBinaryExpression) thisNode).expr1 instanceof ASTIntegerConstant)
                {
                    src1 = ((ASTIntegerConstant) ((ASTBinaryExpression) thisNode).expr1).value.toString();
                }
                else if (((ASTBinaryExpression) thisNode).expr1 instanceof ASTIdentifier)
                {
                    ASTIdentifier id = (ASTIdentifier) ((ASTBinaryExpression) thisNode).expr1;
                    if (op.equals("="))
                    {
                        src1 = id.value.toString();
                    }
                    else
                    {
                        //找表，加载地址 这里有访问已知变量操作！！！！
                        int sr1_addr = LocalSyTable.get(id.value.toString()).reg_num;
                        int new_reg = GetRegCount();
                        InsBuffer.add(new IRInstruction("%" + new_reg, "load", "i32", null, "i32* " + "%" + sr1_addr));

                        src1 = "%" + new_reg;
                        //这个指令也相当于从上一条指令中取值T，因此也要--
                        //last--;
                    }
                }
                else
                {
                    //从上一条指令取值，栈顶要--
                    src1 = InsBuffer.get(last).dest_var;
                    last--;
                }
                if (((ASTBinaryExpression) thisNode).expr2 instanceof ASTIntegerConstant)
                {
                    src2 = ((ASTIntegerConstant) ((ASTBinaryExpression) thisNode).expr2).value.toString();
                }
                else if (((ASTBinaryExpression) thisNode).expr2 instanceof ASTIdentifier)
                {
                    ASTIdentifier id = (ASTIdentifier) ((ASTBinaryExpression) thisNode).expr2;
                    //找表，加载地址 这里有访问已知变量操作！！！！
                    // todo: 写一个访问变量的判断
                    int sr2_addr = LocalSyTable.get(id.value.toString()).reg_num;
                    int new_reg = GetRegCount();
                    InsBuffer.add(new IRInstruction("%" + new_reg, "load", "i32", null, "i32* " + "%" + sr2_addr));

                    src2 = "%" + new_reg;
                }
                else
                {
                    src2 = InsBuffer.get(last).dest_var;
                }


                if (op.equals("="))
                {
                    InsBuffer.add(new IRInstruction(null, "store", "i32", src2, "i32* " + "%" + LocalSyTable.get(src1).reg_num));
                }
                else if (op.equals(">"))
                {
                    String cmp_reg = "%" + GetRegCount();
                    InsBuffer.add(new IRInstruction(cmp_reg, "icmp", "sle i32", src1, src2));
                }
                else if (op.equals("<"))
                {
                    String cmp_reg = "%" + GetRegCount();
                    InsBuffer.add(new IRInstruction(cmp_reg, "icmp", "sge i32", src1, src2));
                }
                else if (op.equals(">="))
                {
                    String cmp_reg = "%" + GetRegCount();
                    InsBuffer.add(new IRInstruction(cmp_reg, "icmp", "sl i32", src1, src2));
                }
                else if (op.equals("<="))
                {
                    String cmp_reg = "%" + GetRegCount();
                    InsBuffer.add(new IRInstruction(cmp_reg, "icmp", "sg i32", src1, src2));
                }
                else if (op.equals("=="))
                {
                    String cmp_reg = "%" + GetRegCount();
                    InsBuffer.add(new IRInstruction(cmp_reg, "icmp", "eq i32", src1, src2));
                }
                else if (op.equals("!="))
                {
                    String cmp_reg = "%" + GetRegCount();
                    InsBuffer.add(new IRInstruction(cmp_reg, "icmp", "ne i32", src1, src2));
                }
                else
                {
                    op = OperatorMap.get(op);
                    // todo:添加类型检查
                    InsBuffer.add(new IRInstruction("%" + GetRegCount(), op, "i32", src1, src2));
                }

            }

        }
    */
    /*
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
        WriteLine(func_name.substring(2) + "_start:\n");

        //打印所有中间语句
        while (!InsBuffer.isEmpty())
        {
            WriteLine("  " + InsBuffer.pop());//顺便搞个缩进
        }


        //todo 增加return语句是否添加检查
        // 一般return是从哪个默认寄存器读值？
        WriteLine("  ret " + func_rt_type);
        if (!func_rt_type.equals("void"))
        {
            WriteLine(" " + 0 + "\n");
        }

        WriteLine("}\n\n");//输出一个函数的结尾

        LocalSyTable = null;//清零后，后续出现的所有值都是不在老变量表中了。仅存的符号表其实只有全局的了
    }*/


    WzcLLVMIR(String oFileName) throws IOException
    {
        OpenFile = oFileName;
        this.SyTableStack = new Stack<>();
        this.SyTableStack.push(new HashMap<>());

        this.InsBuffer = new LinkedList<>();
        this.InsBufferStack.push(this.InsBuffer);

        WriteIRHeader();

        OperatorMap = new HashMap<>();
        //构造运算符的映射
        OperatorMap.put("+", "add");
        OperatorMap.put("-", "sub" +
                "");
        OperatorMap.put("*", "mul");
        OperatorMap.put("/", "sdiv");
        OperatorMap.put("<<", "shl");
        OperatorMap.put("%", "srem");

    }

    IdentifierSymbol GetSymbolDetail(String SymbolName)
    {
        for (int j = SyTableStack.size() - 1; j >= 0; j--)
        {
            SyTable = SyTableStack.get(j);
            if (SyTable.containsKey(SymbolName))
            {
                return SyTable.get(SymbolName);
            }
        }
        return null;//没有找到符号
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

class SemanticError
{
    static void ES01(boolean isIdentifier, String Name)
    {
        if (isIdentifier)
        {
            System.out.println("ES01 >> Identifier: " + Name + " is not defined.\n");
        }
    }

    static void ES02()
    {
    }

    static void ES03()
    {
    }

    static void ES04()
    {
    }

    static void ES05()
    {
    }

    static void ES06()
    {
    }

    static void ES07()
    {
    }

    static void ES08()
    {
    }
}

//这个东西得不停迭代想新的方法
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

    public LinkedList<IRInstruction> insBufferPointer = null;

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