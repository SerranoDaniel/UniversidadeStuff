:-set_prolog_stack(local,  limit(2 000 000 000)).

%
%   5o Trabalho de IA-Planeamento
%
%
%

% lista de copos adjacentes.



adjacente(1,2).
adjacente(2,3).
adjacente(3,4).

% vocabulário.
% pcima(C) - copo virado para cima
% pbaixo(C) - copo virado para baixo
% mao(C1,C2) - copos C1 e C2 na mão
% mvazia - mão não tem copos
% viraCC(C1,C2) - vira copos C1 e C2 para cima
% viraBB(C1,C2) - vira copos C1 e C2 para baixo
% viraCB(C1,C2) - vira copo C1 para cima e copo C2 para baixo
% viraBC(C1,C2) - vira copo C1 para baico e copo C2 para cima

estado_inicial([pbaixo(1),pcima(2),pbaixo(3),pbaixo(4),mvazia]).
estado_final([pcima(1) pcima(2),pcima(3),pbaixo(4),mvazia]).

acção(agarra(C1,C2),[mvazia, adjacente(C1,C2)],[mao(C1,C2)],[mvazia]).

acção(viraCC(C1,C2),[mao(C1,C2),pbaixo(C1),pbaixo(C2)],[pcima(C1),pcima(C2),mvazia],[mao(C1,C2),pbaixo(C1),pbaixo(C2)]).

acção(viraBB(C1,C2),[mao(C1,C2),pcima(C1),pcima(C2)],[pbaixo(C1),pbaixo(C2),mvazia],[mao(C1,C2),pcima(C1),pcima(C2)]).

acção(viraCB(C1,C2),[mao(C1,C2),pbaixo(C1),pcima(C2)],[pcima(C1),pbaixo(C2),mvazia],[mao(C1,C2),pbaixo(C1),pcima(C2)]).

acção(viraBC(C1,C2),[mao(C1,C2),pcima(C1),pbaixo(C2)],[pbaixo(C1),pcima(C2),mvazia],[mao(C1,C2),pcima(C1),pbaixo(C2)]).
