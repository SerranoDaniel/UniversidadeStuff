
#include <stdio.h>
#include <math.h>

#define N 100000000

void returnRaiz()
{	
	float sum = 0;
	for(int i = 1; i <=N; i++)
	{
		sum += sqrt(i);
	}
	printf("%f\n", sum);	
}

int main(void)
{		
	returnRaiz();
	return 0;
}