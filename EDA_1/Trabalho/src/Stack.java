
public class Stack<E> implements StackInterface<E> {

	private E[] stack;
	private int cont = -1;
	
	
	public Stack(int size){
		stack = (E[]) new Object[size];
	}
	public void push(E o){
		cont++;
		stack[cont] = o;		
	}
	public boolean empty() {
		return cont == -1;
	}
	public E pop() {
		E obj = stack[cont];
		stack[cont--] = null;
		return obj;
	}
	public int size() {
		return cont+1;
	}
	public E top() {
		if(cont == -1){
			return null;
		}else{
			return stack[cont];
		}
	}
	
	public String toString(){
		String abc = "";
		for(int i=cont; i>-1; i--){
			abc += stack[i]+" | ";			
		}
		return abc;
	}	
}