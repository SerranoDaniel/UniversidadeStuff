dimensao(9).

soma(S2):-
	dimensao(R),
	S2 is 9.

dominio(S1):-
	dimensao(R),
	S2 is 9,
	dominioaux(S2,S1).

dominioaux(1,[1]):-!.

dominioaux(V,ListaV):-
	V1 is V-1,
	dominioaux(V1,ListaV2),
	append(ListaV2,[V],ListaV).

matriz(1,[c(1,Y)],Y):-!.

matriz(N,ListaV,Y):-
	N1 is N-1,
	matriz(N1,ListaV2,Y),
	append(ListaV2,[c(N,Y)],ListaV).
	%N is y

dado(S1):-
	dimensao(R),
	S2 is R,
	matriz(S2,S1).

colunamatriz(1,V):-
	dimensao(R),
	matriz(R,V,1),!.

colunamatriz(R1,S1):-
	dimensao(R),
	S2 is R1-1,
	colunamatriz(S2,S),
	matriz(R,SS,R1),
	append(S,SS,S1).


estado_inicial(e(S1,[])):-
	dimensao(R),
	colunamatriz(R,ListaC),
	estado_inicial_aux(ListaC,S1).


estado_inicial_aux([],[]):-!.
estado_inicial_aux([Head|Tail],[v(Head,D,_)|Tails]):-
	dominio(D),
	estado_inicial_aux(Tail,Tails).	


%%%%%%%%%%%%%%%%%%%%%%%% pergunta a) %%%%%%%%%%%%%%%%%%%%%%%


ve_restricoes(e(_,Afe)):-
	
findall( Valor,	member(v(c(_,_),_,Valor),Afe),Listr), 
	%ver quadrantes
	ve_loop(9,Afe),
	quadrantes(Afe).


quadrantes(Afe):-
	length(Afe,81),
	member(v(c(1,1),_,Q1),Afe),
	member(v(c(1,2),_,Q1),Afe),
	member(v(c(1,3),_,Q1),Afe),
	member(v(c(2,1),_,Q1),Afe),
	member(v(c(2,2),_,Q1),Afe),
	member(v(c(2,3),_,Q1),Afe),
	member(v(c(3,1),_,Q1),Afe),
	member(v(c(3,2),_,Q1),Afe),
	member(v(c(3,3),_,Q1),Afe),







ve_loop(0,_):-!.
ve_loop(A,List):-
	ve_coluna(A,List),
	ve_linha(A,List),
	Valor is A-1,
	ve_loop(Valor,List)
.


ve_coluna(Vec,List):-
	findall( Valor,	member(v(c(Vec,_),_,Valor),List),
		Listr), % vai a lista de v(c(x,y),D,V) e retira o v metendo na listr

		sort(Listr,Lista), %retira duplicados e coloca-as em lista
		length(Lista,Tlista), %tamanho da lista 
		length(Listr,Tlista), %comparar os tamanhos das listas
		dimensao(D),
		length(Listr,D),!.
		

ve_coluna(Vec,List):-
	findall( Valor,	member(v(c(Vec,_),_,Valor),List),
		Listr), % vai a lista de v(c(x,y),D,V) e retira o v metendo na listr

		dimensao(D),
		\+length(Listr,D),!.

ve_linha(Vel,List):-
	findall( Valor,	member(v(c(_,Vel),_,Valor),List),
		Listr), % vai a lista de v(c(x,y),D,V) e retira o v metendo na listr

		sort(Listr,Lista), %retira duplicados e coloca-as em lista
		length(Lista,Tlista), %tamanho da lista 
		length(Listr,Tlista), %comparar os tamanhos das listas
		dimensao(D),
		length(Listr,D),!.

ve_linha(Vel,List):-
	findall( Valor,	member(v(c(_,Vel),_,Valor),List),
		Listr), % vai a lista de v(c(x,y),D,V) e retira o v metendo na listr

		dimensao(D),
		\+length(Listr,D),!.


esc(A):-write(A),nl. %escreve o estado final