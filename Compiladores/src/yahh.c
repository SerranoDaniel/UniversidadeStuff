#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "yahh.h"

char variavel[800];

struct decls_t_ {
	enum {DECLS_SOLO, DECLS_RECURSIVE} kind;


	union{
	struct{
    decl_t arg1;
	} decls_solo;
	struct{
		decl_t arg1;
    decls_t arg2;
	} decls_recursive;
	}u;
};

struct decl_t_ {
  enum {DECL_ID, DECL_FUNCTION, DECL_ASSIGN, DECL_DEFINE,DECL_ARGDEF} kind;


  union{
  struct{
    ids_t arg1;
    typee_t arg2;
  } decl_id;
  struct {
    ids_t arg1;
    typee_t arg2;
    stms_t arg3; 
  }decl_function;
  struct {
    ids_t arg1;
    typee_t arg2;
    exp_t arg3; 
  }decl_assign;
  struct {
    char *id;
    typee_t arg;
  }decl_define;
  struct {
    ids_t arg1;
    argdefs_t arg2;
    typee_t arg3;
    stms_t arg4; 
  }decl_argdef;
  }u;
};



struct ids_t_{
  enum {IDS_SOLO, IDS_RECURSIVE} kind;

  union{
    struct{
      char *id;
    }ids_solo;
    struct{
      char *id;
      ids_t arg1;
    }ids_recursive;
  }u;
};

struct typee_t_{
  enum {TYPE_INT, TYPE_FLOAT, TYPE_STRING, TYPE_BOOL, TYPE_VOID} kind;
};

struct stms_t_{
  enum {STMS_UNIQUE, STMS_DOUBLEE} kind;

  union{
    struct{
      stm_t arg;
    }stms_unique;
    struct{
      stm_t arg1;
      stms_t arg2;
    }stms_doublee;
  }u;
};


struct stm_t_{
  enum {STM_DECLS, STM_EXP, STM_RETURN , STM_IF, STM_WHILE, STM_PRINT, STM_INPUT } kind;
  union{
    struct{
      decls_t arg;
    }stm_decls;
    struct{
      exp_t arg;
    }stm_exp;
    struct{
      exp_t arg;
    }stm_return;
    struct{
      boolexp_t arg1;
      stms_t arg2;
    }stm_if;
    struct{
      boolexp_t arg1;
      stms_t arg2;
    }stm_while;
    struct{
      char *id;
    }stm_print;
    struct{
      char *id;
    }stm_input;
  }u;
};

struct args_t_ {
  enum {ARGS_UNIQUE, ARGS_DOUBLEE} kind;

  union{
    struct{
      exp_t arg;
    }unique;
    struct{
      exp_t arg1;
      args_t arg2;
    }doublee;
  }u;
};

struct argdef_t_ {
  enum {ARGDEF_UNIQUE} kind;

  union{
    struct{
      char *id;
      typee_t arg;
    }unique;
  }u;
};


struct argdefs_t_ {
  enum {ARGDEFS_UNICO, ARGDEFS_DOUBLE} kind;

  union{
    struct{
      argdef_t arg;
    }unico;
    struct{
      argdef_t arg1;
      argdefs_t arg2;
    }doublee;
  }u;
};

struct exp_t_{
  enum {EXP_NUM, EXP_ID, EXP_BINOP, EXP_EXPE, EXP_NAME, EXP_ARGS, EXP_FUNCAO} kind;
  union{
    int num;
    char *id;
    struct{
      char op[3];
      exp_t arg1;
      exp_t arg2;
    }binop;
    struct{
      exp_t arg;
    }expe;
   struct{
      char *id;
    }exp_name;
   struct{
      char *id1;
      char *id2;
    }exp_funcao;
    struct{
      char *id;
      args_t arg;
    }exp_args;
  }u;
};


