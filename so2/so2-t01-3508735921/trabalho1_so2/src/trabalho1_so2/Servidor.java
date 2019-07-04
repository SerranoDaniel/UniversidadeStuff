package trabalho1_so2;

import java.util.Scanner;
import java.rmi.RemoteException;

public class Servidor {

    public static void main(String args[]) throws Exception {
        int porta = 1099; // default RMIRegistry port
        /*
        args[1] ->  host_BaseDados
        args[2] ->  nome_BaseDados
        args[3] ->  user_BaseDados
        args[4] ->  pass_BaseDados
         */

        try {
            if (args.length != 5) { // obrigar à presenca de argumentos
                System.out.println("Argumentos Errados!");
                System.exit(0);
            } else {
                porta = Integer.parseInt(args[0]);
            }

            // criar um Objeto Remoto
            ControloBD obj = new ControloBD(args[1], args[2], args[3], args[4]);

            java.rmi.registry.LocateRegistry.createRegistry(porta);

            java.rmi.registry.Registry registry = java.rmi.registry.LocateRegistry.getRegistry(porta);

            registry.rebind("questionario", obj);

            System.out.println("Bound RMI object in registry");

            System.out.println("Servidor Pronto");

            System.out.println("Pressionar 0 para fechar o servidor");

            Scanner scan = new Scanner(System.in);

            while (!scan.nextLine().equals("0")) {
                scan.next();
            }

            obj.fechaBD();
            System.exit(0);
        } catch (RemoteException e) {
            System.out.println("RMI Remote Exception!");
        }
    }
}
