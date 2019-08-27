/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sof203_assignment1_ps04271;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class guimailgv1sv implements Runnable{
    String tk="";
    String mk="";
    String guitoi="";
    String tieude="";
    String noidung="";
    @Override
    public void run()
    {
        try{
            
        Properties ppt = new Properties();
        ppt.put("mail.smtp.auth", "true");
	ppt.put("mail.smtp.starttls.enable", "true");
	ppt.put("mail.smtp.host", "smtp.gmail.com");
	ppt.put("mail.smtp.port", "587");
        
        Session ss = Session.getInstance(ppt,
                new javax.mail.Authenticator()
                {
                    protected PasswordAuthentication getPasswordAuthentication(){
                        return new PasswordAuthentication(tk, mk);
                    }
                }
        
        );
        
        Message msg = new MimeMessage(ss);
        msg.setFrom(new InternetAddress(tk));
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(guitoi) );
        msg.setSubject(tieude);
        msg.setText(noidung);
        
        Transport.send(msg);
    }
    catch(Exception e){}
    
}
}
