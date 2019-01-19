package EDA1;

/**
 * Created by User on 23/12/2017.
 */
public class Node<T> {
    public T elemento; //Node Actual
    public Node<T> left; //Funciona como Node anterior
    public Node<T> right; //Funciona como Node posterior
    public boolean ativado; //Para as HashTables
    int altura;

    //Construtor do elemento
    public Node(T elemento) {
        this.elemento = elemento;
        this.left = null;
        this.right = null;
        this.ativado = true;
        this.altura = 0;
    }

    //Construtor vazio
    public Node() {
        this(null);
    }

    //Construtor com elemento + Next
    public Node(T elemento, Node<T> next) {
        this.elemento = elemento;
        this.right = next;
        this.left = null;
        this.ativado = true;
        this.altura = 0;
    }

    //Construtor com elemento + Prev + next
    public Node(T elemento, Node<T> prev, Node<T> next) {
        this.elemento = elemento;
        this.right = null;
        this.left = prev;
        this.ativado = true;
        this.altura = 0;
    }

    public T elemento() throws InvalidNodeException{
        if(this==null){
            throw new InvalidNodeException("Null node");
        }
        return elemento;
    }

    public String toString(){
        return elemento.toString();
    }

    public T getElemento() {
        return elemento;
    }

    public Node<T> getLeft() {
        return left;
    }

    public Node<T> getRight() {
        return right;
    }

    public boolean isAtivado() {
        return ativado;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public void setAtivado(boolean ativado) {
        this.ativado = ativado;
    }


}



