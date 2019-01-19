%{
#include <stdlib.h> 
#include "yahh.h"
#include "parser.h"

%}

INT  [0-9]+
FLOAT [0-9]*[.][0-9]*
ID	["]*[_a-zA-Z]*["]*
%%

{INT}   {yylval.val = atof(yytext); return NUM;}
"string" {return T_STRING;}
"input" {return INPUT;}
"int" {return T_INT;}
"float" {return T_FLOAT;}
"void" {return VOID;}
"bool" {return T_BOOL;}
"define" {return DEFINE;}
"then" {return THEN;}
"if" {return IF;}
"else" {return ELSE;}
"return" { return RETURN;}
"while" {return WHILE;}
"%" {return MOD;}
"and" { return AND;}
"or" { return OR;}
"," { return COMMA;}
":" { return COLON;}
"^" { return POWEROF;}
">" { return BIGGERTHAN;}
"<" { return LESSTHAN;}
";" {return SEMI;}
"+"	{ return ADD; }
"!" {return NOT;}
"-"	{ return SUB; }
"/"	{ return DIV; }
"*"	{ return MUL; }
"{" {return LCBRACE;}
"}" {return RCBRACE;}
"[" {return LBRACKET;}
"]" {return RBRACKET;}
"("	{ return LPAR; }
"print" { return PRINT;}
")"	{ return RPAR; }
"="	{ return ASSIGN; }
{ID}	 { yylval.id = strdup(yytext); return ID; }
.	{/*ignorar (- ou dar erro?)*/}


%%

int yywrap()  {return 1;}