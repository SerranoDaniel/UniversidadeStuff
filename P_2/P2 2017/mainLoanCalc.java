import java.util.*;

class mainLoanCalc {

    public static void main( String[] args ) {     
        LoanCalc lC = new LoanCalc();
        Double name = lC.scanis();
        lC.calculos(name);
        System.out.print(lC.toString());
    }
}