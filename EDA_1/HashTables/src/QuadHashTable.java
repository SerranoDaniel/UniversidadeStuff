/**
 * Created by User on 14/12/2017.
 */
public class QuadHashTable<T> extends HashTable<T> {

    public QuadHashTable() {
        super();
    }

    public QuadHashTable(int n) {
        super(n);
    }

    @Override
    protected int procPos(T s) {
        int index = s.hashCode() % tabela.length;
        int i = 0;

        while(tabela[index] != null){
            index = (index + (i*i)) % tabela.length;
        }

        return index;
    }

    public static void main(String[] args) {
        QuadHashTable<Integer> h1 = new QuadHashTable<>(5);

        h1.insere(1);

        h1.insere(10);

        h1.insere(2);

        h1.insere(3);
    }

}

