/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Hung
 */
public class ClientCtr {
    private Socket mySocket;
    private String serverHost = "localhost";
    private int serverPort = 8888;

    public ClientCtr() {
    }

    public void openConnection() {
        try {
            mySocket = new Socket(serverHost, serverPort);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void sendData(Object o) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(mySocket.getOutputStream());
            oos.writeObject(o);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Object receiveData() {
        try {
            ObjectInputStream ois = new ObjectInputStream(mySocket.getInputStream());
            Object o = ois.readObject();
            return o;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public boolean closeConnection() {
        try {
            mySocket.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}
