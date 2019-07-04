jogos:-esc.


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


%main esc
esc:-
	nl,
	write('Jogo do galo: '),nl,
	write('    1 - Jogar contra o Computador (minimax)'),
	nl,nl,
	%write('    2 - PC contra PC (minimax vs alfabeta)'),
	%nl,nl,
	write('Jogo do 4 em linha: '),nl,
	write('    2 - Jogar contra o Computador (alfabeta)'),
	nl,nl,
	%write('    4 - PC contra PC (minimax vs alfabeta)'),
	%nl,nl,
	write('3 - Sair do Programa'),
	nl,nl,
	write('Insira um numero de acordo com o que pretende fazer: '),
	read(X),
	escOpt(X).

escOpt(1):-
	[minimax],
	%[alfabeta_v2],	
	[galo],
	initInc,  %inicia a incrementação dos nos	
	initProf,
	%limitar_profundidade(15),
	nl,
	write('Primeiro a jogar: Jogador ou Computador (j ou c)? '),
	read(Jogador),
	nl,
	write('O Jogador fica com as cruzes - x'),
	nl,
	estado_inicial(Ei),nl,
	startCycle(Jogador,x,Ei),nl,
	write('Deseja sair (s) ou voltar ao esc (m)? '),
	read(X),
	opcao(X).
	
escOpt(2):-
	%[minimax_cut],
	[alfabeta],
	[quatroEmLinha],
	initInc,	
	initProf,
	limitar_profundidade(20),
	nl,
	write('Primeiro a jogar: Jogador ou Computador (j ou c)? '),
	read(Jogador),
	nl,
	write('O Jogador fica com as cruzes - x'),
	nl, 
	estado_inicial(Ei),nl,
	startCycle(Jogador,x,Ei),nl,
	write('Deseja sair (s) ou voltar ao esc (m)? '),
	read(X),
	opcao(X).


%predicado de saida do esc
escOpt(3).

%casos em que nao e inserido um dos numeros desejados
escOpt(_):-
	nl,
	esc.

opcao('s'):- escOpt(3).
opcao('m'):- nl,esc.
opcao(_):-
	nl,
	esc.

startCycle('c', S, (E,P)):-
	P = S,
	ciclo_jogada('c', (E,P)).

startCycle('j', S, (E,P)):-
	inverteJog(S,P1),
	P = P1,	
	ciclo_jogada('j', (E,P)).
