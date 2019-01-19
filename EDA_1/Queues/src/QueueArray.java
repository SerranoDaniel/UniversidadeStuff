public class QueueArray<T>{
	public int ini;
	public int fim;
	public T[] queue;
	public int maxsize;
	public int size;
	
	QueueArray(int cap){
		queue =  (T[]) new Object[maxsize];
		ini=0;
		fim=-1;
		size =0;
	}
	
	public int size(){
		return this.size;
	}
	
	public int maxsize(){
		return this.maxsize;
	}
	
	public boolean isfull(){
		return this.size == this.maxsize;
	}
	
	public boolean empty(){
		return this.size == this.maxsize;
	}
	
	public int places(){
		return this.maxsize-this.size;
	}
	
	public T front() throws EmptyQueueException{
		if(!empty()){
			return this.queue[this.ini]; 
		}
		else{
			throw new EmptyQueueException("Queue vazia");
		}
	}
	
	public void enqueue(T t) throws OverflowQueueException{
		if(!isfull()){
			if(this.ini == maxsize-1){
				fim=-1;
			}
			fim++;
			queue[fim] = t;
			size++;
		}
		else{
			throw new OverflowQueueException("queue cheia");
		}
	}

	public T dequeue() throws EmptyQueueException{
		if(empty()){
			throw new EmptyQueueException("Queue vazia");			
		}
		else{
			T data = this.queue[this.ini];
			this.queue[this.ini] = null;
				
				if(this.ini == maxsize-1){
					this.ini=0;
				}
				else{
					this.ini+=1;
				}
			this.size--;
			return data;
		}
	}
	
	public String toString(){
		String s= new String();
		for(int i=size; i>=0; i--){
			s+= queue[i] +" , ";
			
		}
		return s;		
	}	
}
	