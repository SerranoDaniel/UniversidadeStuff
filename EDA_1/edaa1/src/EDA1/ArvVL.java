package EDA1;

/**
 * Created by User on 25/12/2017.
 */
public class ArvVL<T extends Comparable<? super T>>{
    Node<T> root;

    public ArvVL(){
        root = null;
    }

    public ArvVL(T x){
        root = new Node<T>(x);
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

    public int height(Node<T> node){
        if(node==null){
            return -1;
        }

        int hleft = height(node.left);
        int hright = height(node.right);

        return Math.max(hleft,hright) + 1;
    }

    private Node rotacaoDir(Node<T> node){
        Node newRoot = node.left;
        Node folhaDireitaDoNoEsq = newRoot.right;

        newRoot.right = node;
        node.left = folhaDireitaDoNoEsq;

        node.altura = Math.max(height(node.left),height(node.right));
        newRoot.altura = Math.max(height(newRoot.left),height(node.right));

        return newRoot;
    }

    private Node rotacaoEsq(Node<T> node){
        Node newRoot = node.right;
        Node folhaEsqDoNoDir = newRoot.left;

        newRoot.left = node;
        node.right = folhaEsqDoNoDir;

        node.altura = Math.max(height(node.left),height(node.right));
        newRoot.altura = Math.max(height(newRoot.left),height(node.right));

        return newRoot;


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
            node.altura = 1 + Math.max(height(node.left),height(node.right));
            if((height(node.left) - height(node.right)) > 1 && x.compareTo(node.left.elemento) < 0 ){
                return rotacaoDir(node);
            }
            if((height(node.left) - height(node.right)) > 1 && x.compareTo(node.left.elemento) > 0 ){
                node.left = rotacaoEsq(node.left);
                return rotacaoDir(node);
            }
        }
        else if (x.compareTo(node.elemento) > 0) {
            node.right = insereRec(node.right, x);
            node.altura = 1 + Math.max(height(node.left),height(node.right));
            if((height(node.left) - height(node.right)) < -1 && x.compareTo(node.right.elemento) > 0 ){
                return rotacaoEsq(node);
            }
            if((height(node.left) - height(node.right)) < -1 && x.compareTo(node.right.elemento) < 0 ){
                node.right = rotacaoDir(node.right);
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


}
