/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clubedesportivo;

import java.sql.*;
/**
 *
 * @author ruirodrigues
 */
public class dbConn {
        
        java.sql.Connection con = null;
        java.sql.Statement stmt = null;
        
        String PG_HOST = null;
        String PG_DB = null;
        String USER = null;
        String PWD = null;
            
        
        public dbConn(String host, String dbName, String user, String pwd) throws java.rmi.RemoteException {
            super();
            PG_HOST = host;
            PG_DB = dbName;
            USER = user;
            PWD = pwd;
        }
        
        public void connectDB() throws java.rmi.RemoteException {
            try {
                Class.forName ("org.postgresql.Driver");
                // url = "jdbc:postgresql://host:port/database",
                con = DriverManager.getConnection("jdbc:postgresql://"+PG_HOST+":5432/"+PG_DB,
                                                  USER,
                                                  PWD);
                stmt = con.createStatement(); 
            }
            catch (Exception e) {
                e.printStackTrace();
                System.err.println("Problems setting the connection");
            }
        }
        
        public void disconnectDB() throws java.rmi.RemoteException {
            try {
                stmt.close();
                con.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
}
