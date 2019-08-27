
package file2.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class raVaoFileByBytesStream {

    public static void main(String[] args) throws Exception {
        final String DIR = "Saved.txt";
        File f = new File(DIR);

        if (!f.exists()) {
            System.out.println("File ko tồn tại");
            try {
                f.createNewFile();
            } catch (IOException ex) {

            }
        } 

        FileInputStream fis = new FileInputStream(f);
        InputStreamReader ist = new InputStreamReader(fis, "UTF8");
        int c = 0;
        while ((c = ist.read()) != -1) {
            System.out.print((char) c);
        }
        System.out.println("");

        //True để ghi tiếp
        FileOutputStream fos = new FileOutputStream("FiOUT.txt",true);
        final String ABC = "anhKien Đẹp Trai";
        byte[] data = ABC.getBytes();
        fos.write(data);
        fos.flush();
        fos.close();
    }
}
