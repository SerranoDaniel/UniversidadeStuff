#include <stdio.h>

int main(void)
{
	int count = 1;
	for(int i = 1; i <= 20; i++)
	{
		if(count == 2)
		{
			printf(" %d", i);
			count = 1;
		}else
		{
		printf("%d", i);
		count++;
		}
	}
}