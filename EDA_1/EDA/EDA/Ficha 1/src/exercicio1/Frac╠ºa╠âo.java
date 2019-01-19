package exercicio1;

public class Fração {
	private int x, y;
	
	public Fração(){
		x = 0;
		y = 1;
	}
	public Fração(int x){
		this.x = x;
		y = 1;
		
	}
	public Fração(int x, int y){
		this.x = x;
		this.y = y;
	}	
	
	public int getNumerador(){
		return x;
	}
	public int getDenominador(){
		return y;
	}
	public void setNumerador(int x){
		this.x = x;
	}
	public void setDenominador(int y){
		this.y = y;
	}
	
	private int maxDiv(int a, int b){
		if(a == 0){
			return 0;
		}else{
			while(a != b){
				if(a<b){
					b = b - a;
				}else{
					a = a - b;
				}
			}
			return a;
		}
	}
	public void reduce(){
		int a = x;
		x = x/maxDiv(x,y);
		y = y/maxDiv(a,y);
	}
	
	public String toString(){
		return x+"/"+y;
	}
}
