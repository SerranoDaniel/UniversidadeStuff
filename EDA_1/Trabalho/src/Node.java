
public class Node<E> {
	public E data;
	public Node<E> left;
	public Node<E> right;
	
	public Node(E data){
		this.data = data; 
		this.left = null; 
		this.right = null; 
	}
	public Node(E data, Node<E> prev){
		this.data = data; 
		this.left = prev; 
		this.right = null; 
	}
	public Node(E data, Node<E> prev, Node<E> next ){ 
		this.data = data; 
		this.left = prev; 
		this.right = next; 
	}
	public String toString(){
		String s = this.data.toString();
		return s;
	}
}
