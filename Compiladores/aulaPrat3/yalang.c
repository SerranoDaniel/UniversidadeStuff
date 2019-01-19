#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#include "yalang.h"

struct ya_t_decls_
{
	enum {YA_DECLS_ONE, YA_DECLS_MORE} kind;

	union
	{
		ya_t_decl arg1;
		struct
		{
			ya_t_decl arg1;
			ya_t_decls arg2;
		}decls_more;
	}u;
};

struct ya_t_decl_
{
	enum {YA_DECL_IDTYPE, YA_DECL_ASSIGN, YA_DECL_FUNCTION, YA_DECL_ARGDEFS, YA_DECL_DEFINE} kind;

	union
	{
		struct
		{
			ya_t_ids arg1;
			ya_t_type arg2;
		}decl_idtype;
		struct
		{
			ya_t_ids arg1;
			ya_t_type arg2;
			ya_t_exp arg3;
		}decl_assign;
		struct
		{
			char *id;
			ya_t_type arg2;
			ya_t_stmts arg3;
		}decl_function;
		struct
		{
			char *id;
			ya_t_argdefs arg2;
			ya_t_type arg3;
			ya_t_stmts arg4;
		}decl_argdefs;
		struct
		{
			char *id;
			ya_t_type arg2;
		}decl_define;
	}u;
};

struct ya_t_argdefs_
{
	enum {YA_ARGDEFS_ONE, YA_ARGDEFS_MORE} kind;

	union
	{
		ya_t_argdef arg1;
		struct
		{
			ya_t_argdef arg1;
			ya_t_argdefs arg2;
		}argdefs_more;
	}u;
};

struct ya_t_argdef_ 
{
	enum {YA_ARGDEF_ID} kind;

	union
	{
		struct
		{
			char *id;
			ya_t_type arg1;
		}argdef_id;
	}u;
};

struct ya_t_stmts_ 
{
	enum {YA_STMTS_ONE, YA_STMTS_MORE} kind;

	union
	{
		ya_t_stmt arg1;
		struct
		{
			ya_t_stmt arg1;
			ya_t_stmts arg2;
		}stmts_more;
	}u;
};

struct ya_t_stmt_
{
	enum {YA_STMT_DECL, YA_STMT_EXP, YA_STMT_ASSIGN, YA_STMT_IF, YA_STMT_IFELSE, YA_STMT_WHILE, YA_STMT_RETURN, YA_STMT_PRINT, YA_STMT_INPUT} kind;

	union
	{
		ya_t_decl arg1;
		struct
		{
			char *id;
			ya_t_exp arg1;
		}stmt_exp;
		struct
		{
			char *id;
			ya_t_exp arg1;
		}stmt_assign;
		struct
		{
			ya_t_exp arg1;
			ya_t_stmts arg2;
		}stmt_if;
		struct
		{
			ya_t_exp arg1;
			ya_t_stmts arg2;
			ya_t_stmts arg3;
		}stmt_ifelse;
		struct
		{
			ya_t_exp arg1;
			ya_t_stmts arg2;
		}stmt_while;
		ya_t_exp arg2;
	}u;
};

struct ya_t_ids_
{
	enum {YA_IDS_ONE, YA_IDS_MORE} kind;

	union
	{
		char *id;
		struct
		{
			char *id;
			ya_t_ids arg1;
		}ids_more;
	}u;
};

struct ya_t_type_
{
	enum {YA_TYPE_INT, YA_TYPE_FLOAT, YA_TYPE_STRING, YA_TYPE_BOOL, YA_TYPE_VOID} kind;

};

struct ya_t_exp_
{
	enum {YA_EXP_INTLIT, YA_EXP_STRINGLIT, YA_EXP_FLOATLIT, YA_EXP_BOOLLIT, YA_EXP_ID, YA_EXP_BINOP, YA_EXP_PAR, YA_EXP_ASSIGN}	kind;

	union
	{
		int arg1;
		char* arg2;
		float arg3;
		char *id;
		struct
		{
			ya_t_exp arg1;
			char action[1];
			ya_t_exp arg2;
		}exp_binop;
		ya_t_exp arg4;
		struct
		{
			char *id;
			ya_t_exp arg1;
		}exp_assign;
	}u;
};


/* FUNCOES DECLS */

