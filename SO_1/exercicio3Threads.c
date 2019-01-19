#include <pthread.h>
#include <stdio.h>
#include <math.h>

#define N 1000000000
float sum1, sum2 = 0;

void* returnRaiz1()
{	
	for(int i = N/2; i <=N; i++)
	{
		sum1 += sqrt(i);
	}	
	return NULL;
}

void* returnRaiz2()
{	
	for(int i = 1; i <N/2; i++)
	{
		sum2 += sqrt(i);
	}
	return NULL;
}

int main()
{	
	pthread_t thread_id, thread_id2;

	pthread_create (&thread_id, NULL, &returnRaiz1, NULL);
	pthread_create (&thread_id2, NULL, &returnRaiz2, NULL);

  	pthread_join(thread_id, NULL);
  	pthread_join(thread_id2, NULL);

 	printf("%f\n", sum1 + sum2);

	return 0;
}