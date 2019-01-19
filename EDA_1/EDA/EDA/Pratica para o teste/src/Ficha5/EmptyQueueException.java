package Ficha5;

public class EmptyQueueException extends RuntimeException {
	public EmptyQueueException(){
		super();
	}
	public EmptyQueueException(String str){
		super(str);
	}
}
