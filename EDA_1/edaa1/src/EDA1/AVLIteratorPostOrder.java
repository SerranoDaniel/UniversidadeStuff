package EDA1;


/**
 * Created by DanielSerrano on 12/01/2018.
 */
import EDA1.Stack.*;

public class AVLIteratorPostOrder<T extends Comparable<? super T>> implements java.util.Iterator<T> {
    ANode<T> node;
    Stack<ANode<T>> stack;

    public AVLIteratorPostOrder(ANode<T> node, int AVLSize){
        this.node = node;
        stack = new StackC<>(AVLSize);
        populateStack(stack, this.node);
    }

    private void populateStack(Stack<ANode<T>> st, ANode<T> n){
        if(n == null)
            return;
        populateStack(st,n.getRight());
        st.push(n);
        populateStack(st,n.getLeft());
        return;
    }

    public boolean hasNext(){
        return !stack.empty();
    }

    public T next(){
        try {
            return stack.pop().getElemento();
        } catch (EmptyException e) {
            e.printStackTrace();
        }
        return null;
    }

}
