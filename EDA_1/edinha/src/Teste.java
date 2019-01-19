import java.util.Collection;

/**
 * Created by User on 09/10/2017.
 */
public class Teste {

    public static float totalShape(Shape[] array){
        float areaTotal = 0;

        for (Shape s : array){
            if(s != null) areaTotal += s.calcArea();
        }
        return areaTotal;
    }

    public static float totalShape2(Collection<Shape> col){
        float areaTotal = 0;

        for (Shape s : col){
            if(s != null) areaTotal += s.calcArea();
        }
        return areaTotal;
    }

    public static void main (String[] args){
        Square s1 = new Square(3, 4);
        Circle c1 = new Circle(4);
        Square s2 = new Square(3, 4);
        Circle c2 = new Circle(5);

        Shape[] arr1 = new Shape[5];
        Circle[] arr2 = new Circle[3];
        Square[] arr3 = new Square[2];

        arr1[0] = s1;
        arr1[1] = s2;
        arr1[2] = c1;
        arr1[3] = c2;

        System.out.println(arr1[0].compareTo(arr1[1]));
        System.out.println(arr1[2].compareTo(arr1[3]));
        System.out.println(arr1[3].toString());
        System.out.println(totalShape(arr1));



    }
}
