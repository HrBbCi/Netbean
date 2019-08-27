/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;
import java.rmi.Remote;
import java.rmi.RemoteException;
import Model.User;
/**
 *
 * @author LENPOVO
 */
public interface RMILoginInterface extends Remote{
    public String checkLogin(User user) throws RemoteException;
}
