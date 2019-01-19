/**
 * Created by JoaoManuel on 06/11/2017.
 */
public class LinkedListIterator<E> implements java.util.Iterator<E> {

    private SingleNode<E> current;

    public LinkedListIterator(SingleNode<E> c) {
        current = c;
    }

    public boolean hasNext() {
        return current != null;
    }

    public E next() {
        if (!hasNext())
            throw new java.util.NoSuchElementException();

        E nextItem = null;

        try {
            nextItem = current.element();
        }
        catch (InvalidNodeException e) {
            e.printStackTrace();
        }
        current = current.getNext();
        return nextItem;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

}
