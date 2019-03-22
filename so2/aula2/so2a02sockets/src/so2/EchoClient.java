package so2;

import static com.sun.xml.internal.messaging.saaj.packaging.mime.util.ASCIIUtility.getBytes;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class EchoClient {

    private String address = null;
    private int sPort = 0;

    public EchoClient(String add, int p) {
        address = add;
        sPort = p;

    }

    public static void main(String[] args) {
        // exigir os argumentos necessarios
        if (args.length < 3) {
            System.err.println("Argumentos insuficientes:  java EchoClient ADDRESS PORT MSG");
            System.exit(1);
        }

        try {
            String addr = args[0];
            int p = Integer.parseInt(args[1]);
            String msg = args[2];

            EchoClient cl = new EchoClient(addr, p);

            // ler o texto a enviar ao servidor
            String s = msg;

            cl.go(s);   // faz o pretendido
        } catch (Exception e) {
            System.out.println("Problema no formato dos argumentos");
            e.printStackTrace();
        }
    }

    public void go(String msg) {

        // exercicio 1: mostrar a mensagem que vai ser enviada
        System.out.println(msg);

        // ... exercicio 3
        try {
            Socket s = new Socket(address, sPort);
            // ja esta connected

            // Envia mensagem para o servidor
            OutputStream socketOut = s.getOutputStream();
            socketOut.write(getBytes(msg));

            // Recebe mensagem do servidor
            InputStream socketIn = s.getInputStream();
            byte[] b = new byte[1023];
            int lidos = socketIn.read(b);
            String reposta = new String(b, 0, lidos);

            //Imprime resposta
            System.out.println("RECEBI: " + reposta);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("PROBLEMAS");

        }

    }

}
