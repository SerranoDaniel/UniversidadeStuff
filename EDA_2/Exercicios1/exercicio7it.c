#include <stdio.h>

void fibo(int x){
	int old = 1;
	int new = 1;

	for(int i=0; i < x; i++){
		if(i==0){
			printf("%d ", i);
		}
		else if(i==1){
			printf("%d ", old);
		}
		else if(i==2){
			printf("%d ", new);
		}
		else{
			int num = new;
			new = new + old;
			old = num;
			printf("%d ", new);
		}
	}
}

int main(void){
	fibo(20);
}