struct boolexp_t_{
  enum {BOOLEXP_UNIQUE, BOOLEXP_AND, BOOLEXP_OR, BOOLEXP_UNOP, BOOLEXP_DUPLO, BOOLEXP_BINOP} kind;
  union{
    struct{
      char op[3];
      exp_t arg1;
      exp_t arg2;
    }boolexp_binop;
   struct{
      char op1[3];
      char op2[3];
      exp_t arg1;
      exp_t arg2;
    }boolexp_duplo;
    struct{
      exp_t arg;
    }boolexp_unique;
  struct{
      char op[3];
      exp_t arg;
    }boolexp_unop;
  struct{
      boolexp_t arg1;
      boolexp_t arg2;
    }boolexp_and;
  struct{
      boolexp_t arg1;
      boolexp_t arg2;
    }boolexp_or;
  }u;
};


//DECLSSS

decls_t decls_solo(decl_t arg1)
{
  decls_t ret = (decls_t) malloc (sizeof (*ret));

  ret->kind = DECLS_SOLO;
  ret->u.decls_solo.arg1 = arg1;

  return ret;
}

decls_t decls_recursive(decl_t arg1, decls_t arg2)
{
  decls_t ret = (decls_t) malloc (sizeof (*ret));

  ret->kind = DECLS_RECURSIVE;
  ret->u.decls_recursive.arg1 = arg1;
  ret->u.decls_recursive.arg2 = arg2;
  return ret;
}

//DECL

decl_t decl_id(ids_t arg1, typee_t arg2)
{
  decl_t ret = (decl_t) malloc (sizeof (*ret));

  ret->kind = DECL_ID;
  ret->u.decl_id.arg1= arg1;
  ret->u.decl_id.arg2= arg2;

  return ret;
}


decl_t decl_function(ids_t arg1, typee_t arg2, stms_t arg3){

  decl_t ret = (decl_t) malloc (sizeof (*ret));

  ret->kind = DECL_FUNCTION;
  ret->u.decl_function.arg1= arg1;
  ret->u.decl_function.arg2= arg2;
  ret->u.decl_function.arg3= arg3;
  return ret;

}

decl_t decl_assign(ids_t arg1, typee_t arg2, exp_t arg3){

  decl_t ret = (decl_t) malloc (sizeof (*ret));

  ret->kind = DECL_ASSIGN;
  ret->u.decl_assign.arg1= arg1;
  ret->u.decl_assign.arg2= arg2;
  ret->u.decl_assign.arg3= arg3;
  return ret;

}

decl_t decl_define(char *id, typee_t arg){

  decl_t ret = (decl_t) malloc (sizeof(*ret));

  ret->kind=DECL_DEFINE;
  ret->u.decl_define.id=id;
  ret->u.decl_define.arg=arg;
  return ret; 
}

 decl_t decl_argdef(ids_t arg1, argdefs_t arg2, typee_t arg3 , stms_t arg4 ){

  decl_t ret = (decl_t) malloc (sizeof(*ret));

  ret->kind=DECL_ARGDEF;
  ret->u.decl_argdef.arg1=arg1;
  ret->u.decl_argdef.arg2=arg2;
  ret->u.decl_argdef.arg3=arg3;
  ret->u.decl_argdef.arg4=arg4;
  return ret; 
}

//ARGDEF


argdef_t argdef_unique(char *id, typee_t arg){

  argdef_t ret = (argdef_t) malloc (sizeof(*ret));

  ret->kind=ARGDEF_UNIQUE;
  ret->u.unique.id=id;
  ret->u.unique.arg=arg;
  return ret; 
}

//ARGS


args_t args_unique(exp_t arg)
{
  args_t ret = (args_t) malloc (sizeof (*ret));

  ret->kind = ARGS_UNIQUE;
  ret->u.unique.arg= arg;
  return ret;
}

args_t args_doublee(exp_t arg1, args_t arg2)
{
  args_t ret = (args_t) malloc (sizeof (*ret));

  ret->kind = ARGS_DOUBLEE;
  ret->u.doublee.arg1= arg1;
  ret->u.doublee.arg2= arg2;
  return ret;
}

//ARGDEFS

argdefs_t argdefs_unico(argdef_t arg){
 
  argdefs_t ret = (argdefs_t) malloc (sizeof(*ret));

  ret->kind=ARGDEFS_UNICO;
  ret->u.unico.arg=arg;
  return ret; 
}

