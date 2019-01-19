/**
 * Created by User on 06/11/2017.
 */
public interface LinkedListInterface {
    public java.util.Iterator<T> iterator();
    public int size();
    public boolean isEmpty();
    public void remove(int i);
    public void remove(T x);
    public void add(T x); // adiciona x no fim da lista
    public void add(int i, T x);
    public T get(ind i);
    public void set(int i, T y);
    public String toString();
}
