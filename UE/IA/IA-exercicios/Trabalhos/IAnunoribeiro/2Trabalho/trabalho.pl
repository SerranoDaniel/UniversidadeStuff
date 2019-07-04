dimensao(4).

soma(S2):-
	dimensao(R),
	S1 is (R*((R*R)+1))/2,
	S2 is round(S1).

dominio(S1):-
	dimensao(R),
	S2 is R*R,
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
	sort(Listr,Lista), 
	length(Listr,Tlista),
	length(Lista,Tlista),
	dimensao(D),
	ve_loop(D,Afe).


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
		length(Listr,D),!,
		ve_colunaaux(Lista,Nmagic),
		soma(Nmagic).
		

ve_coluna(Vec,List):-
	findall( Valor,	member(v(c(Vec,_),_,Valor),List),
		Listr), % vai a lista de v(c(x,y),D,V) e retira o v metendo na listr

		dimensao(D),
		\+length(Listr,D),!.


ve_colunaaux([],0):-
		!.
ve_colunaaux([Head|Tail],T):-	%somar os valores da lista
	ve_colunaaux(Tail,Valor),
	T is Head+Valor.

ve_linha(Vel,List):-
	findall( Valor,	member(v(c(_,Vel),_,Valor),List),
		Listr), % vai a lista de v(c(x,y),D,V) e retira o v metendo na listr

		sort(Listr,Lista), %retira duplicados e coloca-as em lista
		length(Lista,Tlista), %tamanho da lista 
		length(Listr,Tlista), %comparar os tamanhos das listas
		dimensao(D),
		length(Listr,D),!,
		ve_colunaaux(Lista,Nmagic),
		soma(Nmagic)	.

ve_linha(Vel,List):-
	findall( Valor,	member(v(c(_,Vel),_,Valor),List),
		Listr), % vai a lista de v(c(x,y),D,V) e retira o v metendo na listr

		dimensao(D),
		\+length(Listr,D),!.


esc(A):-write(A),nl. %escreve o estado final