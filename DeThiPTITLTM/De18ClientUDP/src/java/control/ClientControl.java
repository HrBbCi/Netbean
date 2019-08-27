/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author HrBbCi
 */
public class ClientControl {
    private int serverPort = 5555;
    private int clientPort = 6666;
    private String serverHost = "localhost";
    private DatagramSocket socket ;

    public ClientControl() {
    }
    
    public  void openConnection(){
        try {
            socket = new DatagramSocket(clientPort);
        } catch (SocketException ex) {
        }
    }
    
    public void closeConnection(){
        socket.close();
    }
    
    public void sendData(Object o){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(baos);
            oos.writeObject(o);
            oos.flush();

            InetAddress ia = InetAddress.getByName(serverHost);
            byte[] sendData = baos.toByteArray();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ia, serverPort);
            socket.send(sendPacket);
        } catch (IOException ex) {
        }
    }
    
    public Object receiveData() {
        Object o = null;
        try {
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);

            ByteArrayInputStream bais = new ByteArrayInputStream(receiveData);
            ObjectInputStream ois = new ObjectInputStream(bais);
            o = ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
        }
        return o;
    }
}
