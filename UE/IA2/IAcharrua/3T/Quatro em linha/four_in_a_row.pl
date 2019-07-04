estado_inicial( e(['.','.','.','.','.','.'],['.','.','.','.','.','.'],['.','.','.','.','.','.'],['.','.','.','.','.','.'],['.','.','.','.','.','.'],['.','.','.','.','.','.'],['.','.','.','.','.','.']) ).
	
verificaColunas(Jogador, e(C1,C2,C3,C4,C5,C6,C7), Ci, Cf):-
	colunas(Jogador, [C1,C2,C3,C4,C5,C6,C7], Ci, Cf).

verificaLinhas(Jogador, e([C1|R1], [C2|R2], [C3|R3], [C4|R4], [C5|R5], [C6|R6], [C7|R7]), Ci, Cf):-
 	verificaLista(Jogador, [C1,C2,C3,C4,C5,C6,C7], Ci, Cf1), ((Cf1 = 4,Cf=4);
	verificaLinhas(Jogador, e(R1, R2, R3, R4, R5, R6, R7), Cf1, Cf)).

verificaDiagonaisDE(Jogador, e([_,_,_,A4, A5, A6], [_,_,B3, B4, B5, B6], [_, C2, C3, C4, C5, C6], [D1, D2, D3, D4, D5, D6], [E1, E2, E3, E4, E5, _], [F1, F2, F3, F4, _, _], [G1, G2, G3, _, _, _]), Ci, Cf):-
	verificaLista(Jogador, [D1, C2, B3, A4], Ci, Cf1), 
	(
		(Cf1=4, Cf=4) ; verificaLista(Jogador, [E1, D2, C3, B4, A5], Ci, Cf2),
		(
			(Cf2=4, Cf=4) ; verificaLista(Jogador, [F1, E2, D3, C4, B5, A6], Ci, Cf3),
			(
				(Cf3=4, Cf=4) ; verificaLista(Jogador, [G1, F2, E3, D4, C5, B6], Ci, Cf4),
				(
					(Cf4=4, Cf=4) ; verificaLista(Jogador, [G2, F3, E4, D5, C6], Ci, Cf5),
					(
						(Cf5=4, Cf=4) ; verificaLista(Jogador, [G3,F4, E5, D6], Ci, Cf) 
					)
				)
			)
		)
	).

verificaDiagonaisED(Jogador, e([A1,A2,A3,_,_,_], [B1,B2,B3,B4,_,_], [C1,C2,C3,C4,C5,_], [D1,D2,D3,D4,D5,D6], [_,E2,E3,E4,E5,E6], [_,_,F3,F4,F5,F6], [_,_,_,G4,G5,G6]), Ci, Cf):-
	verificaLista(Jogador, [A3,B4,C5,D6], Ci, Cf1), 
	(
		(Cf1=4, Cf=4) ; verificaLista(Jogador, [A2,B3,C4,D5,E6], Ci, Cf2),
		(
			(Cf2=4, Cf=4) ; verificaLista(Jogador, [A1,B2,C3,D4,E5,F6], Ci, Cf3),
			(
				(Cf3=4, Cf=4) ; verificaLista(Jogador, [B1,C2,D3,E4,F5,G6], Ci, Cf4),
				(
					(Cf4=4, Cf=4) ; verificaLista(Jogador, [C1,D2,E3,F4,G5], Ci, Cf5),
					(
						(Cf5=4, Cf=4) ; verificaLista(Jogador, [D1,E2,F3,G4], Ci, Cf) 
					)
				)
			)
		)
	).

colunas(Jogador, [L|R], Ci, Cf):-
	verificaLista(Jogador, L, Ci, Cfn),
	((Cfn = 4, Cf = 4);
	(colunas(Jogador, R, 0, Cf))).

verificaLista(_,_, 4, 4).
verificaLista(_,[],Ci,Ci).
verificaLista(Jogador,[E|R],Ci, Cf):-
	avalia(Jogador,E,Ci,Cf1),
	verificaLista(Jogador,R,Cf1, Cf).

