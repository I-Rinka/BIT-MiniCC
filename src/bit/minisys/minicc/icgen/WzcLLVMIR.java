package bit.minisys.minicc.icgen;

import bit.minisys.minicc.internal.util.MiniCCUtil;
import bit.minisys.minicc.parser.CParser;
import bit.minisys.minicc.parser.WzcListenr;
import bit.minisys.minicc.parser.ast.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class WzcLLVMIR extends WzcListenr
{
    private final String OpenFile;
    public String target_data_layout = "e-m:e-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128";
    public String target_triple = "x86_64-pc-linux-gnu";

    private LinkedList<IRInstruction> InsBuffer; //存放一个函数中要输出的所有指令，函数节点退栈时输出。
    private final LinkedList<LinkedList<IRInstruction>> CompoundStatementBuffer;

    private final Stack<LinkedList<IRInstruction>> Segment;

    private final HashMap<String, String> OperatorMap;
    private final HashMap<String, String> TypeMap;

    private final Stack<HashMap<String, IdentifierSymbol>> SyTableStack;

    private int register_count = 0;

    @Override
    public void enterFunctionDefinition(CParser.FunctionDefinitionContext ctx)
    {
        //todo 注意基本块！是否进入函数后的一瞬间，或者是退出parameter的时候要把reg号增加一下
        this.register_count = 0;
        InsBuffer = new LinkedList<>();
        super.enterFunctionDefinition(ctx);
    }

    @Override
    public void exitDeclaration(CParser.DeclarationContext ctx)
    {
        //只对全局变量做操作
        //全局变量: SyTableStack的大小等于1
        if (SyTableStack.size() == 1)
        {
            ASTDeclaration thisNode = (ASTDeclaration) super.nodeStack.peek();
            String type = thisNode.specifiers.get(0).value.toString();

            //todo: 符号映射支持

            type = TypeMap.get(type);
            for (ASTInitList il : thisNode.initLists)
            {
                if (il.declarator instanceof ASTVariableDeclarator)
                {
                    String global_name = ((ASTVariableDeclarator) il.declarator).identifier.value.toString();
                    if (GetSymbolInfo(global_name) == null)
                    {
                        SyTableStack.peek().put(global_name, new IdentifierSymbol("@" + global_name, type));
                    }
                    //重复定义
                    else
                    {
                        SemanticError.ES02(true, global_name);
                    }
                    String num = "0";
                    if (il.exprs != null && il.exprs.size() >= 1)
                    {
                        if (il.exprs.get(0) instanceof ASTIntegerConstant)
                        {
                            num = ((ASTIntegerConstant) il.exprs.get(0)).value.toString();
                        }
                    }
                    WriteLine(new IRInstruction("@" + global_name, "global", type, num, null));
                }
            }
        }
        super.exitDeclaration(ctx);
    }

    private void HandleDeclaration(ASTDeclaration declaration)
    {
        //todo 添加long long和无符号数的支持
        String type = declaration.specifiers.get(0).value.toString();
        type = TypeMap.get(type);

        type = TypeMap.get(type);
        for (ASTInitList il : declaration.initLists)
        {
            if (il.declarator instanceof ASTVariableDeclarator)
            {
                int now_reg = GetRegCount();
                String var_name = ((ASTVariableDeclarator) il.declarator).identifier.value.toString();
                if (GetSymbolInfo(var_name) == null)
                {
                    SyTableStack.peek().put("%" + now_reg, new IdentifierSymbol("%" + now_reg, type));
                }
                //重复定义
                else
                {
                    SemanticError.ES02(true, var_name);
                }
                String num = "0";
                if (il.exprs != null && il.exprs.size() >= 1)
                {
                    if (il.exprs.get(0) instanceof ASTIntegerConstant)
                    {
                        num = ((ASTIntegerConstant) il.exprs.get(0)).value.toString();
                    }
                }
                InsBuffer.add(new IRInstruction("%" + now_reg, "alloca", type, null, null));
            }
        }
    }

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

        //新的符号表
        this.SyTableStack.push(new HashMap<>());

        //新的指令表
        LinkedList<IRInstruction> ins_segment = new LinkedList<>();

        //保存当前的指令栈
        Segment.push(this.InsBuffer);
        this.InsBuffer = ins_segment;

        super.enterCompoundStatement(ctx);
    }

    //declaration只用来声明全局变量！
    //把它变成正序遍历！

    //enter函数或者exitparam的时候必须增加一个regCount，主要是要看看即使param是空，它还会不会走

    @Override
    public void exitFunctionDefinition(CParser.FunctionDefinitionContext ctx)
    {
        ASTFunctionDefine thisNode = (ASTFunctionDefine) super.nodeStack.peek();
        super.exitFunctionDefinition(ctx);

        String func_out_header = "define ";

        //todo: longlong等类型的支持
        String func_rt_type = thisNode.specifiers.get(0).value.toString();
        func_rt_type = TypeMap.get(func_rt_type);

        func_out_header += func_rt_type;
        String func_name = "";
        ASTFunctionDeclarator ast_func_declarator = (ASTFunctionDeclarator) thisNode.declarator;

        if (ast_func_declarator.declarator instanceof ASTVariableDeclarator)
        {
            func_name += ((ASTVariableDeclarator) ast_func_declarator.declarator).identifier.value.toString();
        }
        //todo: 将函数声明放到全局符号表

        func_out_header += "@" + func_name + "(";

//        //注意，params中的东西应该从符号表中取,来自declaration
//        for (ASTParamsDeclarator params :
//                ast_func_declarator.params
//        )
//        {
////            String para_type=params.specfiers.get(0).value.toString();
//            //todo 不知道还有没有除了variableDeclarator之外的类型
//            String id_name = ((ASTVariableDeclarator) params.declarator).identifier.value.toString();
//            int reg = LocalSyTable.get(id_name).reg_num;
//            String para_type = LocalSyTable.get(id_name).i_type;
//
//            if (param_count != 0)
//            {
//                func_out_header += ", ";
//            }
//            func_out_header += para_type + " %" + reg;
//            param_count++;
//        }

        func_out_header += ") #0 {\n";//开始前的最后一句
        WriteLine(func_out_header);

        InsBuffer = CompoundStatementBuffer.pop();
        while (!InsBuffer.isEmpty())
        {
            WriteLine(InsBuffer.pop());
        }

        WriteLine(func_out_header);
    }

    @Override
    public void exitCompoundStatement(CParser.CompoundStatementContext ctx)
    {
        ASTCompoundStatement thisNode = (ASTCompoundStatement) nodeStack.peek();
        //收集信息
        // blocItems 可能的节点:
        // 1. 各种Statement
        // 2. 各种Declarations

        for (ASTNode blockItem :
                thisNode.blockItems)
        {
            //在这里进行判断操作
            if (blockItem instanceof ASTDeclaration)
            {
            }
            else if (blockItem instanceof ASTStatement)
            {
                if (blockItem instanceof ASTCompoundStatement)
                {
                    //从队列中取出insBuffer并合并
                    LinkedList<IRInstruction> child_compound = CompoundStatementBuffer.pop();
                    this.InsBuffer.addAll(child_compound);
                }
            }
        }
        //把自己这部分指令压入队列
        CompoundStatementBuffer.push(this.InsBuffer);
        this.InsBuffer = Segment.pop();//恢复到原来的段

        //收集信息后退栈，然后现在才在上一个地方留下自己的痕迹 //原则:只有退出时才向原来的地方写入 (真的能写入吗，要不就存到队列里? 不对，只有顶层引用了，才能向指令栈中写入
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
            String op = thisNode.op.value.toString();
            String type = "";
            String rt_reg = "%" + GetRegCount();

            switch (op)
            {
                case "=":
                    InsBuffer.add(new IRInstruction(null, "store", "i32", src2, "i32* " + src1));
                    register_count--;//并没有使用新的寄存器，因此--

                    return src2;
                case ">":
                    InsBuffer.add(new IRInstruction(rt_reg, "icmp", "sle i32", src1, src2));
                    break;
                case "<":
                    InsBuffer.add(new IRInstruction(rt_reg, "icmp", "sge i32", src1, src2));
                    break;
                case ">=":
                    InsBuffer.add(new IRInstruction(rt_reg, "icmp", "sl i32", src1, src2));
                    break;
                case "<=":
                    InsBuffer.add(new IRInstruction(rt_reg, "icmp", "sg i32", src1, src2));
                    break;
                case "==":
                    InsBuffer.add(new IRInstruction(rt_reg, "icmp", "eq i32", src1, src2));
                    break;
                case "!=":
                    InsBuffer.add(new IRInstruction(rt_reg, "icmp", "ne i32", src1, src2));
                    break;
                default:
                    op = OperatorMap.get(op);
                    // todo:添加类型检查
                    InsBuffer.add(new IRInstruction(rt_reg, op, type, src1, src2));
                    break;
            }

            return rt_reg;
        }
        //叶节点2: 变量
        else if (expression instanceof ASTIdentifier)

        {
            ASTIdentifier thisNode = (ASTIdentifier) expression;
            //未声明使用报错
            IdentifierSymbol detail = GetSymbolInfo(thisNode.value.toString());
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
                src = detail.addr;
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


    WzcLLVMIR(String oFileName) throws IOException
    {
        OpenFile = oFileName;
        this.SyTableStack = new Stack<>();
        this.SyTableStack.push(new HashMap<>());

        this.InsBuffer = new LinkedList<>();

        this.Segment = new Stack<>();
        this.CompoundStatementBuffer = new LinkedList<>();

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

        TypeMap = new HashMap<>();
        TypeMap.put("int", "i32");
        TypeMap.put("long", "i32");
        TypeMap.put("char", "i8");
        TypeMap.put("long long", "i64");
        TypeMap.put("cmp", "i1");
    }

    IdentifierSymbol GetSymbolInfo(String SymbolName)
    {
        for (int j = SyTableStack.size() - 1; j >= 0; j--)
        {
            //最好把这个东西的使用禁止掉
            HashMap<String, IdentifierSymbol> syTable = SyTableStack.get(j);
            if (syTable.containsKey(SymbolName))
            {
                return syTable.get(SymbolName);
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

    static void ES02(boolean isIdentifier, String Name)
    {
        if (isIdentifier)
        {
            System.out.println("ES02 >> Declaration: " + Name + " has been declared.\n");
        }
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
    public String addr;
    public String i_type;

    IdentifierSymbol(String addr, String i_type)
    {
        this.addr = addr;
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