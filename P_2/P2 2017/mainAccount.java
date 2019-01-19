class mainAccount{
public static void main(String[] args){
 Bicycle bik = new Bicycle();
//  String nome1 = "Jervasio";
//  String nome2 = "Anastacio";
  Account acct = new Account();
  
  bik.setDonoNome("Jervasio");
  acct.setDonoNome("Anastacio");
  acct.setSaldoInicial(1300);
 acct.somar(200);
 acct.subtrair(200);
 System.out.println("O saldo disponivel é : "+(int)acct.getSaldoDisponivel() + "€");
  System.out.println(acct.toString() + "\n" + bik.toString());
  
}
}