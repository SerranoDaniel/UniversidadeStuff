import random

def menu():
    print('Bem-vindo ao Drench!')
    print('0 -> Sair')
    print('1 -> Unico Jogador')
    print('2 -> IA')
    Escolha = input('Digite a sua escolha: ')
    if (Escolha == '0'):
        print('Obrigado, volte sempre!')
        exit
    elif (Escolha == '1'):
        print('MODO UNICO JOGADOR!')
        print('1 -> Carregar tabuleiro')
        print('2 -> Gerar tabuleiro')
        Escolha2 = input('Digite a sua escolha: ')
        if (Escolha2 == '1'):
            print('Carregar tabuleiro!')
        elif (Escolha2 == '2'):
            print('Gerar tabuleiro!')
            tabuleiro = gerar_tabuleiro()
            tab_org(tabuleiro)
        else:
            print('A escolha nao consta nas opcoes!')
            menu()
    elif (Escolha == '2'):
        print('MODO IA!')
        print('1 -> Carregar Tabuleiro')
        print('2 -> Gerar Tabuleiro')
        Escolha2 = input('Digite a sua escolha: ')
        if (Escolha2 == '1'):
            print('Carregar tabuleiro no modo IA!')
        elif (Escolha2 == '2'):
            print('Gerar tabuleiro no modo IA!')
            tabuleiro = gerar_tabuleiro()
            tab_org(tabuleiro)
        else:
            print('A escolha nao consta nas opcoes!')
            menu()
    else:
        print('A escolha nao consta nas opcoes!')
        menu()


#Gera o tabuleiro

def gerar_tabuleiro():
    dim = int(input('Insira a dimensao do tabuleiro em que pretende jogar:\n'))
    tabuleiro = []
    for linha in range(dim):
        tabuleiro.append([])
        for coluna in range(dim):
            ajuda = int(len(tabuleiro))
            ajuda_div2 = int(len(tabuleiro) / 2)
            ajuda_div3 = int(len(tabuleiro) / 3)
            
#Manipulação dos valores gerados no tabuleiro
            
            if coluna == random.randint(0, ajuda_div2):
                numeros_certos = (1,1,2,2,2,2,3,3,3,3,4,1,6,6,6)
                num_notrandom = random.choice(numeros_certos)
                tabuleiro[linha].append(num_notrandom)
            elif coluna == random.randint(ajuda_div2, ajuda):
                numeros_certos = (4,5)
                num_notrandom = random.choice(numeros_certos)
                tabuleiro[linha].append(num_notrandom)
            elif coluna == random.randint(ajuda_div3, ajuda_div2):
                numeros_certos = (6,6)
                num_notrandom = random.choice(numeros_certos)
                tabuleiro[linha].append(num_notrandom)
            elif coluna == random.randint(ajuda_div3, ajuda):
                numeros_certos = (1,2,5)
                num_notrandom = random.choice(numeros_certos)
                tabuleiro[linha].append(num_notrandom)
            else:            
                numeros = random.randint(1,6)
                tabuleiro[linha].append(numeros)
    return tabuleiro

#Output do tabuleiro organizado

def tab_org(tabuleiro):
    for x in range(len(tabuleiro)):
        print(' ')
        print('----' * len(tabuleiro))
        for y in range(len(tabuleiro)):
            print((tabuleiro[x][y]), end= ' | ')


menu()
