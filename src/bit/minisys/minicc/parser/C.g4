grammar C;

primaryExpression:
	Identifier
	| Constant
	| StringLiteral+
	| '(' expression ')'
	| genericSelection;

genericSelection:
	'_Generic' '(' assignmentExpression ',' genericAssocList ')';

genericAssocList:
	genericAssociation
	| genericAssocList ',' genericAssociation;

genericAssociation:
	typeName ':' assignmentExpression
	| 'default' ':' assignmentExpression;

postfixExpression:
	primaryExpression									# postfixExpression_else
	| postfixExpression '[' expression ']'				# ArrayAccess
	| postfixExpression '(' argumentExpressionList? ')'	# FunctionCall
	| postfixExpression '.' Identifier					# postfixExpression__
	| postfixExpression '->' Identifier					# postfixExpression__
	| postfixExpression '++'							# postfixExpression__
	| postfixExpression '--'							# postfixExpression__
	| '(' typeName ')' '{' initializerList '}'			# postfixExpression__
	| '(' typeName ')' '{' initializerList ',' '}'		# postfixExpression__;

argumentExpressionList:
	assignmentExpression
	| argumentExpressionList ',' assignmentExpression;

unaryExpression:
	postfixExpression				# UnaryExpression_else
	| '++' unaryExpression			# UnaryExpression_
	| '--' unaryExpression			# UnaryExpression_
	| unaryOperator castExpression	# UnaryExpression_
	| 'sizeof' unaryExpression		# UnaryTypeName_
	| 'sizeof' '(' typeName ')'		# UnaryTypeName_;

unaryOperator: '&' | '*' | '+' | '-' | '~' | '!';

castExpression:
	'(' typeName ')' castExpression	# CastExpression_
	| unaryExpression				# CastExpression_else
	| DigitSequence					# CastExpression_else; // for 

// multiplicativeExpression: castExpression | multiplicativeExpression '*' castExpression |
// multiplicativeExpression '/' castExpression | multiplicativeExpression '%' castExpression;

// additiveExpression: castExpression # BinaryExpression_else | castExpression '+' castExpression #
// BinaryExpression | castExpression '-' castExpression # BinaryExpression | castExpression '*'
// castExpression # BinaryExpression | castExpression '/' castExpression # BinaryExpression |
// castExpression '%' castExpression # BinaryExpression;

// shiftExpression: additiveExpression | shiftExpression '<<' additiveExpression | shiftExpression
// '>>' additiveExpression;

// relationalExpression: shiftExpression | relationalExpression '<' shiftExpression |
// relationalExpression '>' shiftExpression | relationalExpression '<=' shiftExpression |
// relationalExpression '>=' shiftExpression;

// equalityExpression: relationalExpression | equalityExpression '==' relationalExpression |
// equalityExpression '!=' relationalExpression;

// andExpression: equalityExpression | andExpression '&' equalityExpression;

// exclusiveOrExpression: andExpression | exclusiveOrExpression '^' andExpression;

// inclusiveOrExpression: exclusiveOrExpression | inclusiveOrExpression '|' exclusiveOrExpression;

// logicalAndExpression: inclusiveOrExpression | logicalAndExpression '&&' inclusiveOrExpression;

// logicalOrExpression: logicalAndExpression | logicalOrExpression '||' logicalAndExpression;

logicalOrExpression:
	expr op expr		# BinaryExpression
	| castExpression	# BinaryExpression_else;

op: '&' | '*' | '+' | '-' | '~' | '!' | '=' | '%' | '>' | '<';

expr: Constant | Identifier;

conditionalExpression:
	logicalOrExpression (
		'?' expression ':' conditionalExpression
	)?;

assignmentExpression:
	conditionalExpression										# assignmentExpression1
	| unaryExpression assignmentOperator assignmentExpression	# assignmentExpression2
	| DigitSequence												# assignmentExpression_digit;

assignmentOperator:
	'='
	| '*='
	| '/='
	| '%='
	| '+='
	| '-='
	| '<<='
	| '>>='
	| '&='
	| '^='
	| '|=';

expression:
	assignmentExpression
	| expression ',' assignmentExpression;

constantExpression: conditionalExpression;

declaration:
	declarationSpecifiers initDeclaratorList ';'
	| declarationSpecifiers ';';

