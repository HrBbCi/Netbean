package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIInterface extends Remote{
    public StringBuilder chuanHoaChuoi(String s) throws RemoteException;
}
