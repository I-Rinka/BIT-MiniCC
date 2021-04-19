package bit.minisys.minicc.parser;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.net.Inet4Address;
import java.util.LinkedList;
import java.util.Stack;

import org.antlr.runtime.tree.TreeWizard.Visitor;
import org.antlr.v4.parse.ANTLRParser.terminal_return;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import bit.minisys.minicc.parser.CParser.CompilationUnitContext;
import bit.minisys.minicc.parser.CParser.CompoundStatementContext;
import bit.minisys.minicc.parser.CParser.DeclarationContext;
import bit.minisys.minicc.parser.CParser.DeclarationSpecifierContext;
import bit.minisys.minicc.parser.CParser.FunctionDeclaratorContext;
import bit.minisys.minicc.parser.CParser.FunctionDefinitionContext;
import bit.minisys.minicc.parser.CParser.InitDeclaratorListContext;
import bit.minisys.minicc.parser.CParser.ParameterDeclarationContext;
import bit.minisys.minicc.parser.CParser.VariableDeclaratorContext;
import bit.minisys.minicc.parser.ast.ASTCompilationUnit;
import bit.minisys.minicc.parser.ast.ASTCompoundStatement;
import bit.minisys.minicc.parser.ast.ASTDeclaration;
import bit.minisys.minicc.parser.ast.ASTDeclarator;
import bit.minisys.minicc.parser.ast.ASTFunctionDeclarator;
import bit.minisys.minicc.parser.ast.ASTFunctionDefine;
import bit.minisys.minicc.parser.ast.ASTIdentifier;
import bit.minisys.minicc.parser.ast.ASTInitList;
import bit.minisys.minicc.parser.ast.ASTNode;
import bit.minisys.minicc.parser.ast.ASTParamsDeclarator;
import bit.minisys.minicc.parser.ast.ASTToken;
import bit.minisys.minicc.parser.ast.ASTVariableDeclarator;

public class WzcListenr extends CBaseListener {
    // 每次进入函数的时候把自己的节点放进去
    // 每次出来的时候获取父节点（不弹出父节点），然后将自己放进去

    Stack<ASTNode> nodeStack;
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
            }
            break;
        case CLexer.Identifier:
            if (parentNode.getClass() == ASTVariableDeclarator.class) {
                ((ASTVariableDeclarator) parentNode).identifier = new ASTIdentifier(node.getSymbol().getText(),
                        node.getSymbol().getTokenIndex());
            }
            break;
        default:
            break;
        }
    }

    public WzcListenr() {
        returNode = new ASTCompilationUnit();
        nodeStack = new Stack<ASTNode>();
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
        }
    }

    @Override
    public void enterCompoundStatement(CompoundStatementContext ctx) {
        nodeStack.push(new ASTCompoundStatement());
    }

    @Override
    public void exitCompoundStatement(CompoundStatementContext ctx) {
        thisNode = nodeStack.pop();
        parentNode = nodeStack.peek();
        // parentNode.(thisNode);
        if (parentNode.getClass() == ASTFunctionDefine.class) {
            ((ASTFunctionDefine) parentNode).body = (ASTCompoundStatement) thisNode;
        }
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
        }
    }

    @Override
    public void enterInitDeclaratorList(InitDeclaratorListContext ctx) {
        nodeStack.push(new ASTInitList());
    }

    @Override
    public void exitInitDeclaratorList(InitDeclaratorListContext ctx) {
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
    public void enterParameterDeclaration(ParameterDeclarationContext ctx) {
        nodeStack.push(new ASTParamsDeclarator());
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
}
