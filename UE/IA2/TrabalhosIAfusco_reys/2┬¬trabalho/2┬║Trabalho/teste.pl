% estado inicial(estado, variaveis(nome, dominio), variaveis não instanciadas)

estado_inicial(e([
		  v(oper(1),['+','-','*','//'],_),
		  v(oper(2),['+','-','*','//'],_),
                  v(n(1),[1,2,3,4,5,6,7,8,9],_),
          	  v(n(2),[1,2,3,4,5,6,7,8,9],_),
                  v(n(3),[1,2,3,4,5,6,7,8,9],_),
		  v(oper(6),['+','-','*','/'],_),
		  v(oper(7),['+','-','*','/'],_),
          	  v(n(4),[1,2,3,4,5,6,7,8,9],_),
          	  v(n(5),[1,2,3,4,5,6,7,8,9],_),
                  v(n(6),[1,2,3,4,5,6,7,8,9],_),
		  v(oper(11),['+','-','*','/'],_),
		  v(oper(12),['+','-','*','/'],_),
          	  v(n(7),[1,2,3,4,5,6,7,8,9],_),
          	  v(n(8),[1,2,3,4,5,6,7,8,9],_),
                  v(n(9),[1,2,3,4,5,6,7,8,9],_),
		  v(oper(3),['+','-','*','/'],_),
		  v(oper(4),['+','-','*','/'],_)
		  %v(oper(5),['+','-','*','/'],_),		  
		  %v(oper(8),['+','-','*','/'],_),
		  %v(oper(9),['+','-','*','/'],_),
		  %v(oper(10),['+','-','*','/'],_)		 
		], [])).

%Predicado que calcula o nó sucessor

sucessor(e([v(N,D,V)|R],E),e(R,[v(N,D,V)|E])):-
	member(V,D).

pb:- estado_inicial(EstI),
	/*time(backtracking(EstI,A)),*/
        backtracking(EstI,A),
	write('Solucao: '),
	nl,nl,
	reverse(A,Sol),
	imprime(Sol),
	nl,nl,
	write(Sol),
	nl.

%operações aritméticas

somar(X,Y,'+',Res):-
	Res is X+Y.

subtrair(X,Y,'-',Res):-
	Res is X-Y.

multiplicar(X,Y,'*',Res):-
	Res is X*Y.

dividir(X,Y,'/',Res):-
	Res is X/Y.


%Restrições

todos_diff(A,B,C):-
	dif_todos(A,B,C).

dif_todos(X,Y,Z):-
	X=\=Y,
	X=\=Z,
	Y=\=Z.

ve_restricoes(e(_,A)):-
	restricao_linha(e(_,A)).
	%restricao_coluna(e(_,A)).	



%restricao_coluna(e(_,C)).	

%Efectua as operações aritméticas necessárias e retorna o resultado das mesmas numa linha e/ou coluna.

linha(X,Y,Z,Op1,Op2,Res):- 

	calcula(X,Y,Op1,R1),
	calcula(R1,Z,Op2,Res).

coluna(X,Y,Z,Op1,Op2,Res):-
	calcula(X,Y,Op1,R1),
	calcula(R1,Z,Op2,Res).

calcula(A,B,C,R):- F=..[C,A,B],R is F.

%Verifica a restrição da primeira linha do quadrado.
restricao_linha(e(_,L)):-
	length(L, Res),
	Res \= 5,
	Res \= 10,
	Res \= 15.

restricao_linha(e(_,A)):-
	length(A,5),
	member(v(n(1),_,X),A),
	member(v(oper(1),_,Op1),A),
	member(v(n(2),_,Y),A),
	member(v(oper(2),_,Op2),A),
	member(v(n(3),_,Z),A),
	todos_diff(X,Y,Z),
	linha(X,Y,Z,Op1,Op2,6).

%Verifica a restrição da segunda linha do quadrado.


restricao_linha(e(_,A)):-
	((length(A,10),
	member(v(n(4),_,X),A),
	member(v(oper(6),_,Op1),A),
	member(v(n(5),_,Y),A),
	member(v(oper(7),_,Op2),A),
	member(v(n(6),_,Z),A),
	todos_diff(X,Y,Z),
	(linha(X,Y,Z,Op1,Op2,15)))).

%Verifica a restrição da terceira linha do quadrado

restricao_linha(e(_,A)):-
	((length(A,15),
	member(v(n(1),_,X1),A),
	member(v(n(2),_,Y1),A),
	member(v(n(3),_,Z1),A),
	member(v(n(4),_,X2),A),
	member(v(n(5),_,Y2),A),
	member(v(n(6),_,Z2),A),
	member(v(n(7),_,X3),A),
	member(v(oper(11),_,Op1),A),
	member(v(n(8),_,Y3),A),
	member(v(oper(12),_,Op2),A),
	member(v(n(9),_,Z3),A),
	todos_diff(X3,Y3,Z3),
	(linha(X3,Y3,Z3,Op1,Op2,24)),
	(linha(X1,X2,X3,+,+,12)))).


esc(A):- write(A),nl.



