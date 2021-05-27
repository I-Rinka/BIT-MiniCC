package bit.minisys.minicc.icgen;

import bit.minisys.minicc.parser.ast.*;
import bit.minisys.minicc.semantic.SemanticErrorHandler;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
    目前支持情况:
    语义检查:
    1. 未定义检测 ✅
    2. 重复定义 ✅
    3. 未在循环内使用break ✅
    4. 函数调用参数不匹配 ✅
    5. 操作类型不匹配 ✅
    6. 数组越界
    7. goto标签不存在
    8. 函数缺少return ✅

    中间代码生成:
    1. 全局变量声明 ✅
    2. 局部变量声明 ✅
    3. 递归作用域 ✅
    4. 无名字符串 ✅
    6. 函数调用 ✅
    7. 运算操作 ✅
    8. 循环语句 ✅
    9. 选择语句 ✅
    10. 跳转语句

 */

public class WzcLLVMIR
{
    public String target_data_layout = "e-m:e-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128";
    public String target_triple = "x86_64-pc-linux-gnu";
    String global_declaration = "";
    String IR_code = "";
    ASTCompilationUnit ASTRoot = null;

    //为了有scope的支持，需要使用栈
    private Stack<HashMap<String, IdentifierSymbol>> SymbolTableStack;
    private LinkedList<IRInstruction> InsBuffer;
    private HashMap<String, String> OperatorMap;
    private HashMap<String, String> RegLineage; //得到一个寄存器的type，LLVM规定寄存器类型需要显示转换 可能需要记录Reg类型的地方: 1.alloca 2.parameters 3.expression 4.load 5.函数

    //因为查错的状态是全局性的，因此需要在外面
    boolean now_function_return_exist = false;//用于检测函数是否有return
    String now_function_type_C = null; //用于函数返回类型

    //使用break或者continue时的标号
    private LinkedList<IRInstruction> break_statements_buffer;//给break语句的标号进行反填
    private int now_continue_position = 0;

    private int register_counter = 0; //虚拟寄存器以及基本块的值
    private int iteration_counter = 0;//目前循环的层数，用于检测break是否在循环内
    private int nameless_str_counter = 0;//用于无名字符串的声明

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

    void StatementHandler(ASTStatement statement)
    {
        if (statement instanceof ASTCompoundStatement)
        {
            SymbolTableStack.push(new HashMap<>());
            CompoundStatementHandler((ASTCompoundStatement) statement);
            SymbolTableStack.pop();
            //从队列中取出insBuffer并合并
            //准备递归调用，不过在这之前，先新建一个环境
        }
        else if (statement instanceof ASTExpressionStatement)
        {
            ASTExpressionStatement expressionStatement = (ASTExpressionStatement) statement;
            ExpressionHandler(expressionStatement.exprs.get(0));
        }
        else if (statement instanceof ASTReturnStatement)
        {
            ReturnStatementHandler((ASTReturnStatement) statement);
        }
        else if (statement instanceof ASTSelectionStatement)
        {
            SelectionStatementHandler((ASTSelectionStatement) statement);
        }
        else if (statement instanceof ASTIterationDeclaredStatement)
        {
            iteration_counter++;
            SymbolTableStack.push(new HashMap<>());
            DcIterationStatementHandler((ASTIterationDeclaredStatement) statement);
            SymbolTableStack.pop();
            iteration_counter--;
        }
        else if (statement instanceof ASTIterationStatement)
        {
            iteration_counter++;
            IterationStatementHandler((ASTIterationStatement) statement);
            iteration_counter--;
        }
        else if (statement instanceof ASTBreakStatement)
        {
            if (iteration_counter == 0)
            {
                SemanticErrorHandler.ES03();
            }
            else
            {
                BreakStatementHandler((ASTBreakStatement) statement);
            }
        }
        else if (statement instanceof ASTContinueStatement)
        {
            if (iteration_counter == 0)
            {
                //continue错误
            }
            else
            {
                ContinueStatementHandler((ASTContinueStatement) statement);
            }
        }
    }

