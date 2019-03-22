package so2;

import java.io.*;
import java.net.*;
import java.util.Vector;

public class VeiculosServer {

    private int serverPort;

    private Vector<Registo> repositorio;

    public VeiculosServer(int p) {
        serverPort = p;
        repositorio = new Vector<>(); // INICIALIZE o Vector
    }

    public static void main(String[] args) {
        System.err.println("SERVER...");
        if (args.length < 1) {
            System.err.println("Missing parameter: port number");
            System.exit(1);
        }
        int p = 0;
        try {
            p = Integer.parseInt(args[0]);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(2);
        }

        VeiculosServer serv = new VeiculosServer(p);
        serv.servico();   // activa o servico
    }

    public void servico() {

        try {

            // inicializa o socket para receber ligacoes
            ServerSocket sock = new ServerSocket(serverPort);

            while (true) {
                // espera uma ligacao
                Socket data = sock.accept();
                // ... accept()

                try {
                    Object objPedido = null;
                    // le os dados do pedido, como um OBJECTO "objPedido"   
                    ObjectInputStream ois = new ObjectInputStream(data.getInputStream());

                    objPedido = ois.readObject();

                    // apreciar o objecto com o pedido recebido:
                    if (objPedido == null) {
                        System.err.println("PEDIDO NULL: esqueceu-se de alguma coisa");
                    }

                    if (objPedido instanceof PedidoDeConsulta) {
                        PedidoDeConsulta pc = null;

                        pc = (PedidoDeConsulta) objPedido;

                        // procurar o registo associado a matricula pretendida
                        Registo registo = null;
                        
                        // pesquisar no servidor (Vector, mais tarde num ficheiro)
                        for (int i = 0; i < repositorio.size(); i++) {
                            if (repositorio.get(i).getMatricula().equals(pc.getMatricula())) {

                                ObjectOutputStream oss = new ObjectOutputStream(data.getOutputStream());

                                oss.writeObject(repositorio.get(i));
                                
                                
                                break;

                            }

                        }

                        // enviar objecto Cliente via socket
                        // se encontra devolve o registo, se não, devolve um novo objecto ou string a representar que nao encontrou
                    } else if (objPedido instanceof PedidoDeRegisto) {
                        PedidoDeRegisto pr = (PedidoDeRegisto) objPedido; // ...
                        
                        Registo registo = pr.getRegisto();
                        
                        String resposta ="ok";
                        
                        boolean repetido=false;

                        // ver se ja existia registo desta matricula
                        for (int i = 0; i < repositorio.size(); i++) {
                            if (repositorio.get(i).getMatricula().equals(pr.getRegisto().getMatricula())) {

                                System.err.println("existe outro igual");
                                repetido=true;
                                break;

                            }

                            // adicionar ao rep local (se nao e' uma repeticao)
                            
                        }
                        
                        if(repetido){
                            resposta="pedido de registo para matricula igual";
                        }
                        
                        else{
                            repositorio.add(registo);
                        }
                        
                        // responder ao cliente
                        
                        ObjectOutputStream oss = new ObjectOutputStream(data.getOutputStream());

                        oss.writeObject(resposta);
                        
                    }
                    
                        else {
                        System.out.println("PROBLEMA");
                    }

                    }catch (Exception exNoAtendimento) {
                    exNoAtendimento.printStackTrace();
                }finally {  // fechar o socket de dados
                    // fechar o socket de dados dedicado a este cliente:
                    try {
                        sock.close(); // Fechar Sock
                    } catch (Exception e002) {
                    }
                }

                }  // ... ciclo de atendimento

            }
            catch (Exception problemaBindAccept) {
            problemaBindAccept.printStackTrace();
        }

        }

    }
