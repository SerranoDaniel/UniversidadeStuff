package EDA1;

/**
 * Created by User on 25/12/2017.
 */
public class DoubleLinkedListIterator<T> implements java.util.Iterator<T> {

    private Node<T> current;

    public DoubleLinkedListIterator(Node<T> c) {
        current = c;
    }

    public boolean hasNext() {
        return current != null;
    }

    public T next() {
        if (!hasNext())
            throw new java.util.NoSuchElementException();

        T nextItem = null;

        try {
            nextItem = current.elemento();
        }
        catch (InvalidNodeException e) {
            e.printStackTrace();
        }
        current = current.getRight();
        return nextItem;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}

