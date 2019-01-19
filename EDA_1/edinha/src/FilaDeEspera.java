/**
 * Created by User on 02/10/2017.
 */
public interface FilaDeEspera<T> {
    int getCompFila();
    int getCompMaxFila();
    int getNumVagas();
    boolean isFull();
    boolean isEmpty();
    void addElement(T num);
    T firstElement();
    T removeFirstElement();
    String toString();
}