argdefs_t argdefs_double(argdef_t arg1, argdefs_t arg2){

  argdefs_t ret = (argdefs_t) malloc (sizeof(*ret));

  ret->kind=ARGDEFS_DOUBLE;
  ret->u.doublee.arg1=arg1;
  ret->u.doublee.arg2=arg2;
  return ret; 
}


//IDS

ids_t ids_solo(char *id){
  ids_t ret = (ids_t) malloc (sizeof (*ret));

  ret->kind = IDS_SOLO;
  ret->u.ids_solo.id= id;

  return ret;
}

ids_t ids_recursive(char *id, ids_t arg1){
  ids_t ret = (ids_t) malloc (sizeof (*ret));

  ret->kind = IDS_RECURSIVE;
  ret->u.ids_recursive.id= id;
  ret->u.ids_recursive.arg1= arg1;
  return ret;

}

//STMS
stms_t stms_unique(stm_t arg)
{
  stms_t ret = (stms_t) malloc (sizeof (*ret));
  ret->kind = STMS_UNIQUE;
  ret->u.stms_unique.arg = arg;
  return ret;
}

stms_t stms_doublee(stm_t arg1 ,stms_t arg2)
{
  stms_t ret = (stms_t) malloc (sizeof (*ret));
  ret->kind = STMS_DOUBLEE;
  ret->u.stms_doublee.arg1 = arg1;
  ret->u.stms_doublee.arg2 = arg2;
  return ret;
}

//STM
stm_t stm_decls(decls_t arg){

  stm_t ret = (stm_t) malloc (sizeof(*ret));

  ret->kind=STM_DECLS;
  ret->u.stm_decls.arg=arg;
  return ret; 
}


stm_t stm_exp(exp_t arg){

  stm_t ret = (stm_t) malloc (sizeof(*ret));

  ret->kind=STM_EXP;
  ret->u.stm_exp.arg=arg;
  return ret; 
}

stm_t stm_return(exp_t arg){

  stm_t ret = (stm_t) malloc (sizeof(*ret));

  ret->kind=STM_RETURN;
  ret->u.stm_return.arg=arg;
  return ret; 
}

stm_t stm_if(boolexp_t arg1, stms_t arg2){
  stm_t ret = (stm_t) malloc (sizeof(*ret));

  ret->kind=STM_IF;
  ret->u.stm_if.arg1=arg1;
  ret->u.stm_if.arg2=arg2;
  return ret; 
}

stm_t stm_while(boolexp_t arg1, stms_t arg2){
  stm_t ret = (stm_t) malloc (sizeof(*ret));

  ret->kind=STM_WHILE;
  ret->u.stm_while.arg1=arg1;
  ret->u.stm_while.arg2=arg2;
  return ret; 
}

stm_t stm_printa(char *id){
  stm_t ret = (stm_t) malloc (sizeof (*ret));

  ret->kind = STM_PRINT;
  ret->u.stm_print.id= id;
  return ret;

}


stm_t stm_input(char *id){
  stm_t ret = (stm_t) malloc (sizeof (*ret));

  ret->kind = STM_INPUT;
  ret->u.stm_input.id= id;
  return ret;

}


//TYPE
typee_t type_int(){
  typee_t ret = (typee_t) malloc (sizeof (*ret));

  ret->kind = TYPE_INT;
  return ret;
}

typee_t type_float(){
  typee_t ret = (typee_t) malloc (sizeof (*ret));

  ret->kind = TYPE_FLOAT;
  return ret;
}

typee_t type_string(){
  typee_t ret = (typee_t) malloc (sizeof (*ret));

  ret->kind = TYPE_STRING;
  return ret;
}

typee_t type_bool(){
  typee_t ret = (typee_t) malloc (sizeof (*ret));

  ret->kind = TYPE_BOOL;
  return ret;
}

typee_t type_void(){
  typee_t ret = (typee_t) malloc (sizeof (*ret));

  ret->kind = TYPE_VOID;
  return ret;
}

//exp

