#include <pthread.h>
#include <stdio.h>
#include <math.h>

#define N 1000000000
float sum1, sum2, sum3, sum4 = 0;

void* returnRaiz1()
{	
	for(int i = 1; i <N/5; i++)
	{
		sum1 += sqrt(i);	
	}
	return NULL;
}

void* returnRaiz2()
{	
	for(int i = N/5; i < N/4; i++)
	{
		sum2 += sqrt(i);
	}
	return NULL;
}

void* returnRaiz3()
{	
	for(int i = N/4; i <N/3; i++)
	{
		sum3 += sqrt(i);
	}	
	return NULL;
}

void* returnRaiz4()
{	
	for(int i = N/3; i <=N; i++)
	{
		sum4 += sqrt(i);
	}
	return NULL;
}

int main()
{		
	pthread_t thread_id, thread_id2, thread_id3, thread_id4;

	pthread_create (&thread_id, NULL, &returnRaiz1, NULL);
  	pthread_create (&thread_id2, NULL, &returnRaiz2, NULL);
  	pthread_create (&thread_id3, NULL, &returnRaiz3, NULL);
  	pthread_create (&thread_id4, NULL, &returnRaiz4, NULL);

  	pthread_join(thread_id, NULL);
  	pthread_join(thread_id2, NULL);
  	pthread_join(thread_id3, NULL);
  	pthread_join(thread_id4, NULL);

  	 printf("%f\n", sum1 + sum2 + sum3 + sum4);


	return 0;
}