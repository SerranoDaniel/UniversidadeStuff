/**
 * Created by User on 20/11/2017.
 */
public class ArBP<T extends Comparable<? super T>>{

    BNode<T> root;

    public ArBP(){
        root = null;
    }

    public ArBP(T x){
        root =new BNode<T>(x);
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


    public boolean isEmpty() {
        return root==null;
    }


    public boolean contains(T x) {
        return contains(root, x);
    }

    private boolean contains(BNode<T> n, T x) {
        if(x.compareTo(n.elemento) < 0){
            contains(n.esq, x);
        }
    return false;
    }

    public T findMin(){
        return findMin(root);
    }

    private T findMin(BNode<T> n) {
        if(n.esq != null){
            return findMin(n.esq);
        }else{
            return n.elemento;
        }
    }


    public T findMax() {
        return findMax(root);
    }

    private T findMax(BNode<T> n){
        if(n.dir != null){
            return findMin(n.esq);
        }else{
            return n.elemento;
        }
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
        }
        else if (x.compareTo(node.elemento) > 0) {
            node.dir = insereRec(node.dir, x);
        }
        return node;
    }


    public void remove(T x) {
        root = remove(root, x);
    }

    private BNode remove(BNode<T> n, T x){
        if(n == null){
            return(n);
        }
        if(x.compareTo(n.elemento) < 0){
            n.esq = remove(n.esq, x);
        }else if(x.compareTo(n.elemento) > 0){
            n.dir = remove(n.dir, x);
        }else{
            if(n.esq != null && n.dir !=null){
                T minright = findMin(n.dir);
                n.elemento = minright;
                n.dir = remove(n.dir, minright);
            }
            else if(n.esq != null){
                n = n.esq;
            }else if(n.dir != null){
                n=n.dir;
            }
            else{
                n = null;
            }
        }
        return n;
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


    public void printEmOrdem() {
        printEmOrdem(root);
    }

    private void printEmOrdem(BNode n){
        if(n != null){
            System.out.print(n + " ");
            printEmOrdem(n.esq);
            printEmOrdem(n.dir);
        }
    }




    public void printPosOrdem() {
    }


    public void printPreOrdem() {

    }

    public static void main (String[] args){
        ArBP<Integer> a1 = new ArBP<>();

        a1.insere(14);
        /*a1.insere(10);
        a1.insere(97);
        a1.insere(4);
        a1.insere(32);
        a1.insere(7);
        a1.insere(5);
        a1.insere(34);
        a1.insere(11);
        a1.insere(50);*/
        //a1.insere(29);

        //System.out.println(a1.findMin());
        //a1.remove(10);
        //a1.remove(14);

        a1.printEmOrdem();

        System.out.println(a1.isEmpty());
        a1.print();
        System.out.print(a1.height());
    }
}
