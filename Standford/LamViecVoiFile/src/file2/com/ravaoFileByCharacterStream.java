
package file2.com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;
public class ravaoFileByCharacterStream {
    public static void main(String[] args) throws IOException {
        File f = new File("Saved.txt");
         if (!f.exists()) {
            System.out.println("File ko tồn tại");
            try {
                f.createNewFile();
            } catch (IOException ex) {
            }
        } 
        FileInputStream fis = new FileInputStream(f);
        InputStreamReader isr = new InputStreamReader(fis,"UTF8");
        String line ;
        BufferedReader br = new BufferedReader(isr);
        while((line =br.readLine())!= null){
            System.out.println(line);
        }
        
        FileWriter fw = new FileWriter("FiOUT.txt");
        fw.write("Đây là ví dụ");
        fw.flush();
        fw.close();
    }
}
