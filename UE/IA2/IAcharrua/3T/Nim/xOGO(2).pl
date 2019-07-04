%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%   Jogo Do Nim            %
%                          %
% Joao Oliveira, 21133, Ei %
% Filipe Sezoes, 21171, Ei %
%                          %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%


demo:- 
  consult('nim'),
  write('Introduza o numero de linhas: '),read(X),nl,
  estado_inicial(X,S0),
  insere_caracteristicas(S0),
  write('Escolha Algoritmo: '),nl,
  write('1. Minimax '),nl,
  write('2. AlfaBeta '),nl,
  write(': '),read(Algoritmo),nl,
  write('Escolha Modo: '),nl,
  write('1. Melhor Jogada '),nl,
  write('2. Homem vs CPU '),nl,
  write('3. CPU vs CPU '),nl,
  write(': '),read(Modo),nl,
  jogar(Algoritmo,Modo,S0),
  retract(lista_linhas(_)),
  retract(profundidade_limite(_)).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%  consult do algoritmo  %%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%

jogar(1,Modo,S0):-
    consult('minimax'),nl,
	write('Insira a Profundidade: '),
	read(X),nl,
	asserta(profundidade_limite(X)),nl,
	write('Estado Inicial: '),nl,
	desenha_estado(S0,1),nl,nl,
	jogador1(Modo,S0).

jogar(2,Modo,S0):-
	consult('alfabeta'),nl,
	write('Insira a Profundidade: '),
	read(X),nl,
	asserta(profundidade_limite(X)),nl,
    write('Estado Inicial: '),nl,
	desenha_estado(S0,1),nl,nl,
	jogador1(Modo,S0).


%%%%%%%%%%%%%%%%%%%%%
%%  Melhor Jogada  %%
%%%%%%%%%%%%%%%%%%%%%

jogador1(1,S0):-
 	decidir_jogada(S0, Op),!,
 	op1(S0,Op,S1),!,
 	write('Melhor Jogada: '),nl,
 	write(Op),nl,nl,
 	desenha_estado(S1,1),!,nl,nl.




%%%%%%%%%%%%%%
%%  Agente  %%
%%%%%%%%%%%%%%


jogador1(_,S0):-
 	terminal(S0,_),write('Jogador 1 venceu').

jogador1(2,S0):-
 	write('Introduza a Linha de onde pretende remover: '),
  	read(Linha),nl,
  	write('Introduza o numero de pecas que pretende remover: '),
  	read(Pecas),nl,
  	Op = retiraLinha(Linha-Pecas),
 	op1(S0,Op,S1),
 	write('Jogada do Jogador 1: '),nl,
 	write(Op),nl,nl,
 	desenha_estado(S1,1),nl,nl,
 	jogador2(2,S1).
 
 	
jogador1(3,S0):-
 	decidir_jogada(S0, Op),!,
 	op1(S0,Op,S1),!,
 	write('Jogada do Jogador 1: '),nl,
 	write(Op),nl,nl,
 	desenha_estado(S1,1),!,nl,nl,
 	jogador2(3,S1).
 	

jogador2(_,S0):-
 	terminal(S0,_),write('Jogador 2 venceu').
 	
jogador2(Modo,S0):-
 	decidir_jogada(S0, Op),!,
 	op1(S0,Op,S1),!,
 	write('Jogada do Jogador 2: '),nl,
 	write(Op),nl,nl,
 	desenha_estado(S1,1),nl,
 	jogador1(Modo,S1).


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%% Outros Predicados  %%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

insere_caracteristicas(S0):-
  	length(S0,X),
  	cria_lista(X,Lista),
  	asserta(lista_linhas(Lista)).
  	
cria_lista(0,[]):-!.
cria_lista(X,[X|L]):-
  	X1 is X-1,
  	cria_lista(X1,L),!.
	
  	
  	