exp_t exp_num(int num)
{
  exp_t ret = (exp_t) malloc (sizeof (*ret));

  ret->kind = EXP_NUM;
  ret->u.num = num;

  return ret;
}

exp_t exp_id(char *id)
{
  exp_t ret = (exp_t) malloc (sizeof (*ret));

  ret->kind = EXP_ID;
  ret->u.id = id;

  return ret;
}


exp_t exp_binop(char op[], exp_t arg1, exp_t arg2)
{
  exp_t ret = (exp_t) malloc (sizeof (*ret));

  ret->kind= EXP_BINOP;
  strcpy(ret->u.binop.op,op);
  ret->u.binop.arg1=arg1;
  ret->u.binop.arg2=arg2;

  return ret;
}


exp_t exp_expe(exp_t arg1)
{
  exp_t ret = (exp_t) malloc (sizeof (*ret));

  ret->kind= EXP_EXPE;
  ret->u.expe.arg=arg1;

  return ret;
}


exp_t exp_name(char *id)
{
  exp_t ret = (exp_t) malloc (sizeof (*ret));

  ret->kind= EXP_NAME;
  ret->u.exp_name.id = id;
  return ret;
}

exp_t exp_funcao(char *id1, char *id2)
{
  exp_t ret = (exp_t) malloc (sizeof (*ret));

  ret->kind= EXP_FUNCAO;
  ret->u.exp_funcao.id1 = id1;
  ret->u.exp_funcao.id2 = id2;
  return ret;
}

exp_t exp_args(char *id, args_t arg)
{
  exp_t ret = (exp_t) malloc (sizeof (*ret));

  ret->kind= EXP_NAME;
  ret->u.exp_args.id = id;
  ret->u.exp_args.arg = arg;
  return ret;
}



//BOOLEXP


boolexp_t boolexp_unique(exp_t arg){
  boolexp_t ret = (boolexp_t) malloc (sizeof (*ret));

  ret->kind= BOOLEXP_UNIQUE;
  ret->u.boolexp_unique.arg = arg;
  return ret;
}


boolexp_t boolexp_binop(char op[], exp_t arg1, exp_t arg2){
  boolexp_t ret = (boolexp_t) malloc (sizeof (*ret));

  ret->kind= BOOLEXP_BINOP;
  strcpy(ret->u.boolexp_binop.op,op);
  ret->u.boolexp_binop.arg1 = arg1;
  ret->u.boolexp_binop.arg2 = arg2;
  return ret;
}


boolexp_t boolexp_duplo(char op1[], char op2[],exp_t arg1, exp_t arg2){
  boolexp_t ret = (boolexp_t) malloc (sizeof (*ret));

  ret->kind= BOOLEXP_DUPLO;
  strcpy(ret->u.boolexp_duplo.op1,op1);
  strcpy(ret->u.boolexp_duplo.op2,op2);
  ret->u.boolexp_duplo.arg1 = arg1;
  ret->u.boolexp_duplo.arg2 = arg2;
  return ret;
}

boolexp_t boolexp_unop(char op[], exp_t arg){
  boolexp_t ret = (boolexp_t) malloc (sizeof (*ret));

  ret->kind= BOOLEXP_UNOP;
  strcpy(ret->u.boolexp_unop.op,op);
  ret->u.boolexp_unop.arg = arg;
  return ret;
}

boolexp_t boolexp_boolexp_and(boolexp_t arg1, boolexp_t arg2){
  boolexp_t ret = (boolexp_t) malloc (sizeof (*ret));

  ret->kind= BOOLEXP_AND;
  ret->u.boolexp_and.arg1 = arg1;
  ret->u.boolexp_and.arg2 = arg2;
  return ret;
}

boolexp_t boolexp_boolexp_or(boolexp_t arg1, boolexp_t arg2){
  boolexp_t ret = (boolexp_t) malloc (sizeof (*ret));

  ret->kind= BOOLEXP_OR;
  ret->u.boolexp_or.arg1 = arg1;
  ret->u.boolexp_or.arg2 = arg2;
  return ret;
}




























































//PRINTS

