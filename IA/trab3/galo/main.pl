%inicia a contagem de nos
initInc:-
	retractall(n(_)),
	assertz(n(0)),!.

%incrementa o contador mais N
incMais(N):-
	retract(n(M)),
	M1 is N+M,
	assertz(n(M1)),!.

%no caso em que queremos limitar a profundidade
limitar_profundidade(0):-
	retractall(prof(_)), 
	assertz(prof(100)),!.
	
limitar_profundidade(X):-
	retractall(prof(_)), 
	assertz(prof(X)),!.

%incrementa a profundidade
incProf:-
	p(P),
	P1 is P + 1,
	retract(p(_)), 
	assertz(p(P1)).
	
%inicializa a contagem da profundidade
initProf:-
	retractall(p(_)),
	assertz(p(1)),!.


initParImpar:-
	retractall(parImpar(_)),
	asserta(parImpar(2)),!.

main:-
    write('Escolha Modo: '),nl,
    write('1. Homem vs CPU'),nl,
    write('2. Homem vs Homem '),nl,
    write(': '), read(Op),
	escolha(Op).

escolha(1):-
	[minimax],
	[galo],
	initInc,  %inicia a incrementação dos nos	
	initProf,
	write('Jogador Principal [x]'),nl,
	estado_inicial((E,P)),nl,	
	play('h', (E,'o')),
	main.

escolha(2):-