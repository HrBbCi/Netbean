package thuchanh.controller;

import thuchanh.model.Product;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductIO {

  public String path;

  public ProductIO(String path) {
    this.path = path;
  }
  public ArrayList<Product> lstProduct = new ArrayList<>();
  Scanner sc = new Scanner(System.in);

  public boolean hasObject(String filePath) {
    FileInputStream fi;
    boolean check = true;
    try {
      fi = new FileInputStream(filePath);
      try (ObjectInputStream inStream = new ObjectInputStream(fi)) {
        if (inStream.readObject() == null) {
          check = false;
        }
      }
    } catch (FileNotFoundException e) {
      check = false;
    } catch (IOException | ClassNotFoundException e) {
      check = false;
    }
    return check;
  }

  public void write(Product product) {
    ObjectOutputStream oos = null;
    try {
      // nếu file chưa lưu object nào thì ghi bình thường
      if (!hasObject(path)) {
        oos = new ObjectOutputStream(new FileOutputStream(path));
      } else {
        oos = new ObjectOutputStream(new FileOutputStream(path, true)) {
          @Override
          protected void writeStreamHeader() throws IOException {
            reset();
          }
        };
      }

      oos.writeObject(product);
      System.out.println("Xong!");
    } catch (IOException ex) {
    } finally {
      if (oos != null) {
        try {
          oos.close();
        } catch (IOException e) {
        }
      }
    }
  }

  public ArrayList readAll() {
    ObjectInputStream inStream = null;
    try {
      inStream = new ObjectInputStream(new FileInputStream(path));
      Object s;
      while (true) {
        s = inStream.readObject();
        lstProduct.add((Product) s);
      }
    } catch (ClassNotFoundException | IOException e) {
    } finally {
      if (inStream != null) {
        try {
          inStream.close();
        } catch (IOException e) {
        }
      }

    }
    return lstProduct;
  }

  public boolean search(String id) {
    Product temp = new Product();
    for (int i = 0; i < lstProduct.size(); i++) {
      temp = this.lstProduct.get(i);
      if (temp.getId().equalsIgnoreCase(id)) {
        return true;
      }
    }
    return false;
  }

  public List<Product> getByID(String id) {
    List<Product> lst = new ArrayList<>();
    Product pd ;
    for (int i = 0; i < lstProduct.size(); i++) {
      pd = lstProduct.get(i);
      if (pd.getId().equals(id)) {
        lst.add(pd);
      }
    }
    return lst;
  }

}
