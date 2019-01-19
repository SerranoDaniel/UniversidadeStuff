/**
 * Created by User on 09/10/2017.
 */
public abstract class Shape implements Comparable<Shape>{

    public abstract double calcArea();

    public int compareTo(Shape o){
        if(this.calcArea()==o.calcArea()){
            return 0;
        }
        if(this.calcArea() < o.calcArea()){
            return -1;
        }
        return 1;
    }

    public String toString(){
        return("I am a class" + this.getClass() + "my area is: " + this.calcArea());
    }



}
