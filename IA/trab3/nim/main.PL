main:- 
  consult('nim'),
  write('Introduza o numero de colunas: '),read(X),nl,
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
  alg_chooser(Algoritmo,Modo,S0),
  retract(lista_colunas(_)),
  retract(profundidade_limite(_)).


% Escolhe o algoritmo para jogar
alg_chooser(1,Modo,S0):-
  	consult('minimax'),nl,
	write('Insira a Profundidade: '),
	read(X),nl,
	asserta(profundidade_limite(X)),nl,
	write('Estado Inicial: '),nl,
	desenha_estado(S0,1),nl,nl,
	jogadorP(Modo,S0).

alg_chooser(2,Modo,S0).

% Melhor Jogada  

jogadorP(1,S0):-
 	decidir_jogada(S0, Op),!,
 	op1(S0,Op,S1),!,
 	write('Melhor Jogada: '),nl,
 	write(Op),nl,nl,
 	desenha_estado(S1,1),!,nl,nl.


%  Agente

jogadorP(_,S0):-
 	terminal(S0,_),write('Jogador Adversário venceu').

jogadorP(2,S0):-
 	write('Introduza a coluna de onde pretende remover: '),
  	read(Coluna),nl,
  	write('Introduza o numero de pecas que pretende remover: '),
  	read(Pecas),nl,
  	Op = retiraColuna(Coluna-Pecas),
 	op1(S0,Op,S1),
 	write('Jogada do Jogador Principal: '),nl,
 	write(Op),nl,nl,
 	desenha_estado(S1,1),nl,nl,
 	jogadorA(2,S1).
 
 	
jogadorP(3,S0):-
 	decidir_jogada(S0, Op),!,
 	op1(S0,Op,S1),!,
 	write('Jogada do Jogador Principal: '),nl,
 	write(Op),nl,nl,
 	desenha_estado(S1,1),!,nl,nl,
 	jogadorA(3,S1).
 	

jogadorA(_,S0):-
 	terminal(S0,_),write('Jogador Principal venceu').
 	
jogadorA(Modo,S0):-
 	decidir_jogada(S0, Op),!,
 	op1(S0,Op,S1),!,
 	write('Jogada do Jogador Adversário: '),nl,
 	write(Op),nl,nl,
 	desenha_estado(S1,1),nl,
 	jogadorP(Modo,S1).


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

insere_caracteristicas(S0):-
  	length(S0,X),
  	cria_lista(X,L),
  	asserta(lista_colunas(L)).
  	
cria_lista(0,[]):-!.
cria_lista(X,[X|L]):-
  	X1 is X-1,
  	cria_lista(X1,L),!.
	
  	
  	
