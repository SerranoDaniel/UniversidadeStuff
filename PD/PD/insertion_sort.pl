/* ins_sort(Xs,Ys) 
a lista Ys e uma permutacao 
ordenada de Xs */

insertion_sort([],[]).

insertion_sort([X|Xs],Ys) :-
	insertion_sort(Xs,Zs),
	insert(X,Zs,Ys).

insert(X,[],[X]).

insert(X,[Y|Ys],[Y|Zs]) :-
	X > Y,
	insert(X,Ys,Zs).

insert(X,[Y|Ys],[X,Y|Ys]) :-
      X =< Y.
