
public class SingleNode<T> {
	private T element;
	private SingleNode<T> next;
	
	public SingleNode(){
		this(null);
	}
	public SingleNode(T e){
		element = e;
		next = null;
	}
	public SingleNode(T e, SingleNode<T> n){
		element = e;
		next = n;
	}
	
	public T getelement()throws InvalidNodeException{
		 if (this==null) throw new InvalidNodeException(" Null node");
		 return element; 
	}
	
	public void setElement(T e){
		 element = e;
	}
	
	public void setNext(SingleNode<T> n){
		 next=n;
	}
}
