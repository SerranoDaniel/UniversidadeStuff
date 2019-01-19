//package exercicioscap4;

public class Temperature {
 private double temp_celsius;
 
 public void setCelsius(double to){
  temp_celsius = to;
 }
 
 public void setFar(double to){
  temp_celsius = 0.5555 * (to - 32);
  
 }
 
 public double toCelsius(){
  return temp_celsius;
 }
 
 public double toFar(){
  double temp_Far = 1.8 * temp_celsius + 32;
  return temp_Far;
 }
 
 public static void main(String[] args){
  Temperature t = new Temperature();
  
  t.setCelsius(0);
  System.out.print(t.toFar());
  
  
 }
 
}