ya_t_decls ya_decls_one(ya_t_decl arg1)
{
	ya_t_decls ret = (ya_t_decls)malloc(sizeof(*ret));

	ret->kind = YA_DECLS_ONE;
	ret->u.arg1 = arg1;

	return ret;
}

ya_t_decls ya_decls_more(ya_t_decl arg1, ya_t_decls arg2)
{
	ya_t_decls ret = (ya_t_decls)malloc(sizeof(*ret));

	ret->kind = YA_DECLS_MORE;
	ret->u.decls_more.arg1 = arg1;
	ret->u.decls_more.arg2 = arg2;

	return ret;
}


/* FUNCOES DECL */

ya_t_decl ya_decl_idtype(ya_t_ids arg1, ya_t_type arg2)
{
	ya_t_decl ret = (ya_t_decl)malloc(sizeof(*ret));

	ret->kind = YA_DECL_IDTYPE;
	ret->u.decl_idtype.arg1=arg1;
	ret->u.decl_idtype.arg2=arg2;

	return ret;
}

ya_t_decl ya_decl_assign(ya_t_ids arg1, ya_t_type arg2, ya_t_exp arg3)
{
	ya_t_decl ret = (ya_t_decl)malloc(sizeof(*ret));

	ret->kind = YA_DECL_ASSIGN;
	ret->u.decl_assign.arg1 = arg1;
	ret->u.decl_assign.arg2 = arg2;
	ret->u.decl_assign.arg3 = arg3;

	return ret;
}

ya_t_decl ya_decl_function(char *id, ya_t_type arg2, ya_t_stmts arg3)
{
	ya_t_decl ret = (ya_t_decl)malloc(sizeof(*ret));

	ret->kind = YA_DECL_FUNCTION;
	strcpy(ret->u.decl_function.id, id);
	ret->u.decl_function.arg2 = arg2;
	ret->u.decl_function.arg3 = arg3;

	return ret;
}	

ya_t_decl ya_decl_argdefs(char *id, ya_t_argdefs arg2, ya_t_type arg3, ya_t_stmts arg4)
{
	ya_t_decl ret = (ya_t_decl)malloc(sizeof(*ret));

	ret->kind = YA_DECL_ARGDEFS;
	strcpy(ret->u.decl_argdefs.id, id);
	ret->u.decl_argdefs.arg2 = arg2;
	ret->u.decl_argdefs.arg3 = arg3;
	ret->u.decl_argdefs.arg4 = arg4;

	return ret;
}

ya_t_decl ya_decl_define(char *id, ya_t_type arg2)
{
	ya_t_decl ret = (ya_t_decl)malloc(sizeof(*ret));

	ret->kind = YA_DECL_DEFINE;
	ret->u.decl_define.id = id;
	ret->u.decl_define.arg2 = arg2;

	return ret;
}


/* FUNCOES ARFDEFS */

ya_t_argdefs ya_argdefs_one(ya_t_argdef arg1)
{
	ya_t_argdefs ret = (ya_t_argdefs)malloc(sizeof(*ret));

	ret->kind = YA_ARGDEFS_ONE;
	ret->u.arg1 = arg1;

	return ret;
}

ya_t_argdefs ya_argdefs_more(ya_t_argdef arg1, ya_t_argdefs arg2)
{
	ya_t_argdefs ret = (ya_t_argdefs)malloc(sizeof(*ret));

	ret->kind = YA_ARGDEFS_MORE;
	ret->u.argdefs_more.arg1 = arg1;
	ret->u.argdefs_more.arg2 = arg2;
	return ret;
}


/* FUNCOES ARGDEF */

ya_t_argdef ya_argdef_id(char *id, ya_t_type arg1)
{
	ya_t_argdef ret = (ya_t_argdef)malloc(sizeof(*ret));

	ret->kind = YA_ARGDEF_ID;
	ret->u.argdef_id.id = id;
	ret->u.argdef_id.arg1 = arg1;

	return ret;
}


/* FUNCOES STMTS */

ya_t_stmts ya_stmts_one(ya_t_stmt arg1)
{
	ya_t_stmts ret = (ya_t_stmts)malloc(sizeof(*ret));

	ret->kind = YA_STMTS_ONE;
	ret->u.arg1 = arg1;

	return ret;
}

