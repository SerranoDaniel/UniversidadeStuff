#ifndef YALANG_H_
#define YALANG_H_

#include "symbolTable.h"

//Structs
typedef struct ya_t_decls_ 		*ya_t_decls;
typedef struct ya_t_decl_ 		*ya_t_decl;
typedef struct ya_t_argdefs_ 	*ya_t_argdefs;
typedef struct ya_t_argdef_ 	*ya_t_argdef;
typedef struct ya_t_stmts_ 		*ya_t_stmts;
typedef struct ya_t_stmt_ 		*ya_t_stmt;
typedef struct ya_t_ids_ 		*ya_t_ids;
typedef struct ya_t_type_ 		*ya_t_type;
typedef struct ya_t_exp_ 		*ya_t_exp;

//Symbol table

typedef struct node_ Node;
typedef struct SymbolTable SymbolTable;

SymbolTable *list_new();
Node *node_new();
void list_insertID(SymbolTable *list, char *id, ya_t_type type);
void list_insertFUNC(SymbolTable *list, char *id, ya_t_type type);
void new_scope(SymbolTable *list);
void drop_scope(SymbolTable *list);
enum type_kind lookUP(char *id, SymbolTable *list);



//DECLS
ya_t_decls ya_decls_one(ya_t_decl arg1);
ya_t_decls ya_decls_more(ya_t_decl arg1, ya_t_decls arg2);

//DECL
ya_t_decl ya_decl_idtype(ya_t_ids arg1, ya_t_type arg2);
ya_t_decl ya_decl_assign(ya_t_ids arg1, ya_t_type arg2, ya_t_exp arg3);
ya_t_decl ya_decl_function(char *id, ya_t_type arg2, ya_t_stmts arg3);
ya_t_decl ya_decl_argdefs(char *id, ya_t_argdefs arg2, ya_t_type arg3, ya_t_stmts arg4);
ya_t_decl ya_decl_define(char *id, ya_t_type arg2);

//ARGDEFS
ya_t_argdefs ya_argdefs_one(ya_t_argdef arg1);
ya_t_argdefs ya_argdefs_more(ya_t_argdef arg1, ya_t_argdefs arg2);

//ARGDEF
ya_t_argdef ya_argdef_id(char *id, ya_t_type arg1);

//STMTS
ya_t_stmts ya_stmts_one(ya_t_stmt arg1);
ya_t_stmts ya_stmts_more(ya_t_stmt arg1, ya_t_stmts arg2);

//STMT
ya_t_stmt ya_stmt_decl(ya_t_decl arg1);
ya_t_stmt ya_stmt_exp(char *id, ya_t_exp arg1);
ya_t_stmt ya_stmt_assign(char *id, ya_t_exp arg1);
ya_t_stmt ya_stmt_if(ya_t_exp arg1, ya_t_stmts arg2);
ya_t_stmt ya_stmt_ifelse(ya_t_exp arg1, ya_t_stmts arg2, ya_t_stmts arg3);
ya_t_stmt ya_stmt_while(ya_t_exp arg1, ya_t_stmts arg2);
ya_t_stmt ya_stmt_return(ya_t_exp arg2);
ya_t_stmt ya_stmt_print(ya_t_exp arg2);
ya_t_stmt ya_stmt_input(ya_t_exp arg2);

//IDS
ya_t_ids ya_ids_one(char *id);
ya_t_ids ya_ids_more(char *id, ya_t_ids arg1);

//TYPE
ya_t_type ya_type_int();
ya_t_type ya_type_float();
ya_t_type ya_type_string();
ya_t_type ya_type_bool();
ya_t_type ya_type_void();

//EXP
ya_t_exp ya_exp_intlit(int arg1);
ya_t_exp ya_exp_stringlit(char* arg2);
ya_t_exp ya_exp_floatlit(float arg3);
ya_t_exp ya_exp_boollit(int arg1);
ya_t_exp ya_exp_id(char *id);
ya_t_exp ya_exp_binop(ya_t_exp arg1, char action[1], ya_t_exp arg2);
ya_t_exp ya_exp_par(ya_t_exp arg4);
ya_t_exp ya_exp_assign(char *id, ya_t_exp arg1);


//PRINTS
void print_decls(ya_t_decls decls, SymbolTable *sT);
void print_decl(ya_t_decl decl, SymbolTable *sT);
void print_argdefs(ya_t_argdefs argdefs, SymbolTable *sT);
void print_argdef(ya_t_argdef argdef, SymbolTable *sT);
void print_stmts(ya_t_stmts stmts, SymbolTable *sT);
void print_stmt(ya_t_stmt stmt, SymbolTable *sT);
void print_ids(ya_t_ids ids, SymbolTable *sT);
void print_type(ya_t_type type, SymbolTable *sT);
void print_exp(ya_t_exp exp, SymbolTable *sT);

#endif