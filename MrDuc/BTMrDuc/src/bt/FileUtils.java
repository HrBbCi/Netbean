package bt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {

  public static void writeString(File f, String content) {
    FileWriter fw = null;
    try {
      fw = new FileWriter(f,true);
      fw.write(content);
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
      while ((temp = br.readLine()) != null) {
        sb.append(temp).append("\n");
      }
    } catch (FileNotFoundException ex) {
    } catch (IOException ex) {
    }
    return sb.toString();
  }
}
