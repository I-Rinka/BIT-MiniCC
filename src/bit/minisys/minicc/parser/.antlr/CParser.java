// Generated from d:\User\Documents\Code\BIT-MiniCC\src\bit\minisys\minicc\parser\C.g4 by ANTLR 4.8
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, Auto=15, Break=16, Case=17, 
		Char=18, Const=19, Continue=20, Default=21, Do=22, Double=23, Else=24, 
		Enum=25, Extern=26, Float=27, For=28, Goto=29, If=30, Inline=31, Int=32, 
		Long=33, Register=34, Restrict=35, Return=36, Short=37, Signed=38, Sizeof=39, 
		Static=40, Struct=41, Switch=42, Typedef=43, Union=44, Unsigned=45, Void=46, 
		Volatile=47, While=48, Alignas=49, Alignof=50, Atomic=51, Bool=52, Complex=53, 
		Generic=54, Imaginary=55, Noreturn=56, StaticAssert=57, ThreadLocal=58, 
		LeftParen=59, RightParen=60, LeftBracket=61, RightBracket=62, LeftBrace=63, 
		RightBrace=64, Less=65, LessEqual=66, Greater=67, GreaterEqual=68, LeftShift=69, 
		RightShift=70, Plus=71, PlusPlus=72, Minus=73, MinusMinus=74, Star=75, 
		Div=76, Mod=77, And=78, Or=79, AndAnd=80, OrOr=81, Caret=82, Not=83, Tilde=84, 
		Question=85, Colon=86, Semi=87, Comma=88, Assign=89, StarAssign=90, DivAssign=91, 
		ModAssign=92, PlusAssign=93, MinusAssign=94, LeftShiftAssign=95, RightShiftAssign=96, 
		AndAssign=97, XorAssign=98, OrAssign=99, Equal=100, NotEqual=101, Arrow=102, 
		Dot=103, Ellipsis=104, Identifier=105, Constant=106, DigitSequence=107, 
		StringLiteral=108, ComplexDefine=109, IncludeDirective=110, AsmBlock=111, 
		LineAfterPreprocessing=112, LineDirective=113, PragmaDirective=114, Whitespace=115, 
		Newline=116, BlockComment=117, LineComment=118;
	public static final int
		RULE_start = 0, RULE_primaryExpression = 1, RULE_genericSelection = 2, 
		RULE_genericAssocList = 3, RULE_genericAssociation = 4, RULE_postfixExpression = 5, 
		RULE_argumentExpressionList = 6, RULE_unaryExpression = 7, RULE_unaryOperator = 8, 
		RULE_castExpression = 9, RULE_multiplicativeExpression = 10, RULE_additiveExpression = 11, 
		RULE_shiftExpression = 12, RULE_relationalExpression = 13, RULE_equalityExpression = 14, 
		RULE_andExpression = 15, RULE_exclusiveOrExpression = 16, RULE_inclusiveOrExpression = 17, 
		RULE_logicalAndExpression = 18, RULE_logicalOrExpression = 19, RULE_conditionalExpression = 20, 
		RULE_assignmentExpression = 21, RULE_assignmentOperator = 22, RULE_expression = 23, 
		RULE_constantExpression = 24, RULE_declaration = 25, RULE_declarationSpecifiers = 26, 
		RULE_declarationSpecifiers2 = 27, RULE_declarationSpecifier = 28, RULE_initDeclaratorList = 29, 
		RULE_initDeclarator = 30, RULE_storageClassSpecifier = 31, RULE_typeSpecifier = 32, 
		RULE_structOrUnionSpecifier = 33, RULE_structOrUnion = 34, RULE_structDeclarationList = 35, 
		RULE_structDeclaration = 36, RULE_specifierQualifierList = 37, RULE_structDeclaratorList = 38, 
		RULE_structDeclarator = 39, RULE_enumSpecifier = 40, RULE_enumeratorList = 41, 
		RULE_enumerator = 42, RULE_enumerationConstant = 43, RULE_atomicTypeSpecifier = 44, 
		RULE_typeQualifier = 45, RULE_functionSpecifier = 46, RULE_alignmentSpecifier = 47, 
		RULE_declarator = 48, RULE_directDeclarator = 49, RULE_gccDeclaratorExtension = 50, 
		RULE_gccAttributeSpecifier = 51, RULE_gccAttributeList = 52, RULE_gccAttribute = 53, 
		RULE_nestedParenthesesBlock = 54, RULE_pointer = 55, RULE_typeQualifierList = 56, 
		RULE_parameterTypeList = 57, RULE_parameterList = 58, RULE_parameterDeclaration = 59, 
		RULE_identifierList = 60, RULE_typeName = 61, RULE_abstractDeclarator = 62, 
		RULE_directAbstractDeclarator = 63, RULE_typedefName = 64, RULE_initializer = 65, 
		RULE_initializerList = 66, RULE_designation = 67, RULE_designatorList = 68, 
		RULE_designator = 69, RULE_staticAssertDeclaration = 70, RULE_statement = 71, 
		RULE_labeledStatement = 72, RULE_compoundStatement = 73, RULE_blockItemList = 74, 
		RULE_blockItem = 75, RULE_expressionStatement = 76, RULE_selectionStatement = 77, 
		RULE_iterationStatement = 78, RULE_forCondition = 79, RULE_forDeclaration = 80, 
		RULE_forExpression = 81, RULE_jumpStatement = 82, RULE_compilationUnit = 83, 
		RULE_translationUnit = 84, RULE_externalDeclaration = 85, RULE_functionDefinition = 86, 
		RULE_declarationList = 87;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "primaryExpression", "genericSelection", "genericAssocList", 
			"genericAssociation", "postfixExpression", "argumentExpressionList", 
			"unaryExpression", "unaryOperator", "castExpression", "multiplicativeExpression", 
			"additiveExpression", "shiftExpression", "relationalExpression", "equalityExpression", 
			"andExpression", "exclusiveOrExpression", "inclusiveOrExpression", "logicalAndExpression", 
			"logicalOrExpression", "conditionalExpression", "assignmentExpression", 
			"assignmentOperator", "expression", "constantExpression", "declaration", 
			"declarationSpecifiers", "declarationSpecifiers2", "declarationSpecifier", 
			"initDeclaratorList", "initDeclarator", "storageClassSpecifier", "typeSpecifier", 
			"structOrUnionSpecifier", "structOrUnion", "structDeclarationList", "structDeclaration", 
			"specifierQualifierList", "structDeclaratorList", "structDeclarator", 
			"enumSpecifier", "enumeratorList", "enumerator", "enumerationConstant", 
			"atomicTypeSpecifier", "typeQualifier", "functionSpecifier", "alignmentSpecifier", 
			"declarator", "directDeclarator", "gccDeclaratorExtension", "gccAttributeSpecifier", 
			"gccAttributeList", "gccAttribute", "nestedParenthesesBlock", "pointer", 
			"typeQualifierList", "parameterTypeList", "parameterList", "parameterDeclaration", 
			"identifierList", "typeName", "abstractDeclarator", "directAbstractDeclarator", 
			"typedefName", "initializer", "initializerList", "designation", "designatorList", 
			"designator", "staticAssertDeclaration", "statement", "labeledStatement", 
			"compoundStatement", "blockItemList", "blockItem", "expressionStatement", 
			"selectionStatement", "iterationStatement", "forCondition", "forDeclaration", 
			"forExpression", "jumpStatement", "compilationUnit", "translationUnit", 
			"externalDeclaration", "functionDefinition", "declarationList"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'__extension__'", "'__builtin_va_arg'", "'__builtin_offsetof'", 
			"'__m128'", "'__m128d'", "'__m128i'", "'__typeof__'", "'__inline__'", 
			"'__stdcall'", "'__declspec'", "'__asm'", "'__attribute__'", "'__asm__'", 
			"'__volatile__'", "'auto'", "'break'", "'case'", "'char'", "'const'", 
			"'continue'", "'default'", "'do'", "'double'", "'else'", "'enum'", "'extern'", 
			"'float'", "'for'", "'goto'", "'if'", "'inline'", "'int'", "'long'", 
			"'register'", "'restrict'", "'return'", "'short'", "'signed'", "'sizeof'", 
			"'static'", "'struct'", "'switch'", "'typedef'", "'union'", "'unsigned'", 
			"'void'", "'volatile'", "'while'", "'_Alignas'", "'_Alignof'", "'_Atomic'", 
			"'_Bool'", "'_Complex'", "'_Generic'", "'_Imaginary'", "'_Noreturn'", 
			"'_Static_assert'", "'_Thread_local'", "'('", "')'", "'['", "']'", "'{'", 
			"'}'", "'<'", "'<='", "'>'", "'>='", "'<<'", "'>>'", "'+'", "'++'", "'-'", 
			"'--'", "'*'", "'/'", "'%'", "'&'", "'|'", "'&&'", "'||'", "'^'", "'!'", 
			"'~'", "'?'", "':'", "';'", "','", "'='", "'*='", "'/='", "'%='", "'+='", 
			"'-='", "'<<='", "'>>='", "'&='", "'^='", "'|='", "'=='", "'!='", "'->'", 
			"'.'", "'...'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "Auto", "Break", "Case", "Char", "Const", "Continue", 
			"Default", "Do", "Double", "Else", "Enum", "Extern", "Float", "For", 
			"Goto", "If", "Inline", "Int", "Long", "Register", "Restrict", "Return", 
			"Short", "Signed", "Sizeof", "Static", "Struct", "Switch", "Typedef", 
			"Union", "Unsigned", "Void", "Volatile", "While", "Alignas", "Alignof", 
			"Atomic", "Bool", "Complex", "Generic", "Imaginary", "Noreturn", "StaticAssert", 
			"ThreadLocal", "LeftParen", "RightParen", "LeftBracket", "RightBracket", 
			"LeftBrace", "RightBrace", "Less", "LessEqual", "Greater", "GreaterEqual", 
			"LeftShift", "RightShift", "Plus", "PlusPlus", "Minus", "MinusMinus", 
			"Star", "Div", "Mod", "And", "Or", "AndAnd", "OrOr", "Caret", "Not", 
			"Tilde", "Question", "Colon", "Semi", "Comma", "Assign", "StarAssign", 
			"DivAssign", "ModAssign", "PlusAssign", "MinusAssign", "LeftShiftAssign", 
			"RightShiftAssign", "AndAssign", "XorAssign", "OrAssign", "Equal", "NotEqual", 
			"Arrow", "Dot", "Ellipsis", "Identifier", "Constant", "DigitSequence", 
			"StringLiteral", "ComplexDefine", "IncludeDirective", "AsmBlock", "LineAfterPreprocessing", 
			"LineDirective", "PragmaDirective", "Whitespace", "Newline", "BlockComment", 
			"LineComment"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "C.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public TranslationUnitContext translationUnit() {
			return getRuleContext(TranslationUnitContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			translationUnit(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryExpressionContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(CParser.Identifier, 0); }
		public TerminalNode Constant() { return getToken(CParser.Constant, 0); }
		public List<TerminalNode> StringLiteral() { return getTokens(CParser.StringLiteral); }
		public TerminalNode StringLiteral(int i) {
			return getToken(CParser.StringLiteral, i);
		}
		public TerminalNode LeftParen() { return getToken(CParser.LeftParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CParser.RightParen, 0); }
		public GenericSelectionContext genericSelection() {
			return getRuleContext(GenericSelectionContext.class,0);
		}
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public TerminalNode Comma() { return getToken(CParser.Comma, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public PrimaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpression; }
	}

	public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
		PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_primaryExpression);
		int _la;
		try {
			int _alt;
			setState(211);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(178);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(179);
				match(Constant);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(181); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(180);
						match(StringLiteral);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(183); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(185);
				match(LeftParen);
				setState(186);
				expression(0);
				setState(187);
				match(RightParen);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(189);
				genericSelection();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(190);
					match(T__0);
					}
				}

				setState(193);
				match(LeftParen);
				setState(194);
				compoundStatement();
				setState(195);
				match(RightParen);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(197);
				match(T__1);
				setState(198);
				match(LeftParen);
				setState(199);
				unaryExpression();
				setState(200);
				match(Comma);
				setState(201);
				typeName();
				setState(202);
				match(RightParen);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(204);
				match(T__2);
				setState(205);
				match(LeftParen);
				setState(206);
				typeName();
				setState(207);
				match(Comma);
				setState(208);
				unaryExpression();
				setState(209);
				match(RightParen);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GenericSelectionContext extends ParserRuleContext {
		public TerminalNode Generic() { return getToken(CParser.Generic, 0); }
		public TerminalNode LeftParen() { return getToken(CParser.LeftParen, 0); }
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public TerminalNode Comma() { return getToken(CParser.Comma, 0); }
		public GenericAssocListContext genericAssocList() {
			return getRuleContext(GenericAssocListContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CParser.RightParen, 0); }
		public GenericSelectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericSelection; }
	}

	public final GenericSelectionContext genericSelection() throws RecognitionException {
		GenericSelectionContext _localctx = new GenericSelectionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_genericSelection);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			match(Generic);
			setState(214);
			match(LeftParen);
			setState(215);
			assignmentExpression();
			setState(216);
			match(Comma);
			setState(217);
			genericAssocList(0);
			setState(218);
			match(RightParen);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GenericAssocListContext extends ParserRuleContext {
		public GenericAssociationContext genericAssociation() {
			return getRuleContext(GenericAssociationContext.class,0);
		}
		public GenericAssocListContext genericAssocList() {
			return getRuleContext(GenericAssocListContext.class,0);
		}
		public TerminalNode Comma() { return getToken(CParser.Comma, 0); }
		public GenericAssocListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericAssocList; }
	}

	public final GenericAssocListContext genericAssocList() throws RecognitionException {
		return genericAssocList(0);
	}

	private GenericAssocListContext genericAssocList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		GenericAssocListContext _localctx = new GenericAssocListContext(_ctx, _parentState);
		GenericAssocListContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_genericAssocList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(221);
			genericAssociation();
			}
			_ctx.stop = _input.LT(-1);
			setState(228);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new GenericAssocListContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_genericAssocList);
					setState(223);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(224);
					match(Comma);
					setState(225);
					genericAssociation();
					}
					} 
				}
				setState(230);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class GenericAssociationContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode Colon() { return getToken(CParser.Colon, 0); }
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public TerminalNode Default() { return getToken(CParser.Default, 0); }
		public GenericAssociationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericAssociation; }
	}

	public final GenericAssociationContext genericAssociation() throws RecognitionException {
		GenericAssociationContext _localctx = new GenericAssociationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_genericAssociation);
		try {
			setState(238);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__3:
			case T__4:
			case T__5:
			case T__6:
			case Char:
			case Const:
			case Double:
			case Enum:
			case Float:
			case Int:
			case Long:
			case Restrict:
			case Short:
			case Signed:
			case Struct:
			case Union:
			case Unsigned:
			case Void:
			case Volatile:
			case Atomic:
			case Bool:
			case Complex:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(231);
				typeName();
				setState(232);
				match(Colon);
				setState(233);
				assignmentExpression();
				}
				break;
			case Default:
				enterOuterAlt(_localctx, 2);
				{
				setState(235);
				match(Default);
				setState(236);
				match(Colon);
				setState(237);
				assignmentExpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PostfixExpressionContext extends ParserRuleContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(CParser.LeftParen, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CParser.RightParen, 0); }
		public TerminalNode LeftBrace() { return getToken(CParser.LeftBrace, 0); }
		public InitializerListContext initializerList() {
			return getRuleContext(InitializerListContext.class,0);
		}
		public TerminalNode RightBrace() { return getToken(CParser.RightBrace, 0); }
		public TerminalNode Comma() { return getToken(CParser.Comma, 0); }
		public PostfixExpressionContext postfixExpression() {
			return getRuleContext(PostfixExpressionContext.class,0);
		}
		public TerminalNode LeftBracket() { return getToken(CParser.LeftBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightBracket() { return getToken(CParser.RightBracket, 0); }
		public ArgumentExpressionListContext argumentExpressionList() {
			return getRuleContext(ArgumentExpressionListContext.class,0);
		}
		public TerminalNode Dot() { return getToken(CParser.Dot, 0); }
		public TerminalNode Identifier() { return getToken(CParser.Identifier, 0); }
		public TerminalNode Arrow() { return getToken(CParser.Arrow, 0); }
		public TerminalNode PlusPlus() { return getToken(CParser.PlusPlus, 0); }
		public TerminalNode MinusMinus() { return getToken(CParser.MinusMinus, 0); }
		public PostfixExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixExpression; }
	}

	public final PostfixExpressionContext postfixExpression() throws RecognitionException {
		return postfixExpression(0);
	}

	private PostfixExpressionContext postfixExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PostfixExpressionContext _localctx = new PostfixExpressionContext(_ctx, _parentState);
		PostfixExpressionContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_postfixExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(241);
				primaryExpression();
				}
				break;
			case 2:
				{
				setState(242);
				match(LeftParen);
				setState(243);
				typeName();
				setState(244);
				match(RightParen);
				setState(245);
				match(LeftBrace);
				setState(246);
				initializerList(0);
				setState(247);
				match(RightBrace);
				}
				break;
			case 3:
				{
				setState(249);
				match(LeftParen);
				setState(250);
				typeName();
				setState(251);
				match(RightParen);
				setState(252);
				match(LeftBrace);
				setState(253);
				initializerList(0);
				setState(254);
				match(Comma);
				setState(255);
				match(RightBrace);
				}
				break;
			case 4:
				{
				setState(257);
				match(T__0);
				setState(258);
				match(LeftParen);
				setState(259);
				typeName();
				setState(260);
				match(RightParen);
				setState(261);
				match(LeftBrace);
				setState(262);
				initializerList(0);
				setState(263);
				match(RightBrace);
				}
				break;
			case 5:
				{
				setState(265);
				match(T__0);
				setState(266);
				match(LeftParen);
				setState(267);
				typeName();
				setState(268);
				match(RightParen);
				setState(269);
				match(LeftBrace);
				setState(270);
				initializerList(0);
				setState(271);
				match(Comma);
				setState(272);
				match(RightBrace);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(299);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(297);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new PostfixExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfixExpression);
						setState(276);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(277);
						match(LeftBracket);
						setState(278);
						expression(0);
						setState(279);
						match(RightBracket);
						}
						break;
					case 2:
						{
						_localctx = new PostfixExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfixExpression);
						setState(281);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(282);
						match(LeftParen);
						setState(284);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << Sizeof) | (1L << Alignof) | (1L << Generic) | (1L << LeftParen))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (Plus - 71)) | (1L << (PlusPlus - 71)) | (1L << (Minus - 71)) | (1L << (MinusMinus - 71)) | (1L << (Star - 71)) | (1L << (And - 71)) | (1L << (AndAnd - 71)) | (1L << (Not - 71)) | (1L << (Tilde - 71)) | (1L << (Identifier - 71)) | (1L << (Constant - 71)) | (1L << (DigitSequence - 71)) | (1L << (StringLiteral - 71)))) != 0)) {
							{
							setState(283);
							argumentExpressionList(0);
							}
						}

						setState(286);
						match(RightParen);
						}
						break;
					case 3:
						{
						_localctx = new PostfixExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfixExpression);
						setState(287);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(288);
						match(Dot);
						setState(289);
						match(Identifier);
						}
						break;
					case 4:
						{
						_localctx = new PostfixExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfixExpression);
						setState(290);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(291);
						match(Arrow);
						setState(292);
						match(Identifier);
						}
						break;
					case 5:
						{
						_localctx = new PostfixExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfixExpression);
						setState(293);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(294);
						match(PlusPlus);
						}
						break;
					case 6:
						{
						_localctx = new PostfixExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfixExpression);
						setState(295);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(296);
						match(MinusMinus);
						}
						break;
					}
					} 
				}
				setState(301);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ArgumentExpressionListContext extends ParserRuleContext {
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public ArgumentExpressionListContext argumentExpressionList() {
			return getRuleContext(ArgumentExpressionListContext.class,0);
		}
		public TerminalNode Comma() { return getToken(CParser.Comma, 0); }
		public ArgumentExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentExpressionList; }
	}

	public final ArgumentExpressionListContext argumentExpressionList() throws RecognitionException {
		return argumentExpressionList(0);
	}

	private ArgumentExpressionListContext argumentExpressionList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ArgumentExpressionListContext _localctx = new ArgumentExpressionListContext(_ctx, _parentState);
		ArgumentExpressionListContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_argumentExpressionList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(303);
			assignmentExpression();
			}
			_ctx.stop = _input.LT(-1);
			setState(310);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArgumentExpressionListContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_argumentExpressionList);
					setState(305);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(306);
					match(Comma);
					setState(307);
					assignmentExpression();
					}
					} 
				}
				setState(312);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class UnaryExpressionContext extends ParserRuleContext {
		public PostfixExpressionContext postfixExpression() {
			return getRuleContext(PostfixExpressionContext.class,0);
		}
		public TerminalNode PlusPlus() { return getToken(CParser.PlusPlus, 0); }
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public TerminalNode MinusMinus() { return getToken(CParser.MinusMinus, 0); }
		public UnaryOperatorContext unaryOperator() {
			return getRuleContext(UnaryOperatorContext.class,0);
		}
		public CastExpressionContext castExpression() {
			return getRuleContext(CastExpressionContext.class,0);
		}
		public TerminalNode Sizeof() { return getToken(CParser.Sizeof, 0); }
		public TerminalNode LeftParen() { return getToken(CParser.LeftParen, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CParser.RightParen, 0); }
		public TerminalNode Alignof() { return getToken(CParser.Alignof, 0); }
		public TerminalNode AndAnd() { return getToken(CParser.AndAnd, 0); }
		public TerminalNode Identifier() { return getToken(CParser.Identifier, 0); }
		public UnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpression; }
	}

	public final UnaryExpressionContext unaryExpression() throws RecognitionException {
		UnaryExpressionContext _localctx = new UnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_unaryExpression);
		try {
			setState(335);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(313);
				postfixExpression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(314);
				match(PlusPlus);
				setState(315);
				unaryExpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(316);
				match(MinusMinus);
				setState(317);
				unaryExpression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(318);
				unaryOperator();
				setState(319);
				castExpression();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(321);
				match(Sizeof);
				setState(322);
				unaryExpression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(323);
				match(Sizeof);
				setState(324);
				match(LeftParen);
				setState(325);
				typeName();
				setState(326);
				match(RightParen);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(328);
				match(Alignof);
				setState(329);
				match(LeftParen);
				setState(330);
				typeName();
				setState(331);
				match(RightParen);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(333);
				match(AndAnd);
				setState(334);
				match(Identifier);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryOperatorContext extends ParserRuleContext {
		public TerminalNode And() { return getToken(CParser.And, 0); }
		public TerminalNode Star() { return getToken(CParser.Star, 0); }
		public TerminalNode Plus() { return getToken(CParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(CParser.Minus, 0); }
		public TerminalNode Tilde() { return getToken(CParser.Tilde, 0); }
		public TerminalNode Not() { return getToken(CParser.Not, 0); }
		public UnaryOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOperator; }
	}

	public final UnaryOperatorContext unaryOperator() throws RecognitionException {
		UnaryOperatorContext _localctx = new UnaryOperatorContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_unaryOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337);
			_la = _input.LA(1);
			if ( !(((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (Plus - 71)) | (1L << (Minus - 71)) | (1L << (Star - 71)) | (1L << (And - 71)) | (1L << (Not - 71)) | (1L << (Tilde - 71)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CastExpressionContext extends ParserRuleContext {
		public TerminalNode LeftParen() { return getToken(CParser.LeftParen, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CParser.RightParen, 0); }
		public CastExpressionContext castExpression() {
			return getRuleContext(CastExpressionContext.class,0);
		}
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public TerminalNode DigitSequence() { return getToken(CParser.DigitSequence, 0); }
		public CastExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castExpression; }
	}

	public final CastExpressionContext castExpression() throws RecognitionException {
		CastExpressionContext _localctx = new CastExpressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_castExpression);
		try {
			setState(352);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(339);
				match(LeftParen);
				setState(340);
				typeName();
				setState(341);
				match(RightParen);
				setState(342);
				castExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(344);
				match(T__0);
				setState(345);
				match(LeftParen);
				setState(346);
				typeName();
				setState(347);
				match(RightParen);
				setState(348);
				castExpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(350);
				unaryExpression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(351);
				match(DigitSequence);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultiplicativeExpressionContext extends ParserRuleContext {
		public CastExpressionContext castExpression() {
			return getRuleContext(CastExpressionContext.class,0);
		}
		public MultiplicativeExpressionContext multiplicativeExpression() {
			return getRuleContext(MultiplicativeExpressionContext.class,0);
		}
		public TerminalNode Star() { return getToken(CParser.Star, 0); }
		public TerminalNode Div() { return getToken(CParser.Div, 0); }
		public TerminalNode Mod() { return getToken(CParser.Mod, 0); }
		public MultiplicativeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeExpression; }
	}

	public final MultiplicativeExpressionContext multiplicativeExpression() throws RecognitionException {
		return multiplicativeExpression(0);
	}

	private MultiplicativeExpressionContext multiplicativeExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MultiplicativeExpressionContext _localctx = new MultiplicativeExpressionContext(_ctx, _parentState);
		MultiplicativeExpressionContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_multiplicativeExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(355);
			castExpression();
			}
			_ctx.stop = _input.LT(-1);
			setState(368);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(366);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicativeExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicativeExpression);
						setState(357);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(358);
						match(Star);
						setState(359);
						castExpression();
						}
						break;
					case 2:
						{
						_localctx = new MultiplicativeExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicativeExpression);
						setState(360);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(361);
						match(Div);
						setState(362);
						castExpression();
						}
						break;
					case 3:
						{
						_localctx = new MultiplicativeExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicativeExpression);
						setState(363);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(364);
						match(Mod);
						setState(365);
						castExpression();
						}
						break;
					}
					} 
				}
				setState(370);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AdditiveExpressionContext extends ParserRuleContext {
		public MultiplicativeExpressionContext multiplicativeExpression() {
			return getRuleContext(MultiplicativeExpressionContext.class,0);
		}
		public AdditiveExpressionContext additiveExpression() {
			return getRuleContext(AdditiveExpressionContext.class,0);
		}
		public TerminalNode Plus() { return getToken(CParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(CParser.Minus, 0); }
		public AdditiveExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpression; }
	}

	public final AdditiveExpressionContext additiveExpression() throws RecognitionException {
		return additiveExpression(0);
	}

	private AdditiveExpressionContext additiveExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AdditiveExpressionContext _localctx = new AdditiveExpressionContext(_ctx, _parentState);
		AdditiveExpressionContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_additiveExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(372);
			multiplicativeExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(382);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(380);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new AdditiveExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_additiveExpression);
						setState(374);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(375);
						match(Plus);
						setState(376);
						multiplicativeExpression(0);
						}
						break;
					case 2:
						{
						_localctx = new AdditiveExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_additiveExpression);
						setState(377);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(378);
						match(Minus);
						setState(379);
						multiplicativeExpression(0);
						}
						break;
					}
					} 
				}
				setState(384);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ShiftExpressionContext extends ParserRuleContext {
		public AdditiveExpressionContext additiveExpression() {
			return getRuleContext(AdditiveExpressionContext.class,0);
		}
		public ShiftExpressionContext shiftExpression() {
			return getRuleContext(ShiftExpressionContext.class,0);
		}
		public TerminalNode LeftShift() { return getToken(CParser.LeftShift, 0); }
		public TerminalNode RightShift() { return getToken(CParser.RightShift, 0); }
		public ShiftExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shiftExpression; }
	}

	public final ShiftExpressionContext shiftExpression() throws RecognitionException {
		return shiftExpression(0);
	}

	private ShiftExpressionContext shiftExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ShiftExpressionContext _localctx = new ShiftExpressionContext(_ctx, _parentState);
		ShiftExpressionContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_shiftExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(386);
			additiveExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(396);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(394);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						_localctx = new ShiftExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_shiftExpression);
						setState(388);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(389);
						match(LeftShift);
						setState(390);
						additiveExpression(0);
						}
						break;
					case 2:
						{
						_localctx = new ShiftExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_shiftExpression);
						setState(391);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(392);
						match(RightShift);
						setState(393);
						additiveExpression(0);
						}
						break;
					}
					} 
				}
				setState(398);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class RelationalExpressionContext extends ParserRuleContext {
		public ShiftExpressionContext shiftExpression() {
			return getRuleContext(ShiftExpressionContext.class,0);
		}
		public RelationalExpressionContext relationalExpression() {
			return getRuleContext(RelationalExpressionContext.class,0);
		}
		public TerminalNode Less() { return getToken(CParser.Less, 0); }
		public TerminalNode Greater() { return getToken(CParser.Greater, 0); }
		public TerminalNode LessEqual() { return getToken(CParser.LessEqual, 0); }
		public TerminalNode GreaterEqual() { return getToken(CParser.GreaterEqual, 0); }
		public RelationalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalExpression; }
	}

	public final RelationalExpressionContext relationalExpression() throws RecognitionException {
		return relationalExpression(0);
	}

	private RelationalExpressionContext relationalExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RelationalExpressionContext _localctx = new RelationalExpressionContext(_ctx, _parentState);
		RelationalExpressionContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_relationalExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(400);
			shiftExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(416);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(414);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new RelationalExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relationalExpression);
						setState(402);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(403);
						match(Less);
						setState(404);
						shiftExpression(0);
						}
						break;
					case 2:
						{
						_localctx = new RelationalExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relationalExpression);
						setState(405);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(406);
						match(Greater);
						setState(407);
						shiftExpression(0);
						}
						break;
					case 3:
						{
						_localctx = new RelationalExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relationalExpression);
						setState(408);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(409);
						match(LessEqual);
						setState(410);
						shiftExpression(0);
						}
						break;
					case 4:
						{
						_localctx = new RelationalExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relationalExpression);
						setState(411);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(412);
						match(GreaterEqual);
						setState(413);
						shiftExpression(0);
						}
						break;
					}
					} 
				}
				setState(418);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class EqualityExpressionContext extends ParserRuleContext {
		public RelationalExpressionContext relationalExpression() {
			return getRuleContext(RelationalExpressionContext.class,0);
		}
		public EqualityExpressionContext equalityExpression() {
			return getRuleContext(EqualityExpressionContext.class,0);
		}
		public TerminalNode Equal() { return getToken(CParser.Equal, 0); }
		public TerminalNode NotEqual() { return getToken(CParser.NotEqual, 0); }
		public EqualityExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityExpression; }
	}

	public final EqualityExpressionContext equalityExpression() throws RecognitionException {
		return equalityExpression(0);
	}

	private EqualityExpressionContext equalityExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EqualityExpressionContext _localctx = new EqualityExpressionContext(_ctx, _parentState);
		EqualityExpressionContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_equalityExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(420);
			relationalExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(430);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(428);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new EqualityExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_equalityExpression);
						setState(422);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(423);
						match(Equal);
						setState(424);
						relationalExpression(0);
						}
						break;
					case 2:
						{
						_localctx = new EqualityExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_equalityExpression);
						setState(425);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(426);
						match(NotEqual);
						setState(427);
						relationalExpression(0);
						}
						break;
					}
					} 
				}
				setState(432);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AndExpressionContext extends ParserRuleContext {
		public EqualityExpressionContext equalityExpression() {
			return getRuleContext(EqualityExpressionContext.class,0);
		}
		public AndExpressionContext andExpression() {
			return getRuleContext(AndExpressionContext.class,0);
		}
		public TerminalNode And() { return getToken(CParser.And, 0); }
		public AndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpression; }
	}

	public final AndExpressionContext andExpression() throws RecognitionException {
		return andExpression(0);
	}

	private AndExpressionContext andExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AndExpressionContext _localctx = new AndExpressionContext(_ctx, _parentState);
		AndExpressionContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_andExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(434);
			equalityExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(441);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AndExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_andExpression);
					setState(436);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(437);
					match(And);
					setState(438);
					equalityExpression(0);
					}
					} 
				}
				setState(443);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExclusiveOrExpressionContext extends ParserRuleContext {
		public AndExpressionContext andExpression() {
			return getRuleContext(AndExpressionContext.class,0);
		}
		public ExclusiveOrExpressionContext exclusiveOrExpression() {
			return getRuleContext(ExclusiveOrExpressionContext.class,0);
		}
		public TerminalNode Caret() { return getToken(CParser.Caret, 0); }
		public ExclusiveOrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exclusiveOrExpression; }
	}

	public final ExclusiveOrExpressionContext exclusiveOrExpression() throws RecognitionException {
		return exclusiveOrExpression(0);
	}

	private ExclusiveOrExpressionContext exclusiveOrExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExclusiveOrExpressionContext _localctx = new ExclusiveOrExpressionContext(_ctx, _parentState);
		ExclusiveOrExpressionContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_exclusiveOrExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(445);
			andExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(452);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExclusiveOrExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_exclusiveOrExpression);
					setState(447);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(448);
					match(Caret);
					setState(449);
					andExpression(0);
					}
					} 
				}
				setState(454);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class InclusiveOrExpressionContext extends ParserRuleContext {
		public ExclusiveOrExpressionContext exclusiveOrExpression() {
			return getRuleContext(ExclusiveOrExpressionContext.class,0);
		}
		public InclusiveOrExpressionContext inclusiveOrExpression() {
			return getRuleContext(InclusiveOrExpressionContext.class,0);
		}
		public TerminalNode Or() { return getToken(CParser.Or, 0); }
		public InclusiveOrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inclusiveOrExpression; }
	}

	public final InclusiveOrExpressionContext inclusiveOrExpression() throws RecognitionException {
		return inclusiveOrExpression(0);
	}

	private InclusiveOrExpressionContext inclusiveOrExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		InclusiveOrExpressionContext _localctx = new InclusiveOrExpressionContext(_ctx, _parentState);
		InclusiveOrExpressionContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_inclusiveOrExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(456);
			exclusiveOrExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(463);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new InclusiveOrExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_inclusiveOrExpression);
					setState(458);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(459);
					match(Or);
					setState(460);
					exclusiveOrExpression(0);
					}
					} 
				}
				setState(465);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class LogicalAndExpressionContext extends ParserRuleContext {
		public InclusiveOrExpressionContext inclusiveOrExpression() {
			return getRuleContext(InclusiveOrExpressionContext.class,0);
		}
		public LogicalAndExpressionContext logicalAndExpression() {
			return getRuleContext(LogicalAndExpressionContext.class,0);
		}
		public TerminalNode AndAnd() { return getToken(CParser.AndAnd, 0); }
		public LogicalAndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalAndExpression; }
	}

	public final LogicalAndExpressionContext logicalAndExpression() throws RecognitionException {
		return logicalAndExpression(0);
	}

	private LogicalAndExpressionContext logicalAndExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LogicalAndExpressionContext _localctx = new LogicalAndExpressionContext(_ctx, _parentState);
		LogicalAndExpressionContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_logicalAndExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(467);
			inclusiveOrExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(474);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LogicalAndExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_logicalAndExpression);
					setState(469);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(470);
					match(AndAnd);
					setState(471);
					inclusiveOrExpression(0);
					}
					} 
				}
				setState(476);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class LogicalOrExpressionContext extends ParserRuleContext {
		public LogicalAndExpressionContext logicalAndExpression() {
			return getRuleContext(LogicalAndExpressionContext.class,0);
		}
		public LogicalOrExpressionContext logicalOrExpression() {
			return getRuleContext(LogicalOrExpressionContext.class,0);
		}
		public TerminalNode OrOr() { return getToken(CParser.OrOr, 0); }
		public LogicalOrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalOrExpression; }
	}

	public final LogicalOrExpressionContext logicalOrExpression() throws RecognitionException {
		return logicalOrExpression(0);
	}

	private LogicalOrExpressionContext logicalOrExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LogicalOrExpressionContext _localctx = new LogicalOrExpressionContext(_ctx, _parentState);
		LogicalOrExpressionContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_logicalOrExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(478);
			logicalAndExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(485);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LogicalOrExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_logicalOrExpression);
					setState(480);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(481);
					match(OrOr);
					setState(482);
					logicalAndExpression(0);
					}
					} 
				}
				setState(487);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ConditionalExpressionContext extends ParserRuleContext {
		public LogicalOrExpressionContext logicalOrExpression() {
			return getRuleContext(LogicalOrExpressionContext.class,0);
		}
		public TerminalNode Question() { return getToken(CParser.Question, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Colon() { return getToken(CParser.Colon, 0); }
		public ConditionalExpressionContext conditionalExpression() {
			return getRuleContext(ConditionalExpressionContext.class,0);
		}
		public ConditionalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalExpression; }
	}

	public final ConditionalExpressionContext conditionalExpression() throws RecognitionException {
		ConditionalExpressionContext _localctx = new ConditionalExpressionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_conditionalExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(488);
			logicalOrExpression(0);
			setState(494);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(489);
				match(Question);
				setState(490);
				expression(0);
				setState(491);
				match(Colon);
				setState(492);
				conditionalExpression();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentExpressionContext extends ParserRuleContext {
		public ConditionalExpressionContext conditionalExpression() {
			return getRuleContext(ConditionalExpressionContext.class,0);
		}
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public AssignmentOperatorContext assignmentOperator() {
			return getRuleContext(AssignmentOperatorContext.class,0);
		}
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public TerminalNode DigitSequence() { return getToken(CParser.DigitSequence, 0); }
		public AssignmentExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentExpression; }
	}

	public final AssignmentExpressionContext assignmentExpression() throws RecognitionException {
		AssignmentExpressionContext _localctx = new AssignmentExpressionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_assignmentExpression);
		try {
			setState(502);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(496);
				conditionalExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(497);
				unaryExpression();
				setState(498);
				assignmentOperator();
				setState(499);
				assignmentExpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(501);
				match(DigitSequence);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentOperatorContext extends ParserRuleContext {
		public TerminalNode Assign() { return getToken(CParser.Assign, 0); }
		public TerminalNode StarAssign() { return getToken(CParser.StarAssign, 0); }
		public TerminalNode DivAssign() { return getToken(CParser.DivAssign, 0); }
		public TerminalNode ModAssign() { return getToken(CParser.ModAssign, 0); }
		public TerminalNode PlusAssign() { return getToken(CParser.PlusAssign, 0); }
		public TerminalNode MinusAssign() { return getToken(CParser.MinusAssign, 0); }
		public TerminalNode LeftShiftAssign() { return getToken(CParser.LeftShiftAssign, 0); }
		public TerminalNode RightShiftAssign() { return getToken(CParser.RightShiftAssign, 0); }
		public TerminalNode AndAssign() { return getToken(CParser.AndAssign, 0); }
		public TerminalNode XorAssign() { return getToken(CParser.XorAssign, 0); }
		public TerminalNode OrAssign() { return getToken(CParser.OrAssign, 0); }
		public AssignmentOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentOperator; }
	}

	public final AssignmentOperatorContext assignmentOperator() throws RecognitionException {
		AssignmentOperatorContext _localctx = new AssignmentOperatorContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_assignmentOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(504);
			_la = _input.LA(1);
			if ( !(((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & ((1L << (Assign - 89)) | (1L << (StarAssign - 89)) | (1L << (DivAssign - 89)) | (1L << (ModAssign - 89)) | (1L << (PlusAssign - 89)) | (1L << (MinusAssign - 89)) | (1L << (LeftShiftAssign - 89)) | (1L << (RightShiftAssign - 89)) | (1L << (AndAssign - 89)) | (1L << (XorAssign - 89)) | (1L << (OrAssign - 89)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Comma() { return getToken(CParser.Comma, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(507);
			assignmentExpression();
			}
			_ctx.stop = _input.LT(-1);
			setState(514);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expression);
					setState(509);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(510);
					match(Comma);
					setState(511);
					assignmentExpression();
					}
					} 
				}
				setState(516);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ConstantExpressionContext extends ParserRuleContext {
		public ConditionalExpressionContext conditionalExpression() {
			return getRuleContext(ConditionalExpressionContext.class,0);
		}
		public ConstantExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantExpression; }
	}

	public final ConstantExpressionContext constantExpression() throws RecognitionException {
		ConstantExpressionContext _localctx = new ConstantExpressionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_constantExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(517);
			conditionalExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public DeclarationSpecifiersContext declarationSpecifiers() {
			return getRuleContext(DeclarationSpecifiersContext.class,0);
		}
		public InitDeclaratorListContext initDeclaratorList() {
			return getRuleContext(InitDeclaratorListContext.class,0);
		}
		public TerminalNode Semi() { return getToken(CParser.Semi, 0); }
		public StaticAssertDeclarationContext staticAssertDeclaration() {
			return getRuleContext(StaticAssertDeclarationContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_declaration);
		try {
			setState(527);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(519);
				declarationSpecifiers();
				setState(520);
				initDeclaratorList(0);
				setState(521);
				match(Semi);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(523);
				declarationSpecifiers();
				setState(524);
				match(Semi);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(526);
				staticAssertDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationSpecifiersContext extends ParserRuleContext {
		public List<DeclarationSpecifierContext> declarationSpecifier() {
			return getRuleContexts(DeclarationSpecifierContext.class);
		}
		public DeclarationSpecifierContext declarationSpecifier(int i) {
			return getRuleContext(DeclarationSpecifierContext.class,i);
		}
		public DeclarationSpecifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationSpecifiers; }
	}

	public final DeclarationSpecifiersContext declarationSpecifiers() throws RecognitionException {
		DeclarationSpecifiersContext _localctx = new DeclarationSpecifiersContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_declarationSpecifiers);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(530); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(529);
					declarationSpecifier();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(532); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationSpecifiers2Context extends ParserRuleContext {
		public List<DeclarationSpecifierContext> declarationSpecifier() {
			return getRuleContexts(DeclarationSpecifierContext.class);
		}
		public DeclarationSpecifierContext declarationSpecifier(int i) {
			return getRuleContext(DeclarationSpecifierContext.class,i);
		}
		public DeclarationSpecifiers2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationSpecifiers2; }
	}

	public final DeclarationSpecifiers2Context declarationSpecifiers2() throws RecognitionException {
		DeclarationSpecifiers2Context _localctx = new DeclarationSpecifiers2Context(_ctx, getState());
		enterRule(_localctx, 54, RULE_declarationSpecifiers2);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(535); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(534);
					declarationSpecifier();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(537); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationSpecifierContext extends ParserRuleContext {
		public StorageClassSpecifierContext storageClassSpecifier() {
			return getRuleContext(StorageClassSpecifierContext.class,0);
		}
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public TypeQualifierContext typeQualifier() {
			return getRuleContext(TypeQualifierContext.class,0);
		}
		public FunctionSpecifierContext functionSpecifier() {
			return getRuleContext(FunctionSpecifierContext.class,0);
		}
		public AlignmentSpecifierContext alignmentSpecifier() {
			return getRuleContext(AlignmentSpecifierContext.class,0);
		}
		public DeclarationSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationSpecifier; }
	}

	public final DeclarationSpecifierContext declarationSpecifier() throws RecognitionException {
		DeclarationSpecifierContext _localctx = new DeclarationSpecifierContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_declarationSpecifier);
		try {
			setState(544);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(539);
				storageClassSpecifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(540);
				typeSpecifier(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(541);
				typeQualifier();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(542);
				functionSpecifier();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(543);
				alignmentSpecifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitDeclaratorListContext extends ParserRuleContext {
		public InitDeclaratorContext initDeclarator() {
			return getRuleContext(InitDeclaratorContext.class,0);
		}
		public InitDeclaratorListContext initDeclaratorList() {
			return getRuleContext(InitDeclaratorListContext.class,0);
		}
		public TerminalNode Comma() { return getToken(CParser.Comma, 0); }
		public InitDeclaratorListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initDeclaratorList; }
	}

	public final InitDeclaratorListContext initDeclaratorList() throws RecognitionException {
		return initDeclaratorList(0);
	}

	private InitDeclaratorListContext initDeclaratorList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		InitDeclaratorListContext _localctx = new InitDeclaratorListContext(_ctx, _parentState);
		InitDeclaratorListContext _prevctx = _localctx;
		int _startState = 58;
		enterRecursionRule(_localctx, 58, RULE_initDeclaratorList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(547);
			initDeclarator();
			}
			_ctx.stop = _input.LT(-1);
			setState(554);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new InitDeclaratorListContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_initDeclaratorList);
					setState(549);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(550);
					match(Comma);
					setState(551);
					initDeclarator();
					}
					} 
				}
				setState(556);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class InitDeclaratorContext extends ParserRuleContext {
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public TerminalNode Assign() { return getToken(CParser.Assign, 0); }
		public InitializerContext initializer() {
			return getRuleContext(InitializerContext.class,0);
		}
		public InitDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initDeclarator; }
	}

	public final InitDeclaratorContext initDeclarator() throws RecognitionException {
		InitDeclaratorContext _localctx = new InitDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_initDeclarator);
		try {
			setState(562);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(557);
				declarator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(558);
				declarator();
				setState(559);
				match(Assign);
				setState(560);
				initializer();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StorageClassSpecifierContext extends ParserRuleContext {
		public TerminalNode Typedef() { return getToken(CParser.Typedef, 0); }
		public TerminalNode Extern() { return getToken(CParser.Extern, 0); }
		public TerminalNode Static() { return getToken(CParser.Static, 0); }
		public TerminalNode ThreadLocal() { return getToken(CParser.ThreadLocal, 0); }
		public TerminalNode Auto() { return getToken(CParser.Auto, 0); }
		public TerminalNode Register() { return getToken(CParser.Register, 0); }
		public StorageClassSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_storageClassSpecifier; }
	}

	public final StorageClassSpecifierContext storageClassSpecifier() throws RecognitionException {
		StorageClassSpecifierContext _localctx = new StorageClassSpecifierContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_storageClassSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(564);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Auto) | (1L << Extern) | (1L << Register) | (1L << Static) | (1L << Typedef) | (1L << ThreadLocal))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeSpecifierContext extends ParserRuleContext {
		public TerminalNode Void() { return getToken(CParser.Void, 0); }
		public TerminalNode Char() { return getToken(CParser.Char, 0); }
		public TerminalNode Short() { return getToken(CParser.Short, 0); }
		public TerminalNode Int() { return getToken(CParser.Int, 0); }
		public TerminalNode Long() { return getToken(CParser.Long, 0); }
		public TerminalNode Float() { return getToken(CParser.Float, 0); }
		public TerminalNode Double() { return getToken(CParser.Double, 0); }
		public TerminalNode Signed() { return getToken(CParser.Signed, 0); }
		public TerminalNode Unsigned() { return getToken(CParser.Unsigned, 0); }
		public TerminalNode Bool() { return getToken(CParser.Bool, 0); }
		public TerminalNode Complex() { return getToken(CParser.Complex, 0); }
		public TerminalNode LeftParen() { return getToken(CParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(CParser.RightParen, 0); }
		public AtomicTypeSpecifierContext atomicTypeSpecifier() {
			return getRuleContext(AtomicTypeSpecifierContext.class,0);
		}
		public StructOrUnionSpecifierContext structOrUnionSpecifier() {
			return getRuleContext(StructOrUnionSpecifierContext.class,0);
		}
		public EnumSpecifierContext enumSpecifier() {
			return getRuleContext(EnumSpecifierContext.class,0);
		}
		public TypedefNameContext typedefName() {
			return getRuleContext(TypedefNameContext.class,0);
		}
		public ConstantExpressionContext constantExpression() {
			return getRuleContext(ConstantExpressionContext.class,0);
		}
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public PointerContext pointer() {
			return getRuleContext(PointerContext.class,0);
		}
		public TypeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeSpecifier; }
	}

	public final TypeSpecifierContext typeSpecifier() throws RecognitionException {
		return typeSpecifier(0);
	}

	private TypeSpecifierContext typeSpecifier(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeSpecifierContext _localctx = new TypeSpecifierContext(_ctx, _parentState);
		TypeSpecifierContext _prevctx = _localctx;
		int _startState = 64;
		enterRecursionRule(_localctx, 64, RULE_typeSpecifier, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(581);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
			case T__4:
			case T__5:
			case Char:
			case Double:
			case Float:
			case Int:
			case Long:
			case Short:
			case Signed:
			case Unsigned:
			case Void:
			case Bool:
			case Complex:
				{
				setState(567);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << Char) | (1L << Double) | (1L << Float) | (1L << Int) | (1L << Long) | (1L << Short) | (1L << Signed) | (1L << Unsigned) | (1L << Void) | (1L << Bool) | (1L << Complex))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case T__0:
				{
				setState(568);
				match(T__0);
				setState(569);
				match(LeftParen);
				setState(570);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << T__5))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(571);
				match(RightParen);
				}
				break;
			case Atomic:
				{
				setState(572);
				atomicTypeSpecifier();
				}
				break;
			case Struct:
			case Union:
				{
				setState(573);
				structOrUnionSpecifier();
				}
				break;
			case Enum:
				{
				setState(574);
				enumSpecifier();
				}
				break;
			case Identifier:
				{
				setState(575);
				typedefName();
				}
				break;
			case T__6:
				{
				setState(576);
				match(T__6);
				setState(577);
				match(LeftParen);
				setState(578);
				constantExpression();
				setState(579);
				match(RightParen);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(587);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeSpecifierContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_typeSpecifier);
					setState(583);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(584);
					pointer();
					}
					} 
				}
				setState(589);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class StructOrUnionSpecifierContext extends ParserRuleContext {
		public StructOrUnionContext structOrUnion() {
			return getRuleContext(StructOrUnionContext.class,0);
		}
		public TerminalNode LeftBrace() { return getToken(CParser.LeftBrace, 0); }
		public StructDeclarationListContext structDeclarationList() {
			return getRuleContext(StructDeclarationListContext.class,0);
		}
		public TerminalNode RightBrace() { return getToken(CParser.RightBrace, 0); }
		public TerminalNode Identifier() { return getToken(CParser.Identifier, 0); }
		public StructOrUnionSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structOrUnionSpecifier; }
	}

	public final StructOrUnionSpecifierContext structOrUnionSpecifier() throws RecognitionException {
		StructOrUnionSpecifierContext _localctx = new StructOrUnionSpecifierContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_structOrUnionSpecifier);
		int _la;
		try {
			setState(601);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(590);
				structOrUnion();
				setState(592);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(591);
					match(Identifier);
					}
				}

				setState(594);
				match(LeftBrace);
				setState(595);
				structDeclarationList(0);
				setState(596);
				match(RightBrace);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(598);
				structOrUnion();
				setState(599);
				match(Identifier);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StructOrUnionContext extends ParserRuleContext {
		public TerminalNode Struct() { return getToken(CParser.Struct, 0); }
		public TerminalNode Union() { return getToken(CParser.Union, 0); }
		public StructOrUnionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structOrUnion; }
	}

	public final StructOrUnionContext structOrUnion() throws RecognitionException {
		StructOrUnionContext _localctx = new StructOrUnionContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_structOrUnion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(603);
			_la = _input.LA(1);
			if ( !(_la==Struct || _la==Union) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StructDeclarationListContext extends ParserRuleContext {
		public StructDeclarationContext structDeclaration() {
			return getRuleContext(StructDeclarationContext.class,0);
		}
		public StructDeclarationListContext structDeclarationList() {
			return getRuleContext(StructDeclarationListContext.class,0);
		}
		public StructDeclarationListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structDeclarationList; }
	}

	public final StructDeclarationListContext structDeclarationList() throws RecognitionException {
		return structDeclarationList(0);
	}

	private StructDeclarationListContext structDeclarationList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StructDeclarationListContext _localctx = new StructDeclarationListContext(_ctx, _parentState);
		StructDeclarationListContext _prevctx = _localctx;
		int _startState = 70;
		enterRecursionRule(_localctx, 70, RULE_structDeclarationList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(606);
			structDeclaration();
			}
			_ctx.stop = _input.LT(-1);
			setState(612);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StructDeclarationListContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_structDeclarationList);
					setState(608);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(609);
					structDeclaration();
					}
					} 
				}
				setState(614);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class StructDeclarationContext extends ParserRuleContext {
		public SpecifierQualifierListContext specifierQualifierList() {
			return getRuleContext(SpecifierQualifierListContext.class,0);
		}
		public TerminalNode Semi() { return getToken(CParser.Semi, 0); }
		public StructDeclaratorListContext structDeclaratorList() {
			return getRuleContext(StructDeclaratorListContext.class,0);
		}
		public StaticAssertDeclarationContext staticAssertDeclaration() {
			return getRuleContext(StaticAssertDeclarationContext.class,0);
		}
		public StructDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structDeclaration; }
	}

	public final StructDeclarationContext structDeclaration() throws RecognitionException {
		StructDeclarationContext _localctx = new StructDeclarationContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_structDeclaration);
		int _la;
		try {
			setState(622);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__3:
			case T__4:
			case T__5:
			case T__6:
			case Char:
			case Const:
			case Double:
			case Enum:
			case Float:
			case Int:
			case Long:
			case Restrict:
			case Short:
			case Signed:
			case Struct:
			case Union:
			case Unsigned:
			case Void:
			case Volatile:
			case Atomic:
			case Bool:
			case Complex:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(615);
				specifierQualifierList();
				setState(617);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 59)) & ~0x3f) == 0 && ((1L << (_la - 59)) & ((1L << (LeftParen - 59)) | (1L << (Star - 59)) | (1L << (Caret - 59)) | (1L << (Colon - 59)) | (1L << (Identifier - 59)))) != 0)) {
					{
					setState(616);
					structDeclaratorList(0);
					}
				}

				setState(619);
				match(Semi);
				}
				break;
			case StaticAssert:
				enterOuterAlt(_localctx, 2);
				{
				setState(621);
				staticAssertDeclaration();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SpecifierQualifierListContext extends ParserRuleContext {
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public SpecifierQualifierListContext specifierQualifierList() {
			return getRuleContext(SpecifierQualifierListContext.class,0);
		}
		public TypeQualifierContext typeQualifier() {
			return getRuleContext(TypeQualifierContext.class,0);
		}
		public SpecifierQualifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specifierQualifierList; }
	}

	public final SpecifierQualifierListContext specifierQualifierList() throws RecognitionException {
		SpecifierQualifierListContext _localctx = new SpecifierQualifierListContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_specifierQualifierList);
		try {
			setState(632);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(624);
				typeSpecifier(0);
				setState(626);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
				case 1:
					{
					setState(625);
					specifierQualifierList();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(628);
				typeQualifier();
				setState(630);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
				case 1:
					{
					setState(629);
					specifierQualifierList();
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StructDeclaratorListContext extends ParserRuleContext {
		public StructDeclaratorContext structDeclarator() {
			return getRuleContext(StructDeclaratorContext.class,0);
		}
		public StructDeclaratorListContext structDeclaratorList() {
			return getRuleContext(StructDeclaratorListContext.class,0);
		}
		public TerminalNode Comma() { return getToken(CParser.Comma, 0); }
		public StructDeclaratorListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structDeclaratorList; }
	}

	public final StructDeclaratorListContext structDeclaratorList() throws RecognitionException {
		return structDeclaratorList(0);
	}

	private StructDeclaratorListContext structDeclaratorList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StructDeclaratorListContext _localctx = new StructDeclaratorListContext(_ctx, _parentState);
		StructDeclaratorListContext _prevctx = _localctx;
		int _startState = 76;
		enterRecursionRule(_localctx, 76, RULE_structDeclaratorList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(635);
			structDeclarator();
			}
			_ctx.stop = _input.LT(-1);
			setState(642);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StructDeclaratorListContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_structDeclaratorList);
					setState(637);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(638);
					match(Comma);
					setState(639);
					structDeclarator();
					}
					} 
				}
				setState(644);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class StructDeclaratorContext extends ParserRuleContext {
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public TerminalNode Colon() { return getToken(CParser.Colon, 0); }
		public ConstantExpressionContext constantExpression() {
			return getRuleContext(ConstantExpressionContext.class,0);
		}
		public StructDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structDeclarator; }
	}

	public final StructDeclaratorContext structDeclarator() throws RecognitionException {
		StructDeclaratorContext _localctx = new StructDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_structDeclarator);
		int _la;
		try {
			setState(651);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(645);
				declarator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(647);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 59)) & ~0x3f) == 0 && ((1L << (_la - 59)) & ((1L << (LeftParen - 59)) | (1L << (Star - 59)) | (1L << (Caret - 59)) | (1L << (Identifier - 59)))) != 0)) {
					{
					setState(646);
					declarator();
					}
				}

				setState(649);
				match(Colon);
				setState(650);
				constantExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumSpecifierContext extends ParserRuleContext {
		public TerminalNode Enum() { return getToken(CParser.Enum, 0); }
		public TerminalNode LeftBrace() { return getToken(CParser.LeftBrace, 0); }
		public EnumeratorListContext enumeratorList() {
			return getRuleContext(EnumeratorListContext.class,0);
		}
		public TerminalNode RightBrace() { return getToken(CParser.RightBrace, 0); }
		public TerminalNode Identifier() { return getToken(CParser.Identifier, 0); }
		public TerminalNode Comma() { return getToken(CParser.Comma, 0); }
		public EnumSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumSpecifier; }
	}

	public final EnumSpecifierContext enumSpecifier() throws RecognitionException {
		EnumSpecifierContext _localctx = new EnumSpecifierContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_enumSpecifier);
		int _la;
		try {
			setState(672);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(653);
				match(Enum);
				setState(655);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(654);
					match(Identifier);
					}
				}

				setState(657);
				match(LeftBrace);
				setState(658);
				enumeratorList(0);
				setState(659);
				match(RightBrace);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(661);
				match(Enum);
				setState(663);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(662);
					match(Identifier);
					}
				}

				setState(665);
				match(LeftBrace);
				setState(666);
				enumeratorList(0);
				setState(667);
				match(Comma);
				setState(668);
				match(RightBrace);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(670);
				match(Enum);
				setState(671);
				match(Identifier);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumeratorListContext extends ParserRuleContext {
		public EnumeratorContext enumerator() {
			return getRuleContext(EnumeratorContext.class,0);
		}
		public EnumeratorListContext enumeratorList() {
			return getRuleContext(EnumeratorListContext.class,0);
		}
		public TerminalNode Comma() { return getToken(CParser.Comma, 0); }
		public EnumeratorListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumeratorList; }
	}

	public final EnumeratorListContext enumeratorList() throws RecognitionException {
		return enumeratorList(0);
	}

	private EnumeratorListContext enumeratorList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EnumeratorListContext _localctx = new EnumeratorListContext(_ctx, _parentState);
		EnumeratorListContext _prevctx = _localctx;
		int _startState = 82;
		enterRecursionRule(_localctx, 82, RULE_enumeratorList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(675);
			enumerator();
			}
			_ctx.stop = _input.LT(-1);
			setState(682);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new EnumeratorListContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_enumeratorList);
					setState(677);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(678);
					match(Comma);
					setState(679);
					enumerator();
					}
					} 
				}
				setState(684);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class EnumeratorContext extends ParserRuleContext {
		public EnumerationConstantContext enumerationConstant() {
			return getRuleContext(EnumerationConstantContext.class,0);
		}
		public TerminalNode Assign() { return getToken(CParser.Assign, 0); }
		public ConstantExpressionContext constantExpression() {
			return getRuleContext(ConstantExpressionContext.class,0);
		}
		public EnumeratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumerator; }
	}

	public final EnumeratorContext enumerator() throws RecognitionException {
		EnumeratorContext _localctx = new EnumeratorContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_enumerator);
		try {
			setState(690);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(685);
				enumerationConstant();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(686);
				enumerationConstant();
				setState(687);
				match(Assign);
				setState(688);
				constantExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumerationConstantContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(CParser.Identifier, 0); }
		public EnumerationConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumerationConstant; }
	}

	public final EnumerationConstantContext enumerationConstant() throws RecognitionException {
		EnumerationConstantContext _localctx = new EnumerationConstantContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_enumerationConstant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(692);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomicTypeSpecifierContext extends ParserRuleContext {
		public TerminalNode Atomic() { return getToken(CParser.Atomic, 0); }
		public TerminalNode LeftParen() { return getToken(CParser.LeftParen, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CParser.RightParen, 0); }
		public AtomicTypeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomicTypeSpecifier; }
	}

	public final AtomicTypeSpecifierContext atomicTypeSpecifier() throws RecognitionException {
		AtomicTypeSpecifierContext _localctx = new AtomicTypeSpecifierContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_atomicTypeSpecifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(694);
			match(Atomic);
			setState(695);
			match(LeftParen);
			setState(696);
			typeName();
			setState(697);
			match(RightParen);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeQualifierContext extends ParserRuleContext {
		public TerminalNode Const() { return getToken(CParser.Const, 0); }
		public TerminalNode Restrict() { return getToken(CParser.Restrict, 0); }
		public TerminalNode Volatile() { return getToken(CParser.Volatile, 0); }
		public TerminalNode Atomic() { return getToken(CParser.Atomic, 0); }
		public TypeQualifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeQualifier; }
	}

	public final TypeQualifierContext typeQualifier() throws RecognitionException {
		TypeQualifierContext _localctx = new TypeQualifierContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_typeQualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(699);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Const) | (1L << Restrict) | (1L << Volatile) | (1L << Atomic))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionSpecifierContext extends ParserRuleContext {
		public TerminalNode Inline() { return getToken(CParser.Inline, 0); }
		public TerminalNode Noreturn() { return getToken(CParser.Noreturn, 0); }
		public GccAttributeSpecifierContext gccAttributeSpecifier() {
			return getRuleContext(GccAttributeSpecifierContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(CParser.LeftParen, 0); }
		public TerminalNode Identifier() { return getToken(CParser.Identifier, 0); }
		public TerminalNode RightParen() { return getToken(CParser.RightParen, 0); }
		public FunctionSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionSpecifier; }
	}

	public final FunctionSpecifierContext functionSpecifier() throws RecognitionException {
		FunctionSpecifierContext _localctx = new FunctionSpecifierContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_functionSpecifier);
		int _la;
		try {
			setState(707);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
			case T__8:
			case Inline:
			case Noreturn:
				enterOuterAlt(_localctx, 1);
				{
				setState(701);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << Inline) | (1L << Noreturn))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 2);
				{
				setState(702);
				gccAttributeSpecifier();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 3);
				{
				setState(703);
				match(T__9);
				setState(704);
				match(LeftParen);
				setState(705);
				match(Identifier);
				setState(706);
				match(RightParen);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AlignmentSpecifierContext extends ParserRuleContext {
		public TerminalNode Alignas() { return getToken(CParser.Alignas, 0); }
		public TerminalNode LeftParen() { return getToken(CParser.LeftParen, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CParser.RightParen, 0); }
		public ConstantExpressionContext constantExpression() {
			return getRuleContext(ConstantExpressionContext.class,0);
		}
		public AlignmentSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alignmentSpecifier; }
	}

	public final AlignmentSpecifierContext alignmentSpecifier() throws RecognitionException {
		AlignmentSpecifierContext _localctx = new AlignmentSpecifierContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_alignmentSpecifier);
		try {
			setState(719);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(709);
				match(Alignas);
				setState(710);
				match(LeftParen);
				setState(711);
				typeName();
				setState(712);
				match(RightParen);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(714);
				match(Alignas);
				setState(715);
				match(LeftParen);
				setState(716);
				constantExpression();
				setState(717);
				match(RightParen);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaratorContext extends ParserRuleContext {
		public DirectDeclaratorContext directDeclarator() {
			return getRuleContext(DirectDeclaratorContext.class,0);
		}
		public PointerContext pointer() {
			return getRuleContext(PointerContext.class,0);
		}
		public List<GccDeclaratorExtensionContext> gccDeclaratorExtension() {
			return getRuleContexts(GccDeclaratorExtensionContext.class);
		}
		public GccDeclaratorExtensionContext gccDeclaratorExtension(int i) {
			return getRuleContext(GccDeclaratorExtensionContext.class,i);
		}
		public DeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarator; }
	}

	public final DeclaratorContext declarator() throws RecognitionException {
		DeclaratorContext _localctx = new DeclaratorContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_declarator);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(722);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Star || _la==Caret) {
				{
				setState(721);
				pointer();
				}
			}

			setState(724);
			directDeclarator(0);
			setState(728);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(725);
					gccDeclaratorExtension();
					}
					} 
				}
				setState(730);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DirectDeclaratorContext extends ParserRuleContext {
		public DirectDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_directDeclarator; }
	 
		public DirectDeclaratorContext() { }
		public void copyFrom(DirectDeclaratorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VariableDeclaratorContext extends DirectDeclaratorContext {
		public TerminalNode Identifier() { return getToken(CParser.Identifier, 0); }
		public TerminalNode LeftParen() { return getToken(CParser.LeftParen, 0); }
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CParser.RightParen, 0); }
		public VariableDeclaratorContext(DirectDeclaratorContext ctx) { copyFrom(ctx); }
	}
	public static class ArrayDeclaratorContext extends DirectDeclaratorContext {
		public DirectDeclaratorContext directDeclarator() {
			return getRuleContext(DirectDeclaratorContext.class,0);
		}
		public TerminalNode LeftBracket() { return getToken(CParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(CParser.RightBracket, 0); }
		public TypeQualifierListContext typeQualifierList() {
			return getRuleContext(TypeQualifierListContext.class,0);
		}
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public TerminalNode Static() { return getToken(CParser.Static, 0); }
		public TerminalNode Star() { return getToken(CParser.Star, 0); }
		public ArrayDeclaratorContext(DirectDeclaratorContext ctx) { copyFrom(ctx); }
	}
	public static class FunctionDeclaratorContext extends DirectDeclaratorContext {
		public DirectDeclaratorContext directDeclarator() {
			return getRuleContext(DirectDeclaratorContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(CParser.LeftParen, 0); }
		public ParameterTypeListContext parameterTypeList() {
			return getRuleContext(ParameterTypeListContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CParser.RightParen, 0); }
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public FunctionDeclaratorContext(DirectDeclaratorContext ctx) { copyFrom(ctx); }
	}

	public final DirectDeclaratorContext directDeclarator() throws RecognitionException {
		return directDeclarator(0);
	}

	private DirectDeclaratorContext directDeclarator(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		DirectDeclaratorContext _localctx = new DirectDeclaratorContext(_ctx, _parentState);
		DirectDeclaratorContext _prevctx = _localctx;
		int _startState = 98;
		enterRecursionRule(_localctx, 98, RULE_directDeclarator, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(737);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				{
				_localctx = new VariableDeclaratorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(732);
				match(Identifier);
				}
				break;
			case LeftParen:
				{
				_localctx = new VariableDeclaratorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(733);
				match(LeftParen);
				setState(734);
				declarator();
				setState(735);
				match(RightParen);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(784);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(782);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
					case 1:
						{
						_localctx = new ArrayDeclaratorContext(new DirectDeclaratorContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_directDeclarator);
						setState(739);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(740);
						match(LeftBracket);
						setState(742);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Const) | (1L << Restrict) | (1L << Volatile) | (1L << Atomic))) != 0)) {
							{
							setState(741);
							typeQualifierList(0);
							}
						}

						setState(745);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << Sizeof) | (1L << Alignof) | (1L << Generic) | (1L << LeftParen))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (Plus - 71)) | (1L << (PlusPlus - 71)) | (1L << (Minus - 71)) | (1L << (MinusMinus - 71)) | (1L << (Star - 71)) | (1L << (And - 71)) | (1L << (AndAnd - 71)) | (1L << (Not - 71)) | (1L << (Tilde - 71)) | (1L << (Identifier - 71)) | (1L << (Constant - 71)) | (1L << (DigitSequence - 71)) | (1L << (StringLiteral - 71)))) != 0)) {
							{
							setState(744);
							assignmentExpression();
							}
						}

						setState(747);
						match(RightBracket);
						}
						break;
					case 2:
						{
						_localctx = new ArrayDeclaratorContext(new DirectDeclaratorContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_directDeclarator);
						setState(748);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(749);
						match(LeftBracket);
						setState(750);
						match(Static);
						setState(752);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Const) | (1L << Restrict) | (1L << Volatile) | (1L << Atomic))) != 0)) {
							{
							setState(751);
							typeQualifierList(0);
							}
						}

						setState(754);
						assignmentExpression();
						setState(755);
						match(RightBracket);
						}
						break;
					case 3:
						{
						_localctx = new ArrayDeclaratorContext(new DirectDeclaratorContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_directDeclarator);
						setState(757);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(758);
						match(LeftBracket);
						setState(759);
						typeQualifierList(0);
						setState(760);
						match(Static);
						setState(761);
						assignmentExpression();
						setState(762);
						match(RightBracket);
						}
						break;
					case 4:
						{
						_localctx = new ArrayDeclaratorContext(new DirectDeclaratorContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_directDeclarator);
						setState(764);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(765);
						match(LeftBracket);
						setState(767);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Const) | (1L << Restrict) | (1L << Volatile) | (1L << Atomic))) != 0)) {
							{
							setState(766);
							typeQualifierList(0);
							}
						}

						setState(769);
						match(Star);
						setState(770);
						match(RightBracket);
						}
						break;
					case 5:
						{
						_localctx = new FunctionDeclaratorContext(new DirectDeclaratorContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_directDeclarator);
						setState(771);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(772);
						match(LeftParen);
						setState(773);
						parameterTypeList();
						setState(774);
						match(RightParen);
						}
						break;
					case 6:
						{
						_localctx = new FunctionDeclaratorContext(new DirectDeclaratorContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_directDeclarator);
						setState(776);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(777);
						match(LeftParen);
						setState(779);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==Identifier) {
							{
							setState(778);
							identifierList(0);
							}
						}

						setState(781);
						match(RightParen);
						}
						break;
					}
					} 
				}
				setState(786);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class GccDeclaratorExtensionContext extends ParserRuleContext {
		public TerminalNode LeftParen() { return getToken(CParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(CParser.RightParen, 0); }
		public List<TerminalNode> StringLiteral() { return getTokens(CParser.StringLiteral); }
		public TerminalNode StringLiteral(int i) {
			return getToken(CParser.StringLiteral, i);
		}
		public GccAttributeSpecifierContext gccAttributeSpecifier() {
			return getRuleContext(GccAttributeSpecifierContext.class,0);
		}
		public GccDeclaratorExtensionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gccDeclaratorExtension; }
	}

	public final GccDeclaratorExtensionContext gccDeclaratorExtension() throws RecognitionException {
		GccDeclaratorExtensionContext _localctx = new GccDeclaratorExtensionContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_gccDeclaratorExtension);
		int _la;
		try {
			setState(796);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
				enterOuterAlt(_localctx, 1);
				{
				setState(787);
				match(T__10);
				setState(788);
				match(LeftParen);
				setState(790); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(789);
					match(StringLiteral);
					}
					}
					setState(792); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==StringLiteral );
				setState(794);
				match(RightParen);
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 2);
				{
				setState(795);
				gccAttributeSpecifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GccAttributeSpecifierContext extends ParserRuleContext {
		public List<TerminalNode> LeftParen() { return getTokens(CParser.LeftParen); }
		public TerminalNode LeftParen(int i) {
			return getToken(CParser.LeftParen, i);
		}
		public GccAttributeListContext gccAttributeList() {
			return getRuleContext(GccAttributeListContext.class,0);
		}
		public List<TerminalNode> RightParen() { return getTokens(CParser.RightParen); }
		public TerminalNode RightParen(int i) {
			return getToken(CParser.RightParen, i);
		}
		public GccAttributeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gccAttributeSpecifier; }
	}

	public final GccAttributeSpecifierContext gccAttributeSpecifier() throws RecognitionException {
		GccAttributeSpecifierContext _localctx = new GccAttributeSpecifierContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_gccAttributeSpecifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(798);
			match(T__11);
			setState(799);
			match(LeftParen);
			setState(800);
			match(LeftParen);
			setState(801);
			gccAttributeList();
			setState(802);
			match(RightParen);
			setState(803);
			match(RightParen);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GccAttributeListContext extends ParserRuleContext {
		public List<GccAttributeContext> gccAttribute() {
			return getRuleContexts(GccAttributeContext.class);
		}
		public GccAttributeContext gccAttribute(int i) {
			return getRuleContext(GccAttributeContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(CParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CParser.Comma, i);
		}
		public GccAttributeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gccAttributeList; }
	}

	public final GccAttributeListContext gccAttributeList() throws RecognitionException {
		GccAttributeListContext _localctx = new GccAttributeListContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_gccAttributeList);
		int _la;
		try {
			setState(814);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(805);
				gccAttribute();
				setState(810);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(806);
					match(Comma);
					setState(807);
					gccAttribute();
					}
					}
					setState(812);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GccAttributeContext extends ParserRuleContext {
		public TerminalNode Comma() { return getToken(CParser.Comma, 0); }
		public List<TerminalNode> LeftParen() { return getTokens(CParser.LeftParen); }
		public TerminalNode LeftParen(int i) {
			return getToken(CParser.LeftParen, i);
		}
		public List<TerminalNode> RightParen() { return getTokens(CParser.RightParen); }
		public TerminalNode RightParen(int i) {
			return getToken(CParser.RightParen, i);
		}
		public ArgumentExpressionListContext argumentExpressionList() {
			return getRuleContext(ArgumentExpressionListContext.class,0);
		}
		public GccAttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gccAttribute; }
	}

	public final GccAttributeContext gccAttribute() throws RecognitionException {
		GccAttributeContext _localctx = new GccAttributeContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_gccAttribute);
		int _la;
		try {
			setState(825);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
			case T__2:
			case T__3:
			case T__4:
			case T__5:
			case T__6:
			case T__7:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case Auto:
			case Break:
			case Case:
			case Char:
			case Const:
			case Continue:
			case Default:
			case Do:
			case Double:
			case Else:
			case Enum:
			case Extern:
			case Float:
			case For:
			case Goto:
			case If:
			case Inline:
			case Int:
			case Long:
			case Register:
			case Restrict:
			case Return:
			case Short:
			case Signed:
			case Sizeof:
			case Static:
			case Struct:
			case Switch:
			case Typedef:
			case Union:
			case Unsigned:
			case Void:
			case Volatile:
			case While:
			case Alignas:
			case Alignof:
			case Atomic:
			case Bool:
			case Complex:
			case Generic:
			case Imaginary:
			case Noreturn:
			case StaticAssert:
			case ThreadLocal:
			case LeftBracket:
			case RightBracket:
			case LeftBrace:
			case RightBrace:
			case Less:
			case LessEqual:
			case Greater:
			case GreaterEqual:
			case LeftShift:
			case RightShift:
			case Plus:
			case PlusPlus:
			case Minus:
			case MinusMinus:
			case Star:
			case Div:
			case Mod:
			case And:
			case Or:
			case AndAnd:
			case OrOr:
			case Caret:
			case Not:
			case Tilde:
			case Question:
			case Colon:
			case Semi:
			case Assign:
			case StarAssign:
			case DivAssign:
			case ModAssign:
			case PlusAssign:
			case MinusAssign:
			case LeftShiftAssign:
			case RightShiftAssign:
			case AndAssign:
			case XorAssign:
			case OrAssign:
			case Equal:
			case NotEqual:
			case Arrow:
			case Dot:
			case Ellipsis:
			case Identifier:
			case Constant:
			case DigitSequence:
			case StringLiteral:
			case ComplexDefine:
			case IncludeDirective:
			case AsmBlock:
			case LineAfterPreprocessing:
			case LineDirective:
			case PragmaDirective:
			case Whitespace:
			case Newline:
			case BlockComment:
			case LineComment:
				enterOuterAlt(_localctx, 1);
				{
				setState(816);
				_la = _input.LA(1);
				if ( _la <= 0 || (((((_la - 59)) & ~0x3f) == 0 && ((1L << (_la - 59)) & ((1L << (LeftParen - 59)) | (1L << (RightParen - 59)) | (1L << (Comma - 59)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(822);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LeftParen) {
					{
					setState(817);
					match(LeftParen);
					setState(819);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << Sizeof) | (1L << Alignof) | (1L << Generic) | (1L << LeftParen))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (Plus - 71)) | (1L << (PlusPlus - 71)) | (1L << (Minus - 71)) | (1L << (MinusMinus - 71)) | (1L << (Star - 71)) | (1L << (And - 71)) | (1L << (AndAnd - 71)) | (1L << (Not - 71)) | (1L << (Tilde - 71)) | (1L << (Identifier - 71)) | (1L << (Constant - 71)) | (1L << (DigitSequence - 71)) | (1L << (StringLiteral - 71)))) != 0)) {
						{
						setState(818);
						argumentExpressionList(0);
						}
					}

					setState(821);
					match(RightParen);
					}
				}

				}
				break;
			case RightParen:
			case Comma:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NestedParenthesesBlockContext extends ParserRuleContext {
		public List<TerminalNode> LeftParen() { return getTokens(CParser.LeftParen); }
		public TerminalNode LeftParen(int i) {
			return getToken(CParser.LeftParen, i);
		}
		public List<NestedParenthesesBlockContext> nestedParenthesesBlock() {
			return getRuleContexts(NestedParenthesesBlockContext.class);
		}
		public NestedParenthesesBlockContext nestedParenthesesBlock(int i) {
			return getRuleContext(NestedParenthesesBlockContext.class,i);
		}
		public List<TerminalNode> RightParen() { return getTokens(CParser.RightParen); }
		public TerminalNode RightParen(int i) {
			return getToken(CParser.RightParen, i);
		}
		public NestedParenthesesBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nestedParenthesesBlock; }
	}

	public final NestedParenthesesBlockContext nestedParenthesesBlock() throws RecognitionException {
		NestedParenthesesBlockContext _localctx = new NestedParenthesesBlockContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_nestedParenthesesBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(834);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << Auto) | (1L << Break) | (1L << Case) | (1L << Char) | (1L << Const) | (1L << Continue) | (1L << Default) | (1L << Do) | (1L << Double) | (1L << Else) | (1L << Enum) | (1L << Extern) | (1L << Float) | (1L << For) | (1L << Goto) | (1L << If) | (1L << Inline) | (1L << Int) | (1L << Long) | (1L << Register) | (1L << Restrict) | (1L << Return) | (1L << Short) | (1L << Signed) | (1L << Sizeof) | (1L << Static) | (1L << Struct) | (1L << Switch) | (1L << Typedef) | (1L << Union) | (1L << Unsigned) | (1L << Void) | (1L << Volatile) | (1L << While) | (1L << Alignas) | (1L << Alignof) | (1L << Atomic) | (1L << Bool) | (1L << Complex) | (1L << Generic) | (1L << Imaginary) | (1L << Noreturn) | (1L << StaticAssert) | (1L << ThreadLocal) | (1L << LeftParen) | (1L << LeftBracket) | (1L << RightBracket) | (1L << LeftBrace))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (RightBrace - 64)) | (1L << (Less - 64)) | (1L << (LessEqual - 64)) | (1L << (Greater - 64)) | (1L << (GreaterEqual - 64)) | (1L << (LeftShift - 64)) | (1L << (RightShift - 64)) | (1L << (Plus - 64)) | (1L << (PlusPlus - 64)) | (1L << (Minus - 64)) | (1L << (MinusMinus - 64)) | (1L << (Star - 64)) | (1L << (Div - 64)) | (1L << (Mod - 64)) | (1L << (And - 64)) | (1L << (Or - 64)) | (1L << (AndAnd - 64)) | (1L << (OrOr - 64)) | (1L << (Caret - 64)) | (1L << (Not - 64)) | (1L << (Tilde - 64)) | (1L << (Question - 64)) | (1L << (Colon - 64)) | (1L << (Semi - 64)) | (1L << (Comma - 64)) | (1L << (Assign - 64)) | (1L << (StarAssign - 64)) | (1L << (DivAssign - 64)) | (1L << (ModAssign - 64)) | (1L << (PlusAssign - 64)) | (1L << (MinusAssign - 64)) | (1L << (LeftShiftAssign - 64)) | (1L << (RightShiftAssign - 64)) | (1L << (AndAssign - 64)) | (1L << (XorAssign - 64)) | (1L << (OrAssign - 64)) | (1L << (Equal - 64)) | (1L << (NotEqual - 64)) | (1L << (Arrow - 64)) | (1L << (Dot - 64)) | (1L << (Ellipsis - 64)) | (1L << (Identifier - 64)) | (1L << (Constant - 64)) | (1L << (DigitSequence - 64)) | (1L << (StringLiteral - 64)) | (1L << (ComplexDefine - 64)) | (1L << (IncludeDirective - 64)) | (1L << (AsmBlock - 64)) | (1L << (LineAfterPreprocessing - 64)) | (1L << (LineDirective - 64)) | (1L << (PragmaDirective - 64)) | (1L << (Whitespace - 64)) | (1L << (Newline - 64)) | (1L << (BlockComment - 64)) | (1L << (LineComment - 64)))) != 0)) {
				{
				setState(832);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
				case T__1:
				case T__2:
				case T__3:
				case T__4:
				case T__5:
				case T__6:
				case T__7:
				case T__8:
				case T__9:
				case T__10:
				case T__11:
				case T__12:
				case T__13:
				case Auto:
				case Break:
				case Case:
				case Char:
				case Const:
				case Continue:
				case Default:
				case Do:
				case Double:
				case Else:
				case Enum:
				case Extern:
				case Float:
				case For:
				case Goto:
				case If:
				case Inline:
				case Int:
				case Long:
				case Register:
				case Restrict:
				case Return:
				case Short:
				case Signed:
				case Sizeof:
				case Static:
				case Struct:
				case Switch:
				case Typedef:
				case Union:
				case Unsigned:
				case Void:
				case Volatile:
				case While:
				case Alignas:
				case Alignof:
				case Atomic:
				case Bool:
				case Complex:
				case Generic:
				case Imaginary:
				case Noreturn:
				case StaticAssert:
				case ThreadLocal:
				case LeftBracket:
				case RightBracket:
				case LeftBrace:
				case RightBrace:
				case Less:
				case LessEqual:
				case Greater:
				case GreaterEqual:
				case LeftShift:
				case RightShift:
				case Plus:
				case PlusPlus:
				case Minus:
				case MinusMinus:
				case Star:
				case Div:
				case Mod:
				case And:
				case Or:
				case AndAnd:
				case OrOr:
				case Caret:
				case Not:
				case Tilde:
				case Question:
				case Colon:
				case Semi:
				case Comma:
				case Assign:
				case StarAssign:
				case DivAssign:
				case ModAssign:
				case PlusAssign:
				case MinusAssign:
				case LeftShiftAssign:
				case RightShiftAssign:
				case AndAssign:
				case XorAssign:
				case OrAssign:
				case Equal:
				case NotEqual:
				case Arrow:
				case Dot:
				case Ellipsis:
				case Identifier:
				case Constant:
				case DigitSequence:
				case StringLiteral:
				case ComplexDefine:
				case IncludeDirective:
				case AsmBlock:
				case LineAfterPreprocessing:
				case LineDirective:
				case PragmaDirective:
				case Whitespace:
				case Newline:
				case BlockComment:
				case LineComment:
					{
					setState(827);
					_la = _input.LA(1);
					if ( _la <= 0 || (_la==LeftParen || _la==RightParen) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				case LeftParen:
					{
					setState(828);
					match(LeftParen);
					setState(829);
					nestedParenthesesBlock();
					setState(830);
					match(RightParen);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(836);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PointerContext extends ParserRuleContext {
		public TerminalNode Star() { return getToken(CParser.Star, 0); }
		public TypeQualifierListContext typeQualifierList() {
			return getRuleContext(TypeQualifierListContext.class,0);
		}
		public PointerContext pointer() {
			return getRuleContext(PointerContext.class,0);
		}
		public TerminalNode Caret() { return getToken(CParser.Caret, 0); }
		public PointerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pointer; }
	}

	public final PointerContext pointer() throws RecognitionException {
		PointerContext _localctx = new PointerContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_pointer);
		int _la;
		try {
			setState(855);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,79,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(837);
				match(Star);
				setState(839);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
				case 1:
					{
					setState(838);
					typeQualifierList(0);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(841);
				match(Star);
				setState(843);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Const) | (1L << Restrict) | (1L << Volatile) | (1L << Atomic))) != 0)) {
					{
					setState(842);
					typeQualifierList(0);
					}
				}

				setState(845);
				pointer();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(846);
				match(Caret);
				setState(848);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
				case 1:
					{
					setState(847);
					typeQualifierList(0);
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(850);
				match(Caret);
				setState(852);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Const) | (1L << Restrict) | (1L << Volatile) | (1L << Atomic))) != 0)) {
					{
					setState(851);
					typeQualifierList(0);
					}
				}

				setState(854);
				pointer();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeQualifierListContext extends ParserRuleContext {
		public TypeQualifierContext typeQualifier() {
			return getRuleContext(TypeQualifierContext.class,0);
		}
		public TypeQualifierListContext typeQualifierList() {
			return getRuleContext(TypeQualifierListContext.class,0);
		}
		public TypeQualifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeQualifierList; }
	}

	public final TypeQualifierListContext typeQualifierList() throws RecognitionException {
		return typeQualifierList(0);
	}

	private TypeQualifierListContext typeQualifierList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeQualifierListContext _localctx = new TypeQualifierListContext(_ctx, _parentState);
		TypeQualifierListContext _prevctx = _localctx;
		int _startState = 112;
		enterRecursionRule(_localctx, 112, RULE_typeQualifierList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(858);
			typeQualifier();
			}
			_ctx.stop = _input.LT(-1);
			setState(864);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,80,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeQualifierListContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_typeQualifierList);
					setState(860);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(861);
					typeQualifier();
					}
					} 
				}
				setState(866);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,80,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ParameterTypeListContext extends ParserRuleContext {
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public TerminalNode Comma() { return getToken(CParser.Comma, 0); }
		public TerminalNode Ellipsis() { return getToken(CParser.Ellipsis, 0); }
		public ParameterTypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterTypeList; }
	}

	public final ParameterTypeListContext parameterTypeList() throws RecognitionException {
		ParameterTypeListContext _localctx = new ParameterTypeListContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_parameterTypeList);
		try {
			setState(872);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,81,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(867);
				parameterList(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(868);
				parameterList(0);
				setState(869);
				match(Comma);
				setState(870);
				match(Ellipsis);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterListContext extends ParserRuleContext {
		public ParameterDeclarationContext parameterDeclaration() {
			return getRuleContext(ParameterDeclarationContext.class,0);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public TerminalNode Comma() { return getToken(CParser.Comma, 0); }
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		return parameterList(0);
	}

	private ParameterListContext parameterList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ParameterListContext _localctx = new ParameterListContext(_ctx, _parentState);
		ParameterListContext _prevctx = _localctx;
		int _startState = 116;
		enterRecursionRule(_localctx, 116, RULE_parameterList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(875);
			parameterDeclaration();
			}
			_ctx.stop = _input.LT(-1);
			setState(882);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,82,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ParameterListContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_parameterList);
					setState(877);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(878);
					match(Comma);
					setState(879);
					parameterDeclaration();
					}
					} 
				}
				setState(884);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,82,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ParameterDeclarationContext extends ParserRuleContext {
		public DeclarationSpecifiersContext declarationSpecifiers() {
			return getRuleContext(DeclarationSpecifiersContext.class,0);
		}
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public DeclarationSpecifiers2Context declarationSpecifiers2() {
			return getRuleContext(DeclarationSpecifiers2Context.class,0);
		}
		public AbstractDeclaratorContext abstractDeclarator() {
			return getRuleContext(AbstractDeclaratorContext.class,0);
		}
		public ParameterDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterDeclaration; }
	}

	public final ParameterDeclarationContext parameterDeclaration() throws RecognitionException {
		ParameterDeclarationContext _localctx = new ParameterDeclarationContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_parameterDeclaration);
		try {
			setState(892);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,84,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(885);
				declarationSpecifiers();
				setState(886);
				declarator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(888);
				declarationSpecifiers2();
				setState(890);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,83,_ctx) ) {
				case 1:
					{
					setState(889);
					abstractDeclarator();
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierListContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(CParser.Identifier, 0); }
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public TerminalNode Comma() { return getToken(CParser.Comma, 0); }
		public IdentifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierList; }
	}

	public final IdentifierListContext identifierList() throws RecognitionException {
		return identifierList(0);
	}

	private IdentifierListContext identifierList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		IdentifierListContext _localctx = new IdentifierListContext(_ctx, _parentState);
		IdentifierListContext _prevctx = _localctx;
		int _startState = 120;
		enterRecursionRule(_localctx, 120, RULE_identifierList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(895);
			match(Identifier);
			}
			_ctx.stop = _input.LT(-1);
			setState(902);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,85,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new IdentifierListContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_identifierList);
					setState(897);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(898);
					match(Comma);
					setState(899);
					match(Identifier);
					}
					} 
				}
				setState(904);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,85,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TypeNameContext extends ParserRuleContext {
		public SpecifierQualifierListContext specifierQualifierList() {
			return getRuleContext(SpecifierQualifierListContext.class,0);
		}
		public AbstractDeclaratorContext abstractDeclarator() {
			return getRuleContext(AbstractDeclaratorContext.class,0);
		}
		public TypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeName; }
	}

	public final TypeNameContext typeName() throws RecognitionException {
		TypeNameContext _localctx = new TypeNameContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_typeName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(905);
			specifierQualifierList();
			setState(907);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 59)) & ~0x3f) == 0 && ((1L << (_la - 59)) & ((1L << (LeftParen - 59)) | (1L << (LeftBracket - 59)) | (1L << (Star - 59)) | (1L << (Caret - 59)))) != 0)) {
				{
				setState(906);
				abstractDeclarator();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AbstractDeclaratorContext extends ParserRuleContext {
		public PointerContext pointer() {
			return getRuleContext(PointerContext.class,0);
		}
		public DirectAbstractDeclaratorContext directAbstractDeclarator() {
			return getRuleContext(DirectAbstractDeclaratorContext.class,0);
		}
		public List<GccDeclaratorExtensionContext> gccDeclaratorExtension() {
			return getRuleContexts(GccDeclaratorExtensionContext.class);
		}
		public GccDeclaratorExtensionContext gccDeclaratorExtension(int i) {
			return getRuleContext(GccDeclaratorExtensionContext.class,i);
		}
		public AbstractDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abstractDeclarator; }
	}

	public final AbstractDeclaratorContext abstractDeclarator() throws RecognitionException {
		AbstractDeclaratorContext _localctx = new AbstractDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_abstractDeclarator);
		int _la;
		try {
			int _alt;
			setState(920);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,89,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(909);
				pointer();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(911);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Star || _la==Caret) {
					{
					setState(910);
					pointer();
					}
				}

				setState(913);
				directAbstractDeclarator(0);
				setState(917);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,88,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(914);
						gccDeclaratorExtension();
						}
						} 
					}
					setState(919);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,88,_ctx);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DirectAbstractDeclaratorContext extends ParserRuleContext {
		public TerminalNode LeftParen() { return getToken(CParser.LeftParen, 0); }
		public AbstractDeclaratorContext abstractDeclarator() {
			return getRuleContext(AbstractDeclaratorContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CParser.RightParen, 0); }
		public List<GccDeclaratorExtensionContext> gccDeclaratorExtension() {
			return getRuleContexts(GccDeclaratorExtensionContext.class);
		}
		public GccDeclaratorExtensionContext gccDeclaratorExtension(int i) {
			return getRuleContext(GccDeclaratorExtensionContext.class,i);
		}
		public TerminalNode LeftBracket() { return getToken(CParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(CParser.RightBracket, 0); }
		public TypeQualifierListContext typeQualifierList() {
			return getRuleContext(TypeQualifierListContext.class,0);
		}
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public TerminalNode Static() { return getToken(CParser.Static, 0); }
		public TerminalNode Star() { return getToken(CParser.Star, 0); }
		public ParameterTypeListContext parameterTypeList() {
			return getRuleContext(ParameterTypeListContext.class,0);
		}
		public DirectAbstractDeclaratorContext directAbstractDeclarator() {
			return getRuleContext(DirectAbstractDeclaratorContext.class,0);
		}
		public DirectAbstractDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_directAbstractDeclarator; }
	}

	public final DirectAbstractDeclaratorContext directAbstractDeclarator() throws RecognitionException {
		return directAbstractDeclarator(0);
	}

	private DirectAbstractDeclaratorContext directAbstractDeclarator(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		DirectAbstractDeclaratorContext _localctx = new DirectAbstractDeclaratorContext(_ctx, _parentState);
		DirectAbstractDeclaratorContext _prevctx = _localctx;
		int _startState = 126;
		enterRecursionRule(_localctx, 126, RULE_directAbstractDeclarator, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(968);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,96,_ctx) ) {
			case 1:
				{
				setState(923);
				match(LeftParen);
				setState(924);
				abstractDeclarator();
				setState(925);
				match(RightParen);
				setState(929);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,90,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(926);
						gccDeclaratorExtension();
						}
						} 
					}
					setState(931);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,90,_ctx);
				}
				}
				break;
			case 2:
				{
				setState(932);
				match(LeftBracket);
				setState(934);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Const) | (1L << Restrict) | (1L << Volatile) | (1L << Atomic))) != 0)) {
					{
					setState(933);
					typeQualifierList(0);
					}
				}

				setState(937);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << Sizeof) | (1L << Alignof) | (1L << Generic) | (1L << LeftParen))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (Plus - 71)) | (1L << (PlusPlus - 71)) | (1L << (Minus - 71)) | (1L << (MinusMinus - 71)) | (1L << (Star - 71)) | (1L << (And - 71)) | (1L << (AndAnd - 71)) | (1L << (Not - 71)) | (1L << (Tilde - 71)) | (1L << (Identifier - 71)) | (1L << (Constant - 71)) | (1L << (DigitSequence - 71)) | (1L << (StringLiteral - 71)))) != 0)) {
					{
					setState(936);
					assignmentExpression();
					}
				}

				setState(939);
				match(RightBracket);
				}
				break;
			case 3:
				{
				setState(940);
				match(LeftBracket);
				setState(941);
				match(Static);
				setState(943);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Const) | (1L << Restrict) | (1L << Volatile) | (1L << Atomic))) != 0)) {
					{
					setState(942);
					typeQualifierList(0);
					}
				}

				setState(945);
				assignmentExpression();
				setState(946);
				match(RightBracket);
				}
				break;
			case 4:
				{
				setState(948);
				match(LeftBracket);
				setState(949);
				typeQualifierList(0);
				setState(950);
				match(Static);
				setState(951);
				assignmentExpression();
				setState(952);
				match(RightBracket);
				}
				break;
			case 5:
				{
				setState(954);
				match(LeftBracket);
				setState(955);
				match(Star);
				setState(956);
				match(RightBracket);
				}
				break;
			case 6:
				{
				setState(957);
				match(LeftParen);
				setState(959);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << Auto) | (1L << Char) | (1L << Const) | (1L << Double) | (1L << Enum) | (1L << Extern) | (1L << Float) | (1L << Inline) | (1L << Int) | (1L << Long) | (1L << Register) | (1L << Restrict) | (1L << Short) | (1L << Signed) | (1L << Static) | (1L << Struct) | (1L << Typedef) | (1L << Union) | (1L << Unsigned) | (1L << Void) | (1L << Volatile) | (1L << Alignas) | (1L << Atomic) | (1L << Bool) | (1L << Complex) | (1L << Noreturn) | (1L << ThreadLocal))) != 0) || _la==Identifier) {
					{
					setState(958);
					parameterTypeList();
					}
				}

				setState(961);
				match(RightParen);
				setState(965);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,95,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(962);
						gccDeclaratorExtension();
						}
						} 
					}
					setState(967);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,95,_ctx);
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1013);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,103,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1011);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,102,_ctx) ) {
					case 1:
						{
						_localctx = new DirectAbstractDeclaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_directAbstractDeclarator);
						setState(970);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(971);
						match(LeftBracket);
						setState(973);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Const) | (1L << Restrict) | (1L << Volatile) | (1L << Atomic))) != 0)) {
							{
							setState(972);
							typeQualifierList(0);
							}
						}

						setState(976);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << Sizeof) | (1L << Alignof) | (1L << Generic) | (1L << LeftParen))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (Plus - 71)) | (1L << (PlusPlus - 71)) | (1L << (Minus - 71)) | (1L << (MinusMinus - 71)) | (1L << (Star - 71)) | (1L << (And - 71)) | (1L << (AndAnd - 71)) | (1L << (Not - 71)) | (1L << (Tilde - 71)) | (1L << (Identifier - 71)) | (1L << (Constant - 71)) | (1L << (DigitSequence - 71)) | (1L << (StringLiteral - 71)))) != 0)) {
							{
							setState(975);
							assignmentExpression();
							}
						}

						setState(978);
						match(RightBracket);
						}
						break;
					case 2:
						{
						_localctx = new DirectAbstractDeclaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_directAbstractDeclarator);
						setState(979);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(980);
						match(LeftBracket);
						setState(981);
						match(Static);
						setState(983);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Const) | (1L << Restrict) | (1L << Volatile) | (1L << Atomic))) != 0)) {
							{
							setState(982);
							typeQualifierList(0);
							}
						}

						setState(985);
						assignmentExpression();
						setState(986);
						match(RightBracket);
						}
						break;
					case 3:
						{
						_localctx = new DirectAbstractDeclaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_directAbstractDeclarator);
						setState(988);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(989);
						match(LeftBracket);
						setState(990);
						typeQualifierList(0);
						setState(991);
						match(Static);
						setState(992);
						assignmentExpression();
						setState(993);
						match(RightBracket);
						}
						break;
					case 4:
						{
						_localctx = new DirectAbstractDeclaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_directAbstractDeclarator);
						setState(995);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(996);
						match(LeftBracket);
						setState(997);
						match(Star);
						setState(998);
						match(RightBracket);
						}
						break;
					case 5:
						{
						_localctx = new DirectAbstractDeclaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_directAbstractDeclarator);
						setState(999);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(1000);
						match(LeftParen);
						setState(1002);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << Auto) | (1L << Char) | (1L << Const) | (1L << Double) | (1L << Enum) | (1L << Extern) | (1L << Float) | (1L << Inline) | (1L << Int) | (1L << Long) | (1L << Register) | (1L << Restrict) | (1L << Short) | (1L << Signed) | (1L << Static) | (1L << Struct) | (1L << Typedef) | (1L << Union) | (1L << Unsigned) | (1L << Void) | (1L << Volatile) | (1L << Alignas) | (1L << Atomic) | (1L << Bool) | (1L << Complex) | (1L << Noreturn) | (1L << ThreadLocal))) != 0) || _la==Identifier) {
							{
							setState(1001);
							parameterTypeList();
							}
						}

						setState(1004);
						match(RightParen);
						setState(1008);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,101,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(1005);
								gccDeclaratorExtension();
								}
								} 
							}
							setState(1010);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,101,_ctx);
						}
						}
						break;
					}
					} 
				}
				setState(1015);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,103,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TypedefNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(CParser.Identifier, 0); }
		public TypedefNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typedefName; }
	}

	public final TypedefNameContext typedefName() throws RecognitionException {
		TypedefNameContext _localctx = new TypedefNameContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_typedefName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1016);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitializerContext extends ParserRuleContext {
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public TerminalNode LeftBrace() { return getToken(CParser.LeftBrace, 0); }
		public InitializerListContext initializerList() {
			return getRuleContext(InitializerListContext.class,0);
		}
		public TerminalNode RightBrace() { return getToken(CParser.RightBrace, 0); }
		public TerminalNode Comma() { return getToken(CParser.Comma, 0); }
		public InitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializer; }
	}

	public final InitializerContext initializer() throws RecognitionException {
		InitializerContext _localctx = new InitializerContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_initializer);
		try {
			setState(1028);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,104,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1018);
				assignmentExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1019);
				match(LeftBrace);
				setState(1020);
				initializerList(0);
				setState(1021);
				match(RightBrace);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1023);
				match(LeftBrace);
				setState(1024);
				initializerList(0);
				setState(1025);
				match(Comma);
				setState(1026);
				match(RightBrace);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitializerListContext extends ParserRuleContext {
		public InitializerContext initializer() {
			return getRuleContext(InitializerContext.class,0);
		}
		public DesignationContext designation() {
			return getRuleContext(DesignationContext.class,0);
		}
		public InitializerListContext initializerList() {
			return getRuleContext(InitializerListContext.class,0);
		}
		public TerminalNode Comma() { return getToken(CParser.Comma, 0); }
		public InitializerListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializerList; }
	}

	public final InitializerListContext initializerList() throws RecognitionException {
		return initializerList(0);
	}

	private InitializerListContext initializerList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		InitializerListContext _localctx = new InitializerListContext(_ctx, _parentState);
		InitializerListContext _prevctx = _localctx;
		int _startState = 132;
		enterRecursionRule(_localctx, 132, RULE_initializerList, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1032);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LeftBracket || _la==Dot) {
				{
				setState(1031);
				designation();
				}
			}

			setState(1034);
			initializer();
			}
			_ctx.stop = _input.LT(-1);
			setState(1044);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,107,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new InitializerListContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_initializerList);
					setState(1036);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(1037);
					match(Comma);
					setState(1039);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==LeftBracket || _la==Dot) {
						{
						setState(1038);
						designation();
						}
					}

					setState(1041);
					initializer();
					}
					} 
				}
				setState(1046);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,107,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class DesignationContext extends ParserRuleContext {
		public DesignatorListContext designatorList() {
			return getRuleContext(DesignatorListContext.class,0);
		}
		public TerminalNode Assign() { return getToken(CParser.Assign, 0); }
		public DesignationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_designation; }
	}

	public final DesignationContext designation() throws RecognitionException {
		DesignationContext _localctx = new DesignationContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_designation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1047);
			designatorList(0);
			setState(1048);
			match(Assign);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DesignatorListContext extends ParserRuleContext {
		public DesignatorContext designator() {
			return getRuleContext(DesignatorContext.class,0);
		}
		public DesignatorListContext designatorList() {
			return getRuleContext(DesignatorListContext.class,0);
		}
		public DesignatorListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_designatorList; }
	}

	public final DesignatorListContext designatorList() throws RecognitionException {
		return designatorList(0);
	}

	private DesignatorListContext designatorList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		DesignatorListContext _localctx = new DesignatorListContext(_ctx, _parentState);
		DesignatorListContext _prevctx = _localctx;
		int _startState = 136;
		enterRecursionRule(_localctx, 136, RULE_designatorList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1051);
			designator();
			}
			_ctx.stop = _input.LT(-1);
			setState(1057);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,108,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new DesignatorListContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_designatorList);
					setState(1053);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(1054);
					designator();
					}
					} 
				}
				setState(1059);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,108,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class DesignatorContext extends ParserRuleContext {
		public TerminalNode LeftBracket() { return getToken(CParser.LeftBracket, 0); }
		public ConstantExpressionContext constantExpression() {
			return getRuleContext(ConstantExpressionContext.class,0);
		}
		public TerminalNode RightBracket() { return getToken(CParser.RightBracket, 0); }
		public TerminalNode Dot() { return getToken(CParser.Dot, 0); }
		public TerminalNode Identifier() { return getToken(CParser.Identifier, 0); }
		public DesignatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_designator; }
	}

	public final DesignatorContext designator() throws RecognitionException {
		DesignatorContext _localctx = new DesignatorContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_designator);
		try {
			setState(1066);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftBracket:
				enterOuterAlt(_localctx, 1);
				{
				setState(1060);
				match(LeftBracket);
				setState(1061);
				constantExpression();
				setState(1062);
				match(RightBracket);
				}
				break;
			case Dot:
				enterOuterAlt(_localctx, 2);
				{
				setState(1064);
				match(Dot);
				setState(1065);
				match(Identifier);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StaticAssertDeclarationContext extends ParserRuleContext {
		public TerminalNode StaticAssert() { return getToken(CParser.StaticAssert, 0); }
		public TerminalNode LeftParen() { return getToken(CParser.LeftParen, 0); }
		public ConstantExpressionContext constantExpression() {
			return getRuleContext(ConstantExpressionContext.class,0);
		}
		public TerminalNode Comma() { return getToken(CParser.Comma, 0); }
		public TerminalNode RightParen() { return getToken(CParser.RightParen, 0); }
		public TerminalNode Semi() { return getToken(CParser.Semi, 0); }
		public List<TerminalNode> StringLiteral() { return getTokens(CParser.StringLiteral); }
		public TerminalNode StringLiteral(int i) {
			return getToken(CParser.StringLiteral, i);
		}
		public StaticAssertDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_staticAssertDeclaration; }
	}

	public final StaticAssertDeclarationContext staticAssertDeclaration() throws RecognitionException {
		StaticAssertDeclarationContext _localctx = new StaticAssertDeclarationContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_staticAssertDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1068);
			match(StaticAssert);
			setState(1069);
			match(LeftParen);
			setState(1070);
			constantExpression();
			setState(1071);
			match(Comma);
			setState(1073); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1072);
				match(StringLiteral);
				}
				}
				setState(1075); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==StringLiteral );
			setState(1077);
			match(RightParen);
			setState(1078);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public LabeledStatementContext labeledStatement() {
			return getRuleContext(LabeledStatementContext.class,0);
		}
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public SelectionStatementContext selectionStatement() {
			return getRuleContext(SelectionStatementContext.class,0);
		}
		public IterationStatementContext iterationStatement() {
			return getRuleContext(IterationStatementContext.class,0);
		}
		public JumpStatementContext jumpStatement() {
			return getRuleContext(JumpStatementContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(CParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(CParser.RightParen, 0); }
		public TerminalNode Semi() { return getToken(CParser.Semi, 0); }
		public TerminalNode Volatile() { return getToken(CParser.Volatile, 0); }
		public List<LogicalOrExpressionContext> logicalOrExpression() {
			return getRuleContexts(LogicalOrExpressionContext.class);
		}
		public LogicalOrExpressionContext logicalOrExpression(int i) {
			return getRuleContext(LogicalOrExpressionContext.class,i);
		}
		public List<TerminalNode> Colon() { return getTokens(CParser.Colon); }
		public TerminalNode Colon(int i) {
			return getToken(CParser.Colon, i);
		}
		public List<TerminalNode> Comma() { return getTokens(CParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CParser.Comma, i);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_statement);
		int _la;
		try {
			setState(1117);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,116,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1080);
				labeledStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1081);
				compoundStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1082);
				expressionStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1083);
				selectionStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1084);
				iterationStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1085);
				jumpStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1086);
				_la = _input.LA(1);
				if ( !(_la==T__10 || _la==T__12) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1087);
				_la = _input.LA(1);
				if ( !(_la==T__13 || _la==Volatile) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1088);
				match(LeftParen);
				setState(1097);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << Sizeof) | (1L << Alignof) | (1L << Generic) | (1L << LeftParen))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (Plus - 71)) | (1L << (PlusPlus - 71)) | (1L << (Minus - 71)) | (1L << (MinusMinus - 71)) | (1L << (Star - 71)) | (1L << (And - 71)) | (1L << (AndAnd - 71)) | (1L << (Not - 71)) | (1L << (Tilde - 71)) | (1L << (Identifier - 71)) | (1L << (Constant - 71)) | (1L << (DigitSequence - 71)) | (1L << (StringLiteral - 71)))) != 0)) {
					{
					setState(1089);
					logicalOrExpression(0);
					setState(1094);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Comma) {
						{
						{
						setState(1090);
						match(Comma);
						setState(1091);
						logicalOrExpression(0);
						}
						}
						setState(1096);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(1112);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Colon) {
					{
					{
					setState(1099);
					match(Colon);
					setState(1108);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << Sizeof) | (1L << Alignof) | (1L << Generic) | (1L << LeftParen))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (Plus - 71)) | (1L << (PlusPlus - 71)) | (1L << (Minus - 71)) | (1L << (MinusMinus - 71)) | (1L << (Star - 71)) | (1L << (And - 71)) | (1L << (AndAnd - 71)) | (1L << (Not - 71)) | (1L << (Tilde - 71)) | (1L << (Identifier - 71)) | (1L << (Constant - 71)) | (1L << (DigitSequence - 71)) | (1L << (StringLiteral - 71)))) != 0)) {
						{
						setState(1100);
						logicalOrExpression(0);
						setState(1105);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==Comma) {
							{
							{
							setState(1101);
							match(Comma);
							setState(1102);
							logicalOrExpression(0);
							}
							}
							setState(1107);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					}
					}
					setState(1114);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1115);
				match(RightParen);
				setState(1116);
				match(Semi);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LabeledStatementContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(CParser.Identifier, 0); }
		public TerminalNode Colon() { return getToken(CParser.Colon, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode Case() { return getToken(CParser.Case, 0); }
		public ConstantExpressionContext constantExpression() {
			return getRuleContext(ConstantExpressionContext.class,0);
		}
		public TerminalNode Default() { return getToken(CParser.Default, 0); }
		public LabeledStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labeledStatement; }
	}

	public final LabeledStatementContext labeledStatement() throws RecognitionException {
		LabeledStatementContext _localctx = new LabeledStatementContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_labeledStatement);
		try {
			setState(1130);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(1119);
				match(Identifier);
				setState(1120);
				match(Colon);
				setState(1121);
				statement();
				}
				break;
			case Case:
				enterOuterAlt(_localctx, 2);
				{
				setState(1122);
				match(Case);
				setState(1123);
				constantExpression();
				setState(1124);
				match(Colon);
				setState(1125);
				statement();
				}
				break;
			case Default:
				enterOuterAlt(_localctx, 3);
				{
				setState(1127);
				match(Default);
				setState(1128);
				match(Colon);
				setState(1129);
				statement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompoundStatementContext extends ParserRuleContext {
		public TerminalNode LeftBrace() { return getToken(CParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(CParser.RightBrace, 0); }
		public BlockItemListContext blockItemList() {
			return getRuleContext(BlockItemListContext.class,0);
		}
		public CompoundStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compoundStatement; }
	}

	public final CompoundStatementContext compoundStatement() throws RecognitionException {
		CompoundStatementContext _localctx = new CompoundStatementContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_compoundStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1132);
			match(LeftBrace);
			setState(1134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << Auto) | (1L << Break) | (1L << Case) | (1L << Char) | (1L << Const) | (1L << Continue) | (1L << Default) | (1L << Do) | (1L << Double) | (1L << Enum) | (1L << Extern) | (1L << Float) | (1L << For) | (1L << Goto) | (1L << If) | (1L << Inline) | (1L << Int) | (1L << Long) | (1L << Register) | (1L << Restrict) | (1L << Return) | (1L << Short) | (1L << Signed) | (1L << Sizeof) | (1L << Static) | (1L << Struct) | (1L << Switch) | (1L << Typedef) | (1L << Union) | (1L << Unsigned) | (1L << Void) | (1L << Volatile) | (1L << While) | (1L << Alignas) | (1L << Alignof) | (1L << Atomic) | (1L << Bool) | (1L << Complex) | (1L << Generic) | (1L << Noreturn) | (1L << StaticAssert) | (1L << ThreadLocal) | (1L << LeftParen) | (1L << LeftBrace))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (Plus - 71)) | (1L << (PlusPlus - 71)) | (1L << (Minus - 71)) | (1L << (MinusMinus - 71)) | (1L << (Star - 71)) | (1L << (And - 71)) | (1L << (AndAnd - 71)) | (1L << (Not - 71)) | (1L << (Tilde - 71)) | (1L << (Semi - 71)) | (1L << (Identifier - 71)) | (1L << (Constant - 71)) | (1L << (DigitSequence - 71)) | (1L << (StringLiteral - 71)))) != 0)) {
				{
				setState(1133);
				blockItemList(0);
				}
			}

			setState(1136);
			match(RightBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockItemListContext extends ParserRuleContext {
		public BlockItemContext blockItem() {
			return getRuleContext(BlockItemContext.class,0);
		}
		public BlockItemListContext blockItemList() {
			return getRuleContext(BlockItemListContext.class,0);
		}
		public BlockItemListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockItemList; }
	}

	public final BlockItemListContext blockItemList() throws RecognitionException {
		return blockItemList(0);
	}

	private BlockItemListContext blockItemList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BlockItemListContext _localctx = new BlockItemListContext(_ctx, _parentState);
		BlockItemListContext _prevctx = _localctx;
		int _startState = 148;
		enterRecursionRule(_localctx, 148, RULE_blockItemList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1139);
			blockItem();
			}
			_ctx.stop = _input.LT(-1);
			setState(1145);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,119,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new BlockItemListContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_blockItemList);
					setState(1141);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(1142);
					blockItem();
					}
					} 
				}
				setState(1147);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,119,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BlockItemContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public BlockItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockItem; }
	}

	public final BlockItemContext blockItem() throws RecognitionException {
		BlockItemContext _localctx = new BlockItemContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_blockItem);
		try {
			setState(1150);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,120,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1148);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1149);
				declaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionStatementContext extends ParserRuleContext {
		public TerminalNode Semi() { return getToken(CParser.Semi, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatement; }
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_expressionStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << Sizeof) | (1L << Alignof) | (1L << Generic) | (1L << LeftParen))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (Plus - 71)) | (1L << (PlusPlus - 71)) | (1L << (Minus - 71)) | (1L << (MinusMinus - 71)) | (1L << (Star - 71)) | (1L << (And - 71)) | (1L << (AndAnd - 71)) | (1L << (Not - 71)) | (1L << (Tilde - 71)) | (1L << (Identifier - 71)) | (1L << (Constant - 71)) | (1L << (DigitSequence - 71)) | (1L << (StringLiteral - 71)))) != 0)) {
				{
				setState(1152);
				expression(0);
				}
			}

			setState(1155);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectionStatementContext extends ParserRuleContext {
		public TerminalNode If() { return getToken(CParser.If, 0); }
		public TerminalNode LeftParen() { return getToken(CParser.LeftParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CParser.RightParen, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode Else() { return getToken(CParser.Else, 0); }
		public TerminalNode Switch() { return getToken(CParser.Switch, 0); }
		public SelectionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectionStatement; }
	}

	public final SelectionStatementContext selectionStatement() throws RecognitionException {
		SelectionStatementContext _localctx = new SelectionStatementContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_selectionStatement);
		try {
			setState(1172);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case If:
				enterOuterAlt(_localctx, 1);
				{
				setState(1157);
				match(If);
				setState(1158);
				match(LeftParen);
				setState(1159);
				expression(0);
				setState(1160);
				match(RightParen);
				setState(1161);
				statement();
				setState(1164);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,122,_ctx) ) {
				case 1:
					{
					setState(1162);
					match(Else);
					setState(1163);
					statement();
					}
					break;
				}
				}
				break;
			case Switch:
				enterOuterAlt(_localctx, 2);
				{
				setState(1166);
				match(Switch);
				setState(1167);
				match(LeftParen);
				setState(1168);
				expression(0);
				setState(1169);
				match(RightParen);
				setState(1170);
				statement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IterationStatementContext extends ParserRuleContext {
		public TerminalNode While() { return getToken(CParser.While, 0); }
		public TerminalNode LeftParen() { return getToken(CParser.LeftParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CParser.RightParen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode Do() { return getToken(CParser.Do, 0); }
		public TerminalNode Semi() { return getToken(CParser.Semi, 0); }
		public TerminalNode For() { return getToken(CParser.For, 0); }
		public ForConditionContext forCondition() {
			return getRuleContext(ForConditionContext.class,0);
		}
		public IterationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterationStatement; }
	}

	public final IterationStatementContext iterationStatement() throws RecognitionException {
		IterationStatementContext _localctx = new IterationStatementContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_iterationStatement);
		try {
			setState(1194);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case While:
				enterOuterAlt(_localctx, 1);
				{
				setState(1174);
				match(While);
				setState(1175);
				match(LeftParen);
				setState(1176);
				expression(0);
				setState(1177);
				match(RightParen);
				setState(1178);
				statement();
				}
				break;
			case Do:
				enterOuterAlt(_localctx, 2);
				{
				setState(1180);
				match(Do);
				setState(1181);
				statement();
				setState(1182);
				match(While);
				setState(1183);
				match(LeftParen);
				setState(1184);
				expression(0);
				setState(1185);
				match(RightParen);
				setState(1186);
				match(Semi);
				}
				break;
			case For:
				enterOuterAlt(_localctx, 3);
				{
				setState(1188);
				match(For);
				setState(1189);
				match(LeftParen);
				setState(1190);
				forCondition();
				setState(1191);
				match(RightParen);
				setState(1192);
				statement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForConditionContext extends ParserRuleContext {
		public ForDeclarationContext forDeclaration() {
			return getRuleContext(ForDeclarationContext.class,0);
		}
		public List<TerminalNode> Semi() { return getTokens(CParser.Semi); }
		public TerminalNode Semi(int i) {
			return getToken(CParser.Semi, i);
		}
		public List<ForExpressionContext> forExpression() {
			return getRuleContexts(ForExpressionContext.class);
		}
		public ForExpressionContext forExpression(int i) {
			return getRuleContext(ForExpressionContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forCondition; }
	}

	public final ForConditionContext forCondition() throws RecognitionException {
		ForConditionContext _localctx = new ForConditionContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_forCondition);
		int _la;
		try {
			setState(1216);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,130,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1196);
				forDeclaration();
				setState(1197);
				match(Semi);
				setState(1199);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << Sizeof) | (1L << Alignof) | (1L << Generic) | (1L << LeftParen))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (Plus - 71)) | (1L << (PlusPlus - 71)) | (1L << (Minus - 71)) | (1L << (MinusMinus - 71)) | (1L << (Star - 71)) | (1L << (And - 71)) | (1L << (AndAnd - 71)) | (1L << (Not - 71)) | (1L << (Tilde - 71)) | (1L << (Identifier - 71)) | (1L << (Constant - 71)) | (1L << (DigitSequence - 71)) | (1L << (StringLiteral - 71)))) != 0)) {
					{
					setState(1198);
					forExpression(0);
					}
				}

				setState(1201);
				match(Semi);
				setState(1203);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << Sizeof) | (1L << Alignof) | (1L << Generic) | (1L << LeftParen))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (Plus - 71)) | (1L << (PlusPlus - 71)) | (1L << (Minus - 71)) | (1L << (MinusMinus - 71)) | (1L << (Star - 71)) | (1L << (And - 71)) | (1L << (AndAnd - 71)) | (1L << (Not - 71)) | (1L << (Tilde - 71)) | (1L << (Identifier - 71)) | (1L << (Constant - 71)) | (1L << (DigitSequence - 71)) | (1L << (StringLiteral - 71)))) != 0)) {
					{
					setState(1202);
					forExpression(0);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1206);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << Sizeof) | (1L << Alignof) | (1L << Generic) | (1L << LeftParen))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (Plus - 71)) | (1L << (PlusPlus - 71)) | (1L << (Minus - 71)) | (1L << (MinusMinus - 71)) | (1L << (Star - 71)) | (1L << (And - 71)) | (1L << (AndAnd - 71)) | (1L << (Not - 71)) | (1L << (Tilde - 71)) | (1L << (Identifier - 71)) | (1L << (Constant - 71)) | (1L << (DigitSequence - 71)) | (1L << (StringLiteral - 71)))) != 0)) {
					{
					setState(1205);
					expression(0);
					}
				}

				setState(1208);
				match(Semi);
				setState(1210);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << Sizeof) | (1L << Alignof) | (1L << Generic) | (1L << LeftParen))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (Plus - 71)) | (1L << (PlusPlus - 71)) | (1L << (Minus - 71)) | (1L << (MinusMinus - 71)) | (1L << (Star - 71)) | (1L << (And - 71)) | (1L << (AndAnd - 71)) | (1L << (Not - 71)) | (1L << (Tilde - 71)) | (1L << (Identifier - 71)) | (1L << (Constant - 71)) | (1L << (DigitSequence - 71)) | (1L << (StringLiteral - 71)))) != 0)) {
					{
					setState(1209);
					forExpression(0);
					}
				}

				setState(1212);
				match(Semi);
				setState(1214);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << Sizeof) | (1L << Alignof) | (1L << Generic) | (1L << LeftParen))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (Plus - 71)) | (1L << (PlusPlus - 71)) | (1L << (Minus - 71)) | (1L << (MinusMinus - 71)) | (1L << (Star - 71)) | (1L << (And - 71)) | (1L << (AndAnd - 71)) | (1L << (Not - 71)) | (1L << (Tilde - 71)) | (1L << (Identifier - 71)) | (1L << (Constant - 71)) | (1L << (DigitSequence - 71)) | (1L << (StringLiteral - 71)))) != 0)) {
					{
					setState(1213);
					forExpression(0);
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForDeclarationContext extends ParserRuleContext {
		public DeclarationSpecifiersContext declarationSpecifiers() {
			return getRuleContext(DeclarationSpecifiersContext.class,0);
		}
		public InitDeclaratorListContext initDeclaratorList() {
			return getRuleContext(InitDeclaratorListContext.class,0);
		}
		public ForDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forDeclaration; }
	}

	public final ForDeclarationContext forDeclaration() throws RecognitionException {
		ForDeclarationContext _localctx = new ForDeclarationContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_forDeclaration);
		try {
			setState(1222);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,131,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1218);
				declarationSpecifiers();
				setState(1219);
				initDeclaratorList(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1221);
				declarationSpecifiers();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForExpressionContext extends ParserRuleContext {
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public ForExpressionContext forExpression() {
			return getRuleContext(ForExpressionContext.class,0);
		}
		public TerminalNode Comma() { return getToken(CParser.Comma, 0); }
		public ForExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forExpression; }
	}

	public final ForExpressionContext forExpression() throws RecognitionException {
		return forExpression(0);
	}

	private ForExpressionContext forExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ForExpressionContext _localctx = new ForExpressionContext(_ctx, _parentState);
		ForExpressionContext _prevctx = _localctx;
		int _startState = 162;
		enterRecursionRule(_localctx, 162, RULE_forExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1225);
			assignmentExpression();
			}
			_ctx.stop = _input.LT(-1);
			setState(1232);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,132,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ForExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_forExpression);
					setState(1227);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(1228);
					match(Comma);
					setState(1229);
					assignmentExpression();
					}
					} 
				}
				setState(1234);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,132,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class JumpStatementContext extends ParserRuleContext {
		public TerminalNode Goto() { return getToken(CParser.Goto, 0); }
		public TerminalNode Identifier() { return getToken(CParser.Identifier, 0); }
		public TerminalNode Semi() { return getToken(CParser.Semi, 0); }
		public TerminalNode Continue() { return getToken(CParser.Continue, 0); }
		public TerminalNode Break() { return getToken(CParser.Break, 0); }
		public TerminalNode Return() { return getToken(CParser.Return, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public JumpStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jumpStatement; }
	}

	public final JumpStatementContext jumpStatement() throws RecognitionException {
		JumpStatementContext _localctx = new JumpStatementContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_jumpStatement);
		int _la;
		try {
			setState(1251);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,134,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1235);
				match(Goto);
				setState(1236);
				match(Identifier);
				setState(1237);
				match(Semi);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1238);
				match(Continue);
				setState(1239);
				match(Semi);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1240);
				match(Break);
				setState(1241);
				match(Semi);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1242);
				match(Return);
				setState(1244);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << Sizeof) | (1L << Alignof) | (1L << Generic) | (1L << LeftParen))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (Plus - 71)) | (1L << (PlusPlus - 71)) | (1L << (Minus - 71)) | (1L << (MinusMinus - 71)) | (1L << (Star - 71)) | (1L << (And - 71)) | (1L << (AndAnd - 71)) | (1L << (Not - 71)) | (1L << (Tilde - 71)) | (1L << (Identifier - 71)) | (1L << (Constant - 71)) | (1L << (DigitSequence - 71)) | (1L << (StringLiteral - 71)))) != 0)) {
					{
					setState(1243);
					expression(0);
					}
				}

				setState(1246);
				match(Semi);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1247);
				match(Goto);
				setState(1248);
				unaryExpression();
				setState(1249);
				match(Semi);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompilationUnitContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(CParser.EOF, 0); }
		public TranslationUnitContext translationUnit() {
			return getRuleContext(TranslationUnitContext.class,0);
		}
		public CompilationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compilationUnit; }
	}

	public final CompilationUnitContext compilationUnit() throws RecognitionException {
		CompilationUnitContext _localctx = new CompilationUnitContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_compilationUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1254);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << Auto) | (1L << Char) | (1L << Const) | (1L << Double) | (1L << Enum) | (1L << Extern) | (1L << Float) | (1L << Inline) | (1L << Int) | (1L << Long) | (1L << Register) | (1L << Restrict) | (1L << Short) | (1L << Signed) | (1L << Static) | (1L << Struct) | (1L << Typedef) | (1L << Union) | (1L << Unsigned) | (1L << Void) | (1L << Volatile) | (1L << Alignas) | (1L << Atomic) | (1L << Bool) | (1L << Complex) | (1L << Noreturn) | (1L << StaticAssert) | (1L << ThreadLocal) | (1L << LeftParen))) != 0) || ((((_la - 75)) & ~0x3f) == 0 && ((1L << (_la - 75)) & ((1L << (Star - 75)) | (1L << (Caret - 75)) | (1L << (Semi - 75)) | (1L << (Identifier - 75)))) != 0)) {
				{
				setState(1253);
				translationUnit(0);
				}
			}

			setState(1256);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TranslationUnitContext extends ParserRuleContext {
		public ExternalDeclarationContext externalDeclaration() {
			return getRuleContext(ExternalDeclarationContext.class,0);
		}
		public TranslationUnitContext translationUnit() {
			return getRuleContext(TranslationUnitContext.class,0);
		}
		public TranslationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_translationUnit; }
	}

	public final TranslationUnitContext translationUnit() throws RecognitionException {
		return translationUnit(0);
	}

	private TranslationUnitContext translationUnit(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TranslationUnitContext _localctx = new TranslationUnitContext(_ctx, _parentState);
		TranslationUnitContext _prevctx = _localctx;
		int _startState = 168;
		enterRecursionRule(_localctx, 168, RULE_translationUnit, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1259);
			externalDeclaration();
			}
			_ctx.stop = _input.LT(-1);
			setState(1265);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,136,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TranslationUnitContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_translationUnit);
					setState(1261);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(1262);
					externalDeclaration();
					}
					} 
				}
				setState(1267);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,136,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExternalDeclarationContext extends ParserRuleContext {
		public FunctionDefinitionContext functionDefinition() {
			return getRuleContext(FunctionDefinitionContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public TerminalNode Semi() { return getToken(CParser.Semi, 0); }
		public ExternalDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_externalDeclaration; }
	}

	public final ExternalDeclarationContext externalDeclaration() throws RecognitionException {
		ExternalDeclarationContext _localctx = new ExternalDeclarationContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_externalDeclaration);
		try {
			setState(1271);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,137,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1268);
				functionDefinition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1269);
				declaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1270);
				match(Semi);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDefinitionContext extends ParserRuleContext {
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public DeclarationSpecifiersContext declarationSpecifiers() {
			return getRuleContext(DeclarationSpecifiersContext.class,0);
		}
		public DeclarationListContext declarationList() {
			return getRuleContext(DeclarationListContext.class,0);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1274);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,138,_ctx) ) {
			case 1:
				{
				setState(1273);
				declarationSpecifiers();
				}
				break;
			}
			setState(1276);
			declarator();
			setState(1278);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << Auto) | (1L << Char) | (1L << Const) | (1L << Double) | (1L << Enum) | (1L << Extern) | (1L << Float) | (1L << Inline) | (1L << Int) | (1L << Long) | (1L << Register) | (1L << Restrict) | (1L << Short) | (1L << Signed) | (1L << Static) | (1L << Struct) | (1L << Typedef) | (1L << Union) | (1L << Unsigned) | (1L << Void) | (1L << Volatile) | (1L << Alignas) | (1L << Atomic) | (1L << Bool) | (1L << Complex) | (1L << Noreturn) | (1L << StaticAssert) | (1L << ThreadLocal))) != 0) || _la==Identifier) {
				{
				setState(1277);
				declarationList(0);
				}
			}

			setState(1280);
			compoundStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationListContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public DeclarationListContext declarationList() {
			return getRuleContext(DeclarationListContext.class,0);
		}
		public DeclarationListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationList; }
	}

	public final DeclarationListContext declarationList() throws RecognitionException {
		return declarationList(0);
	}

	private DeclarationListContext declarationList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		DeclarationListContext _localctx = new DeclarationListContext(_ctx, _parentState);
		DeclarationListContext _prevctx = _localctx;
		int _startState = 174;
		enterRecursionRule(_localctx, 174, RULE_declarationList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1283);
			declaration();
			}
			_ctx.stop = _input.LT(-1);
			setState(1289);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,140,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new DeclarationListContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_declarationList);
					setState(1285);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(1286);
					declaration();
					}
					} 
				}
				setState(1291);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,140,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return genericAssocList_sempred((GenericAssocListContext)_localctx, predIndex);
		case 5:
			return postfixExpression_sempred((PostfixExpressionContext)_localctx, predIndex);
		case 6:
			return argumentExpressionList_sempred((ArgumentExpressionListContext)_localctx, predIndex);
		case 10:
			return multiplicativeExpression_sempred((MultiplicativeExpressionContext)_localctx, predIndex);
		case 11:
			return additiveExpression_sempred((AdditiveExpressionContext)_localctx, predIndex);
		case 12:
			return shiftExpression_sempred((ShiftExpressionContext)_localctx, predIndex);
		case 13:
			return relationalExpression_sempred((RelationalExpressionContext)_localctx, predIndex);
		case 14:
			return equalityExpression_sempred((EqualityExpressionContext)_localctx, predIndex);
		case 15:
			return andExpression_sempred((AndExpressionContext)_localctx, predIndex);
		case 16:
			return exclusiveOrExpression_sempred((ExclusiveOrExpressionContext)_localctx, predIndex);
		case 17:
			return inclusiveOrExpression_sempred((InclusiveOrExpressionContext)_localctx, predIndex);
		case 18:
			return logicalAndExpression_sempred((LogicalAndExpressionContext)_localctx, predIndex);
		case 19:
			return logicalOrExpression_sempred((LogicalOrExpressionContext)_localctx, predIndex);
		case 23:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 29:
			return initDeclaratorList_sempred((InitDeclaratorListContext)_localctx, predIndex);
		case 32:
			return typeSpecifier_sempred((TypeSpecifierContext)_localctx, predIndex);
		case 35:
			return structDeclarationList_sempred((StructDeclarationListContext)_localctx, predIndex);
		case 38:
			return structDeclaratorList_sempred((StructDeclaratorListContext)_localctx, predIndex);
		case 41:
			return enumeratorList_sempred((EnumeratorListContext)_localctx, predIndex);
		case 49:
			return directDeclarator_sempred((DirectDeclaratorContext)_localctx, predIndex);
		case 56:
			return typeQualifierList_sempred((TypeQualifierListContext)_localctx, predIndex);
		case 58:
			return parameterList_sempred((ParameterListContext)_localctx, predIndex);
		case 60:
			return identifierList_sempred((IdentifierListContext)_localctx, predIndex);
		case 63:
			return directAbstractDeclarator_sempred((DirectAbstractDeclaratorContext)_localctx, predIndex);
		case 66:
			return initializerList_sempred((InitializerListContext)_localctx, predIndex);
		case 68:
			return designatorList_sempred((DesignatorListContext)_localctx, predIndex);
		case 74:
			return blockItemList_sempred((BlockItemListContext)_localctx, predIndex);
		case 81:
			return forExpression_sempred((ForExpressionContext)_localctx, predIndex);
		case 84:
			return translationUnit_sempred((TranslationUnitContext)_localctx, predIndex);
		case 87:
			return declarationList_sempred((DeclarationListContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean genericAssocList_sempred(GenericAssocListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean postfixExpression_sempred(PostfixExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 10);
		case 2:
			return precpred(_ctx, 9);
		case 3:
			return precpred(_ctx, 8);
		case 4:
			return precpred(_ctx, 7);
		case 5:
			return precpred(_ctx, 6);
		case 6:
			return precpred(_ctx, 5);
		}
		return true;
	}
	private boolean argumentExpressionList_sempred(ArgumentExpressionListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean multiplicativeExpression_sempred(MultiplicativeExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 3);
		case 9:
			return precpred(_ctx, 2);
		case 10:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean additiveExpression_sempred(AdditiveExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 11:
			return precpred(_ctx, 2);
		case 12:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean shiftExpression_sempred(ShiftExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 13:
			return precpred(_ctx, 2);
		case 14:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean relationalExpression_sempred(RelationalExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 15:
			return precpred(_ctx, 4);
		case 16:
			return precpred(_ctx, 3);
		case 17:
			return precpred(_ctx, 2);
		case 18:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean equalityExpression_sempred(EqualityExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 19:
			return precpred(_ctx, 2);
		case 20:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean andExpression_sempred(AndExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 21:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean exclusiveOrExpression_sempred(ExclusiveOrExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 22:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean inclusiveOrExpression_sempred(InclusiveOrExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 23:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean logicalAndExpression_sempred(LogicalAndExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 24:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean logicalOrExpression_sempred(LogicalOrExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 25:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 26:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean initDeclaratorList_sempred(InitDeclaratorListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 27:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean typeSpecifier_sempred(TypeSpecifierContext _localctx, int predIndex) {
		switch (predIndex) {
		case 28:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean structDeclarationList_sempred(StructDeclarationListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 29:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean structDeclaratorList_sempred(StructDeclaratorListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 30:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean enumeratorList_sempred(EnumeratorListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 31:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean directDeclarator_sempred(DirectDeclaratorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 32:
			return precpred(_ctx, 6);
		case 33:
			return precpred(_ctx, 5);
		case 34:
			return precpred(_ctx, 4);
		case 35:
			return precpred(_ctx, 3);
		case 36:
			return precpred(_ctx, 2);
		case 37:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean typeQualifierList_sempred(TypeQualifierListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 38:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean parameterList_sempred(ParameterListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 39:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean identifierList_sempred(IdentifierListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 40:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean directAbstractDeclarator_sempred(DirectAbstractDeclaratorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 41:
			return precpred(_ctx, 5);
		case 42:
			return precpred(_ctx, 4);
		case 43:
			return precpred(_ctx, 3);
		case 44:
			return precpred(_ctx, 2);
		case 45:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean initializerList_sempred(InitializerListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 46:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean designatorList_sempred(DesignatorListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 47:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean blockItemList_sempred(BlockItemListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 48:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean forExpression_sempred(ForExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 49:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean translationUnit_sempred(TranslationUnitContext _localctx, int predIndex) {
		switch (predIndex) {
		case 50:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean declarationList_sempred(DeclarationListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 51:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3x\u050f\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\3\2\3\2\3\3\3\3\3\3\6\3\u00b8\n\3\r\3\16"+
		"\3\u00b9\3\3\3\3\3\3\3\3\3\3\3\3\5\3\u00c2\n\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\u00d6\n\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\7\5\u00e5\n\5\f\5\16\5\u00e8"+
		"\13\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u00f1\n\6\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0115\n\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\5\7\u011f\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\7\7\u012c\n\7\f\7\16\7\u012f\13\7\3\b\3\b\3\b\3\b\3\b\3\b\7\b"+
		"\u0137\n\b\f\b\16\b\u013a\13\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0152\n\t\3\n\3\n"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13"+
		"\u0163\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u0171"+
		"\n\f\f\f\16\f\u0174\13\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u017f"+
		"\n\r\f\r\16\r\u0182\13\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\7\16\u018d\n\16\f\16\16\16\u0190\13\16\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u01a1\n\17\f\17\16"+
		"\17\u01a4\13\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u01af"+
		"\n\20\f\20\16\20\u01b2\13\20\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u01ba"+
		"\n\21\f\21\16\21\u01bd\13\21\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u01c5"+
		"\n\22\f\22\16\22\u01c8\13\22\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u01d0"+
		"\n\23\f\23\16\23\u01d3\13\23\3\24\3\24\3\24\3\24\3\24\3\24\7\24\u01db"+
		"\n\24\f\24\16\24\u01de\13\24\3\25\3\25\3\25\3\25\3\25\3\25\7\25\u01e6"+
		"\n\25\f\25\16\25\u01e9\13\25\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u01f1"+
		"\n\26\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u01f9\n\27\3\30\3\30\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\7\31\u0203\n\31\f\31\16\31\u0206\13\31\3\32\3\32"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u0212\n\33\3\34\6\34\u0215"+
		"\n\34\r\34\16\34\u0216\3\35\6\35\u021a\n\35\r\35\16\35\u021b\3\36\3\36"+
		"\3\36\3\36\3\36\5\36\u0223\n\36\3\37\3\37\3\37\3\37\3\37\3\37\7\37\u022b"+
		"\n\37\f\37\16\37\u022e\13\37\3 \3 \3 \3 \3 \5 \u0235\n \3!\3!\3\"\3\""+
		"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u0248\n\"\3\""+
		"\3\"\7\"\u024c\n\"\f\"\16\"\u024f\13\"\3#\3#\5#\u0253\n#\3#\3#\3#\3#\3"+
		"#\3#\3#\5#\u025c\n#\3$\3$\3%\3%\3%\3%\3%\7%\u0265\n%\f%\16%\u0268\13%"+
		"\3&\3&\5&\u026c\n&\3&\3&\3&\5&\u0271\n&\3\'\3\'\5\'\u0275\n\'\3\'\3\'"+
		"\5\'\u0279\n\'\5\'\u027b\n\'\3(\3(\3(\3(\3(\3(\7(\u0283\n(\f(\16(\u0286"+
		"\13(\3)\3)\5)\u028a\n)\3)\3)\5)\u028e\n)\3*\3*\5*\u0292\n*\3*\3*\3*\3"+
		"*\3*\3*\5*\u029a\n*\3*\3*\3*\3*\3*\3*\3*\5*\u02a3\n*\3+\3+\3+\3+\3+\3"+
		"+\7+\u02ab\n+\f+\16+\u02ae\13+\3,\3,\3,\3,\3,\5,\u02b5\n,\3-\3-\3.\3."+
		"\3.\3.\3.\3/\3/\3\60\3\60\3\60\3\60\3\60\3\60\5\60\u02c6\n\60\3\61\3\61"+
		"\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\5\61\u02d2\n\61\3\62\5\62\u02d5"+
		"\n\62\3\62\3\62\7\62\u02d9\n\62\f\62\16\62\u02dc\13\62\3\63\3\63\3\63"+
		"\3\63\3\63\3\63\5\63\u02e4\n\63\3\63\3\63\3\63\5\63\u02e9\n\63\3\63\5"+
		"\63\u02ec\n\63\3\63\3\63\3\63\3\63\3\63\5\63\u02f3\n\63\3\63\3\63\3\63"+
		"\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\5\63\u0302\n\63\3\63"+
		"\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\5\63\u030e\n\63\3\63\7\63"+
		"\u0311\n\63\f\63\16\63\u0314\13\63\3\64\3\64\3\64\6\64\u0319\n\64\r\64"+
		"\16\64\u031a\3\64\3\64\5\64\u031f\n\64\3\65\3\65\3\65\3\65\3\65\3\65\3"+
		"\65\3\66\3\66\3\66\7\66\u032b\n\66\f\66\16\66\u032e\13\66\3\66\5\66\u0331"+
		"\n\66\3\67\3\67\3\67\5\67\u0336\n\67\3\67\5\67\u0339\n\67\3\67\5\67\u033c"+
		"\n\67\38\38\38\38\38\78\u0343\n8\f8\168\u0346\138\39\39\59\u034a\n9\3"+
		"9\39\59\u034e\n9\39\39\39\59\u0353\n9\39\39\59\u0357\n9\39\59\u035a\n"+
		"9\3:\3:\3:\3:\3:\7:\u0361\n:\f:\16:\u0364\13:\3;\3;\3;\3;\3;\5;\u036b"+
		"\n;\3<\3<\3<\3<\3<\3<\7<\u0373\n<\f<\16<\u0376\13<\3=\3=\3=\3=\3=\5=\u037d"+
		"\n=\5=\u037f\n=\3>\3>\3>\3>\3>\3>\7>\u0387\n>\f>\16>\u038a\13>\3?\3?\5"+
		"?\u038e\n?\3@\3@\5@\u0392\n@\3@\3@\7@\u0396\n@\f@\16@\u0399\13@\5@\u039b"+
		"\n@\3A\3A\3A\3A\3A\7A\u03a2\nA\fA\16A\u03a5\13A\3A\3A\5A\u03a9\nA\3A\5"+
		"A\u03ac\nA\3A\3A\3A\3A\5A\u03b2\nA\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\3"+
		"A\3A\3A\5A\u03c2\nA\3A\3A\7A\u03c6\nA\fA\16A\u03c9\13A\5A\u03cb\nA\3A"+
		"\3A\3A\5A\u03d0\nA\3A\5A\u03d3\nA\3A\3A\3A\3A\3A\5A\u03da\nA\3A\3A\3A"+
		"\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\5A\u03ed\nA\3A\3A\7A\u03f1"+
		"\nA\fA\16A\u03f4\13A\7A\u03f6\nA\fA\16A\u03f9\13A\3B\3B\3C\3C\3C\3C\3"+
		"C\3C\3C\3C\3C\3C\5C\u0407\nC\3D\3D\5D\u040b\nD\3D\3D\3D\3D\3D\5D\u0412"+
		"\nD\3D\7D\u0415\nD\fD\16D\u0418\13D\3E\3E\3E\3F\3F\3F\3F\3F\7F\u0422\n"+
		"F\fF\16F\u0425\13F\3G\3G\3G\3G\3G\3G\5G\u042d\nG\3H\3H\3H\3H\3H\6H\u0434"+
		"\nH\rH\16H\u0435\3H\3H\3H\3I\3I\3I\3I\3I\3I\3I\3I\3I\3I\3I\3I\7I\u0447"+
		"\nI\fI\16I\u044a\13I\5I\u044c\nI\3I\3I\3I\3I\7I\u0452\nI\fI\16I\u0455"+
		"\13I\5I\u0457\nI\7I\u0459\nI\fI\16I\u045c\13I\3I\3I\5I\u0460\nI\3J\3J"+
		"\3J\3J\3J\3J\3J\3J\3J\3J\3J\5J\u046d\nJ\3K\3K\5K\u0471\nK\3K\3K\3L\3L"+
		"\3L\3L\3L\7L\u047a\nL\fL\16L\u047d\13L\3M\3M\5M\u0481\nM\3N\5N\u0484\n"+
		"N\3N\3N\3O\3O\3O\3O\3O\3O\3O\5O\u048f\nO\3O\3O\3O\3O\3O\3O\5O\u0497\n"+
		"O\3P\3P\3P\3P\3P\3P\3P\3P\3P\3P\3P\3P\3P\3P\3P\3P\3P\3P\3P\3P\5P\u04ad"+
		"\nP\3Q\3Q\3Q\5Q\u04b2\nQ\3Q\3Q\5Q\u04b6\nQ\3Q\5Q\u04b9\nQ\3Q\3Q\5Q\u04bd"+
		"\nQ\3Q\3Q\5Q\u04c1\nQ\5Q\u04c3\nQ\3R\3R\3R\3R\5R\u04c9\nR\3S\3S\3S\3S"+
		"\3S\3S\7S\u04d1\nS\fS\16S\u04d4\13S\3T\3T\3T\3T\3T\3T\3T\3T\3T\5T\u04df"+
		"\nT\3T\3T\3T\3T\3T\5T\u04e6\nT\3U\5U\u04e9\nU\3U\3U\3V\3V\3V\3V\3V\7V"+
		"\u04f2\nV\fV\16V\u04f5\13V\3W\3W\3W\5W\u04fa\nW\3X\5X\u04fd\nX\3X\3X\5"+
		"X\u0501\nX\3X\3X\3Y\3Y\3Y\3Y\3Y\7Y\u050a\nY\fY\16Y\u050d\13Y\3Y\2 \b\f"+
		"\16\26\30\32\34\36 \"$&(\60<BHNTdrvz\u0080\u0086\u008a\u0096\u00a4\u00aa"+
		"\u00b0Z\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:"+
		"<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a"+
		"\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2"+
		"\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\2\16\7\2IIKKMMPPUV\3\2[e\b"+
		"\2\21\21\34\34$$**--<<\n\2\6\b\24\24\31\31\35\35\"#\'(/\60\66\67\3\2\6"+
		"\b\4\2++..\6\2\25\25%%\61\61\65\65\5\2\n\13!!::\4\2=>ZZ\3\2=>\4\2\r\r"+
		"\17\17\4\2\20\20\61\61\2\u0580\2\u00b2\3\2\2\2\4\u00d5\3\2\2\2\6\u00d7"+
		"\3\2\2\2\b\u00de\3\2\2\2\n\u00f0\3\2\2\2\f\u0114\3\2\2\2\16\u0130\3\2"+
		"\2\2\20\u0151\3\2\2\2\22\u0153\3\2\2\2\24\u0162\3\2\2\2\26\u0164\3\2\2"+
		"\2\30\u0175\3\2\2\2\32\u0183\3\2\2\2\34\u0191\3\2\2\2\36\u01a5\3\2\2\2"+
		" \u01b3\3\2\2\2\"\u01be\3\2\2\2$\u01c9\3\2\2\2&\u01d4\3\2\2\2(\u01df\3"+
		"\2\2\2*\u01ea\3\2\2\2,\u01f8\3\2\2\2.\u01fa\3\2\2\2\60\u01fc\3\2\2\2\62"+
		"\u0207\3\2\2\2\64\u0211\3\2\2\2\66\u0214\3\2\2\28\u0219\3\2\2\2:\u0222"+
		"\3\2\2\2<\u0224\3\2\2\2>\u0234\3\2\2\2@\u0236\3\2\2\2B\u0247\3\2\2\2D"+
		"\u025b\3\2\2\2F\u025d\3\2\2\2H\u025f\3\2\2\2J\u0270\3\2\2\2L\u027a\3\2"+
		"\2\2N\u027c\3\2\2\2P\u028d\3\2\2\2R\u02a2\3\2\2\2T\u02a4\3\2\2\2V\u02b4"+
		"\3\2\2\2X\u02b6\3\2\2\2Z\u02b8\3\2\2\2\\\u02bd\3\2\2\2^\u02c5\3\2\2\2"+
		"`\u02d1\3\2\2\2b\u02d4\3\2\2\2d\u02e3\3\2\2\2f\u031e\3\2\2\2h\u0320\3"+
		"\2\2\2j\u0330\3\2\2\2l\u033b\3\2\2\2n\u0344\3\2\2\2p\u0359\3\2\2\2r\u035b"+
		"\3\2\2\2t\u036a\3\2\2\2v\u036c\3\2\2\2x\u037e\3\2\2\2z\u0380\3\2\2\2|"+
		"\u038b\3\2\2\2~\u039a\3\2\2\2\u0080\u03ca\3\2\2\2\u0082\u03fa\3\2\2\2"+
		"\u0084\u0406\3\2\2\2\u0086\u0408\3\2\2\2\u0088\u0419\3\2\2\2\u008a\u041c"+
		"\3\2\2\2\u008c\u042c\3\2\2\2\u008e\u042e\3\2\2\2\u0090\u045f\3\2\2\2\u0092"+
		"\u046c\3\2\2\2\u0094\u046e\3\2\2\2\u0096\u0474\3\2\2\2\u0098\u0480\3\2"+
		"\2\2\u009a\u0483\3\2\2\2\u009c\u0496\3\2\2\2\u009e\u04ac\3\2\2\2\u00a0"+
		"\u04c2\3\2\2\2\u00a2\u04c8\3\2\2\2\u00a4\u04ca\3\2\2\2\u00a6\u04e5\3\2"+
		"\2\2\u00a8\u04e8\3\2\2\2\u00aa\u04ec\3\2\2\2\u00ac\u04f9\3\2\2\2\u00ae"+
		"\u04fc\3\2\2\2\u00b0\u0504\3\2\2\2\u00b2\u00b3\5\u00aaV\2\u00b3\3\3\2"+
		"\2\2\u00b4\u00d6\7k\2\2\u00b5\u00d6\7l\2\2\u00b6\u00b8\7n\2\2\u00b7\u00b6"+
		"\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba"+
		"\u00d6\3\2\2\2\u00bb\u00bc\7=\2\2\u00bc\u00bd\5\60\31\2\u00bd\u00be\7"+
		">\2\2\u00be\u00d6\3\2\2\2\u00bf\u00d6\5\6\4\2\u00c0\u00c2\7\3\2\2\u00c1"+
		"\u00c0\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\7="+
		"\2\2\u00c4\u00c5\5\u0094K\2\u00c5\u00c6\7>\2\2\u00c6\u00d6\3\2\2\2\u00c7"+
		"\u00c8\7\4\2\2\u00c8\u00c9\7=\2\2\u00c9\u00ca\5\20\t\2\u00ca\u00cb\7Z"+
		"\2\2\u00cb\u00cc\5|?\2\u00cc\u00cd\7>\2\2\u00cd\u00d6\3\2\2\2\u00ce\u00cf"+
		"\7\5\2\2\u00cf\u00d0\7=\2\2\u00d0\u00d1\5|?\2\u00d1\u00d2\7Z\2\2\u00d2"+
		"\u00d3\5\20\t\2\u00d3\u00d4\7>\2\2\u00d4\u00d6\3\2\2\2\u00d5\u00b4\3\2"+
		"\2\2\u00d5\u00b5\3\2\2\2\u00d5\u00b7\3\2\2\2\u00d5\u00bb\3\2\2\2\u00d5"+
		"\u00bf\3\2\2\2\u00d5\u00c1\3\2\2\2\u00d5\u00c7\3\2\2\2\u00d5\u00ce\3\2"+
		"\2\2\u00d6\5\3\2\2\2\u00d7\u00d8\78\2\2\u00d8\u00d9\7=\2\2\u00d9\u00da"+
		"\5,\27\2\u00da\u00db\7Z\2\2\u00db\u00dc\5\b\5\2\u00dc\u00dd\7>\2\2\u00dd"+
		"\7\3\2\2\2\u00de\u00df\b\5\1\2\u00df\u00e0\5\n\6\2\u00e0\u00e6\3\2\2\2"+
		"\u00e1\u00e2\f\3\2\2\u00e2\u00e3\7Z\2\2\u00e3\u00e5\5\n\6\2\u00e4\u00e1"+
		"\3\2\2\2\u00e5\u00e8\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7"+
		"\t\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00ea\5|?\2\u00ea\u00eb\7X\2\2\u00eb"+
		"\u00ec\5,\27\2\u00ec\u00f1\3\2\2\2\u00ed\u00ee\7\27\2\2\u00ee\u00ef\7"+
		"X\2\2\u00ef\u00f1\5,\27\2\u00f0\u00e9\3\2\2\2\u00f0\u00ed\3\2\2\2\u00f1"+
		"\13\3\2\2\2\u00f2\u00f3\b\7\1\2\u00f3\u0115\5\4\3\2\u00f4\u00f5\7=\2\2"+
		"\u00f5\u00f6\5|?\2\u00f6\u00f7\7>\2\2\u00f7\u00f8\7A\2\2\u00f8\u00f9\5"+
		"\u0086D\2\u00f9\u00fa\7B\2\2\u00fa\u0115\3\2\2\2\u00fb\u00fc\7=\2\2\u00fc"+
		"\u00fd\5|?\2\u00fd\u00fe\7>\2\2\u00fe\u00ff\7A\2\2\u00ff\u0100\5\u0086"+
		"D\2\u0100\u0101\7Z\2\2\u0101\u0102\7B\2\2\u0102\u0115\3\2\2\2\u0103\u0104"+
		"\7\3\2\2\u0104\u0105\7=\2\2\u0105\u0106\5|?\2\u0106\u0107\7>\2\2\u0107"+
		"\u0108\7A\2\2\u0108\u0109\5\u0086D\2\u0109\u010a\7B\2\2\u010a\u0115\3"+
		"\2\2\2\u010b\u010c\7\3\2\2\u010c\u010d\7=\2\2\u010d\u010e\5|?\2\u010e"+
		"\u010f\7>\2\2\u010f\u0110\7A\2\2\u0110\u0111\5\u0086D\2\u0111\u0112\7"+
		"Z\2\2\u0112\u0113\7B\2\2\u0113\u0115\3\2\2\2\u0114\u00f2\3\2\2\2\u0114"+
		"\u00f4\3\2\2\2\u0114\u00fb\3\2\2\2\u0114\u0103\3\2\2\2\u0114\u010b\3\2"+
		"\2\2\u0115\u012d\3\2\2\2\u0116\u0117\f\f\2\2\u0117\u0118\7?\2\2\u0118"+
		"\u0119\5\60\31\2\u0119\u011a\7@\2\2\u011a\u012c\3\2\2\2\u011b\u011c\f"+
		"\13\2\2\u011c\u011e\7=\2\2\u011d\u011f\5\16\b\2\u011e\u011d\3\2\2\2\u011e"+
		"\u011f\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u012c\7>\2\2\u0121\u0122\f\n"+
		"\2\2\u0122\u0123\7i\2\2\u0123\u012c\7k\2\2\u0124\u0125\f\t\2\2\u0125\u0126"+
		"\7h\2\2\u0126\u012c\7k\2\2\u0127\u0128\f\b\2\2\u0128\u012c\7J\2\2\u0129"+
		"\u012a\f\7\2\2\u012a\u012c\7L\2\2\u012b\u0116\3\2\2\2\u012b\u011b\3\2"+
		"\2\2\u012b\u0121\3\2\2\2\u012b\u0124\3\2\2\2\u012b\u0127\3\2\2\2\u012b"+
		"\u0129\3\2\2\2\u012c\u012f\3\2\2\2\u012d\u012b\3\2\2\2\u012d\u012e\3\2"+
		"\2\2\u012e\r\3\2\2\2\u012f\u012d\3\2\2\2\u0130\u0131\b\b\1\2\u0131\u0132"+
		"\5,\27\2\u0132\u0138\3\2\2\2\u0133\u0134\f\3\2\2\u0134\u0135\7Z\2\2\u0135"+
		"\u0137\5,\27\2\u0136\u0133\3\2\2\2\u0137\u013a\3\2\2\2\u0138\u0136\3\2"+
		"\2\2\u0138\u0139\3\2\2\2\u0139\17\3\2\2\2\u013a\u0138\3\2\2\2\u013b\u0152"+
		"\5\f\7\2\u013c\u013d\7J\2\2\u013d\u0152\5\20\t\2\u013e\u013f\7L\2\2\u013f"+
		"\u0152\5\20\t\2\u0140\u0141\5\22\n\2\u0141\u0142\5\24\13\2\u0142\u0152"+
		"\3\2\2\2\u0143\u0144\7)\2\2\u0144\u0152\5\20\t\2\u0145\u0146\7)\2\2\u0146"+
		"\u0147\7=\2\2\u0147\u0148\5|?\2\u0148\u0149\7>\2\2\u0149\u0152\3\2\2\2"+
		"\u014a\u014b\7\64\2\2\u014b\u014c\7=\2\2\u014c\u014d\5|?\2\u014d\u014e"+
		"\7>\2\2\u014e\u0152\3\2\2\2\u014f\u0150\7R\2\2\u0150\u0152\7k\2\2\u0151"+
		"\u013b\3\2\2\2\u0151\u013c\3\2\2\2\u0151\u013e\3\2\2\2\u0151\u0140\3\2"+
		"\2\2\u0151\u0143\3\2\2\2\u0151\u0145\3\2\2\2\u0151\u014a\3\2\2\2\u0151"+
		"\u014f\3\2\2\2\u0152\21\3\2\2\2\u0153\u0154\t\2\2\2\u0154\23\3\2\2\2\u0155"+
		"\u0156\7=\2\2\u0156\u0157\5|?\2\u0157\u0158\7>\2\2\u0158\u0159\5\24\13"+
		"\2\u0159\u0163\3\2\2\2\u015a\u015b\7\3\2\2\u015b\u015c\7=\2\2\u015c\u015d"+
		"\5|?\2\u015d\u015e\7>\2\2\u015e\u015f\5\24\13\2\u015f\u0163\3\2\2\2\u0160"+
		"\u0163\5\20\t\2\u0161\u0163\7m\2\2\u0162\u0155\3\2\2\2\u0162\u015a\3\2"+
		"\2\2\u0162\u0160\3\2\2\2\u0162\u0161\3\2\2\2\u0163\25\3\2\2\2\u0164\u0165"+
		"\b\f\1\2\u0165\u0166\5\24\13\2\u0166\u0172\3\2\2\2\u0167\u0168\f\5\2\2"+
		"\u0168\u0169\7M\2\2\u0169\u0171\5\24\13\2\u016a\u016b\f\4\2\2\u016b\u016c"+
		"\7N\2\2\u016c\u0171\5\24\13\2\u016d\u016e\f\3\2\2\u016e\u016f\7O\2\2\u016f"+
		"\u0171\5\24\13\2\u0170\u0167\3\2\2\2\u0170\u016a\3\2\2\2\u0170\u016d\3"+
		"\2\2\2\u0171\u0174\3\2\2\2\u0172\u0170\3\2\2\2\u0172\u0173\3\2\2\2\u0173"+
		"\27\3\2\2\2\u0174\u0172\3\2\2\2\u0175\u0176\b\r\1\2\u0176\u0177\5\26\f"+
		"\2\u0177\u0180\3\2\2\2\u0178\u0179\f\4\2\2\u0179\u017a\7I\2\2\u017a\u017f"+
		"\5\26\f\2\u017b\u017c\f\3\2\2\u017c\u017d\7K\2\2\u017d\u017f\5\26\f\2"+
		"\u017e\u0178\3\2\2\2\u017e\u017b\3\2\2\2\u017f\u0182\3\2\2\2\u0180\u017e"+
		"\3\2\2\2\u0180\u0181\3\2\2\2\u0181\31\3\2\2\2\u0182\u0180\3\2\2\2\u0183"+
		"\u0184\b\16\1\2\u0184\u0185\5\30\r\2\u0185\u018e\3\2\2\2\u0186\u0187\f"+
		"\4\2\2\u0187\u0188\7G\2\2\u0188\u018d\5\30\r\2\u0189\u018a\f\3\2\2\u018a"+
		"\u018b\7H\2\2\u018b\u018d\5\30\r\2\u018c\u0186\3\2\2\2\u018c\u0189\3\2"+
		"\2\2\u018d\u0190\3\2\2\2\u018e\u018c\3\2\2\2\u018e\u018f\3\2\2\2\u018f"+
		"\33\3\2\2\2\u0190\u018e\3\2\2\2\u0191\u0192\b\17\1\2\u0192\u0193\5\32"+
		"\16\2\u0193\u01a2\3\2\2\2\u0194\u0195\f\6\2\2\u0195\u0196\7C\2\2\u0196"+
		"\u01a1\5\32\16\2\u0197\u0198\f\5\2\2\u0198\u0199\7E\2\2\u0199\u01a1\5"+
		"\32\16\2\u019a\u019b\f\4\2\2\u019b\u019c\7D\2\2\u019c\u01a1\5\32\16\2"+
		"\u019d\u019e\f\3\2\2\u019e\u019f\7F\2\2\u019f\u01a1\5\32\16\2\u01a0\u0194"+
		"\3\2\2\2\u01a0\u0197\3\2\2\2\u01a0\u019a\3\2\2\2\u01a0\u019d\3\2\2\2\u01a1"+
		"\u01a4\3\2\2\2\u01a2\u01a0\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3\35\3\2\2"+
		"\2\u01a4\u01a2\3\2\2\2\u01a5\u01a6\b\20\1\2\u01a6\u01a7\5\34\17\2\u01a7"+
		"\u01b0\3\2\2\2\u01a8\u01a9\f\4\2\2\u01a9\u01aa\7f\2\2\u01aa\u01af\5\34"+
		"\17\2\u01ab\u01ac\f\3\2\2\u01ac\u01ad\7g\2\2\u01ad\u01af\5\34\17\2\u01ae"+
		"\u01a8\3\2\2\2\u01ae\u01ab\3\2\2\2\u01af\u01b2\3\2\2\2\u01b0\u01ae\3\2"+
		"\2\2\u01b0\u01b1\3\2\2\2\u01b1\37\3\2\2\2\u01b2\u01b0\3\2\2\2\u01b3\u01b4"+
		"\b\21\1\2\u01b4\u01b5\5\36\20\2\u01b5\u01bb\3\2\2\2\u01b6\u01b7\f\3\2"+
		"\2\u01b7\u01b8\7P\2\2\u01b8\u01ba\5\36\20\2\u01b9\u01b6\3\2\2\2\u01ba"+
		"\u01bd\3\2\2\2\u01bb\u01b9\3\2\2\2\u01bb\u01bc\3\2\2\2\u01bc!\3\2\2\2"+
		"\u01bd\u01bb\3\2\2\2\u01be\u01bf\b\22\1\2\u01bf\u01c0\5 \21\2\u01c0\u01c6"+
		"\3\2\2\2\u01c1\u01c2\f\3\2\2\u01c2\u01c3\7T\2\2\u01c3\u01c5\5 \21\2\u01c4"+
		"\u01c1\3\2\2\2\u01c5\u01c8\3\2\2\2\u01c6\u01c4\3\2\2\2\u01c6\u01c7\3\2"+
		"\2\2\u01c7#\3\2\2\2\u01c8\u01c6\3\2\2\2\u01c9\u01ca\b\23\1\2\u01ca\u01cb"+
		"\5\"\22\2\u01cb\u01d1\3\2\2\2\u01cc\u01cd\f\3\2\2\u01cd\u01ce\7Q\2\2\u01ce"+
		"\u01d0\5\"\22\2\u01cf\u01cc\3\2\2\2\u01d0\u01d3\3\2\2\2\u01d1\u01cf\3"+
		"\2\2\2\u01d1\u01d2\3\2\2\2\u01d2%\3\2\2\2\u01d3\u01d1\3\2\2\2\u01d4\u01d5"+
		"\b\24\1\2\u01d5\u01d6\5$\23\2\u01d6\u01dc\3\2\2\2\u01d7\u01d8\f\3\2\2"+
		"\u01d8\u01d9\7R\2\2\u01d9\u01db\5$\23\2\u01da\u01d7\3\2\2\2\u01db\u01de"+
		"\3\2\2\2\u01dc\u01da\3\2\2\2\u01dc\u01dd\3\2\2\2\u01dd\'\3\2\2\2\u01de"+
		"\u01dc\3\2\2\2\u01df\u01e0\b\25\1\2\u01e0\u01e1\5&\24\2\u01e1\u01e7\3"+
		"\2\2\2\u01e2\u01e3\f\3\2\2\u01e3\u01e4\7S\2\2\u01e4\u01e6\5&\24\2\u01e5"+
		"\u01e2\3\2\2\2\u01e6\u01e9\3\2\2\2\u01e7\u01e5\3\2\2\2\u01e7\u01e8\3\2"+
		"\2\2\u01e8)\3\2\2\2\u01e9\u01e7\3\2\2\2\u01ea\u01f0\5(\25\2\u01eb\u01ec"+
		"\7W\2\2\u01ec\u01ed\5\60\31\2\u01ed\u01ee\7X\2\2\u01ee\u01ef\5*\26\2\u01ef"+
		"\u01f1\3\2\2\2\u01f0\u01eb\3\2\2\2\u01f0\u01f1\3\2\2\2\u01f1+\3\2\2\2"+
		"\u01f2\u01f9\5*\26\2\u01f3\u01f4\5\20\t\2\u01f4\u01f5\5.\30\2\u01f5\u01f6"+
		"\5,\27\2\u01f6\u01f9\3\2\2\2\u01f7\u01f9\7m\2\2\u01f8\u01f2\3\2\2\2\u01f8"+
		"\u01f3\3\2\2\2\u01f8\u01f7\3\2\2\2\u01f9-\3\2\2\2\u01fa\u01fb\t\3\2\2"+
		"\u01fb/\3\2\2\2\u01fc\u01fd\b\31\1\2\u01fd\u01fe\5,\27\2\u01fe\u0204\3"+
		"\2\2\2\u01ff\u0200\f\3\2\2\u0200\u0201\7Z\2\2\u0201\u0203\5,\27\2\u0202"+
		"\u01ff\3\2\2\2\u0203\u0206\3\2\2\2\u0204\u0202\3\2\2\2\u0204\u0205\3\2"+
		"\2\2\u0205\61\3\2\2\2\u0206\u0204\3\2\2\2\u0207\u0208\5*\26\2\u0208\63"+
		"\3\2\2\2\u0209\u020a\5\66\34\2\u020a\u020b\5<\37\2\u020b\u020c\7Y\2\2"+
		"\u020c\u0212\3\2\2\2\u020d\u020e\5\66\34\2\u020e\u020f\7Y\2\2\u020f\u0212"+
		"\3\2\2\2\u0210\u0212\5\u008eH\2\u0211\u0209\3\2\2\2\u0211\u020d\3\2\2"+
		"\2\u0211\u0210\3\2\2\2\u0212\65\3\2\2\2\u0213\u0215\5:\36\2\u0214\u0213"+
		"\3\2\2\2\u0215\u0216\3\2\2\2\u0216\u0214\3\2\2\2\u0216\u0217\3\2\2\2\u0217"+
		"\67\3\2\2\2\u0218\u021a\5:\36\2\u0219\u0218\3\2\2\2\u021a\u021b\3\2\2"+
		"\2\u021b\u0219\3\2\2\2\u021b\u021c\3\2\2\2\u021c9\3\2\2\2\u021d\u0223"+
		"\5@!\2\u021e\u0223\5B\"\2\u021f\u0223\5\\/\2\u0220\u0223\5^\60\2\u0221"+
		"\u0223\5`\61\2\u0222\u021d\3\2\2\2\u0222\u021e\3\2\2\2\u0222\u021f\3\2"+
		"\2\2\u0222\u0220\3\2\2\2\u0222\u0221\3\2\2\2\u0223;\3\2\2\2\u0224\u0225"+
		"\b\37\1\2\u0225\u0226\5> \2\u0226\u022c\3\2\2\2\u0227\u0228\f\3\2\2\u0228"+
		"\u0229\7Z\2\2\u0229\u022b\5> \2\u022a\u0227\3\2\2\2\u022b\u022e\3\2\2"+
		"\2\u022c\u022a\3\2\2\2\u022c\u022d\3\2\2\2\u022d=\3\2\2\2\u022e\u022c"+
		"\3\2\2\2\u022f\u0235\5b\62\2\u0230\u0231\5b\62\2\u0231\u0232\7[\2\2\u0232"+
		"\u0233\5\u0084C\2\u0233\u0235\3\2\2\2\u0234\u022f\3\2\2\2\u0234\u0230"+
		"\3\2\2\2\u0235?\3\2\2\2\u0236\u0237\t\4\2\2\u0237A\3\2\2\2\u0238\u0239"+
		"\b\"\1\2\u0239\u0248\t\5\2\2\u023a\u023b\7\3\2\2\u023b\u023c\7=\2\2\u023c"+
		"\u023d\t\6\2\2\u023d\u0248\7>\2\2\u023e\u0248\5Z.\2\u023f\u0248\5D#\2"+
		"\u0240\u0248\5R*\2\u0241\u0248\5\u0082B\2\u0242\u0243\7\t\2\2\u0243\u0244"+
		"\7=\2\2\u0244\u0245\5\62\32\2\u0245\u0246\7>\2\2\u0246\u0248\3\2\2\2\u0247"+
		"\u0238\3\2\2\2\u0247\u023a\3\2\2\2\u0247\u023e\3\2\2\2\u0247\u023f\3\2"+
		"\2\2\u0247\u0240\3\2\2\2\u0247\u0241\3\2\2\2\u0247\u0242\3\2\2\2\u0248"+
		"\u024d\3\2\2\2\u0249\u024a\f\3\2\2\u024a\u024c\5p9\2\u024b\u0249\3\2\2"+
		"\2\u024c\u024f\3\2\2\2\u024d\u024b\3\2\2\2\u024d\u024e\3\2\2\2\u024eC"+
		"\3\2\2\2\u024f\u024d\3\2\2\2\u0250\u0252\5F$\2\u0251\u0253\7k\2\2\u0252"+
		"\u0251\3\2\2\2\u0252\u0253\3\2\2\2\u0253\u0254\3\2\2\2\u0254\u0255\7A"+
		"\2\2\u0255\u0256\5H%\2\u0256\u0257\7B\2\2\u0257\u025c\3\2\2\2\u0258\u0259"+
		"\5F$\2\u0259\u025a\7k\2\2\u025a\u025c\3\2\2\2\u025b\u0250\3\2\2\2\u025b"+
		"\u0258\3\2\2\2\u025cE\3\2\2\2\u025d\u025e\t\7\2\2\u025eG\3\2\2\2\u025f"+
		"\u0260\b%\1\2\u0260\u0261\5J&\2\u0261\u0266\3\2\2\2\u0262\u0263\f\3\2"+
		"\2\u0263\u0265\5J&\2\u0264\u0262\3\2\2\2\u0265\u0268\3\2\2\2\u0266\u0264"+
		"\3\2\2\2\u0266\u0267\3\2\2\2\u0267I\3\2\2\2\u0268\u0266\3\2\2\2\u0269"+
		"\u026b\5L\'\2\u026a\u026c\5N(\2\u026b\u026a\3\2\2\2\u026b\u026c\3\2\2"+
		"\2\u026c\u026d\3\2\2\2\u026d\u026e\7Y\2\2\u026e\u0271\3\2\2\2\u026f\u0271"+
		"\5\u008eH\2\u0270\u0269\3\2\2\2\u0270\u026f\3\2\2\2\u0271K\3\2\2\2\u0272"+
		"\u0274\5B\"\2\u0273\u0275\5L\'\2\u0274\u0273\3\2\2\2\u0274\u0275\3\2\2"+
		"\2\u0275\u027b\3\2\2\2\u0276\u0278\5\\/\2\u0277\u0279\5L\'\2\u0278\u0277"+
		"\3\2\2\2\u0278\u0279\3\2\2\2\u0279\u027b\3\2\2\2\u027a\u0272\3\2\2\2\u027a"+
		"\u0276\3\2\2\2\u027bM\3\2\2\2\u027c\u027d\b(\1\2\u027d\u027e\5P)\2\u027e"+
		"\u0284\3\2\2\2\u027f\u0280\f\3\2\2\u0280\u0281\7Z\2\2\u0281\u0283\5P)"+
		"\2\u0282\u027f\3\2\2\2\u0283\u0286\3\2\2\2\u0284\u0282\3\2\2\2\u0284\u0285"+
		"\3\2\2\2\u0285O\3\2\2\2\u0286\u0284\3\2\2\2\u0287\u028e\5b\62\2\u0288"+
		"\u028a\5b\62\2\u0289\u0288\3\2\2\2\u0289\u028a\3\2\2\2\u028a\u028b\3\2"+
		"\2\2\u028b\u028c\7X\2\2\u028c\u028e\5\62\32\2\u028d\u0287\3\2\2\2\u028d"+
		"\u0289\3\2\2\2\u028eQ\3\2\2\2\u028f\u0291\7\33\2\2\u0290\u0292\7k\2\2"+
		"\u0291\u0290\3\2\2\2\u0291\u0292\3\2\2\2\u0292\u0293\3\2\2\2\u0293\u0294"+
		"\7A\2\2\u0294\u0295\5T+\2\u0295\u0296\7B\2\2\u0296\u02a3\3\2\2\2\u0297"+
		"\u0299\7\33\2\2\u0298\u029a\7k\2\2\u0299\u0298\3\2\2\2\u0299\u029a\3\2"+
		"\2\2\u029a\u029b\3\2\2\2\u029b\u029c\7A\2\2\u029c\u029d\5T+\2\u029d\u029e"+
		"\7Z\2\2\u029e\u029f\7B\2\2\u029f\u02a3\3\2\2\2\u02a0\u02a1\7\33\2\2\u02a1"+
		"\u02a3\7k\2\2\u02a2\u028f\3\2\2\2\u02a2\u0297\3\2\2\2\u02a2\u02a0\3\2"+
		"\2\2\u02a3S\3\2\2\2\u02a4\u02a5\b+\1\2\u02a5\u02a6\5V,\2\u02a6\u02ac\3"+
		"\2\2\2\u02a7\u02a8\f\3\2\2\u02a8\u02a9\7Z\2\2\u02a9\u02ab\5V,\2\u02aa"+
		"\u02a7\3\2\2\2\u02ab\u02ae\3\2\2\2\u02ac\u02aa\3\2\2\2\u02ac\u02ad\3\2"+
		"\2\2\u02adU\3\2\2\2\u02ae\u02ac\3\2\2\2\u02af\u02b5\5X-\2\u02b0\u02b1"+
		"\5X-\2\u02b1\u02b2\7[\2\2\u02b2\u02b3\5\62\32\2\u02b3\u02b5\3\2\2\2\u02b4"+
		"\u02af\3\2\2\2\u02b4\u02b0\3\2\2\2\u02b5W\3\2\2\2\u02b6\u02b7\7k\2\2\u02b7"+
		"Y\3\2\2\2\u02b8\u02b9\7\65\2\2\u02b9\u02ba\7=\2\2\u02ba\u02bb\5|?\2\u02bb"+
		"\u02bc\7>\2\2\u02bc[\3\2\2\2\u02bd\u02be\t\b\2\2\u02be]\3\2\2\2\u02bf"+
		"\u02c6\t\t\2\2\u02c0\u02c6\5h\65\2\u02c1\u02c2\7\f\2\2\u02c2\u02c3\7="+
		"\2\2\u02c3\u02c4\7k\2\2\u02c4\u02c6\7>\2\2\u02c5\u02bf\3\2\2\2\u02c5\u02c0"+
		"\3\2\2\2\u02c5\u02c1\3\2\2\2\u02c6_\3\2\2\2\u02c7\u02c8\7\63\2\2\u02c8"+
		"\u02c9\7=\2\2\u02c9\u02ca\5|?\2\u02ca\u02cb\7>\2\2\u02cb\u02d2\3\2\2\2"+
		"\u02cc\u02cd\7\63\2\2\u02cd\u02ce\7=\2\2\u02ce\u02cf\5\62\32\2\u02cf\u02d0"+
		"\7>\2\2\u02d0\u02d2\3\2\2\2\u02d1\u02c7\3\2\2\2\u02d1\u02cc\3\2\2\2\u02d2"+
		"a\3\2\2\2\u02d3\u02d5\5p9\2\u02d4\u02d3\3\2\2\2\u02d4\u02d5\3\2\2\2\u02d5"+
		"\u02d6\3\2\2\2\u02d6\u02da\5d\63\2\u02d7\u02d9\5f\64\2\u02d8\u02d7\3\2"+
		"\2\2\u02d9\u02dc\3\2\2\2\u02da\u02d8\3\2\2\2\u02da\u02db\3\2\2\2\u02db"+
		"c\3\2\2\2\u02dc\u02da\3\2\2\2\u02dd\u02de\b\63\1\2\u02de\u02e4\7k\2\2"+
		"\u02df\u02e0\7=\2\2\u02e0\u02e1\5b\62\2\u02e1\u02e2\7>\2\2\u02e2\u02e4"+
		"\3\2\2\2\u02e3\u02dd\3\2\2\2\u02e3\u02df\3\2\2\2\u02e4\u0312\3\2\2\2\u02e5"+
		"\u02e6\f\b\2\2\u02e6\u02e8\7?\2\2\u02e7\u02e9\5r:\2\u02e8\u02e7\3\2\2"+
		"\2\u02e8\u02e9\3\2\2\2\u02e9\u02eb\3\2\2\2\u02ea\u02ec\5,\27\2\u02eb\u02ea"+
		"\3\2\2\2\u02eb\u02ec\3\2\2\2\u02ec\u02ed\3\2\2\2\u02ed\u0311\7@\2\2\u02ee"+
		"\u02ef\f\7\2\2\u02ef\u02f0\7?\2\2\u02f0\u02f2\7*\2\2\u02f1\u02f3\5r:\2"+
		"\u02f2\u02f1\3\2\2\2\u02f2\u02f3\3\2\2\2\u02f3\u02f4\3\2\2\2\u02f4\u02f5"+
		"\5,\27\2\u02f5\u02f6\7@\2\2\u02f6\u0311\3\2\2\2\u02f7\u02f8\f\6\2\2\u02f8"+
		"\u02f9\7?\2\2\u02f9\u02fa\5r:\2\u02fa\u02fb\7*\2\2\u02fb\u02fc\5,\27\2"+
		"\u02fc\u02fd\7@\2\2\u02fd\u0311\3\2\2\2\u02fe\u02ff\f\5\2\2\u02ff\u0301"+
		"\7?\2\2\u0300\u0302\5r:\2\u0301\u0300\3\2\2\2\u0301\u0302\3\2\2\2\u0302"+
		"\u0303\3\2\2\2\u0303\u0304\7M\2\2\u0304\u0311\7@\2\2\u0305\u0306\f\4\2"+
		"\2\u0306\u0307\7=\2\2\u0307\u0308\5t;\2\u0308\u0309\7>\2\2\u0309\u0311"+
		"\3\2\2\2\u030a\u030b\f\3\2\2\u030b\u030d\7=\2\2\u030c\u030e\5z>\2\u030d"+
		"\u030c\3\2\2\2\u030d\u030e\3\2\2\2\u030e\u030f\3\2\2\2\u030f\u0311\7>"+
		"\2\2\u0310\u02e5\3\2\2\2\u0310\u02ee\3\2\2\2\u0310\u02f7\3\2\2\2\u0310"+
		"\u02fe\3\2\2\2\u0310\u0305\3\2\2\2\u0310\u030a\3\2\2\2\u0311\u0314\3\2"+
		"\2\2\u0312\u0310\3\2\2\2\u0312\u0313\3\2\2\2\u0313e\3\2\2\2\u0314\u0312"+
		"\3\2\2\2\u0315\u0316\7\r\2\2\u0316\u0318\7=\2\2\u0317\u0319\7n\2\2\u0318"+
		"\u0317\3\2\2\2\u0319\u031a\3\2\2\2\u031a\u0318\3\2\2\2\u031a\u031b\3\2"+
		"\2\2\u031b\u031c\3\2\2\2\u031c\u031f\7>\2\2\u031d\u031f\5h\65\2\u031e"+
		"\u0315\3\2\2\2\u031e\u031d\3\2\2\2\u031fg\3\2\2\2\u0320\u0321\7\16\2\2"+
		"\u0321\u0322\7=\2\2\u0322\u0323\7=\2\2\u0323\u0324\5j\66\2\u0324\u0325"+
		"\7>\2\2\u0325\u0326\7>\2\2\u0326i\3\2\2\2\u0327\u032c\5l\67\2\u0328\u0329"+
		"\7Z\2\2\u0329\u032b\5l\67\2\u032a\u0328\3\2\2\2\u032b\u032e\3\2\2\2\u032c"+
		"\u032a\3\2\2\2\u032c\u032d\3\2\2\2\u032d\u0331\3\2\2\2\u032e\u032c\3\2"+
		"\2\2\u032f\u0331\3\2\2\2\u0330\u0327\3\2\2\2\u0330\u032f\3\2\2\2\u0331"+
		"k\3\2\2\2\u0332\u0338\n\n\2\2\u0333\u0335\7=\2\2\u0334\u0336\5\16\b\2"+
		"\u0335\u0334\3\2\2\2\u0335\u0336\3\2\2\2\u0336\u0337\3\2\2\2\u0337\u0339"+
		"\7>\2\2\u0338\u0333\3\2\2\2\u0338\u0339\3\2\2\2\u0339\u033c\3\2\2\2\u033a"+
		"\u033c\3\2\2\2\u033b\u0332\3\2\2\2\u033b\u033a\3\2\2\2\u033cm\3\2\2\2"+
		"\u033d\u0343\n\13\2\2\u033e\u033f\7=\2\2\u033f\u0340\5n8\2\u0340\u0341"+
		"\7>\2\2\u0341\u0343\3\2\2\2\u0342\u033d\3\2\2\2\u0342\u033e\3\2\2\2\u0343"+
		"\u0346\3\2\2\2\u0344\u0342\3\2\2\2\u0344\u0345\3\2\2\2\u0345o\3\2\2\2"+
		"\u0346\u0344\3\2\2\2\u0347\u0349\7M\2\2\u0348\u034a\5r:\2\u0349\u0348"+
		"\3\2\2\2\u0349\u034a\3\2\2\2\u034a\u035a\3\2\2\2\u034b\u034d\7M\2\2\u034c"+
		"\u034e\5r:\2\u034d\u034c\3\2\2\2\u034d\u034e\3\2\2\2\u034e\u034f\3\2\2"+
		"\2\u034f\u035a\5p9\2\u0350\u0352\7T\2\2\u0351\u0353\5r:\2\u0352\u0351"+
		"\3\2\2\2\u0352\u0353\3\2\2\2\u0353\u035a\3\2\2\2\u0354\u0356\7T\2\2\u0355"+
		"\u0357\5r:\2\u0356\u0355\3\2\2\2\u0356\u0357\3\2\2\2\u0357\u0358\3\2\2"+
		"\2\u0358\u035a\5p9\2\u0359\u0347\3\2\2\2\u0359\u034b\3\2\2\2\u0359\u0350"+
		"\3\2\2\2\u0359\u0354\3\2\2\2\u035aq\3\2\2\2\u035b\u035c\b:\1\2\u035c\u035d"+
		"\5\\/\2\u035d\u0362\3\2\2\2\u035e\u035f\f\3\2\2\u035f\u0361\5\\/\2\u0360"+
		"\u035e\3\2\2\2\u0361\u0364\3\2\2\2\u0362\u0360\3\2\2\2\u0362\u0363\3\2"+
		"\2\2\u0363s\3\2\2\2\u0364\u0362\3\2\2\2\u0365\u036b\5v<\2\u0366\u0367"+
		"\5v<\2\u0367\u0368\7Z\2\2\u0368\u0369\7j\2\2\u0369\u036b\3\2\2\2\u036a"+
		"\u0365\3\2\2\2\u036a\u0366\3\2\2\2\u036bu\3\2\2\2\u036c\u036d\b<\1\2\u036d"+
		"\u036e\5x=\2\u036e\u0374\3\2\2\2\u036f\u0370\f\3\2\2\u0370\u0371\7Z\2"+
		"\2\u0371\u0373\5x=\2\u0372\u036f\3\2\2\2\u0373\u0376\3\2\2\2\u0374\u0372"+
		"\3\2\2\2\u0374\u0375\3\2\2\2\u0375w\3\2\2\2\u0376\u0374\3\2\2\2\u0377"+
		"\u0378\5\66\34\2\u0378\u0379\5b\62\2\u0379\u037f\3\2\2\2\u037a\u037c\5"+
		"8\35\2\u037b\u037d\5~@\2\u037c\u037b\3\2\2\2\u037c\u037d\3\2\2\2\u037d"+
		"\u037f\3\2\2\2\u037e\u0377\3\2\2\2\u037e\u037a\3\2\2\2\u037fy\3\2\2\2"+
		"\u0380\u0381\b>\1\2\u0381\u0382\7k\2\2\u0382\u0388\3\2\2\2\u0383\u0384"+
		"\f\3\2\2\u0384\u0385\7Z\2\2\u0385\u0387\7k\2\2\u0386\u0383\3\2\2\2\u0387"+
		"\u038a\3\2\2\2\u0388\u0386\3\2\2\2\u0388\u0389\3\2\2\2\u0389{\3\2\2\2"+
		"\u038a\u0388\3\2\2\2\u038b\u038d\5L\'\2\u038c\u038e\5~@\2\u038d\u038c"+
		"\3\2\2\2\u038d\u038e\3\2\2\2\u038e}\3\2\2\2\u038f\u039b\5p9\2\u0390\u0392"+
		"\5p9\2\u0391\u0390\3\2\2\2\u0391\u0392\3\2\2\2\u0392\u0393\3\2\2\2\u0393"+
		"\u0397\5\u0080A\2\u0394\u0396\5f\64\2\u0395\u0394\3\2\2\2\u0396\u0399"+
		"\3\2\2\2\u0397\u0395\3\2\2\2\u0397\u0398\3\2\2\2\u0398\u039b\3\2\2\2\u0399"+
		"\u0397\3\2\2\2\u039a\u038f\3\2\2\2\u039a\u0391\3\2\2\2\u039b\177\3\2\2"+
		"\2\u039c\u039d\bA\1\2\u039d\u039e\7=\2\2\u039e\u039f\5~@\2\u039f\u03a3"+
		"\7>\2\2\u03a0\u03a2\5f\64\2\u03a1\u03a0\3\2\2\2\u03a2\u03a5\3\2\2\2\u03a3"+
		"\u03a1\3\2\2\2\u03a3\u03a4\3\2\2\2\u03a4\u03cb\3\2\2\2\u03a5\u03a3\3\2"+
		"\2\2\u03a6\u03a8\7?\2\2\u03a7\u03a9\5r:\2\u03a8\u03a7\3\2\2\2\u03a8\u03a9"+
		"\3\2\2\2\u03a9\u03ab\3\2\2\2\u03aa\u03ac\5,\27\2\u03ab\u03aa\3\2\2\2\u03ab"+
		"\u03ac\3\2\2\2\u03ac\u03ad\3\2\2\2\u03ad\u03cb\7@\2\2\u03ae\u03af\7?\2"+
		"\2\u03af\u03b1\7*\2\2\u03b0\u03b2\5r:\2\u03b1\u03b0\3\2\2\2\u03b1\u03b2"+
		"\3\2\2\2\u03b2\u03b3\3\2\2\2\u03b3\u03b4\5,\27\2\u03b4\u03b5\7@\2\2\u03b5"+
		"\u03cb\3\2\2\2\u03b6\u03b7\7?\2\2\u03b7\u03b8\5r:\2\u03b8\u03b9\7*\2\2"+
		"\u03b9\u03ba\5,\27\2\u03ba\u03bb\7@\2\2\u03bb\u03cb\3\2\2\2\u03bc\u03bd"+
		"\7?\2\2\u03bd\u03be\7M\2\2\u03be\u03cb\7@\2\2\u03bf\u03c1\7=\2\2\u03c0"+
		"\u03c2\5t;\2\u03c1\u03c0\3\2\2\2\u03c1\u03c2\3\2\2\2\u03c2\u03c3\3\2\2"+
		"\2\u03c3\u03c7\7>\2\2\u03c4\u03c6\5f\64\2\u03c5\u03c4\3\2\2\2\u03c6\u03c9"+
		"\3\2\2\2\u03c7\u03c5\3\2\2\2\u03c7\u03c8\3\2\2\2\u03c8\u03cb\3\2\2\2\u03c9"+
		"\u03c7\3\2\2\2\u03ca\u039c\3\2\2\2\u03ca\u03a6\3\2\2\2\u03ca\u03ae\3\2"+
		"\2\2\u03ca\u03b6\3\2\2\2\u03ca\u03bc\3\2\2\2\u03ca\u03bf\3\2\2\2\u03cb"+
		"\u03f7\3\2\2\2\u03cc\u03cd\f\7\2\2\u03cd\u03cf\7?\2\2\u03ce\u03d0\5r:"+
		"\2\u03cf\u03ce\3\2\2\2\u03cf\u03d0\3\2\2\2\u03d0\u03d2\3\2\2\2\u03d1\u03d3"+
		"\5,\27\2\u03d2\u03d1\3\2\2\2\u03d2\u03d3\3\2\2\2\u03d3\u03d4\3\2\2\2\u03d4"+
		"\u03f6\7@\2\2\u03d5\u03d6\f\6\2\2\u03d6\u03d7\7?\2\2\u03d7\u03d9\7*\2"+
		"\2\u03d8\u03da\5r:\2\u03d9\u03d8\3\2\2\2\u03d9\u03da\3\2\2\2\u03da\u03db"+
		"\3\2\2\2\u03db\u03dc\5,\27\2\u03dc\u03dd\7@\2\2\u03dd\u03f6\3\2\2\2\u03de"+
		"\u03df\f\5\2\2\u03df\u03e0\7?\2\2\u03e0\u03e1\5r:\2\u03e1\u03e2\7*\2\2"+
		"\u03e2\u03e3\5,\27\2\u03e3\u03e4\7@\2\2\u03e4\u03f6\3\2\2\2\u03e5\u03e6"+
		"\f\4\2\2\u03e6\u03e7\7?\2\2\u03e7\u03e8\7M\2\2\u03e8\u03f6\7@\2\2\u03e9"+
		"\u03ea\f\3\2\2\u03ea\u03ec\7=\2\2\u03eb\u03ed\5t;\2\u03ec\u03eb\3\2\2"+
		"\2\u03ec\u03ed\3\2\2\2\u03ed\u03ee\3\2\2\2\u03ee\u03f2\7>\2\2\u03ef\u03f1"+
		"\5f\64\2\u03f0\u03ef\3\2\2\2\u03f1\u03f4\3\2\2\2\u03f2\u03f0\3\2\2\2\u03f2"+
		"\u03f3\3\2\2\2\u03f3\u03f6\3\2\2\2\u03f4\u03f2\3\2\2\2\u03f5\u03cc\3\2"+
		"\2\2\u03f5\u03d5\3\2\2\2\u03f5\u03de\3\2\2\2\u03f5\u03e5\3\2\2\2\u03f5"+
		"\u03e9\3\2\2\2\u03f6\u03f9\3\2\2\2\u03f7\u03f5\3\2\2\2\u03f7\u03f8\3\2"+
		"\2\2\u03f8\u0081\3\2\2\2\u03f9\u03f7\3\2\2\2\u03fa\u03fb\7k\2\2\u03fb"+
		"\u0083\3\2\2\2\u03fc\u0407\5,\27\2\u03fd\u03fe\7A\2\2\u03fe\u03ff\5\u0086"+
		"D\2\u03ff\u0400\7B\2\2\u0400\u0407\3\2\2\2\u0401\u0402\7A\2\2\u0402\u0403"+
		"\5\u0086D\2\u0403\u0404\7Z\2\2\u0404\u0405\7B\2\2\u0405\u0407\3\2\2\2"+
		"\u0406\u03fc\3\2\2\2\u0406\u03fd\3\2\2\2\u0406\u0401\3\2\2\2\u0407\u0085"+
		"\3\2\2\2\u0408\u040a\bD\1\2\u0409\u040b\5\u0088E\2\u040a\u0409\3\2\2\2"+
		"\u040a\u040b\3\2\2\2\u040b\u040c\3\2\2\2\u040c\u040d\5\u0084C\2\u040d"+
		"\u0416\3\2\2\2\u040e\u040f\f\3\2\2\u040f\u0411\7Z\2\2\u0410\u0412\5\u0088"+
		"E\2\u0411\u0410\3\2\2\2\u0411\u0412\3\2\2\2\u0412\u0413\3\2\2\2\u0413"+
		"\u0415\5\u0084C\2\u0414\u040e\3\2\2\2\u0415\u0418\3\2\2\2\u0416\u0414"+
		"\3\2\2\2\u0416\u0417\3\2\2\2\u0417\u0087\3\2\2\2\u0418\u0416\3\2\2\2\u0419"+
		"\u041a\5\u008aF\2\u041a\u041b\7[\2\2\u041b\u0089\3\2\2\2\u041c\u041d\b"+
		"F\1\2\u041d\u041e\5\u008cG\2\u041e\u0423\3\2\2\2\u041f\u0420\f\3\2\2\u0420"+
		"\u0422\5\u008cG\2\u0421\u041f\3\2\2\2\u0422\u0425\3\2\2\2\u0423\u0421"+
		"\3\2\2\2\u0423\u0424\3\2\2\2\u0424\u008b\3\2\2\2\u0425\u0423\3\2\2\2\u0426"+
		"\u0427\7?\2\2\u0427\u0428\5\62\32\2\u0428\u0429\7@\2\2\u0429\u042d\3\2"+
		"\2\2\u042a\u042b\7i\2\2\u042b\u042d\7k\2\2\u042c\u0426\3\2\2\2\u042c\u042a"+
		"\3\2\2\2\u042d\u008d\3\2\2\2\u042e\u042f\7;\2\2\u042f\u0430\7=\2\2\u0430"+
		"\u0431\5\62\32\2\u0431\u0433\7Z\2\2\u0432\u0434\7n\2\2\u0433\u0432\3\2"+
		"\2\2\u0434\u0435\3\2\2\2\u0435\u0433\3\2\2\2\u0435\u0436\3\2\2\2\u0436"+
		"\u0437\3\2\2\2\u0437\u0438\7>\2\2\u0438\u0439\7Y\2\2\u0439\u008f\3\2\2"+
		"\2\u043a\u0460\5\u0092J\2\u043b\u0460\5\u0094K\2\u043c\u0460\5\u009aN"+
		"\2\u043d\u0460\5\u009cO\2\u043e\u0460\5\u009eP\2\u043f\u0460\5\u00a6T"+
		"\2\u0440\u0441\t\f\2\2\u0441\u0442\t\r\2\2\u0442\u044b\7=\2\2\u0443\u0448"+
		"\5(\25\2\u0444\u0445\7Z\2\2\u0445\u0447\5(\25\2\u0446\u0444\3\2\2\2\u0447"+
		"\u044a\3\2\2\2\u0448\u0446\3\2\2\2\u0448\u0449\3\2\2\2\u0449\u044c\3\2"+
		"\2\2\u044a\u0448\3\2\2\2\u044b\u0443\3\2\2\2\u044b\u044c\3\2\2\2\u044c"+
		"\u045a\3\2\2\2\u044d\u0456\7X\2\2\u044e\u0453\5(\25\2\u044f\u0450\7Z\2"+
		"\2\u0450\u0452\5(\25\2\u0451\u044f\3\2\2\2\u0452\u0455\3\2\2\2\u0453\u0451"+
		"\3\2\2\2\u0453\u0454\3\2\2\2\u0454\u0457\3\2\2\2\u0455\u0453\3\2\2\2\u0456"+
		"\u044e\3\2\2\2\u0456\u0457\3\2\2\2\u0457\u0459\3\2\2\2\u0458\u044d\3\2"+
		"\2\2\u0459\u045c\3\2\2\2\u045a\u0458\3\2\2\2\u045a\u045b\3\2\2\2\u045b"+
		"\u045d\3\2\2\2\u045c\u045a\3\2\2\2\u045d\u045e\7>\2\2\u045e\u0460\7Y\2"+
		"\2\u045f\u043a\3\2\2\2\u045f\u043b\3\2\2\2\u045f\u043c\3\2\2\2\u045f\u043d"+
		"\3\2\2\2\u045f\u043e\3\2\2\2\u045f\u043f\3\2\2\2\u045f\u0440\3\2\2\2\u0460"+
		"\u0091\3\2\2\2\u0461\u0462\7k\2\2\u0462\u0463\7X\2\2\u0463\u046d\5\u0090"+
		"I\2\u0464\u0465\7\23\2\2\u0465\u0466\5\62\32\2\u0466\u0467\7X\2\2\u0467"+
		"\u0468\5\u0090I\2\u0468\u046d\3\2\2\2\u0469\u046a\7\27\2\2\u046a\u046b"+
		"\7X\2\2\u046b\u046d\5\u0090I\2\u046c\u0461\3\2\2\2\u046c\u0464\3\2\2\2"+
		"\u046c\u0469\3\2\2\2\u046d\u0093\3\2\2\2\u046e\u0470\7A\2\2\u046f\u0471"+
		"\5\u0096L\2\u0470\u046f\3\2\2\2\u0470\u0471\3\2\2\2\u0471\u0472\3\2\2"+
		"\2\u0472\u0473\7B\2\2\u0473\u0095\3\2\2\2\u0474\u0475\bL\1\2\u0475\u0476"+
		"\5\u0098M\2\u0476\u047b\3\2\2\2\u0477\u0478\f\3\2\2\u0478\u047a\5\u0098"+
		"M\2\u0479\u0477\3\2\2\2\u047a\u047d\3\2\2\2\u047b\u0479\3\2\2\2\u047b"+
		"\u047c\3\2\2\2\u047c\u0097\3\2\2\2\u047d\u047b\3\2\2\2\u047e\u0481\5\u0090"+
		"I\2\u047f\u0481\5\64\33\2\u0480\u047e\3\2\2\2\u0480\u047f\3\2\2\2\u0481"+
		"\u0099\3\2\2\2\u0482\u0484\5\60\31\2\u0483\u0482\3\2\2\2\u0483\u0484\3"+
		"\2\2\2\u0484\u0485\3\2\2\2\u0485\u0486\7Y\2\2\u0486\u009b\3\2\2\2\u0487"+
		"\u0488\7 \2\2\u0488\u0489\7=\2\2\u0489\u048a\5\60\31\2\u048a\u048b\7>"+
		"\2\2\u048b\u048e\5\u0090I\2\u048c\u048d\7\32\2\2\u048d\u048f\5\u0090I"+
		"\2\u048e\u048c\3\2\2\2\u048e\u048f\3\2\2\2\u048f\u0497\3\2\2\2\u0490\u0491"+
		"\7,\2\2\u0491\u0492\7=\2\2\u0492\u0493\5\60\31\2\u0493\u0494\7>\2\2\u0494"+
		"\u0495\5\u0090I\2\u0495\u0497\3\2\2\2\u0496\u0487\3\2\2\2\u0496\u0490"+
		"\3\2\2\2\u0497\u009d\3\2\2\2\u0498\u0499\7\62\2\2\u0499\u049a\7=\2\2\u049a"+
		"\u049b\5\60\31\2\u049b\u049c\7>\2\2\u049c\u049d\5\u0090I\2\u049d\u04ad"+
		"\3\2\2\2\u049e\u049f\7\30\2\2\u049f\u04a0\5\u0090I\2\u04a0\u04a1\7\62"+
		"\2\2\u04a1\u04a2\7=\2\2\u04a2\u04a3\5\60\31\2\u04a3\u04a4\7>\2\2\u04a4"+
		"\u04a5\7Y\2\2\u04a5\u04ad\3\2\2\2\u04a6\u04a7\7\36\2\2\u04a7\u04a8\7="+
		"\2\2\u04a8\u04a9\5\u00a0Q\2\u04a9\u04aa\7>\2\2\u04aa\u04ab\5\u0090I\2"+
		"\u04ab\u04ad\3\2\2\2\u04ac\u0498\3\2\2\2\u04ac\u049e\3\2\2\2\u04ac\u04a6"+
		"\3\2\2\2\u04ad\u009f\3\2\2\2\u04ae\u04af\5\u00a2R\2\u04af\u04b1\7Y\2\2"+
		"\u04b0\u04b2\5\u00a4S\2\u04b1\u04b0\3\2\2\2\u04b1\u04b2\3\2\2\2\u04b2"+
		"\u04b3\3\2\2\2\u04b3\u04b5\7Y\2\2\u04b4\u04b6\5\u00a4S\2\u04b5\u04b4\3"+
		"\2\2\2\u04b5\u04b6\3\2\2\2\u04b6\u04c3\3\2\2\2\u04b7\u04b9\5\60\31\2\u04b8"+
		"\u04b7\3\2\2\2\u04b8\u04b9\3\2\2\2\u04b9\u04ba\3\2\2\2\u04ba\u04bc\7Y"+
		"\2\2\u04bb\u04bd\5\u00a4S\2\u04bc\u04bb\3\2\2\2\u04bc\u04bd\3\2\2\2\u04bd"+
		"\u04be\3\2\2\2\u04be\u04c0\7Y\2\2\u04bf\u04c1\5\u00a4S\2\u04c0\u04bf\3"+
		"\2\2\2\u04c0\u04c1\3\2\2\2\u04c1\u04c3\3\2\2\2\u04c2\u04ae\3\2\2\2\u04c2"+
		"\u04b8\3\2\2\2\u04c3\u00a1\3\2\2\2\u04c4\u04c5\5\66\34\2\u04c5\u04c6\5"+
		"<\37\2\u04c6\u04c9\3\2\2\2\u04c7\u04c9\5\66\34\2\u04c8\u04c4\3\2\2\2\u04c8"+
		"\u04c7\3\2\2\2\u04c9\u00a3\3\2\2\2\u04ca\u04cb\bS\1\2\u04cb\u04cc\5,\27"+
		"\2\u04cc\u04d2\3\2\2\2\u04cd\u04ce\f\3\2\2\u04ce\u04cf\7Z\2\2\u04cf\u04d1"+
		"\5,\27\2\u04d0\u04cd\3\2\2\2\u04d1\u04d4\3\2\2\2\u04d2\u04d0\3\2\2\2\u04d2"+
		"\u04d3\3\2\2\2\u04d3\u00a5\3\2\2\2\u04d4\u04d2\3\2\2\2\u04d5\u04d6\7\37"+
		"\2\2\u04d6\u04d7\7k\2\2\u04d7\u04e6\7Y\2\2\u04d8\u04d9\7\26\2\2\u04d9"+
		"\u04e6\7Y\2\2\u04da\u04db\7\22\2\2\u04db\u04e6\7Y\2\2\u04dc\u04de\7&\2"+
		"\2\u04dd\u04df\5\60\31\2\u04de\u04dd\3\2\2\2\u04de\u04df\3\2\2\2\u04df"+
		"\u04e0\3\2\2\2\u04e0\u04e6\7Y\2\2\u04e1\u04e2\7\37\2\2\u04e2\u04e3\5\20"+
		"\t\2\u04e3\u04e4\7Y\2\2\u04e4\u04e6\3\2\2\2\u04e5\u04d5\3\2\2\2\u04e5"+
		"\u04d8\3\2\2\2\u04e5\u04da\3\2\2\2\u04e5\u04dc\3\2\2\2\u04e5\u04e1\3\2"+
		"\2\2\u04e6\u00a7\3\2\2\2\u04e7\u04e9\5\u00aaV\2\u04e8\u04e7\3\2\2\2\u04e8"+
		"\u04e9\3\2\2\2\u04e9\u04ea\3\2\2\2\u04ea\u04eb\7\2\2\3\u04eb\u00a9\3\2"+
		"\2\2\u04ec\u04ed\bV\1\2\u04ed\u04ee\5\u00acW\2\u04ee\u04f3\3\2\2\2\u04ef"+
		"\u04f0\f\3\2\2\u04f0\u04f2\5\u00acW\2\u04f1\u04ef\3\2\2\2\u04f2\u04f5"+
		"\3\2\2\2\u04f3\u04f1\3\2\2\2\u04f3\u04f4\3\2\2\2\u04f4\u00ab\3\2\2\2\u04f5"+
		"\u04f3\3\2\2\2\u04f6\u04fa\5\u00aeX\2\u04f7\u04fa\5\64\33\2\u04f8\u04fa"+
		"\7Y\2\2\u04f9\u04f6\3\2\2\2\u04f9\u04f7\3\2\2\2\u04f9\u04f8\3\2\2\2\u04fa"+
		"\u00ad\3\2\2\2\u04fb\u04fd\5\66\34\2\u04fc\u04fb\3\2\2\2\u04fc\u04fd\3"+
		"\2\2\2\u04fd\u04fe\3\2\2\2\u04fe\u0500\5b\62\2\u04ff\u0501\5\u00b0Y\2"+
		"\u0500\u04ff\3\2\2\2\u0500\u0501\3\2\2\2\u0501\u0502\3\2\2\2\u0502\u0503"+
		"\5\u0094K\2\u0503\u00af\3\2\2\2\u0504\u0505\bY\1\2\u0505\u0506\5\64\33"+
		"\2\u0506\u050b\3\2\2\2\u0507\u0508\f\3\2\2\u0508\u050a\5\64\33\2\u0509"+
		"\u0507\3\2\2\2\u050a\u050d\3\2\2\2\u050b\u0509\3\2\2\2\u050b\u050c\3\2"+
		"\2\2\u050c\u00b1\3\2\2\2\u050d\u050b\3\2\2\2\u008f\u00b9\u00c1\u00d5\u00e6"+
		"\u00f0\u0114\u011e\u012b\u012d\u0138\u0151\u0162\u0170\u0172\u017e\u0180"+
		"\u018c\u018e\u01a0\u01a2\u01ae\u01b0\u01bb\u01c6\u01d1\u01dc\u01e7\u01f0"+
		"\u01f8\u0204\u0211\u0216\u021b\u0222\u022c\u0234\u0247\u024d\u0252\u025b"+
		"\u0266\u026b\u0270\u0274\u0278\u027a\u0284\u0289\u028d\u0291\u0299\u02a2"+
		"\u02ac\u02b4\u02c5\u02d1\u02d4\u02da\u02e3\u02e8\u02eb\u02f2\u0301\u030d"+
		"\u0310\u0312\u031a\u031e\u032c\u0330\u0335\u0338\u033b\u0342\u0344\u0349"+
		"\u034d\u0352\u0356\u0359\u0362\u036a\u0374\u037c\u037e\u0388\u038d\u0391"+
		"\u0397\u039a\u03a3\u03a8\u03ab\u03b1\u03c1\u03c7\u03ca\u03cf\u03d2\u03d9"+
		"\u03ec\u03f2\u03f5\u03f7\u0406\u040a\u0411\u0416\u0423\u042c\u0435\u0448"+
		"\u044b\u0453\u0456\u045a\u045f\u046c\u0470\u047b\u0480\u0483\u048e\u0496"+
		"\u04ac\u04b1\u04b5\u04b8\u04bc\u04c0\u04c2\u04c8\u04d2\u04de\u04e5\u04e8"+
		"\u04f3\u04f9\u04fc\u0500\u050b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}