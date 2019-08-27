/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Sach;
import server.RMIInterface;

/**
 *
 * @author HrBbCi
 */
public class ClientControl {

    private String host = "localhost";
    private int port = 3232;
    private Registry registry;
    private RMIInterface rmiSever;
    private String rmiService = "rmiServer";

    public ClientControl() {
        try {
            registry = LocateRegistry.getRegistry(host, port);
            rmiSever = (RMIInterface) registry.lookup(rmiService);
        } catch (RemoteException | NotBoundException ex) {
        }
    }

    public List<Sach> remoteListSach(String name) {
        Sach s;
        try {
            s = rmiSever.getSachbyName(name);
            List<Sach> list = new ArrayList<>();
            list.add(s);
            return list;
        } catch (RemoteException ex) {
        }
        return null;
    }

    public boolean remoteUpdate(Sach s) {
        try {
            return rmiSever.update(s);
        } catch (RemoteException ex) {
        }
        return false;
    }

}