    //这个很重要
    void FunctionDefineHandler(ASTFunctionDefine functionDefine)
    {
        //进行局部环境的初始化
        SymbolTableStack.push(new HashMap<>());
        InsBuffer = new LinkedList<>();
        RegLineage = new HashMap<>();

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

        String para_string = "";
        LinkedList<String> para_list = new LinkedList<>();

        //遍历params收集信息
        for (ASTParamsDeclarator para :
                ((ASTFunctionDeclarator) functionDefine.declarator).params)
        {
            String para_type = TypeSpecifierListHandler(para.specfiers);
            if (para.declarator instanceof ASTVariableDeclarator)
            {
                String para_reg = "%" + GetRegCount();
                if (!para_string.equals(""))
                {
                    para_string += ", ";
                }
                para_string += ConvertCType2LLVMIR(para_type) + " " + para_reg;
                RegLineage.put(para_reg, ConvertCType2LLVMIR(para_type));
                para_list.add(ConvertCType2LLVMIR(para_type));
            }
        }
        func_out_header += para_string;
        func_out_header += ") #0 {\n";
        IR_code += func_out_header;
        GetRegCount();
        int para_count = 0;//准备进入函数，将形参load一遍

        //函数表注册函数
        FunctionDecHandler(func_name, now_function_type_C, para_list, false);

        for (ASTParamsDeclarator para :
                ((ASTFunctionDeclarator) functionDefine.declarator).params)
        {
            String para_type = TypeSpecifierListHandler(para.specfiers);
            if (para.declarator instanceof ASTVariableDeclarator)
            {
                String C_type = TypeSpecifierListHandler(para.specfiers);
                VariableDeclaratorHandler((ASTVariableDeclarator) para.declarator, C_type);
                //然后load值
                InsBuffer.add(new IRInstruction(null, "store", ConvertCType2LLVMIR(C_type), "%" + para_count, ConvertCType2LLVMIR(C_type) + "* " + GetSymbolInfo((((ASTVariableDeclarator) para.declarator).identifier.value.toString())).addr));
            }
            para_count++;
        }

        //真正执行CompoundStatement中的指令
        CompoundStatementHandler(functionDefine.body);

        if (!now_function_return_exist)
        {
            SemanticErrorHandler.ES08(func_name);
            if (now_function_type_C.equals("void"))
            {
                InsBuffer.add(new IRInstruction(null, "ret", now_function_type_C, null, null));

            }
            else
            {
                InsBuffer.add(new IRInstruction(null, "ret", ConvertCType2LLVMIR(now_function_type_C), "0", null));
            }
        }

        //输出符号
        for (IRInstruction instruction :
                InsBuffer)
        {
            IR_code += "  " + instruction.toString();
        }
        IR_code += "}\n";
        SymbolTableStack.pop();
        now_function_type_C = null;
        now_function_return_exist = false;
        this.register_counter = 0;
    }

    void CompoundStatementHandler(ASTCompoundStatement compoundStatement)
    {
        for (ASTNode blockItem :
                compoundStatement.blockItems)
        {
            //在这里进行判断操作
            if (blockItem instanceof ASTDeclaration)
            {
                DeclarationHandler((ASTDeclaration) blockItem);
            }
            else if (blockItem instanceof ASTStatement)
            {
                StatementHandler((ASTStatement) blockItem);
            }
        }
    }

    void ReturnStatementHandler(ASTReturnStatement returnStatement)
    {
        now_function_return_exist = true;
        if (returnStatement.expr == null || returnStatement.expr.size() == 0)
        {
            InsBuffer.add(new IRInstruction(null, "ret", "void", null, null));
        }
        else
        {
            String val = ExpressionHandler(returnStatement.expr.get(0));
            String type = ConvertCType2LLVMIR(now_function_type_C);
            if (val == null)
            {
                if (returnStatement.expr.get(0) instanceof ASTIntegerConstant)
                {
                    val = ((ASTIntegerConstant) returnStatement.expr.get(0)).value.toString();
                }
            }
            InsBuffer.add(new IRInstruction(null, "ret", type, val, null));
        }
    }

