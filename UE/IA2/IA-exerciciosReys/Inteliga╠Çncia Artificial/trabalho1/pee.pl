%estado
% ([MArgemI],[MargemF])
:- set_prolog_stack(global, limit(100 000 000 000)).
%PNI
estado_inicial(([28, 65, 45, 57, 98,120],[])).
%PI
%estado_inicial(([28, 65, 45, 57, 98, 120, 34],[])).


%estado final

estado_final(([],_Xs)).

%operaçoes

op((Ms,Ls),transfere,(Ms1,[Ls1|Ls]),1):-
	findall(A,t(A,Ms),L1),
	sort(L1,Lista),
	tira1(Lista,Ls1,_),
	remove(Ms,Ls1,Ms1).

remove(L,[],L):-!.
remove(L,[X|R],L1):-
	remove1(L,X,L2),
	remove(L2,R,L1).

remove1([X|L],X,L):-!.
remove1([A|L],X,[A|L1]):-
	remove1(L,X,L1).

tira1([E|L], E, L).
tira1([E1|L], N, [E1|L1]):- tira1(L,N,L1).

permutar([],[]).
permutar(L,[X|L1]):-
	member1(X,L,L0),
	permutar(L0,L1).

member1(X,[X|L],L).
member1(X,[A|L],[A|L1]):-
	member1(X,L,L1).

t(A,L):-
	permutar(L,R),
	append(A,_B,R),
	pesototal(A,Peso),
	Peso=<140.

pesototal([],0):-!.
pesototal([X|Ls],V1):-
	pesototal(Ls,V),
	V1 is V+X.

numerodepessoas([],V,V):-!.
numerodepessoas([_|L],X,V):-
	X1 is X+1,
	numerodepessoas(L,X1,V).

h1((L,_),V):- pesototal(L,T), V is T/140.
h2((L,_),V):- numerodepessoas(L,0,N),pesototal(L,T), T\=0,!, V is T/(N*140).
h2((L,_),V):- V is 0.
