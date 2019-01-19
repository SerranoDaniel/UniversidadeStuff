%option noyywrap
%option yylineno
%option noinput

%{
#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "yalang.h"
#include "parser.h"


int line   = 0;
int column = 0;

#define INC_RET(x, y) column += x; return(y)
#define INC_COL(x)    column += x
#define INC_LINE      line++; column = 0
%}

INTLIT [0-9]+
ID [a-zA-Z][a-zA-Z0-9_]*
FLOATLIT [0-9]*\.[0.9]+	
STRINGLIT \"[^\"]*\"

%%

";"			{INC_RET(1, SEMI); }
"\""		{INC_RET(1, INV_COMMA); }
"("			{INC_RET(1, LPAR); }
")"			{INC_RET(1, RPAR); }
"["			{INC_RET(1, LRPAR); }
"]"			{INC_RET(1, RRPAR); }
"{"			{INC_RET(1, LCPAR); }
"}"			{INC_RET(1, RCPAR); }
","			{INC_RET(1, COMMA); }
":"			{INC_RET(1, COLON); }
"="			{INC_RET(1, ASSIGN); }

"+"			{INC_RET(1, ADD); }
"-" 		{INC_RET(1, SUB); }
"/"			{INC_RET(1, DIV); }
"*"			{INC_RET(1, MUL); }
"^"			{INC_RET(1, POW); }

"=="		{INC_RET(2, EQ_OP); }
"<"			{INC_RET(1, LT_OP); }
">"			{INC_RET(1, GT_OP); }
"<="		{INC_RET(2, LET_OP); }
">="		{INC_RET(2, GET_OP); }
"!="		{INC_RET(2, NE_OP); }

"mod"		{INC_RET(3, MOD); }
"and"		{INC_RET(3, AND); }
"or"		{INC_RET(2, OR); }
"not"		{INC_RET(3, NOT); }

"int"		{INC_RET(3, T_INT); }
"float"		{INC_RET(5, T_FLOAT); }
"string"	{INC_RET(6, T_STRING); }
"bool"		{INC_RET(4, T_BOOL); }
"void"		{INC_RET(4, VOID); }

"define"	{INC_RET(6, DEFINE); }
"if"		{INC_RET(2, IF); }
"then"		{INC_RET(4, THEN); }
"else"		{INC_RET(4, ELSE); }
"while"		{INC_RET(5, WHILE); }
"do"		{INC_RET(2, DO); }

"return"	{INC_RET(6, RETURN); }
"break"		{INC_RET(5, BREAK); }
"next"		{INC_RET(4, NEXT); }

"input"		{INC_RET(5, INPUT); }
"print"		{INC_RET(5, PRINT); }

{INTLIT}	{ yylval.ival = atof(yytext); INC_RET(strlen(yytext), INTLIT); } 
{FLOATLIT}	{ yylval.fval = atof(yytext); INC_RET(strlen(yytext), FLOATLIT); }
{STRINGLIT}	{ yylval.sval = strdup(yytext); INC_RET(strlen(yytext), STRINGLIT); }

[ \t]+		{INC_COL(strlen(yytext)); }

"true"		{ yylval.bval = 1; INC_RET(4, BOOLLIT); }
"false"		{ yylval.bval = 0; INC_RET(5, BOOLLIT); }

{ID}		{yylval.id = strdup(yytext); return ID; }
\n 			{INC_LINE; }

#.*			{printf("Erro lexical na linha: %d", line); }

%%