/**
 * Created by JoaoManuel on 09/10/2017.
 */
public abstract class Shape implements Comparable<Shape>{

    public int compareTo(Shape o) {

        double area1 = this.area();
        double area2 = o.area();

        if (area1==area2){
            return 0;
        }
        if (area1<area2){
            return -1;
        }
        return 1;

    }

    public abstract double area();

    public String toString(){

        return ("I am a class "+this.getClass()+" my area is: "+this.area());
    }

}
