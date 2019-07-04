%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
dominio([1,2,3,4,5,6,7,8,9]).

tamanho_tabuleiro(3). 

estado_inicial( e([v(n(1,1),D,_Val),
           v(n(1,2),D,_Val),
           v(n(1,3),D,_Val),
           v(n(2,1),D,_Val),
           v(n(2,2),D,_Val),
           v(n(2,3),D,_Val),
           v(n(3,1),D,_Val),
           v(n(3,2),D,_Val),
           v(n(3,3),D,_Val)],[]) ):- dominio(D).
 
 %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
 
%Verifica se todos os elementos no quadrado sao diferentes e valida as somas
restricoes(e(NAfect,Afect)):- all_diff(Afect), valida_somas(Afect).
 
 
all_diff([]).
all_diff([v(_,_,V)|Afect]):- member(v(_,_,V),Afect),!,fail.
all_diff([_|Afect]):- all_diff(Afect).
 
%quadrado magico soma linhas colunas e diagonais iguais.
valida_somas(L):- % linhas 
                  findall(V,member(v(n(1,_),_,V), L),L1), sum_total(L1),
                  findall(V,member(v(n(2,_),_,V), L),L2), sum_total(L2),
                  findall(V,member(v(n(3,_),_,V), L),L3), sum_total(L3),

                  %colunas
                  findall(V,member(v(n(_,1),_,V), L),C1), sum_total(C1),
                  findall(V,member(v(n(_,2),_,V), L),C2), sum_total(C2),
                  findall(V,member(v(n(_,3),_,V), L),C3), sum_total(C3),
                  
                  % diagonal X = y 
                  findall(V,member(v(n(1,1),_,V),L),D1),
                  findall(V,member(v(n(2,2),_,V), L),D2),
                  findall(V,member(v(n(3,3),_,V), L),D3),append(D1,D2,M),append(M,D3,X),sum_total(X),

                  % diagonal
                  findall(V,member(v(n(0,2),_,V),L),D4),
                  findall(V,member(v(n(1,1),_,V), L),D5),
                  findall(V,member(v(n(2,0),_,V), L),D6),append(D4,D5,P),append(P,D6,J),sum_total(J).
 
sum_total( [V1,V2,V3] ):-!, 15 is  V1+V2+V3.

sum_total(_).                              

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%% escreve
%esc(_).
esc(L):-sort(L, L1), esc_a(L1),nl.

esc_a(L):- tamanho_tabuleiro(S), esc_l(L, 1, S).

esc_l([H], S, S):- H = v(_,_,X), write(X),nl.

esc_l([H|T], S, S):- H = v(_,_,X), write(X), nl,esc_l(T, 1, S).

esc_l([H|T], I, S):- I<S, I2 is I+1,
                    H = v(_,_,X), write(X),write(' . '),
                     esc_l(T, I2, S).
