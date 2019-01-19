/**
 * Created by JoaoManuel on 09/10/2017.
 */
public class Circle extends Shape {

    double raio;

    public Circle(double raio){
        this.raio=raio;
    }


    public double area(){

        return (Math.PI * this.raio * this.raio);
    }

}
