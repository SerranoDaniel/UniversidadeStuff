/* Define a new classnamedTemperature.
 * Theclass has two accessors
 * —to-Fahrenheit and toCelsius—
 * that return the temperature in the specified 
 * unit and 
 * two mutators
 * —setFahrenheit  
 * -setCelsius
 * that assign the temperature in the specified unit. 
 * Maintain the temperature internally 
 * in degrees Fahrenheit. 
 * Using this class, write a program 
 * that inputs 
 * temperature in degrees Fahrenheit 
 * and outputs 
 * the temperature in equivalent degrees Celsius.
 */
import java.util.*;
class Temperatura{
  private double tf;//inicializacao de objeto instancia de classe
  private double tc;  
  public void Temperatura(){//construtor
    this.tf = tf; //referencia a objeto tf
    this.tc = tc;
  }
  public void setFahrenheit(double tf){
    this.tf = tf; 
  }
  public double toFahrenheit(){
    return this.tf; 
  }
  public void setCelsius(double tc){
    this.tf = (5/4)*(this.tc - 32); 
  }
  public double toCelsius(){
    return this.tc;    
  }   
  public static void main(String[]args){
   Temperatura  t1 = new Temperatura();
   t1.setFahrenheit(49); 
   System.out.println("temperatura em Fahrenheit: "+t1.tf);
   t1.setCelsius();
   System.out.println("temperatura em celsios: "+t1.tc);
  }
  
}