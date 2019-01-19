#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#include "symbolTable.h"

//cria e inicializa uma nova lista ligada 
SymbolTable *list_new(){    //aloca e inicializa a lista com NULL's 
	
	SymbolTable *list = malloc(sizeof(LinkedList)); //aloca o espaco necessario para a lista 
	
	// inicializa a lista com tamanho 0 e null na cabeca
	list -> head = node_new();
	list -> size = 0;
	list -> curr = 0;
	
	return list;
}


//cria e inicializa um novo nó
Node *node_new()
{
	Node *thisnode = malloc(sizeof(Node));
	thisnode -> next = NULL;
	return thisnode;
}


void list_insertID(SymbolTable *list, char *id, ya_t_type type)
{
	Node *node = node_new();
	node->id = strdup(id);
	node->type = type->kind;

	Node *tmp;
	tmp =  list->head;

	if(list->head == NULL){
		// se a lista estiver vazia a cabeca passa a ser o item ento que se prentende inserir
		list->head = node;
		list->head->next = NULL;  
		list->size++;
	}
	else{

		// percorre a lista ate ao fim.
    	while(tmp->next != NULL)
			tmp = tmp->next;

		// insere no fim da lista
		node->next = NULL;
		tmp->next = node;
		list->size++;
	}	
}


void list_insertFUNC(SymbolTable *list, char *id, ya_t_type type)
{
	Node *node = node_new();
	node->id = strdup(id);
	node->type = type->kind;

	Node *tmp;
	tmp =  list->head;

	if(list->head == NULL){
		// se a lista estiver vazia a cabeca passa a ser o item ento que se prentende inserir
		list->head = node;
		list->head->next = NULL;  
		list->size++;
	}
	else{

		// percorre a lista ate ao fim.
    	while(tmp->next != NULL)
			tmp = tmp->next;

		// insere no fim da lista
		node->next = NULL;
		tmp->next = node;
		list->size++;
	}	

	list->curr ++;

	new_scope(list);
}

void new_scope(SymbolTable *list)
{
	SymbolTable *nova = list_new();
	nova->old = list;
	list->newl=nova
}

void drop_scope(SymbolTable *list)
{
	SymbolTable *antiga = list->old;
	antiga->new = NULL;
	list.>old = NULL;

	free(list);
}

enum type_kind lookUP(char *id, SymbolTable *list)
{
	SymbolTable *antiga = list->old;
	Node *current = antiga->head->next;

	while(current != NULL)
	{
		if(strcmp(current->id, id)==0)
			return current->type
		else
			current = current->next;
	}
	return NULL;
}