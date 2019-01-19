import java.util.Scanner;

/**
 * Created by User on 25/10/2017.
 */
public class TheStack<E> implements Stack <E>{

    private int top;
    private E[] stack;

    public TheStack(){
        stack = (E[]) new Object[10];
        top = -1;
    }

    public TheStack(int size){
        stack = (E[]) new Object[size];
        top = -1;
    }

    @Override
    public void push(E o) {
        if(stack.length  == this.size()){
            System.out.println("The stack is full");
        }else {
            stack[this.size()] = o;
            top += 1;
        }
    }

    @Override
    public E top() {
        return stack[top];
    }

    @Override
    public E pop() {
        if (this.size() == 0) {
            return null;
        } else {
            E x = stack[top];
            stack[this.size()] = null;
            top -= 1;
            return x;
        }
    }

    @Override
    public int size() {
        return top+1;
    }

    @Override
    public boolean empty() {
        if(top == -1){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String [ ] args){
        TheStack array = new TheStack(10);
        int cont = 0;



        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = scan.nextInt();

        while(num != 0){
            array.push(num % 2);
            num = num / 2;
            cont += 1;
        }

        while(cont != 0){
            System.out.println(array.pop());
            cont -= 1;
        }





    }
}
