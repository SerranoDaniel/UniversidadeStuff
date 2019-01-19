/**
 * Created by User on 11/12/2017.
 */
public abstract class HashTable<T>{
    Elemento<T>[]  tabela;
    int ocupados;


    public HashTable(){
        alocarTabela(13);
        ocupados = 0;
    }

    public HashTable(int n){
        alocarTabela(n);
        ocupados = 0;
    }

    public int ocupados(){
        return ocupados;
    }

    public float factorCarga(){
        return ((float)ocupados) / ((float)tabela.length);
    }

    protected abstract int procPos(T s);

    public void alocarTabela(int dim){
        tabela = new Elemento[dim];

    }

    public void tornarVazia(){
        for(int i=0; i < tabela.length; i++){
            tabela[i] = null;
        }
        ocupados = 0;
    }

    public T procurar(T x){
        int ind = procPos(x);

        if(tabela[ind] == null){
            return null;
        }
        else{
            return tabela[ind].elemento;
        }
    }

    public void remove(T x){
        int ind = procPos(x);
        tabela[ind].apagado = false;
    }

    public void insere(T x){
        int ind = procPos(x);
        tabela[ind] = new Elemento<T>(x);
        ocupados ++;


        if(factorCarga() > 0.5){
            rehash();
        }
    }

    private boolean isPrime(int n){
        if (n == 1){
            return false;
        }
        if (n%2 == 0)
            return n==2;

        int limit = (int)Math.round(Math.sqrt(n));
        for(int i=3;i<=limit;i+=2)
            if (n%i == 0)
                return false;

        return true;
    }

    private int getNextPrime(int n){
        while (isPrime(n) == false ){
            n++;
        }
        return n;
    }

    public void rehash(){
        Elemento<T>[] tabelaAnting = this.tabela;
        alocarTabela(getNextPrime(tabelaAnting.length * 2));
        tornarVazia();

        for(int i=0; i < tabelaAnting.length; i++){
            if(tabelaAnting[i] != null) {
                insere(tabelaAnting[i].elemento);
            }
        }


    }

    public void print(){

    }

}
