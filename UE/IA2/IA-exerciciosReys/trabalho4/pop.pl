:- dynamic(n/1).

n(3).


% POP - Planeador de ordem parcial

% representacao de um plano:
% plano(p(Passos,Ordem,Links))

% representacao de um passo:
% passo(nomePasso-op(nomeAccao,Precond,AddList,DeleList)).


% plano_ini(P) constroi o plano inicial dados os estados inicial e final


plano_ini(p([s1-op(inicial,[],EstadoIni,[]),
s2-op(final,EstadoFin,[],[])],[m(s1,s2)],[]))
:-estado_inicial(EstadoIni),
estado_final(EstadoFin).


% este predicado retorna um plano linearizado

plano(P):- plano_ini(Pi), pop(Pi,P2), lineariza(P2,P).

% pop(+Pi,-P)
% este predicado recebe um plano e retorna um novo plano com mais uma
% condicao satisfeita


pop(Pi,P):- escolheCi(Pi,Si,Ci,Pj),!,
escolheSk(Pj,Si,Ci,Pk),
resolveAmeacas(Pk,Pl),
consistentep(Pl),
pop(Pl,P).

pop(P,P).

%Escolhe um condicao, Ci, da lista de precondicoes de um passo, Si, do plano
%que ainda nao esta satisfeita

escolheCi(p(Passos,Ordem,Links),Si,Ci,
p([Si-op(Nome,Cond1,Add,Del)|Passos1], Ordem,Links)):-
retira(Si-op(Nome,Cond,Add,Del),Passos,Passos1),
retira(Ci,Cond,Cond1).


%escolhe uma passo do plano, Sk, que satisfaz Ci, acrescenta um link e
%e a ordem relativa entre os passos do plano Sk<Si.

escolheSk(p(Passos,Ordem,Links),S,C,p(Passos,[m(Sk,S)|Ordem],
[link(Sk,S,C)|Links])):-
member(Sk-op(_,_,Add,_),Passos),
member(C, Add).


%Cria um novo passo no plano de forma a satisfazer Ci, actualiza os links
%e a Ordem entre os passos.

escolheSk(p(Passos,Ordem,Links),S,C,p([Sk-op(N,Cond,Add,Del)|Passos],
[m(Sk,S),m(Sk,s2),m(s1,Sk)|Ordem],
[link(Sk,S,C)|Links])):-
novo(Sk),!,length(Passos,M),M<5,!,
accao(N,Cond,Add,Del),
member(C, Add).


%resolve as ameacas aos links

resolveAmeacas(p(Passos,Ordem,Links),P):-
member(link(S1,S2,C),Links),
member(S3-op(_,_,_,Del),Passos),\+ member(S3,[S1,S2]),
member(C,Del),ameaca(S1,S2,S3,Ordem),!,
resolve(S1,S2,S3,Rest),
resolveAmeacas(p(Passos,[Rest|Ordem],Links),P).

resolveAmeacas(P,P).

%S3 ameaca o link(S1,S2,C) se S3 tem C na delete list e S1<S3<S2
ameaca(S1,S2,S3,Ord):- consistente([m(S1,S3),m(S3,S2)|Ord]).


%resolve ameaca: promove ou despromove S3
resolve(S1,_,S3,m(S3,S1)).
resolve(_,S2,S3,m(S2,S3)).

retira(X,[X|R],R).
retira(X,[Y|R],[Y|S]):- retira(X,R,S).

%retorna um novo identificador para um passo do plano
novo(O):- retract(n(I)), J is I+1, asserta(n(J)),
name(I,L), name(O,[115|L]),!.

%---Os predicados abaixo permitem verificar se um plano e consistente
% e linearizar uma plano

%verifica se um Plano e consistente
consistentep(p(_,Ordem,_)):- consistente(Ordem).

%verifica se uma ordem e consistente
consistente(A):-renomeia(A,[],B,_), ve_consistente(B).


renomeia([],N,[],N).
renomeia([m(A,B)|R],Nomes,[m(X,Y)|S],Nomesf):-
nome(A,X,Nomes,Nomes1),
nome(B,Y,Nomes1,Nomes2),
renomeia(R,Nomes2,S,Nomesf).
nome(A,X,L,L):- member(n(X,A),L),!.
nome(A,X,L,[n(X,A)|L]).

ve_consistente([]).
ve_consistente([m(A,B)|R]):- A#>=0, A #=<30, B#>=0, B #=<30, A #< B,
ve_consistente(R).

