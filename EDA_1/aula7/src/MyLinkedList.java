import java.util.Iterator;

/**
 * Created by JoaoManuel on 06/11/2017.
 */
public class MyLinkedList<T> implements Iterable<T>{

    SingleNode<T> header;
    int size;

    public MyLinkedList(){

        header = new SingleNode<>();
        size=0;

    }

    public Iterator<T> iterator() {

        return new LinkedListIterator<T>(header.getNext());
    }


    public int size() {
        return this.size;
    }


    public boolean isEmpty(){
        return header.getNext()==null;
    }


    public void remove(int i){

        SingleNode<T> p = getNode(i);
        SingleNode<T> p_ant = getNode(i-1);

        if(p.getNext()==null){

            p_ant.setNext(null);

        }
        else{

            p_ant.setNext(p.next);
        }

        size--;

    }


    public void remove(T x) {
        SingleNode<T> p = header;

        while(p != null && p.next.elemento!=x){
            p = p.next;
        }
        p.setNext(p.next.next);
        size --;
        }



    public void add(T x) {

        add(size,x);

    }


    public void add(int i, T x) {

        SingleNode<T> p = getNode(i-1);

        SingleNode<T> novo = new SingleNode<>(x,p.getNext());

        p.setNext(novo);

        size++;


    }


    public T get(int i) {
        SingleNode<T> x = getNode(i);
        return x.elemento;
    }


    public void set(int i, T y) {
        SingleNode<T> x = getNode(i);
        x.setElement(y);
    }

    private SingleNode<T> getNode(int i){ //retorna o no que está em i

        SingleNode<T> p = header;

        for(int k=0; k<=i;k++){
            p=p.getNext();
        }
        return p;
    }




    public static void main(String[] args){

        MyLinkedList<String> l1 = new MyLinkedList<>();

        l1.add("a");

        l1.add("b");

        l1.add("c");

        l1.add(0,"d");

        //System.out.println(l1.isEmpty());

        for(String x : l1){

            System.out.println(x);

        }

        System.out.println("x" + l1.get(1));
        l1.remove("r");
        System.out.println("x" + l1.get(2));
    }


}
