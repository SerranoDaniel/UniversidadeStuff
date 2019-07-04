diagonal(c(1,1),[c(2,2),c(3,3)]).
diagonal(c(2,2),[c(1,1),c(3,3), c(1,3), c(3,1)]).
diagonal(c(3,3),[c(1,1),c(2,2)]).
diagonal(c(1,3),[c(2,2),c(3,1)]).
diagonal(c(3,1),[c(2,2),c(1,3)]).

diagonal(c(1,2),[]).
diagonal(c(2,1),[]).
diagonal(c(3,2),[]).
diagonal(c(2,3),[]).


p(Prg):- consult(Prg),estado_inicial(E0),back(E0,A), esc(A).

back(e([],A),A).
back(E,Sol):- sucessor(E,E1), ve_restricoes(E1),
back(E1,Sol).

sucessor(e([v(N,D,V)|R],E),e(R1,[v(N,D,V)|E])):- member(V,D), remove(N,V,R,R1).

remove(c(I,J),V,R,R3):-
  linha(I,V,R,R1),
  coluna(J,V,R1,R2),
  diagonais(c(I,J),V,R2,R3).

linha(_,_,[],[]).
linha(Linha,Valor,[v(c(Linha,Col),D,_)|R],[v(c(Linha,Col),D2,_)|R1]):-
  removeLista(Valor,D,D2),
  linha(Linha,Valor,R,R1),!.

linha(Linha,Valor,[I|R],[I|R1]):-
  linha(Linha,Valor,R,R1),!.

coluna(_,_,[],[]).
coluna(Col,Valor,[v(c(Linha,Col),D,_)|R],[v(c(Linha,Col),D2,_)|R1]):-
  removeLista(Valor,D,D2),
  coluna(Col,Valor,R,R1),!.

coluna(Col,Valor,[I|R],[I|R1]):-
  coluna(Col,Valor,R,R1),!.

diagonais(N,V,R,R1):-
  diagonal(N,Lista),
  removeDiagonais(Lista,V,R,R1).

removeDiagonais([],_,R,R).

removeDiagonais([N|L],V,R,R2):-
  member(v(N,_,_),R),
  findRemove(v(N,_,_),V,R,R1),
  removeDiagonais(L,V,R1,R2).

removeDiagonais([N|L],V,R,R1):-
  \+ member(v(N,_,_),R),
  removeDiagonais(L,V,R,R1).

findRemove(v(N,_,_),V,[v(N,D,L)|R],[v(N,D2,L)|R]):-
  removeLista(V,D,D2),!.

findRemove(v(N,_,_),V,[I|R],[I|R1]):-
  findRemove(v(N,_,_),V,R,R1).

removeLista(_,[],[]):-!.
removeLista(Valor,[Valor|R],R):-!.
removeLista(Valor,[X|R],[X|R1]):-
  removeLista(Valor,R,R1).
