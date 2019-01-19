import java.util.*;

class Monograma {
  
        private String  nome, inicio, meio, penul, ultima, espaco, monograma;
        
  public void Monograma(){
  
        this.nome = nome;
        this.inicio = inicio;
        this.meio = meio;
        this.penul = penul;
        this.ultima = ultima;
        this.espaco = espaco;
        this.monograma = monograma;
  }

    public String anagramScanner(  ) {
        //Input the full name
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter(System.getProperty("line.separator"));
        System.out.print("Enter your full name (primeiro, segundo, terceiro, quarto): \n");
        nome = scanner.next( );
        //System.out.print("O teu nome completo é : \n" + nome + "\n");
        return nome ;
        
    }
    public String extrair(String nome){
      espaco = " ";
      inicio = nome.substring(0,nome.indexOf(espaco));//subS(0,espaco)     
      nome = nome.substring(nome.indexOf(espaco)+1,nome.length());//subS(espaco1+espaco, comprimento1palavra) = novo zero
      meio = nome.substring(0, nome.indexOf(espaco));//subS(novo zero, ate espaco2 )
      penul = nome.substring(nome.indexOf(espaco)+1, nome.length());//espaco2 +1 final do espaco2 = novo zero 
      nome = nome.substring(nome.indexOf(espaco)+1,nome.length());//serve para avancar da segunda para terceira palavra      
      ultima= nome.substring(nome.indexOf(espaco)+1, nome.length()); //(do final do espaco da terceira, ate a quarta)

        //Verifica substring
        //System.out.println("First:"  + inicio);
        //System.out.println("Middle:" + meio);
        //System.out.println("penultima:"   + fim);
        //System.out.println("ultima:"   + quatro);
      
      //Compute o monogram
      //ate aqui isolamos as palavras do nome
      //agora usando a subString vamos isolar as letras pretendidas utilizando (0,1) primeira letra
      monograma = inicio.substring(0, 1)
                    + meio.substring(0, 1)
                        + penul.substring(0, 1)
                            +ultima.substring(0,1);
      return monograma;
      
    }
      public String toString(){
        
        

        //Output the result
        System.out.print("O teu nome completo é : \n" + nome + "\n");
        return ("O teu monograma é :\n" + inicio.substring(0, 1) + "." + meio.substring(0, 1) + "." +penul.substring(0, 1) +"." + ultima.substring(0, 1) +".\n" + "E tens uma ROLA");//Ivo Miguel Direitinho Rego
    }
    }

