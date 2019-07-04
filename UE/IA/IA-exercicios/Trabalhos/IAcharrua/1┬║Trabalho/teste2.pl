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


estado_inicial((18,18)).
estado_final((26,26)).

:- dynamic(visitado/1).

%operador (Estado inicial, OPerador, Estado Seguinte,Custo)
op((X,Y),cima,(X,Y1), 1):-
	tabuleiro_min(M),
	M < Y,
	Y1 is Y-1,
	\+visitado((X,Y1)),
	\+blocked((X,Y),(X,Y1)),
	assertz(visitado((X,Y1))).
	

op((X,Y),baixo,(X,Y1), 1):-
	tabuleiro_max(M),
	M > Y,
	Y1 is Y+1,
	\+visitado((X,Y1)),
	\+blocked((X,Y),(X,Y1)),
	assertz(visitado((X,Y1))).
	

op((X,Y),esquerda,(X1,Y), 1):-
	tabuleiro_min(M),
	M < X,
	X1 is X-1,
	\+visitado((X1,Y)),
	\+blocked((X,Y),(X1,Y)),
	assertz(visitado((X1,Y))).
	
op((X,Y),direita,(X1,Y), 1):-
	tabuleiro_max(M),
	M > X,
	X1 is X+1,
	\+visitado((X1,Y)),
	\+blocked((X,Y),(X1,Y)),
	assertz(visitado((X1,Y))).
	
%h(Estado Atual, V)
h(E,V):-
	%h1(E,V1),
	h2(E,V2),
	V is V2.

h1((X,Y),V):-
	findall((X,Y), (blocked((X,Y),_);blocked(_,(X,Y))), Pl),
	length(Pl, V).

h2((X,Y),V):-
	estado_final((A,B)),
	V is ((A-X) +(B-Y)).