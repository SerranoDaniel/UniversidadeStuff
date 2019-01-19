%{
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "yalang.h"

int yylex (void);	
void yyerror (char const *);
%}

%union {
	int ival;
    float fval;
    char *id;
    char *sval;
    int bval;

struct ya_t_decls_ 		*ya_t_decls;
struct ya_t_decl_ 		*ya_t_decl;
struct ya_t_argdefs_ 	*ya_t_argdefs;
struct ya_t_argdef_ 	*ya_t_argdef;
struct ya_t_stmts_ 		*ya_t_stmts;
struct ya_t_stmt_ 		*ya_t_stmt;
struct ya_t_ids_ 		*ya_t_ids;
struct ya_t_type_ 		*ya_t_type;
struct ya_t_exp_ 		*ya_t_exp;
}

/* Bison declarations.  */

%token	<id>		ID
%token	<ival>		INTLIT
%token	<fval>		FLOATLIT
%token 	<sval>		STRINGLIT
%token 	<bval> 		BOOLLIT


%token 					T_INT T_FLOAT T_STRING T_BOOL VOID

%token					DEFINE RETURN STRUCT WHILE IF THEN DO PRINT INPUT ELSE BREAK NEXT

%token					COLON
%right					ASSIGN
%left					COMMA
%left					SEMI
%token					INV_COMMA


%left					OR
%left					AND
%left					NOT
%left					MOD

%nonassoc				EQ_OP NE_OP GET_OP LET_OP GT_OP LT_OP

%left					SUB ADD
%left					MUL DIV
%right					POW

%nonassoc				LCPAR RCPAR
%nonassoc				LRPAR RRPAR
%nonassoc				LPAR RPAR

%type   <ya_t_decls>    decls
%type   <ya_t_decl>     decl
%type   <ya_t_argdefs>  argdefs
%type   <ya_t_argdef>   argdef
%type   <ya_t_stmts>	stmts
%type   <ya_t_stmt>    	stmt
%type   <ya_t_ids>     	ids
%type	<ya_t_type>		type
%type	<ya_t_exp>		exp


%%

program:		decls	
				;

decls:			decl {$$ = ya_decls_one($1);}
		|		decl decls {$$ = ya_decls_more($1, $2);}
				;

decl:			ids COLON type SEMI {$$ = ya_decl_idtype($1, $3);}
		|		ids COLON type ASSIGN exp SEMI {$$ = ya_decl_assign($1, $3, $5);}
		|		ID LPAR RPAR COLON type LCPAR stmts RCPAR SEMI {$$ = ya_decl_function($1, $5, $7);}
		|		ID LPAR argdefs RPAR COLON type LCPAR stmts RCPAR SEMI {$$ = ya_decl_argdefs($1, $3, $6, $8);}
		|		DEFINE ID type SEMI {$$ = ya_decl_define($2, $3);}
				;

argdefs:		argdef {$$ = ya_argdefs_one($1);}
		|		argdef COMMA argdefs {$$ = ya_argdefs_more($1, $3);}
				;

argdef:			ID COLON type {$$ = ya_argdef_id($1, $3);}
				;

stmts:		stmt {$$ = ya_stmts_one($1);}
		| 	stmt stmts {$$ = ya_stmts_more($1, $2);}
			;

stmt:		decl {$$ = ya_stmt_decl($1);}
		|	ID exp SEMI {$$ = ya_stmt_exp($1, $2);}
		| 	ID ASSIGN exp SEMI {$$ = ya_stmt_assign($1, $3);}
		|	IF exp THEN LCPAR stmts RCPAR SEMI {$$ = ya_stmt_if($2, $5);}
		|	IF exp THEN LCPAR stmts RCPAR ELSE LCPAR stmts RCPAR SEMI {$$ = ya_stmt_ifelse($2, $5, $9);}
		|	WHILE exp DO LCPAR stmts RCPAR SEMI {$$ = ya_stmt_while($2, $5);}
		|	RETURN exp SEMI {$$ = ya_stmt_return($2);}
		| 	PRINT exp SEMI {$$ = ya_stmt_print($2);}
		| 	INPUT exp SEMI {$$ = ya_stmt_input($2);}
			;


ids: 	ID {$$ = ya_ids_one($1);}
	| 	ID COMMA ids {$$ = ya_ids_more($1, $3);}
		;

type: 		T_INT  {$$ = ya_type_int();}
		|	T_FLOAT {$$ = ya_type_float();}
		|	T_STRING {$$ = ya_type_string();}
		|	T_BOOL {$$ = ya_type_bool();}
		|	VOID {$$ = ya_type_void();}
			;

exp:	INTLIT {$$ = ya_exp_intlit($1);}
	|	STRINGLIT {$$ = ya_exp_stringlit($1);}
	|	FLOATLIT {$$ = ya_exp_floatlit($1);}
	|	BOOLLIT {$$ = ya_exp_boollit($1);}
	|	ID {$$ = ya_exp_id($1);}

	|	exp ADD exp	{$$ = ya_exp_binop($1, "+", $3);}
	|	exp SUB exp	{$$ = ya_exp_binop($1, "-", $3);}
	|	exp MUL exp {$$ = ya_exp_binop($1, "*", $3);}
	|	exp DIV exp {$$ = ya_exp_binop($1, "/", $3);}

	|	exp EQ_OP exp {$$ = ya_exp_binop($1, "==", $3);}
	|	exp LT_OP exp {$$ = ya_exp_binop($1, "<", $3);}
	|	exp GT_OP exp {$$ = ya_exp_binop($1, ">", $3);}
	|	exp LET_OP exp {$$ = ya_exp_binop($1, "<=", $3);}
	|	exp GET_OP exp {$$ = ya_exp_binop($1, ">=", $3);}
	|	exp NE_OP exp {$$ = ya_exp_binop($1, "!=", $3);}

	|	LPAR exp RPAR {$$ = ya_exp_par($2);}
	| 	ID LPAR exp RPAR {$$ = ya_exp_assign($1, $3);}
		;
		

%%

void yyerror(const char *msg)
{
	extern int yylineno;
	extern int line;
	extern int column;
	fprintf(stderr, "Error: %s\n", msg);
	fprintf(stderr, "ERRO NA LINHA: %d   \n\tCOLUNA:%d\n", yylineno,column);
}
int main (void)
{
	return yyparse();
}