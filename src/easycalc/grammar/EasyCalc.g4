grammar EasyCalc;

program : declar* stmt* '$$';

declar  : type=('bool' | 'int' | 'real') ID ';';

stmt    : ID ':=' expr ';'                      # AssignStmt
        | 'read' ID ';'                         # ReadStmt
        | 'write' expr ';'                      # WriteStmt
        ;

expr    : LIT                                   # LitExpr
        | ID                                    # IdExpr
        | '(' expr ')'                          # ParenExpr
        | op=('to_int'|'to_real') '(' expr ')'  # ToExpr
        | expr op=('*' | '/') expr              # MulDivExpr
        | expr op=('+' | '-') expr              # AddSubExpr
        | expr op=('<' | '>') expr              # LessGrtrExpr
        | expr op='==' expr                     # EqualExpr
        | expr op='and' expr                    # AndExpr
        | expr op='or' expr                     # OrExpr
        | 'if' expr 'then' expr 'else' expr     # IfExpr
        ;

DSTOP   : '$$';
SSTOP   : ';';
BOOL    : 'bool';
INT     : 'int';
REAL    : 'real';
ASSIGN  : ':=';
READ    : 'read';
WRITE   : 'write';
LPAREN  : '(';
RRAPEN  : ')';
TINT    : 'to_int';
TREAL   : 'to_real';
MUL     : '*';
DIV     : '/';
ADD     : '+';
SUB     : '-';
LESS    : '<';
GRTR    : '>';
EQUAL   : '==';
AND     : 'and';
OR      : 'or';
IF      : 'if';
THEN    : 'then';
ELSE    : 'else';

LIT     : [0-9]+ | ([0-9]* ('.' [0-9] | [0-9] '.') [0-9]*) | 'true' | 'false';
ID      : [a-zA-Z][a-zA-Z0-9_]*;

WS      : [ \t\r\n]+ -> skip;