decls_t decls_print(decls_t termo){
  switch (termo->kind) {
    case DECLS_SOLO:
      decl_print(termo->u.decls_solo.arg1);
    break;
    case DECLS_RECURSIVE:
      decl_print(termo->u.decls_recursive.arg1);
      decls_print(termo->u.decls_recursive.arg2);
      break;
    default:
      printf("Error de DECLS\n");
  } 
}


decl_t decl_print(decl_t termo){
  switch (termo->kind) {
    case DECL_ID:
      typee_print(termo->u.decl_id.arg2);
      printf(" ");
      ids_print(termo->u.decl_id.arg1);
      printf(";\n");
    break;
    
    case DECL_FUNCTION:
    typee_print(termo->u.decl_function.arg2);
    printf(" ");
    ids_print(termo->u.decl_function.arg1);
    printf("()");  
    printf("{\n");
    stms_print(termo->u.decl_function.arg3);
    printf("};\n");
    break;
    
    case DECL_ASSIGN:
     typee_print(termo->u.decl_assign.arg2);
     printf(" ");
      ids_print(termo->u.decl_assign.arg1);
      printf("=");
      exp_print(termo->u.decl_assign.arg3);
      printf(";\n");
    break;
    
    case DECL_DEFINE:
      printf("define %s ",termo->u.decl_define.id);
      typee_print(termo->u.decl_define.arg);
      printf(";\n");
    break;

    case DECL_ARGDEF:
      typee_print(termo->u.decl_argdef.arg3);
      printf(" ");
      ids_print(termo->u.decl_argdef.arg1);
      printf("(");
      argdefs_print(termo->u.decl_argdef.arg2);
      printf(")");
      
      printf("{\n");
      stms_print(termo->u.decl_argdef.arg4);
      printf("};\n");
     break;

    default:
      printf("Error de DECL\n");
  } 
}

argdefs_t argdefs_print(argdefs_t termo){
  switch (termo->kind) {
    case ARGDEFS_UNICO:
      argdef_print(termo->u.unico.arg);
    break;
    
    case ARGDEFS_DOUBLE:
    argdef_print(termo->u.doublee.arg1);
    argdefs_print(termo->u.doublee.arg2);
    break;

    default:
      printf("Error de ARGDEFS\n");
  } 
}



argdef_t argdef_print(argdef_t termo){
  switch (termo->kind) {
    case ARGDEF_UNIQUE:
    typee_print(termo->u.unique.arg);
      printf("  %s",termo->u.unique.id);
      
    break;

    default:
      printf("Error de ARGDEF\n");
  } 
}

ids_t ids_print(ids_t termo){
  switch (termo->kind) {
    case IDS_SOLO:
      printf("%s ",termo->u.ids_solo.id);
    break;

    case IDS_RECURSIVE:
      printf("%s , ",termo->u.ids_recursive.id);
      ids_print(termo->u.ids_recursive.arg1);
    break;

    default:
      printf("Error de IDS\n");
  } 
}

typee_t typee_print(typee_t termo){
  switch (termo->kind) {
    case TYPE_INT:
      printf("int");
    break;

    case TYPE_FLOAT:
      printf("float");
    break;

    case TYPE_STRING:
      printf("string");
    break;

    case TYPE_BOOL:
      printf("bool");
    break;

    case TYPE_VOID:
      printf("void");
    break;

    default:
      printf("Error de TYPE\n");
  } 
}


stms_t stms_print(stms_t termo){
  switch (termo->kind) {
    case STMS_UNIQUE:
      stm_print(termo->u.stms_unique.arg);
    break;

    case STMS_DOUBLEE:
      stm_print(termo->u.stms_doublee.arg1);
      stms_print(termo->u.stms_doublee.arg2);
    break;

    default:
      printf("Error de STMS\n");
  } 
}


