/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HrBbCi
 */
public class View {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connection conn = dataBaseAcess.getConnection();
        try {
            if(conn != null && !conn.isClosed()){
                System.out.println("Kết nối DB ");
            }
            else{
                System.out.println("FAlSE");
            }
        } catch (SQLException ex) {
        }
    }
    
}
