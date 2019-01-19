package EDA1;

/**
 * Created by User on 21/12/2017.
 */
public interface Stack<T>{
    public void push(T o) throws FullException;
    public T top() throws EmptyException;
    public T pop() throws EmptyException;
    public int size();
    public boolean empty();
}
