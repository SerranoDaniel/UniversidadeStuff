import java.util.*; 

import java.text.*; 

class LoanCalc { 
  final int M_A = 12;  
  double impostosAnual = 11.4;
  double  valorEmprestimo, pagamentoMes, pagamentoTotal, impostosMes, scan, 
       periodoEmprestimo, numeroPagamentos; 
  
  void LoanCalc(){ 
    this.valorEmprestimo = valorEmprestimo; 
    this.periodoEmprestimo = periodoEmprestimo; 
    this.numeroPagamentos = numeroPagamentos;
    this.impostosMes = impostosMes;
    this.impostosAnual=impostosAnual; 
    this.pagamentoMes = pagamentoMes; 
    this.pagamentoTotal = pagamentoTotal;   
  }
  public double scanInput(){
    
    Scanner scanner = new Scanner(System.in); 
    scanner.useDelimiter(System.getProperty("line.separator"));
    //System.out.print("Introduza 3 input: \nValor do emprestimo, \nImposto anual,  \nPeriodo emprestimo");
    scan = scanner.nextDouble();
    //get input values 
    return scan;
  }
  public double scanis(){
    System.out.print("Valor do emprestimo (euros+centimos): "); 
    valorEmprestimo = scanInput(); 
    
    //System.out.print("imposto anual (e.g., 9.5): "); 
    //impostosAnual = scanInput(); 
    
    System.out.print("periodo emprestimo - # em anos: "); 
    periodoEmprestimo = scanInput();
    
    scan = valorEmprestimo + periodoEmprestimo;//+ impostosAnual + periodoEmprestimo;
    
    return scan;
    
  }
  public double calculos(double scan){
    //compute the monthly and total payments 
    impostosMes = impostosAnual / M_A / 100; 
    numeroPagamentos = periodoEmprestimo * M_A; 
    
    pagamentoMes = (valorEmprestimo * impostosMes) / (1 - Math.pow(1/(1 + impostosMes), numeroPagamentos ) ); 
    
    pagamentoTotal  =  pagamentoMes * numeroPagamentos; 
    
    return  pagamentoMes + pagamentoTotal;
  }
  
  public String toString(){
    DecimalFormat df = new DecimalFormat("0.00");
    //describe the program 
    System.out.println("This program computes the monthly and total"); 
    System.out.println("payments for a given loan amount, annual "); 
    System.out.println("interest rate, and loan period."); 
    System.out.println("Emprestimo anual, e.g., 12345.50"); 
    System.out.println("Imposto percentagem anual, e.g., 12.75"); 
    System.out.println("Periodo de emprestimo em anos, e.g., 15"); 
    System.out.println("\n"); //skip two lines 
    
    //display the result 
    System.out.println(""); 
    System.out.println("Eprestimo pedido: " + valorEmprestimo + " €"); 
    System.out.println("Imposto Anual:  " + impostosAnual + "%"); 
    System.out.println("Periodo de emprestimo:   " + periodoEmprestimo + " Anos"); 
    return ("Pagamento por Mes = "+ df.format(pagamentoMes) + " Pagamento Total com juros = " + df.format(pagamentoTotal));
    
  } 
  
}