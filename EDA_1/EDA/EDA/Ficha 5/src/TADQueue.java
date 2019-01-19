
public interface TADQueue<E> {

		 public void enqueue(E o) throws OverflowQueueException;
		 public E front() throws EmptyQueueException;
		 public E dequeue() throws EmptyQueueException;
		 public int size();
		 public boolean empty();
		 
}
