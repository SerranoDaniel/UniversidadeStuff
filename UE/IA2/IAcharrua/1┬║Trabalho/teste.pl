blocked((1,2),(1,3)).
blocked((1,3),(1,2)).

blocked((2,3),(2,2)).
blocked((2,2),(2,3)).

blocked((3,4),(4,4)).
blocked((4,4),(3,4)).

blocked((4,5),(3,5)).
blocked((3,5),(4,5)).

tabuleiro_min(1).
tabuleiro_max(30).


estado_inicial(s(18,18)).
estado_final(s(26,26)).

:- dynamic(visitado/1).

%operador (Estado inicial, OPerador, Estado Seguinte,Custo)
op(s(X,Y),cima,s(X,Y1), 1):-
	tabuleiro_min(M),
	M < Y,
	Y1 is Y-1,
	\+visitado(s(X,Y1)),
	\+blocked(s(X,Y),s(X,Y1)),
	assertz(visitado(s(X,Y1))).
	

op(s(X,Y),baixo,s(X,Y1), 1):-
	tabuleiro_max(M),
	M > Y,
	Y1 is Y+1,
	\+visitado(s(X,Y1)),
	\+blocked(s(X,Y),s(X,Y1)),
	assertz(visitado(s(X,Y1))).
	

op(s(X,Y),esquerda,s(X1,Y), 1):-
	tabuleiro_min(M),
	M < X,
	X1 is X-1,
	\+visitado(s(X1,Y)),
	\+blocked(s(X,Y),s(X1,Y)),
	assertz(visitado(s(X1,Y))).
	
op(s(X,Y),direita,s(X1,Y), 1):-
	tabuleiro_max(M),
	M > X,
	X1 is X+1,
	\+visitado(s(X1,Y)),
	\+blocked(s(X,Y),s(X1,Y)),
	assertz(visitado(s(X1,Y))).
	
%h(Estado Atual, V)
h(E,V):-
%h1(E,V1),
h2(E,V2),
V is V2.

h1(s(X,Y),V):-
findall((X,Y), (blocked((X,Y),_);blocked(_,(X,Y))), Pl),
length(Pl, V).

h2(s(X,Y),V):-
estado_final(s(A,B)),
V is ((A-X) +(B-Y)).
