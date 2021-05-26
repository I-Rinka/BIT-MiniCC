package bit.minisys.minicc.icgen;

import bit.minisys.minicc.parser.ast.*;
import bit.minisys.minicc.semantic.SemanticErrorHandler;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class WzcLLVMIR
{
    public String target_data_layout = "e-m:e-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128";
    public String target_triple = "x86_64-pc-linux-gnu";
    String global_declaration="";
    String IR_code = "";
    ASTCompilationUnit ASTRoot = null;
    String now_function_type_C = null;

    //为了有scope的支持，需要使用栈
    private Stack<HashMap<String, IdentifierSymbol>> SymbolTableStack;
    private LinkedList<IRInstruction> InsBuffer;
    private HashMap<String, String> OperatorMap;

    private int register_count = 0;


    void Run()
    {
        for (ASTNode item : ASTRoot.items)
        {
            if (item instanceof ASTDeclaration)
            {
                GlobalDeclarationHandler((ASTDeclaration) item);
            }
            else if (item instanceof ASTFunctionDefine)
            {
                FunctionDefineHandler((ASTFunctionDefine) item);
            }
        }
    }

    void FunctionDefineHandler(ASTFunctionDefine functionDefine)
    {
        SymbolTableStack.push(new HashMap<>());
        InsBuffer = new LinkedList<>();

        String func_out_header = "define ";
        now_function_type_C = TypeSpecifierListHandler(functionDefine.specifiers);

        func_out_header += ConvertCType2LLVMIR(now_function_type_C);

        String func_name = "";
        ASTFunctionDeclarator ast_func_declarator = (ASTFunctionDeclarator) functionDefine.declarator;

        if (ast_func_declarator.declarator instanceof ASTVariableDeclarator)
        {
            func_name += ((ASTVariableDeclarator) ast_func_declarator.declarator).identifier.value.toString();
        }

        func_out_header += " @" + func_name + "(";

        //todo: params

        func_out_header += ") #0 {\n";
        GetRegCount();

        IR_code += func_out_header;

        //退出
        for (IRInstruction instruction :
                InsBuffer)
        {
            IR_code += instruction.toString();
        }
        IR_code += "}\n";
        SymbolTableStack.pop();
        now_function_type_C = null;
    }

    void DeclarationHandler(ASTDeclaration declaration)
    {

    }

    public String ExpressionHandler(ASTExpression expression) //递归调用
    {
        //叶节点1: 整形
        if (expression instanceof ASTIntegerConstant || expression instanceof ASTStringConstant || expression instanceof ASTCharConstant || expression instanceof ASTFloatConstant)
        {
            return null;
        }
        else if (expression instanceof ASTBinaryExpression)
        {
            ASTBinaryExpression thisNode = (ASTBinaryExpression) expression;
            String src1 = ExpressionHandler(thisNode.expr1);
            //先全考虑整型
            if (src1 == null) //constant todo 添加constant判断，先假定所有的都是i32
            {
                src1 = ((ASTIntegerConstant) thisNode.expr1).value.toString();
            }
            String src2 = ExpressionHandler(thisNode.expr2);
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
        return null;
    }

    //todo: 字符串支持
    void NamelessStrHandler(ASTStringConstant stringConstant)
    {

    }

    void GlobalDeclarationHandler(ASTDeclaration declaration)
    {
        String type = TypeSpecifierListHandler(declaration.specifiers);

        type = ConvertCType2LLVMIR(type);

        //todo: 函数定义
        for (ASTInitList il : declaration.initLists)
        {
            if (il.declarator instanceof ASTVariableDeclarator)
            {
                String global_name = ((ASTVariableDeclarator) il.declarator).identifier.value.toString();
                if (GetSymbolInfo(global_name) == null)
                {
                    SymbolTableStack.firstElement().put(global_name, new IdentifierSymbol("@" + global_name, type));
                }
                //重复定义
                else
                {
                    SemanticErrorHandler.ES02(true, global_name);
                }
                String num = "0";
                if (il.exprs != null && il.exprs.size() >= 1)
                {
                    if (il.exprs.get(0) instanceof ASTIntegerConstant)
                    {
                        num = ((ASTIntegerConstant) il.exprs.get(0)).value.toString();
                    }
                }
                global_declaration += (new IRInstruction("@" + global_name, "global", type, num, null)).toString();
            }
        }
    }

    String TypeSpecifierListHandler(List<ASTToken> specifiers)
    {
        String type = specifiers.get(0).value.toString();
        for (int i = 1; i < specifiers.size(); i++)
        {
            type += specifiers.get(1).value.toString() + " ";
        }
        return type;
    }

    String ConvertCType2LLVMIR(String type)
    {
        if (type.contains("long long"))
        {
            return "i64";
        }
        else if (type.contains("char"))
        {
            return "i8";
        }
        else if (type.contains("bit"))
        {
            return "i1";
        }
        else if (type.contains("int"))
        {
            return "i32";
        }
        return "unknownType";
    }

    boolean isSignedType(String type)
    {
        if (type.contains("unsigned"))
        {
            return false;

        }
        return true;
    }

    public String GetResult()
    {
        Run();
        return target_data_layout + "\n" +
                target_triple + "\n" +
                global_declaration + "\n" +
                IR_code;
    }

    int GetRegCount()
    {
        int t = this.register_count;
        register_count++;
        return t;
    }

    IdentifierSymbol GetSymbolInfo(String SymbolName)
    {
        for (int j = SymbolTableStack.size() - 1; j >= 0; j--)
        {
            //最好把这个东西的使用禁止掉
            HashMap<String, IdentifierSymbol> syTable = SymbolTableStack.get(j);
            if (syTable.containsKey(SymbolName))
            {
                return syTable.get(SymbolName);
            }
        }
        SemanticErrorHandler.ES01(true, SymbolName);
        return null;//没有找到符号
    }

    WzcLLVMIR(ASTCompilationUnit ASTNode)
    {
        this.ASTRoot = ASTNode;
        this.SymbolTableStack = new Stack<>();
        this.SymbolTableStack.push(new HashMap<>());

        this.InsBuffer = new LinkedList<>();

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
}

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