import java.util.*;
public class LinkedList<T> implements Iterable<T> {
	
	private SingleNode<T> header;
	private SingleNode<T> last;
	private int theSize;
	
	public LinkedList() {
		header = new SingleNode<T>();
		last = header;
		theSize = 0;
	}
	
	public java.util.Iterator<T> iterator(){
		return new LinkedListIterator<T>(header.getNext());
			}
	
	public int size() {
		return theSize;		
	}
	
	public boolean isEmpty() {
		return header == last;
	}
	
	public void remove(int i) {
		SingleNode<T> current = header;
		if(i < theSize) {
			for(int k=0; k<i-1; k++) {
				current = current.getNext();
			}
			
			current.setNext(current.getNext().getNext());
			theSize--;
		}
	}
	
	public void remove(T x) throws InvalidNodeException{
		SingleNode<T> current = header;
		while(current.getNext() != null) {
			if(current.getNext().element() == x) {
				current.setNext(current.getNext().getNext());
				theSize--;
			}
			
			current = current.getNext();
		}
		
	}
	
	public void add(T x) {
		//Adiciona x no fim da fila
		SingleNode<T> novo = new SingleNode<T>(x);
		last.next = novo;
		last = novo;
		theSize++;
	}
	
	public void add(int i, T x) {
		SingleNode<T> current = header;
		SingleNode<T> novo = new SingleNode<T>(x);
		while(current.getNext() != null) {
			if(i == 0) {
				novo.setNext(current.getNext());
				current.setNext(novo);
				theSize++;
			}
			
			current = current.getNext();
			i--;
		}
	}
	
	public T get(int i) throws InvalidNodeException{
		SingleNode<T> current = header;
		while(current.getNext() != null) {
			if(i == 0) {
				return current.getNext().element();
			}
			
			current = current.getNext();
			i--;
		}
		
		return null;
		
	}
	
	public void set(int i, T x) {
		SingleNode<T> current = header;
		while(current.getNext() != null) {
			if(i == 0) {
				current.getNext().setElement(x);
			}
			
			current = current.getNext();
			i--;
		}
	}
	
	public String toString() {
		LinkedListIterator i = (LinkedListIterator) iterator();
		String s = "";
		while(i.hasNext()) {
			s += i.next().toString() + "\n";
		}
		
		return s;
		
	}
}
