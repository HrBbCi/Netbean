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
    boolean check = true;
    try {
      try (ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(filePath))) {
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

  public Product search(String id) {
    Product temp = new Product();
    for (int i = 0; i < lstProduct.size(); i++) {
      temp = this.lstProduct.get(i);
      if (temp.getId().equalsIgnoreCase(id)) {
        return temp;
      }
    }
    return null;
  }

  public boolean search1(String id) {
    Product temp = new Product();
    for (int i = 0; i < lstProduct.size(); i++) {
      temp = this.lstProduct.get(i);
      if (temp.getId().equalsIgnoreCase(id)) {
        return true;
      }
    }
    return false;
  }

  public List<Product> getBy(String... a) {
    List<Product> lst = new ArrayList<>();
    Product pd;
    String id = a[0];
    String name = a[1];
    if (!id.isEmpty() && name.isEmpty()) {
      for (int i = 0; i < lstProduct.size(); i++) {
        pd = lstProduct.get(i);
        if (pd.getId().equals(id)) {
          lst.add(pd);
        }
      }
    }
    if (!name.isEmpty() && id.isEmpty()) {
      for (int i = 0; i < lstProduct.size(); i++) {
        pd = lstProduct.get(i);
        if (pd.getName().equals(name)) {
          lst.add(pd);
        }
      }
    }
    if (!name.isEmpty() && !id.isEmpty()) {
      for (int i = 0; i < lstProduct.size(); i++) {
        pd = lstProduct.get(i);
        if (pd.getName().equals(name) && pd.getId().equals(id)) {
          lst.add(pd);
        }
      }
    }

    return lst;
  }

  public void them(Product pd) {
    if (pd != null) {
      lstProduct.add(pd);
    }
  }

  public boolean sua(Product pd) {
    if (pd != null) {
      Product temp = null;
      for (int i = 0, length = lstProduct.size(); i < length; i++) {
        temp = lstProduct.get(i);
        if (temp.getId().equals(pd.getId())) {
          temp.setId(pd.getId());
          temp.setName(pd.getName());
          temp.setPrice(pd.getPrice());
          temp.setPd(pd.getPd());
          ProductIO pi = new ProductIO("BT.dat");
          return true;
        }
      }
    }
    return false;
  }

  public boolean xoa(String ma) {
    if (ma == null || ma.isEmpty()) {
      return false;
    }
    for (Product pd : lstProduct) {
      if (pd.getId().equals(ma)) {
        lstProduct.remove(pd);
        return true;
      }
    }
    return false;
  }
}
