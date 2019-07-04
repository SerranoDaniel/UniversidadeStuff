/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


 public class ClubeImplem extends UnicastRemoteObject implements Clube, java.io.Serializable {
    String host= "alunos.di.uevora.pt";
    

        public ClubeImplem() throws java.rmi.RemoteException {
        super();
        }
        ClubeConnector obj = new ClubeConnector();
        
        public ArrayList<String> GetCampos() throws java.rmi.RemoteException {
            
        ArrayList <String> f = new ArrayList<String>();
        
        try {
            obj.connect();
        } catch (Exception ex) {
            Logger.getLogger(ClubeImplem.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                try {

               ResultSet rs = obj.getStatement().executeQuery("SELECT * from Campos"  );

                while (rs.next()) {
                    int custo= rs.getInt("Custo");
                    String Campo = rs.getString("Nomecampo");
                    
                    String Custo= Integer.toString(custo);
                    
                    String Total= "Campo:  "+Campo+"  Custo:  "+Custo;
                    
                    
                    
                    f.add(Total);
                    
                   
                }
                //rs.close(); já está contido no disconnect
            }
            catch (Exception e) {
                e.printStackTrace();
                System.err.println("Problems retrieving data from db...");
            }
            
           obj.disconnect();
           return f;        
        } 
    
        public boolean VerificarCampo(String Nomecampo, String data) throws java.rmi.RemoteException {
            boolean x= false;
            try {
            obj.connect();
        } catch (Exception ex) {
            Logger.getLogger(ClubeImplem.class.getName()).log(Level.SEVERE, null, ex);
        }
            try{
               ResultSet rs = obj.getStatement().executeQuery("SELECT IdReserva from reservas WHERE Nomecampo='" +Nomecampo+ "' AND di<='"+data+ "'AND df>'"+data+"'"  );
                //1 - LIVRE
                //0 - NAO LIVRE
                
                
                if (!rs.next()){
                    x=true;
                }
                
                System.err.println(x);
                //rs.close();
             }   
            catch (Exception e) {
                e.printStackTrace();
                System.err.println("Problems retrieving data from db...");
            }
            
            obj.disconnect();
            return x;
        }

    
        public ArrayList<String> ReservaCampos(String Nomecampo) throws java.rmi.RemoteException {
            
        ArrayList <String> f = new ArrayList<String>();
        
        try {
            obj.connect();
        } catch (Exception ex) {
            Logger.getLogger(ClubeImplem.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                try {
            

               ResultSet rs = obj.getStatement().executeQuery("SELECT di, df from reservas WHERE Nomecampo='" +Nomecampo+"'" );

                while (rs.next()) {
              
                    String di = rs.getString("di");
                    String df = rs.getString("df");
                   
                    String Total= "Data Inicio:  "+di+"|    | Data Final:  "+df;
                   
                    f.add(Total);
                    
                   
                }
                //rs.close(); 
            }
            catch (Exception e) {
                e.printStackTrace();
                System.err.println("Problems retrieving data from db...");
            }
            
           obj.disconnect();
           return f;        
        } 
    
        public double FazerReserva(String Utilizador,int Telemovel,String NomeCampo,String di,String df, int NUtilizadores)throws java.rmi.RemoteException{
        if (VerificarCampo(NomeCampo, di)==true && VerificarCampo(NomeCampo, df)==true){
        double pagamento = 0;
        int custo=0;
            try {
            obj.connect();
        } catch (Exception ex) {
            Logger.getLogger(ClubeImplem.class.getName()).log(Level.SEVERE, null, ex);
        }
         try { 
             /*    ######################  obter custo ###############     */
             ResultSet rs = obj.getStatement().executeQuery("SELECT custo from Campos where Nomecampo='"+NomeCampo+"'"  );
            
             while(rs.next()){
             custo= rs.getInt("Custo");
             }
             /*    ######################  obter pagamento ###############     */
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
            Date data = format.parse(di);
            Date data1 = format.parse(df);
            long difdata= data1.getTime()-data.getTime();
            
            double horas=(double) difdata/(1000*60*60)%24; 
            
            pagamento= horas *custo;
            
            obj.getStatement().executeUpdate("INSERT INTO Reservas(Utilizador,Telemovel,NomeCampo,DI,DF,Pagemento,NumUtilizadores) VALUES ('"+Utilizador+"','"+Telemovel+"','"+NomeCampo+"','"+di+"','"+df+"' ,'"+pagamento+"','"+NUtilizadores+"')" );
            //rs.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.err.println("Problems on insert...");
       }
         obj.disconnect();
         return pagamento;
          
        }
        else{
        return 0;
        }
    } 
 }