    void SelectionStatementHandler(ASTSelectionStatement selectionStatement)
    {
        String ans_reg = ExpressionHandler(selectionStatement.cond.get(0));
        int True_label = GetRegCount();
        IRInstruction br1 = new IRInstruction(null, "br", "i1 " + ans_reg + ",", "label " + "%" + True_label, null);
        InsBuffer.add(br1);
        InsBuffer.add(new IRInstruction(null, True_label + ":", "", "", null));

        StatementHandler(selectionStatement.then);

        IRInstruction br2 = new IRInstruction(null, "br", "label", null, null);
        InsBuffer.add(br2);

        int False_label = GetRegCount();
        br1.src_var2 = "label " + "%" + False_label;
        InsBuffer.add(new IRInstruction(null, False_label + ":", "", "", null));

        if (selectionStatement.otherwise != null)
        {
            StatementHandler(selectionStatement.otherwise);
            int Out_label = GetRegCount();
            br2.src_var1 = "%" + Out_label;
            IRInstruction br3 = new IRInstruction(null, "br", "label", "%" + Out_label, null);
            InsBuffer.add(br3);
            InsBuffer.add(new IRInstruction(null, Out_label + ":", "", "", null));
        }
        else
        {
            br2.src_var1 = "%" + False_label;
        }

    }

    void DcIterationStatementHandler(ASTIterationDeclaredStatement itDeclaredStatement)
    {
        DeclarationHandler(itDeclaredStatement.init);
        int Start_label = GetRegCount();

        now_continue_position = Start_label;

        InsBuffer.add(new IRInstruction(null, "br", "label", "%" + Start_label, null));
        InsBuffer.add(new IRInstruction(null, Start_label + ":", "", "", null));

        //cmp
        String ans_reg = ExpressionHandler(itDeclaredStatement.cond.getLast());
        int True_label = GetRegCount();
        IRInstruction br1 = new IRInstruction(null, "br", "i1 " + ans_reg + ",", "label " + "%" + True_label, null);
        InsBuffer.add(br1);
        InsBuffer.add(new IRInstruction(null, True_label + ":", "", "", null));

        StatementHandler(itDeclaredStatement.stat);
        int Nxt_label = GetRegCount();
        InsBuffer.add(new IRInstruction(null, "br", "label", "%" + Nxt_label, null));
        InsBuffer.add(new IRInstruction(null, Nxt_label + ":", "", "", null));


        ExpressionHandler(itDeclaredStatement.step.getLast());
        int False_label = GetRegCount();
        br1.src_var2 = "%" + False_label;
        for (int i = 0; i < break_statements_buffer.size(); i++)
        {
            break_statements_buffer.pop().src_var1 = "%" + False_label;
        }
        InsBuffer.add(new IRInstruction(null, "br", "label", "%" + Start_label, null));
        InsBuffer.add(new IRInstruction(null, False_label + ":", "", "", null));

    }

    void IterationStatementHandler(ASTIterationStatement iterationStatement)
    {
        if (iterationStatement.init != null && iterationStatement.init.size() > 0)
        {
            ExpressionHandler(iterationStatement.init.getLast());
        }
        int Start_label = GetRegCount();
        now_continue_position = Start_label;//todo: continue日后也需要队列支持
        InsBuffer.add(new IRInstruction(null, "br", "label", "%" + Start_label, null));
        InsBuffer.add(new IRInstruction(null, Start_label + ":", "", "", null));

        IRInstruction condition = null;

        String True_label = "";
        String False_label = "";

        //cmp
        if (iterationStatement.cond != null && iterationStatement.cond.size() > 0)
        {
            String ans_reg = ExpressionHandler(iterationStatement.cond.getLast());
            True_label += GetRegCount();
            condition = new IRInstruction(null, "br", "i1 " + ans_reg + ",", "label " + "%" + True_label, null);
            InsBuffer.add(new IRInstruction(null, True_label + ":", "", "", null));
        }

        StatementHandler(iterationStatement.stat);

        if (iterationStatement.step != null && iterationStatement.step.size() > 0)
        {
            int new_label = GetRegCount();
            InsBuffer.add(new IRInstruction(null, "br", "label", "%" + new_label, null));
            InsBuffer.add(new IRInstruction(null, new_label + ":", "", "", null));
            ExpressionHandler(iterationStatement.step.getLast());
        }

        False_label += GetRegCount();
        InsBuffer.add(new IRInstruction(null, False_label + ":", "", "", null));
        if (condition != null)
        {
            condition.src_var2 += "%" + False_label;
        }

        for (int i = 0; i < break_statements_buffer.size(); i++)
        {
            break_statements_buffer.pop().src_var1 = "%" + False_label;
        }
    }

