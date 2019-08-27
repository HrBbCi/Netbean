/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import model.HangHoa;
import model.NCC;

/**
 *
 * @author Hung
 */
public interface HangNhapInterFace extends Remote{
    public  NCC[] getNCCByName(String s) throws RemoteException;
    public boolean insertNCC(NCC ncc) throws RemoteException;
    public HangHoa[] getHangHoaByName(String s) throws RemoteException;
}
