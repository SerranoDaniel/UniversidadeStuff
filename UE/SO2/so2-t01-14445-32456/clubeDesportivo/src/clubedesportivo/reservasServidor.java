/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clubedesportivo;

import java.sql.DriverManager;

/**
 *
 * @author ruirodrigues
 */
public class reservasServidor {
    
    public static void main(String[] args) {
        
        int regPort = 1099;
        
        if (args.length !=5) {
	    System.out.println("Usage: ./server.sh port host db user pwd");
	    System.exit(1);
	}
        
        try{
            regPort=Integer.parseInt(args[0]);
            
            System.out.println(java.net.InetAddress.getLocalHost());
            
            reservasClube obj = new reservasImpl(args[1], args[2], args[3], args[4]);
            
            //java.rmi.registry.Registry registry = java.rmi.registry.LocateRegistry.getRegistry(regPort);
            java.rmi.registry.Registry registry = java.rmi.registry.LocateRegistry.createRegistry(regPort);
            registry.rebind("reservasClube", obj);
            
            System.out.println("Bound RMI object in registry");
            System.out.println("servidor pronto");
        }
        catch (Exception ex) {
	    ex.printStackTrace();
	}
    }
    
}
