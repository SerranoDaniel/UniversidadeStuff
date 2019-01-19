%{
#include <stdlib.h>
#include "parser.h"

%}

INT			[a-9]+
ID 			[a-zA-Z][a-zA-Z0-9_]*


%%


{INT}		{ yylval.val = atof(yytext); return NUM; }
"+"			{ return ADD; }
"-" 		{ return SUB; }
"/"			{ return DIV; }
"*"			{ return MUL; }
"("			{ return LPAR; }
")"			{ return RPAR; }
"="			{ return ASSIGN; }
"quit"		{ exit(0); }
{ID}		{ yylval.id = strdup(yytext); return ID; }
\N 			{ return NL; }
.			{/*ignorar*/}

%%

int yywrap() {return 1;}