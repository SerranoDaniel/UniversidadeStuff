%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%   Jogo Do Nim            %
%                          %
% Joao Oliveira, 21133, Ei %
% Filipe Sezoes, 21171, Ei %
%                          %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%

decidir_jogada(Ei,terminou):- 
  terminal(Ei,_).


decidir_jogada(Ei, Opf):-
  findall(Es-Op, op1(Ei, Op, Es), L),
  findall(Vc-Op, (member(E-Op, L), minimax_valor(E, Vc, 1)), L1),
  escolhe_max1(L1, Opf).


minimax_valor(Ei, Val, P):- 
  terminal(Ei,Res), 
  valor(Res, Val, P).


minimax_valor(Ei, Val, P):- 
  profundidade_limite(P1), P = P1,!, %write('entrou no corte'),nl,
  f_avalia(Ei,Val,P),!,%write(P-P1-Val),nl,
  !.


minimax_valor(Ei, Val, P):- 
  findall(Es, op1(Ei, _, Es), L),
  P1 is P+1,
  findall(Val1, (member(E, L), minimax_valor(E, Val1, P1)), V),
  seleciona_valor1(V, P, Val).



seleciona_valor1(V, P, Val):- 
  X is P mod 2, 
  X=0,
  !, 
  maximo1(V, Val).


seleciona_valor1(V, _, Val):- 
  minimo1(V, Val).


escolhe_max1([A|R], Val):- escolhe_max1(R, A, Val).

escolhe_max1([], _-Op, Op).
escolhe_max1([A-_|R], X-Op, Val):- 
  A < X,
  !, 
  escolhe_max1(R, X-Op, Val).

escolhe_max1([A|R], _, Val):-
  escolhe_max1(R, A, Val).


minimo1([A|R],Val):- minimo1(R,A,Val).

minimo1([], A, A).

minimo1([A|R], X, Val):- 
  A > X,
  !, 
  minimo1(R,X,Val).

minimo1([A|R], _, Val):-
  minimo1(R, A, Val).


maximo1([A|R],Val):- 
  maximo1(R,A,Val).

maximo1([], A, A).

maximo1([A|R], X, Val):- 
  A < X,
  !,
  maximo1(R,X,Val).

maximo1([A|R], _, Val):- 
  maximo1(R, A, Val).
