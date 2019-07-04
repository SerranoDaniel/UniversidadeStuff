n(7). %numero de algarismos iguais
a(5). %algarismo

estado_inicial(e(NAfect, Afect)):-
  n(N),
  a(A),
  N1 is N-1,
  numlist(1, N1, L1),
  numlist(1, N, L2),
  findall(v(p(M1), ['+', '-', '*', '/'], _), (member(M,L1), M1 is M * 2), NAfect), % listaq de operadores
  findall(v(p(M2), [], A), (member(M,L2), M2 is ((M * 2)-1)), Afect). % algoritmos afectados
