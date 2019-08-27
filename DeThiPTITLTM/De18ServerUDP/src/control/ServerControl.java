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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HrBbCi
 */
public class ServerControl {

    private DatagramSocket myServer;
    private int port = 5555;
    private DatagramPacket receivePacket = null;

    public ServerControl() {
        try {
            myServer = new DatagramSocket(port);
        } catch (SocketException ex) {
        }
        while (true) {
            listening();
        }
    }

    private void sendData(Object o) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(baos);
            oos.writeObject(o);
            oos.flush();

            InetAddress ia = receivePacket.getAddress();
            int clientPort = receivePacket.getPort();
            byte[] sendData = baos.toByteArray();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ia, clientPort);
            myServer.send(sendPacket);
        } catch (IOException ex) {
        }

    }

    private Object receiveData() {
        Object o = null;
        try {
            byte[] receiveData = new byte[1024];
            receivePacket = new DatagramPacket(receiveData, receiveData.length);
            myServer.receive(receivePacket);

            ByteArrayInputStream bais = new ByteArrayInputStream(receiveData);
            ObjectInputStream ois = new ObjectInputStream(bais);
            o = ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
        }
        return o;
    }

    private void listening() {
        Object o = receiveData();
        if(o instanceof Float){
            Float f = (Float) o;
            if(ktSNT(f)){
                sendData("ok");
            }
            else{
                sendData("notok");
            }
        }
        
    }

    private boolean ktSNT(float so) {
        if (so < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(so); i++) {
            if (so % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ServerControl sc = new ServerControl();
    }
}
