
%estado inicial-6 buracos e 1 pot para cada jogador, buracos com 4 sementes e pot com 0 sementes
% assume-se que j1 é o primeiro a começar.
%estado_inicial((j1,([4,4,4,4,4,4,4,4,4,4,4,4],0,0))).
estado_inicial((j1,([0,0,1,0,0,0,0,0,0,0,0,0],23,23))).

%estados finais
%quando j1 e j2 não tem qualquer elemento e pretendem jogar
terminal((_,([0,0,0,0,0,0,0,0,0,0,0,0],_V1,_V2))).
terminal((_,(_,V1,_))):- V1>24.
terminal((_,(_,_,V2))):- V2>24.
terminal((J,(A,B,C))):- verificaJogada(J,(A,B,C,_B1,_C1)).




%op1(estado,jogar,estado_seguinte)
op1((j1,(L,V1,V2)),Px,(j2,(Ls,V1f,V2))):- member(Px,[1,2,3,4,5,6]),jogar(Px,j1,L,Ls,V1,V1f),nl.
op1((j2,(L,V1,V2)),Px,(j1,(Ls,V1,V2f))):- member(Px,[7,8,9,10,11,12]), jogar(Px,j2,L,Ls,V2,V2f),nl. 
				

%jogar(Posição, jogador,Lista_Estado,Lista_Estado_seg,ValorPotIni,ValorPotFim)
%joga o jogador 1
jogar(Px,j1,L,Ls,V1i,V1f):- Px>=1, Px =< 6,
		      verificaReg(Px,L),
		      semear(Px,L,L1,Pf),
		      depositar(Pf,L1,Ls,V1i,V1f).

%joga o jogador 2
jogar(Px,j2,L,Ls,V2i,V2f):- Px>=7, Px=<12,
		      verificaReg(Px,L),
		      semear(Px,L,L2,Pf),
		      depositar(Pf,L2,Ls,V2i,V2f).

%Se a soma da posição com o numero de semente for menor ou igual que 12
%soma 1 semente ate ao fim
semear(Px,L1,Ls,Pf):- 
	 listaSemear(Px,L1,Lpre,Lpos,E),
	 Pf is Px+E, 
	 Pf =<12,!,
	 semearAux(E,Lpos,Ls1,_Ef),
	 append(Lpre,[0],Lx),
	 append(Lx,Ls1,Ls).

%Se a soma da posição com o numero de sementes for maior que 12
%soma 1 semente ate ao fim da lista e depois começa novamente no inicio da lista	
semear(Px,L1,Ls,Pf):- 
	 listaSemear(Px,L1,Lpre,Lpos,E),
	 semearAux(E,Lpos,Ls1,Ef),
	 Pf is Ef,
	 append(Lpre,[0],Lx),
	 append(Lx,Ls1,Ls2),
	 semearAux(Ef,Ls2,Ls,_Ef).

%soma 1 os elementos da lista
semearAux(0,L,L,0).
semearAux(E,[],[],E).
semearAux(E,[L|L1],[Ls|Ls1],Ef):-
	 E >0 ,!,
	 Ls is L+1,
	 E1 is E-1,
	 semearAux(E1,L1,Ls1,Ef).

%divide a lista em anteriores a posição e posterior a posição
listaSemear(Px,L1,Lpre,Lpos,E):- nth(Px,L1,E),
	  listaPre(Px,L1,Lpre),
	  listaPos(Px,L1,Lpos),!.


%lista com os elementos anteriores à jogada
listaPre(1,_,[]).
listaPre(P,[E1|Rs],[E1|Rs1]):-
	  P2 is P-1,
	  listaPre(P2,Rs,Rs1).


%lista com os elementos apos a posição da jogada
listaPos(0,Rs,Rs).
listaPos(P,[_E1|Rs],Ls):-
	  P2 is P-1,
	  listaPos(P2,Rs,Ls).



%Verifica se não existem buracos com mais sementes que 1
verificaReg(Px,L):-nth(Px,L,E),
		   E\=0,!,
		   verificaMaior(E,L).

%Verfica se na lista os elementos são maiores que 1
verificaMaior(E,_L):-E > 1.
verificaMaior(1,[]).
verificaMaior(E,[L1|L]):- E==1,
	L1 =<1, verificaMaior(1,L).



%Deposita as sementes no pot
depositar(Pf,L,Lfim,V1,Vf):- nth(Pf,L,E),
	      (E==2;E==3),
	      Va is V1+E,
	      listaPre(Pf,L,Lpre),
	      listaPos(Pf,L,Lpos),
	      reverse(Lpre,Lr),
	      reverse(Lpos,Lrp),
	      depositarAux(Lr,Lrp,Lf,Lfp,Va,Vf),
	      reverse(Lf,LPres),
      	      reverse(Lfp,LFPres),
	      append(LPres,[0],Lt),
	      append(Lt,LFPres,Lfim).
depositar(_Pf,L,L,V,V).


depositarAux([],Lp,[],Lpf,V,Vf):- depositarAuxP(Lp,Lpf,V,Vf),!.
depositarAux([L|Ls],Lp,[Lf|Lfs],Lpf,V1,Vf):- (L==2;L==3),!,
		  Va is V1+L,
		  Lf is 0,
		  depositarAux(Ls,Lp,Lfs,Lpf,Va,Vf).
depositarAux(L,Lp,L,Lp,V,V).


depositarAuxP([],[],V,V):-!.
depositarAuxP([L|Ls],[Lf|Lfs],V1,Vf):- (L==2;L==3),!,
		  Va is V1+L,
		  Lf is 0,
		  depositarAuxP(Ls,Lfs,Va,Vf).
depositarAuxP(L,L,V,V).



verificaJogada(j1,([0,0,0,0,0,0,P1,P2,P3,P4,P5,P6],V1,V2,V1,V2f)):- 
		V2f is V2+P1+P2+P3+P4+P5+P6.
		%P1 is 0, P2 is 0, P3 is 0, P4 is 0, P5 is 0, P6 is 0.
verificaJogada(j2,([P1,P2,P3,P4,P5,P6,0,0,0,0,0,0],V1,V2,V1f,V2)):- 
		V1f is V1+P1+P2+P3+P4+P5+P6.
%		P1 is 0, P2 is 0, P3 is 0, P4 is 0, P5 is 0, P6 is 0.


%Função Utilidade 1 - Ganha; -1 - Perde; 0 - Empata

valor((J,(A,B,C)),1,_P):- verificaJogada(J,(A,B,C,B1,C1)), B1>C1.
valor((J,(A,B,C)),-1,_P):- verificaJogada(J,(A,B,C,B1,C1)), B1<C1.
valor((J,(A,B,C)),0,_P):- verificaJogada(J,(A,B,C,B1,C1)), B1=C1.
valor((J,(T,V1,V2)),1,_P):-terminal((J,(T,V1,V2))), V1>V2.
valor((J,(T,V1,V2)),-1,_P):-terminal((J,(T,V1,V2))), V2>V1.
valor((J,(T,V1,V2)),0,_P):-terminal((J,(T,V1,V2))), V1=V2.

