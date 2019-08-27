/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demojavaswing;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HrBbCi
 */
public class DeMoJavaSwing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            String ngaySinh="1997-10-01";
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(df.parse(ngaySinh));
        } catch (ParseException ex) {
            System.out.println(ex);
        }
    }
    
}
