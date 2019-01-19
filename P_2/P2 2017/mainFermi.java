import java.util.*;
import java.lang.Math;
public class mainFermi{
  public static void main(String[] args){
    
    
    Scanner scan = new Scanner(System.in);
  
    Fermi fe = new Fermi();  
    //Debug
    System.out.println("Debug Para os numeros secretos " + fe.a + " " + fe.b + " " + fe.c +"\n"); //Debug
    
    // Scanner input
    System.out.println("Introduza um numero de 0 a 9 por input para tentar adivinhar o numero selecionado aleatoriamente \n");
    System.out.println("Introduza input 1 ");
    int num1 = scan.nextInt();
    System.out.println("Introduza input 2 ");
    int num2 = scan.nextInt();
    System.out.println("Introduza input 3 ");
    int num3 = scan.nextInt();
    
    //Run
    System.out.println(fe.checkA(num1 , num2 , num3) + fe.checkB(num1 , num2 , num3) + fe.checkC(num1 , num2 , num3)); 
    
 
  }  
}