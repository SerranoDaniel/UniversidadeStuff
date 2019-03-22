/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paral04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author danas
 */
public class PrimosThreadPool extends Thread{
    
     public static void main(String[] args) {
        
        PrimosThread p1 = new PrimosThread(0, 50000);
        PrimosThread p2 = new PrimosThread(50000, 100000);
        PrimosThread p3 = new PrimosThread(100000, 150000);
        PrimosThread p4 = new PrimosThread(150000, 200000);
        
        ExecutorService pool = Executors.newFixedThreadPool(4);
        
        pool.execute(p1);
        pool.execute(p2);
        pool.execute(p3);
        pool.execute(p4);
        
    }
}
