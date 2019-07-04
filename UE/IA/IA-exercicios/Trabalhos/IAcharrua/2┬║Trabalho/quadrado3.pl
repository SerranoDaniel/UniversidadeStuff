%Alterar o dominio para conseguir 3x3 (até 9)

dominio([1,2,3,4,5,6,7,8,9]).

estado_inicial( e([v(n(1,1),D,_Val1),
		   		   v(n(1,2),D,_Val2),
	      	       v(n(1,3),D,_Val3),
		   		   v(n(2,1),D,_Val4),
		   		   v(n(2,2),D,_Val5),
		   		   v(n(2,3),D,_Val6),
		   		   v(n(3,1),D,_Val7),
		   		   v(n(3,2),D,_Val8),
		   		   v(n(3,3),D,_Val9)],[]) ) :- dominio(D).


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
		           findall(V,member(v(n(_,3),_,V), L),C3), coluna(C3).
		          




linha( [V1,V2,V3] ):-!, 15 is  V1+V2+V3.
linha(_).							   

coluna( [V1,V2,V3] ):- !, 15 is V1+V2+V3.
coluna(_).



