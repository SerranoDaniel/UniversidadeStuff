estado_inicial(([c1(0),c2(0)],[s(0)])).
estado_final((_,[s(1300)])).


op(([c1(X),c2(Y)],Z), c1parac2 , ([c1(A),c2(B)],Z),1):-
	Y < 200,
	X > 0,
	Livre2 is 200-Y,
	calculaAB_c1c2(Livre2,X,Y,A,B).
	
op(([c1(X),c2(Y)],Z), c2parac1 , ([c1(A),c2(B)],Z),1):-
	X<500,
	Y>0,
	Livre1 is 500-X,
	calculaAB_c2c1(Livre1,X,Y,A,B).

op(([c1(X),Y],[s(Z)]), dC1saco, ([c1(0),Y],[s(A)]),1):-
	X\=0,
	A is X+Z,
	A<1300.

op(([Y,c2(X)],[s(Z)]), dC2saco, ([Y,c2(0)],[s(A)]),1):-
	X\=0,
	A is X+Z,
	A<1300.	
	
op(([c1(A),X],Y), encheC1, ([c1(500),X],Y),1):-
	A\=500.
op(([X,c2(A)],Y), encheC2, ([X,c2(200)],Y),1):-
	A\=200.

op(([c1(A),X],Y), despejaC1, ([c1(0),X],Y),1):-
	A\=0.
op(([X,c2(A)],Y), despejaC2, ([X,c2(0)],Y),1):-
	A\=0.

	
calculaAB_c1c2(Livre2,X,_,A,B):-
	X>=Livre2,
	A is X-Livre2,
	B=200,!.
	
calculaAB_c1c2(Livre2,X,Y,A,B):-
	X<Livre2,
	A=0,
	B is X+Y.


	
calculaAB_c2c1(Livre1,_,Y,A,B):-
	Y>= Livre1,
	A=500,
	B is Y-Livre1,!.
	
calculaAB_c2c1(Livre1,X,Y,A,B):-
	Y<Livre1,
	A is X+Y,
	B=0.
