package Agenda;

import EDA1.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by DanielSerrano on 28/12/2017.
 */
public class Agendaplementation {
    Agenda agenda = new Agenda();


    public void adicionarContacto(){
        Scanner scan = new Scanner(System.in);
        System.out.println("\nNovo contacto: \n   Introduza o nome: \n   Introduza 'Cancelar' para cancelar");
        String nome = scan.nextLine();
        if(nome.equalsIgnoreCase("Cancelar")){;
            System.out.println("");
            System.out.println("\n    Acção cancelada!\n");
            return;
        }
        int numero = 0;
        while(true){
            try{
                System.out.println("\n   Introduza o numero: \n   Introduza '0' para cancelar");
                numero = scan.nextInt();
                break;
            }
            catch (InputMismatchException e){
                System.out.println("\nINTRODUZA UM NUMERO!\n");
                scan.nextLine();
            }
        }
        if(numero == 0){

            System.out.println("\n    Acção cancelada!\n");
            return;
        }
        Contacto contacto = new Contacto(nome, numero);

        while(true){
            int resposta=0;
            try {
                System.out.println("\n Quer associar outro numero a este contacto?\n   1- Sim\n   2- Nao");
                resposta = scan.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("\nINTRODUZA UM NUMERO!\n");
                scan.nextLine();
            }
            if(resposta==1){
                int num= 0;
                while(true){
                    try{
                        System.out.println("\nIntroduza o numero\nIntroduza '0' para cancelar");
                        num = scan.nextInt();
                        break;
                    }
                    catch (InputMismatchException e){
                        System.out.println("\nINTRODUZA UM NUMERO!\n");
                        scan.nextLine();
                    }
                }
                if(num==0){
                    break;
                }
                contacto.addNumero(num);
            }else if(resposta==2){
                break;
            }else{
                System.out.print("\nOpcao invalida\n");
            }

        }
        agenda.insere(contacto);
        System.out.println("");
        System.out.println("Contacto adicionado com sucesso!\n");
        return;
    }

    public void listarContactos(){
        if(!agenda.isEmpty()) {
            System.out.print("\n");
            agenda.listarContacto();
            System.out.print("\n");
        }else{
            System.out.println("\nA agenda está vazia\n");
        }

    }


