package bit.minisys.minicc.parser;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.beans.Expression;
import java.net.Inet4Address;
import java.util.LinkedList;
import java.util.Stack;

import org.antlr.runtime.tree.TreeWizard.Visitor;
import org.antlr.v4.parse.ANTLRParser.terminal_return;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.python.antlr.PythonParser.break_stmt_return;

import bit.minisys.minicc.parser.CParser.AdditiveExpression_Context;
import bit.minisys.minicc.parser.CParser.ArrayAceess_Context;
import bit.minisys.minicc.parser.CParser.ArrayDeclaratorContext;
import bit.minisys.minicc.parser.CParser.AssignmentExpressionContext;
import bit.minisys.minicc.parser.CParser.AssignmentExpression_Context;
import bit.minisys.minicc.parser.CParser.BreakStatementContext;
import bit.minisys.minicc.parser.CParser.CastExpression_Context;
import bit.minisys.minicc.parser.CParser.CompilationUnitContext;
import bit.minisys.minicc.parser.CParser.CompoundStatementContext;
import bit.minisys.minicc.parser.CParser.ConditionalExpressionContext;
import bit.minisys.minicc.parser.CParser.ContinueStatementContext;
import bit.minisys.minicc.parser.CParser.DeclarationContext;
import bit.minisys.minicc.parser.CParser.DeclarationSpecifierContext;
import bit.minisys.minicc.parser.CParser.EqualityExpression_Context;
import bit.minisys.minicc.parser.CParser.ExpressionContext;
import bit.minisys.minicc.parser.CParser.ExpressionStatementContext;
import bit.minisys.minicc.parser.CParser.FunctionCall_Context;
import bit.minisys.minicc.parser.CParser.FunctionDeclaratorContext;
import bit.minisys.minicc.parser.CParser.FunctionDefinitionContext;
import bit.minisys.minicc.parser.CParser.GotoStatementContext;
import bit.minisys.minicc.parser.CParser.InitDeclaratorContext;
import bit.minisys.minicc.parser.CParser.InitDeclaratorListContext;
import bit.minisys.minicc.parser.CParser.IterationDeclaredStatement_Context;
import bit.minisys.minicc.parser.CParser.IterationStatement_Context;
import bit.minisys.minicc.parser.CParser.LabeledStatementContext;
import bit.minisys.minicc.parser.CParser.MultiplicativeExpression_Context;
import bit.minisys.minicc.parser.CParser.ParameterDeclarationContext;
import bit.minisys.minicc.parser.CParser.PostfixExpressionContext;
import bit.minisys.minicc.parser.CParser.PostfixExpression_Context;
import bit.minisys.minicc.parser.CParser.PostfixExpression_passContext;
import bit.minisys.minicc.parser.CParser.PrimaryExpressionContext;
import bit.minisys.minicc.parser.CParser.ReturnStatementContext;
import bit.minisys.minicc.parser.CParser.SelectionStatementContext;
import bit.minisys.minicc.parser.CParser.SelectionStatement_no_elseContext;
import bit.minisys.minicc.parser.CParser.StatementContext;
import bit.minisys.minicc.parser.CParser.UnaryExpressionContext;
import bit.minisys.minicc.parser.CParser.UnaryExpression_Context;
import bit.minisys.minicc.parser.CParser.VariableDeclaratorContext;
import bit.minisys.minicc.parser.ast.ASTArrayAccess;
import bit.minisys.minicc.parser.ast.ASTArrayDeclarator;
import bit.minisys.minicc.parser.ast.ASTBinaryExpression;
import bit.minisys.minicc.parser.ast.ASTBreakStatement;
import bit.minisys.minicc.parser.ast.ASTCastExpression;
import bit.minisys.minicc.parser.ast.ASTCharConstant;
import bit.minisys.minicc.parser.ast.ASTCompilationUnit;
import bit.minisys.minicc.parser.ast.ASTCompoundStatement;
import bit.minisys.minicc.parser.ast.ASTContinueStatement;
import bit.minisys.minicc.parser.ast.ASTDeclaration;
import bit.minisys.minicc.parser.ast.ASTDeclarator;
import bit.minisys.minicc.parser.ast.ASTExpression;
import bit.minisys.minicc.parser.ast.ASTExpressionStatement;
import bit.minisys.minicc.parser.ast.ASTFloatConstant;
import bit.minisys.minicc.parser.ast.ASTFunctionCall;
import bit.minisys.minicc.parser.ast.ASTFunctionDeclarator;
import bit.minisys.minicc.parser.ast.ASTFunctionDefine;
import bit.minisys.minicc.parser.ast.ASTGotoStatement;
import bit.minisys.minicc.parser.ast.ASTIdentifier;
import bit.minisys.minicc.parser.ast.ASTInitList;
import bit.minisys.minicc.parser.ast.ASTIntegerConstant;
import bit.minisys.minicc.parser.ast.ASTIterationDeclaredStatement;
import bit.minisys.minicc.parser.ast.ASTIterationStatement;
import bit.minisys.minicc.parser.ast.ASTLabeledStatement;
import bit.minisys.minicc.parser.ast.ASTNode;
import bit.minisys.minicc.parser.ast.ASTParamsDeclarator;
import bit.minisys.minicc.parser.ast.ASTPostfixExpression;
import bit.minisys.minicc.parser.ast.ASTReturnStatement;
import bit.minisys.minicc.parser.ast.ASTSelectionStatement;
import bit.minisys.minicc.parser.ast.ASTStatement;
import bit.minisys.minicc.parser.ast.ASTToken;
import bit.minisys.minicc.parser.ast.ASTUnaryExpression;
import bit.minisys.minicc.parser.ast.ASTUnaryTypename;
import bit.minisys.minicc.parser.ast.ASTVariableDeclarator;

