import javax.swing.*;
import java.util.Scanner;
class Exercicio_22
{
  public static void main(String[]args)
  {
    Scanner scanner;
    scanner=new Scanner(System.in);
    int w,h;
    System.out.println("Insert W:");
    w=scanner.next();
    System.out.println("Insert H:");
    h=scanner.next();
    
    JFrame janela;
    janela=new JFrame();
    janela.setSize(w,h);
    janela.serTitle("Exercicio_22");
    janela.setVisible(true);
  }
}