    //todo 基本块的标号应该怎么处理
    void BreakStatementHandler(ASTBreakStatement breakStatement)
    {
        IRInstruction break_statement = new IRInstruction(null, "br", "label", null, null);
        InsBuffer.add(break_statement);//到时候在src1的时候填
        break_statements_buffer.add(break_statement);
    }

    void ContinueStatementHandler(ASTContinueStatement continueStatement)
    {
        InsBuffer.add(new IRInstruction(null, "br", "label", "%" + now_continue_position, null));
    }

    //注册，打印
    void VariableDeclaratorHandler(ASTVariableDeclarator variableDeclarator, String C_type)
    {
        int now_reg = GetRegCount();
        String var_name = variableDeclarator.identifier.value.toString();
        //Scope,只看当前层是否重复定义
        if (!SymbolTableStack.peek().containsKey(var_name))
        {
            SymbolTableStack.peek().put(var_name, new IdentifierSymbol("%" + now_reg, ConvertCType2LLVMIR(C_type)));
        }
        //重复定义
        else
        {
            SemanticErrorHandler.ES02(true, var_name);
        }
        //打印
        //声明以后应该alloca
        InsBuffer.add(new IRInstruction("%" + now_reg, "alloca", ConvertCType2LLVMIR(C_type), null, null));
        RegLineage.put("%" + now_reg, ConvertCType2LLVMIR(C_type));

    }

    void DeclarationHandler(ASTDeclaration declaration)
    {
        String C_type = TypeSpecifierListHandler(declaration.specifiers);


        for (ASTInitList il : declaration.initLists)
        {
            if (il.declarator instanceof ASTVariableDeclarator)
            {
                ASTVariableDeclarator variableDeclarator = (ASTVariableDeclarator) il.declarator;
                VariableDeclaratorHandler(variableDeclarator, C_type);
                //从expression中加载值
                if (il.exprs.size() > 0)
                {
                    String store_val = "";
                    if (il.exprs.get(0) instanceof ASTIntegerConstant)
                    {
                        store_val = ((ASTIntegerConstant) il.exprs.get(0)).value.toString();
                    }
                    else
                    {
                        store_val = ExpressionHandler(il.exprs.get(0));
                    }
                    String var = ((ASTVariableDeclarator) il.declarator).identifier.value.toString();
                    var = GetSymbolInfo(var).addr;
                    InsBuffer.add(new IRInstruction(null, "store", ConvertCType2LLVMIR(C_type), store_val, ConvertCType2LLVMIR(C_type) + "* " + var));
                }
            }
        }
    }

