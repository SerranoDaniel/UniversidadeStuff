/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clubedesportivo;

import static java.lang.Thread.sleep;
import java.rmi.RemoteException;
import java.util.*;

/**
 *
 * @author ruirodrigues
 */
public class reservasCliente {

    static Scanner scanner;
    static Vector<String> reservas;
    static Vector<Integer> aux;
    static Calendar cal = Calendar.getInstance();
    static String data;
    static int intInputValue;

    static int cYear = cal.get(Calendar.YEAR);
    static int cMonth = cal.get(Calendar.MONTH) + 1;
    static int cDay = cal.get(Calendar.DAY_OF_MONTH);
    static int cHour = cal.get(Calendar.HOUR_OF_DAY);

    public static int inputInt(int min, int max, Scanner scanner) {
        while (true) {
            String choice = scanner.next();
            try {
                intInputValue = Integer.parseInt(choice);
                if (intInputValue > min && intInputValue < max) {
                    break;
                }
                System.out.println("Input Inválido\n");
                System.out.println("Tente Novamente:");
            } catch (NumberFormatException | InputMismatchException ne) {
                System.out.println("Input Inválido\n");
                System.out.println("Tente Novamente:");
            }
        }
        return intInputValue;
    }

    public static void menuInicio(reservasClube obj) throws RemoteException, InterruptedException {
        System.out.println("");
        System.out.println("   ##########################################");
        System.out.println("   ##    Aluguer de Espaços Desportivos    ##");
        System.out.println("   ## Clube Desportivo da Praça do Giraldo ##");
        System.out.println("   ##########################################");
        System.out.println("   #                                        #");
        System.out.println("   #    1-         Consulta                 #");
        System.out.println("   #    2-         Reservar                 #");
        System.out.println("   #                                        #");
        System.out.println("   #    3-           Sair                   #");
        System.out.println("   #                                        #");
        System.out.println("   ##########################################");
        System.out.println("");

        scanner = new Scanner(System.in);

        switch (inputInt(0, 4, scanner)) {
            case 1:
                menuConsulta(obj);
                break;
            case 2:
                fazerReserva(obj);
                sleep(1000);
                menuInicio(obj);
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida, tente de novo");
                menuInicio(obj);
        }
    }

    private static Vector inputData() {
        aux = new Vector();
        System.out.println("Ano: ");
        int ano = inputInt(cYear-1, 999999, scanner);
        aux.add(ano);

        System.out.println("Mês: ");
        int mes = 99;
        while (true) {
            mes = inputInt(0, 13, scanner);
            if (ano == cYear && mes >= cMonth && mes < 13 || ano != cYear && mes > 0 && mes < 13) {
                break;
            }else{
                System.out.println("Input Inválido\n");
                System.out.println("Tente Novamente:");
            }
        }
        aux.add(mes);
        
        System.out.println("Dia: ");
        int dia = 60;
        while (true) {
            dia = inputInt(0, 32, scanner);
            if (ano == cYear && mes == cMonth && cMonth == 2 && dia >= cDay && dia < 29
                    || ano == cYear && mes == cMonth && cMonth % 2 == 0 && mes < 8 && dia >= cDay && dia < 31
                    || ano == cYear && mes == cMonth && cMonth % 2 != 0 && mes > 7 && dia >= cDay && dia < 31
                    || ano == cYear && mes == cMonth && cMonth % 2 == 0 && mes > 7 && dia >= cDay && dia < 32
                    || ano == cYear && mes == cMonth && cMonth % 2 != 0 && mes < 8 && dia >= cDay && dia < 32
                    || ano == cYear && mes != cMonth && cMonth % 2 == 0 && mes < 8 && dia >= 1 && dia < 31
                    || ano == cYear && mes != cMonth && cMonth % 2 != 0 && mes > 7 && dia >= 1 && dia < 31
                    || ano == cYear && mes != cMonth && cMonth % 2 == 0 && mes > 7 && dia >= 1 && dia < 32
                    || ano == cYear && mes != cMonth && cMonth % 2 != 0 && mes < 8 && dia >= 1 && dia < 32
                    || ano != cYear && mes == 2 && dia > 1 && dia < 29
                    || ano != cYear && mes % 2 == 0 && mes < 8 && dia > 1 && dia < 31
                    || ano != cYear && mes % 2 == 0 && mes > 7 && dia > 1 && dia < 32
                    || ano != cYear && mes % 2 != 0 && mes > 7 && dia > 1 && dia < 31
                    || ano != cYear && mes % 2 != 0 && mes < 8 && dia > 1 && dia < 32) {
                break;
            }else{
                System.out.println("Input Inválido\n");
                System.out.println("Tente Novamente:");
            }
        }
        aux.add(dia);
        return aux;
    }

