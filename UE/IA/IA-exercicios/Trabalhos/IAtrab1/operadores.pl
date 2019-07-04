
:- dynamic(caminho/1).
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

porta_bloq((1,2),(1,3)).
porta_bloq((1,3),(1,2)).
porta_bloq((2,3),(2,2)).
porta_bloq((2,2),(2,3)).
porta_bloq((3,4),(4,4)).
porta_bloq((4,4),(3,4)).
porta_bloq((4,5),(3,5)).
porta_bloq((3,5),(4,5)).


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
estado_inicial((18,18)).
estado_final((26,26)).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%


op((A,B),sobe,(C,B),1):-
	A > 1,
	C is A-1,
	(caminho((C,B))
	-> fail
		;assertz(caminho((C,B)))
	).


op((A,B),desce,(C,B),1):-
	A < 30,
	C is A+1,
	(caminho((C,B))
	-> fail
		;assertz(caminho((C,B)))
	).



op((A,B),dir,(A,C),1):-
	B < 30,
	C is B+1,
	(caminho((A,C))
	-> fail
		;assertz(caminho((A,C)))
	).


op((A,B),esq,(A,C),1):-
	B > 1,
	C is B-1,
	(caminho((A,C))
	-> fail
		;assertz(caminho((A,C)))
	).


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%


% 1 a heuristica
h((Xi,Yi),V):- estado_final((Xf,Yf)), V is (Xf - Xi) + (Yf - Yi).
% 2 o heuristica
h((Xi,Yi),V):- estado_final((Xf,Yf)), Xf \= Xi, V is (Yf - Yi)/ (Xf - Xi).
h((Xi,Yi),V):- estado_final((Xf,Yf)), Xf = Xi,V is 0.


