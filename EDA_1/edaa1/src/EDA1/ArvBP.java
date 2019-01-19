package EDA1;

/**
 * Created by User on 25/12/2017.
 */
public class ArvBP<T extends Comparable<? super T>>{

    Node<T> root;

    public ArvBP(){
        root = null;
    }

    public ArvBP(T x){
        root =new Node<T>(x);
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
    private void print(Node<T> n,int t){
        //System.out.println("PRINT2");
        if (n!=null){
            System.out.println(ntabs(t)+n);
            print(n.left,t+1);
            print(n.right,t+1);
        }
    }


    public boolean isEmpty() {
        return root==null;
    }


    public boolean contains(T x) {
        return contains(root, x);
    }

    private boolean contains(Node<T> n, T x) {
        if(x.compareTo(n.elemento) < 0){
            contains(n.left, x);
        }
        return false;
    }

    public T findMin(){
        return findMin(root);
    }

    private T findMin(Node<T> n) {
        if(n.left != null){
            return findMin(n.right);
        }else{
            return n.elemento;
        }
    }


    public T findMax() {
        return findMax(root);
    }

    private T findMax(Node<T> n){
        if(n.right != null){
            return findMin(n.left);
        }else{
            return n.elemento;
        }
    }


    public void insere(T x) {
        root = insereRec(root, x);
    }

    private Node insereRec(Node<T> node, T x){
        if (node == null) {
            node = new Node(x);
            return node;
        }
        if (x.compareTo(node.elemento) < 0) {
            node.left = insereRec(node.left, x);
        }
        else if (x.compareTo(node.elemento) > 0) {
            node.right = insereRec(node.right, x);
        }
        return node;
    }


    public void remove(T x) {
        root = remove(root, x);
    }

    private Node remove(Node<T> n, T x){
        if(n == null){
            return(n);
        }
        if(x.compareTo(n.elemento) < 0){
            n.left = remove(n.left, x);
        }else if(x.compareTo(n.elemento) > 0){
            n.right = remove(n.right, x);
        }else{
            if(n.left != null && n.right !=null){
                T minright = findMin(n.right);
                n.elemento = minright;
                n.right = remove(n.right, minright);
            }
            else if(n.left != null){
                n = n.left;
            }else if(n.right != null){
                n=n.right;
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

    public int height(Node<T> node){
        if(node==null){
            return -1;
        }

        int hleft = height(node.left);
        int hright = height(node.right);

        return Math.max(hleft,hright) + 1;
    }


    public void printEmOrdem() {
        printEmOrdem(root);
    }

    private void printEmOrdem(Node n){
        if(n != null){
            System.out.print(n + " ");
            printEmOrdem(n.left);
            printEmOrdem(n.right);
        }
    }




    public void printPosOrdem(){ printPosOrdem(root);
    }

    public void printPosOrdem(Node n) {
        if(n !=  null) {
            printPosOrdem(n.left);
            printPosOrdem(n.right);
            System.out.print(n + " ");
        }
    }


    public void printPreOrdem(){ printPreOrdem(root);
    }

    public void printPreOrdem(Node n) {
        if(root !=  null) {
            printPosOrdem(n.left);
            printPosOrdem(root.right);
            System.out.print(n + " ");
        }
    }


}
