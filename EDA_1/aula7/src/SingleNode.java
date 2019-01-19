/**
 * Created by JoaoManuel on 06/11/2017.
 */
public class SingleNode<T> {

    T elemento;
    SingleNode<T> next;

    public SingleNode(T x){
        elemento=x;
        next=null;
    }

    public SingleNode(){
        this(null);
    }

    public SingleNode(T x, SingleNode<T> n){
        elemento= x;
        next=n;
    }

    public T element() throws InvalidNodeException{
        if(this==null){
            throw new InvalidNodeException("Null node");
        }
        return elemento;
    }

    public SingleNode<T> getNext(){
        return this.next;
    }

    public void setElement(T x){
        this.elemento=x;
    }

    public void setNext(SingleNode<T> n){
        this.next=n;
    }

}
