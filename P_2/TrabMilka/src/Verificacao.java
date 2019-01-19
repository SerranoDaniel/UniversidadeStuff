package trabalho;

import java.util.ArrayList;

/**
 * Classe que cria uma lista onde mete as posicoes adjacentes, iguais à cor da jogada, nesta mesma e coloca-as a 0 e à posicao utilizada.
 * Efectua todas as verificacoes necessarias, dependendo das coordenadas.
 */

public class Verificacao {
	static ArrayList<Integer> lista = new ArrayList<>();
	public void verificacao(int linha, int coluna,int tabuleiro[][],int r, int cor){
		boolean z = false;
		if(linha == 0){
			if(coluna == 0){
				if(tabuleiro[linha+1][coluna]==cor){
					z = true;
					tabuleiro[linha+1][coluna]=0;
					lista.add(linha+1);
					lista.add(coluna);
				}
				if(tabuleiro[linha][coluna+1]==cor){
					z = true;
					tabuleiro[linha][coluna+1]=0;
					lista.add(linha);
					lista.add(coluna+1);
				}
				if(z == true){
					tabuleiro[linha][coluna]=0;
					
				}
			}
			else if(coluna == r-1){
				if(tabuleiro[linha+1][coluna]==cor){
					z = true;
					tabuleiro[linha+1][coluna]=0;
					lista.add(linha+1);
					lista.add(coluna);
				}
				if(tabuleiro[linha][coluna-1]==cor){
					z = true;
					tabuleiro[linha][coluna-1]=0;
					lista.add(linha);
					lista.add(coluna-1);
				}
				if(z == true){
					tabuleiro[linha][coluna]=0;
				}
			}
			else{
				if(tabuleiro[linha+1][coluna]==cor){
					z = true;
					tabuleiro[linha+1][coluna]=0;
					lista.add(linha+1);
					lista.add(coluna);
				}
				if(tabuleiro[linha][coluna+1]==cor){
					z = true;
					tabuleiro[linha][coluna+1]=0;
					lista.add(linha);
					lista.add(coluna+1);
				}
				if(tabuleiro[linha][coluna-1]==cor){
					z = true;
					tabuleiro[linha][coluna-1]=0;
					lista.add(linha);
					lista.add(coluna-1);
				}
				if(z == true){
					tabuleiro[linha][coluna]=0;
				}
			}
		}
		else if(linha == r-1){
			if(coluna == 0){
				if(tabuleiro[linha-1][coluna]==cor){
					z = true;
					tabuleiro[linha-1][coluna]=0;
					lista.add(linha-1);
					lista.add(coluna);
				}
				if(tabuleiro[linha][coluna+1]==cor){
					z = true;
					tabuleiro[linha][coluna+1]=0;
					lista.add(linha);
					lista.add(coluna+1);
				}
				if(z == true){
					tabuleiro[linha][coluna]=0;
				}
			}
			else if(coluna == r-1){
				if(tabuleiro[linha-1][coluna]==cor){
					z = true;
					tabuleiro[linha-1][coluna]=0;
					lista.add(linha-1);
					lista.add(coluna);
				}
				if(tabuleiro[linha][coluna-1]==cor){
					z = true;
					tabuleiro[linha][coluna-1]=0;
					lista.add(linha);
					lista.add(coluna-1);
				}
				if(z == true){
					tabuleiro[linha][coluna]=0;
				}
			}
			else{
				if(tabuleiro[linha-1][coluna]==cor){
					z = true;
					tabuleiro[linha-1][coluna]=0;
					lista.add(linha-1);
					lista.add(coluna);
				}
				if(tabuleiro[linha][coluna+1]==cor){
					z = true;
					tabuleiro[linha][coluna+1]=0;
					lista.add(linha);
					lista.add(coluna+1);
				}
				if(tabuleiro[linha][coluna-1]==cor){
					z = true;
					tabuleiro[linha][coluna-1]=0;
					lista.add(linha);
					lista.add(coluna-1);
				}
				if(z == true){
					tabuleiro[linha][coluna]=0;
				}
			}
		}
		else if(coluna == 0){
			if(linha != 0 | linha != r-1){
				if(tabuleiro[linha+1][coluna]==cor){
					z = true;
					tabuleiro[linha+1][coluna]=0;
					lista.add(linha+1);
					lista.add(coluna);
				}
				if(tabuleiro[linha-1][coluna]==cor){
					z = true;
					tabuleiro[linha-1][coluna]=0;
					lista.add(linha-1);
					lista.add(coluna);
				}
				if(tabuleiro[linha][coluna+1]==cor){
					z = true;
					tabuleiro[linha][coluna+1]=0;
					lista.add(linha);
					lista.add(coluna+1);
				}
				if(z == true){
					tabuleiro[linha][coluna]=0;
				}
			}
		}
		else if(coluna == r-1){
			if(linha !=0 | linha != r-1){
				if(tabuleiro[linha+1][coluna]==cor){
					z = true;
					tabuleiro[linha+1][coluna]=0;
					lista.add(linha+1);
					lista.add(coluna);
				}
				if(tabuleiro[linha-1][coluna]==cor){
					z = true;
					tabuleiro[linha-1][coluna]=0;
					lista.add(linha-1);
					lista.add(coluna);
				}
				if(tabuleiro[linha][coluna-1]==cor){
					z = true;
					tabuleiro[linha][coluna-1]=0;
					lista.add(linha);
					lista.add(coluna-1);
				}
				if(z == true){
					tabuleiro[linha][coluna]=0;
				}
			}
		}
		else{
			if(tabuleiro[linha+1][coluna]==cor){
				z = true;
				tabuleiro[linha+1][coluna]=0;
				lista.add(linha+1);
				lista.add(coluna);
			}
			if(tabuleiro[linha-1][coluna]==cor){
				z = true;
				tabuleiro[linha-1][coluna]=0;
				lista.add(linha-1);
				lista.add(coluna);
			}
			if(tabuleiro[linha][coluna+1]==cor){
				z = true;
				tabuleiro[linha][coluna+1]=0;
				lista.add(linha);
				lista.add(coluna+1);
			}
			if(tabuleiro[linha][coluna-1]==cor){
				z = true;
				tabuleiro[linha][coluna-1]=0;
				lista.add(linha);
				lista.add(coluna-1);
			}
			if(z == true){
				tabuleiro[linha][coluna]=0;
			}
		}
	}
}
