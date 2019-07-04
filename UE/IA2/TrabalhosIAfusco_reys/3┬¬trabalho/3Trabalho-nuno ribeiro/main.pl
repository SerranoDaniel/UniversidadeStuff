main:-
	write('Jogar - 1'),nl,
	write('sair - 2'),nl,
	write('Escolha:'),
	read(Input),
	main2(Input).

initInc:-
	retractall(n(_)),
	assertz(n(0)),!.

	incMais(N):-
	retract(n(M)),
	M1 is N+M,
	assertz(n(M1)),!.

main2(1):-
	[minimanx],[traba1],
	initInc,
	estado_inicial(Ei),
	startCycle('j',Ei),nl,
	write('voltar a Jogar - 1'),nl,
	write('sair - 2'),nl,
	write('Escolha:'),
	read(X),
	main2(X).

main2(2):-
	write('gg afk, fucking retard, cyka blyat'),!.

startCycle('j', (E,P)):-
	P = P1,	
	ciclo_jogada(j, (E,P)).

ciclo_jogada(_,(E,J)):- (linha(E,Linha,Q);coluna(E,Colu,Q);diag_Esquerda(E,Q);diag_Direita(E,Q)), print_(E),write('Vencedor: '),write(Q),!.
ciclo_jogada(_,(E,J)):- empate(E), print_(E),write('Empate!'),nl,!.

ciclo_jogada(c,(E,J)):-
	print_(E),
	%nl,statistics(real_time,[Ti,_]),
	minimax_decidir((E,J),Op),
	%statistics(real_time,[Tf,_]), T is Tf-Ti,
	nl, 
	%write('Tempo: '(T)),	
	nl,
	%write(Op),
	nl,
	n(N),
	write(N),
	initInc,
	nl,
	op1((E,J),Op,Es),
	ciclo_jogada(j,Es).

ciclo_jogada(j,(E,J)):-	
	print_(E),
	nl,
	write('Escreva a linha da posicao onde deseja jogar: '),
	read(X),
	write('Escreva a coluna da posicao onde deseja jogar: '),
	read(Y),
	nl,
	insere_posicao(X,Y,x,E,Es),
	nl,
	ciclo_jogada(c,(Es,x)).