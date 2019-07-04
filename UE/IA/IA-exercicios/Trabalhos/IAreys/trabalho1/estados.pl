%Descricao do problema:

estado_inicial(c((18,18), [])).
estado_final(c((26,26), _)).

restricoes([(1,2), (1,3), (2,3), (2,2), (3,4), (4,4), (4,5), (3,5)]).

%representacao dos operadores
%op(EstadoActual, Operador, EstadoSeguinte, Custo)

op(c((X,Y), L), sobe, c((X,Z), [(X,Y)|L]), 1):-
                            Z is Y+1,
                            Z < 31,
                            restricoes(Rest),
                            \+ member((X,Z), Rest),
                            \+ member((X,Z), L).

op(c((X,Y), L), desce, c((X,Z), [(X,Y)|L]), 1):-
                            Z is Y-1,
                            Z > -1,
                            restricoes(Rest),
                            \+ member((X,Z), Rest),
                            \+ member((X,Z), L).

op(c((X,Y), L), esquerda, c((Z,Y), [(X,Y)|L]), 1):-
                            Z is X-1,
                            Z > -1,
                            restricoes(Rest),
                            \+ member((Z,Y), Rest),
                            \+ member((Z,Y), L).

op(c((X,Y), L), direita, c((Z,Y), [(X,Y)|L]), 1):-
                            Z is X+1,
                            Z < 31,
                            restricoes(Rest),
                            \+ member((Z,Y), Rest),
                            \+ member((Z,Y), L).

%Heuristicas

h(c((X,Y), _), H):- estado_final(c((W,Z), _)),
                     CoordX is abs(W-X),
                     CoordY is abs(Z-Y),
                     H is CoordY + CoordX.

%h(c((X,Y), _), H):- estado_final(c((W,Z), _)),
 %                    CoordX is abs(W-X),
  %                   CoordY is abs(Z-Y),
   %                  H is round(sqrt(CoordY*CoordY + CoordX*CoordX)).