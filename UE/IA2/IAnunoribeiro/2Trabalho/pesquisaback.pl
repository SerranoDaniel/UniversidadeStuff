
p:- consult('trabalho.pl'),
estado_inicial(E0), back(E0,A), esc(A).

back(e([],A),A).
back(E,Sol):- sucessor(E,E1), ve_restricoes(E1),
                          back(E1,Sol).

sucessor(e([v(N,D,V)|R],E),e(R,[v(N,D,V)|E])):- member(V,D).


f:- consult('trabalho.pl'),
estado_inicial(E0), forwerd(E0,A), esc(A).

sucessor2(e([v(N,D,V)|R],E),e(NovoR,[v(N,D,V)|E])):- member(V,D),
	altera_dominio(N,V,R,NovoR).

altera_dominio(_,_, [], []):-!.
altera_dominio(c(X,Y),Val, [HeadR|TailR], [HeadR|TailNR]):-
	HeadR=v(c(XX,YY),D,_),
	X\=XX,
	Y\=YY,
	!,
	altera_dominio(c(X,Y),Val,TailR,TailNR).

altera_dominio(c(X,Y),Val, [HeadR|TailR], [HeadNR|TailNR]):-
	HeadR = v(c(X1,Y1),D,_),
	subtract(D,[Val],NovoD),
	HeadNR = v(c(X1,Y1),NovoD,_),
	!,
	altera_dominio(c(X,Y),Val, TailR,TailNR).



forwerd(e([],A),A).
forwerd(E,Sol):- sucessor2(E,E1), ve_restricoes(E1),
                          forwerd(E1,Sol).