declarationSpecifiers: declarationSpecifier+;

declarationSpecifiers2: declarationSpecifier+;

declarationSpecifier: typeSpecifier | typeQualifier;

initDeclaratorList:
	initDeclarator
	| initDeclaratorList ',' initDeclarator;

initDeclarator: declarator | declarator '=' initializer;

typeSpecifier: (
		'void'
		| 'char'
		| 'short'
		| 'int'
		| 'long'
		| 'float'
		| 'double'
		| 'signed'
		| 'unsigned'
	)
	| structOrUnionSpecifier
	| enumSpecifier
	| typedefName
	| typeSpecifier pointer;

structOrUnionSpecifier:
	structOrUnion Identifier? '{' structDeclarationList '}'
	| structOrUnion Identifier;

structOrUnion: 'struct' | 'union';

structDeclarationList:
	structDeclaration
	| structDeclarationList structDeclaration;

structDeclaration:
	specifierQualifierList structDeclaratorList? ';';

specifierQualifierList:
	typeSpecifier specifierQualifierList?
	| typeQualifier specifierQualifierList?;

structDeclaratorList:
	structDeclarator
	| structDeclaratorList ',' structDeclarator;

structDeclarator:
	declarator
	| declarator? ':' constantExpression;

enumSpecifier:
	'enum' Identifier? '{' enumeratorList '}'
	| 'enum' Identifier? '{' enumeratorList ',' '}'
	| 'enum' Identifier;

enumeratorList: enumerator | enumeratorList ',' enumerator;

enumerator:
	enumerationConstant
	| enumerationConstant '=' constantExpression;

enumerationConstant: Identifier;

typeQualifier: 'const';

declarator: pointer? directDeclarator;

directDeclarator:
	Identifier																	# variableDeclarator
	| '(' declarator ')'														# variableDeclarator
	| directDeclarator '[' typeQualifierList? assignmentExpression? ']'			# arrayDeclarator
	| directDeclarator '[' 'static' typeQualifierList? assignmentExpression ']'	# arrayDeclarator
	| directDeclarator '[' typeQualifierList 'static' assignmentExpression ']'	# arrayDeclarator
	| directDeclarator '[' typeQualifierList? '*' ']'							# arrayDeclarator
	| directDeclarator '(' parameterTypeList ')'								# functionDeclarator
	| directDeclarator '(' identifierList? ')'									# functionDeclarator;

pointer:
	'*' typeQualifierList?
	| '*' typeQualifierList? pointer;

typeQualifierList:
	typeQualifier
	| typeQualifierList typeQualifier;

parameterTypeList: parameterList | parameterList ',' '...';

parameterList:
	parameterDeclaration
	| parameterList ',' parameterDeclaration;

parameterDeclaration:
	declarationSpecifiers declarator
	| declarationSpecifiers2 abstractDeclarator?;

identifierList: Identifier | identifierList ',' Identifier;

typeName: specifierQualifierList abstractDeclarator?; //typeName?

abstractDeclarator: pointer | pointer? directAbstractDeclarator;

directAbstractDeclarator:
	'[' typeQualifierList? assignmentExpression? ']'
	| '[' 'static' typeQualifierList? assignmentExpression ']'
	| '[' typeQualifierList 'static' assignmentExpression ']'
	| '[' '*' ']'
	| '(' parameterTypeList? ')'
	| directAbstractDeclarator '[' typeQualifierList? assignmentExpression? ']'
	| directAbstractDeclarator '[' 'static' typeQualifierList? assignmentExpression ']'
	| directAbstractDeclarator '[' typeQualifierList 'static' assignmentExpression ']'
	| directAbstractDeclarator '[' '*' ']'
	| directAbstractDeclarator '(' parameterTypeList? ')';

typedefName: Identifier;

initializer:
	assignmentExpression			# initializer_direct
	| '{' initializerList '}'		# initializer_direct_
	| '{' initializerList ',' '}'	# initializer_direct_;

initializerList:
	designation? initializer
	| initializerList ',' designation? initializer;

designation: designatorList '=';

designatorList: designator | designatorList designator;

designator: '[' constantExpression ']' | '.' Identifier;

statement:
	labeledStatement
	| compoundStatement
	| expressionStatement
	| selectionStatement
	| iterationStatement
	| jumpStatement;

