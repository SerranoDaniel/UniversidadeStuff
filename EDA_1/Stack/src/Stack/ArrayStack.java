package Stack;
public class ArrayStack<E> implements Stack<E> {
	private  static final int capacity =100;
	private E[] x;
	private int t=-1;
	
	ArrayStack(){
		this(capacity);
	}
	
	ArrayStack(int cap){
		x=  (E[]) new Object[capacity];
	}
	
	public int size(){
		return t+1;
	}
	
	public boolean isEmpty(){
		return t==-1;
	}
	
	public void push(E e) throws IllegalStateException{
		if(size()==x.length)  throw new IllegalStateException("Stack is full");
		t++;
		x[t]=e;
	}
	
	public E top(){
		if(isEmpty()){
			return null;
		}
		return x[t];
	}
	
	public E pop(){
		if(isEmpty()){
			return null;
		}
		E temp = x[t];
		t--;
		return temp;
	}
	
	public String toString(){
		String s= new String();
		for(int i=t; i>=0; i--){
			s+= x[i] +" ";			
		}
		return s;
	}	

}
