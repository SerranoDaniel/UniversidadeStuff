import java.util.*;

public class SingleNode<T> {
	
	//variaveis declaradas
	T elemento;
	SingleNode<T> next;
	
	//construtor da classe
	public SingleNode(T x) {
		elemento = x;
		next = null;
	}
	
	//construtor vazio
	public SingleNode() {
		this(null);
	}
	
	//construtor com elemento e next
	public SingleNode(T x, SingleNode<T> n) {
		elemento = x;
		next = n;
	}
	
	//metodos
	public T element() throws InvalidNodeException{
		if(this == null) {
			throw new InvalidNodeException("Null node");
		}
		
		return elemento;
	}
	
	public SingleNode<T> getNext(){
		return next;
	}
	
	public void setElement(T x) {
		this.elemento = x;
	}
	
	public void setNext(SingleNode<T> n) {
		next = n;
	}
}
