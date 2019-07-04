import ply.yacc as yacc

from tree import *

global nodes
global rep
global vars

nodes = []
rep = []
vars = []

def p_aplicacao(p):
    '''
    Termo : Termo Termo  %prec APL
          | LPAR Termo Termo RPAR
    '''
    if len(p) == 3:
        nodes.insert(0, Node('-', 'apl'))

    elif len(p) == 5:
        nodes.insert(0, Node('-', 'apl', 1))


def p_abstracao(p):
    '''
    Termo : LAMBDA VAR DOT Termo
          | LPAR LAMBDA VAR DOT Termo RPAR
    '''
    if len(p) == 5:
        b = Node('-', 'abs')
        b.left = Node(p[2], 'var')
        nodes.insert(0, b)
        rep.append(p[2])

    elif len(p) == 7:
        b = Node('-', 'abs', 1)
        b.left = Node(p[3], 'var')
        nodes.insert(0, b)
        rep.append(p[3])


def p_variavel(p):
    '''
    Termo : VAR
          | LPAR VAR LPAR
    '''
    if len(p) == 2:
        nodes.insert(0, Node(p[1], 'var'))
        vars.append(p[1])
    elif len(p) == 4:
        nodes.insert(0, Node(p[1], 'var', 1))
        vars.append(p[1])


def p_error(p):
    print(p)
    print("Syntax error in input!")