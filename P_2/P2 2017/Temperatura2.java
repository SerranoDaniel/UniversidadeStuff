/* Exercicio 7
 * Define a new class named Temperature.
 * The class has two accessors
 * -Fahrenheit & -toCelsius
 * that return 
 * the temperature in the specified unit 
 * and two mutators
 * —setFahrenheit  & -setCelsius
 * that assign the temperature in the specified unit. 
 * 
 * Maintain the temperature internally in degrees Fahrenheit. 
 * Using this class, write a program that 
 * -inputs temperature in degrees Fahrenheit 
 * -outputs the temperature in equivalent degrees Celsius.
 * formulas:
 * Far to celcius>  T(°C) = (T(°F) - 32) × 5/9
 * Celcius to far>  T(°F) = T(°C) × 9/5 + 32
 */
import java.util.*;//importa todas as classes utilitarios esta é necessária para este exercicio
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Temperatura{//maiuscula superclasse
  double tf;//init de objeto instancia de classe
  double tc;//init guarda valor em celsius da conversao 
  
  //________________construtor
  public void Temperatura(){//construtor maiuscula
    
    this.tf = tf; //referencia a objeto tf no construtor? ?
    this.tc = tc; //referencia a objeto tc no construtor? ?
  }
  /*----------metodos seletores da superclasse 
   * referenciados dentro do construtor da superclasse
  */
 
  public void setFahrenheit(double tf){ //metodo set
    this.tf = tf;
  }
  public double toFahrenheit(){ // metodo get??
    return this.tf; 
  }
  public void setCelsius(){
    this.tc = Math.round((0.55)*(this.tf - 32)); 
  }
  public double toCelsius(){
    return this.tc; 
  } 
  
  public static void main(String[]args){
    
    // cria um novo objeto da superclasse com o nome "t1:Temperatura"
   Temperatura  t1 = new Temperatura(); //t1
 //t1.setFahrenheit(68); //input "68"
   //metodo que envia mensagem "68" ao novo objeto
   //para este utilizar os metodos de instancia da superclasse com a nova mensagem 
 //t1.setCelsius();
 //System.out.println("Convertendo "+t1.tf+"º Fahrenheit em Celsius: "+t1.tc+"º Celsius");//output resultado em Celsius
   //responde ao exercicio é o resultado?
   String tf = JOptionPane.showInputDialog(null, "Introduza temperatura em Far a converter para Celsius:");
   "Convertendo "+t1.tf+"º Fahrenheit em Celsius: "+t1.tc+"º Celsius"
     
   
   /*JFrame jf = new JFrame(); //"Conversor de Temperatura");
   jf.setName("Conversor de temperatura");
   jf.setSize(600, 600);
   jf.setResizable(true);
   
   jf.setVisible(true);
   //jf.setDefaultCloseOperation(Exit_ON_CLOSE);
   JButton okButton = new JButton("Open a Frame");
   JLabel msg = new JLabel("Welcome to TutorialsPoint SWING Tutorial.", JLabel.CENTER);
  jf.setLayout(new GridLayout(3, 1));*/
  
}
}