labeledStatement:
	Identifier ':' statement
	| 'case' constantExpression ':' statement
	| 'default' ':' statement;

compoundStatement: '{' blockItemList? '}';

blockItemList: blockItem | blockItemList blockItem;

blockItem: statement | declaration;

expressionStatement: expression? ';';

selectionStatement:
	'if' '(' expression ')' statement ('else' statement)?
	| 'switch' '(' expression ')' statement;

iterationStatement:
	While '(' expression ')' statement
	| Do statement While '(' expression ')' ';'
	| For '(' forCondition ')' statement;

forCondition:
	forDeclaration ';' forExpression? ';' forExpression?
	| expression? ';' forExpression? ';' forExpression?;

forDeclaration:
	declarationSpecifiers initDeclaratorList
	| declarationSpecifiers;

forExpression:
	assignmentExpression
	| forExpression ',' assignmentExpression;

jumpStatement:
	'goto' Identifier ';'		# GotoStatement
	| 'continue' ';'			# ContinueStatement
	| 'break' ';'				# BreakStatement
	| 'return' expression? ';'	# ReturnStatement;

compilationUnit: translationUnit? EOF;

translationUnit:
	externalDeclaration
	| translationUnit externalDeclaration;

externalDeclaration: functionDefinition | declaration | ';';

functionDefinition:
	declarationSpecifiers? declarator declarationList? compoundStatement;

declarationList: declaration | declarationList declaration;

Auto: 'auto';
Break: 'break';
Case: 'case';
Char: 'char';
Const: 'const';
Continue: 'continue';
Default: 'default';
Do: 'do';
Double: 'double';
Else: 'else';
Enum: 'enum';
Extern: 'extern';
Float: 'float';
For: 'for';
Goto: 'goto';
If: 'if';
Inline: 'inline';
Int: 'int';
Long: 'long';
Register: 'register';
Restrict: 'restrict';
Return: 'return';
Short: 'short';
Signed: 'signed';
Sizeof: 'sizeof';
Static: 'static';
Struct: 'struct';
Switch: 'switch';
Typedef: 'typedef';
Union: 'union';
Unsigned: 'unsigned';
Void: 'void';
While: 'while';

LeftParen: '(';
RightParen: ')';
LeftBracket: '[';
RightBracket: ']';
LeftBrace: '{';
RightBrace: '}';

Less: '<';
LessEqual: '<=';
Greater: '>';
GreaterEqual: '>=';
LeftShift: '<<';
RightShift: '>>';

Plus: '+';
PlusPlus: '++';
Minus: '-';
MinusMinus: '--';
Star: '*';
Div: '/';
Mod: '%';

And: '&';
Or: '|';
AndAnd: '&&';
OrOr: '||';
Caret: '^';
Not: '!';
Tilde: '~';

Question: '?';
Colon: ':';
Semi: ';';
Comma: ',';

Assign: '=';
StarAssign: '*=';
DivAssign: '/=';
ModAssign: '%=';
PlusAssign: '+=';
MinusAssign: '-=';
LeftShiftAssign: '<<=';
RightShiftAssign: '>>=';
AndAssign: '&=';
XorAssign: '^=';
OrAssign: '|=';

Equal: '==';
NotEqual: '!=';

Arrow: '->';
Dot: '.';
Ellipsis: '...';

Identifier: IdentifierNondigit ( IdentifierNondigit | Digit)*;

fragment IdentifierNondigit:
	Nondigit
	| UniversalCharacterName; //|   // other implementation-defined characters...

fragment Nondigit: [a-zA-Z_];

fragment Digit: [0-9];

fragment UniversalCharacterName:
	'\\u' HexQuad
	| '\\U' HexQuad HexQuad;

fragment HexQuad:
	HexadecimalDigit HexadecimalDigit HexadecimalDigit HexadecimalDigit;

Constant:
	IntegerConstant
	| FloatingConstant
	//|   EnumerationConstant
	| CharacterConstant;

fragment IntegerConstant:
	DecimalConstant IntegerSuffix?
	| OctalConstant IntegerSuffix?
	| HexadecimalConstant IntegerSuffix?
	| BinaryConstant;

fragment BinaryConstant: '0' [bB] [0-1]+;

fragment DecimalConstant: NonzeroDigit Digit*;

