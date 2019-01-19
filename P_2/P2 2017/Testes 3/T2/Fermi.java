import java.util.*;

public class Fermi{
  int a, b, c;
  
  public Fermi(){
    a = getRandom();
    b = getRandom();
    c = getRandom();
    
  }    
  int getRandom(){// classe private
    Random rand = new Random();
    int geraNum =  rand.nextInt(10);
    return geraNum;
  }
  public int checkA(int n1, int n2, int n3){
    
    if(a == n1 ){
      System.out.println("FermiA");  
    }
    if(a == n2 || a == n3){
      System.out.println("PicoA");
    }
    if(a != n1  ){
      System.out.println("NanoA");   
    }
    
    return 0;
    
  }
  public int checkB(int n1, int n2, int n3){
    
    if(b == n2 ){
      System.out.println("FermiB");  
    }  
    if(b == n1 || b == n3){
      System.out.println("PicoB");
    }
    if(b != n2 ){
      System.out.println("NanoB");   
    }
    
    
    return 0;
    
  }
  public int checkC(int n1, int n2, int n3){
    
    if(c == n3 ){
      System.out.println("FermiC");  
    }  
    if(c == n1 || c == n2){
      System.out.println("PicoC");
    }
    if(c != n3 ){
      System.out.println("NanoC");   
    }
    
    return 0;
    
  }
}