/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import java.util.ArrayList;

    

public interface Clube extends java.rmi.Remote {

    public ArrayList<String> GetCampos() throws java.rmi.RemoteException;
    
    public ArrayList<String> ReservaCampos(String Nomecampo) throws java.rmi.RemoteException;
    
    public boolean VerificarCampo(String Nomecampo, String data) throws java.rmi.RemoteException;
    
    public double FazerReserva(String Nome,int Telemovel,String NomeCampo,String di,String df, int NUtilizadores)throws java.rmi.RemoteException;
}
