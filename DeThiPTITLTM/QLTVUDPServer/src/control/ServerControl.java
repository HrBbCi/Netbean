/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Sach;

/**
 *
 * @author HrBbCi 12h52
 */
public class ServerControl {

    private DatagramSocket myServer;
    private Connection con = null;
    private int port = 5555;
    private DatagramPacket receivePacket = null;

    public ServerControl() {
        getConnection();
        try {
            myServer = new DatagramSocket(port);
        } catch (SocketException ex) {
        }
        while (true) {
            listening();
        }
    }

    public Connection getConnection() {
        String dbClass = "com.mysql.jdbc.Driver";
        String dbUrl = "jdbc:mysql://localhost:3306/qlthuvien";
        try {
            Class.forName(dbClass);
            con = DriverManager.getConnection(dbUrl, "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Fail");
        }

        return con;
    }

    public boolean sendData(Object o) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(o);
            oos.flush();

            InetAddress ip = receivePacket.getAddress();
            int clientport = receivePacket.getPort();
            byte[] sendData = baos.toByteArray();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ip, clientport);
            myServer.send(sendPacket);
            return true;
        } catch (IOException ex) {
        }

        return false;
    }

    public Object receiveData() {
        Object o = null;
        try {
            byte[] receiveData = new byte[1024];
            receivePacket = new DatagramPacket(receiveData, receiveData.length);
            myServer.receive(receivePacket);

            ByteArrayInputStream bais = new ByteArrayInputStream(receiveData);
            ObjectInputStream ois = new ObjectInputStream(bais);
            o = ois.readObject();
            return o;
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
        return o;
    }

    public void listening() {
        Object o = receiveData();
        if(o instanceof String){
            String str = (String) o;
            Sach s = getSachByName(str);
            List<Sach> list = new ArrayList<>();
            list.add(s);
            sendData(list);
        }
        if(o instanceof Sach){
            Sach s = (Sach) o;
            updateBook(s);
            sendData(s);
        }
    }
    
    public boolean updateBook(Sach s) {
        String SQL = "UPDATE SACH SET ten = '" + s.getTen() + "', tacGia ='" + s.getTacGia() + "'"
                + ", namXB ='" + s.getNamXB() + "',nhaXB='" + s.getNhaXB() + "'";
        SQL += " WHERE id ='" + s.getId() + "'";
        Statement st = null;
        try {
            st = con.createStatement();
            return st.executeUpdate(SQL) > 0;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public Sach getSachByName(String name) {
        String sql = "Select * from sach where ten='" + name + "'";
        Statement st = null;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            Sach s = null;
            while (rs.next()) {
                s = new Sach();
                s.setId(rs.getInt("id"));
                s.setTen(rs.getString("ten"));
                s.setTacGia(rs.getString("tacGia"));
                s.setNamXB(rs.getInt("namXB"));
                s.setNhaXB(rs.getString("nhaXB"));
            }
            return s;
        } catch (SQLException ex) {
        }
        return null;
    }
    public static void main(String[] args) {
        ServerControl sc = new ServerControl();
    }
    

}
