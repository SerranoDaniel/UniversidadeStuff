% algoritmo minimax com corte em profundidade

go_cut(Jogo):- 
  consult(Jogo), 
  estado_inicial1(Ei),
  minimax_decidir(Ei, Op),
  write(Op),
  nl.

% decide qual a melhor jogada num estado do jogo
% minimaxcut_decidir(Estado, MelhorJogada)
% se e estado terminal  nao ha jogada         

minimaxcut_decidir(Ei,terminou):- terminal(Ei).

% Para cada estado sucessor de Ei calcula o valor minimaxcut do estado
% Opf e o operador (jogada) que tem maior valor

minimaxcut_decidir(Ei,Opf):-
	findall(Es-Op, op1(Ei,Op,Es),L),
	findall(Vc-Op,(member(E-Op,L), minimaxcut_valor(E,Vc,1)),L1),
	escolhe_max3(L1,Opf).

minimaxcut_valor(Ei,Val,P):- terminal(Ei), valor(Ei,Val,P).

% se um estado atinge o limite o valor e dado pela funcao de avaliacao

minimaxcut_valor(Ei,Val,P):-  prof_limite(Prof), P>Prof, favaliacao(Ei,Val).

% Se o estado nao e terminal o valor e:
%    -se a profundidade e par, o maior valor dos sucessores de Ei
%    -se aprofundidade e impar o menor valor dos sucessores de Ei

minimaxcut_valor(Ei,Val,P):- 
	prof_limite(Prof),
	P=<Prof,
	findall(Es,op1(Ei,_,Es),L),
	P1 is P+1,
	findall(Val1,(member(E,L),minimaxcut_valor(E,Val1,P1)),V),
      	seleciona_valor3(V,P,Val).

% Se a profundidade (P) e par, retorna em Val o maximo de V
seleciona_valor3(V,P,Val):- X is P mod 2, X=0,!, maximo3(V,Val).

% Senao retorna em Val o minimo de V
seleciona_valor3(V,_,Val):- minimo3(V,Val).


maximo3([A|R],Val):- maximo3(R,A,Val).

maximo3([],A,A).
maximo3([A|R],X,Val):- A < X,!, maximo3(R,X,Val).
maximo3([A|R],_,Val):-  maximo3(R,A,Val).

escolhe_max3([A|R],Val):- escolhe_max3(R,A,Val).

escolhe_max3([],_-Op,Op).
escolhe_max3([A-_|R],X-Op,Val):- A < X,!, escolhe_max3(R,X-Op,Val).
escolhe_max3([A|R],_,Val):-  escolhe_max3(R,A,Val).


minimo3([A|R],Val):- minimo3(R,A,Val).

minimo3([],A,A).
minimo3([A|R],X,Val):- A > X,!, minimo3(R,X,Val).
minimo3([A|R],_,Val):-  minimo3(R,A,Val).


