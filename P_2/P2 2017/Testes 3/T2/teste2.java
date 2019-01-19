import java.math.*;

public class teste2{

  public static void main(String[] args){
  int j = 4;
  int k = 5;
  int m,n,i = 3;
  float v,w,x = 34.5f;
  float y = 12.25f;
  
  
  double alineaA = Math.pow(3,Math.pow(i,j));
  double alineaB = x/i;
  double alineaC = Math.ceil(y)%k;
  double alineaD = (int)x/y*i/2;
  double alineaE = Math.sqrt(i*i-4*j*k);
  //double  alineaF = n+i*j;
  double alineaG = k/(j*i)*x+y;
  double alineaH = i+1;
  double alineaI = int(x+i);
  double alineaJ = x/i/y/j;
  
  System.out.println("Alinea a = " + alineaA);
  System.out.println("((3)^3)^4 = "+ Math.pow(3,Math.pow(i,j))+ " Obtem-se double\n\n");
  
  System.out.println("Alinea b = " + alineaB);
  System.out.println(" 34.5f/3 = "+ x/i + " Obtem-se double\n\n");
  
  System.out.println("Alinea c = "+ alineaC);
  System.out.println(" 13%5 = " + Math.ceil(y)%k + " Obtem-se double\n\n");
  
  System.out.println("Alinea d = "+ alineaD);
  System.out.println("cast para int (int)34/12*3/2 = " + (int)x/y*i/2 + " -> Com um cast altera-se o tipo mas nao se altera o valor\n\n");
  
  System.out.println("Alinea e = "+ alineaE);
  System.out.println(" Quando se calcula a raiz quadrada de um numero negativo o resultado e = '" + Math.sqrt(i*i-4*j*k) + "' significa 'Not a Number' pois nao esta definido \n Acontece quando uma operacao de floating point tem parametros de input que produzem resultado indefinido\n\n");
  
  //System.out.println("Alinea f = "+ alineaF);
  System.out.println(" Alinea f = n+i*j da um erro de inicializacao de variavel a variavel 'n' esta mal inicializada so e possivel inicializar duas variaveis de cada vez na mesma linha utilizando o metodo aplicado no enunciado\n\n");
  //System.out.println("Alinea f = "+ alineaF);
  
  System.out.println("Alinea g = "+ alineaG);
  System.out.println("O resultado segue as \n regras PEMDAS ->Parentesis Expoente Multiplicacao Divisao Adicao Subtracao");
  double pP = j*i;
  double sM = pP * x;
  double tD = k / sM;
  double qA = tD+y;
  System.out.println(qA);
  
 
  System.out.println("Alinea h = "+ alineaH + "\n\n");
  
  System.out.println("Alinea i = erro");
  System.out.println("Da erro '.class' expected not a statement, incorreto cast nao e possivel converter para float\n\n");
  
  System.out.println("Alinea j = "+ alineaJ);
  System.out.println("Vai dividindo pela ordem disposicao das variaveis ate chegar a ultima variavel\n\n");
  
  System.out.println("Raiz cubica de 2 = " + Math.pow(2,1/3) + "\n\n");
  
  
  }
}
  