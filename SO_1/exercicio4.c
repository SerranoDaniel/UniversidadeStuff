#include <stdio.h>
#include <stdlib.h>

//EXERCICIO_1

/*void funcaoTeste(char* array)
{
	printf("\n teste a fazer print de dentro da funcao: %s", array);
}

int main()
{
	char* string = "";
	printf("\n Insirta o texto para a string\n");
	scanf("%[0-9a-zA-Z]s", &string); //diferente que apenas %s
	printf("\n texto inserido: %s \n", &string);

	printf("\n ############# \n");

	//chama da funcao que recebe a string para testar
	funcaoTeste(&string);
	return 1;
}*/


//EXERCICIO_2

/*int main()
{
		FILE* ficheiro;
		char* linha=NULL;
		size_t len = 0;
		ssize_t read;

		ficheiro = fopen("texto.txt", "r");
		if(ficheiro == NULL)
		{
			printf("\nFicheiro nao encontrado!");
		}
		else
		{
			while((read=getline(&linha, &len, ficheiro)) != -1)
			{
				printf("Linha lida: %s", linha);
			}
		}

		fclose(ficheiro);
}*/


//EXERCICIO3_

/*int main()
{
	FILE *ficheiro;
	ficheiro = fopen("file.txt", "a"); // faz apend ou cria um novo ficheiro caso ainda nao exista

	char* texto = "A escrita em ficheiro e bastante simples \n";
	fprintf(ficheiro, "%s", texto); //faz a escrita
	printf("Foi escrito");

	fclose(ficheiro);
}*/


//EXERCICIO_4

int main()
{
	//	& significa "endreço de"
	//	* significa "conteudo do endereço para onde aponta"

	int a = 33;
	int b = 55;
	int *ap=&a;		// &a, devolve o endereço de memória de uma variavel

	//int *ap;		//declara um ponteiro para um inteiro 
	//*ap = 33		//atribui o valor 33 à variavel que está contida no ponteiro

	printf("Valor a: %d\n", a);
	printf("Endereço a: %d\n", &a);
	printf("Valor apontador: %d\n", ap);
	printf("Endereço apontador: %d\n", &ap);
	printf("Valor na memoria apontada pelo apontador: %d\n", *ap);

	//Incrementar a variavel a por via de apontador? 
	ap++;
	(*ap)++;
	printf("\nValor na memoria apontada pelo apontador: %d\n", *ap);

	puts("\n##########");

	int *ap1 = &a;
	int *ap2 = &b;

	printf("Valores dos apontadores: ap1 %d    ap2 %d \n", ap1, ap2);
	printf("Endereço dos apontadores: ap1 %d    ap2 %d \n", &ap1, &ap2);
	printf("Valor na memoria apontada pelos apontadores: ap1 %d    ap2 %d \n", *ap1, *ap2);


	//Qual e diferenca entre as segunites opreacoes?
	ap2=ap1;
	*ap2=*ap1;


	puts("\n\n");
	printf("Valores dos apontadores: ap1 %d    ap2 %d \n", ap1, ap2);
	printf("Endereço dos apontadores: ap1 %d    ap2 %d \n", &ap1, &ap2);
	printf("Valor na memoria apontada pelos apontadores: ap1 %d    ap2 %d \n", *ap1, *ap2);

	return 1;
}

