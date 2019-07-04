/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clubedesportivo;

import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author ruirodrigues
 */
public class reservasImpl extends UnicastRemoteObject implements reservasClube, java.io.Serializable {
    
    Vector <String> reservas;
    ResultSet rs = null;
    int idReserva = 0;
    dbConn db;
    private Date d;
    
    public reservasImpl(String host, String dbName, String user, String pwd) throws java.rmi.RemoteException {
        super();
        reservas = new Vector();
        db = new dbConn(host, dbName, user, pwd);
        
         
    }
    
    public Vector campoCusto() throws java.rmi.RemoteException {
        reservas = new Vector();
        d = new Date();
        try { 
           db.connectDB();
           rs = db.stmt.executeQuery("SELECT jogo, custo FROM campos;");
           while (rs.next()) {
               reservas.add(rs.getString("jogo"));
               reservas.add(rs.getString("custo"));
           }
           rs.close();
           db.disconnectDB();
           System.out.println("\n" + new Timestamp(d.getTime()) + ": CAMPO/CUSTO REALIZADO COM SUCESSO");
        }
        catch (Exception e) {
            System.out.println("\n" + new Timestamp(d.getTime()) + ": PROBLEMA A PEDIR CAMPO/CUSTO");
       }
        
        return reservas;
    }
    
    public float calcCustoEst(int idCampo, String datai, String dataf) throws java.rmi.RemoteException{
        float custoEst = 0;
        int custoCampo = 0;
        
        try {
            rs = db.stmt.executeQuery("SELECT custo FROM campos WHERE id_campo = "+idCampo+";");
            while (rs.next()) {
                custoCampo = rs.getInt("custo");
            }
            rs.close();
            String horasI[] = datai.split(" ");
            String horasF[] = dataf.split(" ");
            
            int custoHora = (Integer.parseInt(horasF[1].substring(0, 2)) - Integer.parseInt(horasI[1].substring(0, 2))) * custoCampo;
            float custoMinuto = ((Integer.parseInt(horasF[1].substring(3, 5)) - Integer.parseInt(horasI[1].substring(3, 5))) * custoCampo) / 60;
            custoEst = custoHora + custoMinuto;
            
        }
        catch (Exception e) {
            System.out.println("\n" + new Timestamp(d.getTime()) + ": PROBLEMA A CALCULAR O CUSTO ESTIMADO");
        }
        return custoEst;
    }
    
    public void fazerReserva(String nome, String telefone, int idCampo, String datai, String dataf, int jogadores) throws java.rmi.RemoteException {
        d = new Date();
        try { 
           db.connectDB();
           rs = db.stmt.executeQuery("SELECT COUNT(*) FROM reservas;");
           while (rs.next()) {
               idReserva = rs.getInt("count");
           }
           rs.close();
           
           
           float custoEst = calcCustoEst(idCampo, datai, dataf);
           
           
           db.stmt.executeUpdate("INSERT INTO reservas VALUES("+ (idReserva+1) +",'"+nome+"', '"+telefone+"', "+idCampo+", '"+datai+"', '"+dataf+"', "+jogadores+", "+custoEst+");");
           
           db.disconnectDB();
           System.out.println("\n" + new Timestamp(d.getTime()) + ": RESERVA REALIZADA COM SUCESSO");
        }
        catch (Exception e) {
            System.out.println("\n" + new Timestamp(d.getTime()) + ": PROBLEMA A REALIZAR A RESERVA");
       }
    }
    
    public Vector getReservas(boolean passadas, int idCampo) throws java.rmi.RemoteException {
        reservas = new Vector();
        d = new Date();
        String simbPassadas;
        if(passadas == true){
            simbPassadas = "<";
        }else{
            simbPassadas = ">";
        }
        try { 
            db.connectDB();
            rs = db.stmt.executeQuery("SELECT id_reserva, nome, telefone, (SELECT jogo FROM campos WHERE campos.id_campo = reservas.id_campo) AS campo, datai, dataF, jogadores, custoEst FROM reservas "
                    + "WHERE id_campo = "+idCampo+" AND datai "+simbPassadas+" NOW() ORDER BY datai;");
            while (rs.next()) {
                reservas.add(rs.getString("id_reserva"));
                reservas.add(rs.getString("nome"));
                reservas.add(rs.getString("telefone"));
                reservas.add(rs.getString("campo"));
                reservas.add(rs.getString("datai"));
                reservas.add(rs.getString("dataf"));
                reservas.add(rs.getString("jogadores"));
                reservas.add(rs.getString("custoEst"));
            }
            rs.close();

            db.disconnectDB();
            System.out.println("\n" + new Timestamp(d.getTime()) + ": CONSULTA DE RESERVAS REALIZADA COM SUCESSO");
         }
         catch (Exception e) {
            System.out.println("\n" + new Timestamp(d.getTime()) + ": PROBLEMA A CONSULTAR AS RESERVAS");
        }
        return reservas;
    }
    
    public Vector disponibilidade(String data, int idCampo) throws java.rmi.RemoteException{
        d = new Date();
        reservas = new Vector();
        String query;
        if(idCampo == 4){
            query = "SELECT (SELECT jogo FROM campos WHERE campos.id_campo = reservas.id_campo) AS campo FROM reservas WHERE datai <= '"+data+"' AND dataf > '"+data+"';";
        }else{
            query = "SELECT (SELECT jogo FROM campos WHERE campos.id_campo = reservas.id_campo) AS campo FROM reservas WHERE id_campo = "+idCampo+" and datai <= '"+data+"' AND dataf > '"+data+"';";
        }
        try { 
            db.connectDB();
            rs = db.stmt.executeQuery(query);
            while (rs.next()) {
                reservas.add(rs.getString("campo"));
            }
            rs.close();
            db.disconnectDB();
            System.out.println("\n" + new Timestamp(d.getTime()) + ": CONSULTA DE DISPONIBILIDADE REALIZADA COM SUCESSO");
        }
        catch(Exception e){
            System.out.println("\n" + new Timestamp(d.getTime()) + ": PROBLEMA A VERIFICAR DISPONIBILIDADE");
        }
        return reservas;
    }
}
