%{
#include <stdio.h>
#include "yahh.h"

int yylex (void);
void yyerror (char const *);
%}
			
%union {
    double val;
    char *id;

    decls_t decls;
    decl_t decl;
    ids_t ids;
    typee_t typee;
    exp_t exp;
    argdefs_t argdefs;
    argdef_t argdef;
    stm_t stm;
    stms_t stms;
    args_t args;
    boolexp_t boolexp;

}

/* Bison declarations.  */

%token	<val>		NUM
%token	<id>		ID
			
			
//palavra pre definidas

%token			PRINT
%token			THEN
%token			DEFINE
%token			DO
%token			IF
%token			ELSE
%token			RETURN
%token			WHILE
%token			INPUT
//pontos e espaços

%token			COMMA
%token			COLON
%token			SEMI

//brackets

%token			LCBRACE
%token			RCBRACE
%token			LBRACKET
%token			RBRACKET
%token			LPAR 
%token			RPAR

//operadores booleanos

%token			BIGGERTHAN
%token			LESSTHAN
%token			ASSIGN
%token			AND
%token			OR
%token			NOT

//operadores

%token			SUB
%token			DIV
%token			MUL
%token			POWEROF
%token			MOD
%token			ADD

//tipos
%token 			T_STRING
%token			T_INT
%token			T_FLOAT
%token			T_BOOL
%token			VOID



			
%type   <decls>     decls
%type   <decl>      decl
%type   <ids>      	ids
%type	<typee>		typee
%type	<exp>		exp
%type   <argdefs>   argdefs
%type   <argdef>    argdef
%type   <stms>    	stms
%type   <stm>    	stm
%type   <args>    	args
%type   <boolexp>   boolexp

%%

prog: decls { 

			printf("SYMBOL TABLE\n");
			struct node *l= list_new();
			decls_list($1,l);
			printf("\n\n\n");
			printf("Codigo em C do programa original\n");
			printf("#include <stdlib.h>\n#include <stdio.h>\n#include <string.h>\n");
			decls_print($1);
			}
	;

decls: decl { $$ = 	decls_solo($1); }
 	| decl decls {  $$ = decls_recursive($1,$2); }
 ;

decl: ids COLON typee SEMI {$$ = decl_id($1,$3);}
	| ids LPAR RPAR COLON typee LCBRACE stms RCBRACE SEMI { $$ = decl_function($1,$5,$7); }
 	| ids COLON typee ASSIGN exp SEMI{ $$ = decl_assign($1,$3,$5);}
 	| DEFINE ID typee SEMI { $$ = decl_define($2,$3);}
	| ids LPAR argdefs RPAR COLON typee LCBRACE stms RCBRACE SEMI { $$ = decl_argdef($1,$3,$6,$8);}
;

argdefs:	argdef   { $$ = argdefs_unico($1);}
		|	argdef COMMA argdefs  { $$ = argdefs_double($1,$3);}
			;

argdef: ID COLON typee { $$ = argdef_unique($1,$3);}
	;


ids: ID { $$ = ids_solo($1);}
	| ID COMMA ids { $$ = ids_recursive($1,$3);}
	;

typee: 		T_INT  { $$ = type_int();}
		|	T_FLOAT { $$ = type_float();}
		|	T_STRING { $$ = type_string();}
		|	T_BOOL { $$ = type_bool();}
		|	VOID { $$ = type_void();}

stms: stm { $$ = stms_unique($1);}
	| stm stms { $$ = stms_doublee($1,$2);}
	;

stm: decls { $$ = stm_decls($1);}
	| exp SEMI { $$ = stm_exp($1);}
	| PRINT LPAR ID RPAR SEMI{ $$ = stm_printa($3);}
	| INPUT LPAR ID RPAR SEMI{ $$ = stm_input($3);}
	| RETURN exp SEMI { $$ = stm_return($2);}
	| IF boolexp THEN LCBRACE stms RCBRACE SEMI { $$ = stm_if($2,$5);}
	| WHILE boolexp THEN LCBRACE stms RCBRACE SEMI { $$ = stm_while($2,$5);}
			
	;


args:	exp   { $$ = args_unique($1);}
	|	exp COMMA args  { $$ = args_doublee($1,$3);}
	;


exp: NUM { $$ = exp_num($1);}
	| ID { $$ = exp_id($1);}
	| exp ADD exp { $$ = exp_binop("+",$1,$3);}
	| exp SUB exp { $$ = exp_binop("-",$1,$3);}
	| exp MUL exp { $$ = exp_binop("*",$1,$3);}
	| exp DIV exp { $$ = exp_binop("/",$1,$3);}	
	| exp POWEROF exp { $$ = exp_binop("^",$1,$3);}
	| exp ASSIGN exp { $$ = exp_binop("=",$1,$3);}
	| LPAR exp RPAR { $$ = exp_expe($2);}
	| ID LPAR ID RPAR { $$ = exp_funcao($1,$3);}
	| ID LPAR RPAR { $$ = exp_name($1);}
	| ID LPAR args RPAR { $$ = exp_args($1,$3);}
	;

boolexp:	exp { $$ = boolexp_unique($1);}
		|	exp BIGGERTHAN exp { $$ = boolexp_binop(">",$1,$3);}
		|	exp LESSTHAN exp { $$ = boolexp_binop("<",$1,$3);}
		|	exp BIGGERTHAN ASSIGN exp { $$ = boolexp_duplo(">","=",$1,$4);}
		|	exp LESSTHAN ASSIGN exp { $$ = boolexp_duplo("<","=",$1,$4);}
		|	exp ASSIGN ASSIGN exp { $$ = boolexp_duplo("=","=",$1,$4);}
		|	exp NOT ASSIGN exp { $$ = boolexp_duplo("!","=",$1,$4);}
		|	NOT exp { $$ = boolexp_unop("-",$2);} 
		|	boolexp AND boolexp { $$ = boolexp_boolexp_and($1,$3);}
		|	boolexp OR boolexp { $$ = boolexp_boolexp_or($1,$3);}
			;

%%
	
/* Called by yyparse on error.  */
void yyerror (char const *s)
	{
	    fprintf (stderr, "%s\n", s);
	}

int main (void)
{
    return yyparse();
}
