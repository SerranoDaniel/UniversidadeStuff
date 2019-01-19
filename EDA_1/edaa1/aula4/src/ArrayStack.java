import java.lang.reflect.Array;

/**
 * Created by JoaoManuel on 16/10/2017.
 */
public class ArrayStack<E> implements Stack<E> {

    E[] stack;

    int tamanho;

    int indice_topo; //guardar a posição do topo para evitar correr a stack


    public ArrayStack() {

        stack = (E[]) new Object[25];

        indice_topo = 0;

    }


    public ArrayStack(int tamanho) {

        this.tamanho = tamanho;

        stack = (E[]) new Object[tamanho];

        indice_topo = 0;
    }


    @Override
    public void push(E o) throws FullException {

        if (indice_topo == tamanho - 1) {
            throw new FullException("A stack está cheia!!!");
        }

        indice_topo += 1;
        stack[indice_topo] = o;

    }

    @Override
    public E top() throws EmptyException {

        if (indice_topo == -1) {
            throw new EmptyException("A stack está vazia!!!");
        }
        return stack[indice_topo];
    }

    @Override
    public E pop() throws EmptyException {

        if (indice_topo == -1) {
            throw new EmptyException("A stack está vazia!!!");
        }

        E aux = stack[indice_topo];

        stack[indice_topo] = null;
        indice_topo -= 1;

        return aux;

    }

    @Override
    public int size() {

        return indice_topo + 1;
    }

    @Override
    public boolean empty() {
        if (indice_topo == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws EmptyException, FullException {
        ArrayStack co = new ArrayStack(4);
        //System.out.println(co.top());
        co.push(1);
        //co.pop();
        co.push(4);
        //co.pop();
        System.out.println(co.size());


    }

}

