/**
 * Created by User on 20/11/2017.
 */
public class BNode<T  extends Comparable<? super T>> {
    T elemento;
    BNode<T> esq;
    BNode<T> dir;
    int altura;

    BNode (T e){
        elemento=e;
        esq=null;
        dir=null;
        altura = 0;
    }
    BNode(T e, BNode<T> esq, BNode<T> dir){
        elemento=e;
        this.esq=esq;
        this.dir=dir;
        altura = 0;
    }


    public String toString(){
        return elemento.toString();
    }
}