lineariza(p(Passos,Ordem,_Links),P):-
renomeia(Ordem,[],OrdemVar,Nomes),
length(Nomes,N), member(n(X,s2),Nomes), X#>=0, X #=< N,
ve_consistente(OrdemVar),variaveis(Nomes,Vars),
fd_labelingff(Vars),
sort(Nomes,Ord),
plano_ord(Ord,Passos,P).

variaveis([],[]).
variaveis([n(X,_)|R],[X|S]):- variaveis(R,S).


plano_ord([],_,[]).
plano_ord([n(_,S)|R],Passos,[S-N|Passos2]):- member(S-op(N,_,_,_),Passos),
plano_ord(R,Passos,Passos2).




% estadoInicial
estado_inicial([
	grande(a),
	grande(d),
	pequeno(b),
	pequeno(c),
	sobre(d,a),
	sobre(c,b),
	bracos,
	topo(d),
	topo(c),
	chao(a),
	chao(b)
]).

estado_final([
	chao(d),
	sobre(b,c,d),
	topo(a),
	sobre(a,b,c),
	grande(a),
	grande(d),
	pequeno(b),
	pequeno(c),
	bracos
]).

%accoes

%apanha um grande
accao(pegaG1(X),[bracos,grande(X),chao(X),topo(X)],[bracos(X,X)],[bracos,chao(X),topo(X)]).
accao(pegaG2(X),[bracos,grande(X),sobre(X,Y),topo(X)],[bracos(X,X),topo(Y)],[bracos,topo(X),sobre(X,Y)]).
accao(pegaG3(X),[bracos,grande(X),sobre(X,Y,Z),topo(X)],[bracos(X,X),topo(Y),topo(Z)],[bracos,topo(X),sobre(X,Y,Z)]).

%apanha com o 1º braço 

accao(pegaP11(X),[bracos,pequeno(X),topo(X),chao(X)],[bracos(X)],[topo(X),bracos,chao(X)]).
accao(pegaP12(X),[bracos,pequeno(X),sobre(X,Y),topo(X)],[bracos(X),topo(Y)],[topo(X),sobre(X,Y),bracos]).
accao(pegaP13(X),[bracos,pequeno(X),topo(X),sobre(A,X,B)],[bracos(X),sobre(A,B)],[topo(X),bracos,sobre(A,X,B)]).

%apanha com o 2º braço
accao(pegaP21(X),[bracos(Y),pequeno(X),topo(X),pequeno(Y),chao(X)],[bracos(Y,X)],[topo(X),bracos(Y),chao(X)]).
accao(pegaP22(X),[bracos(Y),pequeno(X),topo(X),pequeno(Y),sobre(X,B)],[bracos(Y,X),topo(B)],[topo(X),bracos(Y),sobre(X,B)]).


%coloca no chao 
accao(colocaChao1(X),[bracos(X,X)],[chao(X),bracos,topo(X)],[bracos(X,X)]).
accao(colocaChao2(X,Y),[bracos(X,Y)],[chao(X),chao(Y),topo(X),topo(Y),bracos],[bracos(X,Y)]).

%coloca grande sobre grande ou pequeno sobre pequeno
accao(colocaSobre1(X,Y),[bracos(X),pequeno(X),pequeno(Y),topo(Y)],[sobre(X,Y),topo(X),bracos],[bracos(X),topo(Y)]).
accao(colocaSobre2(X,Y),[bracos(X,X),grande(X),grande(Y),topo(Y)],[sobre(X,Y),topo(X),bracos],[bracos(X,X),topo(Y)]).

%coloca 2 pequenos sobre grande
accao(colocaSobre1(X,Y,Z),[bracos(X,Y),pequeno(X),pequeno(Y),grande(Z),topo(Z)],[topo(X),topo(Y),sobre(X,Y,Z),bracos],[bracos(X,Y),topo(Z)]).

%coloca grande sobre 2 pequenos
accao(colocaSobre2(Z,X,Y),[bracos(Z,Z),pequeno(X),pequeno(Y),grande(Z),topo(X),topo(Y), sobre(X,Y,_)],[sobre(Z,X,Y),bracos,topo(Z)],[bracos(Z,Z),topo(X),topo(Y)]).
accao(colocaSobre3(Z,X,Y),[bracos(Z,Z),pequeno(X),pequeno(Y),grande(Z),topo(X),topo(Y), chao(Y),chao(X)],[sobre(Z,X,Y),bracos,topo(Z)],[bracos(Z,Z),topo(X),topo(Y)]).




pegaG2(d), colocaChao1(d), pegaP12(c), pegaP21(b), colocaSobre1(b,c,d), pegaG1(a), colocaSobre2(a,b,c)