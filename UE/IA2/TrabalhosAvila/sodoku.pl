tamanho_tabuleiro(9).

dominio([1,2,3,4,5,6,7,8,9]).

estado_inicial(e([v(n(1,1),D,_),v(n(1,3),D,_),v(n(1,4),D,_),v(n(1,5),D,_),v(n(1,7),D,_),
				 v(n(2,1),D,_),v(n(2,2),D,_),v(n(2,3),D,_),v(n(2,5),D,_),v(n(2,7),D,_),v(n(2,8),D,_),v(n(2,9),D,_),
				 v(n(3,2),D,_),v(n(3,3),D,_),v(n(3,4),D,_),v(n(3,5),D,_),v(n(3,6),D,_),v(n(3,8),D,_),
				 v(n(4,1),D,_),v(n(4,2),D,_),v(n(4,3),D,_),v(n(4,4),D,_),v(n(4,5),D,_),v(n(4,7),D,_),v(n(4,8),D,_),v(n(4,9),D,_),
				 v(n(5,1),D,_),v(n(5,2),D,_),v(n(5,3),D,_),v(n(5,4),D,_),v(n(5,7),D,_),
				 v(n(6,2),D,_),v(n(6,3),D,_),v(n(6,5),D,_),v(n(6,6),D,_),v(n(6,7),D,_),v(n(6,8),D,_),v(n(6,9),D,_),
				 v(n(7,1),D,_),v(n(7,2),D,_),v(n(7,3),D,_),v(n(7,5),D,_),v(n(7,6),D,_),v(n(7,7),D,_),v(n(7,8),D,_),v(n(7,9),D,_),
				 v(n(8,3),D,_),v(n(8,4),D,_),v(n(8,6),D,_),v(n(8,7),D,_),v(n(8,9),D,_),
				 v(n(9,1),D,_),v(n(9,2),D,_),v(n(9,4),D,_),v(n(9,5),D,_),v(n(9,7),D,_),v(n(9,8),D,_),v(n(9,9),D,_)],
[v(n(1,2),D,1),
v(n(1,6),D,8),
v(n(1,8),D,7),
v(n(1,9),D,3),
v(n(2,4),D,5),
v(n(2,6),D,9),
v(n(3,1),D,7),
v(n(3,7),D,9),
v(n(3,9),D,4),
v(n(4,6),D,4),
v(n(5,5),D,3),
v(n(5,6),D,5),
v(n(5,8),D,1),
v(n(5,9),D,8),
v(n(6,1),D,8),
v(n(6,4),D,9),
v(n(7,4),D,7),
v(n(8,1),D,2),
v(n(8,2),D,6),
v(n(8,5),D,4),
v(n(8,8),D,3),
v(n(9,3),D,5),
v(n(9,6),D,3)]) ):- dominio(D).

 
%Verifica todas as restriçoes do sudoku
restricoes(e(NAfect,Afect)):-
	ver_linhas(e(Nafect,Afect)),
	ver_colunas(e(Nafect,Afect)),
	ver_quadrantes(e(Nafect,Afect)).
 

all_diff([]).
all_diff([H|T]) :-
	\+member(H, T), all_diff(T).


ver_linhas(e(Nafect,[v(n(X,Y), D, V)|R])):- findall(V1,member(v(n(X,_),_,V1),R),L), all_diff([V|L]).

ver_colunas(e(Nafect,[v(n(X,Y), D, V)|R])):- findall(V1,member(v(n(_,Y),_,V1),R),L), all_diff([V|L]).

ver_quadrantes(e(_, Afect)):-
	%ve o primeiro quadrante 
	ver_quadrante(Afect, 1, 1, 3, Q1), all_diff(Q1),

	%ve o segundo quadrante
	ver_quadrante(Afect, 1, 4, 6, Q2),all_diff(Q2),

	%ve o terceiro quadrante
	ver_quadrante(Afect, 1, 7, 9, Q3),all_diff(Q3),

	%ve o quarto quadrante
	ver_quadrante(Afect, 4, 1, 3, Q4),all_diff(Q4),

	%ve o quinto quadrante
	ver_quadrante(Afect, 4, 4, 6, Q5),all_diff(Q5),

	%ve o sexto quadrante
	ver_quadrante(Afect, 4, 7, 9, Q6),all_diff(Q6),

	%ve o sétimo quadrante
	ver_quadrante(Afect, 7, 1, 3, Q7),all_diff(Q7),

	%ve o oitavo quadrante
	ver_quadrante(Afect, 7, 4, 6, Q8),all_diff(Q8),

	%ve o nono quadrante
	ver_quadrante(Afect, 7, 7, 9, Q9),all_diff(Q9).


ver_quadrante(L, X, Y, Y2, L2):-
	Y = Y2, X1 is X+2,
	ver_q_c(L, X, Y, X1, L2).

ver_quadrante(L, X, Y, Y2, L3):-
	Y < Y2, Y1 is Y+1,
	X1 is X+2,
	ver_q_c(L, X, Y, X1, L1),
	append(L1, L2, L3),
	ver_quadrante(L, X, Y1, Y2, L2).

ver_q_c(L, X, Y, X2, []):-
	X = X2,
	\+member(v(n(X, Y), _, _), L).

ver_q_c(L, X, Y, X2, [V]):-
        X = X2,
        member(v(n(X,Y), _, V), L).

ver_q_c(L, X, Y, X2, T):-
        X < X2, X1 is X+1,
        \+member(v(n(X, Y), _, _), L),
	ver_q_c(L, X1, Y, X2, T).

ver_q_c(L, X, Y, X2, [V|T]):-
	X < X2, 
        member(v(n(X,Y), _, V), L),
	X1 is X+1,
        ver_q_c(L, X1, Y, X2, T).



%% escreve
%esc(_).
esc(L):-sort(L, L1), esc_a(L1),nl.

esc_a(L):- tamanho_tabuleiro(S), esc_l(L, 1, S).

esc_l([H], S, S):- H = v(_,_,X), write(X),nl.

esc_l([H|T], S, S):- H = v(_,_,X), write(X), nl, esc_l(T, 1, S).

esc_l([H|T], I, S):- I<S, I2 is I+1, H = v(_,_,X), write(X),write(' . '),esc_l(T, I2, S).