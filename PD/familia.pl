progenitor(chico, daniel).
progenitor(chico, kiko).
progenitor(chico, alexanfre).
progenitor(fernanfa, daniel).
progenitor(fernanfa, kiko).
progenitor(fernanfa, alexanfre).
progenitor(celestina, chico).
progenitor(celestina, antonio).
progenitor(domingos, chico).
progenitor(domingos, antonio).
progenitor(antonio, miguel).
progenitor(antonio, pedro).
progenitor(antonio, joao).
progenitor(antonio, maria).

progenitor(caramelo, celestina).
progenitor(jotap, caramelo).

progenitor(pica, porco).
progenitor(filipe, porco).

animal(porco).
homem(pica).
homem(filipe).
homem(daniel).
homem(chico).
homem(kiko).
homem(pedro).
homem(miguel).
homem(joao).
homem(antonio).
homem(domingos).
homem(alexanfre).
homem(joaquimmiguel).

mulher(maria).
mulher(fernanfa).
mulher(isabel).
mulher(celestina).

gay(X) :-
    progenitor(X, Z),
    progenitor(Y, Z),
    (homem(X),
    homem(Y))/
    (mulher(X), 
    mulher(Y)).

pai(X, Y) :-
	progenitor(X, Y),
	homem(X).

mae(X, Y) :-
    progenitor(X, Y),
    mulher(X).

avo(X, Y) :-
    progenitor(X, Z),
    progenitor(Z, Y).

irmao(X, Y) :-
    progenitor(Z, X),
    progenitor(Z, Y),
    homem(X),
    X \= Y.

irma(X, Y) :- 
    progenitor(Z, X),
    progenitor(Z, Y),
    mulher(X),
    X \= Y.

primo(X, Y) :-
    progenitor(Z, X),
    progenitor(U, Y),
    \+irmao(X, Y),
    (irmao(Z, U) ; irma(Z, U)).

prima(X, Y) :-
    progenitor(Z, X),
    progenitor(U, Y),
    irma(Z, U).

tio(X, Y) :-
    progenitor(Z, Y),
    irmao(X, Z).

tia(X, Y) :-
    progenitor(Z, Y),
    irma(X, Z).


antepassado(X, Y) :-
    progenitor(X,Y).
antepassado(X, Y) :-
    progenitor(X, Z),
    antepassado(Z, Y).
    
parente(X, Y) :- 
    antepassado(Z, Y),
    antepassado(Z, X).   