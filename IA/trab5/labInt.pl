:-dynamic(h/2).

tabuleiro(6,6).




%%%% Condições ou fluentes %%%%

%obstruida(X,Y) -- é verdade se a casa (X,Y) está obstruída.
%visitada(X,Y) -- é verdade se a casa (X,Y) já foi visitada pelo agente.
%esta(X,Y) -- é verdade se o agente está na casa (X,Y).
%saida(X,Y) -- é verdade se a casa (X,Y) tem a saída do labirinto.




%%%% Acções %%%%

%mover(X) -- com X pertencente a {cima, baixo, esquerda, direita}.
%desistir.
%sair.




%%%% Percepções %%%%

%brisa
%obstruidas(n) -- com n o número de casas adjacentes obstruídas

start:- andar(s0),!.

andar(S):- h(ganhou,S), write('Vitoria'),nl.

andar(S) :- h(desistir,S), write('Derrota por desistencia'),nl.




%%%% Interface %%%%

%Se ainda não visitou a casa pede a percepcao
andar(S):- r(A0,S1)=S, 
	h(esta(X,Y),S),
	\+ h(visitada(X,Y),S1),
	write('Percepcao na situacao apos: '),
	h(esta(X,Y),S),
	write(A0), 
	write('Em: '), 
	write(pos(X,Y)),nl,
	write(' O que? '), nl,
	read(P),!,
	tell(kb,percepcao([P],S)),
	ask(kb,accao(A,S)),
	write('Faz: '),write(A),nl,
	andar(r(A,S)).

%Se já visitou a casa não pede a percepcao
andar(S):- h(esta(X,Y),S), 
	write('Em: '), write(pos(X,Y)),nl,
	ask(kb,accao(A,S)),
	write('Faz: '),write(A),nl,
	andar(r(A,S)).

% Guarda percepcoes
tell(kb,percepcao([],_)).
tell(kb,percepcao([nada],_)).
tell(kb,percepcao([A|R],S)):- asserta(h(A,S)), 
	tell(kb,percepcao(R,S)).




%%Interpretação do ask                                   		

%Prefere ganhar se puder
ask(kb,accao(A,S)):- h(ganhou,r(A,S)).

%O agente deve procurar ir para uma casa que ainda não visitou.
ask(kb,accao(mover(cima),S)):- h(esta(X,Y),S),
			Y1 is Y+1, tabuleiro(_,TabY), Y1=<TabY,
			\+ h(visitada(X,Y1),_), \+ h(obstruida(X,Y1),r(mover(cima),S)).

ask(kb,accao(mover(direita),S)):- h(esta(X,Y),S),
			X1 is X+1, tabuleiro(TabX,_), X1=<TabX,
			\+ h(visitada(X1,Y),_), \+ h(obstruida(X1,Y),r(mover(cima),S)).

ask(kb,accao(mover(baixo),S)):- h(esta(X,Y),S),
			Y1 is Y-1, Y1>0,
			\+ h(visitada(X,Y1),_), \+ h(obstruida(X,Y1),r(mover(cima),S)).

ask(kb,accao(mover(esquerda),S)):- h(esta(X,Y),S),
			X1 is X-1, X1>0,
			\+ h(visitada(X1,Y),_), \+ h(obstruida(X1,Y),r(mover(cima),S)).

%Se o agente está rodeado de casas obstruidas, desistir.
ask(kb,accao(desistir,S)):- h(temTiros(T),S),T==0,
			h(esta(X,Y),S),
			proxObst((X,Y),N,Nprox),N==Nprox.

%Se o agente está rodeado de casas obstruidas e visitadas, desistir
ask(kb,accao(disparar(cima),S)):- h(esta(X,Y),S),
			Y1 is Y+1,
			obstruida(X,Y1),
			proxObst((X,Y),N1,Nprox),
			proxVisitada((X,Y),N2,Nprox),
			N is N1+N2,
			N==Nprox.




%%%%%%%%%%%%%%%%%%%%%%%

%estado inicial
h(esta(1,1),s0).
h(temTiros(3),s0).




%%%%%%%%%%%%%%%%%%%%%%%%%
%i- as consequencias positivas de cada ação		  
%%%%%%%%%%%%%%%%%%%%%%%%%%

