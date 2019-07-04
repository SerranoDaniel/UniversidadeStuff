homem('Afonso Henriques','rei de Portugal',1109).
homem('Henrique de Borgonha','conde de Portugal',1069).

homem('Sancho I','rei de Portugal',1154).
homem('Fernando II','rei de Le�o',1137).
homem('Afonso IX', 'rei de Le�o e Castela', 1171).
homem('Afonso II', 'rei de Portugal',1185).

homem('Sancho II', 'rei de Portugal',1207).
homem('Afonso III', 'rei de Portugal',1210).


mulher('Teresa de Castela', 'condessa de Portugal', 1080).
mulher('Mafalda', 'condessa de Saboia', 1125).
mulher('Urraca', 'infanta de Portugal',1151).
mulher('Dulce de Barcelona','infanta de Aragão',1160).
mulher('Berengária', 'infanta de Portugal',1194).
mulher('Urraca C','infanta de Castela',1186).


filho('Afonso Henriques','Henrique de Borgonha').
filho('Afonso Henriques','Teresa de Castela').
filho('Urraca','Afonso Henriques').
filho('Urraca','Mafalda').
filho('Sancho I','Afonso Henriques').
filho('Sancho I','Mafalda').
filho('Afonso IX','Urraca').
filho('Afonso IX','Fernando II').
filho('Afonso II','Sancho I').
filho('Afonso II','Dulce de Barcelona').
filho('Berengária','Sancho I').
filho('Berengária','Dulce de Barcelona').
filho('Sancho II','Afonso II').
filho('Afonso III','Afonso II').
filho('Sancho II','Urraca C').
filho('Afonso III','Urraca C').

irmao(X,Y):-
	filho(X,Z),
	filho(Y,Z),
	X \= Y.


primoDireito(X,Y):-
	filho(X,Z),
	irmao(Z,W),
	filho(Y,W).

irmaos(X,Y):-
	setof(Z, X ^ irmao(X,Z), Y).


primos(X,Y):-
	setof(Z, X ^ primoDireito(X,Z), K), %primos direitos
	setof(Z, (member(J,K), filho(Z,J)), K1), %filhos dos primos direitos




