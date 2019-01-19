/**
 * Created by User on 25/10/2017.
 */
public class Java1 {
    public class QueueWithStack<E>{

        Stack<E> pilhaStack;
        Stack<E> pilhaAux;

        public QueueWithStack( ){
            pilhaStack = new Stack<E>(10);
            pilhaAux = pilhaStack;
        }

        public QueueWithStack(int n ){
            pilhaStack = new Stack<E>(n);
            pilhaAux = pilhaStack;
        }

        public void enqueue(E x){
            return pilhaStack.push();
        }

        public E dequeue() {
            for (i = 0; i < pilhaStack.size(); i++) {
                pilhaAux.push(pilhaStack.pop());
            }
            E x = pilhaAux.pop();
            for(i = 0; i < pilhaAux.size(); i++){
                pilhaStack.push(pilhaAux.pop());
            }
            return x;
        }

        public E front(){

        }

    }
    public boolean isEmpty(){

    }
    public int size(){

    }
}
}
