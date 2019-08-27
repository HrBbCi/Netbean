/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author LENPOVO
 */
public class UserDAO {
    Connection conn = null;
    public UserDAO(String dbUsername, String dbPassword) {
     String dbUrl = "jdbc:mysql://localhost:3306/hoanganh";
     String dbClass = "com.mysql.jdbc.Driver";
     try {
     Class.forName(dbClass);
     conn = DriverManager.getConnection (dbUrl, dbUsername, dbPassword);
     }catch(ClassNotFoundException e) {
     e.printStackTrace();
     }catch(SQLException e) {
     e.printStackTrace();
     }
   }
    
    public boolean checkLogin(Model.User user){
String query = "Select * FROM tbluser WHERE username = ? AND password = ?";
     try {
     PreparedStatement ps = conn.prepareStatement(query);
     ps.setString(1, user.getUserName());
     ps.setString(2, user.getPassword());
    
ResultSet rs = ps.executeQuery();
     if (rs.next()) {
     return true;
     } 
     }catch(SQLException e) {
     e.printStackTrace();
     }
return false;
}
}
