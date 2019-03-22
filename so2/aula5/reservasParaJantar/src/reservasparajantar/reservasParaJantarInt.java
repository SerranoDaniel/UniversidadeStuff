
package reservasparajantar;

import java.util.Vector;

public interface reservasParaJantarInt extends java.rmi.Remote {
    
    public void addName(String name) throws java.rmi.RemoteException;
    
    public Vector<String> getNamesList() throws java.rmi.RemoteException;
 
    public int getNumberOfReserves() throws java.rmi.RemoteException;
    
}
    