ya_t_stmts ya_stmts_more(ya_t_stmt arg1, ya_t_stmts arg2)
{
	ya_t_stmts ret = (ya_t_stmts)malloc(sizeof(*ret));

	ret->kind = YA_STMTS_MORE;
	ret->u.stmts_more.arg1 = arg1;
	ret->u.stmts_more.arg2 = arg2;

	return ret;
}


/* FUNCOES STMT */

ya_t_stmt ya_stmt_decl(ya_t_decl arg1)
{
	ya_t_stmt ret = (ya_t_stmt)malloc(sizeof(*ret));

	ret->kind = YA_STMT_DECL;
	ret->u.arg1=arg1;

	return ret;
}

ya_t_stmt ya_stmt_exp(char *id, ya_t_exp arg1)
{
	ya_t_stmt ret = (ya_t_stmt)malloc(sizeof(*ret));

	ret->kind = YA_STMT_EXP;
	ret->u.stmt_exp.id = id;
	ret->u.stmt_exp.arg1 = arg1;

	return ret;
}

ya_t_stmt ya_stmt_assign(char *id, ya_t_exp arg1)
{
	ya_t_stmt ret = (ya_t_stmt)malloc(sizeof(*ret));

	ret->kind = YA_STMT_ASSIGN;
	ret->u.stmt_assign.id = id;
	ret->u.stmt_assign.arg1 = arg1;

	return ret;
}

ya_t_stmt ya_stmt_if(ya_t_exp arg1, ya_t_stmts arg2)
{
	ya_t_stmt ret = (ya_t_stmt)malloc(sizeof(*ret));

	ret->kind = YA_STMT_IF;
	ret->u.stmt_if.arg1 = arg1;
	ret->u.stmt_if.arg2 = arg2;

	return ret;
}

ya_t_stmt ya_stmt_ifelse(ya_t_exp arg1, ya_t_stmts arg2, ya_t_stmts arg3)
{
	ya_t_stmt ret = (ya_t_stmt)malloc(sizeof(*ret));

	ret->kind = YA_STMT_IFELSE;
	ret->u.stmt_ifelse.arg1 = arg1;
	ret->u.stmt_ifelse.arg2 = arg2;
	ret->u.stmt_ifelse.arg3 = arg3;

	return ret;
}

ya_t_stmt ya_stmt_while(ya_t_exp arg1, ya_t_stmts arg2)
{
	ya_t_stmt ret = (ya_t_stmt)malloc(sizeof(*ret));

	ret->kind = YA_STMT_WHILE;
	return ret;
}

ya_t_stmt ya_stmt_return(ya_t_exp arg2)
{
	ya_t_stmt ret = (ya_t_stmt)malloc(sizeof(*ret));

	ret->kind = YA_STMT_RETURN;
	ret->u.arg2 = arg2;

	return ret;
}

ya_t_stmt ya_stmt_print(ya_t_exp arg2)
{
	ya_t_stmt ret = (ya_t_stmt)malloc(sizeof(*ret));

	ret->kind = YA_STMT_PRINT;
	ret->u.arg2 = arg2;

	return ret;
}

ya_t_stmt ya_stmt_input(ya_t_exp arg2)
{
	ya_t_stmt ret = (ya_t_stmt)malloc(sizeof(*ret));

	ret->kind = YA_STMT_INPUT;
	ret->u.arg2 = arg2;

	return ret;
}


/* FUNCOES IDS */

ya_t_ids ya_ids_one(char *id)
{
	ya_t_ids ret = (ya_t_ids)malloc(sizeof(*ret));

	ret->kind = YA_IDS_ONE;
	ret->u.id = id;

	return ret;
}

ya_t_ids ya_ids_more(char *id, ya_t_ids arg1)
{
	ya_t_ids ret = (ya_t_ids)malloc(sizeof(*ret));

	ret->kind = YA_IDS_MORE;
	ret->u.ids_more.id = id;
	ret->u.ids_more.arg1 = arg1;

	return ret;
}


/* FUNCOES TYPE */

ya_t_type ya_type_int()
{
	ya_t_type ret = (ya_t_type)malloc(sizeof(*ret));

	ret->kind = YA_TYPE_INT;

	return ret;
}
ya_t_type ya_type_float()
{
	ya_t_type ret = (ya_t_type)malloc(sizeof(*ret));

	ret->kind = YA_TYPE_FLOAT;

	return ret;
}

