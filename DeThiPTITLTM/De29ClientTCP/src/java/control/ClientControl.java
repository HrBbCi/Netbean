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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CoSo;

public class ClientControl {

    private Socket client;
    private int port = 7777;
    private String serverHost = "localhost";

    public ClientControl() {

    }

    public Socket openCon() {
        try {
            client = new Socket(serverHost, port);
        } catch (IOException ex) {
            System.out.println("Fail");
        }
        return client;
    }

    public boolean sendData(Object o) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
            oos.writeObject(o);
        } catch (IOException ex) {
        }
        return true;
    }

    public Object receiveData() {
        String str = "";
        try {
            ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
            Object o = ois.readObject();
            if (o instanceof String) {
                str = (String) o;
            }
        } catch (IOException | ClassNotFoundException ex) {
        }
        return str;
    }

    public boolean closeCon() {
        try {
            client.close();
        } catch (IOException ex) {
        }
        return true;
    }

}
