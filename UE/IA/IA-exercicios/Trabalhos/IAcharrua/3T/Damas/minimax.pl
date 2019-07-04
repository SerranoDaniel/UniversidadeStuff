% algoritmo minimax

go(Jogo):- 
  consult(Jogo), 
  estado_inicial1(Ei),
  minimax_decidir(Ei, Op),
  write(Op),
  nl.

% Decide qual � a melhor jogada num estado do jogo
% minimax_decidir(Estado, MelhorJogada)

% Se � estado terminal, n�o ha jogada         
minimax_decidir(Ei,terminou):- 
  terminal(Ei).

% Para cada estado sucessor de Ei calcula o valor minimax do estado
% em que Opf � o operador (jogada) que tem maior valor
minimax_decidir(Ei, Opf):-
  findall(Es-Op, op1(Ei, Op, Es), L),
  findall(Vc-Op, (member(E-Op, L), minimax_valor(E, Vc, 1)), L1),
  escolhe_max(L1, Opf).

% se um estado e terminal o valor e dado pela funcao de utilidade
minimax_valor(Ei, Val, P):- 
  terminal(Ei), 
  valor(Ei, Val, P).

% se o estado n�o � terminal o valor �:
%    -se a profundidade � par, o maior valor dos sucessores de Ei
%    -se aprofundidade � impar, o menor valor dos sucessores de Ei
minimax_valor(Ei, Val, P):- 
  findall(Es, op1(Ei, _, Es), L),
  P1 is P+1,
  findall(Val1, (member(E, L), minimax_valor(E, Val1, P1)), V),
  seleciona_valor(V, P, Val).


% Se a profundidade (P) � par, retorna em Val o maximo de V
seleciona_valor(V, P, Val):- 
  X is P mod 2, 
  X=0,
  !, 
  maximo(V, Val).

% Sen�o retorna em Val o minimo de V
seleciona_valor(V, _, Val):- 
  minimo(V, Val).

% escolhe_max(L, Op_Max) 
% L = [V1-Op1, ..., Vn-Opn] 
% Op_Max est� associado ao max(Vi)
escolhe_max([A|R], Val):- escolhe_max(R, A, Val).

escolhe_max([], _-Op, Op).
escolhe_max([A-_|R], X-Op, Val):- 
  A < X,
  !, 
  escolhe_max(R, X-Op, Val).

escolhe_max([A|R], _, Val):-
  escolhe_max(R, A, Val).

% minimo(Lista_de_Valores, Valor)
% equivalente ao min_list/2 do gprolog
minimo([A|R],Val):- minimo(R,A,Val).

minimo([], A, A).

minimo([A|R], X, Val):- 
  A > X,
  !, 
  minimo(R,X,Val).

minimo([A|R], _, Val):-
  minimo(R, A, Val).


% maximo(Lista_de_Valores, Valor)
% equivalente ao max_list/2 do gprolog
maximo([A|R],Val):- 
  maximo(R,A,Val).

maximo([], A, A).

maximo([A|R], X, Val):- 
  A < X,
  !,
  maximo(R,X,Val).

maximo([A|R], _, Val):- 
  maximo(R, A, Val).
