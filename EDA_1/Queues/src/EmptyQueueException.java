public class EmptyQueueException extends RuntimeException{

  public EmptyQueueException(){}
  
  public EmptyQueueException(String message){
  super(message);
  }
}