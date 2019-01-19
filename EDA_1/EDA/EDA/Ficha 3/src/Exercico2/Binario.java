package Exercico2;

public class Binario{
	private int number, cont=0;
	private int[] stack = new int[100];
	
	public Binario(int number){
		this.number = number;
	}
	
	private void addStack(int i){
		stack[cont] = i;
		cont++;
	}
	
	private void getBinario(){
		int i = number;
		do{
			addStack(i%2);
			i /= 2;
		}while(i!=0);
	}
	
	public String toString(){
		String str="";
		for(int i=cont; i>=0; i--){
			str += stack[i];
		}
		return str;
	}
	
	public static void main(String[] args) {
		Binario bin = new Binario(20);
		bin.getBinario();
		System.out.println(bin.toString());
	}
}
