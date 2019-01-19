/**
 * Created by User on 12/12/2017.
 */
public class LinHashTable<T> extends HashTable<T>{

    public LinHashTable() {
        super();
    }

    public LinHashTable(int n) {
        super(n);
    }



    @Override
    protected int procPos(T s) {
        int index = s.hashCode() % tabela.length;
        while(tabela[index] != null){
            if(index == tabela.length){
                index = 0;
            }else{
                index ++;
            }
        }
        return index;
    }

    public static void main(String[] args){
        LinHashTable<Integer> h1 = new LinHashTable<>(5);

        h1.insere(1);

        h1.insere(10);

        h1.insere(2);

        h1.insere(3);

        h1.insere(4);

        h1.insere(5);

        h1.insere(6);

        h1.insere(7);

        h1.insere(8);

        h1.insere(9);

        h1.insere(11);

    }
}
