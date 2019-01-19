num(X).
mais1(X,s(X)):-
	num(X).

soma(z,X,X).
soma(s(X),Y,s(Z)):-	
	soma(X,Y,Z).

subtr(X,z,X).
subtr(X,Y,Z):-	
	soma(Z,Y,X).

le(X,Y):-	
	soma(X,_,Y).

lt(X,Y):-	
	soma(X,s(_),Y).

dobro(z,z).
dobro(X,Y):-	
	soma(X,X,Y).

mult(z,_,z).
mult(s(X),Y,Z):-	
	mult(X,Y,W),
	soma(Y,W,Z).

div(z,_,z).
div(X,Y,Z):-	
	mult(Z,Y,X).

pot(_,z,s(z)).
pot(X,s(Y),Z):-		
	pot(X,Y,W),
	mult(X,W,Z).

quadrado(X,Y):-	
	mult(X,X,Y).


cortar([], _, [], []).
cortar([X|L], X, [], [X|L]).
cortar([Y|M], X, [Y|Z], W) :-
	cortar(M, X, Z, W).

partir([], _, [], []).
partir([X|L], Y, [X|Z], W) :-
	X < Y,
	partir(L, Y, Z, W).
partir([X|L], Y, Z, [X|W]) :-
	\+ X < Y,
	partir(L, Y, Z, W).

misturar([], [], []).
misturar([], Z, Z).
misturar(Z, [], Z).
misturar([X|Xs], [Y|Ys], [X,Y|L]) :-
	misturar(Xs, Ys, L).






cortar([], _, [], []).

cortar([E|L], E, [], [E|L]).

cortar([X|A], E, [Y|B], C) :- 
	cortar(A, E, B, C).


partir([], _, [], []).

partir([X|A], E, [X|B], C) :-
	X < E,
	partir(A, E, B, C).

partir([X|A], E, B, [X|C]) :-
	\+ X < E,
	partir(A, E, B, C).



misturar([], [], []).

misturar([], X, X).

misturar(X, [], X).

misturar([X|A], [Y|B], [X,Y|W]) :- 
	misturar(A,B,W).