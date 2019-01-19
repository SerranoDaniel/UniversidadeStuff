	//int x = open(nome, O_RDWR) caso ja exista, se nao exisitir devolve -1.
	//E se nao exisitir chama-lo outra vez com O_CREAT para o criar

	//Usar 2 "open" para saber se o ficheiro ja exisita ou nao

	//Para ler: read(int fd, void *destion, size_t numer de bytes a ler )
	//Se read returnar 0 quer dizer que o ficheiro esta vazia
	//Se read returnar -1 se der erro

	//Para escrever: wirte(int find, void *origem da informacao, size_t numero de 
	//bytes a escrever)

	//Para voltar a cabeca do ficheiro usar:
	//lseek(int fd, off.t offset, int origem)
	//int origem: seek_cur, em relacao ao off set
	//int origem: seek_set, em relacao a posicao 0
	//int origem: seek_end, em relacao ao fim do ficheiro
	//devolve a pusicao onde ficou a cabeca

	//Para fechar o ficheiro:
	//close(fd);

	//os erros (-1) ficam guardadas numa variavel "errno"
	//funcao perror(char "open") -> open: mensagem de erro
	//escreve mensagem que traduz qual o erro q ocorreu4


	/////////////////
	//Standart C: fopen, fread, fwrite, fseek, fclose, perror
