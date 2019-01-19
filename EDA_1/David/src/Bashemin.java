package pratica5;
import pratica4.ArrayStack;

public class Bashemin {
	
	ArrayStack<Carros> ladoEsquerdo;
	ArrayStack<Carros> ladoDireito;
	
	final int espaco = 10;
	
	public Bashemin(){
		ladoEsquerdo = new ArrayStack<>(espaco);
		ladoDireito = new ArrayStack<>(espaco);
	}
	
	public String toString(){
		return "esquerda: \n" + ladoEsquerdo + "\ndireita: \n" + ladoDireito;
	}
	
	public void entra(Carros carro){
		
		if (ladoEsquerdo.size() + ladoDireito.size() == espaco + 1){
			System.out.println("\nparque cheio, o carro: " + carro.getMatricula() + " nao entrou\n");
		} else {
			if (ladoEsquerdo.size() == espaco){
				ladoDireito.push(carro);
				System.out.println(" [E] Chegou o carro: " + carro.getMatricula());
			} else {
				ladoEsquerdo.push(carro);
				System.out.println(" [E] Chegou o carro: " + carro.getMatricula());
			}
		}
		
	}
	
	public void gere_saida(Carros carro){
		while (sai(carro)){
			sai (carro);
		}
	}
	
	public boolean sai(Carros carro){
		
		Carros temporario;
		
		if (ladoEsquerdo.size() == 0 && ladoDireito.size() == 0){
			System.out.println("O parque está vazio ");
		} else {
			
			if (ladoEsquerdo.size() < ladoDireito.size()){
				
				// Retira da direita e mete na esquerda
				while (!ladoDireito.empty()){
					
					temporario = ladoDireito.pop();	
					
					if (carro.getMatricula() == temporario.getMatricula()){
						System.out.println("\n Carro " + carro + " removido \n");
						return true;
					}
					else {
						System.out.println("movido carro (pa esquerda) " + temporario.getMatricula() );
						ladoEsquerdo.push(temporario);
					}
					
				}
				
			} else {
				
				// Retira da direita e mete na esquerda
				
				while (!ladoEsquerdo.empty()){
					temporario = ladoEsquerdo.pop();
					
					if (carro.getMatricula().equals(temporario.getMatricula())){
						System.out.println("\n Carro: " + temporario + " removido \n");
						return true;
					} else {
						System.out.println("Carro movidos: " + temporario);
						ladoDireito.push(temporario);
					}
					
				} 
				
			}
			
		}
		
		return false;
		
	}
	

}
