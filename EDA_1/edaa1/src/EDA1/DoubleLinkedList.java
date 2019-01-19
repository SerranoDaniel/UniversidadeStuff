package EDA1;

import java.util.Iterator;

/**
 * Created by User on 25/12/2017.
 */
public class DoubleLinkedList<T> implements Iterable<T> {
    Node<T> head, tail;
    int size;

    public DoubleLinkedList(){
        head = new Node<>();
        tail = new Node<>();
        size = -1;
    }


    @Override
    public Iterator<T> iterator() {
        return new DoubleLinkedListIterator<T>(head.getRight());
    }

    public int size() {
        return this.size;
    }


    public boolean isEmpty(){
        return head.getRight()==null;
    }

    public void remove(int i){
        Node<T> x = getNode(i);

        if(x.getRight()==null){
            x.left.setRight(null);
        }
        else{
            x.left.setRight(x.right);
        }
        size--;
    }

    public void remove(T x){
        Node<T> p = head;

        while(p != null && p.right.elemento!=x){
            p = p.right;
        }
        p.setRight(p.right.right);
        size --;
    }

    public void add(T x) {

        add(size,x);

    }

    public void add(int i, T x) {

        Node<T> p = getNode(i-1);

        Node<T> novo = new Node<>(x,p.getRight());

        p.setRight(novo);

        size++;

    }

    public T get(int i) {
        Node<T> x = getNode(i);
        return x.elemento;
    }

    public void set(int i, T y) {
        Node<T> x = getNode(i);
        x.setElemento(y);
    }

    private Node<T> getNode(int i){ //retorna o no que está em i

        Node<T> p = head;

        for(int k=0; k<=i;k++){
            p=p.getRight();
        }
        return p;
    }
}
