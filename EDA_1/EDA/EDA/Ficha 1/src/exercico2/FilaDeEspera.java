package exercico2;

public interface FilaDeEspera<T> {
	public int size();
	public int maxSize();
	public int places();
	
	public boolean isFull();
	public boolean isEmpty();
	
	public void add(T object);
	
	public T front();
	public T remove();
	
	public String toString();
}
