estado_inicial(a(2,2)).
estado_final(a(3,1)).
mercado(a(1,1)).

fechada((1,2),(1,3)).
fechada((2,3),(2,2)).
fechada((3,4),(4,4)).
fechada((4,5),(3,5)).

fechada((1,3),(1,2)).
fechada((2,2),(2,3)).
fechada((4,4),(3,4)).
fechada((3,5),(4,5)).

op(E, cima, Es, 1):-
	E = a(X,Y),
	Y1 is Y-1, Y1 > 0,
	\+ fechada((X,Y),(X,Y1)),
	Es = a(X,Y1).

op(E,nbaixo, Es, 1):-
	E = a(X,Y),
	Y1 is Y+1, Y1 =< 10,
	\+ fechada((X,Y),(X,Y1)),
	Es = a(X,Y1).

op(E, esq, Es, 1):-
	E = a(X,Y),
	X1 is X-1, X1 > 0,
	\+ fechada((X,Y),(X1,Y)),
	Es = a(X1,Y).

op(E, dir, Es, 1):-
	E = a(X,Y),
	X1 is X+1, X1 =< 10,
	\+ fechada((X,Y),(X1,Y)),
	Es = a(X1,Y).


h(E, V):-
	h1(E, V1),
	h2(E, V2),
	V is V1 +V2.



h1(E,V1):-
	E=a(X,Y),
	estado_final(X1, Y1),
	Xf is X1-X,
	Yf is Y1-Y,
	V1 is Xf+Yf.


h2(E,V1):-
	E=a(X,Y),
	mercado(X1, Y1),
	Xf is X1-X,
	Yf is Y1-Y,
	V1 is Xf+Yf.