import java.util.Scanner;

public class Bus {
	private Scanner scan;
	private QueueArray<Integer> fila = new QueueArray<Integer>(10);
	private String code, time, num;
	
	private void read(){
		scan = new Scanner(System.in);
		System.out.println("Codigo:");
		code = scan.nextLine();
		System.out.println("Hora:");
		time = scan.nextLine();
		System.out.println("Numero:");
		
	}
	
}