public class WzcListenr extends CBaseListener {
    // 每次进入函数的时候把自己的节点放进去
    // 每次出来的时候获取父节点（不弹出父节点），然后将自己放进去

    Stack<ASTNode> nodeStack;
    Stack<ASTExpression> expressionStack;
    ASTNode thisNode;
    ASTNode parentNode;
    ASTNode returNode;

    @Override
    public void visitTerminal(TerminalNode node) {
        parentNode = nodeStack.peek();
        switch (node.getSymbol().getType()) {
        case CLexer.Int:
        case CLexer.Double:
        case CLexer.Void:
        case CLexer.Float:

            if (parentNode.getClass() == ASTFunctionDefine.class) {
                ((ASTFunctionDefine) parentNode).specifiers
                        .add(new ASTToken(node.getSymbol().getText(), node.getSymbol().getTokenIndex()));
            } else if (parentNode.getClass() == ASTDeclaration.class) {
                ASTDeclaration astDeclaration = (ASTDeclaration) parentNode;
                if (astDeclaration.specifiers == null) {
                    astDeclaration.specifiers = new LinkedList<ASTToken>();
                }
                astDeclaration.specifiers
                        .add(new ASTToken(node.getSymbol().getText(), node.getSymbol().getTokenIndex()));
            } else if (parentNode.getClass() == ASTParamsDeclarator.class) {
                ((ASTParamsDeclarator) parentNode).specfiers
                        .add(new ASTToken(node.getSymbol().getText(), node.getSymbol().getTokenIndex()));
            }
            break;
        case CLexer.Identifier:
            if (parentNode.getClass() == ASTVariableDeclarator.class) {
                ((ASTVariableDeclarator) parentNode).identifier = new ASTIdentifier(node.getSymbol().getText(),
                        node.getSymbol().getTokenIndex());
            } else if (parentNode.getClass() == ASTInitList.class) {

                ASTInitList astInitList = ((ASTInitList) parentNode);
                if (astInitList.exprs == null) {
                    astInitList.exprs = new LinkedList<ASTExpression>();
                }
                astInitList.exprs.add(new ASTIdentifier(node.getSymbol().getText(), node.getSymbol().getTokenIndex()));

            }

            if (expressionStack != null && !expressionStack.empty()
                    && expressionStack.peek().getClass() == ASTPostfixExpression.class) {
                ASTPostfixExpression postfixExpression = (ASTPostfixExpression) expressionStack.peek();
                postfixExpression.expr = new ASTIdentifier(node.getSymbol().getText(),
                        node.getSymbol().getTokenIndex());
            }
            break;

        case CLexer.Constant:
            int type = 0;// Int
            if (node.getText().charAt(0) == '\'') {
                type = 2;// Char
            } else if (node.getText().contains(".")) {
                type = 1;// Float
            }
            if (parentNode.getClass() == ASTInitList.class) {

                ASTInitList astInitList = ((ASTInitList) parentNode);
                if (astInitList.exprs == null) {
                    astInitList.exprs = new LinkedList<ASTExpression>();
                }
                if (type == 0) {
                    astInitList.exprs.add(new ASTIntegerConstant(Integer.valueOf(node.getSymbol().getText()),
                            node.getSymbol().getTokenIndex()));
                }
            } else if (parentNode.getClass() == ASTArrayDeclarator.class) {
                if (type == 0) {
                    ((ASTArrayDeclarator) parentNode).expr = new ASTIntegerConstant(
                            Integer.valueOf(node.getSymbol().getText()), node.getSymbol().getTokenIndex());
                } else if (type == 1) {
                    ((ASTArrayDeclarator) parentNode).expr = new ASTFloatConstant(
                            Double.valueOf(node.getSymbol().getText()), node.getSymbol().getTokenIndex());
                } else if (type == 2) {
                    ((ASTArrayDeclarator) parentNode).expr = new ASTCharConstant(node.getSymbol().getText(),
                            node.getSymbol().getTokenIndex());
                }
            }

            if (expressionStack != null && !expressionStack.empty()
                    && expressionStack.peek().getClass() == ASTPostfixExpression.class) {
                ASTPostfixExpression postfixExpression = (ASTPostfixExpression) expressionStack.peek();
                if (type == 0) {
                    postfixExpression.expr = new ASTIntegerConstant(Integer.valueOf(node.getSymbol().getText()),
                            node.getSymbol().getTokenIndex());
                } else if (type == 1) {
                    postfixExpression.expr = new ASTFloatConstant(Double.valueOf(node.getSymbol().getText()),
                            node.getSymbol().getTokenIndex());
                } else if (type == 2) {
                    postfixExpression.expr = new ASTCharConstant(node.getSymbol().getText(),
                            node.getSymbol().getTokenIndex());
                }
            }
            break;
        case CLexer.Assign:
        case CLexer.Plus:
        case CLexer.Minus:
        case CLexer.Div:
        case CLexer.Star:
        case CLexer.Equal:
        case CLexer.Less:
        case CLexer.LessEqual:
        case CLexer.Greater:
        case CLexer.GreaterEqual:
            if (expressionStack != null && expressionStack.size() >= 2
                    && expressionStack.elementAt(expressionStack.size() - 2).getClass() == ASTBinaryExpression.class) {
                ((ASTBinaryExpression) expressionStack.elementAt(expressionStack.size() - 2)).op = new ASTToken(
                        node.getSymbol().getText(), node.getSymbol().getTokenIndex());
            }
            break;

        case CLexer.PlusPlus:
        case CLexer.MinusMinus:
            if (expressionStack != null && !expressionStack.empty()
                    && expressionStack.peek().getClass() == ASTPostfixExpression.class) {
                ASTPostfixExpression postfixExpression = (ASTPostfixExpression) expressionStack.peek();
                postfixExpression.op = new ASTToken(node.getSymbol().getText(), node.getSymbol().getTokenIndex());
            }
            break;
        default:
            break;
        }
    }