ya_t_type ya_type_string()
{
	ya_t_type ret = (ya_t_type)malloc(sizeof(*ret));

	ret->kind = YA_TYPE_STRING;

	return ret;
}

ya_t_type ya_type_bool()
{
	ya_t_type ret = (ya_t_type)malloc(sizeof(*ret));

	ret->kind = YA_TYPE_BOOL;

	return ret;
}

ya_t_type ya_type_void()
{
	ya_t_type ret = (ya_t_type)malloc(sizeof(*ret));

	ret->kind = YA_TYPE_VOID;

	return ret;
}


/* FUNCOES EXP */

ya_t_exp ya_exp_intlit(int arg1)
{
	ya_t_exp ret = (ya_t_exp)malloc(sizeof*ret);

	ret->kind = YA_EXP_INTLIT;
	ret->u.arg1 = arg1;

	return ret;
}
ya_t_exp ya_exp_stringlit(char *arg2)
{
	ya_t_exp ret = (ya_t_exp)malloc(sizeof*ret);

	ret->kind = YA_EXP_STRINGLIT;
	ret->u.arg2 = arg2;

	return ret;
}

ya_t_exp ya_exp_floatlit(float arg3)
{
	ya_t_exp ret = (ya_t_exp)malloc(sizeof*ret);

	ret->kind = YA_EXP_FLOATLIT;
	ret->u.arg3 = arg3;

	return ret;
}

ya_t_exp ya_exp_boollit(int arg1)
{
	ya_t_exp ret = (ya_t_exp)malloc(sizeof*ret);

	ret->kind = YA_EXP_BOOLLIT;
	ret->u.arg1 = arg1;

	return ret;
}

ya_t_exp ya_exp_id(char *id)
{
	ya_t_exp ret = (ya_t_exp)malloc(sizeof*ret);

	ret->kind = YA_EXP_ID;
	ret->u.id = id;

	return ret;
}

ya_t_exp ya_exp_binop(ya_t_exp arg1, char action[1], ya_t_exp arg2)
{
	ya_t_exp ret = (ya_t_exp)malloc(sizeof*ret);

	ret->kind = YA_EXP_BINOP;
	ret->u.exp_binop.arg1 = arg1;
	strcpy(ret->u.exp_binop.action, action);
	ret->u.exp_binop.arg2 = arg2;

	return ret;
}

ya_t_exp ya_exp_par(ya_t_exp arg4)
{
	ya_t_exp ret = (ya_t_exp)malloc(sizeof*ret);

	ret->kind = YA_EXP_PAR;
	ret->u.arg4 = arg4;

	return ret;
}

ya_t_exp ya_exp_assign(char *id, ya_t_exp arg1)
{
	ya_t_exp ret = (ya_t_exp)malloc(sizeof*ret);

	ret->kind = YA_EXP_ASSIGN;
	ret->u.exp_assign.id = id;
	ret->u.exp_assign.arg1 = arg1;

	return ret;
}



/* Aqui é a parte dos prints e enquanto faz os prints
	adiciona tambem na symboltable

	nota: A parte de adicionar na symboltable está mal feita pois deveria
	ter estruturado certas coisas de outra maneira, mas está mais ou menos
	estruturado */



void print_decls(ya_t_decls decls, SymbolTable *sT)
{
	switch(decls->kind)
	{
		case YA_DECLS_ONE:
			printf("[.decls \n");
			print_decl(decls->u.arg1, sT);
			printf(" ]\n");
			break;
		case YA_DECLS_MORE:
			printf("[.decls \n");
			print_decl(decls->u.decls_more.arg1, sT);
			print_decls(decls->u.decls_more.arg2, sT);
			printf(" ]\n");
			break;
		default:
			printf("Error in DECLS\n");
	}
}

