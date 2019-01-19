package EDA1;

/**
 * Created by User on 21/12/2017.
 */
public class StackC<T> implements Stack<T> {
    private T[] stack;
    private int top;

    public StackC() {
        stack = (T[]) new Object[15];
        top = -1;
    }

    public StackC(int StackSize) {
        stack = (T[]) new Object[StackSize];
        top = -1;
    }

    @Override
    public void push(T obj) {
        if (stack.length == this.size()) {
            System.out.println("The stack is full");
        } else {
            stack[this.size()] = obj;
            top += 1;
        }
    }

    @Override
    public T top() {
        return stack[top];
    }

    @Override
    public T pop() {
        if (this.size() == 0) {
            return null;
        } else {
            T x = stack[top];
            stack[this.size()] = null;
            top -= 1;
            return x;
        }
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public boolean empty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    public String toString(){
        String str = "";
        for(int i=top; i>-1; i--){
            str += stack[i]+" | ";
        }
        return str;
    }
}
