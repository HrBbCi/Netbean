package control;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
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

public class ServerControl {

    private ServerSocket myServer;
    private int port = 7777;
    Connection con = null;

    public ServerControl() {
        getConnection();
        try {
            myServer = new ServerSocket(port);
            if (myServer != null) {
                System.out.println("Khởi tạo thành công");
            }
        } catch (IOException ex) {
        }
        while (true) {
            listening();
        }
    }

    private void getConnection() {
        String dbUrl = "jdbc:mysql://localhost/qlthuvien";
        String dbClass = "com.mysql.jdbc.Driver";
        try {
            Class.forName(dbClass);
            con = DriverManager.getConnection(dbUrl, "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Lỗi kết nối db");
        }
    }

    private void listening() {
        System.out.println("gọi hàm");
        try {
            Socket client = myServer.accept();
            ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
            Object o = ois.readObject();
            if (o instanceof String) {
                String str = (String) o;
                Sach s = getSachByName(str);
                List<Sach> listSach = new ArrayList<>();
                listSach.add(s);
                oos.writeObject(listSach);
            }
            else if (o instanceof Sach) {
                 Sach sach = (Sach) o;
                 if (updateBook(sach)) {
                    oos.writeObject(sach);
                } else {
                    oos.writeObject("failupdate");
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
        }

    }

    private boolean updateBook(Sach s) {
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
            Logger.getLogger(ServerControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        ServerControl sc = new ServerControl();
    }

}
