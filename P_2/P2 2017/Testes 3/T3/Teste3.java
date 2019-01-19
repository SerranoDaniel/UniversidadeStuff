import java.util.*;
class Teste3{
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    try{
      while(scan.hasNext()){
        int num = scan.nextInt();
        if(num<1){
          throw new Exception("conta");
        }
        System.out.println(num + " fixe.");
      }
    }catch(InputMismatchException e){
      System.out.println("Não pesca.");
    }catch(Exception e){
      System.out.println("Não " + e.getMessage());
    }finally{
      System.out.println("pois.");
    }
  }
}