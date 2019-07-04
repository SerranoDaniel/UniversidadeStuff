/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clubedesportivo;

/**
 *
 * @author ruirodrigues
 */
import java.util.Vector;
/**
 *
 * @author ruirodrigues
 */
public interface reservasClube extends java.rmi.Remote{
    
    public void fazerReserva (String nome, String telefone, int idCampo, String datai, String dataf, int jogadores) throws java.rmi.RemoteException;
    
    public Vector campoCusto() throws java.rmi.RemoteException;
  
    public Vector getReservas(boolean passadas, int idCampo) throws java.rmi.RemoteException;
    
    public Vector disponibilidade(String data, int idCampo) throws java.rmi.RemoteException;
    
    public float calcCustoEst(int idCampo, String datai, String dataf) throws java.rmi.RemoteException;
    
}
