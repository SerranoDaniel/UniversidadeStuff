						/*Jogo do Galo*/

/*O estado inicial e representado por um tuplo que contem um array inicializado com 0, seguido do operador(X,o);
ex: estado_inicial( e([0,0,0, 0,0,0, 0,0,0],o) ). 
*/

estado_inicial(e([0,0,0,
	              x,x,0,
	              o,o,0],x)).


terminal(E):- 
	estado_terminal(E),!.

terminal(E):-
	estado_empatado(E),!.

%linhas
estado_terminal(e([Xo,Xo,Xo,_,_,_,_,_,_],Xo)).
estado_terminal(e([_,_,_,Xo,Xo,Xo,_,_,_],Xo)).
estado_terminal(e([_,_,_,_,_,_,Xo,Xo,Xo],Xo)).

%colunas
estado_terminal(e([Xo,_,_,Xo,_,_,Xo,_,_],Xo)).
estado_terminal(e([_,Xo,_,_,Xo,_,_,Xo,_],Xo)).
estado_terminal(e([_,_,Xo,_,_,Xo,_,_,Xo],Xo)).

%diagonais
estado_terminal(e([Xo,_,_,_,Xo,_,_,_,Xo],Xo)).
estado_terminal(e([_,_,Xo,_,Xo,_,Xo,_,_],Xo)).


%empate
estado_empatado(e([A,B,C,D,E,F,G,H,I],_)):-
	member(A,[x,o]),
	member(B,[x,o]),
	member(C,[x,o]),
	member(D,[x,o]),
	member(E,[x,o]),
	member(F,[x,o]),
	member(G,[x,o]),
	member(H,[x,o]),
	member(I,[x,o]).


%predicado que tem a funcao de colocar um operador na lista numa determinada posicao 
 
op1(e(Lista,o),(x,Posicao),e(ListaFinal,x)):-
	member(Posicao,[1,2,3,4,5,6,7,8,9]),
	substitui(Lista,(x,Posicao),ListaFinal).

op1(e(Lista,x),(o,Posicao),e(ListaFinal,o)):-
	member(Posicao,[1,2,3,4,5,6,7,8,9]),
	substitui(Lista,(o,Posicao),ListaFinal).


substitui([0|Resto],(Operador,1),[Operador|Resto]):-!.

substitui([Head|Resto],(Operador,Posicao),Final):-
	Posicao > 1,
	Paux is Posicao - 1,
	substitui(Resto,(Operador,Paux),R),
	append([Head],R,Final).


/* função de utilidade, retorna 1 se ganha, 0 se empata, -1 se perde, 
   o jogador "Humano" é o operador x!  
*/

valor(e(Lista,Operador),1,_):- 
		estado_terminal(e(Lista,Operador)), Operador=x,!.

valor(Lista,0,_):- 
		estado_empatado(Lista),!.

valor(e(Lista,Operador),-1,_):- 
		estado_terminal(e(Lista,Operador)), Operador=o,!.




