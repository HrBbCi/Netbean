package control;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import server.RMIInterfaceServer;

public class ServerControl extends UnicastRemoteObject implements RMIInterfaceServer {

    private int port = 3232;
    private Registry regisstry;
    private String rmiService = "rmiServer";

    public ServerControl() throws RemoteException {
        try {
            regisstry = LocateRegistry.createRegistry(port);
            regisstry.rebind(rmiService, this);
        } catch (RemoteException ex) {
        }

    }

    @Override
    public String phanTich(model.Number n) throws RemoteException {
        int so = n.getNumber();
        int i = 2;
        String result = "";
        while (i <= so) {
            if (so % i == 0) {
                result += i ;
                so /= i;
                if (so != 1) {
                    result += "*";
                }
            } else {
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        try {
            ServerControl sc = new ServerControl();
        } catch (RemoteException ex) {
        }
    }
}
