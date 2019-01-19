package exercicio1;

public class Teste {
	
	public static void main(String[] args) {
		
		Fração fracao1 = new Fração();
		Fração fracao2 = new Fração(1);
		Fração fracao3 = new Fração(100,75);
		
		
		System.out.println(fracao1);
		System.out.println(fracao2);
		fracao3.reduce();
		System.out.println(fracao3);
	}
}
