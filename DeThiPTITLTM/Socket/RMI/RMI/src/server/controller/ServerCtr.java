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
import model.HangNhap;
import model.HoaDon;
import model.NCC;
import model.RankHangHoa;
import model.RankNCC;

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
        getDBConnection("quanlynhaphang", "sa", "123456");
// dang ki RMI server
        try {
            registry = LocateRegistry.createRegistry(serverPort);
            registry.rebind(rmiService, this);
        } catch (RemoteException e) {
            throw e;
        }
    }
    private void getDBConnection(String dbName, String username, String password) {
        String dbUrl = "jdbc:sqlserver://localhost:1433; "+"databaseName="+dbName+"; username="+username+"; password="+password;
        String dbClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
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
        String sql = "SELECT * FROM tblNCC WHERE name like ?;";
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
                                               ,rs.getString(5)
                                               ,rs.getString(6)
                );
            }
            return result;
        } catch (Exception e) {
            
            return null;
        }
    }

    @Override
    public boolean insertNCC(NCC ncc) throws RemoteException {
        String sql =  "INSERT INTO tblNCC (name,address, phone, email,description) "
                    + " VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ncc.getName());
            ps.setString(2, ncc.getAddress());
            ps.setString(3, ncc.getPhone());
            ps.setString(4, ncc.getEmail());
            ps.setString(5, ncc.getDescription());
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
        String sql = "SELECT * FROM tblHangHoa WHERE name like ?;";
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
                                               ,rs.getFloat(4)
                                               ,rs.getString(5)
                );
            }
            return result;
        } catch (Exception e) {
            
            return null;
        }
    }

    @Override
    public boolean insertHoaDon(HoaDon hoaDon) throws RemoteException {

        String sql = "SELECT TOP 1 id FROM tblHoaDon ORDER BY id DESC;";
        int idHoaDon =  -1;
        try {
            PreparedStatement ps = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = ps.executeQuery();
            if(rs.last()) {
                rs.beforeFirst();
            }
            while( rs.next()) {
                idHoaDon = rs.getInt(1);
            }
            // finish id
            if( idHoaDon == -1) {
                idHoaDon = 1;
            }
            else  idHoaDon++;
            
            sql =  "INSERT INTO tblHoaDon (id,idNCC, amout, dateCreater,prepay) "
                    + " VALUES (?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, idHoaDon);
            ps.setInt(2, hoaDon.getNcc().getId());
            ps.setFloat(3, hoaDon.getAmout());
            ps.setString(4, hoaDon.getDateCreater());
            ps.setString(5, hoaDon.getPrepay());
            ps.executeUpdate();
            
            sql = "INSERT INTO tblHangNhap (maHangHoa,maHoaDon,soLuong,DonGia,chatLuong) "
                    + " VALUES (?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            for (HangNhap hn : hoaDon.getListHangNhaps()) {
                ps.setInt(1, hn.getHangHoa().getId());
                ps.setInt(2, idHoaDon);
                ps.setInt(3, hn.getSoLuong());
                ps.setFloat(4, hn.getDonGia());
                ps.setString(5, hn.getChatLuong());
                ps.executeUpdate();
            }
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
        
        return true;
    }

    @Override
    public RankHangHoa[] getSoLuongHangHoa() throws RemoteException {
//        System.out.println(",");
        RankHangHoa[] result = null;
        String sql ="SELECT SUM(hn.soLuong) AS soLuong , hh.id , hh.name  , hh.type , hh.price ,hh.description\n" +
                    "FROM tblHangHoa hh\n" +
                    "INNER JOIN tblHangNhap hn ON hh.id = hn.maHangHoa\n" +
                    "GROUP BY hh.id , hh.name  , hh.type , hh.price ,hh.description\n" +
                    "ORDER BY soLuong DESC;";
        try {
            PreparedStatement ps = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = ps.executeQuery();
            if(rs.last()) {
                result = new RankHangHoa[rs.getRow()];
                rs.beforeFirst();
            }
            int cnt =0;
            while( rs.next()) {
                result[cnt++] = new RankHangHoa(rs.getInt(1)
                                               ,rs.getInt(2)
                                               ,rs.getString(3)
                                               ,rs.getString(4)
                                               ,rs.getFloat(5)
                                               ,rs.getString(6)
                );
            }
            System.out.println(result.length);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public RankNCC[] getSoLuongNCC() throws RemoteException {
        RankNCC[] result = null;
        String sql ="SELECT SUM(hn.soLuong) AS soLuong, ncc.id , ncc.name, ncc.address, ncc.phone , ncc.email , ncc.description\n" +
                    "FROM tblNCC ncc\n" +
                    "INNER JOIN tblHoaDon hd ON hd.idNCC = ncc.id\n" +
                    "INNER JOIN tblHangNhap hn ON hn.maHoaDon = hd.id\n" +
                    "GROUP BY ncc.id , ncc.name, ncc.address, ncc.phone , ncc.email , ncc.description\n" +
                    "ORDER BY soLuong DESC;";
        try {
            PreparedStatement ps = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = ps.executeQuery();
            if(rs.last()) {
                result = new RankNCC[rs.getRow()];
                rs.beforeFirst();
            }
            int cnt =0;
            while( rs.next()) {
                result[cnt++] = new RankNCC(    rs.getInt(1)
                                               ,rs.getInt(2)
                                               ,rs.getString(3)
                                               ,rs.getString(4)
                                               ,rs.getString(5)
                                               ,rs.getString(6)
                                               ,rs.getString(7)
                );
            }
            System.out.println(result.length);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
