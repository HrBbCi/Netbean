/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sof203_assignment1_ps04271;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Admin
 */
public class guimaildt implements Runnable{
    String tk="";
    String mk="";
    String[] guitoi= new String[1000];
    String tieude="";
    String noidung= "";
    int sl=0;
    int cc=0;
    int sllink=0;
    String [] linkfile = new String [1000];
    guimaildt(String tk, String mk, String[] guitoi,String tieude, String noidung, int sl, int cc, String[] link, int sllink)
    {
        this.tk = tk;
        this.mk=mk;
        this.tieude=tieude;
        this.sl = sl;
        this.cc = cc;
        this.noidung=noidung;
        this.sllink=sllink;
        for(int i=0;i<this.sl;i++)
        {
            this.guitoi[i]=guitoi[i];
        }
        for(int i=0;i<this.sllink;i++)
        {
            this.linkfile[i]=link[i];
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
        
        Session session = Session.getInstance(ppt,
         new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(tk, mk);
            }
         });

         // Create a default MimeMessage object.
         Message message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(tk));

         message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(guitoi[0]));
        if(cc==1){
            for(int i=1;i<sl;i++)
            {
                message.addRecipient(RecipientType.BCC, new InternetAddress(guitoi[i]));
            }
        }
        else{
            for(int i=1;i<sl;i++)
            {
                message.addRecipient(RecipientType.CC, new InternetAddress(guitoi[i]));
            }
        }

         // Set Subject: header field
         message.setSubject(tieude);

         // Create the message part
          BodyPart messageBodyPart = new MimeBodyPart();

         // Now set the actual message
         messageBodyPart.setText(noidung);

         // Create a multipar message
          Multipart multipart = new MimeMultipart();

         // Set text message part
         multipart.addBodyPart(messageBodyPart);

         // Part two is attachment
         for(int i=0;i<sllink;i++)
         {
         messageBodyPart = new MimeBodyPart();
         String filename = linkfile[i];
         DataSource source = new FileDataSource(filename);
         messageBodyPart.setDataHandler(new DataHandler(source));
         messageBodyPart.setFileName(filename);
         multipart.addBodyPart(messageBodyPart);
         }
         
         // Send the complete message parts
         message.setContent(multipart);

         // Send message
         Transport.send(message);
        System.out.print("Đã gửi ");
        
        
    }
    catch(Exception e){System.out.print("Lỗi: "+e);}
    
    }
}
    

