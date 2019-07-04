%Descricao do problema:

%estado_inicial(Estado)
%estado_final(Estado)

%representacao dos operadores
%op(Eact,OP,Eseg,Custo)

%representacao dos nos
%no(Estado,no_pai,OperadorCusto,Profundidade)

:-dynamic(conta/1).

conta(0).

incC(_):-
  conta(X),
  retractall(conta(_)),
  Y is X+1,
  NovoC =.. [conta,Y],
  asserta(NovoC).

pesquisa(Problema,Alg):-
  consult(Problema),
  estado_inicial(S0),
  pesquisa(Alg,[no(S0,[],[],0,0)],Solucao),
  escreve_seq_solucao(Solucao).

pesquisa(largura,Ln,Sol):- pesquisa_largura(Ln,Sol).

pesquisa_largura([no(E,Pai,Op,C,P)|_],no(E,Pai,Op,C,P)):- estado_final(E), incC(_).
pesquisa_largura([E|R],Sol):- expande(E,Lseg), esc(E),
insere_fim(Lseg,R,Resto),
incC(_),
pesquisa_largura(Resto,Sol).

expande(no(E,Pai,Op,C,P),L):- findall(no(En,no(E,Pai,Op,C,P),Opn,Cnn,P1),
  (op(E,Opn,En,Cn),P1 is P+1, Cnn is Cn+C),L).

insere_fim([],L,L).
insere_fim(L,[],L).
  insere_fim(R,[A|S],[A|L]):- insere_fim(R,S,L).

escreve_seq_solucao(no(E,Pai,Op,Custo,Prof)):- write(custo(Custo)),nl,
  write(profundidade(Prof)),nl,
  conta(X),
  write(nos(X)),
  retractall(conta(_)),nl,
  escreve_seq_accoes(no(E,Pai,Op,_,_)).

escreve_seq_accoes([]).
  escreve_seq_accoes(no(E,Pai,Op,_,_)):- escreve_seq_accoes(Pai),
  write(e(Op,E)),nl.

esc(A):- write(A), nl.


%---------------------  pesquisa informada

pesquisai(Problema,Alg):-
  consult(Problema),
  estado_inicial(S0),
  pesquisa(Alg,[no(S0,[],[],0,1,0)],Solucao),
  escreve_seq_solucaoi(Solucao).

pesquisa(a,E,S):- pesquisa_a(E,S).

pesquisa_a([no(E,Pai,Op,C,HC,P)|_],no(E,Pai,Op,C,HC,P)):- estado_final(E), incC(_).

pesquisa_a([E|R],Sol):- expande_a(E,Lseg), incC(_), esc(E),
  insere_ord(Lseg,R,Resto),
  pesquisa_a(Resto,Sol).

expande_a(no(E,Pai,Op,C,HC,P),L):- findall(no(En,
  no(E,Pai,Op,C,HC,P),Opn,Cnn,HCnn,P1),
  (op(E,Opn,En,Cn),P1 is P+1, Cnn is Cn+C, h1(En,H),
  HCnn is Cnn+H), L).

insere_ord([],L,L).
insere_ord([A|L],L1,L2):- insereE_ord(A,L1,L3), insere_ord(L,L3,L2).

insereE_ord(A,[],[A]).
insereE_ord(A,[A1|L],[A,A1|L]):- menor_no(A,A1),!.
insereE_ord(A,[A1|L], [A1|R]):- insereE_ord(A,L,R).

menor_no(no(_,_,_,_,N,_), no(_,_,_,_,N1,_)):- N < N1.

escreve_seq_solucaoi(no(E,Pai,Op,Custo,_HC,Prof)):- write(custo(Custo)),nl,
  write(profundidade(Prof)),nl,
  conta(X), write(nos(X)),nl,retractall(conta(_)),
  escreve_seq_accoesi(no(E,Pai,Op,_,_,_)).


escreve_seq_accoesi([]).
escreve_seq_accoesi(no(E,Pai,Op,_,_,_)):- escreve_seq_accoesi(Pai),
  write(e(Op,E)),nl.
