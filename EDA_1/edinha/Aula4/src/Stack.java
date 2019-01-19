/**
 * Created by User on 16/10/2017.
 */
public interface Stack<E>{
    public void push(E o) throws FullException;
    public E top() throws EmptyException;
    public E pop() throws EmptyException;
    public int size();
    public boolean empty();
}
