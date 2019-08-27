/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import Model.User;
/**
 *
 * @author LENPOVO
 */
public class ServerControl {
    private Connection con;
    private ServerSocket myServer;
    private int serverPort = 7777;
    public ServerControl() {
        getDBConnection("hoanganh", "root", "");
       
        openServer(serverPort);
        while (true)
        {
            listenning();
        }
        
        
           
    }
    private void getDBConnection(String dbName, String username,String password)
    {
        String dbUrl = "jdbc:mysql://localhost:3306/" + dbName;
        String dbClass = "com.mysql.jdbc.Driver";
        try {
         Class.forName(dbClass);
         con = DriverManager.getConnection (dbUrl,username, password);
         if (con==null)  System.out.println("Ket noi khong thanh cong");
         else  System.out.println("Ket noi thanh cong");
             
             
         
         
         
        }
        catch(Exception e) {
         e.printStackTrace();
        } 
}
    private void openServer(int portNumber){
        try {
        myServer = new ServerSocket(portNumber);
        if (myServer==null) System.out.println("Khong dc");
        else System.out.println("Mo cong thanh ");
        }catch(IOException e) {
        e.printStackTrace();
        }
}
    private void listenning(){
        System.out.println("GoiHam Listening");
        try {
            
        Socket clientSocket = myServer.accept();
        
        
        ObjectInputStream ois = new 
        ObjectInputStream(clientSocket.getInputStream());
        ObjectOutputStream oos = new 
        ObjectOutputStream(clientSocket.getOutputStream());
        Object o = ois.readObject();
        if(o instanceof User){
        User user = (User)o;
        if(checkUser(user)){
        oos.writeObject("ok");
        }
        else
        oos.writeObject("false");
        }
        }catch (Exception e) {
        e.printStackTrace();
        }
}
    
    private boolean checkUser(User user) throws Exception {
            String query = "Select * FROM tbluser WHERE userName ='" + user.getUserName() 
             + "' AND password ='" + user.getPassword() + "'";
            try {
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query);
             if (rs.next()) {
              return true;
             }
            }catch(Exception e) {
            throw e;
            } 
            return false;
  }
    
    
        
}

