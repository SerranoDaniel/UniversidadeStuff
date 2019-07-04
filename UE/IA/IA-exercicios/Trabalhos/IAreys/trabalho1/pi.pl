%Descricao do problema:

%estado_inicial(Estado)
%estado_final(Estado)

%representacao dos operadores
%op(Eact,OP,Eseg,Custo)

%representacao dos nos
%no(Estado,no_pai,Operador,Custo,H+C,Profundidade)
:-dynamic(estadosVisitados/1).
estadosVisitados([]).
insereEstadosVisitados(E):-
  estadosVisitados(Lista),
  append([E], Lista, LAux),
  flatten(LAux, LFinal),
  retractall(estadosVisitados(_)),
  Novo =.. [estadosVisitados, LFinal],
  asserta(Novo).

%flatten(Xs, Ys):- flattendl(Xs, Ys-[]).

%flattendl([X|Xs], Ys-Zs):-
  %flattendl(X, Ys-Ys1),
  %flattendl(Xs, Ys1-Zs).

%flattendl(X, [X|Xs]-Xs ):-
  %atomic(X),
  %X \== [].

%flattendl([], Xs-Xs).

pesquisa(Problema,Alg):-
  consult(Problema),
  estado_inicial(S0),
  pesquisa(Alg,[no(S0,[],[],0,1,0)],Solucao),
  escreve_seq_solucao(Solucao),
  retractall(estadosVisitados(_)),
  Novo =.. [estadosVisitados, []],
  asserta(Novo).


  pesquisa(a,E,S):- pesquisa_a(E,S).

%pesquisa_a([],_):- !,fail.
pesquisa_a([no(E,Pai,Op,C,HC,P)|_],no(E,Pai,Op,C,HC,P)):- estado_final(E).

pesquisa_a([no(c(E, L),Pai,Op,C,HC,P)|R],Sol):- estadosVisitados(X),
                        \+ member(E, X),
                        insereEstadosVisitados(E),
                        expande(no(c(E, L),Pai,Op,C,HC,P),Lseg),
                        insere_ord(Lseg,R,Resto),
                        esc(Resto),
                        pesquisa_a(Resto,Sol),!.

pesquisa_a([_|R],Sol):- pesquisa_a(R,Sol),!.

expande(no(E,Pai,Op,C,HC,P),L):- findall(no(En,no(E,Pai,Op,C,HC,P),Opn,Cnn,HCnn,P1),
                                        (op(E,Opn,En,Cn),P1 is P+1, Cnn is Cn+C, h(En,H), 
                                        HCnn is Cnn+H), L).


insere_ord([],L,L).
insere_ord([no(E,Pai,Op,C,HC,P)|L],L1,L2):- insereE_ord(no(E,Pai,Op,C,HC,P),L1,L3), 
                                            insere_ord(L,L3,L2).

insereE_ord(A,[],[A]).
insereE_ord(A,[A1|L],[A,A1|L]):- menor_no(A,A1),!.
insereE_ord(A,[A1|L], [A1|R]):-  insereE_ord(A,L,R).

menor_no(no(_,_,_,_,N,_), no(_,_,_,_,N1,_)):- N < N1.

escreve_seq_solucao(no(E,Pai,Op,Custo,_HC,Prof)):- write(custo(Custo)),nl,
                                          write(profundidade(Prof)),nl,
                                          estadosVisitados(Lista),
                                          length(Lista, Size),
                                          write(Size),nl,
                                          escreve_seq_accoes(no(E,Pai,Op,_,_,_)).


escreve_seq_accoes([]).
escreve_seq_accoes(no(E,Pai,Op,_,_,_)):- escreve_seq_accoes(Pai),
                                              write(e(Op,E)),nl.

esc([E|_]):- estadosVisitados(X), write(X), nl, nl.