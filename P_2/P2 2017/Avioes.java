// http://www.newthinktank.com/2014/06/java-programming/  
import java.util.Scanner;
import java.util.*;

// A class defines the attributes (fields) and capabilities (methods) of a real world object

public class Avioes { //cabecalho
  private String marca;  //atributos
  private String modelo; //atributos
  
  public Avioes(String ma, String mo){//construtor
    marca = ma;
    modelo = mo;
  }
  
  public void setMarca(){//metodo seletor
    marca = ma;
  }

  public String getMarca(){//metodo seletor
    return marca;
  }
}