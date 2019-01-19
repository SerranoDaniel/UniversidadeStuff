public class Tester
{
    public static void main(String args[]) {
        ArrayStack<Integer> co = new ArrayStack();

        co.push(1);
        co.push(5);

        System.out.println(co.pop());
    }
}