    public WzcListenr() {
        returNode = new ASTCompilationUnit();
        nodeStack = new Stack<ASTNode>();
        expressionStack = new Stack<ASTExpression>();
    };

    @Override
    public void enterCompilationUnit(CompilationUnitContext ctx) {
        nodeStack.push(returNode);
    }

    @Override
    public void exitCompilationUnit(CompilationUnitContext ctx) {

    }

    @Override
    public void enterFunctionDefinition(FunctionDefinitionContext ctx) {
        nodeStack.push(new ASTFunctionDefine());
    }

    @Override
    public void exitFunctionDefinition(FunctionDefinitionContext ctx) {
        thisNode = nodeStack.pop();
        parentNode = nodeStack.peek();
        // parentNode.(thisNode);
        if (parentNode.getClass() == ASTCompilationUnit.class) {
            ((ASTCompilationUnit) parentNode).items.add(thisNode);
        }
    }

    @Override
    public void enterFunctionDeclarator(FunctionDeclaratorContext ctx) {
        nodeStack.push(new ASTFunctionDeclarator());
    }

    @Override
    public void exitFunctionDeclarator(FunctionDeclaratorContext ctx) {
        thisNode = nodeStack.pop();
        parentNode = nodeStack.peek();

        if (parentNode.getClass() == ASTFunctionDefine.class) {
            ((ASTFunctionDefine) parentNode).declarator = (ASTDeclarator) thisNode;
        } else if (parentNode.getClass() == ASTInitList.class) {
            ((ASTInitList) parentNode).declarator = (ASTDeclarator) thisNode;
        } else if (parentNode.getClass() == ASTParamsDeclarator.class) {
            ((ASTParamsDeclarator) parentNode).declarator = (ASTDeclarator) thisNode;
        }
    }

