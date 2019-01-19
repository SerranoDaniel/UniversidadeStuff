
public interface Lista<E> {
	
	public void add(E x);
	public void add(int i, E x);
	
	public void set(int i, E x);
	public E get(int i);
	
	public void remove(E x);
	public void remove(int x);
	
	public int size();
	public boolean isEmpty();
	public String toString();
}