    public void editarContacto(){
        if(!agenda.isEmpty()) {
            Scanner scan = new Scanner(System.in);
            while (true) {
                System.out.print("\n");
                listarContactos();
                System.out.print("\nEscolha o nome do contacto a editar: ");
                String nome = scan.nextLine();
                if (agenda.containsNome(nome)) {
                    while (true) {
                        try {
                            System.out.println("\nO que deseja editar?\n   1- Nome\n   2- Numero\n   0- Cancelar");
                            int resposta = scan.nextInt();
                            if (resposta == 1) {
                                scan.nextLine();
                                System.out.print("\nIntroduza o novo nome: ");
                                String nomeNovo = scan.nextLine();
                                agenda.setNome(nome, nomeNovo);
                                System.out.println("\nNome modificado com sucesso!\n");
                                break;
                            } else if (resposta == 2) {
                                while (true) {
                                    System.out.println("\nQue acão deseja fazer?\n   1- Adicionar\n   2- Editar\n   3- Remover   \n   0- Cancelar");
                                    try {
                                        int acao = scan.nextInt();
                                        if (acao == 1) {
                                            int numAdd = 0;
                                            while (true) {
                                                try {
                                                    System.out.print("\nIntroduza o numero a adicionar: ");
                                                    numAdd = scan.nextInt();
                                                    break;
                                                } catch (InputMismatchException e) {
                                                    System.out.println("\nINTRODUZA UM NUMERO!\n");
                                                    scan.nextLine();
                                                }

                                            }
                                            agenda.addContacto(nome, numAdd);
                                            System.out.print("\nNumero adicionado com sucesso!\n");
                                            break;
                                        } else if (acao == 2) {
                                            int num = 0;
                                            int numNovo = 0;
                                            System.out.print(agenda.showNumeros(nome));
                                            while (true) {
                                                System.out.println("\nQual o indice do numero a editar?");
                                                try {
                                                    num = scan.nextInt();
                                                    if (num > 0 && num <= agenda.sizeContacto(nome)) {
                                                        break;
                                                    }
                                                } catch (InputMismatchException e) {
                                                    System.out.println("\nINTRODUZA UM NUMERO!\n");
                                                    scan.nextLine();
                                                }
                                            }
                                            while (true) {
                                                System.out.print("\nIntroduza o numero novo: ");
                                                try {
                                                    numNovo = scan.nextInt();
                                                    break;
                                                } catch (InputMismatchException e) {
                                                    System.out.println("\nINTRODUZA UM NUMERO!\n");
                                                    scan.nextLine();
                                                }
                                            }
                                            agenda.setNumero(nome, num, numNovo);
                                            System.out.println("\nNumero modificado com sucesso!\n");
                                            break;
                                        } else if (acao == 3) {
                                            System.out.print(agenda.showNumeros(nome));
                                            int numInd=0;
                                            while (true) {
                                                System.out.println("\nQual o indice do numero a remover?");
                                                try {
                                                    numInd = scan.nextInt();
                                                    if (numInd > 0 && numInd <= agenda.sizeContacto(nome)) {
                                                        break;
                                                    }
                                                } catch (InputMismatchException e) {
                                                    System.out.println("\nINTRODUZA UM NUMERO!\n");
                                                    scan.nextLine();
                                                }
                                            }
                                            System.out.println("");
                                            agenda.removeNumber(nome,numInd-1);
                                            System.out.println("");
                                            System.out.println("\nNumero removido com sucesso!\n");
                                            break;
                                        } else if (acao == 0) {
                                            System.out.print("\nOperacao cancelada!\n");
                                            break;
                                        } else {
                                            System.out.println("\nEscolha uma opcao valida\n");
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.println("\nINTRODUZA UM NUMERO!\n");
                                        scan.nextLine();
                                    }
                                }
                                break;
                            } else if (resposta == 0) {
                                System.out.print("\nOperacao cancelada!\n");
                                break;
                            } else {
                                System.out.print("\nEscolha uma opcao valida\n");
                                scan.nextLine();
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("\nINTRODUZA UM NUMERO!\n");
                            scan.nextLine();
                        }
                    }
                    break;
                } else {
                    System.out.print("\nNome invalido\n");
                }
            }
        }else{
            System.out.println("\nA agenda está vaia\n");
        }
    }

    public void procurarTelefone(){
        if(!agenda.isEmpty()) {
            Scanner scan = new Scanner(System.in);
            while (true) {
                try {
                    System.out.println("\nIntroduza o numero que procura: \nIntrouza '0' para cancelar");
                    int numProcurado = scan.nextInt();
                    scan.nextLine();
                    if(numProcurado==0){
                        break;
                    }else if (agenda.containsNum(numProcurado)) {
                        System.out.println("\nContacto: " + agenda.getContactoStringWithNumber(numProcurado) + "\n");
                        break;
                    } else {
                        while (true) {
                            try {
                                System.out.println("\nO numero introduzido não pertence à lista de contactos\n Deseja visualizar a lista de contactos?\n   1- Sim\n   2- Nao");
                                int respostaElse = scan.nextInt();
                                if (respostaElse == 1) {
                                    System.out.print("\n");
                                    agenda.listarContacto();
                                    scan.nextLine();
                                    break;
                                } else if (respostaElse == 2) {
                                    scan.nextLine();
                                    break;
                                } else {
                                    scan.nextLine();
                                    System.out.print("\nEscolha uma opcao valida\n");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("\nINTRODUZA UM NUMERO!\n");
                                scan.nextLine();
                            }
                        }
                    }
                }catch (InputMismatchException e) {
                    System.out.println("\nINTRODUZA UM NUMERO!\n");
                    scan.nextLine();
                }

            }
        }else{
            System.out.println("\nA agenda está vazia\n");
        }
    }

    public void exportarContactos() throws OverflowException, EmptyException{
        if(!agenda.isEmpty()) {
            System.out.println("");
            QueueC queue = new QueueC();
            for (int x = 0; x < agenda.size; x++) {
                queue.enqueue(agenda.getContacto(x));
            }
            for (int i = 0; i < agenda.size; i++) {
                System.out.println(queue.dequeue());
            }
            System.out.println("");
        }else{
            System.out.println("\nA agenda está vazia\n");
        }
    }

    public void removerContacto() {
        if (!agenda.isEmpty()) {
            Scanner scan = new Scanner(System.in);
            while(true) {
            listarContactos();
            System.out.println("\nEscolha o nome contacto a remover: \nIndroduza 'Cancelar' para cancelar");
            String contactoRemove = scan.nextLine();
                if (agenda.containsNome(contactoRemove)) {
                    agenda.remove(contactoRemove);
                    System.out.println("\nContacto removido com sucesso!\n");
                    break;
                } else if(contactoRemove.equalsIgnoreCase("cancelar")){
                    System.out.println("\nOperacao cancelada!");
                    break;
                } else {
                    System.out.print("\nIntroduza um nome válido\n");
                }
            }
        } else {
            System.out.println("\nA agenda está vazia\n");
        }
    }
}