    public static void menuConsulta(reservasClube obj) throws RemoteException, InterruptedException {
        System.out.println("");
        System.out.println("   ##########################################");
        System.out.println("   ##         Consulta de Reservas         ##");
        System.out.println("   ##########################################");
        System.out.println("   #                                        #");
        System.out.println("   #    1-      Campo  /  Custo             #");
        System.out.println("   #    2-      Listar Reservas             #");
        System.out.println("   #    3-   Disponiblidade Campo X         #");
        System.out.println("   #                                        #");
        System.out.println("   #    4-          Voltar                  #");
        System.out.println("   #                                        #");
        System.out.println("   ##########################################");
        System.out.println("");

        scanner = new Scanner(System.in);

        switch (inputInt(0, 5, scanner)) {
            case 1:
                reservas = obj.campoCusto();
                System.out.println("");
                System.out.println("Preços dos Campos: ");
                for (int i = 0; i < reservas.size(); i += 2) {
                    System.out.println(reservas.get(i) + ": " + reservas.get(i + 1) + " €/h");
                }
                break;
            case 2:
                System.out.println("");
                System.out.println("Para que campo deseja ver as Reservas ? (1- Ténis | 2- Futsal | 3- Padel)");
                int campo = inputInt(0, 4, scanner);
                System.out.println("");
                System.out.println("Reservas Futuras ou Passadas ?   (1- Futuras | 2- Passadas)");
                int passadas = inputInt(0, 3, scanner);
                if (passadas == 2) {
                    reservas = obj.getReservas(true, campo);
                } else {
                    reservas = obj.getReservas(false, campo);
                }
                impReservas(reservas);
                break;
            case 3:
                System.out.println("");
                System.out.println("Para que dia / hora quer saber a disponiblidade ?");
                
                aux = inputData();
                data = aux.get(0) + "-" + aux.get(1) + "-" +aux.get(2);
                
                System.out.println("Hora de Inicio: ");
                
                int horaInicio = 999999;
                while (true) {
                    horaInicio = inputInt(-1, 25, scanner);
                    if (aux.get(0) == cYear && aux.get(1) == cMonth && aux.get(2) == cDay && horaInicio >= cHour && horaInicio < 24 || aux.get(2) != cDay && horaInicio > -1 && horaInicio < 24) {
                        break;
                    }
                    else{
                        System.out.println("Input Inválido\n");
                        System.out.println("Tente Novamente:");
                    }
                }

                data = data + " " + horaInicio + ":00";

                System.out.println("Para que campo deseja saber a disponibilidade ? (1- Ténis | 2- Futsal | 3- Padel | 4- Todos)");
                int campoD = inputInt(0, 5, scanner);

                reservas = obj.disponibilidade(data, campoD);
                System.out.println("");
                if (reservas.size() == 0) {
                    System.out.println("Não existem marcações para a hora pedida !");
                } else if (reservas.size() != 0 && campoD == 4) {
                    System.out.println("Existem marcações para os seguintes campos na hora pretendida: \n");
                    for (int i = 0; i < reservas.size(); i++) {
                        System.out.println("- " + reservas.get(i));
                    }
                    System.out.println("\nOs restantes estão livres !");
                } else {
                    System.out.println("O de " + reservas.get(0) + " está ocupado na hora pretendida !");
                }

                break;
            case 4:
                menuInicio(obj);
                break;
            default:
                System.out.println("Opção inválida, tente de novo");
                menuConsulta(obj);
        }
        sleep(1000);
        System.out.println("");
        menuInicio(obj);
    }

