public interface Stack<T>
{
    public void push(T o);
    public T top();
    public T pop();
    public int size();
    public boolean empty();
}
