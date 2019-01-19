package trabalho;

import java.util.*;

/**
 * 
 * Classe main com o menu, onde chama as classes necessarias dependendo das decisoes tomadas.
 */

public class Menu {
	public static void main(String[]args){
		Scanner input = new Scanner(System.in);
		int decisao,escolha;
		boolean boleano = true,boleano1=true;
		while(boleano == true && boleano1 == true){
			System.out.println("SMOOTHY");
			System.out.println("0 - Explicação do jogo");
			System.out.println("1 - Jogar");
			System.out.println("2 - Sair");
			System.out.print("Decisao:");
			try{
				decisao=input.nextInt();
			}catch(InputMismatchException error1){
				System.out.println("Erro: " + error1);
				input = new Scanner(System.in);
				continue;
			}
			if(decisao == 0){
				Explicacao e = new Explicacao();
				e.explicacao();
				while(boleano=true){
					try{
						System.out.println("(0-Menu | 1 - Sair)");
						System.out.print("Decisao: ");
						escolha = input.nextInt();
					}catch(InputMismatchException error){
						System.out.println("Erro: " + error);
						input = new Scanner(System.in);
						continue;
					}
					if(escolha==1){
						System.out.println("Saiu do jogo!");
						boleano1 = false;
						break;
					}
					else if(escolha==0){
						break;
					}
					else if(escolha!=1 && escolha !=0){
						System.out.println("Opcao invalida.");
					}
				}
			}
			else if(decisao==1){
				Gerar g = new Gerar();
				g.tabuleiro();
				while(boleano=true){
					try{
						System.out.println("(0-Menu | 1 - Sair)");
						System.out.print("Decisao: ");
						escolha = input.nextInt();
					}catch(InputMismatchException error){
						System.out.println("Erro: " + error);
						input = new Scanner(System.in);
						continue;
					}
					if(escolha==1){
						System.out.println("Saiu do jogo!");
						boleano1 = false;
						break;
					}
					else if(escolha==0){
						break;
					}
					else if(escolha!=1 && escolha !=0){
						System.out.println("Opcao invalida.");
					}
				}
			}
			else if(decisao==2){
				System.out.print("Saiu do jogo!");
				break;
			}
			else if(decisao!=0 && decisao!=1 && decisao!=2){
				System.out.println("Opcao invalida.");
			}
		}
	}
}