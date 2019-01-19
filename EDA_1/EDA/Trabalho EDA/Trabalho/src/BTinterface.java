
public interface BTinterface<E extends Comparable<? super E>> {
	public boolean isEmpty();
	
	public void insert(E x);
	
	public int altura();
	public void draw(String s);
 	
 	//public void printEmOrdem();
 	public void printPosOrdem();
	//public void printPreOrdem();
 } 