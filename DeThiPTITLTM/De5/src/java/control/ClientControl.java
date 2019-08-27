/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import model.GiaiPTB2;

/**
 *
 * @author HrBbCi
 */
public class ClientControl {

    private Socket mySocket;
    private String serverHost = "localhost";
    private int port = 7777;

    public ClientControl() {
    }

    public Socket openConnection() {
        try {
            mySocket = new Socket(serverHost, port);
            if (mySocket == null) {
                System.out.println("Fail");
            } else {
                System.out.println("Kết nối Thành công");
            }
        } catch (IOException ex) {
        }
        return mySocket;
    }

    public boolean sendData(GiaiPTB2 g) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(mySocket.getOutputStream());
            oos.writeObject(g);
        } catch (IOException ex) {
            return false;
        }
        return true;
    }

    public GiaiPTB2 receiveData() {
        GiaiPTB2 result = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(mySocket.getInputStream());
            Object o = ois.readObject();
            if (o instanceof GiaiPTB2) {
                result = (GiaiPTB2) o;
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    public boolean closeConnection() {
        try {
            mySocket.close();
        } catch (IOException ex) {
            return false;
        }
        return true;
    }
}
