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
import model.CoSo;

public class ServerControl {
    private ServerSocket myServer;
    private int port = 7777;

    public ServerControl() {
        try {
            myServer = new ServerSocket(port);
        } catch (IOException ex) {
            System.out.println("Fail");
        }
        
        while (true) {            
            listening();
        }
        
    }
    
    public void listening(){
        try {
            Socket client = myServer.accept();
            ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
            Object o = ois.readObject();
            if(o instanceof CoSo){
                CoSo cs = (CoSo) o;
                String cd = chuyenDoiCoSo(cs);
                oos.writeObject(cd);
            }
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
       
    }
    private String chuyenDoiCoSo(CoSo cs ){
        int so = cs.getSo();
        int coso = cs.getCoSo();
        if(coso == 10){
            return (String.valueOf(so));
        }
        else if(coso == 16){
            return Integer.toHexString(so);
        }
        else if(coso == 8){
            return Integer.toOctalString(so);
        }
        return Integer.toBinaryString(so);
       
    }
    public static void main(String[] args) {
        ServerControl sc = new ServerControl();
    }
  
    
}
