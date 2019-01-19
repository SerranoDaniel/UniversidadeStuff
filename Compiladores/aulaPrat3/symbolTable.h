/* Symbol table feita com linke list */
#ifndef SYMBOLTABLE_H_
#define SYMBOLTABLE_H_
#include "yalang.h"

typedef struct ya_t_type_ 		*ya_t_type;
enum type_kind {INT_, FLOAT_, STRING_, BOOL_, VOID_};

typedef struct node_
{
	char *id;
	enum type_kind type;
	struct node_ *next;
}Node;

typedef struct SymbolTable{ 
	struct Node *head;
	int size;
	int curr;

	struct SymbolTable *old;
	struct SymbolTable *newl;
} SymbolTable;

SymbolTable *list_new();
Node *node_new();
void list_insertID(SymbolTable *list, char *id, ya_t_type type);
void list_insertFUNC(SymbolTable *list, char *id, ya_t_type type);
void new_scope(SymbolTable *list);
void drop_scope(SymbolTable *list);
enum type_kind lookUP(char *id, SymbolTable *list);

#endif
