

estado_inicial(([(p(1,1),a),(p(1,2),a),(p(1,3),a),
				(p(2,1),a),(p(2,2),a),(p(2,3),a),
				(p(3,1),a),(p(3,2),a),(p(3,3),a)],x)).

op1((E,O), insere(p(X,Y),O), (EF,P)):-		% estadoincial,operação,Estadoseguinte
	member(X, [1,2,3]),member(Y, [1,2,3]),	%estado_inicial = (tabuleiro,jogador)  estado_seguinte = (tabuleiro modificado, jogador seguinte) 
	inverte_jogador(O,P),								
	insere_posicao(X, Y, P, E, EF).

insere_posicao(_, _, _, [], []):-!.

insere_posicao(X, Y, S, [E|TE], [E|EF]):-
	E=(p(PX,PY),_),
	(PX\=X;PY\=Y),!,
	insere_posicao(X,Y,S,TE,EF).

insere_posicao(X, Y, S, [HE|TE], [HEF|TEF]):-
	HE=(p(X,Y),a),
	HEF=(p(X,Y),S),
	insere_posicao(X,Y,S,TE,TEF).

inverte_jogador(x,o).
inverte_jogador(o,x).
	
terminal((EF,_)):-
	(linha(EF,1,_);
	linha(EF,2,_);
	linha(EF,3,_);
	coluna(EF,1,_);
	coluna(EF,2,_);
	coluna(EF,3,_);
	diag_Direita(EF,_);
	diag_Esquerda(EF,_);
	empate(EF)),
	!.

linha(E, Linha, Q):-
	member((p(1,Linha),Q1),E),
	member((p(2,Linha),Q2),E),
	member((p(3,Linha),Q3),E),
	Q1\=a,Q2\=a,Q3\=a,
	Q1=Q2,
	Q1=Q3,
	Q=Q1.

empate(EF):-
	member((p(1,1),Q1),EF),
	member((p(2,1),Q2),EF),
	member((p(3,1),Q3),EF),
	member((p(1,2),Q4),EF),
	member((p(2,2),Q5),EF),
	member((p(3,2),Q6),EF),
	member((p(1,3),Q7),EF),
	member((p(2,3),Q8),EF),
	member((p(3,3),Q9),EF),
	Q1\=a,Q2\=a,Q3\=a,Q4\=a,Q5\=a,Q6\=a,Q7\=a,Q8\=a,Q9\=a.

coluna(E, Colu, Q):-
	member((p(Colu,1),Q1),E),
	member((p(Colu,2),Q2),E),
	member((p(Colu,3),Q3),E),
	Q1\=a,Q2\=a,Q3\=a,
	Q1=Q2,
	Q1=Q3,
	Q=Q1.

diag_Direita(E, Q):-
	member((p(1,1),Q1),E),
	member((p(2,2),Q2),E),
	member((p(3,3),Q3),E),
	Q1\=a,Q2\=a,Q3\=a,
	Q1=Q2,
	Q1=Q3,
	Q=Q1.

diag_Esquerda(E, Q):-
	member((p(3,1),Q1),E),
	member((p(2,2),Q2),E),
	member((p(1,3),Q3),E),
	Q1\=a,Q2\=a,Q3\=a,
	Q1=Q2,
	Q1=Q3,
	Q=Q1.

valor((E, _), 1, _):-
	(linha(E,1,x);
	linha(E,2,x);
	linha(E,3,x);
	coluna(E,1,x);
	coluna(E,2,x);
	coluna(E,3,x);
	diag_Esquerda(E,x);
	diag_Direita(E,x)),!.


valor((E,_), -1, _):-
	(linha(E,1,o);
	linha(E,2,o);
	linha(E,3,o);
	coluna(E,1,o);
	coluna(E,2,o);
	coluna(E,3,o);
	diag_Esquerda(E,o);
	diag_Direita(E,o)),!.

valor((E, _), 0, _):-
	empate(E),!.

print_(E):-
	print_linhas(E).

print_linhas(E):-
	write('       '),
	print_linha(E, 1, 1),
	write('       '),
	write_line(1, 3),
	write('       '),
	print_linha(E, 2, 1),
	write('       '),
	write_line(1, 3),
	write('       '),
	print_linha(E, 3, 1),
	write('\n\n').

print_linha(E, I, J):-
	member((p(I,J), X), E),
	J = 3,
	write_last_element(X),write('\n').

print_linha(E, I, J):-
	\+member((p(I,J), X), E),
	J = 3,
	write_last_element(X).

print_linha(E, I, J):-
	J < 3, J2 is J+1,
	member((p(I,J), X), E),
	write_elements(X),
	print_linha(E, I, J2).

print_linha(E, I, J):-
	J < 3, J2 is J+1,
	\+member((p(I,J), X), E),
	write_elements(X),
	print_linha(E, I, J2).

write_elements(X):-
	nonvar(X),
	write(X),write(' | ').
write_elements(X):-
	\+ nonvar(X),
	write(' '),write(' | ').
write_last_element(X):-
	nonvar(X),
	write(X).
write_last_element(X):-
	\+ nonvar(X),
	write(' ').


write_line( I, P):-
        I = P, write('- - -'), nl.
write_line( I, P):-
        I < P, I2 is I+1,
        write('- '),
        write_line(I2, P).