/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file.com;

import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ByteStream {

    public static void main(String[] args) {
        final String DATA = "Ảnh đẹp";
        File f = new File("D:\\love.txt");
        //Ghi dữ liệu

        writeData(f, DATA.getBytes());

        readData(f);
    }

    //Ghi dữ liệu ra file
    public static void writeData(File fileDest, byte[] arrByte) {
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(fileDest,true);
            //Ghi file
            fos.write(arrByte);

            //Đẩy dữ liệu từ bộ đệm xuống file
            fos.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("Lỗi khi ghi file");
        } catch (IOException ex) {
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException ex) {
                }
            }

        }
    }

    //Đọc File
    public static void readData(File f) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(f);
            //Hỗ trợ đọc Tiếng Việt
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            int data = 0;
            //Chưa đọc đến cuối file thì in ra dữ liệu
            while ((data = isr.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
    }

    public void none(WindowEvent evt) {
        // TODO add your handling code here:
    }
    
    
}
