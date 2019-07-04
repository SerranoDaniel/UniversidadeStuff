%Alterar o dominio para conseguir 3x3 (até 9)

dominio([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16]).

estado_inicial( e([v(n(1,1),D,_Val1),
		   		   v(n(1,2),D,_Val2),
	      	       v(n(1,3),D,_Val3),
		   		   v(n(2,1),D,_Val4),
		   		   v(n(2,2),D,_Val5),
		   		   v(n(2,3),D,_Val6),
		   		   v(n(3,1),D,_Val7),
		   		   v(n(3,2),D,_Val8),
		   		   v(n(3,3),D,_Val9),
		   		   v(n(4,1),D,_ValA),
		   		   v(n(4,2),D,_ValB),
		   		   v(n(4,3),D,_ValC),
		   		   v(n(4,4),D,_ValD),
		   		   v(n(1,4),D,_ValE),
		   		   v(n(2,4),D,_ValF),
		   		   v(n(3,4),D,_ValG)],[]) ) :- dominio(D).

%Comentar as linhas a partir de (4,1) para conseguir o 3x3


%Verifica se todos os elementos no quadrado são diferentes e valida as somas
ve_restricoes(e(NAfect,Afect)):- 
	all_diff(Afect),
	valida_somas(Afect).




all_diff([]).

all_diff([v(_,_,V)|Afect]) :- 
	member(v(_,_,V),Afect),!,fail.

all_diff([_|Afect]):- 
	all_diff(Afect).




%quadrado magico somas de linha coluna todas iguais
valida_somas(L) :- findall(V,member(v(n(1,_),_,V), L),L1), linha(L1),
                   findall(V,member(v(n(2,_),_,V), L),L2), linha(L2),
                   findall(V,member(v(n(3,_),_,V), L),L3), linha(L3),
		  		   findall(V,member(v(n(_,1),_,V), L),C1), coluna(C1),
		           findall(V,member(v(n(_,2),_,V), L),C2), coluna(C2),
		           findall(V,member(v(n(_,3),_,V), L),C3), coluna(C3),

		           findall(V,member(v(n(_,4),_,V), L),C4), coluna(C4),
		           findall(V,member(v(n(4,_),_,V), L),L4), linha(L4).
		          




linha( [V1,V2,V3,V4] ):-!, 34 is  V1+V2+V3+V4.
linha(_).							   

coluna( [V1,V2,V3,V4] ):- !, 34 is V1+V2+V3+V4.
coluna(_).



