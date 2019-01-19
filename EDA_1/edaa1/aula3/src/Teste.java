import java.util.ArrayList;

/**
 * Created by JoaoManuel on 09/10/2017.
 */

import java.util.Collection;

public class Teste {

    public static double totalShape(Shape[] arr){

        double areaTotal=0;

        for (Shape o : arr) {

            areaTotal += o.area();

        }

        return areaTotal;
    }

    public static double totalShape2(Collection<Square> col){

        double areaTotal=0;

        for (Shape o : col) {

            areaTotal += o.area();

        }

        return areaTotal;
    }





    public static void main(String[] args){

        Shape[] shape_array = new Shape[4];

        Circle[] circle_array = new Circle[2];

        Square[] square_array = new Square[2];

        Collection<Shape> shape_col = new ArrayList<Shape>(4);

        Collection<Square> square_col = new ArrayList<Square>(2);

        Collection<Circle> circle_col = new ArrayList<Circle>(2);



        Square square1 = new Square(10);
        Square square2 = new Square(50);

        square_array[0]=square1;
        square_array[1]=square2;

        square_col.add(square1);
        square_col.add(square2);


        Circle circle1 = new Circle(10);
        Circle circle2 = new Circle(50);

        circle_array[0]=circle1;
        circle_array[1]=circle2;

        circle_col.add(circle1);
        circle_col.add(circle2);

        shape_array[0]=square1;
        shape_array[1]=square2;
        shape_array[2]=circle1;
        shape_array[3]=circle2;

        shape_col.add(square1);
        shape_col.add(square2);
        shape_col.add(circle1);
        shape_col.add(circle2);

        System.out.println(shape_array[0].compareTo(shape_array[3]));

        System.out.println(circle_array[0].toString());

        System.out.println(totalShape(square_array));

        System.out.println(totalShape2(square_col));




    }
}
