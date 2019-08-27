package thuchanh.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import thuchanh.model.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import thuchanh.model.ProductType;

public class ProductIO {

  public String path;
  public ArrayList<Product> lstProduct = new ArrayList<>();

  public ProductIO(String path) {
    this.path = path;
  }

  public void readFile(){
    lstProduct = read();
  }
  
  public void writeFile(Product product){
    write(product);
  }
  public void write(Product product) {
    File input = new File(path);
    try {
      input.createNewFile();
      PrintWriter pw = new PrintWriter(new FileOutputStream(input, true));
      pw.println(product.getId() + " " + product.getName() + " "
              + product.getPrice() + " " + product.getPd().getId());
      pw.flush();
      pw.close();
    } catch (IOException ex) {
    }
  }

  public ArrayList<Product> read() {
    File f = new File(path);
    try (Scanner sc = new Scanner(f)) {
      String str;
      while (sc.hasNext()) {
        str = sc.nextLine();
        Product pt = new Product();
        String a[] = str.split(" ");
        pt.setId(a[0]);
        pt.setName(a[1]);
        pt.setPrice(a[2]);
        ProductType pdt = new ProductType();
        pdt.setId(a[3]);
        pt.setPd(pdt);

        lstProduct.add(pt);
      }
    } catch (Exception e) {
    }
    return lstProduct;
  }

  public Product search(String id) {
    Product temp = new Product();
    for (int i = 0; i < lstProduct.size(); i++) {
      temp = lstProduct.get(i);
      if (temp.getId().equals(id)) {
        return temp;
      }
    }
    return null;
  }

  public boolean search1(String id) {
    for (Product b : lstProduct) {
      if (b.getId().equals(id)) {
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
          temp.setPd(pd.getPd());
          temp.setPrice(pd.getPrice());
//          lstProduct.set(i, temp);
          writeFile(temp);
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
