class Node:
    def __init__(self, value, kind, par=None, left=None, right=None):
        self.value  = value
        self.kind   = kind
        self.par    = par
        self.left   = left
        self.right  = right
       

    #Inserts the Node into the self.left
    def insertLeftNode(self, Node):
        if not self.left:
            self.left = Node
    
    #Inserts the Node into the self.right
    def insertRightNode(self, Node):
        if not self.right:
            self.right = Node

    #Adds free variables to the free list
    def findFreeVars(self, free):
        #If it is an abstraction search right node
        if self.kind == 'abs':
            free.append('abs')
            free.append(self.left.value)

            self.right.findFreeVars(free)

            free.remove('abs')
            free.remove(self.left.value)

        #If it is a variable and bound append to the free list
        elif self.kind == 'var':
            for i in range(0, len(free)):
                if free[i-1] == 'abs' and self.value == free[i]:
                    free.append(self.value)
                        
        
        else:
            if self.left:
                self.left.findFreeVars(free)
            if self.right:
                self.right.findFreeVars(free)

            
    #Replaces value with newvalue in the tree
    def replace(self, value, newvalue, b):
        if self.kind == 'abs' and self.left.value == value:
            if b:
                self.left.value = newvalue

                b = False
                self.right.replaceall(value, newvalue, b)
                return b

        else:
            if self.left and b:
                b = self.left.replace(value, newvalue, b)

            if self.right and b:
                b = self.right.replace(value, newvalue, b)

            return b
    

    def replaceall(self, value, newvalue, b):
        if self.kind == 'abs' and self.left.value == value and not b:
            pass
        
        elif self.kind == 'var' and self.value == value:
            self.value = newvalue
        
        else:
            if self.left:
                self.left.replaceall(value, newvalue, b)
            if self.right:
                self.right.replaceall(value, newvalue, b)

    #Returns true if there is an abstraction
    def findAbs(self):
        if self.kind == 'abs':
            return True
        else:
            if self.left:
                return self.left.findAbs()
            
            if self.right:
                return self.right.findAbs()
        
            return False


    #Prints tree
    def printTree(self):
        if self:
            if self.par != None:
                print('(', end='')

            if self.kind == 'abs':
                print('!', end='')
                if self.left:
                    self.left.printTree()
                if self.right:
                    print('.', end='')
                    self.right.printTree()

                if self.par != None:
                    print(')', end='')
                       
            elif self.kind == 'apl':
                if self.left:
                    self.left.printTree()
                if self.right:
                    self.right.printTree()

                if self.par != None:
                    print(')', end='')
            
            elif self.kind == 'var':
                print(self.value, end='')
                if self.left:
                    self.left.printTree()
                if self.right:
                    self.right.printTree()
                    
                if self.par != None:
                    print(')', end='')                



class Tree:
    def __init__(self):
        self.root = None
    
    #Sets the root = node
    def setRoot(self, node):
        self.root = node
        return self.root
    
    #Inserts a node into the tree
    def insertNode(self, Node, dir):
        if self.root:
            return self.root.insertNode(Node, dir)
        else:
            self.root = Node
            return self.root

    #Adds free variables to the free list
    def findFreeVars(self, free):
        if self.root:
            return self.root.findFreeVars(free)
        else:
            return False

    #Replaces value with new value in the tree
    def replace(self, value, newvalue, b):
        if self.root:
            return self.root.replace(value, newvalue, b)
        else:
            return False

    #Returns true if there is an abstraction
    def findAbs(self):
        if self.root:
            return self.root.findAbs()
        else:
            return False
    
    #Prints the tree
    def printTree(self):
        if self.root:
            self.root.printTree()
            print("")
    

    #Deletes the tree
    def clear(self):
        self.root = None
