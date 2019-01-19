package Agenda;

import EDA1.*;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by DanielSerrano on 25/12/2017.
 */
public class Main {
    Scanner scan = new Scanner(System.in);

    public int menu() {
        while(true){
            try {
                System.out.print("AGENDA\n   (1) - Adicionar Contacto\n   (2) - Listar Contactos\n   (3) - Editar Contacto\n" +
                        "   (4) - Procurar Telefone\n   (5) - Exportar para Queue\n   (6) - Remover Contacto\n   (0) - Sair\nEscolha o indice de uma das opções: ");
                int option = scan.nextInt();
                return option;
            }
            catch (InputMismatchException e){
                System.out.println("\nINTRODUZA UM NUMERO!\n");
                scan.nextLine();
            }
        }
    }

    public static void main(String[] args) throws OverflowException, EmptyException {
        Main agenda = new Main();
        Agendaplementation agendafunc = new Agendaplementation();

        while(true){
            switch(agenda.menu()){
                case 1: agendafunc.adicionarContacto();
                        break;
                case 2: agendafunc.listarContactos();
                        break;
                case 3: agendafunc.editarContacto();
                        break;
                case 4: agendafunc.procurarTelefone();
                        break;
                case 5: agendafunc.exportarContactos();
                        break;
                case 6: agendafunc.removerContacto();
                        break;
                case 0: System.exit(0);
                default: System.out.println("\nOpcao invalida\n");
                        break;
            }
        }

    }

}
