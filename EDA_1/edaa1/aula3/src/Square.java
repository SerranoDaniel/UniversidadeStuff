/**
 * Created by JoaoManuel on 09/10/2017.
 */
public class Square extends Shape {

    double lado;

    public Square(double lado){

        this.lado=lado;

    }

    public double area() {

        return (this.lado*this.lado);

    }


}
