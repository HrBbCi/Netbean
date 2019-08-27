/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import server.RMIInterfaceServer;

/**
 *
 * @author HrBbCi
 */
public class ClientControl {
    private String serverHost= "localhost";
    private int port = 3232;
    private RMIInterfaceServer rmiServer;
    private Registry registry;
    private String rmiService = "rmiServer";

    public ClientControl() {
        try {
            registry = LocateRegistry.getRegistry(serverHost,port);
             rmiServer = (RMIInterfaceServer) registry.lookup(rmiService);
        } catch (RemoteException ex) {
        } catch (NotBoundException ex) {
        }
    }
    
    public String remoteKetQua(model.Number n){
        String result = null;
        try {
            result = rmiServer.phanTich(n);
        } catch (RemoteException ex) {
        }
        return result;
    }
    
}
