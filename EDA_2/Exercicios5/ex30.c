#include <sys/stat.h>
#include <sys/types.h>
#include <fcntl.h>
#include <unistd.h> //write
#include <stdio.h>

#define NUMFICH 10

int abrirFicheiro(char *nome)
{
	int fd = open(nome, O_RDWR);
	if(fd==-1)
	{
		printf("Creating file\n");
		fd = open(nome, O_RDWR | O_CREAT, S_IRUSR | S_IWUSR);
		if(fd==-1)
		{
			perror("create");
		}
		int n=0;
		for(int i=0; i < NUMFICH; i++)
			write(fd, &n, sizeof(int));
	}
	return fd;
}

int lerN(int fd, int n)
{
	int rValue;
	if(lseek(fd, sizeof(int)*(n-1), SEEK_SET) < 0)
	{
		perror("seek");
		return -1;
	}

	if(read(fd, &rValue, sizeof(int)) < 0)
	{
		perror("read");
		return -1;
	}

	return rValue;
}

int escreverN(int fd, int n, int wValue)
{
	if(lseek(fd, sizeof(int)*(n-1), SEEK_SET) < 0)
	{
		perror("seek");
		return -1;
	}

	if(write(fd, &wValue, sizeof(int)) < 0)
	{
		perror("write");
		return -1;
	}

	return 0;
}

int main(void)
{	int fd, x
	;char action;
	fd = abrirFicheiro("teste.txt");
	if(fd==-1)
		return 1;

	escreverN(fd, 3, 5);

	scanf("%c %d", action, x);
	if(action == '?')
		printf("%d\n", lerN(fd, x));



	close(fd);
	return 0;
}