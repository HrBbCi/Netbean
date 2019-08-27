package filetrongjava;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ByteStream {

  public static void main(String[] args) {
    final String DATA = "A - Hà Nội";
    File f = new File("D:\\a.txt");
    writeData(f, DATA.getBytes());
    readData(f);
  }

  public static void writeData(File fileDest, byte[] arrByte) {
    FileOutputStream fos = null;
    try {
      fos = new FileOutputStream(fileDest, true);
      fos.write(arrByte);
      fos.flush();
    } catch (FileNotFoundException ex) {
      System.out.println("Lỗi khi ghi file, byte stream");
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

  public static void readData(File f) {
    FileInputStream fis = null;
    try {
      fis = new FileInputStream(f);
      InputStreamReader isr = new InputStreamReader(fis,
              "UTF-8");
      int data = 0;
      while ((data = isr.read()) != -1) {
        System.out.print((char) data);
      }
    } catch (FileNotFoundException ex) {
    } catch (IOException ex) {
    }
  }
}
