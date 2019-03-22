
package reservasparajantar;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

public class ReservasParaJantar extends UnicastRemoteObject implements reservasParaJantarInt, java.io.Serializable {
    
    public ReservasParaJantar() throws java.rmi.RemoteException {
        super();       
    }
    
    @Override
    public void addName(String name) throws RemoteException {
        
    }

    @Override
    public Vector<String> getNamesList() throws RemoteException {
        
    }

    @Override
    public int getNumberOfReserves() throws RemoteException {
        
    }
    
}
