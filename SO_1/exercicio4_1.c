#include <stdio.h>

int main()
{
	FILE *ficheiroR;
	FILE *ficheiroA;
	
	ficheiroR = fopen("file.txt","r");
	if(ficheiroR == NULL){
		printf("\nFicheiro nao encontrado!");
	}
	else{
		ficheiroA = fopen("texto.txt", "a");
		fseek(ficheiroR, -1, SEEK_END);
		int ficheiroRLength = ftell(ficheiroR);
		for(int filePos = ficheiroRLength; filePos >= 0; filePos--)
		{
    		fseek(ficheiroR, filePos, SEEK_SET);
    		fprintf(ficheiroA, "%c", fgetc(ficheiroR)); 
		} 
		printf("Foi escrito");
	}

	fclose(ficheiroR);
	fclose(ficheiroA);
}