#include <stdio.h>

int fact(int num);

int main(void){
	printf("%d\n", fact(10));
}

int fact(int num){
	if(num > 0){
		return num*fact(num-1);
	}
	return 1;
}