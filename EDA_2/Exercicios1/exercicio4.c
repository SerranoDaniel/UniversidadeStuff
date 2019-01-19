#include <stdio.h>

int fact(int num);

int main(void)
{
	printf("%d\n", fact(10));
}

int fact(int num){
	int result = 1;
	for(num ; num > 0; num--){
		result = result * num;
	}
	return result;
}