void print_decl(ya_t_decl decl, SymbolTable *sT)
{
	switch(decl->kind)
	{
		case YA_DECL_IDTYPE:
			printf("[. decl\n");
			print_type(decl->u.decl_idtype.arg2, sT);
			print_ids(decl->u.decl_idtype.arg1, sT);
			printf(" ]\n");
			break;
		case YA_DECL_ASSIGN:
			printf("[. decl\n");
			print_ids(decl->u.decl_assign.arg1, sT);
			print_type(decl->u.decl_assign.arg2, sT);
			print_exp(decl->u.decl_assign.arg3, sT);
			printf(" ]\n");
			break;
		case YA_DECL_FUNCTION:
			printf("[. decl [. id [ $%s$ ] ]\n", decl->u.decl_function.id);
			print_type(decl->u.decl_function.arg2, sT);

			printf("FUNCTION\n");
			//list_insertFUNC(sT, decl->u.decl_function.id, decl->u.decl_function.arg2);
			print_stmts(decl->u.decl_function.arg3, sT);
			printf(" ]\n");
			break;
		case YA_DECL_ARGDEFS:
			printf("[. decl\n");
			printf("[. decl [. id [ $%s$ ] ]\n", decl->u.decl_argdefs.id);
			print_argdefs(decl->u.decl_argdefs.arg2, sT);
			print_type(decl->u.decl_argdefs.arg3, sT);

			printf("FUNCTION\n");
			//list_insertFUNC(sT, decl->u.decl_argdefs.id, decl->u.decl_argdefs.arg3);
			print_stmts(decl->u.decl_argdefs.arg4, sT);
			printf(" ]\n");
			break;
		case YA_DECL_DEFINE:
			printf("[. decl [. id [ $%s$ ] ]\n", decl->u.decl_define.id);
			print_type(decl->u.decl_define.arg2, sT);
			printf(" ]\n");
			break;
		default:
			printf("Error in decl\n");
	}
}

void print_argdefs(ya_t_argdefs argdefs, SymbolTable *sT)
{
	switch(argdefs->kind)
	{
		case YA_ARGDEFS_ONE:
			printf("[. argdefs\n");
			print_argdef(argdefs->u.arg1, sT);
			printf(" ]\n");
			break;
		case YA_ARGDEFS_MORE:
			printf("[. argdefs\n");
			print_argdef(argdefs->u.argdefs_more.arg1, sT);
			print_argdefs(argdefs->u.argdefs_more.arg2, sT);
			printf(" ]\n");
			break;
		default:
			printf("Error in argdefs\n");
	}
}

void print_argdef(ya_t_argdef argdef, SymbolTable *sT)
{
	switch(argdef->kind)
	{
		case YA_ARGDEF_ID:
			printf("[. argdef [. id [ $%s$ ] ]\n", argdef->u.argdef_id.id);
			print_type(argdef->u.argdef_id.arg1, sT);
			printf(" ]\n");
			break;
		default:
			printf("Error in argdef\n");
	}
}

void print_stmts(ya_t_stmts stmts, SymbolTable *sT)
{
	switch(stmts->kind)
	{
		case YA_STMTS_ONE:
			printf("[. stmts\n");
			print_stmt(stmts->u.arg1, sT);
			printf(" ]\n");
			break;
		case YA_STMTS_MORE:
			printf("[. stmts\n");
			print_stmt(stmts->u.stmts_more.arg1, sT);
			print_stmts(stmts->u.stmts_more.arg2, sT);
			printf(" ]\n");
			break;
		default:
			printf("Error in stmts\n");
	}
}

