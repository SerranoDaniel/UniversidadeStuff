#include <stdlib.h>
#include <stdbool.h>
#include <stdio.h>

#include "list.h"

struct node{
	int elemento;
	struct node *next;
};

struct list{
	struct node *head;
	int size;
};

static struct node *node_new(int value, struct node *next)
{
  struct node *node = malloc(sizeof(struct node));

  if (node != NULL)
    {
      node->elemento = value;
      node->next = next;
    }

  return node;
}

struct list *list_new(){
	struct list *list = malloc(sizeof(struct list));

  if (list != NULL)
  {
  	list->head = NULL;  
	list->size = 0;
  }

	return list;
}

bool list_empty(struct list *list){
	return list->size == 0;
}

bool list_insert(struct list *list, int value){
	struct node *node = node_new(value, list->head);

	if(node == NULL)
		return false;

	list->head = node;
	list->size ++;

	return true;
}

int list_find(struct list *list, int value){
	struct node *actual = list->head;

	for(int i=0; i < list->size; i++){
		if(actual->elemento==value)
			return i;
		actual = actual->next;
	}
	return -1;

}

bool list_remove(struct list *list, int value){
	struct node *pointer = list->head;
	struct node *aux;


	if(list_find(list, value) == -1)
		return false;
	for(int i=0; i < list_find(list, value) - 1; i++)
		pointer = pointer->next;

	aux = pointer->next;
	pointer->next = pointer->next->next;

	list->size --;

	//free(aux);

	return true;
	
	
}

void list_print(struct list *list){
	struct node *pointer = list->head;

	printf("[ ");
	if(!list_empty(list))
	{
		do{
			printf("%d ", pointer->elemento);
			pointer = pointer->next;
		}
		while(pointer->next!=NULL);
		printf("%d ", pointer->elemento);

	}
	printf("]\n");
}

void node_destroy(struct node *node)
{
	if(node->next!=NULL)
		node_destroy(node->next);

	free(node);
}


void list_destroy(struct list *list){
	node_destroy(list->head);

	free(list);
}

int list_length(struct list *list)
{
	return list->size;
}

int list_nth(struct list *list, int n)
{
  struct node *node = list->head;

  for (; n > 0; --n)
    node = node->next;

  return node->elemento;
}

