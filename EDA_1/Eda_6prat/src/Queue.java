/**
 * Created by User on 30/10/2017.
 */
public interface Queue<E> {
    public void enqueue(E o) throws OverflowQueueException;
    public E front() throws EmptyQueueException;
    public E dequeue() throws EmptyQueueException;
    public int size();
    public boolean empty();

}
