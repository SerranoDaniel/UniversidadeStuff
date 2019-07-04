% representacao de um estado e uma lista de listas com representacao de um tabuleiro de 8x8 e com menos pecas que o jogo original
% jogo de damas "simplificado", em que uma peca so pode comer uma outra de cada vez e nao ha damas, mas as pecas podem jogar para baixo
% b -> peca branca, p -> peca preta
% Jogadores -> pretas ou brancas;
% estado(PECA_A_JOGAR,[pos1_1,pos2_1,...,pos1_2,pos2_2,...],NUM_PECAS_BRANCAS,NUM_PECAS_PRETAS)
% uma posicao define-se com: pos(PECA,COLUNA,LINHA)

% estado inicial para minimax e para minimax com corte em profundidade

estado_inicial1(e(p,[pos(p,1,1),pos(b,2,2)],1,1)).
estado_inicial2(e(p,[pos(p,1,1),pos(p,1,7),pos(b,2,2),pos(b,8,8)],2,2)).
estado_inicial3(e(p,[pos(p,1,1),pos(b,2,2),pos(p,3,3)],1,2)).


% terminal, que ocorre quando um dos jogadores ganhou ou quando houver um empate

terminal(e(_,_,NB,NP)):- ganhou(NB,NP).
terminal(e(P,TAB,NB,NP)):- empate(P,TAB,NB,NP).

ganhou(_,0).
ganhou(0,_).

% empate ocorre quando nenhum dos jogadores pode jogar

empate(P,TAB,NB,NP):- NB>0, NP>0, \+joga(P,TAB,TAB,_,NB,_,NP,_), muda_jogador(P,NP),\+joga(NP,TAB,TAB,_,NB,_,NP,_).

% funcao de utilidade, cujo valor e 20 para quando ganha o MAX, -20 para quando ganha o MIN e 0 para empate

valor(e(P,TAB,NB,NP),0,_):- empate(P,TAB,NB,NP).
valor(e(_,_,_,_),20,PR):- \+e_par(PR).
valor(e(_,_,_,_),-20,PR):- e_par(PR).

% funcao de avaliacao, cujo valor e 10 quando o numero de pecas de MAX e maior que o de MIN e -10 quando acontece o contrario
 
favaliacao(e(_,_,NB,NP),10):- max(p), NP>NB.
favaliacao(e(_,_,NB,NP),-10):- max(p), NB>NP.
favaliacao(e(_,_,NB,NP),10):- max(b), NB>NP.
favaliacao(e(_,_,NB,NP),-10):- max(b), NP>NB.
favaliacao(e(_,_,N,N),0).

e_par(X):- Y is X 'mod' 2, Y=0.

% mudanca de estado: mudanca de tabuleiro e mudanca de jogador
% op1(estado,jogada,estado seguinte)

op1(e(P,TAB,NB,NP),jogada(e(NPECA,NTAB,NNB,NNP)),e(NPECA,NTAB,NNB,NNP)):- muda_jogador(P,NPECA), joga(P,TAB,TAB,NTAB,NB,NNB,NP,NNP).

muda_jogador(b,p).
muda_jogador(p,b).


% para cada peca, fazer uma jogada

joga(P,TAB,[pos(P,L,C)|_],NTAB,NB,NNB,NP,NNP):- jg(P,L,C,TAB,NTAB,NB,NNB,NP,NNP).
joga(P,TAB,[pos(P,_,_)|T],NTAB,NB,NNB,NP,NNP):- joga(P,TAB,T,NTAB,NB,NNB,NP,NNP).
joga(P1,TAB,[pos(P2,_,_)|T],NTAB,NB,NNB,NP,NNP):- P1\=P2, joga(P1,TAB,T,NTAB,NB,NNB,NP,NNP).

% para cada diagonal, tentar jogada

jg(P,L,C,TAB,NTAB,NB,NNB,NP,NNP):- X is L-1, Y is C-1, jog(P,L,C,TAB,NTAB,NB,NNB,NP,NNP,X,Y).
jg(P,L,C,TAB,NTAB,NB,NNB,NP,NNP):- X is L-1, Y is C+1, jog(P,L,C,TAB,NTAB,NB,NNB,NP,NNP,X,Y).
jg(P,L,C,TAB,NTAB,NB,NNB,NP,NNP):- X is L+1, Y is C-1, jog(P,L,C,TAB,NTAB,NB,NNB,NP,NNP,X,Y).
jg(P,L,C,TAB,NTAB,NB,NNB,NP,NNP):- X is L+1, Y is C+1, jog(P,L,C,TAB,NTAB,NB,NNB,NP,NNP,X,Y).

% verifica se a posicao e valida e em caso afirmativo tenta jogada

