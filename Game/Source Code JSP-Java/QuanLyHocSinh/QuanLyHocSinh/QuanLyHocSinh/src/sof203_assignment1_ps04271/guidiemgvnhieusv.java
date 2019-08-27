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

/**
 *
 * @author Admin
 */
public class guidiemgvnhieusv implements Runnable{
    String tk="";
    String mk="";
    String[] guitoi= new String[1000];
    String tieude="";
    String[] noidung= new String[1000];
    int sl;
    guidiemgvnhieusv(String tk, String mk, String[] guitoi,String tieude, String[] noidung, int sl)
    {
        this.tk = tk;
        this.mk=mk;
        this.tieude=tieude;
        this.sl = sl;
        for(int i=0;i<this.sl;i++)
        {
            this.guitoi[i]=guitoi[i];
            this.noidung[i]=noidung[i];
        }
    }
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
        for(int i=0;i<this.sl;i++){
        Message msg = new MimeMessage(ss);
        msg.setFrom(new InternetAddress(tk));
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(guitoi[i]) );
        msg.setSubject(tieude);
        msg.setText(noidung[i]);
        
        Transport.send(msg);
        System.out.print("Đã gửi ");
        }
        
    }
    catch(Exception e){System.out.print("Lỗi: "+e);}
    
    }
}
