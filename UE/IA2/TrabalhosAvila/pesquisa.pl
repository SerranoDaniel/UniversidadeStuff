%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%


b:- consult(sodoku),
    estado_inicial(E0), 
    back(E0,A),
    esc(A).
 
back(e([],A),A).
back(E,Sol):- sucessor(E,E1), 
          restricoes(E1),
              back(E1,Sol).
 

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

f:-consult(sodoku), 
    	estado_inicial(E0), 
    	back1(E0,A),
    	write(A),nl,nl,esc(A).

back1(e([],A),A).
back1(E,Sol):- sucessor(E,E1), 
          restricoes(E1),
          forwardC(E1,E2),
              back1(E2,Sol).

%ForwardChecking
 
forwardC(e(NAfect,[v(N,D,V)|Afect]),e(NAfectS,[v(N,D,V)|Afect])):-
        actualizaDom(V, NAfect, NAfectS).
 
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%


sucessor(e([v(N,D,_)|R],E),e(R,[v(N,D,V)|E])):- member(V,D).
  
actualizaDom(_,[],[]).
actualizaDom(V,[v(N,D,_)|NAfect],[v(N,DS,_)|NAfectS]):-
    delete(D,V,DS),
    actualizaDom(V, NAfect, NAfectS).