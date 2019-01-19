package EDA1;

/**
 * Created by User on 22/12/2017.
 */
public interface Queue<T> {
    public void enqueue(T o) throws OverflowException;
    public T front() throws EmptyException;
    public T dequeue() throws EmptyException;
    public int size();
    public boolean empty();
}
