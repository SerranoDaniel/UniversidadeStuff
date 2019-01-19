package EDA1;

/**
 * Created by DanielSerrano on 29/12/2017.
 */
public class ANode<T  extends Comparable<? super T>> {
    private T elemento;
    private ANode<T> left;
    private ANode<T> right;
    private int altura;

    ANode (T e){
        elemento=e;
        left=null;
        right=null;
        altura = 0;
    }
    ANode(T e, ANode<T> left, ANode<T> right){
        elemento=e;
        this.left=left;
        this.right=right;
        altura = 0;
    }

    public T getElemento() {
        return elemento;
    }

    public ANode<T> getLeft() {
        return left;
    }

    public ANode<T> getRight() {
        return right;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public void setLeft(ANode<T> left) {
        this.left = left;
    }

    public void setRight(ANode<T> right) {
        this.right = right;
    }

    public int getAltura(){
        return altura;
    }

    public void setAltura(int altura){
        this.altura = altura;
    }


    public String toString(){
        return elemento.toString();
    }
}