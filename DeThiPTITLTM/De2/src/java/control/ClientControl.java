package control;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import Model.ChuanHoaChuoi;

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
            ex.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            myClient.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void sendData(ChuanHoaChuoi chc) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(chc);
            oos.flush();

            InetAddress IPAddress
                    = InetAddress.getByName(serverHost);
            byte[] sendData = baos.toByteArray();
            DatagramPacket sendPacket = new DatagramPacket(sendData,
                    sendData.length, IPAddress, serverPort);
            myClient.send(sendPacket);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String receiveData() {
        String result = "";
        try {
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            myClient.receive(receivePacket);
            ByteArrayInputStream bais = new ByteArrayInputStream(receiveData);
            ObjectInputStream ois = new ObjectInputStream(bais);
            result = (String) ois.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