stm_t stm_print(stm_t termo){
  switch (termo->kind) {
    case STM_DECLS:
      decls_print(termo->u.stm_decls.arg);
    break;

    case STM_EXP:
      exp_print(termo->u.stm_exp.arg);
      printf(";\n");
    break;

  case STM_RETURN:
    printf("return ");
      exp_print(termo->u.stm_return.arg);
    printf(";\n");
    break;

  case STM_IF:
  printf("if (");
        boolexp_print(termo->u.stm_if.arg1);
  printf(") {\n");
        stms_print(termo->u.stm_if.arg2);
  printf("};\n");
    break;

  case STM_WHILE:
   printf("while (");
        boolexp_print(termo->u.stm_while.arg1);
          printf(") {\n");
        stms_print(termo->u.stm_while.arg2);
          printf("};\n");
    break;

    case STM_PRINT:
      printf("print( %s );\n", termo->u.stm_print.id);
      break;

    case STM_INPUT:
      printf("input ( %s );\n", termo->u.stm_input.id);
      break;
    default:
      printf("Error de STM\n");
  } 
}






args_t args_print(args_t termo){
  switch (termo->kind) {
    case ARGS_UNIQUE:
      exp_print(termo->u.unique.arg);
    break;

    case ARGS_DOUBLEE:
      exp_print(termo->u.doublee.arg1);
      printf(" , ");
      args_print(termo->u.doublee.arg2);
    break;

    default:
      printf("Error de ARGS\n");
  } 
}








exp_t exp_print(exp_t termo){
   switch (termo->kind) {
    case EXP_NUM:
      printf("%d ", termo->u.num);
    break;

    case EXP_ID:
      printf("%s ", termo->u.id);
    break;

    case EXP_BINOP:
      exp_print(termo->u.binop.arg1);
      printf("%s ", termo->u.binop.op );
      exp_print(termo->u.binop.arg2);
    break;

    case EXP_EXPE:
    printf("( ");
        exp_print(termo->u.expe.arg);
      printf(") ");
    break;

    case EXP_NAME:
      printf("%s  ()", termo->u.exp_name.id );
    break;

    case EXP_ARGS:
     printf("%s ( ", termo->u.exp_args.id );
      args_print(termo->u.exp_args.arg);
      printf(") ");
    break;


    case EXP_FUNCAO:
      printf("%s  (", termo->u.exp_funcao.id1 );
      printf("%s)", termo->u.exp_funcao.id2 );
    break;   

    default:
      printf("Error de EXP\n");
  } 
}



boolexp_t boolexp_print(boolexp_t termo){
   switch (termo->kind) {
    case BOOLEXP_UNIQUE:
      exp_print(termo->u.boolexp_unique.arg);
    break;

    case BOOLEXP_BINOP:
      exp_print(termo->u.boolexp_binop.arg1);
      printf("%s ", termo->u.boolexp_binop.op);
      exp_print(termo->u.boolexp_binop.arg2);
    break;

    case BOOLEXP_DUPLO:
      exp_print(termo->u.boolexp_duplo.arg1);
      printf("%s", termo->u.boolexp_duplo.op1);
      printf("%s ", termo->u.boolexp_duplo.op2);
      exp_print(termo->u.boolexp_duplo.arg2);
    break;

    case BOOLEXP_UNOP:
      printf("%s ", termo->u.boolexp_unop.op);
      exp_print(termo->u.boolexp_unop.arg);
    break;

    case BOOLEXP_AND:
    boolexp_print(termo->u.boolexp_and.arg1);
      printf("AND ");
          boolexp_print(termo->u.boolexp_and.arg2);
    break;

    case BOOLEXP_OR:
      boolexp_print(termo->u.boolexp_or.arg1);
      printf("OR ");
      boolexp_print(termo->u.boolexp_or.arg2);
    break;


    default:
      printf("Error de BOOLEXP\n");
  } 
}














































































//LISTS

struct node
{
    char *variaveis[30];
    int size;
    struct node *next;
};

struct node *list_new()
{
  struct node *node = malloc(sizeof(struct node));
  node->next=NULL;
  return node;
};

void list_insert_variavel(struct node *list, char *variavel){
  struct node *temp = list_new();
  temp=list;
  while(temp->next!=NULL){
    temp=temp->next;
  }
  int help=temp->size;
  temp->variaveis[help]=variavel;
  help++;
  temp->size=help;
};

