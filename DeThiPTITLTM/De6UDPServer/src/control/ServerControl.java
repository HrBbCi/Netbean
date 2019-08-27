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
public class ServerControl {
    private DatagramSocket myServer;
    private int serverPort = 5555;
    private DatagramPacket receivePacket = null;
    
    public ServerControl() {
        openServer(serverPort);
        while (true) {
            listenning();
        }
    }
    
     private void openServer(int portNumber) {
        try {
            myServer = new DatagramSocket(portNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     
     private void sendData(GiaiPTB2 g) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(g);
            oos.flush();

            InetAddress IPAddress = receivePacket.getAddress();
            int clientPort = receivePacket.getPort();
            byte[] sendData = baos.toByteArray();
            DatagramPacket sendPacket = new DatagramPacket(sendData,
                    sendData.length, IPAddress, clientPort);
            myServer.send(sendPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private GiaiPTB2 receiveData() {
        GiaiPTB2 g = null;
        try {
            byte[] receiveData = new byte[1024];
            receivePacket = new DatagramPacket(receiveData, receiveData.length);
            myServer.receive(receivePacket);
            ByteArrayInputStream bais = new ByteArrayInputStream(receiveData);
            ObjectInputStream ois = new ObjectInputStream(bais);
            g = (GiaiPTB2) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return g;
    }
    
    private void listenning() {
        GiaiPTB2 g = receiveData();
        giaiPTB2(g);
        sendData(g);
    }
    public void giaiPTB2(GiaiPTB2 g) {
        float a = g.getA();
        float b = g.getB();
        float c = g.getC();
        float x1 = 0;
        float x2 = 0;
        String kq = "";
        float delTa = b * b - 4 * a * c;
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    kq = "VSN";
                } else {
                    kq = "VN";
                }
            } else {
                kq = "1N";
                System.out.println("PT có 1 nghiem :" + (float) -c / b);
                x1 = (float) -c / b;
                g.setX1(x1);
            }

        } else {
            if (delTa > 0) {
                kq = "2N";
                x1 = (float) ((-b - Math.sqrt(delTa)) / (2 * a));
                x2 = (float) ((-b + Math.sqrt(delTa)) / (2 * a));
                g.setX1(x1);
                g.setX2(x2);
                System.out.println(g.getX1()+" ;;;;;;;; " +g.getX2());
            } else {
                if (delTa == 0) {
                    kq = "NK";
                    x1 = (float) -b / 2 * a;
                    x2 = (float) -b / 2 * a;
                    g.setX1(x1);
                    g.setX2(x2);
                } else {
                    kq = "VN";
                }
            }
        }
        g.setKq(kq);
    }
}
