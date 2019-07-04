/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author tiago
 */
public class ClubeCliente {
    public static void main(String args[]) throws NotBoundException, RemoteException {
	Scanner sc = new Scanner(System.in);
        String regHost="localhost" ;
	String regPort="9000" ;  // porto do binder
        
	if (args.length !=2) { // requer 2 argumentos
	    System.out.println
		("Usage: java so2.rmi.ClubeCliente registryHost registryPort ");
	    System.exit(1);
	}
	regHost= args[0];
	regPort= args[1];


	try {
	    // objeto que fica associado ao proxy para objeto remoto
	    Clube obj =	(Clube) java.rmi.Naming.lookup("rmi://" + regHost + ":" + regPort + "/Clube");
					  
         while (true){  
                 
	    System.err.println("#############Menu############");
            
            System.err.println("1 - Listar Campos ");
            System.err.println("2 - Listar Reservas ");
            System.err.println("3 - Verificar Reserva de um Campo");
            System.err.println("4 - Fazer Reserva");
            System.err.println("5 - Sair");
            
            System.err.println("Insira a opção que pretende:");
	    int x = sc.nextInt();
            
            //Escolhe ver os campos
            if (x== 1){
            ArrayList<String> lista= obj.GetCampos();
            for (String list1 : lista){
                System.out.println(list1);}  
            
            } 
            
            //Escolhe ver as reservas
            if (x== 2){
              System.err.println("Qual o campo que pretende? ");
              String Campo=sc.next();
            ArrayList<String> lista= obj.ReservaCampos(Campo);
            for (String list1 : lista){
                System.out.println(list1);
            }
            }
            
            //Escolhe verificar a disponibilidade de um campo
            if(x==3){
               System.err.println("Qual o campo que pretende? ");
               String Campo=sc.next();
               System.err.println("Qual a data? Formato:2016-01-02 08:33:00");
               String data=sc.next( );
             boolean f= obj.VerificarCampo(Campo,data);
            System.out.println(f);
                
               
            if(f==false){
                System.out.println("Está Ocupado!");
            }
            else{
                System.out.println("Siga Jogar!");
            }
            }
            
            
            //Escolhe fazer uma reserva
            if(x==4){
               System.err.println("Introduza o seu nome:");
               String nome=sc.next();
               
               System.err.println("Introduza o seu contacto:");
               int telemovel=sc.nextInt();
               
               
               System.err.println("Qual o campo q pretende alugar:");
               String campo=sc.next();
               
               System.err.println("Data de Inicio:");
               sc.nextLine();
               String di=sc.nextLine();
               
               System.err.println("Data Final:");
               String df=sc.nextLine();
               
               System.err.println("Numero de utilizadores:");
               int uti=sc.nextInt();
               
            double f= obj.FazerReserva( nome, telemovel, campo, di, df,  uti);
            if (f!=0){
            System.out.println("Reserva feita com sucessso com um custo de "+f+"patacas!");
            
            break;}
           }
           if(x==5){
           break;
           } 
               
               
           }
         
    
        }
          
        
        
	catch (Exception ex) {
	    ex.printStackTrace();
	}
}
}
    