void list_insert(struct node *list){
  struct node *novo = list_new();
  struct node *temp = list_new();
  temp=list;
  while(temp->next!=NULL){
    temp=temp->next;
  }
  temp->next=novo;
}


void list_print(struct node *list){
  struct node *temp = list_new();
  temp=list;
  while(temp!=NULL){
    for(int x=0;x<temp->size;x++){
      printf("%s\n", temp->variaveis[x]);
    }
    temp=temp->next;
  };
};














































//Inserção na symbol table

decls_t decls_list(decls_t termo, struct node *list){
  switch (termo->kind) {
    case DECLS_SOLO:
      decl_list(termo->u.decls_solo.arg1, list);
    break;
    case DECLS_RECURSIVE:
      decl_list(termo->u.decls_recursive.arg1,list);
      decls_list(termo->u.decls_recursive.arg2,list);
      break;
    default:
      printf("Error List de DECLS\n");
  } 
}


decl_t decl_list(decl_t termo, struct node *list){
     
  switch (termo->kind) {
    case DECL_ID:
      ids_list(termo->u.decl_id.arg1,list);
      typee_list(termo->u.decl_id.arg2,list);
    break;
    
    case DECL_FUNCTION:
      ids_list(termo->u.decl_function.arg1,list);
      strcat(variavel," function");
      printf("%s\n", variavel );
      list_insert_variavel(list,variavel);
      strcpy(variavel,"");
      printf("{\n");
      stms_list(termo->u.decl_function.arg3,list);
      printf("}\n");
    break;
    
    case DECL_ASSIGN:
      ids_list(termo->u.decl_assign.arg1,list);
      typee_list(termo->u.decl_assign.arg2,list);
      exp_list(termo->u.decl_assign.arg3,list);
    break;
    
    case DECL_DEFINE:
      strcpy(variavel,termo->u.decl_define.id);
      strcat(variavel," ");
      typee_list(termo->u.decl_define.arg,list);
    break;

    case DECL_ARGDEF:
      ids_list(termo->u.decl_argdef.arg1,list);
      strcat(variavel," function");
      printf("%s\n", variavel );
      list_insert_variavel(list,variavel);
      argdefs_list(termo->u.decl_argdef.arg2,list);
      printf("{\n");
      stms_list(termo->u.decl_argdef.arg4,list);
      printf("}\n");
     break;

    default:
      printf("ErrorList de DECL\n");
  } 
}

argdefs_t argdefs_list(argdefs_t termo, struct node *list){
  switch (termo->kind) {
    case ARGDEFS_UNICO:
      argdef_list(termo->u.unico.arg,list);
    break;
    
    case ARGDEFS_DOUBLE:
    argdef_list(termo->u.doublee.arg1,list);
    argdefs_list(termo->u.doublee.arg2,list);
    break;

    default:
      printf("Error de ARGDEFS\n");
  } 
}



argdef_t argdef_list(argdef_t termo,struct node *list){
  switch (termo->kind) {
    case ARGDEF_UNIQUE:
      strcpy(variavel,termo->u.unique.id);
      strcat(variavel," ");
      typee_list(termo->u.unique.arg,list);
    break;

    default:
      printf("Error de ARGDEF\n");
  } 
}

ids_t ids_list(ids_t termo,struct node *list){
  switch (termo->kind) {
    case IDS_SOLO:
      strcat(variavel,termo->u.ids_solo.id);
      strcat(variavel," ");
    break;

    case IDS_RECURSIVE:
      strcat(variavel,termo->u.ids_recursive.id);
      strcat(variavel," ");
      ids_list(termo->u.ids_recursive.arg1,list);
    break;

    default:
      printf("Error de IDS\n");
  } 
}

