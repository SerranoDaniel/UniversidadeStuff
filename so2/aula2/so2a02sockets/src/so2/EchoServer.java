package so2;

import static com.sun.xml.internal.messaging.saaj.packaging.mime.util.ASCIIUtility.getBytes;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    private int serverPort;

    public EchoServer(int p) {
        serverPort = p;
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

        EchoServer serv = new EchoServer(p);
        serv.servico();   // activa o servico
    }

    // activa o servidor no porto indicado em "serverPort"
    public void servico() {

        // exercicio 2: inicializar um socket para aceitar ligacoes...
        try {
                ServerSocket ss = new ServerSocket(serverPort);

            while (true) {
                Socket sc = ss.accept();

                try {
                    //ler o pedido do cliente
                    InputStream socketIn = sc.getInputStream();
                    byte[] b = new byte[1023];
                    int lidos = socketIn.read(b);
                    String pedido = new String(b, 0, lidos);

                    System.out.println("RECEBI O PEDIDO " + pedido);
                    pedido += "_#";

                    OutputStream socketOut = sc.getOutputStream();
                    socketOut.write(pedido.getBytes());

                    sc.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                } finally {
                    if (sc != null && sc.isConnected()) {
                        sc.close();
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
