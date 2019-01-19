/*
 * After you have read and studied this chapter, you should be able to 
 * • Select proper types for numerical data. 
 * • Write arithmetic expressions in Java. 
 * • Evaluate arithmetic expressions using the precedence rules. 
 * • Describe how the memory allocation works for objects and primitive data values. 
 * • Write mathematical expressions, using methods in the Math class. 
 * • Generate pseudo random numbers. 
 * • Use the GregorianCalendar class in manipulating date information such as year, month, and day. 
 * • Use the DecimalFormat class to format numerical data 
 * • Input and output numerical data by using System.in and System.out
 */
import javax.swing.*; 
import java.util.Scanner; 
import java.lang.String; 
class numeroMaior{  
  
  
  
  public static void main(String[]args) 
  { 
    Scanner scanner; 
    scanner=new Scanner(System.in); //crio um novo objeto da classe scanner
    String width,length ;
    System.out.println("Insert W:"); 
    width =scanner.next();
    
    System.out.println("Insert H:"); 
    length=scanner.next(); 
 
    JFrame numeroMaior; 
    numeroMaior=new JFrame(); 
//    int w = width;
//    int h = length;
    numeroMaior.setSize(width,length); 
    numeroMaior.setTitle("numeroMaior"); 
    numeroMaior.setVisible(true); 
  } 
}
  

