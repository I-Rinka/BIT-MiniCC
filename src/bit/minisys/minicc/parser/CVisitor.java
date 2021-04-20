// Generated from .\C.g4 by ANTLR 4.8
package bit.minisys.minicc.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(CParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpression(CParser.PrimaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code postfixExpression_pass}
	 * labeled alternative in {@link CParser#postfixExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixExpression_pass(CParser.PostfixExpression_passContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionCall_}
	 * labeled alternative in {@link CParser#postfixExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall_(CParser.FunctionCall_Context ctx);
	/**
	 * Visit a parse tree produced by the {@code postfixExpression_}
	 * labeled alternative in {@link CParser#postfixExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixExpression_(CParser.PostfixExpression_Context ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayAceess_}
	 * labeled alternative in {@link CParser#postfixExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAceess_(CParser.ArrayAceess_Context ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#argumentExpressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentExpressionList(CParser.ArgumentExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryExpression_pass}
	 * labeled alternative in {@link CParser#unaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpression_pass(CParser.UnaryExpression_passContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryExpression_}
	 * labeled alternative in {@link CParser#unaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpression_(CParser.UnaryExpression_Context ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryTypename_}
	 * labeled alternative in {@link CParser#unaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryTypename_(CParser.UnaryTypename_Context ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#unaryOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOperator(CParser.UnaryOperatorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code castExpression_}
	 * labeled alternative in {@link CParser#castExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastExpression_(CParser.CastExpression_Context ctx);
	/**
	 * Visit a parse tree produced by the {@code castExpression_pass}
	 * labeled alternative in {@link CParser#castExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastExpression_pass(CParser.CastExpression_passContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiplicativeExpression_}
	 * labeled alternative in {@link CParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression_(CParser.MultiplicativeExpression_Context ctx);
	/**
	 * Visit a parse tree produced by the {@code multiplicativeExpression_pass}
	 * labeled alternative in {@link CParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression_pass(CParser.MultiplicativeExpression_passContext ctx);
	/**
	 * Visit a parse tree produced by the {@code additiveExpression_pass}
	 * labeled alternative in {@link CParser#additiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression_pass(CParser.AdditiveExpression_passContext ctx);
	/**
	 * Visit a parse tree produced by the {@code additiveExpression_}
	 * labeled alternative in {@link CParser#additiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression_(CParser.AdditiveExpression_Context ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#shiftExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftExpression(CParser.ShiftExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relationalExpression_pass}
	 * labeled alternative in {@link CParser#relationalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression_pass(CParser.RelationalExpression_passContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relationalExpression_}
	 * labeled alternative in {@link CParser#relationalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression_(CParser.RelationalExpression_Context ctx);
	/**
	 * Visit a parse tree produced by the {@code equalityExpression_pass}
	 * labeled alternative in {@link CParser#equalityExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression_pass(CParser.EqualityExpression_passContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equalityExpression_}
	 * labeled alternative in {@link CParser#equalityExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression_(CParser.EqualityExpression_Context ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#andExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression(CParser.AndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExclusiveOrExpression(CParser.ExclusiveOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInclusiveOrExpression(CParser.InclusiveOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalAndExpression(CParser.LogicalAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOrExpression(CParser.LogicalOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conditionalExpression_pass}
	 * labeled alternative in {@link CParser#conditionalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalExpression_pass(CParser.ConditionalExpression_passContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conditionalExpression_}
	 * labeled alternative in {@link CParser#conditionalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalExpression_(CParser.ConditionalExpression_Context ctx);
	/**
	 * Visit a parse tree produced by the {@code assignmentExpression_pass}
	 * labeled alternative in {@link CParser#assignmentExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExpression_pass(CParser.AssignmentExpression_passContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignmentExpression_}
	 * labeled alternative in {@link CParser#assignmentExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExpression_(CParser.AssignmentExpression_Context ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#assignmentOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentOperator(CParser.AssignmentOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(CParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#constantExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantExpression(CParser.ConstantExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(CParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#declarationSpecifiers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationSpecifiers(CParser.DeclarationSpecifiersContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#declarationSpecifiers2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationSpecifiers2(CParser.DeclarationSpecifiers2Context ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#declarationSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationSpecifier(CParser.DeclarationSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#initDeclaratorList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitDeclaratorList(CParser.InitDeclaratorListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#initDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitDeclarator(CParser.InitDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#storageClassSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageClassSpecifier(CParser.StorageClassSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#typeSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeSpecifier(CParser.TypeSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#structOrUnionSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructOrUnionSpecifier(CParser.StructOrUnionSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#structOrUnion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructOrUnion(CParser.StructOrUnionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#structDeclarationList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructDeclarationList(CParser.StructDeclarationListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#structDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructDeclaration(CParser.StructDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#specifierQualifierList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecifierQualifierList(CParser.SpecifierQualifierListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#structDeclaratorList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructDeclaratorList(CParser.StructDeclaratorListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#structDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructDeclarator(CParser.StructDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#enumSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumSpecifier(CParser.EnumSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#enumeratorList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumeratorList(CParser.EnumeratorListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#enumerator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumerator(CParser.EnumeratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#enumerationConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumerationConstant(CParser.EnumerationConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#typeQualifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeQualifier(CParser.TypeQualifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarator(CParser.DeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variableDeclarator}
	 * labeled alternative in {@link CParser#directDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarator(CParser.VariableDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayDeclarator}
	 * labeled alternative in {@link CParser#directDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayDeclarator(CParser.ArrayDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionDeclarator}
	 * labeled alternative in {@link CParser#directDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclarator(CParser.FunctionDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#nestedParenthesesBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNestedParenthesesBlock(CParser.NestedParenthesesBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#pointer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPointer(CParser.PointerContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#typeQualifierList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeQualifierList(CParser.TypeQualifierListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#parameterTypeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterTypeList(CParser.ParameterTypeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(CParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterDeclaration(CParser.ParameterDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#identifierList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierList(CParser.IdentifierListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#typeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeName(CParser.TypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#abstractDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbstractDeclarator(CParser.AbstractDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#directAbstractDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirectAbstractDeclarator(CParser.DirectAbstractDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#typedefName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypedefName(CParser.TypedefNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#initializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializer(CParser.InitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#initializerList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializerList(CParser.InitializerListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#designation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDesignation(CParser.DesignationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#designatorList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDesignatorList(CParser.DesignatorListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#designator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDesignator(CParser.DesignatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(CParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#labeledStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabeledStatement(CParser.LabeledStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#compoundStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundStatement(CParser.CompoundStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#blockItemList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockItemList(CParser.BlockItemListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#blockItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockItem(CParser.BlockItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(CParser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#selectionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectionStatement(CParser.SelectionStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code iterationWhileStatement_}
	 * labeled alternative in {@link CParser#iterationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterationWhileStatement_(CParser.IterationWhileStatement_Context ctx);
	/**
	 * Visit a parse tree produced by the {@code iterationDoStatement_}
	 * labeled alternative in {@link CParser#iterationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterationDoStatement_(CParser.IterationDoStatement_Context ctx);
	/**
	 * Visit a parse tree produced by the {@code iterationDeclaredStatement_}
	 * labeled alternative in {@link CParser#iterationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterationDeclaredStatement_(CParser.IterationDeclaredStatement_Context ctx);
	/**
	 * Visit a parse tree produced by the {@code iterationStatement_}
	 * labeled alternative in {@link CParser#iterationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterationStatement_(CParser.IterationStatement_Context ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#forDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForDeclaration(CParser.ForDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#forExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForExpression(CParser.ForExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GotoStatement}
	 * labeled alternative in {@link CParser#jumpStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGotoStatement(CParser.GotoStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ContinueStatement}
	 * labeled alternative in {@link CParser#jumpStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStatement(CParser.ContinueStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BreakStatement}
	 * labeled alternative in {@link CParser#jumpStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStatement(CParser.BreakStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReturnStatement}
	 * labeled alternative in {@link CParser#jumpStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(CParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#compilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompilationUnit(CParser.CompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#translationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTranslationUnit(CParser.TranslationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#externalDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExternalDeclaration(CParser.ExternalDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#functionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefinition(CParser.FunctionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#declarationList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationList(CParser.DeclarationListContext ctx);
}