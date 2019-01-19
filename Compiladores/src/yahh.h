#ifndef YAH_H_
#define YAH_H_

//typedef struct prog_t_ *prog_t;
typedef struct decls_t_ *decls_t;
typedef struct decl_t_ *decl_t;
typedef struct ids_t_ *ids_t;
typedef struct typee_t_ *typee_t;
typedef struct exp_t_ *exp_t;
typedef struct argdef_t_ *argdef_t;
typedef struct argdefs_t_ *argdefs_t;
typedef struct stm_t_ *stm_t;
typedef struct stms_t_ *stms_t;
typedef struct args_t_ *args_t;
typedef struct boolexp_t_ *boolexp_t;
struct node *list_new();

//LISTA

void list_insert_variavel(struct node *list, char *variavel);
void list_insert(struct node *list);
void list_print(struct node *list);


//DECLS
decls_t decls_solo(decl_t arg1);
decls_t decls_recursive(decl_t arg1,decls_t arg2);

//DECL
decl_t decl_id(ids_t arg1, typee_t arg2);
decl_t decl_function(ids_t arg1, typee_t arg2, stms_t arg3);
decl_t decl_assign(ids_t arg1,typee_t arg2, exp_t arg3);
decl_t decl_define(char *id, typee_t arg);
decl_t decl_argdef(ids_t arg1, argdefs_t arg2, typee_t arg3, stms_t arg4);
decl_t decl_chamada(ids_t arg1, ids_t arg2);

//ARGDEFS
argdefs_t argdefs_unico(argdef_t arg);
argdefs_t argdefs_double(argdef_t arg1, argdefs_t arg2);

//ARGDEF
argdef_t argdef_unique(char *id, typee_t arg);

//STMS
stms_t stms_unique(stm_t arg);
stms_t stms_doublee(stm_t arg1,stms_t arg2);

//STM
stm_t stm_decls(decls_t arg);
stm_t stm_exp(exp_t arg);
stm_t stm_return(exp_t arg);
stm_t stm_if(boolexp_t arg1 , stms_t arg2);
stm_t stm_while(boolexp_t arg1 , stms_t arg2);
stm_t stm_printa(char *id);
stm_t stm_input(char *id);

//IDS
ids_t ids_solo(char *id);
ids_t ids_recursive(char *id, ids_t arg1);

//type
typee_t type_int();
typee_t type_float();
typee_t type_string();
typee_t type_bool();
typee_t type_void();

//EXP
exp_t exp_num(int num);
exp_t exp_id(char *id);
exp_t exp_binop(char op[], exp_t arg1, exp_t arg2);
exp_t exp_expe(exp_t arg);
exp_t exp_funcao(char *id1, char *id2);
exp_t exp_name(char *id);
exp_t exp_args(char *id, args_t arg);

//ARGS
args_t args_unique(exp_t arg);
args_t args_doublee(exp_t arg1, args_t arg2);


//BOOLEXP
boolexp_t boolexp_unique(exp_t arg);
boolexp_t boolexp_binop(char op[], exp_t arg1, exp_t arg2);
boolexp_t boolexp_duplo(char op1[], char op2[], exp_t arg1, exp_t arg2);
boolexp_t boolexp_unop(char op[], exp_t arg);
boolexp_t boolexp_boolexp_and(boolexp_t arg1, boolexp_t arg2);
boolexp_t boolexp_boolexp_or(boolexp_t arg1, boolexp_t arg2);

//Introdução na symbol table
decls_t decls_list(decls_t termo, struct node *list);
decl_t decl_list(decl_t termo, struct node *list);
argdefs_t argdefs_list(argdefs_t termo, struct node *list);
argdef_t argdef_list(argdef_t termo, struct node *list);
ids_t ids_list(ids_t termo, struct node *list);
typee_t typee_list(typee_t termo, struct node *list);
stms_t stms_list(stms_t termo, struct node *list);
stm_t stm_list(stm_t termo, struct node *list);
args_t args_list(args_t termo, struct node *list);
exp_t exp_list(exp_t termo, struct node *list);
boolexp_t boolexp_list(boolexp_t termo, struct node *list);


//PRINTS - Geraçao de código
decls_t decls_print(decls_t termo);
decl_t decl_print(decl_t termo);
argdefs_t argdefs_print(argdefs_t termo);
argdef_t argdef_print(argdef_t termo);
ids_t ids_print(ids_t termo);
typee_t typee_print(typee_t termo);
stms_t stms_print(stms_t termo);
stm_t stm_print(stm_t termo);
args_t args_print(args_t termo);
exp_t exp_print(exp_t termo);
boolexp_t boolexp_print(boolexp_t termo);

#endif