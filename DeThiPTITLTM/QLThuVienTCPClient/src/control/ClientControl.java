package control;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientControl {

    private Socket client;
    private String serverHost = "localhost";
    private int port = 7777;

    public ClientControl() {

    }

    public Socket openConnection() {
        try {
            client = new Socket(serverHost, port);
            if (client != null) {
                System.out.println("Kết nối thành công");
            }

        } catch (IOException ex) {
        }
        return client;
    }
    
    public boolean sendData(Object o){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(client.getOutputStream());
            oos.writeObject(o);
        } catch (IOException ex) {
            return false;
        }
        return true;
    }
    public Object receiveData(){
        Object o = null;
        
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(client.getInputStream());
            o = ois.readObject();
            return o;
        } catch (IOException | ClassNotFoundException ex) {
        }
        return o;
    }
    public boolean closeConnection(){
        try {
            client.close();
        } catch (IOException ex) {
            return false;
        }
        return true;
    }
}
