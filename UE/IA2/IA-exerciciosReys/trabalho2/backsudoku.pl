%quadrado1
diagonal(c(1,1),[c(2,2),c(3,3)]).
diagonal(c(2,2),[c(1,1),c(3,3), c(1,3), c(3,1)]).
diagonal(c(3,3),[c(1,1),c(2,2)]).
diagonal(c(1,3),[c(2,2),c(3,1)]).
diagonal(c(3,1),[c(2,2),c(1,3)]).

diagonal(c(1,2),[]).
diagonal(c(2,1),[]).
diagonal(c(3,2),[]).
diagonal(c(2,3),[]).

%quadrado2
diagonal(c(1,4),[c(2,5),c(3,6)]).
diagonal(c(2,5),[c(1,4),c(3,6), c(3,4), c(1,6)]).
diagonal(c(3,4),[c(2,5),c(1,6)]).
diagonal(c(3,6),[c(2,5),c(1,4)]).
diagonal(c(1,6),[c(2,5),c(3,4)]).

diagonal(c(1,5),[]).
diagonal(c(2,4),[]).
diagonal(c(2,6),[]).
diagonal(c(3,5),[]).

%quadrado3
diagonal(c(1,7),[c(2,8),c(3,9)]).
diagonal(c(2,8),[c(1,7),c(3,9), c(3,7), c(1,9)]).
diagonal(c(3,7),[c(2,8),c(1,9)]).
diagonal(c(3,9),[c(2,8),c(1,7)]).
diagonal(c(1,9),[c(2,8),c(3,7)]).

diagonal(c(1,8),[]).
diagonal(c(2,7),[]).
diagonal(c(2,9),[]).
diagonal(c(3,8),[]).

%quadrado4
diagonal(c(4,1),[c(5,2),c(6,3)]).
diagonal(c(5,2),[c(4,1),c(6,3), c(4,3), c(6,1)]).
diagonal(c(6,3),[c(4,1),c(5,2)]).
diagonal(c(4,3),[c(5,2),c(6,1)]).
diagonal(c(6,1),[c(5,2),c(4,3)]).

diagonal(c(4,2),[]).
diagonal(c(5,1),[]).
diagonal(c(6,2),[]).
diagonal(c(5,3),[]).

%quadrado5
diagonal(c(4,4),[c(5,5),c(6,6)]).
diagonal(c(5,5),[c(4,4),c(6,6), c(6,4), c(4,6)]).
diagonal(c(6,4),[c(5,5),c(4,6)]).
diagonal(c(6,6),[c(5,5),c(4,4)]).
diagonal(c(4,6),[c(5,5),c(6,4)]).

diagonal(c(4,5),[]).
diagonal(c(5,4),[]).
diagonal(c(5,6),[]).
diagonal(c(6,5),[]).

%quadrado6
diagonal(c(4,7),[c(5,8),c(6,9)]).
diagonal(c(5,8),[c(4,7),c(6,9), c(6,7), c(4,9)]).
diagonal(c(6,7),[c(5,8),c(4,9)]).
diagonal(c(6,9),[c(5,8),c(4,7)]).
diagonal(c(4,9),[c(5,8),c(6,7)]).

diagonal(c(4,8),[]).
diagonal(c(5,7),[]).
diagonal(c(5,9),[]).
diagonal(c(6,8),[]).

%quadrado7
diagonal(c(7,1),[c(8,2),c(9,3)]).
diagonal(c(8,2),[c(7,1),c(9,3), c(9,1), c(7,3)]).
diagonal(c(9,1),[c(8,2),c(7,3)]).
diagonal(c(9,3),[c(8,2),c(7,1)]).
diagonal(c(7,3),[c(8,2),c(9,1)]).

diagonal(c(7,2),[]).
diagonal(c(8,1),[]).
diagonal(c(8,3),[]).
diagonal(c(9,2),[]).

%quadrado8
diagonal(c(7,4),[c(8,5),c(9,6)]).
diagonal(c(8,5),[c(7,4),c(9,6), c(9,4), c(7,6)]).
diagonal(c(9,4),[c(8,5),c(7,6)]).
diagonal(c(9,6),[c(8,5),c(7,4)]).
diagonal(c(7,6),[c(8,5),c(9,4)]).

diagonal(c(7,5),[]).
diagonal(c(8,4),[]).
diagonal(c(8,6),[]).
diagonal(c(9,5),[]).

%quadrado9
diagonal(c(7,7),[c(8,8),c(9,9)]).
diagonal(c(8,8),[c(7,7),c(9,9), c(9,7), c(7,9)]).
diagonal(c(9,7),[c(8,8),c(7,9)]).
diagonal(c(9,9),[c(8,8),c(7,7)]).
diagonal(c(7,9),[c(8,8),c(9,7)]).

diagonal(c(7,8),[]).
diagonal(c(8,7),[]).
diagonal(c(8,9),[]).
diagonal(c(9,8),[]).

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
  removeQuads(Lista,V,R,R1).

removeQuads([],_,R,R).

removeQuads([N|L],V,R,R2):-
  member(v(N,_,_),R),
  findRemove(v(N,_,_),V,R,R1),
  removeQuads(L,V,R1,R2).

removeQuads([N|L],V,R,R1):-
  \+ member(v(N,_,_),R),
  removeQuads(L,V,R,R1).

findRemove(v(N,_,_),V,[v(N,D,L)|R],[v(N,D2,L)|R]):-
  removeLista(V,D,D2),!.

findRemove(v(N,_,_),V,[I|R],[I|R1]):-
  findRemove(v(N,_,_),V,R,R1).

removeLista(_,[],[]):-!.
removeLista(Valor,[Valor|R],R):-!.
removeLista(Valor,[X|R],[X|R1]):-
  removeLista(Valor,R,R1).
