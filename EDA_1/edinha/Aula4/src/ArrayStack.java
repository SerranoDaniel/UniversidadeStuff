public class ArrayStack<E> implements Stack<E>{

    E[] stack = (E[]) new Object[3];
    E last;

    public ArrayStack(){

    }

    @Override
    public void push(E o) throws FullException{

        for (int i = 0; i<stack.length; i++){
            if(stack[stack.length-1] != null){
                throw new FullException("A stack está cheia");
            }
            if(stack[i]==null){
                stack[i]=o;
                break;
            }
        }

    }

    @Override
    public E top() throws EmptyException{
        for (int i = 0; i<stack.length; i++) {
            if(i == 0 && stack[i]==null){
                throw new EmptyException("A Stack esta vazia");
            }

            else if (stack[i] == null) {
                return stack[i - 1];
            }

        }
        return null;

    }

    @Override
    public E pop() throws EmptyException {
        for (int i = 0; i<stack.length; i++){
            if(stack[0] == null){
                throw new EmptyException("A stack está vazia");
            }
            if(stack[stack.length-1]!=null){
                E x = stack[stack.length-1];
                stack[stack.length-1]=null;
                return x;
            }
            if(stack[i]==null){
                E x = stack[i-1];
                stack[i-1] = null;
                return x;
            }

        }
        return null;
    }

    @Override
    public int size() {
        for (int i = 0; i<stack.length; i++){
            int size =+ 1;
            if(stack[i]==null){
                return  size;
            }
        }
        return 0;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               \
    }

    @Override
    public boolean empty() {
        return false;
    }

    public E coco(){
        for(int i = 0; i<stack.length; i++){
            System.out.println(stack[i]);
        }
        return null;
    }

    public static void main(String[] args) throws EmptyException, FullException {
        ArrayStack co = new ArrayStack();
        //System.out.println(co.top());
        co.push(1);
        System.out.println(co.coco());
        System.out.println("");
        co.push(4);
        System.out.println(co.coco());
        System.out.println("");
        co.pop();
        System.out.println(co.coco());

    }
}
