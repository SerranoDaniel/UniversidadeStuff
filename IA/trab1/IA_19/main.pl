estado_inicial((18,18)).
estado_final((26,26)).


blocked((1,2), (1,3)).
blocked((1,3), (1,2)).
blocked((2,3), (2,2)).
blocked((2,2), (2,3)).
blocked((3,4), (4,4)).
blocked((4,4), (3,4)).
blocked((4,5), (3,5)).
blocked((3,5), (4,5)).


largura(30).
profundidade(30).


:- dynamic(visited/1).
visited((18,18)).


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%


op((X, Y), baixo, (Z, Y), 1) :- 
		profundidade(Prof),
		X < Prof,
		Z is X+1,
		( visited((Z,Y))
			-> fail	
			; ( blocked((X, Y), (Z, Y))
				-> fail
				; asserta(visited((Z,Y)))
			  )
		).

op((X, Y), dir, (X, Z), 1) :- 
		largura(Larg),
		Z is Y+1,
		Y < Larg,
		( visited((X,Z))
			-> fail
		  	;(blocked((X, Y), (X, Z))
		  		-> fail
		  		; asserta(visited((X,Z)))
		  	)
		).

op((X, Y), esq, (X, Z), 1) :- 
		Y > 1,
		Z is Y-1,
		( visited((X,Z))
			-> fail
			 ; ( blocked((X, Y), (X, Z))
		 		-> fail
		 		; asserta(visited((X,Z)))
			   )
		 ).

op((X, Y), sobe, (Z, Y), 1) :- 
		X > 1,
		Z is X-1,
		( visited((Z,Y))
			-> fail
		  	; ( blocked((X, Y), (Z, Y))
				-> fail
				; asserta(visited((Z,Y)))
			  )
		).


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%


%Heuristica 1 - Distancia de manhattan
heu_1((Ix,Iy),SOMA):-
	estado_final((Fx,Fy)),
	Dx is abs(Ix - Fx), 
 	Dy is abs(Iy - Fy),
	SOMA is Dx + Dy.


%Heuristica 2 - Distancia euclidiana
heu_2((Ix,Iy),SOMA):-
	estado_final((Fx,Fy)),
	Dx is abs(Ix - Fx), 
 	Dy is abs(Iy - Fy),
	SOMA is round(sqrt(Dy ** 2 + Dx ** 2)).