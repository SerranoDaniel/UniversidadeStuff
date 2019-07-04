:-dynamic(h/2).



% blocos

grande(a).
grande(d).
pequeno(c).
pequeno(b).

% estado inicial

h(dir([]),S0).
h(esq([]),S0).
h(cima(d,a),S0).
h(cima(c,b),S0).
h(livre(c),S0).
h(livre(d),S0).
h(no_chao(a),S0).
h(no_chao(b),S0).

% consequencias
pgc(D):- no_chao(D),livre(D),esq([]),dir([]).
ppc(D,D1) :- esq([]),dir([]),no_chao(D1),livre(D),
	cima(D,D1),pequeno(D),pequeno(D1),
	D \= D1.

pgg(D,D1):- esq([]), dir([]), cima(D,D1), livre(D).

tgc(D):- esq(D),dir(D).

tgg(D):- esq(D),dir(D),livre(D1).


% tirar pequeno do chao e coloca no braço bracoDir
h(dir(D),r(tirar_p(D),S)):-
	h(dir([]),S),h(no_chao(D),S),h(livre(D),S),pequeno(D).


% tirar pequeno do chao e coloca no braço bracoEsq
h(esq(D),r(tirar_p(D),S)):-
	h(esq([]),S),h(no_chao(D),S),h(livre(D),S),pequeno(D).


% tirar pequeno de outro pequeno usando braço dir
h(dir(D),r(tirar_p(D),S)):-
	h(dir([]),S),
	h(cima(D,D1),S),
	h(livre(D),S),
	pequeno(D),pequeno(D1),D \= D1.

% tirar pequeno de outro pequeno usando braço esq
h(esq(D),r(tirar_p(D),S)):-
	h(esq([]),S),
	h(cima(D,D1),S),
	h(livre(D),S),
	pequeno(D),pequeno(D1), D1 \= D.


% tirar grande do chao usando os dois braços
h(tgc(D),r(tirar_Grande_do_chao(D),S)):-
	h(esq([]),S),
	h(dir([]),S),
	h(no_chao(D),S),
	h(livre(D),S),
	grande(D).


% tirar grande cima de outro grande usando os dois braços
h(tgg(D),r(tirar_Grande_de_Grande(D),S)):-
	h(esq([]),S),
	h(dir([]),S),
	h(cima(D,D1),S),
	h(livre(D),S),
	grande(D),
	grande(D1),
	D \= D1.


% por grande no chao usando os dois braços
h(pgc(D),r(por_Grande_no_Chao(D),S)):-
	h(esq(D),S),
	h(dir(D),S),
	grande(D).


% por um pequeno no chao e outro em cima do outro pequeno
% usando os blocos que estao nos braços
h(ppc(D,D1),r(por_pequenos_no_chao(D,D1),S)):-
	h(esq(D),S),
	h(dir(D1),S)
	pequeno(D),
	pequeno(D1),
	D \= D1.

% por grande em cima de outro grande
h(pgg(D,D1),r(por_grande_em_grande(D,D1),S)):-
	h(esq(D),S),
	h(dir(D),S),
	h(livre(D1),S),
	grande(D),
	grande(D1),
	D \= D1.


% inercia

h(esq(D),r(D1,S)):-
	h(esq(D),S),
	D1 \= tirar_p(D).

h(dir(D),r(D1,S)):-
	h(dir(D),S),
	D1 \= tirar_p(D).

h(dir(D),esq(D),r(D1,S)):-
	h(esq(D),dir(D),S),
	D1 \= tirar_Grande_do_chao(D),
	D1 \= tirar_Grande_de_Grande(D).


h(esq([]), dir([]), r(D1, S)) :-
	h(esq([]), S),
	h(dir([]), S),
	X \= por_grande_em_grande(D,A),
	X \= por_Grande_no_Chao(D).

h(esq(D),dir(D1),r(D2,S)):-
	h(esq(D),S),
	h(dir(D1),S),
	X \= por_pequenos_no_chao(D,D1).

% estado final

:-h(bracoEsq([]),S),
	h(bracoDir([]),S),
	h(no_chao(d),S),
	h(no_chao(c),S),
	h(cima(a,d),S),
	h(cima(b,c),S),
	h(livre(a),S),
	h(livre(b),S).


S =
	r(por_pequenos_no_chao(c,b),
	r(tirar_p(c),
	r(tirar_p(c),
	r(por_grande_em_grande(a,d),
	r(tirar_Grande_do_chao(a), 
	r(por_Grande_no_Chao(d),
	r(tirar_Grande_de_Grande(d),S0))))))).