    //返回结果存的寄存器
    public String ExpressionHandler(ASTExpression expression) //递归调用
    {
        //叶节点1: 整形
        if (expression instanceof ASTIntegerConstant || expression instanceof ASTStringConstant || expression instanceof ASTCharConstant || expression instanceof ASTFloatConstant)
        {
            return null;
        }
        else if (expression instanceof ASTFunctionCall)
        {
            ASTFunctionCall functionCall = (ASTFunctionCall) expression;
            String func_name = ((ASTIdentifier) functionCall.funcname).value.toString();
            GlobalSymbol func_info = GetFuncInfo(func_name);//函数未声明报错已经写在里面了
            if (func_info == null)
            {
                return "none";
            }
            else
            {
                String func_para = "";
                int para_count = 0;
                if (functionCall.argList.size() != func_info.func_para.size())
                {
                    SemanticErrorHandler.ES04(func_name);//函数参数不对
                }
                for (ASTExpression arg : functionCall.argList)
                {
                    if (para_count > 0)
                    {
                        func_para += ", ";
                    }
                    String reg = ExpressionHandler(arg);
                    if (reg == null)
                    {

                        //判断整形之类的
                        if (arg instanceof ASTStringConstant)
                        {
                            reg = NamelessStrHandler(((ASTStringConstant) arg));
                        }
                        else if (arg instanceof ASTIntegerConstant)
                        {
                            reg += "i32" + " " + ((ASTIntegerConstant) arg).value.toString();
                        }
                        else if (arg instanceof ASTCharConstant)
                        {

                        }
                        func_para += reg;
                    }
                    else
                    {
                        func_para += RegLineage.get(reg) + " " + reg;
                        if (!RegLineage.get(reg).equals(func_info.func_para.get(para_count)))//函数操作不相容
                        {
                            SemanticErrorHandler.ES04(func_name);
                        }
                    }
                    para_count++;
                }
                if (func_info.llvm_type.equals("void"))
                {
                    InsBuffer.add(new IRInstruction(null, "call", ConvertCType2LLVMIR(func_info.llvm_type), "@" + func_name + "()", null));
                    return "none";
                }
                int rt_reg = GetRegCount();
                InsBuffer.add(new IRInstruction("%" + rt_reg, "call", ConvertCType2LLVMIR(func_info.llvm_type), func_info.GetFuncCallList() + "@" + func_name + "(" + func_para + ")", null));
                RegLineage.put("%" + rt_reg, ConvertCType2LLVMIR(func_info.llvm_type));
                return "%" + rt_reg;
            }
        }
        else if (expression instanceof ASTBinaryExpression)
        {
            ASTBinaryExpression thisNode = (ASTBinaryExpression) expression;
            String op = thisNode.op.value.toString();
            String op_type = "";
            if (op.equals("="))
            {
                String src1 = ((ASTIdentifier) thisNode.expr1).value.toString();
                String src2 = ExpressionHandler(thisNode.expr2);
                op_type = RegLineage.get(src2);
                if (!GetSymbolInfo(src1).llvm_type.equals(op_type))
                {
                    SemanticErrorHandler.ES05("=");
                }
                if (src2 == null) //constant
                {
                    src2 = ((ASTIntegerConstant) thisNode.expr2).value.toString();
                }
                InsBuffer.add(new IRInstruction(null, "store", op_type, src2, op_type + "* " + GetSymbolInfo(src1).addr));
                return "Assignment";
            }
            else
            {
                //先全考虑整型
                String src1 = ExpressionHandler(thisNode.expr1);
                if (src1 == null)
                {
                    if (thisNode.expr1 instanceof ASTIntegerConstant)
                    {
                        src1 = ((ASTIntegerConstant) thisNode.expr1).value.toString();
                        op_type = "i32";
                    }
                }
                else
                {
                    op_type = RegLineage.get(src1);
                }
                String op_type2 = "";
                String src2 = ExpressionHandler(thisNode.expr2);
                if (src2 == null) //constant
                {
                    if (thisNode.expr2 instanceof ASTIntegerConstant)
                    {
                        src2 = ((ASTIntegerConstant) thisNode.expr2).value.toString();
                        op_type2 = "i32";
                    }
                }
                else
                {
                    op_type2 = RegLineage.get(src2);
                }
                String rt_reg = "%" + GetRegCount();


                //操作符判断
                switch (op)
                {
                    case ">":
                        InsBuffer.add(new IRInstruction(rt_reg, "icmp", "sgt", " " + op_type + src1, src2));
                        break;
                    case "<":
                        InsBuffer.add(new IRInstruction(rt_reg, "icmp", "slt", " " + op_type + src1, src2));
                        break;
                    case ">=":
                        InsBuffer.add(new IRInstruction(rt_reg, "icmp", "sge", " " + op_type + src1, src2));
                        break;
                    case "<=":
                        InsBuffer.add(new IRInstruction(rt_reg, "icmp", "sle", " " + op_type + src1, src2));
                        break;
                    case "==":
                        InsBuffer.add(new IRInstruction(rt_reg, "icmp", "eq", " " + op_type + src1, src2));
                        break;
                    case "!=":
                        InsBuffer.add(new IRInstruction(rt_reg, "icmp", "ne", " " + op_type + src1, src2));
                        break;
                    default:
                        if (!op_type.equals(op_type2))
                        {
                            SemanticErrorHandler.ES05(op);
                        }
                        op = OperatorMap.get(op);
                        InsBuffer.add(new IRInstruction(rt_reg, op, op_type, src1, src2));
                        break;
                }
                RegLineage.put(rt_reg, op_type);
                return rt_reg;
            }
        }
        //叶节点2: 变量
        else if (expression instanceof ASTIdentifier)
        {
            ASTIdentifier thisNode = (ASTIdentifier) expression;
            //未声明使用报错
            IdentifierSymbol detail = GetSymbolInfo(thisNode.value.toString());
            String src = "";
            if (detail == null) //未出现，进行报错
            {
                SemanticErrorHandler.ES01(true, thisNode.value.toString());
                String new_reg = "%" + GetRegCount();
                InsBuffer.add(new IRInstruction(new_reg, "add", "i32", "0", "0"));
                return new_reg;//todo 把这里临时alloca出一个来
            }
            else
            {
                src = detail.addr;
                //todo: 写个C语言到llvm的类型映射
                String new_reg = "%" + GetRegCount();
                InsBuffer.add(new IRInstruction(new_reg, "load", detail.llvm_type, null, detail.llvm_type + "* " + src));
                RegLineage.put(new_reg, detail.llvm_type);
                return new_reg;
            }

        }
        //todo 添加其他操作类型的支持

        return "none";
    }

