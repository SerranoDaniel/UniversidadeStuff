/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paral04;

/**
 *
 * @author danas
 */
public class Primos {
    private int start;
    private int end;
    
    
    public Primos(int start, int end) {
        this.start= start;
        this.end= end;
    }
    
    int count_primes(int start, int end) {
        int total = 0;
        int i = start; // check if prime    
        while (i <= end) {
            int c;
            for (c = 2; c <= i - 1; c++) {
                if (i % c == 0) {
                    break;
                }
            }
            if (c == i) {
                //printf("%d\n", i);
                total++;
            }
            i++;   // next prime candidate
        }
        return total;
    }

    public void go() {
	
        int found_primes = count_primes(start, end);
        System.out.println("  found "+found_primes);

    }
    
}
