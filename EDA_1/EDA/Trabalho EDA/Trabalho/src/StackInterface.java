
public interface StackInterface<E> {
	
	public void push(E o);
	public E top();
	public E pop();
	public int size();
	public boolean empty();
	
	public String toString();
}
