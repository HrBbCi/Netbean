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
import model.GiaiPTB2;

/**
 *
 * @author HrBbCi
 */
public class ClientControl {

    private int serverPort = 5555;
    private int clientPort = 6666;
    private String serverHost = "localhost";
    private DatagramSocket myClient;

    public ClientControl() {
    }

    public void openConnection() {
        try {
            myClient = new DatagramSocket(clientPort);
        } catch (Exception ex) {
        }
    }

    public void closeConnection() {
        try {
            myClient.close();
        } catch (Exception ex) {
        }
    }

    public void sendData(GiaiPTB2 g) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(g);
            oos.flush();

            InetAddress IPAddress
                    = InetAddress.getByName(serverHost);
            byte[] sendData = baos.toByteArray();
            DatagramPacket sendPacket = new DatagramPacket(sendData,
                    sendData.length, IPAddress, serverPort);
            myClient.send(sendPacket);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public GiaiPTB2 receiveData() {
        GiaiPTB2 result = null;
        try {
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            myClient.receive(receivePacket);
            ByteArrayInputStream bais = new ByteArrayInputStream(receiveData);
            ObjectInputStream ois = new ObjectInputStream(bais);
            Object o = ois.readObject();
            if (o instanceof GiaiPTB2) {
                result = (GiaiPTB2) o;
            }
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
