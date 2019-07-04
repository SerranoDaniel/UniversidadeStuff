%ex1

% estado(c(x,y), [Lista por capturar]) -> c(x,y) = pos. actual
estado_inicial(c((1,1), [(3,1), (1,4), (6,1), (4,6)])).
estado_final(c((4,6), [])).
    
restricoes([(4,5), (5,5), (5,4)]).

%representacao dos operadores
%op(EstadoActual, Operador, EstadoSeguinte, Custo)

captura(P, [H|L], L):-
     P = H,
     !.
captura(_, X, X).

op(c((X,Y), L1), sobe, c((X,Z), L2), 1):-
                            Z is Y+1,
                            Z < 7,
                            restricoes(Rest),
                            \+ member((X,Z), Rest),
                            captura((X, Z), L1, L2).

op(c((X,Y), L1), desce, c((X,Z), L2), 1):-
                            Z is Y-1,
                            Z > 0,
                            restricoes(Rest),
                            \+ member((X,Z), Rest),
                            captura((X, Z), L1, L2).

op(c((X,Y), L1), esquerda, c((Z,Y), L2), 1):-
                            Z is X-1,
                            Z > 0,
                            restricoes(Rest),
                            \+ member((Z,Y), Rest),
                            captura((Z, Y), L1, L2).

op(c((X,Y), L1), direita, c((Z,Y), L2), 1):-
                            Z is X+1,
                            Z < 7,
                            restricoes(Rest),
                            \+ member((Z,Y), Rest),
                            captura((Z, Y), L1, L2).

%ex 2
%                (1,1)                  profundidade 0
%             /        \
%           /            \
%      (2,1)              (1,2)         profundidade 1
%   /    |    \        /    |   \
%(1,1) (2,2) (3,1)  (1,1) (2,2) (1,3)   profundidade 2

%ex 4 -> pesquisa em profundidade iterativa já que evita ciclos desnecessários, 
%enquanto que a largura consome mais memória

%ex 5 -> uma heurística admissível poderia ser calcular a distância até ao próximo objectivo