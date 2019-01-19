import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ParentMatchEsqueleto
{
    public static boolean isOpenParen(String s){
        //retorna true se for parentesis a abrir
        return false;

    }
    public static boolean isCloseParen(String s){
        //retorna true se for parenesis a fechar
        return false;
    }

    public static boolean marrie(String s, String u){
        // retirn true se s casa com u
        return false;

    }

    public static void main(String[] args)
    {
        ArrayStack stack = new ArrayStack();

        System.out.println("Digite a expressão;");

        try {
            BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st=new StringTokenizer(bf.readLine(),"(){}[]",true);
            // implementar o algoritmo
            while(st.hasMoreTokens())
            {
                if(!isOpenParen(st.nextToken()))
                {

                }

                System.out.println(st.nextToken());
            }
        }
        catch(IOException e) {}
    }
}
