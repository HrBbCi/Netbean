/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.controller;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import model.HangHoa;
import model.NCC;

/**
 *
 * @author Hung
 */
public class ServerCtr extends UnicastRemoteObject implements HangNhapInterFace {

    private int serverPort = 3232;
    private Registry registry;
    private Connection con;
    private String rmiService = "rmiServer";

    public ServerCtr() throws RemoteException {
        getDBConnection("quanlynhaphang", "root", "");
// dang ki RMI server
        try {
            registry = LocateRegistry.createRegistry(serverPort);
            registry.rebind(rmiService, this);
        } catch (RemoteException e) {
            throw e;
        }
    }
    private void getDBConnection(String dbName, String username, String password) {
        String dbUrl = "jdbc:mysql://localhost:3306/"+dbName;
        String dbClass = "com.mysql.jdbc.Driver";
        try {
            Class.forName(dbClass);
            con = DriverManager.getConnection(dbUrl, username, password);
            System.out.println("Connect SQL Server Successful!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws RemoteException {
        new ServerCtr();
    }

    @Override
    public NCC[] getNCCByName(String s) throws RemoteException {
        NCC[] result = null;
        String sql = "SELECT * FROM tblncc WHERE name like ?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ps.setString(1,"%" + s + "%");
            ResultSet rs = ps.executeQuery();
            if(rs.last()) {
                result = new NCC[rs.getRow()];
                rs.beforeFirst();
            }
            int cnt =0;
            while( rs.next()) {
                result[cnt++] = new NCC( rs.getInt(1)
                                               ,rs.getString(2)
                                               ,rs.getString(3)
                                               ,rs.getString(4)
                );
            }
            return result;
        } catch (Exception e) {
            
            return null;
        }
    }

    @Override
    public boolean insertNCC(NCC ncc) throws RemoteException {
        String sql =  "INSERT INTO tblncc (name,address, phone) "
                    + " VALUES (?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ncc.getName());
            ps.setString(2, ncc.getAddress());
            ps.setString(3, ncc.getPhone());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }

    @Override
    public HangHoa[] getHangHoaByName(String s) throws RemoteException {
        HangHoa[] result = null;
        String sql = "SELECT * FROM tblhanghoa WHERE name like ?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ps.setString(1,"%" + s + "%");
            ResultSet rs = ps.executeQuery();
            if(rs.last()) {
                result = new HangHoa[rs.getRow()];
                rs.beforeFirst();
            }
            int cnt =0;
            while( rs.next()) {
                result[cnt++] = new HangHoa( rs.getInt(1)
                                               ,rs.getString(2)
                                               ,rs.getString(3)
                );
            }
            return result;
        } catch (Exception e) {
            
            return null;
        }
    }
}
