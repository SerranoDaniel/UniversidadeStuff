/**
 * Created by User on 09/10/2017.
 */
public class Square extends Shape {
    double comp, larg;

    public Square(double comp, double larg){
        this.comp=comp;
        this.larg=larg;
    }



    @Override
    public double calcArea(){
        return this.comp * this.larg;
    }
}