void print_stmt(ya_t_stmt stmt, SymbolTable *sT)
{
	switch(stmt->kind)
	{
		case YA_STMT_DECL:
			printf("[. stmt\n");
			print_decl(stmt->u.arg1, sT);
			printf(" ]\n");
			break;
		case YA_STMT_EXP:
			printf("[. stmt [. exp [. id [ $%s$ ] ] \n", stmt->u.stmt_exp.id);
			print_exp(stmt->u.stmt_exp.arg1, sT);
			printf(" ]\n");
			break;
		case YA_STMT_ASSIGN:
			printf("[. stmt [. assign [. id [ $%s$ ] ] \n", stmt->u.stmt_assign.id);
			print_exp(stmt->u.stmt_assign.arg1, sT);
			printf(" ]\n");
			break;
		case YA_STMT_IF:
			printf("[. stmt [. if ]\n");
			print_exp(stmt->u.stmt_if.arg1, sT);
			print_stmts(stmt->u.stmt_if.arg2, sT);
			printf(" ]\n");
			break;
		case YA_STMT_IFELSE:
			printf("[. stmt [. if else ]\n");
			print_exp(stmt->u.stmt_ifelse.arg1, sT);
			print_stmts(stmt->u.stmt_ifelse.arg2, sT);
			print_stmts(stmt->u.stmt_ifelse.arg3, sT);
			printf(" ]\n");
			break;
		case YA_STMT_WHILE:	
			printf("[. stmt [. while ]\n");
			print_exp(stmt->u.stmt_while.arg1, sT);
			print_stmts(stmt->u.stmt_while.arg2, sT);
			printf(" ]\n");
			break;
		case YA_STMT_RETURN:
			printf("[. stmt [. return ]\n");
			print_exp(stmt->u.arg2, sT);
			printf(" ]\n");
			break;
		case YA_STMT_PRINT:
			printf("[. stmt [. print ]\n");
			print_exp(stmt->u.arg2, sT);
			printf(" ]\n");
			break;
		case YA_STMT_INPUT:
			printf("[. stmt [. input ]\n");
			print_exp(stmt->u.arg2, sT);
			printf(" ]\n");
			break;
		default:
			printf("Error in stmt\n");
	}
}

void print_ids(ya_t_ids ids, SymbolTable *sT)
{
	switch(ids->kind)
	{
		case YA_IDS_ONE:
			printf("[. ids [ $%s$ ] \n", ids->u.id);
			printf(" ]\n");
			break;
		case YA_IDS_MORE:
			printf("[. id [. ids [ $%s$ ] ]\n", ids->u.ids_more.id);
			print_ids(ids->u.ids_more.arg1, sT);
			printf(" ]\n");
			break;
		default:
			printf("Error in ids\n");
	}
}

void print_type(ya_t_type type, SymbolTable *sT)
{
	switch(type->kind)
	{
		case YA_TYPE_INT:
			printf("[. type [ $INTEGER$ ] ]\n");
			break;
		case YA_TYPE_FLOAT:
			printf("[. type [ $FLOAT$ ] ]\n");
			break;
		case YA_TYPE_STRING:
			printf("[. type [ $STRING$ ] ]\n");
			break;
		case YA_TYPE_BOOL:
			printf("[. type [ $BOOL$ ] ]\n");
			break;
		case YA_TYPE_VOID:
			printf("[. type [ $VOID$ ] ]\n");
			break;
		default:
			printf("Error in type\n");
	}
}

void print_exp(ya_t_exp exp, SymbolTable *sT)
{
	switch(exp->kind)
	{
		case YA_EXP_INTLIT:
			printf("[. exp\n");
			printf("[. literals [. int [ $%d$ ] ] ]\n", exp->u.arg1);
			printf(" ]\n");
			break;
		case YA_EXP_STRINGLIT:
			printf("[. exp\n");
			printf("[. literals [. string [ $%s$ ] ] ]\n", exp->u.arg2);
			printf(" ]\n");
			break;
		case YA_EXP_FLOATLIT:
			printf("[. exp\n");
			printf("[. literals [. float [ $%f$ ] ] ]\n", exp->u.arg3);
			printf(" ]\n");
			break;
		case YA_EXP_BOOLLIT:
			printf("[. exp\n");
			printf("[. literals [. int [ $BOOL$ ] ] ]\n");
			printf(" ]\n");
			break;
		case YA_EXP_ID:
			printf("[. exp\n");
			printf("[. literals [. id [ $%s$ ] ] ]\n", exp->u.id);
			printf(" ]\n");
			break;
		case YA_EXP_BINOP:
			printf("[. exp\n");
			print_exp(exp->u.exp_binop.arg1, sT);
			printf("[. binop [ $%s$\n", exp->u.exp_binop.action);
			print_exp(exp->u.exp_binop.arg2, sT);
			printf(" ]\n");
			break;
		case YA_EXP_PAR:
			printf("[. exp  [. par ]\n");
			print_exp(exp->u.arg4, sT);
			printf(" ]\n");
			break;
		case YA_EXP_ASSIGN:
			printf("[. exp [. assign [ $%s$ ] ]\n", exp->u.exp_assign.id);
			print_exp(exp->u.exp_assign.arg1, sT);
			printf(" ]\n");
			break;
	}
}
