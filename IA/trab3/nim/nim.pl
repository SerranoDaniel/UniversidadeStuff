%%% Estado inicial recebe o numero de colunas (n) e coloca em jogo 2*n - 1 peças
estado_inicial(0,[]):-!.
estado_inicial(X,S0):-
	X2 is X*2-1,
	X1 is X-1,
	append(S01,[X2],S0),
	estado_inicial(X1,S01).
		

%%% Estado terminal
		
terminal(A,Res):-
	soma(A,Res),
	Res = 0.

soma([],0).
soma([A|R],Res):-
	soma(R,Res1),
	Res is (A+Res1).


%%% Funcao utilidade

valor(0, 1, P):- 
  X is P mod 2, 
  X = 0,
  !.

valor(0, -1, _):-!.



%%%  funcao avaliacao 

f_avalia(Estado,Val,P):- nim_sum(Estado,Val1),bom_mau2(Val1,Val,P).
	
	nim_sum([V],V).   %% calcula o xor entre todos os elementos
	nim_sum([A,B|R],V):-
		C is A^B,
		nim_sum([C|R],V),!.
	
  bom_mau2(0,1,P):-
		Y is P mod 2,
		Y =0,!.
	bom_mau2(0,-1,P):-
		Y is P mod 2,
		Y \=0,!.
	bom_mau2(X,0,_):-
		X\=0,!.



%%%    Operadores    

op1(A,retiraColuna(Coluna-Pecas),Y):-
	lista_colunas(Lista),
	member(Coluna,Lista), % seleciona uma coluna do jogo
	aux(A,Coluna,Pecas,Y). 


aux(A,Coluna,Pecas,Y):-
	obtem_n_pecas(Coluna,A,N_Pecas), % obtem o numero de pecas que se encontra nessa coluna
	cria_lista(N_Pecas,Lista2),!,   % cria uma lista com os numeros que podem ser tirados dessa coluna
	member(Pecas,Lista2),           % seleciona um numero de pecas a retirar
	retira_pecas(A,Coluna,Pecas,Y).
	

	
retira_pecas(A,0,_,A):-!.
retira_pecas([A|Lista],Coluna,Pecas,[B|Lista1]):-
	Coluna = 1,
	B is (A-Pecas),
	B >=0,
	retira_pecas(Lista,0,_,Lista1).
retira_pecas([A|Lista],Coluna,Pecas,[A|Lista1]):-
	Coluna > 1,
	Coluna1 is (Coluna-1),
    retira_pecas(Lista,Coluna1,Pecas,Lista1).
	
	


obtem_n_pecas(1,[A|_],A).
obtem_n_pecas(X,[_|R],P):-
	X1 is X-1,
	obtem_n_pecas(X1,R,P).



%%%  Print  
	
desenha_estado([],_).
desenha_estado([A|R],Coluna):-
	write('coluna '),write(Coluna),write(': '),
	desenhaColuna(A),
	Coluna1 is Coluna+1,
	desenha_estado(R,Coluna1).
	
desenhaColuna(0):-
	nl.
desenhaColuna(A):-
	A>0,
	write('[]'),
	A1 is A-1,
	desenhaColuna(A1).