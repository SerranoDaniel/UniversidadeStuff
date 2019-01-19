
public class DoublyLinkedList<E> implements Lista<E> {
	private Node<E> head;
	private Node<E> tail;
	private int cont;
	
	
	public void add(E x) {
		if(isEmpty()){
			Node<E> n = new Node<E>(x);
			head = n;
			tail = n;
			cont++;
		}else{
			Node<E> n = new Node<E>(x, tail);
			tail.right = n;
			tail = n;
			cont++;
		}	
	}
	public void add(int i, E x) {
		Node<E> pos = head;
		for(int j=0;j<i; j++){
			pos = pos.right;
		}
		Node<E> n = new Node<E>(x, pos, pos.right);
		pos.right = n;
		(n.right).left=n;
		if(pos.right==null){
			tail = n;
		}
		cont ++;
	}
	public void set(int i, E x) {
		Node<E> pos = head;
		for(int j=0;j<i; j++){
			pos = pos.right;
		}
		pos.data = x;
	}
	public E get(int i) {
		Node<E> pos = head;
		for(int j=0;j<i; j++){
			pos = pos.right;
		}
		return (E) pos.data;
	}
	public void remove(E x) {
		Node<E> pos = head;
		for(int j=0 ;j<size(); j++){
			if(x.equals(pos.data)){
				(pos.left).right=pos.right;
				(pos.right).left=pos.left;
				cont--;
			}
			pos = pos.right;
		}
	}
	public void remove(int i) {
		Node<E> pos = head;
		for(int j=0 ;j<i; j++){
			pos = pos.right;
		}
		(pos.left).right=pos.right;
		(pos.right).left=pos.left;
		cont--;
	}
	public int size() {
		return cont;
	}
	public boolean isEmpty() {
		return cont==0;
	}
	public String toString(){
		String abc ="";
		if(!isEmpty()){
			Node<E> pos = head;
			for(int i=0; i<size(); i++){
				abc += ""+pos.data +" | ";
				
				pos = pos.right;
			}
			return abc;
		}else{
			return "Lista Vazia";
		}
	}

}
