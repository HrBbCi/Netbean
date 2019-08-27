package filetrongjava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author HrBbCi
 */
public class CharacterStream {

  public static void main(String[] args) {
    final String CONTENT = "Hà Nội, ngày 14/07/2017";
    File f = new File("D:\\stanford.txt");
    // Ghi ra file
    writeString(f, CONTENT);

    // Đọc nội dung file
    String str = readString(f);
    // In ra console
    System.out.println(str);
  }

  /**
   * Ghi nội dung ra 1 file
   */
  public static void writeString(File f, String content) {
    FileWriter fw = null;

    try {
      fw = new FileWriter(f);
      // Ghi dữ liệu ra file
      fw.write(content);
      // Đẩy dữ liệu xuống file
      fw.flush();
    } catch (IOException ex) {
    } finally {
      try {
        fw.close();
      } catch (IOException ex) {
      }
    }
  }

  public static String readString(File f) {
    StringBuilder sb = new StringBuilder();

    FileReader fr = null;
    BufferedReader br = null;

    try {
      fr = new FileReader(f);
      br = new BufferedReader(fr);

      String temp = "";
      // Đọc cho đến khi chưa hết nội dung file
      while ((temp = br.readLine()) != null) {
        // Lưu dòng vừa đọc được vào StringBuilder
        sb.append(temp).append("\n");
      }
      // throw - throws

    } catch (FileNotFoundException ex) {
    } catch (IOException ex) {
    }

    return sb.toString();
  }
}
