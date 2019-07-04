/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

/**
 *
 * @author tiago
 */
public class ClubeServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         
	// assume-se que o Servico de Nomes e' local
	// pode ser um processo autonomo ou 
	// parte desta aplicacao servidor
	// aqui usamos o externo

	int regPort= 9000; // default RMIRegistry port

	if (args.length !=1) { // obrigar 'a presenca de um argumento
	    System.out.println("Usage: java so2.rmi.ClubeServer registryPort");
	    System.exit(1);
	}
	

	try {
	    // ATENCAO: este porto e' relativo ao binder e nao ao servidor RMI
	    regPort=Integer.parseInt(args[0]);


	    // criar um Objeto Remoto
	    Clube obj= new ClubeImplem();


	    // registar este objeto no servico de nomes
            
            /**
             * Se quiser substituir o processo rmiregisty...
             * pode ativar o servidor de nomes neste mesmo processo (antes do bind)
             */
            java.rmi.registry.LocateRegistry.createRegistry(regPort);            
            
            
	    // usar o Registry local (em execução na mesma máquina)
            // e no porto regPort
	    java.rmi.registry.Registry registry = java.rmi.registry.LocateRegistry.getRegistry(regPort);

            // mas podiamos tb criar um novo, 
	    // integrado nesta mesma aplicacao servidor!

	    // ... e bind
	    registry.rebind("Clube", obj);  // NOME DO SERVICO

	    /*
	      OUTRO MODO, indicando o servidor onde está o serviço de nomes
	    java.rmi.Naming.rebind("rmi://"+regHost+":" +
				   regPort + "/palavras", stub);
	    
	    */
	    System.out.println("Bound RMI object in registry");

            System.out.println("servidor pronto");
	} 
	catch (Exception ex) {
	    ex.printStackTrace();
	}
    }
    
}
       
   
