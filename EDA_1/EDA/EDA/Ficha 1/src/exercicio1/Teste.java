package exercicio1;

public class Teste {
	
	public static void main(String[] args) {
		
		Fra��o fracao1 = new Fra��o();
		Fra��o fracao2 = new Fra��o(1);
		Fra��o fracao3 = new Fra��o(100,75);
		
		
		System.out.println(fracao1);
		System.out.println(fracao2);
		fracao3.reduce();
		System.out.println(fracao3);
	}
}
