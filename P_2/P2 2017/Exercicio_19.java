import java.util.Scanner;
class Exercicio_19
{
  public static void main(String[]args)
  {
    Scanner scanner;
    scanner=new Scanner(System.in);
    String nome1, nome2, nome3;
    System.out.println("Enter your first name:");
    nome1=scanner.next();
    System.out.println("Enter your midle name:");
    nome2=scanner.next();
    System.out.println("Enter your last name:");
    nome3=scanner.next();
    nome2=nome2.substring(0,1);
    System.out.println(nome1+" "+nome2+". "+nome3);
  }
}