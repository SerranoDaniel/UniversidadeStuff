estado_inicial(e([
v(c(1,1),[1,2,3,4],_),
v(c(1,2),[1,2,3,4],_),
v(c(1,3),[1,2,3,4],_),
v(c(1,4),[1,2,3,4],_),
v(c(2,1),[1,2,3,4],_),
v(c(2,2),[1,2,3,4],_),
v(c(2,3),[1,2,3,4],_),
v(c(2,4),[1,2,3,4],_),
v(c(3,1),[1,2,3,4],_),
v(c(3,2),[1,2,3,4],_),
v(c(3,3),[1,2,3,4],_),
v(c(3,4),[1,2,3,4],_),
v(c(4,1),[1,2,3,4],_),
v(c(4,2),[1,2,3,4],_),
v(c(4,3),[1,2,3,4],_),
v(c(4,4),[1,2,3,4],_)], [])).

ve_restricoes(e(_,Afect)):-
  \+ (member(v(c(I,J),_,Vj), Afect), member(v(c(I,K),_,Vk),Afect),  K \=J,Vk=Vj),
  \+ (member(v(c(I,J),_,Vi), Afect), member(v(c(K,J),_,Vk),Afect),  K \=I,Vi=Vk),
  \+ (member(v(c(1,1),_,Vi), Afect), member(v(c(2,2),_,Vj),Afect),  Vi=Vj),
  \+ (member(v(c(2,1),_,Vi), Afect), member(v(c(1,2),_,Vj),Afect),  Vi=Vj),
  \+ (member(v(c(3,1),_,Vi), Afect), member(v(c(4,2),_,Vj),Afect),  Vi=Vj),
  \+ (member(v(c(3,2),_,Vi), Afect), member(v(c(4,1),_,Vj),Afect),  Vi=Vj),
  \+ (member(v(c(1,3),_,Vi), Afect), member(v(c(2,4),_,Vj),Afect),  Vi=Vj),
  \+ (member(v(c(2,3),_,Vi), Afect), member(v(c(1,4),_,Vj),Afect),  Vi=Vj),
  \+ (member(v(c(3,3),_,Vi), Afect), member(v(c(4,4),_,Vj),Afect),  Vi=Vj),
  \+ (member(v(c(3,4),_,Vi), Afect), member(v(c(4,3),_,Vj),Afect),  Vi=Vj).

esc(L):- sort(L,L1),nl, esc1(L1,1).
esc1([],_):-!.
esc1([v(_,_,V)|R], N):- N < 4, write(V), N1 is N+1, esc1(R,N1),!.
esc1([v(_,_,V)|R], N):- N = 4, write(V), nl, N1 is 1, esc1(R,N1),!.
