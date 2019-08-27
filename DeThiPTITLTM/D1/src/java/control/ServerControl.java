/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.ChuanHoaChuoi;

/**
 *
 * @author LENPOVO
 */
public class ServerControl {

    private Connection con;
    private ServerSocket myServer;
    private int serverPort = 7777;

    public ServerControl() {
        openServer(serverPort);
        while (true) {
            listenning();
        }

    }

    private void openServer(int portNumber) {
        try {
            myServer = new ServerSocket(portNumber);
            if (myServer == null) {
                System.out.println("Khong dc");
            } else {
                System.out.println("Mo cong thanh ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listenning() {
        System.out.println("GoiHam Listening");
        try {

            Socket clientSocket = myServer.accept();

            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
            Object o = ois.readObject();
            if (o instanceof ChuanHoaChuoi) {
                ChuanHoaChuoi chc = (ChuanHoaChuoi) o;
                String chuoi = chuanHoaChuoi(chc);
                oos.writeObject(chuoi);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String chuanHoaChuoi(ChuanHoaChuoi c) throws Exception {
        String chuoi = c.getChuoi();
        StringBuilder abc = getRes(chuoi.toLowerCase().toString());
        return abc.toString();
    }
    public StringBuilder getRes(String s ){
        Pattern pattern = Pattern.compile("\\s+");
        Matcher matcher = pattern.matcher(s);
        StringBuilder sb = new StringBuilder(matcher.replaceAll(" "));
        if(sb.charAt(0) == ' ') sb.deleteCharAt(0);
        if( sb.charAt(sb.length()-1) == ' ') sb.deleteCharAt(sb.length()-1);
        
        for( int i = 0; i< sb.length(); i++ ){
            if( i < sb.length()-1 ){
                if( (sb.charAt(i) == ',' || sb.charAt(i) == '.' || sb.charAt(i) == '?' 
                        || sb.charAt(i) == ';' || sb.charAt(i) == ':' || sb.charAt(i) == '!')
                        && sb.charAt(i+1) != ' '){
                    sb.insert(i+1, " ");
                }
            }
        }
        
        for( int i = 0; i< sb.length(); i++ ){
            if( i < sb.length()-1 ){
                if( (sb.charAt(i+1) == ',' || sb.charAt(i+1) == '.' || sb.charAt(i+1) == '?' 
                        || sb.charAt(1+i) == ';' || sb.charAt(i+1) == ':' || sb.charAt(1+i) == '!')
                        && sb.charAt(i) == ' '){
                    sb.deleteCharAt(i);
                }
            }
        }
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        
        for( int i = 0; i< sb.length(); i++ ){
            if( i < sb.length()-2 ){
                if( sb.charAt(i) == '.' || sb.charAt(i) == '?' || sb.charAt(i) == '!'){
                    sb.setCharAt(i+2, Character.toUpperCase(sb.charAt(2+i)));
                }
            }
        }
        
        return sb;
        
    }

}
