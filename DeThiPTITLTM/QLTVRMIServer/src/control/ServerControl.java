
package control;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Sach;
import server.RMIInterface;


public class ServerControl extends UnicastRemoteObject implements RMIInterface{
    private Registry registry;
    private Connection con ;
    private int port = 3232;
    private String rmiService="rmiServer";

    public ServerControl() throws RemoteException{
        getConnection();
        try {
            registry = LocateRegistry.createRegistry(port);
            registry.rebind(rmiService, this);
        } catch (RemoteException ex) {
        }
        
    }
    
    private Connection getConnection(){
        String dbClass = "com.mysql.jdbc.Driver";
        String dbUrl ="jdbc:mysql://localhost/qlthuvien";
        try {
            Class.forName(dbClass);
            con= DriverManager.getConnection(dbUrl, "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Fail");
        }
        return con;
    }

    @Override
    public boolean update(Sach s) throws RemoteException {
        String sql = "UPDATE sach set ten='"+s.getTen()+"', tacGia ='"+s.getTacGia()+"'"
                + ", namXB='"+s.getNamXB()+"', nhaXB ='"+s.getNhaXB()+"'";
        sql+=" where id='"+s.getId()+"'";
        Statement st = null;
        try {
            st = con.createStatement();
            return st.executeUpdate(sql)>0;
        } catch (SQLException ex) {
        }
        return false;
    }

    @Override
    public Sach getSachbyName(String name) throws RemoteException {
        String sql = "select * from sach where ten='"+name+"'";
        Statement st = null;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs= st.executeQuery(sql);
            Sach s = null;
            while(rs.next()){
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
        try {
            ServerControl sc = new ServerControl();
        } catch (RemoteException ex) {
        }
    }
    
    
}
