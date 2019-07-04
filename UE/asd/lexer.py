import ply.lex as lex 

tokens = [
    'DOT',
    'VAR',
    'RPAR',
    'LPAR',
    'LAMBDA', 
    ]

t_DOT = r'\.'

def t_VAR(t):
    r'[a-zA-Z_]'
    t.type = 'VAR'
    return t

t_LAMBDA = r'\!'

t_RPAR = r'\)'
t_LPAR = r'\('

t_ignore = ' '

def t_error(t):
    print('Ilegal Character!!!')
    t.lexer.skip(1)


precedence = (
    ('right', 'DOT'),
    ('left', 'RPAR'),
    ('right', 'LPAR'), 
    ('left', 'VAR'),
    ('left', 'APL'),
)