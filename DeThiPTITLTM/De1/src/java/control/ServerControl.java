/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import model.ChuanHoaChuoi;

/**
 *
 * @author LENPOVO
 */
public class ServerControl {

    private Connection con;
    private ServerSocket myServer;
    private int serverPort = 7777;

    public ServerControl() {
        openServer(serverPort);
        while (true) {
            listenning();
        }

    }

    private void openServer(int portNumber) {
        try {
            myServer = new ServerSocket(portNumber);
            if (myServer == null) {
                System.out.println("Khong dc");
            } else {
                System.out.println("Mo cong thanh ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listenning() {
        System.out.println("GoiHam Listening");
        try {

            Socket clientSocket = myServer.accept();

            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
            Object o = ois.readObject();
            if (o instanceof ChuanHoaChuoi) {
                ChuanHoaChuoi chc = (ChuanHoaChuoi) o;
                if (chuanHoaChuoi(chc)) {
                    oos.writeObject("ok");
                } else {
                    oos.writeObject("false");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean chuanHoaChuoi(ChuanHoaChuoi c) throws Exception {
        System.out.println("Chuẩn hóa chuỗi ở đây");
        return true;
    }

}
