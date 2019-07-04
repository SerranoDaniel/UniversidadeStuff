% vocabulário.
% pcima(C) - copo virado para cima
% pbaixo(C) - copo virado para baixo
% mao(C1,C2) - copos C1 e C2 na mão
% mvazia - mão não tem copos
% frente(C1,C2) - mão em frente aos copos C1 e C2
% viraCC(C1,C2) - vira copos C1 e C2 para cima
% viraBB(C1,C2) - vira copos C1 e C2 para baixo
% viraCB(C1,C2) - vira copo C1 para cima e copo C2 para baixo
% viraBC(C1,C2) - vira copo C1 para baico e copo C2 para cima
% desloca(C1,C2) - desloca mao para frente dos copos C1 e C2
% agarra(C1,C2) - coloca os copos C1 e C2 na mão

:-dynamic(h/2).


%estado inicial

h(pbaixo(1),s0).
h(pbaixo(2),s0).
h(pbaixo(3),s0).
h(pbaixo(4),s0).
adjacente(1,2).
adjacente(2,3).
adjacente(3,4).
%adjacente(4,1),s0).
adjacente(2,1).
adjacente(3,2).
adjacente(4,3).

h(frente(1,2),s0).

%estado final - h(pcima(1),S) , h(pcima(2),S), h(pbaixo(3),S), h(pbaixo(4),S), h(mvazia,S),h(adjacente(1,2),S), h(adjacente(2,3),S),h(adjacente(3,4),S),h(frente(1,2),S),h(adjacente(2,1),S), h(adjacente(3,2),S),h(adjacente(4,3),S).
%estado final - h(pcima(1),S) , h(pcima(2),S), h(pbaixo(3),S), h(pbaixo(4),S), h(mvazia,S),h(adjacente(1,2),S), h(adjacente(2,3),S),h(adjacente(3,4),S),h(adjacente(4,1),S),h(frente(1,2),S).

% consequencias positivas.

h(pbaixo(C1),r(viraBB(C1,C2),S)):-
  h(mao(C1,C2),S),
  h(pcima(C1),S),
  h(pcima(C2),S).

h(pbaixo(C2),r(viraBB(C1,C2),S)):-
  h(mao(C1,C2),S),
  h(pcima(C1),S),
  h(pcima(C2),S).

h(pbaixo(C2),r(viraCB(C1,C2),S)):-
  h(mao(C1,C2),S),
  h(pbaixo(C1),S),
  h(pcima(C2),S).

h(pbaixo(C1),r(viraBC(C1,C2),S)):-
  h(mao(C1,C2),S),
  h(pcima(C1),S),
  h(pbaixo(C2),S).

h(pcima(C1),r(viraCC(C1,C2),S)):-
  h(mao(C1,C2),S),
  h(pbaixo(C1),S),
  h(pbaixo(C2),S).

h(pcima(C2),r(viraCC(C1,C2),S)):-
  h(mao(C1,C2),S),
  h(pbaixo(C1),S),
  h(pbaixo(C2),S).

h(pcima(C2),r(viraBC(C1,C2),S)):-
  h(mao(C1,C2),S),
  h(pcima(C1),S),
  h(pbaixo(C2),S).

h(pcima(C1),r(viraCB(C1,C2),S)):-
  h(mao(C1,C2),S),
  h(pbaixo(C1),S),
  h(pcima(C2),S).


h(frente(C1,C2),r(desloca(C1,C2),S)):-
  adjacente(C1,C2).


h(mao(C1,C2),r(agarra(C1,C2),S)):-
  adjacente(C1,C2),
  h(frente(C1,C2),S).


% inercia

h(pcima(C1),r(A,S)):-
  h(pcima(C1),S),
  adjacente(C1,C2),
  \+ member(A,[viraBB(C1,C2),viraBC(C1,C2)]).

h(pcima(C1),r(A,S)):-
  h(pcima(C1),S),
  adjacente(C2,C1),
  \+ member(A,[viraBB(C2,C1),viraCB(C2,C1)]).

h(pbaixo(C1),r(A,S)):-
  h(pbaixo(C1),S),
  adjacente(C1,C2),
  \+ member(A,[viraCC(C1,C2),viraCB(C1,C2)]).

h(pbaixo(C1),r(A,S)):-
  h(pbaixo(C1),S),
  adjacente(C2,C1),
  \+ member(A,[viraCC(C2,C1),viraBC(C2,C1)]).

h(mao(C1,C2),r(A,S)):-
  h(mao(C1,C2),S),
  A \= larga(C1,C2).

h(frente(C1,C2),r(A,S)):-
  h(frente(C1,C2),S),
  A \= desloca(1,2),
  A \= desloca(2,3),
  A \= desloca(3,4),
  A \= desloca(4,3),
  A \= desloca(3,2),
  A \= desloca(2,1).
