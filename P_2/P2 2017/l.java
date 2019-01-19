import java.util.*;
import java.util.regex.*;

class l {
  
  public static void main (String[] args) {
    
    ex3("Inscrito a FG2 que é de FIS3452 mas contente!");
    
    
  }
  
  private static void ex3 (String question) {
    
    Scanner s = new Scanner(System.in);
    System.out.println(question);
    Pattern p = Pattern.compile("([A-Z][A-Z][A-z][0-9]+)"); //expressão regular alinea a) e alinea b)
    String word;
    Matcher m;
    String frase = " ";
    String input = s.nextLine();
    Scanner i = new Scanner(input);
    while(i.hasNext()){
        word = i.next();
        if (word.length()>3){
          m = p.matcher(word.substring(0,7));
          if(m.matches()){
            if (word.substring(0,7).equals("INF0881"))
              frase += " uma UC do Departamento de Informatica ";
            if (word.substring(0,7).equals("GES7659"))
              frase += " uma UC do Departamento de Gestao ";
            if (word.substring(0,7).equals("FIS3452"))
              frase += " uma UC do Departamento de Fisica ";
            if (word.substring(0,7).equals("QUI3456"))
              frase += " uma UC do Departamento de Quimica ";
            if (word.substring(0,7).equals("PED1234"))
              frase += " uma UC do Departamento de Pedagogia ";
            if (word.substring(0,7).equals("MAT8907"))
              frase += " uma UC do Departamento de Matematica ";
          }
          else{
          frase += " " + word + " ";
        }
        }
        else{
          frase += " " + word + " ";
        }
    }
    System.out.println(frase);
  }        
}