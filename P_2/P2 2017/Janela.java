import javax.swing.*;

class Janela{
  public static void main(String [] args){
  JFrame myWindow; // declara a variavel
  myWindow = new JFrame();// cria um objeto instancia da classe
  
  myWindow.setSize(300,200); //mensagem 1 
  myWindow.setTitle("Hello");//mensagem 2
  myWindow.setVisible(true);//mensagem 3
  JFrame myWindow1; // declara a variavel
  myWindow1 = new JFrame();// cria um objeto instancia da classe
  myWindow1.setSize(300,200); //mensagem 1 
  myWindow1.setTitle("World");//mensagem 2
  myWindow1.setVisible(true);//mensagem 3
  }
}