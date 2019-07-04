demo:- [damas],[minimax], [minimaxcut], menu.

menu:- repeat, nl,nl,write('Escolha a opcao'),nl,write('1 - Minimax para o estado inicial e(p,[pos(p,1,1),pos(b,2,2)],1,1).'),nl,
	write('2 - Minimax com corte em profundidade de 2 para o estado inicial e(p,[pos(p,1,1),pos(b,2,2)],1,1).'),nl,
	write('3 - Jogo utilizando o Minimax com corte em profundidade de 2 para o estado inicial e(p,[pos(p,1,1),pos(p,1,7),pos(b,2,2),pos(b,8,8)],2,2) e em que o MAX e a peca preta.'),nl,write('4 - Jogo utilizando o Minimax com corte em profundidade de 2 para o estado e(p,[pos(p,1,1),pos(b,2,2),pos(p,3,3)],1,2) e em que o MAX e a peca preta.'),nl,write('5 - Sair.'),nl,read(OPC),executa_opcao(OPC),fail.

executa_opcao(1):- go(damas),!.
executa_opcao(2):- assertz(prof_limite(2)),assertz(max(p)),go_cut(damas),!.
executa_opcao(3):- estado_inicial2(Ei), escreve_tabuleiro(Ei), jogar(Ei),!.
executa_opcao(4):- estado_inicial3(Ei), escreve_tabuleiro(Ei), jogar(Ei),!.
executa_opcao(5):- halt.

jogar(Ei):- assertz(prof_limite(2)), assertz(max(p)), minimaxcut_decidir(Ei,P), ve_estado(P,ET), escreve_tabuleiro(ET),diz_proximo_passo(ET).

diz_proximo_passo(ET):- \+terminal(ET), write(ET), nl, jogar(ET).
diz_proximo_passo(ET):- terminal(ET), write('jogo terminado: '), write(ET).

ve_estado(jogada(ET),ET).

escreve_tabuleiro(e(P,TAB,NB,NP)):- write('Vez do jogador '), write(P), nl, escreve_tab(TAB,1,1,8,8), nl,write('NB: '), 
					write(NB), write('NP: '), write(NP),nl.

escreve_tab(TAB,8,8,_,_):- \+member(pos(_,8,8),TAB),!, write(' v ').
escreve_tab(TAB,8,8,_,_):- member(pos(P,8,8),TAB),!, write(' '), write(P), write(' ').
escreve_tab(TAB,Li,Ci,Lf,Cf):- \+member(pos(_,Li,Ci),TAB),!, write(' v '), proxima_pos(Li,Ci,L,C),escreve_tab(TAB,L,C,Lf,Cf).
escreve_tab(TAB,Li,Ci,Lf,Cf):- member(pos(P,Li,Ci),TAB),!, write(' '), write(P), write(' '), proxima_pos(Li,Ci,L,C), escreve_tab(TAB,L,C,Lf,Cf).

proxima_pos(Li,Ci,Li,C):- Ci\=8, C is Ci+1.
proxima_pos(Li,8,L,1):- Li\=8, L is Li+1,nl.

