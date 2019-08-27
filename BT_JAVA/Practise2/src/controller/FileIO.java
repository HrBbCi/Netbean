
package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class FileIO {
    public void readFile(List list, String path){
        try {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
                Object ob;
                while((ob = (Object) ois.readObject()) != null){
                    list.add(ob);
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
//            Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void writeFile(List list, String path){
        try {
            File file = new File(path);
            if (!file.exists()) file.createNewFile();
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
                for (Object object : list) {
                    oos.writeObject(object);
                }
            }
        } catch (FileNotFoundException ex) {
//            Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
//            Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
