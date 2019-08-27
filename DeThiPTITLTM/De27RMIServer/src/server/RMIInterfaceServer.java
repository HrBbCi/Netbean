/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author HrBbCi
 */
public interface RMIInterfaceServer extends Remote{
    public String phanTich(model.Number n) throws RemoteException;
}
