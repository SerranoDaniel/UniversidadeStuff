class Account{
  private String donoNome;
  private double saldoInicial;
  
  double saldoFinalSub;
  double saldoFinalSum;
  public void Account(){
    this.donoNome = " ";
    this.saldoInicial = 0.0;
  }
  public void somar(double amt){
      saldoFinalSum = saldoInicial + amt;
    }
    public void subtrair(double amt){
      saldoFinalSub = saldoInicial - amt;
    }
    public double getSaldoDisponivel(){
      return saldoInicial;
    }
    public String getDonoNome(){
      return donoNome;
    }
    public void setSaldoInicial(double bal){
      this.saldoInicial = (int)bal;
    }
    
    public void setDonoNome(String nome){
      this.donoNome = nome;
    }
    public String toString(){
      return "O dono desta conta é " + donoNome 
         + " o saldo inicial da conta é " + (int)saldoInicial  
         + "€ depois de levantar 200€ ficou com " + (int)saldoFinalSub + "€";
      
    }
      
      
                  
}