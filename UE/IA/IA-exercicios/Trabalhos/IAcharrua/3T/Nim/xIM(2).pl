%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%   Jogo Do Nim            %
%                          %
% Joao Oliveira, 21133, Ei %
% Filipe Sezoes, 21171, Ei %
%                          %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%


%%% estado inicial - Dado um numero de linhas cria uma lista, 
%%%                  onde cada elemento representa o numero de 
%%%                  pecas por linha. A formula para calcular o 
%%%                  numero de pecas e: 2*n-1, onde n representa 
%%%                  a linha.

estado_inicial(0,[]):-!.
estado_inicial(X,S0):-
	X2 is X*2-1,
	X1 is X-1,
	append(S01,[X2],S0),
	estado_inicial(X1,S01).
		


%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%  Predicado Terminal  %%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		
terminal(A,Res):-
	soma(A,Res),
	Res = 0.

soma([],0).
soma([A|R],Res):-
	soma(R,Res1),
	Res is (A+Res1).


%%%%%%%%%%%%%%%%%%%%%%%%%
%%%  funcao utilidade %%%
%%%%%%%%%%%%%%%%%%%%%%%%%	
valor(0, 15, P):- 
  X is P mod 2, 
  X = 0,
  !.

valor(0, -15, _):-!.




%%%%%%%%%%%%%%%%%%%%%%%%%
%%%  funcao avaliacao %%%
%%%%%%%%%%%%%%%%%%%%%%%%%

f_avalia(Estado,Val,P):- so_uns(Estado,Val1),!,bom_mau(Val1,Val,P).

f_avalia(Estado,Val,P):- nim_sum(Estado,Val1),bom_mau2(Val1,Val,P).

	so_uns([],0).
	so_uns([A|R],V):-
		A < 2,
		so_uns(R,V1),
		V is A+V1.
	
	bom_mau(Val1,3,P):-
		Y is P mod 2,
		Y \=0,
		X is Val1 mod 2,
		X \=0,!.
	
	bom_mau(Val1,3,P):-
		Y is P mod 2,
		Y =0,
		X is Val1 mod 2,
		X =0,!.
	
	bom_mau(_,-3,_).
	
	nim_sum([V],V).   %% calcula o xor entre todos os elementos
	nim_sum([A,B|R],V):-
		C is A^B,
		nim_sum([C|R],V),!.
	
    bom_mau2(0,3,P):-
		Y is P mod 2,
		Y =0,!.
	bom_mau2(0,-3,P):-
		Y is P mod 2,
		Y \=0,!.
	bom_mau2(X,0,_):-
		X\=0,!.

		
%%%%%%%%%%%%%%%%%%%%%%%%
%%%    Operadores    %%% 
%%%%%%%%%%%%%%%%%%%%%%%%

op1(A,retiraLinha(Linha-Pecas),Y):-
	lista_linhas(Lista),
	member(Linha,Lista), % seleciona uma linha do jogo
	aux(A,Linha,Pecas,Y). 


aux(A,Linha,Pecas,Y):-
	obtem_n_pecas(Linha,A,N_Pecas), % obtem o numero de pecas que se encontra nessa linha
	cria_lista(N_Pecas,Lista2),!,   % cria uma lista com os numeros que podem ser tirados dessa linha
	member(Pecas,Lista2),           % seleciona um numero de pecas a retirar
	retira_pecas(A,Linha,Pecas,Y).
	

	
retira_pecas(A,0,_,A):-!.
retira_pecas([A|Lista],Linha,Pecas,[B|Lista1]):-
	Linha = 1,
	B is (A-Pecas),
	B >=0,
	retira_pecas(Lista,0,_,Lista1).
retira_pecas([A|Lista],Linha,Pecas,[A|Lista1]):-
	Linha > 1,
	Linha1 is (Linha-1),
    retira_pecas(Lista,Linha1,Pecas,Lista1).
	
	


obtem_n_pecas(1,[A|_],A).
obtem_n_pecas(X,[_|R],P):-
	X1 is X-1,
	obtem_n_pecas(X1,R,P).




%%%%%%%%%%%%%%%%%%%%%%%%%
%%%  Imprime Estados  %%%
%%%%%%%%%%%%%%%%%%%%%%%%%
	
desenha_estado([],_).
desenha_estado([A|R],Linha):-
	write('linha '),write(Linha),write(': '),
	desenhaLinha(A),
	Linha1 is Linha+1,
	desenha_estado(R,Linha1).
	
desenhaLinha(0):-
	nl.
desenhaLinha(A):-
	A>0,
	write('o'),
	A1 is A-1,
	desenhaLinha(A1).
