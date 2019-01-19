#include <stdio.h>

int main(void){
	for(int i = 1; i <=	 10; i++){
		int j;
		for ( j = 1; j < i; ++j){
			printf("%5d", i * j );
		}
		printf("%5d\n", i * j);
	}

	//3 indica o numero minimo de colunas q vai ocupar
}