/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author HrBbCi
 */
public class DB {
    private static final String dbDriver ="com.mysql.jdbc.Driver";
    private static final String dbPath ="jdbc:mysql://localhost/d41qlhanghoa";
    
    public static Connection getConnection(){
        Connection con = null;
        try {
            Class.forName(dbDriver);
            con =  DriverManager.getConnection(dbPath, "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Fail");
        }
        return con;
    }
}
