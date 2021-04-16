package bit.minisys.minicc.parser;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.net.Inet4Address;

import org.antlr.runtime.tree.TreeWizard.Visitor;
import org.antlr.v4.parse.ANTLRParser.terminal_return;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class MyListener extends CBaseListener {
    String ast_json = "";
    int now_token_id = 0;

    @Override
    public void visitTerminal(TerminalNode node) {
        String temp_json = "";
        Boolean isToken = true;
        temp_json += '{';
        temp_json += "\"type\":";

        switch (node.getSymbol().getType()) {

        case CLexer.Constant:
            if (node.getText().toString().contains(".")) {
                temp_json += "\"FloatConstant\",";
            } else {
                temp_json += "\"IntergerConstant\",";
            }
            temp_json += "\"value\":" + node.getText();
            break;
        case CLexer.Char:
            temp_json += "\"CharConstant\",";
            temp_json += "\"value\":" + '\"' + node.getSymbol().getText() + '\"';
            break;
        case CLexer.StringLiteral:
            temp_json += "\"StringLiteral\",";
            temp_json += "\"value\":" + '\"' + node.getSymbol().getText() + '\"';
            break;
        case CLexer.Identifier:
            temp_json += "\"Identifier\",";
            temp_json += "\"value\":" + '\"' + node.getSymbol().getText() + '\"';
            break;
        case CLexer.Int:
        case CLexer.Double:
        case CLexer.Void:
        case CLexer.Float:
            temp_json += "\"Token\",";
            temp_json += "\"value\":" + '\"' + node.getSymbol().getText() + '\"';
            break;
        // case CLexer.Else:
        // temp_json += "@ELSE_";
        // break;
        default:
            isToken = false;
            break;
        }

        temp_json += ",\"tokenId\":" + node.getSymbol().getTokenIndex();
        now_token_id = node.getSymbol().getTokenIndex();
        temp_json += '}';
        if (isToken) {
            ast_json += temp_json;
        }
    }

    @Override
    public void enterUnaryExpression_(CParser.UnaryExpression_Context ctx) {
        this.ast_json += '{';
        this.ast_json += "\"type\":\"UnaryExpression\",";
        this.ast_json += "\"op\":{";
        // op
        this.ast_json += "\"value\":" + '\"';
        ctx.start.getText();
        this.ast_json += "\"" + ",\"tokenId\":";
        ctx.start.getStartIndex();
        this.ast_json += "},";
        this.ast_json += "\"expr\":";
    }

    @Override
    public void exitUnaryExpression_(CParser.UnaryExpression_Context ctx) {
        this.ast_json += "}";
    }

    @Override
    public void enterUnaryTypeName_(CParser.UnaryTypeName_Context ctx) {
        this.ast_json += '{';
        this.ast_json += "\"type\":\"UnaryTypeName\",";
        this.ast_json += "\"op\":{";
        // op
        this.ast_json += "\"value\":" + '\"';
        ctx.start.getText();
        this.ast_json += "\"" + ",\"tokenId\":";
        ctx.start.getStartIndex();
        this.ast_json += "},";
        this.ast_json += "\"typename\":{";
        this.ast_json += "\"type\":\"Typename\",";
        this.ast_json += "\"specifiers\":[";

        // typeName 可以使用visitor遍历吗？
    }

    @Override
    public void exitUnaryTypeName_(CParser.UnaryTypeName_Context ctx) {
        this.ast_json.replace("}{", "},{");
        this.ast_json += "],";
        this.ast_json += "\"declarator\":null,";
        this.ast_json += "}";
        this.ast_json += "}";
    }

    @Override
    public void enterBinaryExpression(CParser.BinaryExpressionContext ctx) {
        this.ast_json += '{';
        this.ast_json += "\"type\":\"BinaryExpression\",";
        this.ast_json += "\"op\":{";

        String find_op = ctx.getText().toString();
        int a = Integer.MAX_VALUE;
        if (find_op.indexOf("+") >= 0 && a > find_op.indexOf("+")) {
            a = find_op.indexOf("+");
        }
        if (find_op.indexOf("-") >= 0 && a > find_op.indexOf("-")) {
            a = find_op.indexOf("-");
        }
        if (find_op.indexOf("*") >= 0 && a > find_op.indexOf("*")) {
            a = find_op.indexOf("*");
        }
        if (find_op.indexOf("/") >= 0 && a > find_op.indexOf("/")) {
            a = find_op.indexOf("/");
        }
        if (a == Integer.MAX_VALUE) {
            a = 0;
        }
        this.ast_json += "\"value\":" + '\"' + find_op.charAt(a) + "\"";
        this.ast_json += ",\"tokenId\":" + now_token_id + 1;
        this.ast_json += "},";
        this.ast_json += "@";

    }

    @Override
    public void exitBinaryExpression(CParser.BinaryExpressionContext ctx) {
        StringBuilder sb = new StringBuilder(ast_json);
        int st = sb.indexOf("@");
        int ex2 = sb.indexOf("}{", st);
        // int ex2 = sb.indexOf("}{", 0);

        sb.insert(ex2 + 1, ",\"expr2\":");
        sb.deleteCharAt(st);

        sb.insert(st, "\"expr1\":");
        this.ast_json = sb.toString();
        this.ast_json += '}';

    }

    @Override
    public void enterFunctionCall(CParser.FunctionCallContext ctx) {
        this.ast_json += '{';
        this.ast_json += "\"type\":\"FunctionCall\",";
        this.ast_json += "\"funcname\":@";
    }

    @Override
    public void exitFunctionCall(CParser.FunctionCallContext ctx) {
        StringBuilder sb = new StringBuilder(ast_json);
        int st = sb.indexOf("@");
        sb.deleteCharAt(st);
        int ex2 = sb.indexOf("}{", st);
        sb.insert(ex2 + 1, ",\"argList\":[");
        int pre = sb.indexOf("}{", ex2);
        sb.insert(pre + 1, ",");
        while ((pre = sb.indexOf("}{", pre)) > 0) {
            sb.insert(pre + 1, ",");
        }
        this.ast_json = sb.toString();
        this.ast_json += ']';
        this.ast_json += '}';
    }

    @Override
    public void enterArrayAccess(CParser.ArrayAccessContext ctx) {
        this.ast_json += '{';
        this.ast_json += "\"type\":\"ArrayAccess\",";
        this.ast_json += "\"arrayName\":@";
    }

    @Override
    public void exitArrayAccess(CParser.ArrayAccessContext ctx) {
        StringBuilder sb = new StringBuilder(ast_json);
        int st = sb.lastIndexOf("@");
        int ex2 = sb.indexOf("}{", st);

        sb.insert(ex2 + 1, ",\"elements\":[");
        sb.deleteCharAt(st);
        this.ast_json = sb.toString();
        this.ast_json += ']';
        this.ast_json += '}';
    }

    @Override
    public void enterPostfixExpression__(CParser.PostfixExpression__Context ctx) {
        this.ast_json += '{';
        this.ast_json += "\"type\":\"PostfixExpression\",";
        this.ast_json += "\"expr\":";
    }

    @Override
    public void exitPostfixExpression__(CParser.PostfixExpression__Context ctx) {
        this.ast_json += ",\"op\":{";
        this.ast_json += "\"value\":" + '\"' + ctx.stop.getText() + '\"';
        this.ast_json += ",\"tokenId\":" + ctx.stop.getTokenIndex();
        this.ast_json += "}}";
    }

    @Override
    public void enterCastExpression_(CParser.CastExpression_Context ctx) {
        this.ast_json += '{';
        this.ast_json += "\"type\":\"CastExpression\",";
        this.ast_json += "\"typename\":{";
        this.ast_json += "\"specifiers\":[@";
    }

    @Override
    public void exitCastExpression_(CParser.CastExpression_Context ctx) {
        StringBuilder sb = new StringBuilder(ast_json);
        int st = sb.lastIndexOf("@");
        sb.deleteCharAt(st);
        int ex2 = sb.lastIndexOf("}{");// 这里不知道为什么lastindexof不行

        sb.insert(ex2 + 1, "],\"delcarator\":null},\"expr\":");
        this.ast_json = sb.toString();
        ast_json.replace("}{", "},{");
        this.ast_json += "}";
    }

    @Override
    public void enterBreakStatement(CParser.BreakStatementContext ctx) {
        this.ast_json += '{';
        this.ast_json += "\"type\":\"BreakStatement\",";
        this.ast_json += "\"tokenId\":" + ctx.start.getTokenIndex();
    }

    @Override
    public void exitBreakStatement(CParser.BreakStatementContext ctx) {
        this.ast_json += '}';
    }

    @Override
    public void enterContinueStatement(CParser.ContinueStatementContext ctx) {
        this.ast_json += '{';
        this.ast_json += "\"type\":\"ContinueStatement\",";
        this.ast_json += "\"tokenId\":" + ctx.start.getTokenIndex();
    }

    @Override
    public void exitContinueStatement(CParser.ContinueStatementContext ctx) {
        this.ast_json += '}';
    }

    @Override
    public void enterGotoStatement(CParser.GotoStatementContext ctx) {
        this.ast_json += '{';
        this.ast_json += "\"type\":\"GotoStatement\",";
        this.ast_json += "\"flag\":";

    }

    @Override
    public void exitGotoStatement(CParser.GotoStatementContext ctx) {
        this.ast_json += ",\"tokenId\":" + ctx.start.getTokenIndex();
        this.ast_json += '}';
    }

    @Override
    public void enterReturnStatement(CParser.ReturnStatementContext ctx) {
        this.ast_json += '{';
        this.ast_json += "\"type\":\"ReturnStatement\",";
        this.ast_json += "\"expr\":[";
    }

    @Override
    public void exitReturnStatement(CParser.ReturnStatementContext ctx) {
        this.ast_json += ']';
        this.ast_json += ",\"tokenId\":" + ctx.start.getTokenIndex();
        this.ast_json += '}';
    }

    @Override
    public void enterLabeledStatement(CParser.LabeledStatementContext ctx) {
        this.ast_json += '{';
        this.ast_json += "\"type\":\"LabledStatement\",";
        this.ast_json += "\"label\":";

    }

    @Override
    public void exitLabeledStatement(CParser.LabeledStatementContext ctx) {
        // this.ast_json += ",\"stat\":";
        this.ast_json += '}';

        StringBuilder sb = new StringBuilder(ast_json);
        int ex2 = sb.lastIndexOf("}{");// 这里不知道为什么lastindexof不行

        sb.insert(ex2 + 1, ",\"stat\":");
        this.ast_json = sb.toString();
    }

    @Override
    public void enterCompoundStatement(CParser.CompoundStatementContext ctx) {
        this.ast_json += '{';
        this.ast_json += "\"type\":\"CompoundStatement\",";
        this.ast_json += "\"blockitems\":[";
    }

    @Override
    public void exitCompoundStatement(CParser.CompoundStatementContext ctx) {
        this.ast_json += "]}";
        this.ast_json = this.ast_json.replace("}{", "},{");
    }

    @Override
    public void enterExpressionStatement(CParser.ExpressionStatementContext ctx) {
        this.ast_json += '{';
        this.ast_json += "\"type\":\"ExpressionStatement\",";
        this.ast_json += "\"exprs\":[";
    }

    @Override
    public void exitExpressionStatement(CParser.ExpressionStatementContext ctx) {
        this.ast_json += "]}";
    }

    @Override
    public void enterSelectionStatement(CParser.SelectionStatementContext ctx) {
        this.ast_json += '{';
        this.ast_json += "\"type\":\"SelectionStatement\",";
        this.ast_json += "\"cond\":[";
    }

    @Override
    public void exitSelectionStatement(CParser.SelectionStatementContext ctx) {
        StringBuilder sb = new StringBuilder(ast_json);
        int st = sb.lastIndexOf("\"cond\":[") + ("\"cond\":[").length();
        int then_pos = sb.indexOf("Statement", st);
        int insert_then = sb.lastIndexOf("}{", then_pos);
        sb.insert(insert_then + 1, "],\"then\":");

        then_pos = sb.indexOf("Statement", insert_then + 1);
        then_pos = sb.indexOf("Statement", then_pos + 1);
        int insert_otherwise = sb.lastIndexOf("{\"t", then_pos);// 最后一个Type
        sb.insert(insert_otherwise, ",\"otherwise\":");

        this.ast_json = sb.toString();
        this.ast_json += '}';
    }

    @Override
    public void enterIterationStatement(CParser.IterationStatementContext ctx) {
        this.ast_json += '{';
        this.ast_json += "\"type\":\"IterationStatement\",";
        this.ast_json += "\"init\":[";
    }

    @Override
    public void enterForExpression(CParser.ForExpressionContext ctx) {
        this.ast_json += "@cond";
    }

    @Override
    public void exitForExpression(CParser.ForExpressionContext ctx) {
        this.ast_json += "@cond_over";
    }

    @Override
    public void exitIterationStatement(CParser.IterationStatementContext ctx) {
        StringBuilder sb = new StringBuilder(ast_json);
        int st = sb.indexOf("\"init\":[");
        int insert_cond = sb.indexOf("@cond{", st);

        sb.delete(insert_cond, insert_cond + ("@cond").length());
        sb.insert(insert_cond, "],\"cond\":[");

        int insert_step = sb.indexOf("@cond_over@cond", insert_cond);
        sb.delete(insert_step, insert_step + ("@cond_over@cond").length());
        sb.insert(insert_step, "],\"step\":[");

        int insert_stat = sb.lastIndexOf("@cond_over");
        sb.delete(insert_stat, insert_stat + ("@cond_over").length());
        sb.insert(insert_stat, "],\"stat\":");

        this.ast_json = sb.toString();

        this.ast_json += "}";

    }

    @Override
    public void enterVariableDeclarator(CParser.VariableDeclaratorContext ctx) {
        this.ast_json += '{';
        this.ast_json += "\"type\":\"VariableDeclarator\",";
        this.ast_json += "\"identifier\":";
    }

    @Override
    public void exitVariableDeclarator(CParser.VariableDeclaratorContext ctx) {
        this.ast_json += '}';
    }

    @Override
    public void enterArrayDeclarator(CParser.ArrayDeclaratorContext ctx) {
        this.ast_json += '{';
        this.ast_json += "\"type\":\"ArrayDeclarator\",";
        this.ast_json += "\"declarator\":";

    }

    @Override
    public void exitArrayDeclarator(CParser.ArrayDeclaratorContext ctx) {
        StringBuilder sb = new StringBuilder(ast_json);

        int st = sb.lastIndexOf("Constant");
        int insert_expr = sb.lastIndexOf("{", st);
        sb.insert(insert_expr, ",\"expr\": [");

        insert_expr = sb.indexOf("}", insert_expr);
        sb.insert(insert_expr + 1, "]");

        this.ast_json = sb.toString();
        this.ast_json += '}';
    }

    @Override
    public void enterFunctionDeclarator(CParser.FunctionDeclaratorContext ctx) {
        this.ast_json += '{';
        this.ast_json += "\"type\":\"FunctionDeclarator\",";
        this.ast_json += "\"declarator\":@";
    }

    @Override
    public void exitFunctionDeclarator(CParser.FunctionDeclaratorContext ctx) {
        StringBuilder sb = new StringBuilder(ast_json);
        int st = sb.lastIndexOf("@");
        sb.deleteCharAt(st);
        st = sb.indexOf("ParamsDeclarator", st);// 这里不知道为什么lastindexof不行
        int insert_params = sb.lastIndexOf("{", st);
        if (insert_params > 0) {

            sb.insert(insert_params, ",\"params\":[");
        }

        this.ast_json = sb.toString();
        if (insert_params > 0) {
            this.ast_json += "],";
        } else {
            this.ast_json += ",\"params\":null,";
        }
        this.ast_json += "\"identifiers\":[]";
        this.ast_json += ",\"subtype\":\"paramtype\"";

        this.ast_json += '}';
    }

    @Override
    public void enterDeclaration(CParser.DeclarationContext ctx) {
        this.ast_json += '{';
        this.ast_json += "\"type\":\"Declaration\",";
        this.ast_json += "\"specifiers\":[";
    }

    @Override
    public void exitDeclaration(CParser.DeclarationContext ctx) {
        this.ast_json += ']';
        this.ast_json += '}';

    }

    @Override
    public void exitDeclarationSpecifiers(CParser.DeclarationSpecifiersContext ctx) {
        // this.ast_json += "],\"initList\":[";
        // this.ast_json += "],";

    }

    @Override
    public void enterInitDeclarator(CParser.InitDeclaratorContext ctx) {
        this.ast_json += "{\"type\":\"InitList\",\"declarator\":";

    }

    @Override
    public void exitInitDeclarator(CParser.InitDeclaratorContext ctx) {
        if (ctx.getChildCount() < 3) {
            this.ast_json += ",\"exprs\":[]";
        } else {

            StringBuilder sb = new StringBuilder(ast_json);
            int insert_comma = 0;
            while ((insert_comma = sb.indexOf("@exit_Initializer@enter_Initializer", insert_comma)) > 0) {
                sb.delete(insert_comma, insert_comma + ("@exit_Initializer@enter_Initializer").length());
                sb.insert(insert_comma, ",");
            }
            int insert_exprs = sb.indexOf("@enter_Initializer");
            sb.delete(insert_exprs, insert_exprs + ("@enter_Initializer").length());
            sb.insert(insert_exprs, ",\"exprs\":[");

            int insert_end = sb.lastIndexOf("@exit_Initializer");
            sb.delete(insert_end, insert_end + ("@exit_Initializer").length());
            sb.insert(insert_end, "]");

            this.ast_json = sb.toString();
        }
        this.ast_json += "}";
    }

    @Override
    public void enterInitializer_direct(CParser.Initializer_directContext ctx) {
        this.ast_json += "@enter_Initializer";
    }

    @Override
    public void exitInitializer_direct(CParser.Initializer_directContext ctx) {
        this.ast_json += "@exit_Initializer";

    }

    @Override
    public void enterParameterDeclaration(CParser.ParameterDeclarationContext ctx) {
        this.ast_json += "{\"type\":\"ParamsDeclarator\",\"specifiers\":[";
    }

    @Override
    public void exitParameterDeclaration(CParser.ParameterDeclarationContext ctx) {
        if (ctx.getChildCount() < 2) {
            this.ast_json += "],";
            this.ast_json += "\"declarator\":null";
        } else {
            StringBuilder sb = new StringBuilder(ast_json);
            int st = sb.lastIndexOf("}{");

            sb.insert(st + 1, "],\"delcarator\":");
            this.ast_json = sb.toString();
        }
        this.ast_json += "}";
    }

    @Override
    public void enterFunctionDefinition(CParser.FunctionDefinitionContext ctx) {
        this.ast_json += "{\"type\":\"FunctionDefine\",\"specifiers\":[";
    }

    @Override
    public void exitFunctionDefinition(CParser.FunctionDefinitionContext ctx) {
        StringBuilder sb = new StringBuilder(ast_json);
        int st = sb.indexOf("FunctionDeclarator");
        int insert_declarator = sb.lastIndexOf("},{", st);
        sb.delete(insert_declarator + 1, insert_declarator + 2);
        sb.insert(insert_declarator + 1, "],\"delclarator\":");

        // body
        int insert_body = sb.indexOf("Statement");
        insert_body = sb.lastIndexOf("},{", insert_body);
        sb.insert(insert_body + 2, "\"declarations\": [],\"body\":");

        this.ast_json = sb.toString();
        this.ast_json += "}";
    }
}
