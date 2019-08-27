package thuchanh.controller;

import thuchanh.model.Product;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductIO {

  public ProductIO() {

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

  public void write(Product product, String path) {
    FileOutputStream fout = null;
    ObjectOutputStream oos = null;
    try {
      // nếu file chưa lưu object nào thì ghi bình thường
      if (!hasObject(path)) {
        fout = new FileOutputStream(path);
        oos = new ObjectOutputStream(fout);
      } else {
        fout = new FileOutputStream(path, true);
        oos = new ObjectOutputStream(fout) {
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
      if (fout != null) {
        try {
          fout.close();
        } catch (IOException e) {
        }
      }

      if (oos != null) {
        try {
          oos.close();
        } catch (IOException e) {
        }
      }
    }
  }

  public void read(String path) {
    FileInputStream fis = null;
    ObjectInputStream inStream = null;
    try {
      fis = new FileInputStream(path);
      inStream = new ObjectInputStream(fis);
      Object s;
      int i = 0;
      while (true) {
        s = inStream.readObject();
        System.out.println(++i + " : " + s.toString());
      }
    } catch (ClassNotFoundException | IOException e) {
    } finally {
      if (fis != null) {
        try {
          fis.close();
        } catch (IOException e) {
        }
      }

      if (inStream != null) {
        try {
          inStream.close();
        } catch (IOException e) {
        }
      }

    }
  }

  public ArrayList readAll(String path) {
    FileInputStream fis = null;
    ObjectInputStream inStream = null;
    try {
      fis = new FileInputStream(path);
      inStream = new ObjectInputStream(fis);
      Object s;
      int i = 0;
      while (true) {
        s = inStream.readObject();
        lstProduct.add((Product) s);
      }
    } catch (ClassNotFoundException | IOException e) {
    } finally {
      if (fis != null) {
        try {
          fis.close();
        } catch (IOException e) {
        }
      }

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

//  public void nhapSP() {
//    Product pd = new Product();
//    System.out.println("Nhập ID : ");
//    while (true) {
//      String temp = sc.nextLine();
//      if (search(temp) == true) {
//        System.out.println("ID exits");
//      } else {
//        pd.setId(temp);
//        break;
//      }
//    }
//    System.out.println("Name : ");
//    pd.setName(sc.nextLine());
//    System.out.println("Type: ");
//    pd.setType(sc.nextLine());
//    System.out.println("Price : ");
//    pd.setPrice(sc.nextLine());
//    lstProduct.add(pd);
//    write(pd, "BT.dat");
//  }
//
//  public void xuatSP() {
//    System.out.println("Danh sach SP:");
//    int k = 1;
//    for (Product pr : lstProduct) {
//      System.out.println(k + ". " + pr.toString());
//      k++;
//    }
//  }
}
