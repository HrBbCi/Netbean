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
import model.GiaiPTB2;

/**
 *
 * @author HrBbCi
 */
public class ServerControl {

    private ServerSocket myServer;
    private int serverPort = 7777;

    public ServerControl() {
        openServer(serverPort);
        while (true) {
            listening();
        }
    }

    private void openServer(int port) {
        try {
            myServer = new ServerSocket(port);
            if (myServer == null) {
                System.out.println("Khởi tạo ko thành công");
            } else {
                System.out.println("Thành công");
            }
        } catch (IOException ex) {
        }
    }

    private void listening() {
        System.out.println("Gọi hàm");
        try {
            Socket clientSocket = myServer.accept();
            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
            Object o = ois.readObject();
            if(o instanceof GiaiPTB2){
                GiaiPTB2 g = (GiaiPTB2) o;
                giaiPTB2(g);
                oos.writeObject(g);
            }
        } catch (IOException | ClassNotFoundException ex) {
        }
        
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
