/**
 * Created by JoaoManuel on 11/12/2017.
 */
public class Elemento<T> {

    boolean on_off;
    T element;

    public Elemento(T x){
        on_off=true;
        element=x;
    }
}
