/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Control.RMILoginServerControl;
import java.rmi.RemoteException;

/**
 *
 * @author LENPOVO
 */
public class RMILoginServerView 
{
    public RMILoginServerView() throws RemoteException
    {
        new RMILoginServerControl();  
        showMessage("RMI server is running...");
    }
    public void showMessage(String msg)
    {
        System.out.println(msg);
    }
}
