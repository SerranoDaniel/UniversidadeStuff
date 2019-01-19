#include <stdio.h>

int main(void){
	for(int i = 1; i <=	 10; i++){
		int j;
		for ( j = 1; j < 10; ++j){
			printf("%3d", i * j );
		}
		printf("%3d\n", i * j);
	}

	//3 indica o numero minimo de colunas q vai ocupar
}