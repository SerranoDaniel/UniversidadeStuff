import java.io.*;
import java.util.Scanner;


public class main{

	public static void main (String[] args) throws IOException
	{
		Scanner teclado = new Scanner(System.in);
		String input;
		int array[] = new int[2];
		int x0 = 0;
		int y0 = 515; 	
		while(true){
			System.out.print("Qualquer letra para alterar parametros da conversao: ");
			input=teclado.nextLine();
			if(!input.equals("")){
				System.out.print("X0:");
				input=teclado.nextLine();
				x0 =Integer.parseInt(input);
				System.out.print("Y0:");
				input=teclado.nextLine();
				y0 = Integer.parseInt(input);
			}
			System.out.print("X: ");
			input=teclado.nextLine();
			int x = Integer.parseInt(input);
			System.out.print("Y:");
			input=teclado.nextLine();
			int y= Integer.parseInt(input);
			array = conversao(x0,y0,x,y);
			System.out.println("( "+array[0]+" , "+array[1]+" )");
		}
	}

	public static int[] conversao(int x0, int y0, int x, int y){
		int array[] = new int[2];
		int novo_x = x-x0;
		int novo_y = y0-y;
		array[0]=novo_x;
		array[1]=novo_y;

		return array;


	}
	
}