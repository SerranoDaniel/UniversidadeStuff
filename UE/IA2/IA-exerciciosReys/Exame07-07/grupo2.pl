estado_inicial(e(
[
      v(c(1,1), [x, o], o),
      v(c(1,2), [x, o], o),
      v(c(1,3), [x, o], o),
      v(c(1,4), [x, o], o),
      v(c(2,1), [x, o], o),
      v(c(2,2), [x, o], o),
      v(c(2,3), [x, o], o),
      v(c(2,4), [x, o], o),
      v(c(3,1), [x, o], o),
      v(c(3,2), [x, o], o),
      v(c(3,3), [x, o], o),
      v(c(3,4), [x, o], o),
      v(c(4,1), [x, o], o),
      v(c(4,2), [x, o], o),
      v(c(4,3), [x, o], o),
      v(c(4,4), [x, o], o)
], 
[]
)).


conta(v(c(I,_),_,Vj), Afect)

ve_restricoes(e(Nafect,Afect)):-
      \+ (member(v(c(I,J),_,Vj), Afect), member(v(c(I,K),_,Vk),Afect),  K \=J,Vk=Vj),
      \+ (member(v(c(I,J),_,Vi), Afect), member(v(c(K,J),_,Vk),Afect),  K \=I,Vi=Vk),


esc(L):- sort(L,L1),nl, esc1(L1,1).
esc1([],_):-!.
esc1([v(_,_,V)|R], N):- N < 4, write(V), write(' '), N1 is N+1, esc1(R,N1),!.
esc1([v(_,_,V)|R], N):- N = 4, write(V), write(' '), nl, N1 is 1, esc1(R,N1),!.