    public static void impReservas(Vector<String> reservas) {
        if (reservas.size() == 0) {
            System.out.println("");
            System.out.println("Não existem as reservas pretendidas!!");
        } else {
            for (int i = 0; i < reservas.size(); i += 8) {
                String[] inicio = reservas.get(i + 4).split(" ");
                String[] fim = reservas.get(i + 5).split(" ");
                System.out.println("");
                System.out.println("Reserva: " + reservas.get(i + 0));
                System.out.println("    Nome: " + reservas.get(i + 1));
                System.out.println("    Telefone: " + reservas.get(i + 2));
                System.out.println("    Campo: " + reservas.get(i + 3));
                System.out.println("    Dia: " + inicio[0]);
                System.out.println("        Das: " + inicio[1].substring(0, inicio[1].length() - 3));
                System.out.println("        Às:  " + fim[1].substring(0, fim[1].length() - 3));
                System.out.println("    No Jogadores: " + reservas.get(i + 6));
                if(reservas.get(i+7).length() > 5){
                    System.out.println("    Custo Estimado: " + reservas.get(i + 7).substring(0, 5) + " €");
                }else{
                    System.out.println("    Custo Estimado: " + reservas.get(i + 7)+ " €");
                }
                System.out.println("");
            }
        }
    }

    public static void fazerReserva(reservasClube obj) throws RemoteException {

        scanner = new Scanner(System.in);
        System.out.println("Dados da Reserva");
        System.out.println("");
        System.out.println("Nome da Reserva: ");
        String nome = scanner.nextLine();
        System.out.println("No Telefone: ");

        int telefone = inputInt(0, 999999999, scanner);
        System.out.println("Campo: ");
        System.out.println("(1- Ténis | 2- Futsal | 3- Padel)");
        int choice = inputInt(0, 4, scanner);

        System.out.println("  Data  ");
        
        aux = inputData();
        data = aux.get(0) + "-" + aux.get(1) + "-" +aux.get(2);
        
        System.out.println("Hora de Inicio: ");
        int horaInicio = 999999;
        while (true) {
        horaInicio = inputInt(-1, 25, scanner);
            if (aux.get(0) == cYear && aux.get(1) == cMonth && aux.get(2) == cDay && horaInicio >= cHour && horaInicio < 24 || aux.get(2) != cDay && horaInicio > -1 && horaInicio < 24) {
                break;
            }
            else{
                System.out.println("Input Inválido\n");
                System.out.println("Tente Novamente:");
            }
        }

        System.out.println("Hora Saída: ");
        int horasFinais = 999999;
        while (true) {
        horasFinais = inputInt(-1, 25, scanner);
            if (horasFinais > horaInicio && horasFinais < horaInicio + 3) {
                break;
            }
            else{
                System.out.println("Input Inválido\n");
                System.out.println("Tente Novamente:"); 
            }
        }
        
        System.out.println("No Jogadores: ");
        int jogadores = 0;
        while(true){
            jogadores = inputInt(0, 16, scanner);
            if((choice == 1 || choice == 3) && jogadores > 0 && jogadores < 5
                    || choice == 2 && jogadores > 0 && jogadores < 16){
                break;
            }
            else{
                System.out.println("Input Inválido\n");
                System.out.println("Tente Novamente:");
            }
        }

        if (obj.disponibilidade(data + " " + String.valueOf(horaInicio) + ":00", choice).size() == 0 && obj.disponibilidade(data + " " + String.valueOf(horasFinais) + ":00", choice).size() == 0) {
            obj.fazerReserva(nome, String.valueOf(telefone), choice, data + " " + String.valueOf(horaInicio) + ":00", data + " " + String.valueOf(horasFinais) + ":00", jogadores);
            System.out.println("Reserva realizada !!");
        } else {
            System.out.println("Reserva não realizada, campo ocupado");
        }

    }

    public static void main(String[] args) {
        String regHost = "localhost";
        String regPort = "9000";

        if (args.length != 2) {
            System.out.println("Usage: ./cliente.sh registryHost registryPort");
            System.exit(1);
        }
        regHost = args[0];
        regPort = args[1];

        try {
            reservasClube obj = (reservasClube) java.rmi.Naming.lookup("rmi://" + regHost + ":"
                    + regPort + "/reservasClube");

            menuInicio(obj);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