    @Override
    public void enterVariableDeclarator(VariableDeclaratorContext ctx) {
        nodeStack.push(new ASTVariableDeclarator());
    }

    @Override
    public void exitVariableDeclarator(VariableDeclaratorContext ctx) {
        thisNode = nodeStack.pop();
        parentNode = nodeStack.peek();
        // parentNode.(thisNode);
        if (parentNode.getClass() == ASTFunctionDeclarator.class) {
            ((ASTFunctionDeclarator) parentNode).declarator = (ASTVariableDeclarator) thisNode;
        } else if (parentNode.getClass() == ASTParamsDeclarator.class) {
            ((ASTParamsDeclarator) parentNode).declarator = (ASTDeclarator) thisNode;
        } else if (parentNode.getClass() == ASTInitList.class) {
            ((ASTInitList) parentNode).declarator = (ASTDeclarator) thisNode;
        } else if (parentNode.getClass() == ASTArrayDeclarator.class) {
            ((ASTArrayDeclarator) parentNode).declarator = (ASTDeclarator) thisNode;
        }
    }

    @Override
    public void enterArrayDeclarator(ArrayDeclaratorContext ctx) {
        nodeStack.push(new ASTArrayDeclarator());
    }

    @Override
    public void exitArrayDeclarator(ArrayDeclaratorContext ctx) {
        thisNode = nodeStack.pop();
        parentNode = nodeStack.peek();
        // parentNode.(thisNode);
        if (parentNode.getClass() == ASTFunctionDeclarator.class) {
            ((ASTFunctionDeclarator) parentNode).declarator = (ASTVariableDeclarator) thisNode;
        } else if (parentNode.getClass() == ASTParamsDeclarator.class) {
            ((ASTParamsDeclarator) parentNode).declarator = (ASTDeclarator) thisNode;
        } else if (parentNode.getClass() == ASTInitList.class) {
            ((ASTInitList) parentNode).declarator = (ASTDeclarator) thisNode;
        }
    }

    @Override
    public void enterCompoundStatement(CompoundStatementContext ctx) {
        nodeStack.push(new ASTCompoundStatement());
    }

    @Override
    public void enterDeclaration(DeclarationContext ctx) {
        nodeStack.push(new ASTDeclaration());

    }

    @Override
    public void exitDeclaration(DeclarationContext ctx) {
        thisNode = nodeStack.pop();
        parentNode = nodeStack.peek();
        // parentNode.(thisNode);
        if (parentNode.getClass() == ASTCompilationUnit.class) {
            ((ASTCompilationUnit) parentNode).items.add((ASTDeclaration) thisNode);
        } else if (parentNode.getClass() == ASTCompoundStatement.class) {
            ((ASTCompoundStatement) parentNode).blockItems.add(thisNode);
        }
    }

    @Override
    public void enterInitDeclarator(InitDeclaratorContext ctx) {

        nodeStack.push(new ASTInitList());
    }

    @Override
    public void exitInitDeclarator(InitDeclaratorContext ctx) {

        thisNode = nodeStack.pop();
        parentNode = nodeStack.peek();
        if (parentNode.getClass() == ASTDeclaration.class) {
            if (((ASTDeclaration) parentNode).initLists == null) {
                ((ASTDeclaration) parentNode).initLists = new LinkedList<ASTInitList>();
            }
            ((ASTDeclaration) parentNode).initLists.add((ASTInitList) thisNode);
        }

    }

    @Override
    public void enterIterationStatement_(IterationStatement_Context ctx) {
        nodeStack.push(new ASTIterationStatement());
    }

    @Override
    public void exitIterationStatement_(IterationStatement_Context ctx) {

    }

