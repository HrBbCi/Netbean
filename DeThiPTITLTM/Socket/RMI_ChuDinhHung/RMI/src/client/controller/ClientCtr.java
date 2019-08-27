/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controller;

import server.controller.*;
import server.controller.HangNhapInterFace;
import java.rmi.registry.Registry;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import model.HangHoa;
import model.NCC;

/**
 *
 * @author Hung
 */
public class ClientCtr {

    private String serverHost = "localhost";
    private int serverPort = 3232;
    private HangNhapInterFace rmiServer;
    private Registry registry;
    private String rmiService = "rmiServer";

    public ClientCtr() {
        try {
            // lay the dang ki
            registry = LocateRegistry.getRegistry(serverHost, serverPort);
            // tim kiem RMI server
            rmiServer = (HangNhapInterFace) (registry.lookup(rmiService));
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }

    public HangHoa[] remoteSearchHangHoaByName( String s) {
        HangHoa[] result = null;
        try {
            result = rmiServer.getHangHoaByName(s);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return result;
    }
    public NCC[] remoteSearchNCCByName( String s) {
        NCC[] result = null;
        try {
            result = rmiServer.getNCCByName(s);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return result;
    }
    public  String remoteInsertNCC(NCC ncc) {
        String res = null;
        try {
            if(rmiServer.insertNCC(ncc)) res =" Add Successful!";
            else res ="ADD WRONG!";
//            res = rmiServer.insertNCC(ncc);
            return res;
        } catch (Exception ex) {
             ex.printStackTrace();
            return null;
        }
    }
}
