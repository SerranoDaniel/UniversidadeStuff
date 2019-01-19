/**
 * Created by JoaoManuel on 02/10/2017.
 */
public interface FiladeEspera<T> {

    int getcomp();
    int getmax();
    int getvagas();
    boolean checkfull();
    boolean checkvoid();
    void addelement(T a);
    T getfirst();
    T removefirst();
    String toString();

}
