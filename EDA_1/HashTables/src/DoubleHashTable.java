/**
 * Created by User on 14/12/2017.
 */
public class DoubleHashTable<T> extends HashTable<T> {

    public DoubleHashTable() {
        super();
    }

    public DoubleHashTable(int n) {
        super(n);
    }

    @Override
    protected int procPos(T s) {
        int index = s.hashCode() % tabela.length;

        return index;
    }

    

    public static void main(String[] args) {
        DoubleHashTable<Integer> h1 = new DoubleHashTable<>(5);

        h1.insere(1);

        h1.insere(10);

        h1.insere(2);

        h1.insere(3);
    }

}