    @Override
    public void enterIterationDeclaredStatement_(IterationDeclaredStatement_Context ctx) {
        nodeStack.push(new ASTIterationDeclaredStatement());
    }

    @Override
    public void exitIterationDeclaredStatement_(IterationDeclaredStatement_Context ctx) {

    }

    @Override
    public void enterSelectionStatement(SelectionStatementContext ctx) {
        ASTSelectionStatement astSelectionStatement = new ASTSelectionStatement();
        astSelectionStatement.cond = new LinkedList<>();
        nodeStack.push(astSelectionStatement);
    }

    @Override
    public void exitSelectionStatement(SelectionStatementContext ctx) {
        // thisNode = nodeStack.pop();
        // parentNode = nodeStack.peek();
        // if (parentNode.getClass() == ASTSelectionStatement.class) {
        // if (((ASTSelectionStatement) parentNode).then == null) {
        // ((ASTSelectionStatement) parentNode).then = (ASTStatement) thisNode;
        // } else {
        // ((ASTSelectionStatement) parentNode).otherwise = (ASTStatement) thisNode;
        // }
        // } else if (parentNode.getClass() == ASTCompoundStatement.class) {
        // ((ASTCompoundStatement) parentNode).blockItems.add(thisNode);
        // }

    }

    @Override
    public void enterParameterDeclaration(ParameterDeclarationContext ctx) {
        nodeStack.push(new ASTParamsDeclarator());
    }

    @Override
    public void enterBreakStatement(BreakStatementContext ctx) {
        nodeStack.push(new ASTBreakStatement());
    }

    @Override
    public void enterGotoStatement(GotoStatementContext ctx) {
        nodeStack.push(new ASTGotoStatement());
    }

    @Override
    public void enterContinueStatement(ContinueStatementContext ctx) {
        nodeStack.push(new ASTContinueStatement());
    }

    @Override
    public void enterReturnStatement(ReturnStatementContext ctx) {
        nodeStack.push(new ASTReturnStatement());
    }

    @Override
    public void enterLabeledStatement(LabeledStatementContext ctx) {
        nodeStack.push(new ASTLabeledStatement());
    }

    @Override
    public void exitParameterDeclaration(ParameterDeclarationContext ctx) {
        thisNode = nodeStack.pop();
        parentNode = nodeStack.peek();
        if (parentNode.getClass() == ASTFunctionDeclarator.class) {
            if (((ASTFunctionDeclarator) parentNode).params == null) {
                ((ASTFunctionDeclarator) parentNode).params = new LinkedList<ASTParamsDeclarator>();
            }
            ((ASTFunctionDeclarator) parentNode).params.add((ASTParamsDeclarator) thisNode);
        }
    }

    @Override // 其他Statement就不用手动退出了
    public void exitStatement(StatementContext ctx) {
        thisNode = nodeStack.peek();
        if (thisNode.getClass() != ASTCompoundStatement.class) {
            thisNode = nodeStack.pop();
            parentNode = nodeStack.peek();

            if (parentNode.getClass() == ASTCompoundStatement.class) {
                ((ASTCompoundStatement) parentNode).blockItems.add(thisNode);
            } else if (parentNode.getClass() == ASTSelectionStatement.class) {
                if (((ASTSelectionStatement) parentNode).then == null) {
                    ((ASTSelectionStatement) parentNode).then = (ASTStatement) thisNode;
                } else {
                    ((ASTSelectionStatement) parentNode).otherwise = (ASTStatement) thisNode;
                }
            } else if (parentNode.getClass() == ASTIterationDeclaredStatement.class) {
                ((ASTIterationDeclaredStatement) parentNode).stat = (ASTStatement) thisNode;
            } else if (parentNode.getClass() == ASTIterationStatement.class) {
                ((ASTIterationStatement) parentNode).stat = (ASTStatement) thisNode;
            }

        }
    }

