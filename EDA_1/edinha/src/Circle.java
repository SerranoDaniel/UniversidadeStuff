/**
 * Created by User on 09/10/2017.
 */
public class Circle extends Shape {
    double raio;

    public Circle(double raio){
        this.raio=raio;

    }

    @Override
    public double calcArea(){
        return (Math.PI * this.raio * this.raio);
    }
}
