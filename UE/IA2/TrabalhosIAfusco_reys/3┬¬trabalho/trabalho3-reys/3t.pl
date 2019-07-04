:-dynamic(empate/1).


%estado_inicial(([(1,1,_),(1,2,_),(1,3,_),
%                (2,1,_),(2,2,_),(2,3,_),
%                (3,1,_),(3,2,_),(3,3,_)],[])).
estado_inicial(([(1,2,_),
                (2,2,_),
                (3,1,_),(3,2,_)],[(1,1,0),(1,3,0),(2,1,1),(2,3,1),(3,3,0)])).

op1((X,Y),joga11,(W,[(1,1,J)|Y]),P):-
  member((1,1,_),X),
  J is P mod 2,
  remover((1,1,_),X,W).

op1((X,Y),joga12,(W,[(1,2,J)|Y]),P):-
  member((1,2,_),X),
  J is P mod 2,
  remover((1,2,_),X,W).

op1((X,Y),joga13,(W,[(1,3,J)|Y]),P):-
  member((1,3,_),X),
  J is P mod 2,
  remover((1,3,_),X,W).

op1((X,Y),joga21,(W,[(2,1,J)|Y]),P):-
  member((2,1,_),X),
  J is P mod 2,
  remover((2,1,_),X,W).

op1((X,Y),joga22,(W,[(2,2,J)|Y]),P):-
  member((2,2,_),X),
  J is P mod 2,
  remover((2,2,_),X,W).

op1((X,Y),joga23,(W,[(2,3,J)|Y]),P):-
  member((2,3,_),X),
  J is P mod 2,
  remover((2,3,_),X,W).

op1((X,Y),joga31,(W,[(3,1,J)|Y]),P):-
  member((3,1,_),X),
  J is P mod 2,
  remover((3,1,_),X,W).

op1((X,Y),joga32,(W,[(3,2,J)|Y]),P):-
  member((3,2,_),X),
  J is P mod 2,
  remover((3,2,_),X,W).

op1((X,Y),joga33,(W,[(3,3,J)|Y]),P):-
  member((3,3,_),X),
  J is P mod 2,
  remover((3,3,_),X,W).



terminal((_,X)):-
  (member((1,1,0),X),member((1,2,0),X),member((1,3,0),X)),!;
  (member((2,1,0),X),member((2,2,0),X),member((2,3,0),X)),!;
  (member((3,1,0),X),member((3,2,0),X),member((3,3,0),X)),!;

  (member((1,1,0),X),member((2,1,0),X),member((3,1,0),X)),!;
  (member((1,2,0),X),member((2,2,0),X),member((3,2,0),X)),!;
  (member((1,3,0),X),member((2,3,0),X),member((3,3,0),X)),!;

  (member((1,1,0),X),member((2,2,0),X),member((3,3,0),X)),!;
  (member((1,3,0),X),member((2,2,0),X),member((3,1,0),X)),!.

terminal((_,X)):-
  (member((1,1,1),X),member((1,2,1),X),member((1,3,1),X)),!;
  (member((2,1,1),X),member((2,2,1),X),member((2,3,1),X)),!;
  (member((3,1,1),X),member((3,2,1),X),member((3,3,1),X)),!;

  (member((1,1,1),X),member((2,1,1),X),member((3,1,1),X)),!;
  (member((1,2,1),X),member((2,2,1),X),member((3,2,1),X)),!;
  (member((1,3,1),X),member((2,3,1),X),member((3,3,1),X)),!;

  (member((1,1,1),X),member((2,2,1),X),member((3,3,1),X)),!;
  (member((1,3,1),X),member((2,2,1),X),member((3,1,1),X)),!.


terminal(([],_)):-
  aux =.. [empate,true],
  asserta(aux).


valor(([],_),0,_):- empate(true),!.
valor(_,1,P):- X is P mod 2, X=0,!.
valor(_,-1,_).


remover(X,[X|Z],Z):-!.
remover(X,[Y|Z],[Y|W]):-
  remover(X,Z,W).
