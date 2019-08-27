/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.KhachHang;

/**
 *
 * @author Hung
 */
public class ServerCtr {

    private Connection con;
    private DatagramSocket myServer;
    private int serverPort = 5555;
    private DatagramPacket receivePacket = null;

    public ServerCtr() {
        getDBConnection("QuanLyTruyenTranh", "sa", "1234@1234a");
        openServer(serverPort);
        while (true) {
            listenning();
        }
    }

    private void getDBConnection(String dbName, String username, String password) {
        String dbUrl = "jdbc:sqlserver://localhost:1433; " + "databaseName=" + dbName + "; username=" + username + "; password=" + password;
        String dbClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        try {
            Class.forName(dbClass);
            con = DriverManager.getConnection(dbUrl, username, password);
            System.out.println("Connect SQLSV Successful");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void openServer(int portNumber) {
        try {
            myServer = new DatagramSocket(portNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listenning() {
        try {
            Object o = receiveData();
            if (o instanceof KhachHang) {
                KhachHang kh = (KhachHang) o;
                if (addKhachHang(kh)) {
                    sendData("Thêm Thành Công!");
                } else {
                    sendData("Không thành công!");
                }

            }
            if (o instanceof String) {
                String name = (String) o;
                KhachHang[] listKhachHangs = getKhachHangByName(name);
                sendData(listKhachHangs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendData(Object o) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(o);
            oos.flush();
            InetAddress IPAddress = receivePacket.getAddress();
            int clientPort = receivePacket.getPort();
            byte[] sendData = baos.toByteArray();
            DatagramPacket sendPacket = new DatagramPacket(sendData,
                    sendData.length, IPAddress, clientPort);
            myServer.send(sendPacket);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Object receiveData() {
        Object o = null;
        try {
            byte[] receiveData = new byte[1024];
            receivePacket = new DatagramPacket(receiveData, receiveData.length);
            myServer.receive(receivePacket);
            ByteArrayInputStream bais = new ByteArrayInputStream(receiveData);
            ObjectInputStream ois = new ObjectInputStream(bais);
            o = ois.readObject();
            return o;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean addKhachHang(KhachHang khachHang) {
        String sql = "INSERT INTO tblKhachHang (tenKhachHang,soDienThoai, diaChi,email,moTa) "
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
        String sql = "SELECT * FROM tblKhachHang WHERE tenKhachHang like ?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();
            if (rs.last()) {
                result = new KhachHang[rs.getRow()];
                rs.beforeFirst();
            }
            int cnt = 0;
            while (rs.next()) {
                result[cnt++] = new KhachHang(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)
                );
            }
            return result;
        } catch (Exception e) {

            return null;
        }
    }

    public static void main(String[] args) {
        new ServerCtr();
    }
}
