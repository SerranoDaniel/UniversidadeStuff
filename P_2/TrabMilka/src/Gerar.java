package trabalho;

import java.util.*;

/**
 * Classe criada para ser usada no menu, gerar o tabuleiro, jogadas, chama o metodo da classe Verificacao e modifica o tabuleiro caso seja necessario.
 */

public class Gerar {
	static int linha,coluna,r,cores,cor;
	Verificacao v = new Verificacao();
	public void tabuleiro(){
		Scanner input = new Scanner(System.in);
		boolean boleano= true;
		int njogadas=0;
		//Escolha da dimensao do tabuleiro.
		while(boleano==true){
			System.out.print("Escolha a dimensao(maior ou igual que 4): ");
			try{
				r = input.nextInt();
			}catch(InputMismatchException error){
				System.out.println("Erro: " + error);
				input = new Scanner(System.in);
				continue;
			}
			if(r>=4){
				break;
			}
			else{
				System.out.println("Opção invalida.");
			}
		}
		//Escolha do numero de cores.
		while(boleano=true){
			System.out.print("Numero de cores(entre 3-6): ");
			try{
				cores = input.nextInt();
			}catch(InputMismatchException error){
				System.out.println("Erro: " + error);
				input = new Scanner(System.in);
				continue;
			}
			if(cores>=3 && cores<=6){
				break;
			}
			else{
				System.out.println("Opção invalida.");
			}
		}
		//Criaçao do array bidimensional.
		int tabuleiro[][] = new int[r][r];
		Random ra = new Random();
		System.out.println("Tabuleiro: " + r + "x" + r);
		String string = "";
		for(int y = 1;y<=r;y++){
			string = string + y + " ";
		}
		System.out.println(string + "\n");
		//Criacao e display do array bidimensional aleatorio.
		for(int i = 0; i<r ;i++){
			for(int a = 0;a<r;a++){
				tabuleiro[i][a]=ra.nextInt(cores) + 1;
				if(tabuleiro[i][a]==0){
					System.out.print("- ");
				}
				if(tabuleiro[i][a]==1){
					System.out.print("A ");
				}
				if(tabuleiro[i][a]==2){
					System.out.print("B ");
				}
				if(tabuleiro[i][a]==3){
					System.out.print("C ");
				}
				if(tabuleiro[i][a]==4){
					System.out.print("D ");
				}
				if(tabuleiro[i][a]==5){
					System.out.print("E ");
				}
				if(tabuleiro[i][a]==6){
					System.out.print("F ");
				}
			}
			System.out.print(" " + (i+1) + "\n");
		}
		while(boleano = true){
			int zeros=0, diferentes=0, notAdjacente=0;
			for(int d = 0;d<r;d++){
				for(int s= 0;s<r;s++){
					if(tabuleiro[d][s]==0){
						zeros++;
					}
					if(tabuleiro[d][s]!=0){
						diferentes++;
						if(d == 0){														
							if(s == 0){												
								if(tabuleiro[d+1][s]!=tabuleiro[d][s] && tabuleiro[d][s+1]!=tabuleiro[d][s]){
									notAdjacente++;
								}
							}
							else if(s == r-1){
								if(tabuleiro[d+1][s]!=tabuleiro[d][s] && tabuleiro[d][s-1]!=tabuleiro[d][s]){
									notAdjacente++;
								}
							}
							else{
								if(tabuleiro[d+1][s]!=tabuleiro[d][s] && tabuleiro[d][s+1]!=tabuleiro[d][s] && tabuleiro[d][s-1]!=tabuleiro[d][s]){
									notAdjacente++;
								}
							}
						}
						else if(d == r-1){
							if(s == 0){
								if(tabuleiro[d-1][s]!=tabuleiro[d][s] && tabuleiro[d][s+1]!=tabuleiro[d][s]){
									notAdjacente++;
								}
							}
							else if(s == r-1){
								if(tabuleiro[d-1][s]!=tabuleiro[d][s] && tabuleiro[d][s-1]!=tabuleiro[d][s]){
									notAdjacente++;
								}
							}
							else{
								if(tabuleiro[d-1][s]!=tabuleiro[d][s] && tabuleiro[d][s+1]!=tabuleiro[d][s] && tabuleiro[d][s-1]!=tabuleiro[d][s]){
									notAdjacente++;
								}
							}
						}
						else if(s == 0){
							if(d != 0 || d != r-1){
								if(tabuleiro[d+1][s]!=tabuleiro[d][s] && tabuleiro[d-1][s]!=tabuleiro[d][s] && tabuleiro[d][s+1]!=tabuleiro[d][s]){
									notAdjacente++;
								}
							}
						}
						else if(s == r-1){
							if(d !=0 || d != r-1){
								if(tabuleiro[d+1][s]!=tabuleiro[d][s] && tabuleiro[d-1][s]!=tabuleiro[d][s] && tabuleiro[d][s-1]!=tabuleiro[d][s]){
									notAdjacente++;
								}
							}
						}
						else{
							if(tabuleiro[d+1][s]!=tabuleiro[d][s] && tabuleiro[d-1][s]!=tabuleiro[d][s] && tabuleiro[d][s+1]!=tabuleiro[d][s] && tabuleiro[d][s-1]!=tabuleiro[d][s]){
								notAdjacente++;
							}
						}
					}
				}
			}
			// verificaçao se o jogo acabou ou nao.
			if(zeros==r*r || diferentes == notAdjacente){
				int score;
				score = (r*r)-diferentes;
				System.out.println("Terminou o jogo!");
				System.out.println("Numero de jogadas: " + njogadas);
				System.out.println("Score: " + score);
				break;
			}
			//Escolha da jogada.
			System.out.println("JOGADA");
			while(boleano=true){
				try{
					System.out.print("Linha(entre 1 e " + r + "): ");
					linha = input.nextInt() - 1;
					System.out.print("Coluna(entre 1 e " + r + "): ");
					coluna = input.nextInt() - 1;
				}catch(InputMismatchException error){
					System.out.println("Erro: " + error);
					input = new Scanner(System.in);
					continue;
				}
				if((linha>=0 && linha<=r-1) && (coluna>=0 && coluna<=r-1)){
					break;
				}
				else{
					System.out.println("Opção invalida.");
				}
			}
			njogadas++;
			//verificacoes em cadeia.
			int cor = tabuleiro[linha][coluna];
			v.verificacao(linha,coluna,tabuleiro,r,cor);
			for(int i = 0;i<v.lista.size();i=i+2){
				v.verificacao(v.lista.get(i), v.lista.get(i+1), tabuleiro, r, cor);
			}
			v.lista.clear();
			//Fazer descer as pecas em caso de buraco.
			for(int m =r -1; m>=0; m--){
	            for(int n = r -1;n>=0;n-- ){
	                if(tabuleiro[n][m]==0){
	                    for(int b=n-1; b>=0; b--){
	                        if(tabuleiro[b][m]!=0){
	                            tabuleiro[n][m]=tabuleiro[b][m];
	                            tabuleiro[b][m]=0;
	                            break;
	                        }
	                    }
	                }
	            }
			}
			//Empurrar as colunas da esquerda para
			//a direita, caso exista coluna a zero.
			for(int x = 1;x<r;x++){
				int t = 0;
				for(int y = 0;y<r;y++){
					if(tabuleiro[y][x]==0){
						t++;
					}
				}
				if(t==r){
					for(int i = 0;i<x;i++){
						for(int s = 0;s<=r-1;s++){
							tabuleiro[s][x-i]=tabuleiro[s][(x-i)-1];
							tabuleiro[s][(x-i)-1]=0;
						}
					}
				}
			}
			//Display do array bidimensional.
			System.out.println("Tabuleiro: " + r + "x" + r);
			System.out.println(string + "\n");
			for(int i = 0; i<r ;i++){
				for(int a = 0;a<r;a++){
					if(tabuleiro[i][a]==0){
						System.out.print("- ");
					}
					if(tabuleiro[i][a]==1){
						System.out.print("A ");
					}
					if(tabuleiro[i][a]==2){
						System.out.print("B ");
					}
					if(tabuleiro[i][a]==3){
						System.out.print("C ");
					}
					if(tabuleiro[i][a]==4){
						System.out.print("D ");
					}
					if(tabuleiro[i][a]==5){
						System.out.print("E ");
					}
					if(tabuleiro[i][a]==6){
						System.out.print("F ");
					}
				}
				System.out.print(" " + (i+1) + "\n");
			}
		}
	}
}
