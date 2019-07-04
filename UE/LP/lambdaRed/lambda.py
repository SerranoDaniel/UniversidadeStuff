import sys
import ply.lex as lex
import ply.yacc as yacc
from tree import *

carStack = []

tokens = [

    'LAMBDA',
    'PONTO',
    'VARIAVEL',
    'PARDIR',
    'PARESQ'
]

t_LAMBDA = r'\!'
t_PONTO = r'\.'
t_VARIAVEL = r'[a-z]'
t_PARDIR = r'\)'
t_PARESQ = r'\('
    
t_ignore = r' '


def t_error(t):
    print("Illegal Character!")
    t.lexer.skip(1)

lexer = lex.lex()

def p_termo(p):
    '''
    termo : PARESQ termo PARDIR termo
          | PARESQ termo PARDIR
          | LAMBDA VARIAVEL PONTO termo
          | VARIAVEL termo
          | VARIAVEL
    '''

    if len(p) == 5 and p[1] == '!':
        carStack.append(p[1])
        carStack.append(p[2])
        carStack.append(p[3])
    elif len(p) == 2:
        carStack.append(p[1])
    elif len(p) == 3:
        carStack.append(p[1])


parser = yacc.yacc()




while True:
    try:
        print('')
        print('Input: ')
        s = input('')
    except EOFError:
        break
    carStack = []
    r = parser.parse(s)
    

    z = 0
    while z < len(carStack):
        if z == 0:
            if len(carStack) == 1:
                a = Tree(carStack[z])
                z += 1
            elif carStack[z+1] != '!':
                auxL = Tree(carStack[z + 1])
                auxR = Tree(carStack[z])
                a = Tree('@', auxL, auxR)
                z += 2
            else:
                a = Tree(carStack[z])
                z += 1

        else:
            if carStack[z] == '!' and carStack[z-2] == '.' and z > 1:
                auxR = Tree(carStack[z + 1])
                b = Tree('!', m, auxR)
                a = Tree('@', a, b)
                z += 3
            elif carStack[z] == '!':
                auxL = Tree(carStack[z+1])
                a = Tree('!', auxL, a)
                z += 3
            elif carStack[z] != '!' and carStack[z-1] == '.' and z != len(carStack) - 1:
                if carStack[z+1] == '!':
                    m = Tree(carStack[z])
                    z += 1
                else:
                    auxR = Tree(carStack[z])
                    a = Tree('@', a, auxR)
                    z += 1
            else:
                auxR = Tree(carStack[z])
                a = Tree('@', a, auxR)
                z += 1

            
    
    arvorezinha = Tree.print_tree(a)
    print('')
    print('Arvore: ')
    print(arvorezinha)



    teste = ''
    teste = Tree.retInput(arvorezinha, teste)

    alpha = Tree.alphaEquiv(teste, carStack)

    redCom = Tree.fazerReducao(alpha)
    redSem = Tree.fazerReducao(s.replace(" ", ""))
    
    print('')
    print('<- ' + s.replace(" ", ""))
    print()
    print('Com AlphaEquivalente -> ' + redCom)
    print('Sem AlphaEquivalente -> ' + redSem)
    
    print('')
    print('')




