estado_inicial(e([
v(c(1,1), [1, 2, 3, 4, 5, 6, 7, 8, 9], _),
v(c(1,2), [1, 2, 3, 4, 5, 6, 7, 8, 9], _),
v(c(1,3), [1, 2, 3, 4, 5, 6, 7, 8, 9], _),
v(c(2,1), [1, 2, 3, 4, 5, 6, 7, 8, 9], _),
v(c(2,2), [1, 2, 3, 4, 5, 6, 7, 8, 9], _),
v(c(2,3), [1, 2, 3, 4, 5, 6, 7, 8, 9], _),
v(c(3,1), [1, 2, 3, 4, 5, 6, 7, 8, 9], _),
v(c(3,2), [1, 2, 3, 4, 5, 6, 7, 8, 9], _),
v(c(3,3), [1, 2, 3, 4, 5, 6, 7, 8, 9], _)], 

[

])).

ve_restricoes(e(Nafect,Afect)):-
  \+ (member(v(c(I,J),_,Vj), Afect), 
      member(v(c(A,B),_,Vk), Afect), 
      A \= I,
      J \= B,
      Vk = Vj),
  (\+ preenchidos(Nafect) ; soma(Afect)).

soma(Afect):-
      member(v(c(1,1),_,V11), Afect),
      member(v(c(1,2),_,V12), Afect),
      member(v(c(1,3),_,V13), Afect), 
      SomaL1 is V11+V12+V13,
      member(v(c(2,1),_,V21), Afect),
      member(v(c(2,2),_,V22), Afect),
      member(v(c(2,3),_,V23), Afect), 
      SomaL2 is V21+V22+V23,
      member(v(c(3,1),_,V31), Afect),
      member(v(c(3,2),_,V32), Afect),
      member(v(c(3,3),_,V33), Afect), 
      SomaL3 is V31+V32+V33,

      member(v(c(1,1),_,V11), Afect),
      member(v(c(2,1),_,V21), Afect),
      member(v(c(3,1),_,V31), Afect), 
      SomaC1 is V11+V21+V31,
      member(v(c(1,2),_,V12), Afect),
      member(v(c(2,2),_,V22), Afect),
      member(v(c(3,2),_,V32), Afect), 
      SomaC2 is V12+V22+V32,
      member(v(c(1,3),_,V13), Afect),
      member(v(c(2,3),_,V23), Afect),
      member(v(c(3,3),_,V33), Afect), 
      SomaC3 is V13+V23+V33,

      member(v(c(1,1),_,V11), Afect),
      member(v(c(2,2),_,V22), Afect),
      member(v(c(3,3),_,V33), Afect), 
      SomaD1 is V11+V22+V33,
      member(v(c(1,3),_,V13), Afect),
      member(v(c(2,2),_,V22), Afect),
      member(v(c(3,1),_,V31), Afect), 
      SomaD2 is V13+V22+V31,

      SomaL1 = SomaL2,
      SomaL2 = SomaL3,
      SomaL3 = SomaC1,
      SomaC1 = SomaC2,
      SomaC2 = SomaC3,
      SomaC3 = SomaD1,
      SomaD1 = SomaD2.

preenchidos([]).



esc(L):- sort(L,L1),nl, esc1(L1,1).
esc1([],_):-!.
esc1([v(_,_,V)|R], N):- N < 3, write(V), write(' '), N1 is N+1, esc1(R,N1),!.
esc1([v(_,_,V)|R], N):- N = 3, write(V), write(' '), nl, N1 is 1, esc1(R,N1),!.