%Acção Mover
h(esta(X,Y1),r(mover(cima),S)):- h(esta(X,Y),S),
				Y1 is Y+1, 
				tabuleiro(_,TabY), 
				Y1=<TabY,
				\+ h(obstruida(X,Y1),r(mover(cima),S)).

h(esta(X1,Y),r(mover(direita),S)):- h(esta(X,Y),S), 
				X1 is X+1,
				tabuleiro(TabX,_),
				X1=<TabX,
				\+ h(obstruida(X1,Y),r(mover(direita),S)).

h(esta(X,Y1),r(mover(baixo),S)):- h(esta(X,Y),S), 
				Y1 is Y-1,
				Y1 > 0,
				\+ h(obstruida(X,Y1),r(mover(baixo),S)).

h(esta(X1,Y),r(mover(esquerda),S)):- h(esta(X,Y),S),
				X1 is X-1,
				X1 > 0,
				\+ h(obstruida(X1,Y),r(mover(esquerda),S)).

%Acção desistir
h(perdeu,r(desistir,S)):- h(esta(_X,_Y),S).

%Acção sair
h(ganhou,r(sair,S)):- h(esta(X,Y),S), saida(X,Y).




direcao(X):- member(X, [cima,baixo,direita,esquerda]).

%%%%%%%%%%%%%%%%%%%%%%%%
%ii. as leis de inercia, para cada fluente indicar as ações que não alteram o seu valor.
%%%%%%%%%%%%%%%%%%%%%%%%%%

%O agente mantem-se na casa(X,Y), se realizar a acção sair em S e não tem a perceção da brisa em S
h(esta(X,Y),r(sair,S)):- h(esta(X,Y),S), \+ h(brisa,S).

%A casa (X,Y) mantem-se obstruida em S, se realizar a acção mover em S 
h(obstruida(X,Y),r(mover(Z),S)):- direcao(Z), 
				h(obstruida(X,Y),S).

%O agente mantêm-se na casa (X,Y), se realizar a acção mover em S e a casa para a qual se vai movimenter estiver obstruida
h(esta(X,Y),r(mover(Z),S)) :- direcao(Z),     h(esta(X,Y),S),     h(obstruida(X,Y),r(mover(Z),S)). 
				
%A casa(X,Y) permanece como visitada em S, independentemente da acção que efectue em S quando esta na casa(X,Y) em S
h(visitada(X,Y),S):- h(esta(X,Y),S).
h(visitada(X,Y),r(_,S)):- h(visitada(X,Y),S).

%A casa (X,Y) permanece como casa de saida em S,independentemente da acção que efectue em S
h(saida(X,Y),r(_,S)):- h(saida(X,Y),S). 

%Fluente ganhou
h(ganhou,r(_,S)):- h(ganhou,S).

%Fluente perdeu
h(perdeu,r(_,S)):- h(perdeu,S).




%%%%%%%%%%%%%%%%%%%%%%%
%iii. o diagnostico das causas das perceções:
%%%%%%%%%%%%%%%%%%%%%%%%%

%Se há a percepção brisa em S e estou em (X,Y), então a casa(X,Y) é a casa de saida. 
saida(X,Y):- h(brisa,S), h(esta(X,Y),S).

%obstruidas(n) - numero de casas proximas obstruidas 
%Se há a percepção obstruidas(n) em S, então há n casas proximas que sao obstruidas
proxObst((X,Y),N,Nprox):- h(esta(X,Y),S),
			h(obstruidas(N),S),
			prox((X,Y),Nprox). 

%contabiliza o numero de casas proximas a (X,Y)
prox((X,Y),Nprox):- tabuleiro(TabX,TabY),
	((X>1,X<TabX,Y>1,Y<TabY, Nprox);
	(((X==1,Y==1);(X==1,Y==TabY);(X==TabX,Y==1);(X==TabX,Y==TabY)),Nprox);
	Nprox).

%proxVisitada((X,Y),N,Nprox) - numero de casas visitadas
prox((X,Y),N,Nprox):- prox((X,Y),Nprox),
		contVis((X,Y),Nprox,N),
		N=<Nprox.