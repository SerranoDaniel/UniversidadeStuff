package trabalho1_so2;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {

    /* 
    Funcao menu que está em loop até ser recebido o input 0  
     */
    public static void menu(ControloBDIF obj) throws RemoteException {
        while (true) {
            System.out.print("\n------------MENU------------\nSelecione a opção que deseja:\n"
                    + "1- Criar questionário\n2- Listar questionários\n"
                    + "3- Apagar questionário\n4- Consultar perguntas de um questionário\n"
                    + "5- Responder a um questionário\n6- Consultar número de respostas de um questionário\n"
                    + "7- Obter média de valores de resposta num questionário\n"
                    + "0- Sair\n>> ");
            Scanner scan = new Scanner(System.in);
            String menuResp;

            menuResp = scan.nextLine();

            switch (menuResp) {
                case "1":
                    criarQuestionario(obj);
                    break;
                case "2":
                    consultarQuestionario(obj);
                    break;
                case "3":
                    apagarQuestionario(obj);
                    break;
                case "4":
                    consultarPerguntas(obj);
                    break;
                case "5":
                    responderQuestionario(obj);
                    break;
                case "6":
                    consultarNumRespostas(obj);
                    break;
                case "7":
                    obterMedia(obj);
                    break;
                case "0":
                    System.exit(0);
                default:
                    System.out.println("\n---Opção inválida---\n");
                    break;
            }
        }
    }

    /* 
    Funcao que cria um novo questionário "q" e o envia para a class de controlo da BD para ser tratado,
        class esta que ira returnar uma string com a confirmacao e o ID do questionario criado
     */
    public static void criarQuestionario(ControloBDIF obj) throws RemoteException {
        Questionario q = new Questionario();
        String confirm = obj.criarQuestionario(q);

        System.out.println(confirm);
    }

    /* 
    Funcao que serve para listar os qustionários pedindo ao servido atraves da funcao "consultarQUestionario" uma string 
        com todos os questionario e caso essa string seja do tipo "\n  " significa que não há questionários"
     */
    public static void consultarQuestionario(ControloBDIF obj) throws java.rmi.RemoteException {
        String consulta = obj.consultarQuestionario();

        if (consulta.equals("\n ")) {
            System.out.println("\n---Não há questionários---\n");
        } else {
            System.out.println(consulta);
        }
    }

    /* 
    Funcao que pede um ID ao user e envia esse ID à classe de contro da BD para apagar o questionario cujo ID corresponde
        O a class de controlo da BD irá devolver uma String para ser enviada ao user
     */
    public static void apagarQuestionario(ControloBDIF obj) throws java.rmi.RemoteException {
        Scanner scan = new Scanner(System.in);

        String perg = "\nQual o ID do questionário que pretende apagar?\n>> ";
        int idQuest = pedeIdQuest(perg);

        String apagarConfirm = obj.apagarQuestionario(idQuest);
        System.out.println(apagarConfirm);
    }

    /* 
    Funcao que pede um ID de um questionario sobre o qual se quer consultar as perguntas
    e envia esse Id à classe de contro da BD atraves da funcao "obterPerguntasDeQuestionario" 
    e esta funcao irá devolver uma arraylist vazia caso o questinoario nao exista, null
    caso tenha ocorrido algum erro ao aceder à BD, ou uma arraylist com a respetiva informação que será 
    tratada de forma a ser perceptivel pelo user
     */
    public static void consultarPerguntas(ControloBDIF obj) throws java.rmi.RemoteException {
        Scanner scan = new Scanner(System.in);

        String perg = "\nQual o ID do questionário do qual pretende consultar as perguntas?\n>> ";
        int idQuest = pedeIdQuest(perg);

        ArrayList<Perguntas> listaPerguntas = obj.obterPerguntasDeQuestionario(idQuest);

        if (listaPerguntas == null) {
            System.out.print("\n---Erro ao consultar perguntas---\n");
        } else if (listaPerguntas.isEmpty()) {
            System.out.print("\n---Questionário inexistente---\n");
        } else {
            listaPerguntas.forEach((pergunta)
                    -> {
                System.out.print("\n<< ID: " + pergunta.getId()
                        + " | Pergunta: " + pergunta.getPergunta()
                        + " | Resposta Global: " + pergunta.getRespostaGlobal());
            });
            System.out.println();
        }
    }

    /*
    Funcao que pede um ID de um questionario ao user sobre o qual quer responder às questoes
    e irá enviar o ID para a class de controlo da BD atraves da funcao "obterPerguntasDeQuestionario"
    funcao esta que devolve um arraylist de perguntas que serão posteriormente mostradas ao user
    e pedido o input da resposta do user a cada pergunta. A cada objeto do tipo Pergunta
    irá ser atribuida uma resposta a partir do método da class Pergunta "responder" e,
    irão ser reenviadas essas Perguntas com as repostas atualizadas para a class de controlo da BD atraves da funcao
    "guardarRespostas" que irá devolver uma string com a respetiva resposta incluindo o codigo da resposta
    do user caso tenho sido tudo efetuado com sucesso
     */
    public static void responderQuestionario(ControloBDIF obj) throws java.rmi.RemoteException {
        Scanner scan = new Scanner(System.in);

        String perg = "\nQual o ID do questionário que pretende responder?\n>> ";
        int idQuest = pedeIdQuest(perg);

        ArrayList<Perguntas> listaPerguntas = obj.obterPerguntasDeQuestionario(idQuest);

        if (listaPerguntas.isEmpty()) {
            System.out.print("\n---Questionário inexistente---\n");
        } else if (listaPerguntas == null) {
            System.out.print("\n---Erro ao aceder ao questionário ou às perguntas---\n");
        } else {
            listaPerguntas.forEach((pergunta)
                    -> {
                int resposta;
                while (true) {
                    Scanner scanW = new Scanner(System.in);

                    System.out.print("\nPergunta: " + pergunta.getPergunta() + "\nResposta (1 a 10) >> ");

                    try {
                        resposta = scanW.nextInt();
                        if (resposta > 0 && resposta < 11) {
                            break;
                        }

                        throw new Exception("valor entre 1 e 10");
                    } catch (Exception e) {
                        System.out.print("\n---Insira um inteiro de 1 a 10!---\n");
                    }
                }
                pergunta.responder(resposta);
            });

            String confirm = obj.guardarRespostas(idQuest, listaPerguntas);
            System.out.print("\n" + confirm + "\n");
        }
    }

    /*
    Funcao que pede o Id do questionario ao user sobre o qual ser quer consultar o numero 
    de vezes que esse questionario foi respondido, id esse que irá ser enviado para a class de controlo da BD
    atraves da funcao "obterNumeroRespostas" e que irá devolver -2 caso o questiionario nao exista, -1 
    caso tenha ocorrido algum erro ao aceder à bd ou irá devolver o valor pedido de numero de respostas
     */
    public static void consultarNumRespostas(ControloBDIF obj) throws java.rmi.RemoteException {
        Scanner scan = new Scanner(System.in);

        String perg = "\nQual o ID do questionário do qual pretende consultar as repostas?\n>> ";
        int idQuest = pedeIdQuest(perg);

        int consultaResp = obj.obterNumeroRespostas(idQuest);

        if (consultaResp == -1) {
            System.out.print("\n---Erro ao consultar número de respostas---\n");
        } else if (consultaResp == -2) {
            System.out.print("\n---Questionário inexistente---\n");
        } else {
            System.out.print("\n<< Número de respostas ao questionário com ID " + idQuest
                    + ": " + consultaResp + "\n");
        }
    }

    /*
    Funcao que pede o Id do questionario ao user sobre o qual ser quer consultar a media 
    de respostas por cada pergunta, id esse que irá ser enviado para a class de controlo da BD atraves 
    da funcao "obterNumeroRespostas" que ira returnar -1 caso tenha ocorrido algum erro de acesso à BD
    0 caso esse questionario ainda nao tenha sido respondido, -2 caso o questionario nao exista,
    e caso corra tudo bem ira returnar uma arraylist com as perguntas do questionario, lista essa que ira ser 
    "mostrada ao user" de modo a que o calculo da media seja feito atravez do metodo da class Pergunta "media"
     */
    public static void obterMedia(ControloBDIF obj) throws java.rmi.RemoteException {
        Scanner scan = new Scanner(System.in);

        String perg = "\nQual o ID do questionário do qual pretende consultar a média das repostas?\n>> ";
        int idQuest = pedeIdQuest(perg);

        int numRespostas = obj.obterNumeroRespostas(idQuest);

        if (numRespostas == -1) {
            System.out.print("\n---Erro ao consultar número de respostas---\n");
        } else if (numRespostas == 0) {
            System.out.print("\n--Questionário sem respostas---\n");
        } else if (numRespostas == -2) {
            System.out.print("\n---Questionário inexistente---\n");
        } else {
            ArrayList<Perguntas> listaPerguntas = obj.obterPerguntasDeQuestionario(idQuest);

            listaPerguntas.forEach((Perguntas pergunta)
                    -> {
                System.out.print("\n>> Pergunta " + pergunta.getId()
                        + ": \"" + pergunta.getPergunta()
                        + "\" com média " + pergunta.media(numRespostas));
            });
            System.out.println();
        }
    }

    /*
    Funcao que recebe uma string que ira ser disposta ao user com uma pergunta a pedir 
    o ID de um questionario e irá returnar esse mesmo ID, e lidar com erros que possao
    ocorrer com inputs errados
     */
    public static int pedeIdQuest(String perguntaMenu) {
        while (true) {
            System.out.print(perguntaMenu);
            Scanner scan = new Scanner(System.in);

            try {
                int paraDevolver = scan.nextInt();

                if (paraDevolver <= 0) {
                    System.out.print("\n--Insira um número inteiro positivo---\n");
                } else {
                    return paraDevolver;
                }
            } catch (Exception e) {
                System.out.print("\n---Insira um inteiro!---\n");
            }
        }
    }

    /*
    Funcao main, retirada das aulas praticas de RMI
     */
    public static void main(String args[]) {
        /* 
        args[0] -> regHost
        args[1] -> regPort
         */

        if (args.length != 2) { // requer 2 argumentos
            System.out.println("Usage: java so2.rmi.Cliente registryHost registryPort");
            System.exit(1);
        }

        try {
            ControloBDIF obj = (ControloBDIF) java.rmi.Naming.lookup("rmi://" + args[0] + ":"
                    + args[1] + "/questionario");
            menu(obj);

        } catch (MalformedURLException | NotBoundException | RemoteException ex) {
            System.out.println(ex);
        }
    }
}
