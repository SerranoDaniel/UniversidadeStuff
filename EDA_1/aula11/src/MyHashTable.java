/**
 * Created by JoaoManuel on 11/12/2017.
 */
public abstract class MyHashTable<T>{

    Elemento<T>[] tabela;
    int nElementos;

    public MyHashTable(){
        alocarTabela(10);
        nElementos = 0;
    }

    public MyHashTable(int tamanho){
        alocarTabela(tamanho);
        nElementos = 0;
    }


    public int ocupados() {
        return nElementos;
    }


    public float factorCarga() {
        return nElementos/tabela.length;
    }


    protected abstract int procPos(T s);


    public void alocarTabela(int dim) {
        tabela= new Elemento[dim];
    }

    public void tornarVazia() {

    }

    public T procurar(T x) {
        int index = procPos(x);

        while(tabela[index].on_off!=false) {
            if (tabela[index].element == x) {
                return tabela[index].element;
            }
            index++;
        }

        return null;
    }


    public void remove(T x) {

    }


    public void insere(T x) {

    }

    public void rehash() {

    }

    public void print() {

    }
}
