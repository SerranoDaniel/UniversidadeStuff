import java.util.*;
import java.util.regex.*;




class UC {
  String word ;Matcher ma; String frase ;
  void UC(){
    String word ; Matcher ma; String frase ;
  }
  public String encontraUC () {
    
    Scanner s = new Scanner(System.in);
    System.out.println("Introduza o codigo UC");
    String input = s.nextLine();
    Pattern pat = Pattern.compile("([A-Z][A-Z][A-z][0-9]+)"); //expressão regular alinea a) e alinea b)
    frase = " ";
    Scanner i = new Scanner(input);
    while(i.hasNext()){
      word = i.next();
      if (word.length()>3){
        ma = pat.matcher(word.substring(0,7));
        if(ma.matches()){
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
    return (frase);
  }        
}