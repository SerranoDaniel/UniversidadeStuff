import sys
import copy

import ply.lex as lex 
import ply.yacc as yacc

from lexer import *
from parser import *
from tree import *

#Creates the tree
global tree
tree = Tree()


#Delete lists
def list_clear():
    tree.clear()
    nodes.clear()
    rep.clear()
    vars.clear()

### Alpha Conversion ##

#Returns a letter from alfa
def random_alfa(alfa):
    for i in alfa:
        return i


#Creates the Tree
def createTree():
    currentnode = nodes[0]
    insertNodes(1, currentnode)

    return currentnode


#Inserts nodes to create a tree
def insertNodes(i, currentnode):
    #If the node its an aplication
    if currentnode.kind == 'apl':
        if not currentnode.right:
            currentnode.insertRightNode(nodes[i])
            i += 1

            #If it is an abstraction
            if nodes[i-1].kind == 'abs':
                i = insertNodes(i, currentnode.right)
            
            if i <= len(nodes) - 1:
                currentnode.insertLeftNode(nodes[i])
                i += 1

                #If it is an abstraction
                if nodes[i-1].kind == 'abs':
                    i = insertNodes(i, currentnode.left)
         
        #If there is a node.left and its an aplication
        if currentnode.left and currentnode.left.kind == 'apl':
            if i <= len(nodes) -1:
                i = insertNodes(i, currentnode.left)

        #If there is a node.right and its an aplication
        if currentnode.right and currentnode.right.kind == 'apl':
            if i <= len(nodes) -1:
                i = insertNodes(i, currentnode.right)

    #If it is an abstraction
    if currentnode.kind == 'abs':
        currentnode.insertRightNode(nodes[i])
        i += 1

        #Goes to the right if there is a node and it isnt a var
        if currentnode.right and currentnode.right.kind != 'var': 
            if i <= len(nodes) -1:
                i = insertNodes(i, currentnode.right)

    return i


#Checks repetitions and replaces repeated letters
def checkRep(free):
    alfa = ['a','b','c','d','e','f','g','h',
            'i','j','k','l','m','n','o','p','q',
            'r','s','t','u','v','x','w','y','z']
    
    #Remove letters of the bound variables from the list alfa
    commonalities = set(alfa) - (set(alfa) - set(rep))
    for i in commonalities:
        alfa.remove(i)

    #Remove letters of free vars from the list alfa
    commonalities2 = set(alfa) - (set(alfa) - set(free))
    for i in commonalities2:
        alfa.remove(i)

    #If there is duplicates replace them with another letter
    for i in free:
        if i in rep:
            letter = random_alfa(alfa)
            tree.replace(i, letter, True)
            alfa.remove(letter)
    
    #if true -> there are duplicates of bound variables
    if not len(set(rep)) == len(rep):
        for i in rep:
            letter = random_alfa(alfa)
            tree.replace(i, letter, True)
            alfa.remove(letter)
    

#Identify free variables
def freeVar():
    free = []

    #Adds bound variables to the free list
    tree.findFreeVars(free)

    #Remove bound vars from allvars = free
    for n in free:
        if n in vars:
            vars.remove(n)
    
    #vars = free
    return vars


### Beta Reduction ###
#Checks if we need a reduction
def call(rootnode):
    #Checks if the root is an application 
    #and if there is an abstraction in the tree
    if rootnode.kind == 'apl' and rootnode.findAbs():
        callByValue(rootnode)
        return True

    else:
        return False

#Implementation of the call by value strategy
def callByValue(node):
    #Use recursion to go to the most left node
    if node.left:
        callByValue(node.left)
    
    #Check if the node is an application
    if node.kind == 'apl':
        if node.left.kind == 'abs':
            a = node.left.left.value #Saves the abstraction value 
            #Checks if there is a need for reduction (cnodes > 0)
            cnodes = countNodes(node.left.right, node.left.left.value)
            
            if cnodes > 0:
                tempnode = copy.deepcopy(node.left.right)
                node.left = tempnode

                #Replaces all nodes needed (Recursion)
                replaceNodeRec(node.left, a, node.right)
                
                #Node = node.left
                tempnode = copy.deepcopy(node.left)
                replaceNode(node, tempnode)

        
                #If there is still an application to be made replace nodes
                if node.kind == 'apl':
                    pass

                #Check if the node is an abstraction    
                elif node.kind == 'abs':
                    if node.right:
                        callByValue(node.right)
        


#Replaces nodes with newnode (Recursion)
def replaceNodeRec(node, a, newnode):
    if node:
        if node.kind == 'var' and node.value == a:
            replaceNode(node, newnode)

        elif node.kind == 'apl':
            replaceNodeRec(node.left, a, newnode)
            replaceNodeRec(node.right, a, newnode)
        
        elif node.kind == 'abs':
            replaceNodeRec(node.right, a, newnode)
            


#Counts the amount of variables to change
def countNodes(node, a):
    counter = 0
    if node:
        if node.kind == 'var':
            if a != None and a == node.value:
                return 1
            else:
                return 0
        
        elif node.kind == 'abs':
            counter += countNodes(node.right, a)
            return counter

        elif node.kind == 'apl':
            counter += countNodes(node.left, a)
            counter += countNodes(node.right, a)
            return counter


#Replace node with newnode
def replaceNode(node, newnode):
    nw = copy.deepcopy(newnode)

    node.value = nw.value
    node.kind  = nw.kind
    node.par   = nw.par
    node.left  = nw.left
    node.right = nw.right

#Searches for abstraction and saves their vars in rep
def updateRep(node):
    if node.left:
        if node.left.kind == 'abs':
            rep.append(node.left.left.value)
            uptRep(node.left.right)
        
        else:
            updateRep(node.left)
    
    if node.right:
        if node.right.kind == 'abs':
            rep.append(node.right.left.value)
            uptRep(node.right.right)
        
        else:
            updateRep(node.right)


def uptRep(node):
    if node.kind == 'var':
        vars.append(node.value)
    
    else:
        if node.left:
            uptRep(node.left)
        
        if node.right:
            uptRep(node.right)



### Run ###
def run(s):
    #Parser
    result = parser.parse(s)

    #Creates root and adds to the tree
    node = createTree()
    tree.setRoot(node)

    #Prints tree
    print("<-",end='')
    tree.printTree()
    
    #Alpha Conversion 
    #Checks for free vars and replaces repeated letters
    checkRep(freeVar())

    #New Alpha Tree
    print("->",end='')
    tree.printTree()


    #Beta Reduction
    b = True
    while b:
        if call(tree.root):
            #Deletes lists
            rep.clear()
            vars.clear()

            #Updates vars and replaces them if needed
            updateRep(tree.root)
            checkRep(freeVar())
            
            #Call by value
            b = call(tree.root)
        else:
            b = False
    
    #New Beta Tree
    print("->",end='')
    tree.printTree()
    
    #Delete lists 
    list_clear()



if __name__ == "__main__":
    lexer = lex.lex()
    parser = yacc.yacc()

    while True:
        print("Interpretador de Calculo Lambda")
        print("Menu:")
        print("1 para ler do ficheiro")
        print("2 para inserir input")
        try:
            o = int(input('> '))

            if o == 1:
                file = open("exemplos.txt", "r")
                for line in file:
                    print("Input: ", end='')
                    print(line)
                    run(line.rstrip('\n'))
                    print(" ")
                file.close()

            elif o == 2:
                try:
                    s = input('>> ')
                except EOFError:
                    break
                if not s: continue 
                run(s)
               

        except EOFError:
            break
        if not o: continue 

        
        
