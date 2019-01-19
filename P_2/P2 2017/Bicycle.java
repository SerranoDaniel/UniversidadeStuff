class Bicycle{
  
    private String donoNome;
    
    public void Bicycle(){
      donoNome = "Dono";
    }
    
    public void setDonoNome(String nome){
      donoNome = nome;
    }
    public String getDonoNome(){
      return donoNome;
    }
    public String toString(){
      return " O " + donoNome + " é dono de uma bicicleta "  ;
    }
}