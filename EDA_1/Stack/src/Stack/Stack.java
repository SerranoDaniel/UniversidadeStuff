package Stack;
public interface Stack<E>{
  public void push(E e);
  public E top();
  public E pop();
  public int size();
  public boolean isEmpty();
}