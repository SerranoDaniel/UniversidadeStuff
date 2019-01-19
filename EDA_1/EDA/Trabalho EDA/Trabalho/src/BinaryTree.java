
public class BinaryTree<E extends Comparable<? super E>> implements BTinterface<E> {
	private int cont=0;
	private Stack<Node<E>> stack = new Stack<Node<E>>(100);
		
	public boolean isEmpty(){
		return cont==0;
	}
	public Node<E> getRaiz(){
		return stack.top();
	}
	private boolean isOperator(E s){
		if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")){
			return true;
		}
		return false;
		
	}
	public void insert(E x){
		if(isOperator(x)){
			Node<E> n = new Node<E>(x);
			n.right = stack.pop();
			n.left = stack.pop();
			stack.push(n);
			cont++;
		}else{
			Node<E> n = new Node<E>(x);
			stack.push(n);
			cont++;
		}
			
	}/*
	public void printEmOrdem(){
		printEmOrdem(raiz);
	}
	private void printEmOrdem(Node<E> n){
		if (n!=null){
			printPosOrdem(n.left);
			System.out.print(n.data + " ");
			printPosOrdem(n.right);	
		}
	}*/
	public void printPosOrdem(){
		printPosOrdem(stack.top());
	}
	private void printPosOrdem(Node<E> n){
		if (n!=null){
			printPosOrdem(n.left);
			printPosOrdem(n.right);
			System.out.print(n.data + " ");
		}
	}/*
	public void printPreOrdem(){
		printPreOrdem(raiz);
	}
	private void printPreOrdem(Node<E> n){
		if(n!=null){	
			System.out.print(n.data + " ");
			printPreOrdem(n.left);
			printPreOrdem(n.right);
		}
	}*/
	public int altura(){
		return altura(stack.top());
	}
	private int altura(Node<E> r){
		if(r == null)
			return 0;
		else 
			return 1 + Math.max(altura(r.left), altura(r.right));
	}
	  
	private void addTree(Node<E> x, int coordX, int coordY, GraphDraw f,int j,int nivel,int larg){
	    if(x!=null){
	      f.addNode(x.toString(), coordX,coordY);
	      int i=f.nodesSize()-1;
	      //System.out.println(i);
	      if(j!=-1){
	        f.addEdge(j,i);  
	      }
	      int n=(int)Math.pow(2,nivel);
	      int dist=larg/(2*n);
	      if(x.left!=null)
	        addTree(x.left,coordX-dist,coordY+50,f,i,nivel+1,larg);
	      
	      if (x.right!=null) 
	        addTree(x.right,coordX+dist ,coordY+50,f,i,nivel+1,larg);
	      
	    }
	    
	 }
	 public void draw(String s){
	    GraphDraw frame = new GraphDraw(s);
	    int h=altura();
	    int d=30;
	    int nos_nivel_h=(int) Math.pow(2,h+1);
	    //System.out.println(nos_nivel_h);
	    
	    int larguraFrame=d*(nos_nivel_h +1);
	    int alturaFrame=70*(h+1);
	    //System.out.println(alturaFrame);
	    //System.out.println("Largura="+larguraFrame);
	    frame.setSize(larguraFrame,alturaFrame);
	 
	    frame.setVisible(true);
	    if (!isEmpty()){
	      addTree(stack.top(), larguraFrame/2,50,frame,-1,1,larguraFrame); 
	    }    	  
	    else{
	    	frame.setSize(50,150);
	    }
	      
	    
	    
	  }
}
