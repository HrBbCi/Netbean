package control;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import server.RMIInterface;

/**
 *
 * @author HrBbCi
 */
public class ClientControl {

    private String serverHost = "localhost";
    private int port = 3232;
    private RMIInterface rmiServer;
    private Registry registry;
    private String rmiService = "rmiServer";

    public ClientControl() {
        try {
            registry = LocateRegistry.getRegistry(serverHost, port);
            rmiServer = (RMIInterface) (registry.lookup(rmiService));
        } catch (RemoteException ex) {
        } catch (NotBoundException ex) {
        }
    }
    
    public String remoteCHC(String s){
        String result = null;
        try {
            result = rmiServer.chuanHoaChuoi(s).toString();
        } catch (RemoteException ex) {
        }
        return result;
    }

}
