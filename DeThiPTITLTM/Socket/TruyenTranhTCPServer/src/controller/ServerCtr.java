/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.KhachHang;
import model.TruyenTranh;

/**
 *
 * @author Hung
 */
public class ServerCtr {
    private Connection con;
    private ServerSocket myServer;
    private int serverPort = 8888;

    public ServerCtr() {
        getDBConnection("quanlytruyentranh","root", "");
        openServer(serverPort);
        while (true) {
            listenning();
        }
    }

    private void getDBConnection(String dbName, String username, String password) {
        String dbUrl = "jdbc:mysql://localhost:3306/"+dbName;
        String dbClass = "com.mysql.jdbc.Driver";
        try {
            Class.forName(dbClass);
            con = DriverManager.getConnection(dbUrl, username, password);
            System.out.println("Connect SQLSV Successful");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connect SQLSV fail");
        }
    }
    
    private void openServer(int portNumber) {
        try {
            myServer = new ServerSocket(portNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private boolean addKhachHang(KhachHang khachHang) {
        String sql =  "INSERT INTO tblkhachhang (tenKhachHang,soDienThoai, diaChi,email,moTa) "
                    + " VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, khachHang.getTenKhachHang());
            ps.setString(2, khachHang.getSoDienThoai());
            ps.setString(3, khachHang.getDiaChi());
            ps.setString(4, khachHang.getEmail());
            ps.setString(5, khachHang.getMoTa());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }
    private KhachHang[] getKhachHangByName(String name) {
        KhachHang[] result = null;
        String sql = "SELECT * FROM tblkhachhang WHERE tenKhachHang like ?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ps.setString(1,"%" + name + "%");
            ResultSet rs = ps.executeQuery();
            if(rs.last()) {
                result = new KhachHang[rs.getRow()];
                rs.beforeFirst();
            }
            int cnt =0;
            while( rs.next()) {
                result[cnt++] = new KhachHang( rs.getInt(1)
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
    private TruyenTranh[] getTruyenTranhByName(String name) {
        System.out.println(name);
        TruyenTranh[] result = null;
        String sql = "SELECT * FROM tbltruyentranh WHERE tenSach like ?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ps.setString(1,"%" + name + "%");
            ResultSet rs = ps.executeQuery();
            if(rs.last()) {
                result = new TruyenTranh[rs.getRow()];
                rs.beforeFirst();
            }
            int cnt =0;
            while( rs.next()) {
                result[cnt++] = new TruyenTranh( rs.getInt(1)
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
    private void listenning() {
        try {
            Socket clientSocket = myServer.accept();
            System.out.println("Co ket noi!");
            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
            Object o = ois.readObject();
            if( o instanceof KhachHang) {
                KhachHang kh = (KhachHang) o;
                if( addKhachHang(kh)) {
                    oos.writeObject("Thêm thành Công");
                }
                else   {
                    oos.writeObject("Không thành công");
                }
                      
            }
            else if(o instanceof String) {
                String name = (String) o;
                KhachHang[] listKhachHangs = getKhachHangByName(name);
                oos.writeObject(listKhachHangs);
            }
            else if(o instanceof TruyenTranh) {
                TruyenTranh truyenTranh = (TruyenTranh) o;
                TruyenTranh[] listTruyenTranhs = getTruyenTranhByName(truyenTranh.getTenSach());
                oos.writeObject(listTruyenTranhs);
            }
//            if (o instanceof Member) {
//                Member user = (Member) o;
//                if (checkUser(user)) {
//                    oos.writeObject("ok");
//                } else {
//                    oos.writeObject("false");
//                }
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public static void main(String[] args) {
        ServerCtr serverCtr = new ServerCtr();
    }
}
