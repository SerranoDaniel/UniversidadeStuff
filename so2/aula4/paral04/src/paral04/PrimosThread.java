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
public class PrimosThread extends Thread{
    int inicio;
    int fim;
    
    public PrimosThread() {
        super();
        this.inicio= 0;
        this.fim= 10;
    }
    public PrimosThread(int inicio, int fim) {
        super();
        this.inicio= inicio;
        this.fim= fim;
    }    
    
    public void run() {
        Primos p= new Primos(inicio,fim);
        p.go();
    }
}
