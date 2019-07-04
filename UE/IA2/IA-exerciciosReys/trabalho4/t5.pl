
% estadoInicial
grande('A').
grande('D').
pequeno('B').
pequeno('C').

h(sobre('D', 'A'), s0).
h(sobre('C', 'B'), s0).
h(bracos(0, 0), s0).
h(chao('A'), s0).
h(chao('B'), s0).
h(topo('D'), s0).
h(topo('C'), s0).

% estadoFinal
h(sobre('A', ('B', 'C'), S).
h(sobre(('B', 'C'), 'D'), S).
h(adjacente('B', 'C'), S).
h(bracos(0, 0), s0).
h(chao('D'), S).
h(topo('A'), S).

% consequencias positivas

h(bracos(Bloco, Bloco), r(agarraG(Bloco), S)):-
	h(topo(Bloco), S),
	grande(Bloco),
	h(bracos(0, 0), S).

h(bracos(Bloco, 0), r(agarraP(Bloco), S)):-
	h(topo(Bloco), S),
	pequeno(Bloco),
	h(bracos(0, 0), S).

h(bracos(Bloco1, Bloco2), r(agarraP(Bloco2), S)):-
	h(topo(Bloco2), S),
	pequeno(Bloco1),
	pequeno(Bloco2),
	h(bracos(Bloco1, 0), S).

h(sobre((Bloco1), (Bloco2, Bloco3)), topo(Bloco1), r(colocarSobre((Bloco1), (Bloco2, Bloco3), S)):-
	h(topo(Bloco2), S),
	h(topo(Bloco3), S),
	grande(Bloco1),
	pequeno(Bloco2),
	pequeno(Bloco3).

h(sobre((Bloco2, Bloco3), (Bloco1)), topo((Bloco2, Bloco3)), r(colocarSobre(((Bloco2, Bloco3), Bloco1), S)):-
	h(topo(Bloco1), S),
	grande(Bloco1),
	pequeno(Bloco2),
	pequeno(Bloco3).

h(chao(Bloco), r(colocaChao(Bloco1), S)):-
	bracos(Bloco, Bloco),
	grande(Bloco).

h(chao(Bloco1, Bloco2), r(colocaChao(Bloco1, Bloco2), S)):-
	bracos(Bloco1, Bloco2),
	pequeno(Bloco1),
	pequeno(Bloco2).

% consequencias de inercia

h(chao(Bloco), r(Accao, S)):-
	h(chao(Bloco), S),
	(Accao \= agarraP(Bloco) ; Accao \= agarraG(Bloco)).

h(sobre((Bloco2, Bloco3), (Bloco1)), r(Accao, S)):-
	h(sobre((Bloco2, Bloco3), (Bloco1)),S),
	Accao \= r(agarraP(Bloco2).

h(sobre((Bloco1), (Bloco2, Bloco3)), r(Accao, S)):-

h(topo(Bloco1), r(Accao, S)):-
	h(topo(Bloco1, S)),
	(Accao \= (agarraP(Bloco1); Accao \= agarraG(Bloco1))