fragment OctalConstant: '0' OctalDigit*;

fragment HexadecimalConstant:
	HexadecimalPrefix HexadecimalDigit+;

fragment HexadecimalPrefix: '0' [xX];

fragment NonzeroDigit: [1-9];

fragment OctalDigit: [0-7];

fragment HexadecimalDigit: [0-9a-fA-F];

fragment IntegerSuffix:
	UnsignedSuffix LongSuffix?
	| UnsignedSuffix LongLongSuffix
	| LongSuffix UnsignedSuffix?
	| LongLongSuffix UnsignedSuffix?;

fragment UnsignedSuffix: [uU];

fragment LongSuffix: [lL];

fragment LongLongSuffix: 'll' | 'LL';

fragment FloatingConstant:
	DecimalFloatingConstant
	| HexadecimalFloatingConstant;

fragment DecimalFloatingConstant:
	FractionalConstant ExponentPart? FloatingSuffix?
	| DigitSequence ExponentPart FloatingSuffix?;

fragment HexadecimalFloatingConstant:
	HexadecimalPrefix HexadecimalFractionalConstant BinaryExponentPart FloatingSuffix?
	| HexadecimalPrefix HexadecimalDigitSequence BinaryExponentPart FloatingSuffix?;

fragment FractionalConstant:
	DigitSequence? '.' DigitSequence
	| DigitSequence '.';

fragment ExponentPart:
	'e' Sign? DigitSequence
	| 'E' Sign? DigitSequence;

fragment Sign: '+' | '-';

DigitSequence: Digit+;

fragment HexadecimalFractionalConstant:
	HexadecimalDigitSequence? '.' HexadecimalDigitSequence
	| HexadecimalDigitSequence '.';

fragment BinaryExponentPart:
	'p' Sign? DigitSequence
	| 'P' Sign? DigitSequence;

fragment HexadecimalDigitSequence: HexadecimalDigit+;

fragment FloatingSuffix: 'f' | 'l' | 'F' | 'L';

fragment CharacterConstant:
	'\'' CCharSequence '\''
	| 'L\'' CCharSequence '\''
	| 'u\'' CCharSequence '\''
	| 'U\'' CCharSequence '\'';

fragment CCharSequence: CChar+;

fragment CChar: ~['\\\r\n] | EscapeSequence;

fragment EscapeSequence:
	SimpleEscapeSequence
	| OctalEscapeSequence
	| HexadecimalEscapeSequence
	| UniversalCharacterName;

fragment SimpleEscapeSequence: '\\' ['"?abfnrtv\\];

fragment OctalEscapeSequence:
	'\\' OctalDigit
	| '\\' OctalDigit OctalDigit
	| '\\' OctalDigit OctalDigit OctalDigit;

fragment HexadecimalEscapeSequence: '\\x' HexadecimalDigit+;

StringLiteral: EncodingPrefix? '"' SCharSequence? '"';

fragment EncodingPrefix: 'u8' | 'u' | 'U' | 'L';

fragment SCharSequence: SChar+;

fragment SChar:
	~["\\\r\n]
	| EscapeSequence
	| '\\\n' // Added line
	| '\\\r\n'; // Added line

ComplexDefine: '#' Whitespace? 'define' ~[#\r\n]* -> skip;

IncludeDirective:
	'#' Whitespace? 'include' Whitespace? (
		('"' ~[\r\n]* '"')
		| ('<' ~[\r\n]* '>')
	) Whitespace? Newline -> skip;

// ignore the following asm blocks:
/*
 asm { mfspr x, 286; }
 */
AsmBlock: 'asm' ~'{'* '{' ~'}'* '}' -> skip;

// ignore the lines generated by c preprocessor sample line : '#line 1 "/home/dm/files/dk1.h" 1'
LineAfterPreprocessing: '#line' Whitespace* ~[\r\n]* -> skip;

LineDirective:
	'#' Whitespace? DecimalConstant Whitespace? StringLiteral ~[\r\n]* -> skip;

PragmaDirective:
	'#' Whitespace? 'pragma' Whitespace ~[\r\n]* -> skip;

Whitespace: [ \t]+ -> skip;

Newline: ( '\r' '\n'? | '\n') -> skip;

BlockComment: '/*' .*? '*/' -> skip;

LineComment: '//' ~[\r\n]* -> skip;
