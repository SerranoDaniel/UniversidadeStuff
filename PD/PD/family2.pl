parent(terach,abraham).
parent(isaac,jacob).
parent(abraham,isaac).
parent(jacob,benjamin).

ancestor(X,Y) :-
	parent(X,Y).
ancestor(X,Y) :-
	parent(X,Z),
	ancestor(Z,Y).