jog(P,L,C,TAB,NTAB,NB,NNB,NP,NNP,X,Y):- e_valido(X,Y), \+member(pos(_,X,Y),TAB), retirar_peca(L,C,TAB,NTABT), coloca_posicao_certa_vazio(P,L,C,NTABT,NTAB,NB,NNB,NP,NNP,X,Y),!.
jog(P,L,C,TAB,NTAB,NB,NNB,NP,NNP,X,Y):- e_valido(X,Y), member(pos(_,X,Y),TAB), retirar_peca(L,C,TAB,NTABT), coloca_posicao_certa(P,L,C,NTABT,NTABT,NTAB,NB,NNB,NP,NNP,X,Y),!.

e_valido(X,Y):- X>0, X<9, Y>0, Y<9.

% caso de ter uma peca da mesma cor no caminho -> fail

% caso de ter uma peca de outra cor no caminho, ver se existe uma outra peca nessa diagonal, se nao existir, fazer jogada para comer peca

coloca_posicao_certa(P1,L,C,TAB,TAB,NTAB,NB,NNB,NP,NNP,X,Y):- member(pos(P2,X,Y),TAB),P1\=P2, ve_posicao_secundaria(L,C,X,Y,A,B), e_valido(A,B), faz_jogada_come(P1,X,Y,A,B,TAB,NTAB,NB,NNB,NP,NNP).

e_diferente(A,B,A,Y):- B\=Y.
e_diferente(A,B,X,B):- A\=X.
e_diferente(A,B,X,Y):- A\=X,B\=Y.

% caso em que a casa esta vazia

coloca_posicao_certa_vazio(P1,_,_,[],[pos(P1,X,Y)],NB,NB,NP,NP,X,Y).
coloca_posicao_certa_vazio(P1,_,_,[pos(P2,L2,C2)|T],[pos(P1,X,Y),pos(P2,L2,C2)|T],NB,NB,NP,NP,X,Y):- L2>X,!.
coloca_posicao_certa_vazio(P1,_,_,[pos(P2,X,C2)|T],[pos(P1,X,Y),pos(P2,X,C2)|T],NB,NB,NP,NP,X,Y):- C2>Y,!.
coloca_posicao_certa_vazio(P1,L,C,[pos(P2,L2,C2)|T],[pos(P2,L2,C2)|R],NB,NNB,NP,NNP,X,Y):- L2<X,coloca_posicao_certa_vazio(P1,L,C,T,R,NB,NNB,NP,NNP,X,Y),!.
coloca_posicao_certa_vazio(P1,L,C,[pos(P2,X,C2)|T],[pos(P2,X,C2)|R],NB,NNB,NP,NNP,X,Y):- C2<Y,coloca_posicao_certa_vazio(P1,L,C,T,R,NB,NNB,NP,NNP,X,Y),!.


ve_posicao_secundaria(L,C,X,Y,A,B):- X is L-1, Y is C-1, A is X-1, B is Y-1.
ve_posicao_secundaria(L,C,X,Y,A,B):- X is L-1, Y is C+1, A is X-1, B is Y+1.
ve_posicao_secundaria(L,C,X,Y,A,B):- X is L+1, Y is C-1, A is X+1, B is Y-1.
ve_posicao_secundaria(L,C,X,Y,A,B):- X is L+1, Y is C+1, A is X+1, B is Y+1.

faz_jogada_come(P,X,Y,A,B,TAB,NTAB,NB,NNB,NP,NNP):- \+member(pos(_,A,B),TAB), actualiza_num_pecas(P,NB,NNB,NP,NNP),
						    retirar_peca(X,Y,TAB,NTABT),
						    colocar_nova_peca(P,A,B,NTABT,NTAB).

% retirar uma peca do tabuleiro

retirar_peca(X,Y,[pos(_,X,Y)|T],T).
retirar_peca(X,Y,[pos(P,A,B)|T],[pos(P,A,B)|R]):- e_diferente(A,B,X,Y), retirar_peca(X,Y,T,R).

% colocar uma nova peca no tabuleiro

colocar_nova_peca(P,A,B,[],[pos(P,A,B)]).
colocar_nova_peca(P,A,B,[pos(PT,X,Y)|T],[pos(P,A,B),pos(PT,X,Y)|T]):- X>A.
colocar_nova_peca(P,A,B,[pos(PT,_,Y)|T],[pos(P,A,B),pos(PT,A,Y)|T]):- Y>B.
colocar_nova_peca(P,A,B,[pos(PT,X,Y)|T],[pos(PT,X,Y)|R]):- X<A, colocar_nova_peca(P,A,B,T,R).
colocar_nova_peca(P,A,B,[pos(PT,A,Y)|T],[pos(PT,A,Y)|R]):- Y<B, colocar_nova_peca(P,A,B,T,R).

actualiza_num_pecas(p,NB,NNB,NP,NP):- NNB is NB-1.
actualiza_num_pecas(b,NB,NB,NP,NNP):- NNP is NP-1.
