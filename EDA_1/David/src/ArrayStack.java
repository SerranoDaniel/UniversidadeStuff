public class ArrayStack<T> implements Stack<T>
{
    private int top;
    private T[] stack;

    public ArrayStack()
    {
        stack = (T[]) new Object[10];
        top = -1;
    }

    @Override
    public void push(T o)
    {
        top += 1;
        stack[top] = o;
    }

    @Override
    public T top()
    {
        return stack[top];
    }

    @Override
    public T pop()
    {
        T o =  stack[top];
        stack[top] = null;
        top -= 1;
        return o;
    }

    @Override
    public int size()
    {
        return top;
    }

    @Override
    public boolean empty()
    {
        return top<0;
    }
}
