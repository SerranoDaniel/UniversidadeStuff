#include <stdio.h>

typedef struct Data
{
	int dia;
	int mes;
	int ano;
} Data;

typedef struct Familia
{
	char paiNome[20];
	char maeNome[20];
} Familia;

typedef struct Aluno
{
	char *nome;
	int numAluno;
	Data dataNasc;
	Data dataMatric;
	Familia fam;
} Aluno;

void dadosAluno(Aluno *array, int pos)
{
	printf("Nome: %s\nNumero: %d\nData de Nascimento: %d/%d/%d\nData de Matricula: %d/%d/%d\nNome do pai: %s\nNome da mae: %s\n", array[pos].nome, array[pos].numAluno, 
		array[pos].dataNasc.dia,
		array[pos].dataNasc.mes, array[pos].dataNasc.ano, array[pos].dataMatric.dia, 
		array[pos].dataMatric.mes,
		array[pos].dataMatric.ano, array[pos].fam.paiNome, array[pos].fam.maeNome);
}

int main()
{
	Aluno a = {"Joao", 1, 8, 8, 97, 1, 9, 10, "Jose", "Maria"};

	Aluno array[1] = {a};

	dadosAluno(array, 0);

	return 0;
}



