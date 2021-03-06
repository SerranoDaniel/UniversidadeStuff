
bloco(a,2).
bloco(b,1).
bloco(c,1).
bloco(d,2).

%----------------------------Estados--------------------------------------
estado_inicial([robot([]),no_chao(a),cima(d,a),no_chao(b),cima(c,b)]).

estado_final([no_chao(d),cima(c,d),cima(b,d),cima(a,b),cima(a,c)]).

%-----------------------------Acções--------------------------------------

accao(retirar_grande_grande(Cima,Baixo),[robot([]),cima(Cima,Baixo),livre(Cima)],[na_mao(Cima),livre(Baixo)],[robot([]),cima(Cima,Baixo),livre(Cima)]):-
	bloco(Cima,2),
	bloco(Baixo,2).

accao(coloca_grande_no_chao(Grande),[na_mao(Grande)],[robot([]),no_chao(Grande),livre(Grande)],[na_mao(Grande)]):-
	bloco(Grande,2).

accao(retirar_pequeno_pequeno(Cima,Baixo),[robo([t]),cima(Cima,Baixo),livre(Cima)],[na_mao(Cima),livre(Baixo)],[robot([]),cima(Cima,Baixo),livre(Cima)]):-
	bloco(Cima,1),
	bloco(Baixo,1).

accao(coloca_pequeno_no_chao(Pequeno),[na_mao(Pequeno)],[robot([]),no_chao(Pequeno),livre(Pequeno)],[na_mao(Pequeno)]):-
	bloco(Pequeno,1).

accao(retira_pequeno_no_chao(Pequeno),[robot([]),no_chao(Pequeno)],[na_mao(Pequeno)],[robot([]),no_chao(Pequeno)]):-
	bloco(Pequeno,1).

accao(retira_grande_no_chao(Grande),[robot([]),no_chao(Grande)],[na_mao(Grande)],[robot([]),no_chao(Grande)]):-
	bloco(Grande,2).

accao(coloca_pequeno_grande(Pequeno,Grande),[na_mao(Pequeno),livre(Grande)],[cima(Pequeno,Grande),robot([]),livre(Pequeno)],[na_mao(Pequeno),livre(Grande)]):-
	bloco(Pequeno,1),
	bloco(Grande,2).

accao(coloca_pequeno_grande(Pequeno,Grande),[na_mao(Pequeno)],[cima(Pequeno,Grande),robot([])],[na_mao(Pequeno)]):-
	bloco(Pequeno,1),
	bloco(Grande,2).

accao(coloca_grande_pequeno(Grande,Pequeno1,Pequeno2),[na_mao(Grande),livre(Pequeno1),livre(Pequeno2)],[robot([]),cima(Grande,Pequeno1),cima(Grande,Pequeno2),livre(Grande)],[na_mao(Grande),livre(Pequeno1),livre(Pequeno2)]):-
	bloco(Pequeno1,1),
	bloco(Pequeno2,1),
	bloco(Grande,2).