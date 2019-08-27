/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import model.Sach;

/**
 *
 * @author HrBbCi 1h49 2h24 24+11 =35
 */
public interface RMIInterface extends Remote{
    public boolean update(Sach s) throws RemoteException;
    public Sach getSachbyName(String name) throws RemoteException;
}
