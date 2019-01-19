
public class QueueArray<E> implements TADQueue<E> {
	public int fim=0, ini=0;
	public E[] fila;
	
	private int add(int i){
		return i+1%fila.length;			
	}
	
	public QueueArray(int tam){
		fila = (E[]) new Object[tam];
	}
	public void enqueue(E o) throws OverflowQueueException {		
		if(size() == fila.length-1) throw new FullException("Is full");
		fila[fim] = o;		
		fim = add(fim);
	}

	public E front() throws EmptyQueueException {
		return fila[ini];
	}

	public E dequeue() throws EmptyQueueException {
		if (empty()) throw new EmptyException("Is empty");
		E x = fila[ini];
		fila[ini]=null;
		ini = add(ini);
		return x;
	}

	public int size() {
		return (fila.length-ini+fim)%fila.length;
	}

	public boolean empty() {
		return fim==ini;
	}
	public String toString(){
		String str = "";
		for(int i=ini; i!=fim; i=add(i)){
			str += fila[i] + " ";
		}
		return str;
	}
	
}
