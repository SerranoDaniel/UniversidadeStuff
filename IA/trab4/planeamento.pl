
seguinte(0,1).
seguinte(1,2).
seguinte(2,3).

%estado inicial - 0
estado_inicial([mao([]), conteudo(1,a), conteudo(2,b), conteudo(3,c), fechada(1), fechada(2), fechada(3), fechada(0)] ).

%estado final - 1
estado_1([mao([]), conteudo(1,a), conteudo(2,b), conteudo(2,c), fechada(1), fechada(2), fechada(3), fechada(0)] ).

%estado final - 2
estado_2([mao([]), conteudo(2,a), conteudo(2,c), conteudo(3,b), fechada(1), fechada(2), fechada(3), fechada(0)] ).

%estado final alternativo
estado_final([conteudo(3,a), conteudo(2,b), conteudo(3,c), fechada(1), fechada(2), fechada(3)]). 

%##############################################################################################################%

% accao(a,Precondicao,AdicionaLista,DeleteLista).

%fechar gaveta
accao(fechaGav(G),[aberta(G)],[fechada(G)],[aberta(G)]) :- member(G,[1,2,3]).

%abrir gaveta
accao(abreGav(G),[mao([]), fechada(G)],[aberta(G)],[fechada(G)]) :- member(G,[1,2,3]).

%coloca objeto
accao(colocaObj(G,O), [mao(O), aberta(G), fechada(G1)], [conteudo(G,O), mao([])], [mao(O)]):- seguinte(G1,G), member(O, [a,b,c]).

%retira objeto
accao(tiraObj(G,O), [mao([]), aberta(G), conteudo(G,O), fechada(G1)], [mao(O)], [conteudo(G,O), mao([])]):- seguinte(G1,G), member(O, [a,b,c]).


% Plano = [s1-inicial,s243-abreGav(1),s244-abreGav(3),s242-tiraObj(1,a),s241-colocaObj(3,a),s245-fechaGav(1),s246-fechaGav(3),s2-final]





