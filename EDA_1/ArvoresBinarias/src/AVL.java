/**
 * Created by User on 04/12/2017.
 */
    public class AVL<T extends Comparable<? super T>>{
    BNode<T> root;

    public AVL(){
        root = null;
    }

    public AVL(T x){
        root = new BNode<T>(x);
    }

    public void print(){
        print(root,0);
    }
    private String ntabs(int t){
        String res="";
        for (int i=0;i<t;i++)
            res +="\t";
        return res;
    }
    private void print(BNode<T> n,int t){
        //System.out.println("PRINT2");
        if (n!=null){
            System.out.println(ntabs(t)+n);
            print(n.esq,t+1);
            print(n.dir,t+1);
        }
    }

    public boolean isEmpty(){
        return root==null;
    }

    public int height(){
        if(this.isEmpty()){
            return 0;
        }
        else{
            return height(root);
        }
    }

    public int height(BNode<T> node){
        if(node==null){
            return -1;
        }

        int hleft = height(node.esq);
        int hright = height(node.dir);

        return Math.max(hleft,hright) + 1;
    }

    private BNode rotacaoDir(BNode<T> node){
        BNode newRoot = node.esq;
        BNode folhaDireitaDoNoEsq = newRoot.dir;

        newRoot.dir = node;
        node.esq = folhaDireitaDoNoEsq;

        node.altura = Math.max(height(node.esq),height(node.dir));
        newRoot.altura = Math.max(height(newRoot.esq),height(node.dir));

        return newRoot;
    }

    private BNode rotacaoEsq(BNode<T> node){
        BNode newRoot = node.dir;
        BNode folhaEsqDoNoDir = newRoot.esq;

        newRoot.esq = node;
        node.dir = folhaEsqDoNoDir;

        node.altura = Math.max(height(node.esq),height(node.dir));
        newRoot.altura = Math.max(height(newRoot.esq),height(node.dir));

        return newRoot;


    }
    public void insere(T x) {
        root = insereRec(root, x);
    }

    private BNode insereRec(BNode<T> node, T x){
        if (node == null) {
            node = new BNode(x);
            return node;
        }
        if (x.compareTo(node.elemento) < 0) {
            node.esq = insereRec(node.esq, x);
            node.altura = 1 + Math.max(height(node.esq),height(node.dir));
            if((height(node.esq) - height(node.dir)) > 1 && x.compareTo(node.esq.elemento) < 0 ){
                return rotacaoDir(node);
            }
            if((height(node.esq) - height(node.dir)) > 1 && x.compareTo(node.esq.elemento) > 0 ){
                node.esq = rotacaoEsq(node.esq);
                return rotacaoDir(node);
            }
        }
        else if (x.compareTo(node.elemento) > 0) {
            node.dir = insereRec(node.dir, x);
            node.altura = 1 + Math.max(height(node.esq),height(node.dir));
            if((height(node.esq) - height(node.dir)) < -1 && x.compareTo(node.dir.elemento) > 0 ){
                return rotacaoEsq(node);
            }
            if((height(node.esq) - height(node.dir)) < -1 && x.compareTo(node.dir.elemento) < 0 ){
                node.dir = rotacaoDir(node.dir);
                return rotacaoEsq(node);
            }
        }
        else{
            return node;
        }
        return node;
    }

    /*
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(BNode<T> node) {
        if (node != null) {
            System.out.print(node.elemento + " ");
            preOrder(node.esq);
            preOrder(node.dir);
        }
    }*/

    public boolean isPrime(int n){
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

    public int getNextPrime(int i){
        while (!isPrime(i)){
            i++;
        }
        return i;
    }



    public static void main (String[] args) {
        AVL<Integer> a1 = new AVL<>();


        System.out.print(a1.getNextPrime(5 * 2));
        System.out.print(a1.isPrime(11));
        System.out.print(a1.isPrime(13));
        System.out.print(a1.isPrime(1));
        System.out.print(a1.isPrime(2));
        System.out.print(a1.isPrime(3));
        System.out.print(a1.isPrime(4));
        System.out.print(a1.isPrime(5));



        a1.insere(11);
        a1.insere(18);
        a1.insere(77);
        a1.insere(32);
        a1.insere(36);
        a1.insere(45);
        a1.insere(4);
        a1.insere(3);
        a1.insere(15);
        a1.insere(19);
        a1.insere(7);
        a1.insere(1);


        a1.print();
        System.out.println("-----------------");


    }


}
