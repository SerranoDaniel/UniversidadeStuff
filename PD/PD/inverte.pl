/*
inverte(Lista,Atsil)
 Atsil e o resultado de inverter a Lista
*/

inverte([],[]).

inverte([X|Xs],Zs) :-
  inverte(Xs,Ys),
  append(Ys,[X],Zs).
