import sys
import random
sys.setrecursionlimit(10000)

class Tree:
    def __init__(self, cargo, left=None, right=None):
        self.cargo = cargo
        self.left  = left
        self.right = right

    def __str__(self):
        return str(self.cargo)

    @staticmethod
    def print_tree(tree):
        if tree == None: 
            return
        cenas = [tree.cargo]
        if tree.left != None:
            cenas.append(Tree.print_tree(tree.left))
        if tree.right != None:
            cenas.append(Tree.print_tree(tree.right))
        return cenas
    
    @staticmethod
    def retInput(tree, teste):
        if tree[0] == '@':
            teste = teste + '(' + Tree.retInput(tree[1], teste) + ')' + '(' + Tree.retInput(tree[2], teste) + ')'
        elif tree[0] == '!':
            teste = teste + '!' + Tree.retInput(tree[1], teste) + '.' + Tree.retInput(tree[2], teste)
        else:
            teste = teste + tree[0]
        return teste


    @staticmethod
    def alphaEquiv(teste, carStack):
        u = 1
        while u < len(teste) - 1:
            if teste[u] not in ['!', '.', '(', ')']:
                if teste[u - 1] == '(' and teste[u + 1] == ')':
                    esq = teste[:u-1]
                    dire = teste[u+2:]
                    teste = esq + teste[u] + dire
                    u -= 2
            u += 1
        if teste[0] == '(' and teste[1] == '(':
            teste = teste[1:]
            teste = teste[:len(teste)-2] + teste[len(teste)-1]
        
        try:
            x = teste.split(')(')
            if len(x) > 1:
                for i in x[0]:
                    randomchar = Tree.randomLetter(carStack)
                    if i != '!' and i != '.' and i in x[1]:
                        x[0] = x[0].replace(i, randomchar)
                        
                teste = x[0] + ')(' + x[1]
        except:
            pass


        if teste[0] == '(' and teste[len(teste)-1] not in ['(', ')']:
            for i in range(len(teste) - 1):
                if teste[i] == teste[len(teste)-1]:
                    teste = teste[:len(teste)-1].replace(teste[len(teste)-1], Tree.randomLetter(carStack)) + teste[len(teste)-1]


        return teste
        

    @staticmethod
    def randomLetter(carStack):
        listLetter = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']
        letter = ''
        while letter == '' or letter in carStack:
            letter = random.choice(listLetter)
        return letter

    @staticmethod
    def fazerReducao(expressao):
        count = expressao.count('(')
        if(expressao[len(expressao)-1] != ')'):
            count += 1
        
        groups = [[] for i in range(count)]
        
        
        i = 0
        for x in expressao:
            groups[i].append(x)
            if(x == ')'):
                i += 1

        while(len(groups) != 1):
            if groups[0][len(groups[0]) - 3] == ')':
                groups[0] = Tree.fazOutra([groups[0]])[0]
            elif(len(groups[1]) != 1):
                groups = Tree.fazCenas(groups)
            else:
                groups = Tree.parLetter(groups)
        
        if len(groups[0]) != 1 and groups[0][len(groups[0]) - 3] == ')':
            groups[0] = Tree.fazOutra([groups[0]])[0]
            
        
        if(groups[0][0] == '('):
            groups[0].pop(0)
            groups[0].pop(len(groups[0])-1)

        reduzida = ''.join(groups[0])

        return reduzida

    

    def parLetter(expressao):
        listLetter = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']
        sub = ''
        savePos = -1
        lastChecked = -1
        saveLetter = ''

        for x in range(len(expressao)):
            if ((expressao[x] in listLetter) and (expressao[x-1] == ')')):
                sub = expressao[x]
                expressao = expressao[:x] + expressao[(x+1):]
                savePos = x

        for x in range(len(expressao)):
            if(expressao[x][0] in listLetter):
                sub = expressao[x][0]
                savePos = x
                break
                
        if(savePos != -1):
            saveLetter = expressao[savePos-1][2]
            for k in range(len(expressao[savePos-1])):
                if(expressao[savePos-1][k] == saveLetter and k != 2):
                    expressao[savePos-1][k] = sub
            expressao[savePos-1].pop(1)
            expressao[savePos-1].pop(1)
            expressao[savePos-1].pop(1)
            del expressao[savePos]
            
        return expressao

    def fazCenas(expressao):
        index = expressao[0].index('!')
        saveLetter = expressao[0][index+1]
        for k in range(len(expressao[0])):
            if(expressao[0][k] == saveLetter and k != (index + 1)):
                expressao[0].pop(k)
                for x in reversed(expressao[1]):
                    expressao[0].insert(k, x)
                break
        expressao.pop(1)
        expressao[0].pop(index)
        expressao[0].pop(index)
        expressao[0].pop(index)

        if(expressao[0][1] == '(' and expressao[0][len(expressao[0])-2] == ')'):
            expressao[0].pop(0)
            expressao[0].pop(len(expressao[0])-1)

        return expressao
    
    def fazOutra(expressao):
        listLetter = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']
        sub = ''
        for x in range(len(expressao[0])-1, 0,-1):
            if expressao[0][x] in listLetter:
                j = [expressao[0][x]]
                expressao.insert(1, j)
                sub = expressao[0][x]
                expressao[0] = expressao[0][:x] 
                break

        aux = []
        for x in range(len(expressao[0])-1, 0,-1):
            if expressao[0][x] == '(':
                aux.append(expressao[0][x])
                expressao[0].pop(x)
                break
            else:
                aux.append(expressao[0][x])
                if x != len(expressao[0])-1:
                    expressao[0].pop(x)


        expressao.insert(1, aux[::-1])
        
        Tree.parLetter([expressao[1], expressao[2]])[0]
        expressao.pop(2)
        expressao[0].insert(len(expressao[0])-1, expressao[1][1])
        expressao.pop(1)


        return(expressao)