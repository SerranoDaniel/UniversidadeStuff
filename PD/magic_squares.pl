sel(E, [E|L], L).
sel(E, [X|L], [X|M]) :- sel(E, L, M).

perm([], []).
perm(L, [X|LP]) :-
    sel(X, L, LX),
    perm(LX, LP).

soma([], 0) :- !.
soma([L|Ls], S) :-
    soma(Ls, Sc),
    S is Sc + L.

linha(L, N, I, LV) :-
    Nk is N*(I-1),
    


squares(N, SOL) :-
    perm(SOL, X),
    squares(N, SOL, X).

    

