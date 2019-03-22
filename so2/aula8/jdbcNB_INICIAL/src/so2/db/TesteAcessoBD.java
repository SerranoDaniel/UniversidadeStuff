package so2.db;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author jsaias
 */
public class TesteAcessoBD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        // coloque os argumentos
        
        // PostgresConnector pc = new PostgresConnector( ?? );
        // NOTA: se isto nao fosse uma domonstacao, nao PODIA ter configuracoes no codigo fonte!!!
        
        
        // estabelecer a ligacao ao SGBD
        pc.connect();
        Statement stmt = pc.getStatement();

	// *******************
        // update/insert
        try {

           // AQUI: operacao para inserir um registo com o seu nome...

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Problems on insert...");
        }

	// ******************
        // query	
        try {
            
            // AQUI: codigo para realizar a CONSULTA
            
            
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Problems retrieving data from db...");
        }

        // desligar do SGBD:
        pc.disconnect();
    }


}
