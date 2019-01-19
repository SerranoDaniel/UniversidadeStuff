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
    else if(a == n2 || a == n3){
      System.out.println("PicoA");
    }
    else{
      System.out.println("NanoA");   
    }
    
    return 0;
    
  }
  public int checkB(int n1, int n2, int n3){
    
    if(b == n2 ){
      System.out.println("FermiB");  
    }  
    else if(b == n1 || b == n3){
      System.out.println("PicoB");
    }
    else {
      System.out.println("NanoB");   
    }
    
    
    return 0;
    
  }
  public int checkC(int n1, int n2, int n3){
    
    if(c == n3 ){
      System.out.println("FermiC");  
    }  
    else if(c == n1 || c == n2){
      System.out.println("PicoC");
    }
    else{
      System.out.println("NanoC");   
    }
    
    return 0;
    
  }
}