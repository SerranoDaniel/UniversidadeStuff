/**
 * Created by User on 30/10/2017.
 */
public class TheQueue<E> implements Queue<E> {

    E[] queue;
    private int inicio;
    private int fim;
    private int N;

    public TheQueue() {
        queue = (E[]) new Object[26];
        this.N = 26;
        this.inicio=0;
        this.fim=0;
    }

    public TheQueue(int size) {
        queue = (E[]) new Object[size+1];
        this.N = size+1;
        this.inicio=0;
        this.fim=0;
    }


    @Override
    public void enqueue(E o) throws OverflowQueueException {
        if (size() == N - 1) {
            throw new OverflowQueueException("The Queue is full");
        }
        queue[fim]=o;
        fim = inc(fim);
    }

    @Override
    public E front() throws EmptyQueueException {
        if(empty()){
            throw new EmptyQueueException("The Queue is empy");
        }
        return queue[inicio];
    }

    @Override
    public E dequeue() throws EmptyQueueException {
        if(empty()==true){
            throw new EmptyQueueException("The Queue is empty;");
        }
        E x = queue[inicio];
        queue[inicio] = null;
        inicio = inc(inicio);
        return x;
    }

    @Override
    public int size() {
        return (N - inicio + fim) % N;
    }

    @Override
    public boolean empty() {
        return false;
    }

    private int inc(int i){
        return (i+1) % N;
    }

}