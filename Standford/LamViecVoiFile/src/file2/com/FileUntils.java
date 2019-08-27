
package file2.com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileUntils {

    public static String readFile(String path) throws Exception {
        //Chứa kết quả trả về
        StringBuilder sb = new StringBuilder();
        File f = new File(path);
        if (!f.exists()) {
            System.out.println("File ko tồn tại");
            try {
                f.createNewFile();
            } catch (IOException ex) {
            }
        }
        FileInputStream fis = new FileInputStream(f);
        InputStreamReader isr = new InputStreamReader(fis, "UTF8");
        String line;
        BufferedReader br = new BufferedReader(isr);
        while ((line = br.readLine()) != null) {
           sb.append(line);
        }
        fis.close();
        isr.close();
        br.close();
        return sb.toString();
    }
    public static  void writeFile(String path, String cmt) throws IOException{
        File f = new File(path);
        FileWriter fw = new FileWriter(f);
        fw.write(cmt);
        fw.flush();
        fw.close();
    }
}
