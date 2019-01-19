
random_l(0, []).
random_l(N, [R|L]) :- 
    random(R),
    Nx is N - 1,
    random_l(Nx, L).

sum([], 0).
sum([X|Xs], S) :- 
    sum(Xs, Sx),
    S is Sx + X.

    
prod([], 1).
prod([X|Xs], S) :- 
    prod(Xs, Sx),
    S is Sx * X.

len([], 0).
len([_|Ls], Len) :- 
    len(Ls, LenA),
    Len is LenA + 1.

 
compr(_, B, [], B) :- !.
compr(O, B, [X|Xs], S) :- 
    compr(O, B, Xs, Sx),
    functor(F, O, 2), arg(1, F, X), arg(2, F, Sx),
    S is F.

calc:-
    write('>'),
    read(S),
    exec(S).

exec(end_of_file) :- !.
exec(X) :- 
    do(X),
    calc.

do(E) :-
    R is E,
    write(R),
    nl.


eval(A+B,R):-
    eval(A, RA),
    eval(B, RB),
    R is RA + RB.

eval(A-B,R):-
    eval(A, RA),
    eval(B, RB),
    R is RA - RB.

eval(A*B,R):-
    eval(A, RA),
    eval(B, RB),
    R is RA * RB.

eval(A/B,R):-
    eval(A, RA),
    eval(B, RB),
    R is RA / RB.


fdic([]).
fdic([_=_|D]) :- fdic(D).

llookup(D, _, _) :- var(D), !, fail.
llookup([K=V|_], K, V).
llookup([_|D], K, V) :- lookup(D, K, V).


insert(D, K, V) :- var(D), !, D=[K=V|_].
insert([K=_|_], K, _) :- !, fail.
insert([_|D], K, V) :- insert(D, K, V).


t(1, isto(nao, e(um), termo(simples))).
t(2, pois(pois(pois,claro), que(nao), se, percebe(o(que), significa(isto)))).



% VE SE O TERMO ESTA NA LISTA e manda a posicao
contem(T, T, []) :- !.
contem(T, A, _) :-
    functor(A, T, _).
contem(ST, T, L) :-
    compound(T),
    functor(T, _, N),
    contem(N, ST, T, L).  
contem(N, ST, T, L) :-
    N > 1, N1 is N-1,
    contem(N1, ST, T, L).
contem(N, ST, T, [N|L]) :-
    arg(N, T, A),
    contem(ST, A, L). 


subterm(T, T).
subterm(ST, T) :-
    compound(T),
    functor(T, _, N),
    subterm(N, ST, T).
subterm(N, ST, T) :-
    N > 1, N1 is N-1,
    subterm(N1, ST, T).
subterm(N, ST, T) :-
    arg(N, T, A),
    subterm(ST, A).



contemU(T, T, []) :- !.
contemU(A, T, _) :-
    T =.. [A|_].
contemU(ST, T, L) :-
    T =.. Lis,
    length(Lis, N),
    contemU(N, ST, Lis, L).  
contemU(N, ST, [_|Ts], L) :-
    N > 1, N1 is N-1,
    contemU(N1, ST, Ts, L).
contemU(N, ST, As, [N|L]) :-
    contemU(ST, As, L).
    



fib(0,1).
fib(1,1).
fib(N,X) :- 
    N>1,
    N1 is N-1,
    N2 is N-2,
    fib(N1,X1), 
    fib(N2,X2),
    X is X1+X2.