avalia(J,J,Ci,Cf):- Cf is Ci + 1.
avalia(J,E,_,0):- J \= E.

op(Jogador, e(A,B,C,D,E,F,G), a, e(Ef,B,C,D,E,F,G)):- putObject(Jogador, A, [], Ef).
op(Jogador, e(A,B,C,D,E,F,G), b, e(A,Ef,C,D,E,F,G)):- putObject(Jogador, B, [], Ef).
op(Jogador, e(A,B,C,D,E,F,G), c, e(A,B,Ef,D,E,F,G)):- putObject(Jogador, C, [], Ef).
op(Jogador, e(A,B,C,D,E,F,G), d, e(A,B,C,Ef,E,F,G)):- putObject(Jogador, D, [], Ef).
op(Jogador, e(A,B,C,D,E,F,G), e, e(A,B,C,D,Ef,F,G)):- putObject(Jogador, E, [], Ef).
op(Jogador, e(A,B,C,D,E,F,G), f, e(A,B,C,D,E,Ef,G)):- putObject(Jogador, F, [], Ef).
op(Jogador, e(A,B,C,D,E,F,G), g, e(A,B,C,D,E,F,Ef)):- putObject(Jogador, G, [], Ef).

putObject(Jogador, ['.'|Column], AuxList, Ef):- 
	append(AuxList, [Jogador|Column], Ef).
putObject(Jogador, [Obj|Column], AuxList, Ef):-
	Obj \= '.',
	append(AuxList, [Obj], Aux),
	putObject(Jogador, Column, Aux, Ef).

drawtable(e([],_,_,_,_,_,_)):- nl,
	write('  A   B   C   D   E   F   G  '),nl,
	write('+---+---+---+---+---+---+---+'),nl.
drawtable(e([A|Ra],[B|Rb],[C|Rc],[D|Rd],[E|Re],[F|Rf],[G|Rg])):-
	drawtable(e(Ra,Rb,Rc,Rd,Re,Rf,Rg)),
	writeLine([A,B,C,D,E,F,G]),
	write('+---+---+---+---+---+---+---+'),nl.

writeLine([]):- write('|'), nl.
writeLine(['.'|R]):- 
	write('|   '),
	writeLine(R).
writeLine([A|R]):-
	write('| '), write(A), write(' '),
	writeLine(R).

/******************************BEGIN**************************************/

go(x):-
	estado_inicial(Estado),
	play('x',Estado,NE),
	go(o,NE).
go(o):-
	estado_inicial(Estado),
	play('o',Estado,NE),
	go(x,NE).

go(x, Estado):-
	\+ verificaColunas('o', Estado, 0, 4),
	\+ verificaLinhas('o', Estado, 0, 4),
	\+ verificaDiagonaisDE('o', Estado, 0, 4),
	\+ verificaDiagonaisED('o', Estado, 0, 4),
	play('x', Estado, NE),
	go(o,NE).
go(o, Estado):-
	\+ verificaColunas('x', Estado, 0, 4),
	\+ verificaLinhas('x', Estado, 0, 4),
	\+ verificaDiagonaisDE('x', Estado, 0, 4),
	\+ verificaDiagonaisED('x', Estado, 0, 4),
	play('o', Estado, NE),
	go(x,NE).
go(x,Estado):- 
	drawtable(Estado),
	write('Game Over'),nl,
	write('Player O win.'),nl,stop.
go(o,Estado):- 
	drawtable(Estado),
	write('Game Over'),nl,
	write('Player X win.'),nl,stop.

play(Jogador,Estado,NewEstado):-
	drawtable(Estado),
	write('Type stop. to End Game.'),nl,
	write(Jogador),write(' to play:'),nl,write('Type Column: '),
	read(Column), 
	(Column = stop, stop; op(Jogador, Estado, Column, NewEstado)).