    //无名字符串支持 返回字符串的地址
    String NamelessStrHandler(ASTStringConstant stringConstant)
    {
        String rt_String = "i8*";
        String strContent = stringConstant.value.toString();
        IdentifierSymbol str = SymbolTableStack.firstElement().get("\"" + strContent + "\"");
        if (str == null)
        {
            str = new GlobalSymbol(strContent, "@.str" + nameless_str_counter, strContent.length());
            nameless_str_counter++;
            SymbolTableStack.firstElement().put("\"" + strContent + "\"", str);
            global_declaration += ((GlobalSymbol) str).GetIRFormat(null);
        }

        rt_String += " getelementptr inbounds ";
        rt_String += "([" + strContent.length() + " x i8], [" + strContent.length() + " x i8]* " + str.addr + ", i64 0, i64 0)";
        return rt_String;
    }

    GlobalSymbol FunctionDecHandler(String func_name, String rt_type, LinkedList<String> para_type_LLVM, boolean is_external)
    {
        IdentifierSymbol func_info = SymbolTableStack.firstElement().get(func_name);
        if ((GlobalSymbol) func_info != null)
        {
            if (!is_external && !((GlobalSymbol) func_info).function_implements)
            {
                ((GlobalSymbol) func_info).function_implements = true;
            }
            else
            {
                SemanticErrorHandler.ES02(false, func_name);
            }
            return (GlobalSymbol) func_info;
        }
        GlobalSymbol func_symbol = new GlobalSymbol(rt_type, para_type_LLVM);
        SymbolTableStack.firstElement().put(func_name, func_symbol);
        if (is_external)
        {
            global_declaration += func_symbol.GetIRFormat(func_name);
        }
        return func_symbol;
    }