    // compoundStatement比较特殊,不走那里
    @Override
    public void exitCompoundStatement(CompoundStatementContext ctx) {
        thisNode = nodeStack.pop();
        parentNode = nodeStack.peek();
        // parentNode.(thisNode);
        if (parentNode.getClass() == ASTFunctionDefine.class) {
            ((ASTFunctionDefine) parentNode).body = (ASTCompoundStatement) thisNode;
        } else if (parentNode.getClass() == ASTSelectionStatement.class) {
            if (((ASTSelectionStatement) parentNode).then == null) {
                ((ASTSelectionStatement) parentNode).then = (ASTStatement) thisNode;
            } else {
                ((ASTSelectionStatement) parentNode).otherwise = (ASTStatement) thisNode;
            }
        } else if (parentNode.getClass() == ASTIterationDeclaredStatement.class) {
            ((ASTIterationDeclaredStatement) parentNode).stat = (ASTStatement) thisNode;
        } else if (parentNode.getClass() == ASTIterationStatement.class) {
            ((ASTIterationStatement) parentNode).stat = (ASTStatement) thisNode;
        }
    }

    // 这里不确定
    @Override
    public void exitExpression(ExpressionContext ctx) {
        if (nodeStack.peek().getClass() == ASTSelectionStatement.class) {
            while (!expressionStack.empty()) {
                if (expressionStack.peek().getClass() == ASTPostfixExpression.class
                        && ((ASTPostfixExpression) expressionStack.peek()).op == null) {
                    expressionStack.pop();
                } else {

                    ((ASTSelectionStatement) nodeStack.peek()).cond.add(expressionStack.pop());
                }
            }
            expressionStack.clear();
        }
    }

    @Override
    public void enterExpressionStatement(ExpressionStatementContext ctx) {
        nodeStack.push(new ASTExpressionStatement());
    }

    @Override
    public void exitExpressionStatement(ExpressionStatementContext ctx) {
        ASTExpressionStatement astExpressionStatement = (ASTExpressionStatement) nodeStack.peek();

        // ExpressionStatement需要特殊处理
        if (astExpressionStatement.exprs == null) {
            astExpressionStatement.exprs = new LinkedList<ASTExpression>();
        }
        while (!expressionStack.empty()) {
            astExpressionStatement.exprs.add(expressionStack.pop());
        }
        expressionStack.clear();

    }

    @Override
    public void enterPostfixExpression_(PostfixExpression_Context ctx) {
        expressionStack.push(new ASTPostfixExpression());
    }

    @Override
    public void enterPostfixExpression_pass(PostfixExpression_passContext ctx) {
        expressionStack.push(new ASTPostfixExpression());
    }

    @Override
    public void exitPostfixExpression_pass(PostfixExpression_passContext ctx) {
        if (expressionStack.size() >= 2) {
            ASTPostfixExpression postfixExpression = (ASTPostfixExpression) expressionStack.pop();
            ASTExpression parent = expressionStack.peek();
            // 值挂载到上一节点
            if (parent.getClass() == ASTUnaryExpression.class) {
                // Unary
                ((ASTUnaryExpression) parent).expr = postfixExpression.expr;
            } else if (parent.getClass() == ASTPostfixExpression.class) {
                // // 自己的递归
                // ((ASTPostfixExpression) parent).expr = postfixExpression.expr;
                expressionStack.push(postfixExpression);
            } else if (parent.getClass() == ASTCastExpression.class) {
                // Cast
                ((ASTCastExpression) parent).expr = postfixExpression.expr;
            } else if (parent.getClass() == ASTArrayAccess.class) {

                expressionStack.push(postfixExpression);

            } else if (parent.getClass() == ASTBinaryExpression.class) {
                expressionStack.push(postfixExpression);
                // 二元的先啥都不干
            } else if (parent.getClass() == ASTFunctionCall.class) {
                // FunCall也是二元的，先啥都不干
                ASTFunctionCall functionCall = (ASTFunctionCall) expressionStack.peek();
                if (functionCall.funcname == null) {
                    functionCall.funcname = postfixExpression.expr;
                } else {
                    if (functionCall.argList == null) {
                        functionCall.argList = new LinkedList<>();
                    }
                    functionCall.argList.add(postfixExpression.expr);
                }
                // expressionStack.push(postfixExpression);
            }
            // 上一个不可能是conditional expression
            // 上一个不可能是type name
        } else {

        }
    }

    // 成功的节点一直留在栈顶
    @Override
    public void enterUnaryExpression_(UnaryExpression_Context ctx) {
        expressionStack.push(new ASTUnaryExpression());
    }

