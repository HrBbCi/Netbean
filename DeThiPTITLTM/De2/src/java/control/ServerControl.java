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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import Model.ChuanHoaChuoi;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author LENPOVO
 */
public class ServerControl {

    private Connection con;
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

    private void listenning() {
        ChuanHoaChuoi ch = receiveData();
        String result = "";
        try {
            result = chuanHoaChuoi(ch);
        } catch (Exception ex) {
        }
        sendData(result);
    }

    private void sendData(String result) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(result);
            oos.flush();

            InetAddress IPAddress = receivePacket.getAddress();
            int clientPort = receivePacket.getPort();
            byte[] sendData = baos.toByteArray();
            DatagramPacket sendPacket = new DatagramPacket(sendData,
                    sendData.length, IPAddress, clientPort);
            myServer.send(sendPacket);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ChuanHoaChuoi receiveData() {
        ChuanHoaChuoi ch = null;
        try {
            byte[] receiveData = new byte[1024];
            receivePacket = new DatagramPacket(receiveData, receiveData.length);
            myServer.receive(receivePacket);
            ByteArrayInputStream bais = new ByteArrayInputStream(receiveData);
            ObjectInputStream ois = new ObjectInputStream(bais);
            ch = (ChuanHoaChuoi) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ch;
    }

    private String chuanHoaChuoi(ChuanHoaChuoi c) throws Exception {
        String chuoi = c.getChuoi();
        StringBuilder abc = getRes(chuoi.toLowerCase());
        return abc.toString();
    }

    public StringBuilder getRes(String s) {
        Pattern pattern = Pattern.compile("\\s+");
        Matcher matcher = pattern.matcher(s);
        StringBuilder sb = new StringBuilder(matcher.replaceAll(" "));
        if (sb.charAt(0) == ' ') {
            sb.deleteCharAt(0);
        }
        if (sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }

        for (int i = 0; i < sb.length(); i++) {
            if (i < sb.length() - 1) {
                if ((sb.charAt(i) == ',' || sb.charAt(i) == '.' || sb.charAt(i) == '?'
                        || sb.charAt(i) == ';' || sb.charAt(i) == ':' || sb.charAt(i) == '!')
                        && sb.charAt(i + 1) != ' ') {
                    sb.insert(i + 1, " ");
                }
            }
        }

        for (int i = 0; i < sb.length(); i++) {
            if (i < sb.length() - 1) {
                if ((sb.charAt(i + 1) == ',' || sb.charAt(i + 1) == '.' || sb.charAt(i + 1) == '?'
                        || sb.charAt(1 + i) == ';' || sb.charAt(i + 1) == ':' || sb.charAt(1 + i) == '!')
                        && sb.charAt(i) == ' ') {
                    sb.deleteCharAt(i);
                }
            }
        }
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));

        for (int i = 0; i < sb.length(); i++) {
            if (i < sb.length() - 2) {
                if (sb.charAt(i) == '.' || sb.charAt(i) == '?' || sb.charAt(i) == '!') {
                    sb.setCharAt(i + 2, Character.toUpperCase(sb.charAt(2 + i)));
                }
            }
        }

        return sb;

    }
}
