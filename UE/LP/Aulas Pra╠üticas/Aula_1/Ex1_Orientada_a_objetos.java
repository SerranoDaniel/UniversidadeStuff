
public static int mdc (int dividendo, int divisor) {
	
	// dividendo = a; divisor = b
	if (dividendo == divisor) {
		return dividendo;
	}
	else if (dividendo < divisor) {
		return mdc(dividendo, (divisor - dividendo));
	}
	else (dividendo > divisor) {
		return mdc((dividendo - divisor), divisor);
	}

public static void main(String[] args) {

	int resposta = mdc(4, 4);

	System.out.println("\nResultado: " + resultado);

}
