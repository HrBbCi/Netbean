/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file.com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HrBbCi
 */
public class CharacterStream {

    public static void main(String[] args) {
        File f = new File("D:\\love.txt");
        
        writeString(f, "Ảnh đepjjj");
        String str = readString(f);
        System.out.println(str);
    }

    public static String readString(File f) {
        StringBuilder sb = new StringBuilder();

        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(f);
               
            br = new BufferedReader(fr);
            
            String tem = "";
            while((tem = br.readLine())!= null){
                //Lưu dòng vừa đọc đc vào sb
                sb.append(tem).append("\n");
            }
            
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
        return sb.toString();
        
    }

    public static void writeString(File f, String path) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(f);
            
            fw.write(path);
            
            fw.flush();
        } catch (IOException ex) {
        }
        finally{
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException ex) {
                }
            }
        }
    }
}