    GlobalSymbol GetFuncInfo(String func_name)
    {
        IdentifierSymbol func = SymbolTableStack.firstElement().get(func_name);
        if (func != null && func instanceof GlobalSymbol)
        {
            return (GlobalSymbol) func;
        }
        SemanticErrorHandler.ES01(false, func_name);
        return null;
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
            else if (il.declarator instanceof ASTFunctionDeclarator)
            {
                ASTFunctionDeclarator functionDeclarator = (ASTFunctionDeclarator) il.declarator;
                String func_name = ((ASTVariableDeclarator) functionDeclarator.declarator).identifier.value.toString();
                LinkedList<String> para_type = new LinkedList<>();
                for (ASTParamsDeclarator para :
                        functionDeclarator.params)
                {
                    para_type.add(TypeSpecifierListHandler(para.specfiers));
                }
                FunctionDecHandler(func_name, type, para_type, true);
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
        else if (type.contains("void"))
        {
            return "void";
        }
        else if (type.contains("bit"))
        {
            return "i1";
        }
        else if (type.contains("int"))
        {
            return "i32";
        }
        else if (type.equals("double"))
        {
            return "double";
        }
        else if (type.equals("float"))
        {
            return "float";
        }
        return "unknownType";
    }

    public String GetResult()
    {
        Run();
        return "target datalayout = \"" + target_data_layout + "\"\n" +
                "target triple = \"" + target_triple + "\"\n" +
                global_declaration + "\n" +
                IR_code;
    }

    int GetRegCount()
    {
        int t = this.register_counter;
        register_counter++;
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
        return null;//没有找到符号
    }

    WzcLLVMIR(ASTCompilationUnit ASTNode)
    {
        this.ASTRoot = ASTNode;
        this.SymbolTableStack = new Stack<>();
        this.SymbolTableStack.push(new HashMap<>());
        this.break_statements_buffer = new LinkedList<>();

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

    class GlobalSymbol extends IdentifierSymbol
    {
        LinkedList<String> func_para;
        boolean is_function = false;
        String string_content = "";
        public boolean function_implements = false;

        GlobalSymbol(String addr, String i_type)
        {
            super(addr, i_type);
        }

        GlobalSymbol(String rt_type, LinkedList<String> para_type_LLVM)
        {
            super("function", rt_type);
            this.func_para = para_type_LLVM;
            is_function = true;
        }

        GlobalSymbol(String string_content, String string_name, int string_len)
        {
            super(string_name, "[" + string_len + " x i8]");
            string_content = string_content;
        }

        public String GetIRFormat(String Name)
        {
            String rt_str = "";
            if (is_function)
            {
                rt_str += "declare";
                rt_str += " " + this.llvm_type;
                rt_str += " @" + Name;
                rt_str += "(";
                int para_count = 0;
                for (String para :
                        func_para)
                {
                    if (para_count > 0)
                    {
                        rt_str += ", ";
                    }
                    para_count++;
                    if (para.equals("..."))
                    {
                        rt_str += "...";
                    }
                    else
                    {
                        rt_str += ConvertCType2LLVMIR(para);
                    }
                }
                rt_str += ")" + " #1";
            }
            else
            {
                rt_str += super.addr + " = " + "private unnamed_addr constant" + super.llvm_type + " c\"" + string_content + "\\00\"";
            }
            return rt_str;
        }

        public String GetFuncCallList()
        {
            String rt_str = "";
            rt_str += "(";
            int para_count = 0;
            for (String para :
                    func_para)
            {
                if (para_count > 0)
                {
                    rt_str += ", ";
                }
                para_count++;
                if (para.equals("..."))
                {
                    rt_str += "...";
                }
                else
                {
                    rt_str += ConvertCType2LLVMIR(para);
                }
            }
            rt_str += ")";
            return rt_str;
        }

    }

    class IdentifierSymbol
    {
        public String addr;
        public String llvm_type;

        IdentifierSymbol(String addr, String llvm_type)
        {
            this.addr = addr;
            this.llvm_type = llvm_type;
        }

        public IRInstruction ins_pointer = null;//准备为拉链反填做支持,拉链反填的标号将会放在addr处，如果addr为空，那么说明需要通过这个进行反填
    }

    class IRInstruction
    {
        public String dest_var = null;

        public String action = null;
        public String action_type = null;

        public String src_var1 = null;
        public String src_var2 = null;

        public IRInstruction ins_pointer = null;//为拉链反填做支持

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
}

