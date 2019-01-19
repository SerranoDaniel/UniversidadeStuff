#include <stdio.h>
#include <stdlib.h>

#define QUANTUM 1

//Struct para cada processo
typedef struct processo

{	int tempoChegada;
	int tempoRestante;
	int pNum;
}P;

//////////////////////////////////////////////////////
/////////////////QUEUE IMPLEMENTATHION////////////////
//////////////////////////////////////////////////////

struct Node
{
	P item;
	struct Node *next;
};

struct Queue
{
	struct Node *head;
	struct Node *tail;
	int size;
};

void init_queue(struct Queue *q)
{
	q->head = NULL;
	q->tail = NULL;
}

void push_queue(struct Queue *queue, P contents)
{
	if (queue->head == NULL) {
		queue->head = (struct Node *) malloc(sizeof(struct Node));
		queue->head->item = contents;
		queue->head->next = NULL;
		queue->tail = queue->head;
	} else {
		queue->tail->next = (struct Node *) malloc(sizeof(struct Node));
		queue->tail->next->item = contents;
		queue->tail->next->next = NULL;
		queue->tail = queue->tail->next;
	}
}

P head(struct Queue *q)
{
	return q->head->item;
}

P pop_queue(struct Queue *queue){
	P popped;
	if (queue->head == NULL){
		return; // causes a compile warning.  Just check for ==NULL when popping.
	} else {
		popped = queue->head->item;
		struct Node *next = queue->head->next;
		free(queue->head);
		queue->head = next;
		if (queue->head == NULL)
			queue->tail = NULL;
	}
	return popped;
}


//////////////////////////////////////////////////////
///////////END OF QUEUE IMPLEMENTATHION///////////////
//////////////////////////////////////////////////////



P *lerInput(int *count, int *tempoTotal)
{
	P *array = calloc(1, sizeof(P));

	while(scanf("%d %d", &array[*count].tempoChegada, &array[*count].tempoRestante)!=EOF)
	{
		*tempoTotal += array[*count].tempoRestante;
		array[*count].pNum = (*count+1);
		*count += 1;
		array = realloc(array, (*count+1)*sizeof(P));
	}

	return array;
}


//Funcao apenas para quando um programa acaba
void exitP(struct Queue *queue)
{
	pop_queue(queue);
}

//Simula (mais ou menos) o estado Run
void run(P *array, struct Queue *queue, int momento)
{
	int i=0;
	while(i!=QUANTUM)
	{
		printf("%d %d\n", momento, queue->head->item.pNum);
		queue->head->item.tempoRestante -= 1;
		if(queue->head->item.tempoRestante == 0)
			exitP(queue);
		i++;
	}

	P aux = pop_queue(queue);
	push_queue(queue, aux);
}

//Funcao que passa a fila "Ready" para o run
void mainProcess(P *array, int *size, int *tempoTotal, struct Queue *queue)
{
	printf("\n");
	for(int i=0; i < *tempoTotal; i+=QUANTUM)
	{
		for(int j=0; j < *size; j++)
		{
			if(array[j].tempoChegada == i)
				push_queue(queue, array[j]);
		}
		run(array, queue, i);
	}
}


int main(void)
{
	int size=0;
	int tempoTotal=0;
	P *inputArray = lerInput(&size, &tempoTotal);

	struct Queue queueReady;
	init_queue(&queueReady);

	mainProcess(inputArray, &size, &tempoTotal, &queueReady);

	free(queueReady.head);
	free(inputArray);

	return 0;
}