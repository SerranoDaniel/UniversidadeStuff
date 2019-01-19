package EDA1;

/**
 * Created by User on 22/12/2017.
 */
public class QueueC<T> implements Queue<T> {
    T[] queue;
    private int inicio;
    private int fim;
    private int N;

    public QueueC() {
        queue = (T[]) new Object[26];
        this.N = 26;
        this.inicio=0;
        this.fim=0;
    }

    public QueueC(int size) {
        queue = (T[]) new Object[size+1];
        this.N = size+1;
        this.inicio=0;
        this.fim=0;
    }


    @Override
    public void enqueue(T o) throws OverflowException {
        if (size() == N - 1) {
            throw new OverflowException("The Queue is full");
        }
        queue[fim]=o;
        fim = inc(fim);
    }

    @Override
    public T front() throws EmptyException {
        if(empty()){
            throw new EmptyException("The Queue is empy");
        }
        return queue[inicio];
    }

    @Override
    public T dequeue() throws EmptyException {
        if(empty()==true){
            throw new EmptyException("The Queue is empty;");
        }
        T x = queue[inicio];
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
        return inicio==fim;
    }

    private int inc(int i){
        return (i+1) % N;
    }


}