    @Override
    public void exitUnaryExpression_(UnaryExpression_Context ctx) {
        ASTExpression previous = expressionStack.pop();
        ((ASTUnaryExpression) expressionStack.peek()).expr = previous;
    }

    @Override
    public void enterCastExpression_(CastExpression_Context ctx) {
        expressionStack.push(new ASTCastExpression());
    }

    @Override
    public void exitCastExpression_(CastExpression_Context ctx) {
        ASTExpression previous = expressionStack.pop();
        ((ASTCastExpression) expressionStack.peek()).expr = previous;
    }

    // 取消支持a+++b，a++=b之类的奇怪语法
    public void exitBinaryExpression() {
        // 可以通过op判断postifix operation 是否是有效的
        ASTExpression expr2 = expressionStack.pop();
        ASTExpression expr1 = expressionStack.pop();
        if (!expressionStack.empty()) {
            if (expr1.getClass() == ASTPostfixExpression.class && ((ASTPostfixExpression) expr1).op == null) {
                ((ASTBinaryExpression) expressionStack.peek()).expr1 = ((ASTPostfixExpression) expr1).expr;
            } else {
                ((ASTBinaryExpression) expressionStack.peek()).expr1 = expr1;
            }
            if (expr2.getClass() == ASTPostfixExpression.class && ((ASTPostfixExpression) expr2).op == null) {
                ((ASTBinaryExpression) expressionStack.peek()).expr2 = ((ASTPostfixExpression) expr2).expr;
            } else {
                ((ASTBinaryExpression) expressionStack.peek()).expr2 = expr2;
            }
            // ((ASTBinaryExpression) expressionStack.peek()).expr1 = expr1;
            // ((ASTBinaryExpression) expressionStack.peek()).expr2 = expr2;
        }
    }

    @Override
    public void enterEqualityExpression_(EqualityExpression_Context ctx) {
        expressionStack.push(new ASTBinaryExpression());
    }

    @Override
    public void exitEqualityExpression_(EqualityExpression_Context ctx) {
        exitBinaryExpression();
    }

    @Override
    public void enterMultiplicativeExpression_(MultiplicativeExpression_Context ctx) {
        expressionStack.push(new ASTBinaryExpression());
    }

    @Override
    public void exitMultiplicativeExpression_(MultiplicativeExpression_Context ctx) {
        exitBinaryExpression();
    }

    @Override
    public void enterAdditiveExpression_(AdditiveExpression_Context ctx) {
        expressionStack.push(new ASTBinaryExpression());
    }

    @Override
    public void exitAdditiveExpression_(AdditiveExpression_Context ctx) {
        exitBinaryExpression();
    }

    @Override
    public void enterAssignmentExpression_(AssignmentExpression_Context ctx) {
        expressionStack.push(new ASTBinaryExpression());
    }

    @Override
    public void exitAssignmentExpression_(AssignmentExpression_Context ctx) {
        exitBinaryExpression();
    }

    @Override
    public void enterFunctionCall_(FunctionCall_Context ctx) {
        expressionStack.push(new ASTFunctionCall());
    }

    @Override
    public void exitFunctionCall_(FunctionCall_Context ctx) {

    }
    // @Override
    // public void enterConditionalExpression(ConditionalExpressionContext ctx) {

    // }
    @Override
    public void enterArrayAceess_(ArrayAceess_Context ctx) {
        expressionStack.push(new ASTArrayAccess());
    }

    // 选择取消支持多elements (比如 a[1,2,3,4])
    @Override
    public void exitArrayAceess_(ArrayAceess_Context ctx) {
        ASTExpression element = expressionStack.pop();
        ASTExpression name = expressionStack.pop();
        // array 的 element为什么是个数组啊
        ((ASTArrayAccess) expressionStack.peek()).arrayName = name;
        if (((ASTArrayAccess) expressionStack.peek()).elements == null) {
            ((ASTArrayAccess) expressionStack.peek()).elements = new LinkedList<>();
        }
        if (element.getClass() == ASTPostfixExpression.class && ((ASTPostfixExpression) element).op == null) {
            ((ASTArrayAccess) expressionStack.peek()).elements.add(((ASTPostfixExpression) element).expr);
        } else {
            ((ASTArrayAccess) expressionStack.peek()).elements.add(element);
        }
        // expressionStack.peek();
    }

    // 恕不支持flag ? x-- : x++;之类的奇怪语法
}
