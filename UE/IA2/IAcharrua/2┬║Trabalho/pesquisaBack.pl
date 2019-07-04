p :- consult(quadrado3), 
	 estado_inicial(E0), 
	 back(E0,A),
	 esc(A).

esc([]).
esc([Afect|Tail]) :-
	Afect = v(C,_,V),
	write(V),
	write(' '),
	write(C),
	nl,
	esc(Tail).


back(e([],A),A).
back(E,Sol) :- 
	sucessor(E,E1), 
	ve_restricoes(E1),
	forwardC(E1,E2),
    back(E1,Sol).




sucessor(e([v(N,D,_)|R],E),e(R,[v(N,D,V)|E])):- 
	member(V,D).


%ForwardChecking

forwardC(e(NAfect,[v(N,D,V)|Afect]),e(NAfectS,[v(N,D,V)|Afect])):-
	    actualizaDom(V, NAfect, NAfectS).

actualizaDom(_,[],[]).
actualizaDom(V,[v(N,D,_)|NAfect],[v(N,DS,_)|NAfectS]):-
	delete(D,V,DS),
	actualizaDom(V, NAfect, NAfectS).



