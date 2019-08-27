package bai1.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class FileIO {

    public static void readFile(List list, String path) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
            Object obj = null;
            while ((obj = (Object) ois.readObject()) != null) {
                list.add(obj);
            }
            ois.close();
        } catch (IOException | ClassNotFoundException ex) {
        }
    }

    public static void writeFile(List list, String path) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
            for (Object object : list) {
                oos.writeObject(object);
            }
            oos.close();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
    }
}
