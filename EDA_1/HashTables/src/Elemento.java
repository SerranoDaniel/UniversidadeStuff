/**
 * Created by User on 11/12/2017.
 */
public class Elemento<T>{
    T elemento;
    boolean apagado; //Se está apagado = true

    public Elemento(T elemento){
        this.elemento = elemento;
        apagado = false;
    }
}