typee_t typee_list(typee_t termo,struct node *list){
  switch (termo->kind) {
    case TYPE_INT:
      strcat(variavel,"integer");
      printf("%s\n", variavel);
      list_insert_variavel(list,variavel);
      strcpy(variavel,"");

    break;

    case TYPE_FLOAT:
      strcat(variavel,"float");
      printf("%s\n", variavel);
      list_insert_variavel(list,variavel);
      strcpy(variavel,"");
    break;

    case TYPE_STRING:
      strcat(variavel,"string");
      printf("%s\n", variavel);
      list_insert_variavel(list,variavel);
      strcpy(variavel,"");
    break;

    case TYPE_BOOL:
      strcat(variavel,"boolean");
      printf("%s\n", variavel);
      list_insert_variavel(list,variavel);
      strcpy(variavel,"");
    break;

    case TYPE_VOID:
      strcat(variavel,"void");
      printf("%s\n", variavel);
      list_insert_variavel(list,variavel);
      strcpy(variavel,"");

    break;

    default:
      printf("Error de TYPE\n");
  } 
}


stms_t stms_list(stms_t termo,struct node *list){
  switch (termo->kind) {
    case STMS_UNIQUE:
      stm_list(termo->u.stms_unique.arg,list);
    break;

    case STMS_DOUBLEE:
      stm_list(termo->u.stms_doublee.arg1,list);
      stms_list(termo->u.stms_doublee.arg2,list);
    break;

    default:
      printf("Error de STMS\n");
  } 
}


stm_t stm_list(stm_t termo, struct node *list){
  switch (termo->kind) {
    case STM_DECLS:
      decls_list(termo->u.stm_decls.arg,list);
    break;

    case STM_EXP:
      exp_list(termo->u.stm_exp.arg,list);
    break;

  case STM_RETURN:
     exp_list(termo->u.stm_return.arg,list);
    break;

  case STM_IF:
     boolexp_list(termo->u.stm_if.arg1,list);
        stms_list(termo->u.stm_if.arg2,list);
    break;

  case STM_WHILE:
        boolexp_list(termo->u.stm_while.arg1,list);
        stms_list(termo->u.stm_while.arg2,list);
    break;

    case STM_PRINT:
          break;

    case STM_INPUT:
          break;

    default:
      printf("Error de STM\n");
  } 
}





args_t args_list(args_t termo,struct node *list){
  switch (termo->kind) {
    case ARGS_UNIQUE:
      exp_list(termo->u.unique.arg,list);
    break;

    case ARGS_DOUBLEE:
      exp_list(termo->u.doublee.arg1,list);
      args_list(termo->u.doublee.arg2,list);
    break;

    default:
      printf("Error de ARGS\n");
  } 
}








exp_t exp_list(exp_t termo,struct node *list){
   switch (termo->kind) {
    case EXP_NUM:
    break;

    case EXP_ID:
    break;

    case EXP_BINOP:
      exp_list(termo->u.binop.arg1,list);
      exp_list(termo->u.binop.arg2,list);
    break;

    case EXP_EXPE:
        exp_list(termo->u.expe.arg,list);
    break;

    case EXP_NAME:
      ;
    break;

    case EXP_FUNCAO:
      ;
    break;

    case EXP_ARGS:
      args_list(termo->u.exp_args.arg,list);
    break;


    default:
      printf("Error de EXP\n");
  } 
}



boolexp_t boolexp_list(boolexp_t termo,struct node *list){
   switch (termo->kind) {
    case BOOLEXP_UNIQUE:
      exp_list(termo->u.boolexp_unique.arg,list);
    break;

    case BOOLEXP_BINOP:
      exp_list(termo->u.boolexp_binop.arg1,list);
      exp_list(termo->u.boolexp_binop.arg2,list);
    break;

    case BOOLEXP_DUPLO:
      exp_list(termo->u.boolexp_duplo.arg1,list);
      exp_list(termo->u.boolexp_duplo.arg2,list);
    break;

    case BOOLEXP_UNOP:
      exp_list(termo->u.boolexp_unop.arg,list);
    break;

    case BOOLEXP_AND:
    boolexp_list(termo->u.boolexp_and.arg1,list);
    boolexp_list(termo->u.boolexp_and.arg2,list);
    break;

    case BOOLEXP_OR:
      boolexp_list(termo->u.boolexp_or.arg1,list);
      boolexp_list(termo->u.boolexp_or.arg2,list);
    break;


    default:
      printf("Error de BOOLEXP\n");
  } 
}