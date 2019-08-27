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
 * @author HrBbCi 12h52 1h15 =23+22=45 1h37
 * 10h01 10h14
 */
public class ClientControl {

    private DatagramSocket csocket;
    private String host = "localhost";
    private int serverPort = 5555;
    private int clientPort = 6666;

    public ClientControl() {
        
    }
    
    public void openCon() {
        try {
            csocket = new DatagramSocket(clientPort);
        } catch (SocketException ex) {
        }
    }
    public void closeCon() {
        csocket.close();
    }

    public boolean sendData(Object o) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(o);
            oos.flush();

            InetAddress ip = InetAddress.getByName(host);
            byte[] sendData = baos.toByteArray();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ip, serverPort);
            csocket.send(sendPacket);
            return true;
        } catch (IOException ex) {
        }

        return false;
    }

    public Object receiveData() {
        Object o = null;
        try {
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            csocket.receive(receivePacket);

            ByteArrayInputStream bais = new ByteArrayInputStream(receiveData);
            ObjectInputStream ois = new ObjectInputStream(bais);
            o = ois.readObject();
            return o;
        } catch (IOException | ClassNotFoundException ex) {
        }
        return o;
    }


}
