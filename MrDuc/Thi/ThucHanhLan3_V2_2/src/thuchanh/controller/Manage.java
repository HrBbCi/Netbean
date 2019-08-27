package thuchanh.controller;

import thuchanh.model.Product;
import java.util.ArrayList;
import java.util.List;

public class Manage {

  public Manage() {

  }
  public ArrayList<Product> lstProduct = new ArrayList<>();
  IOFile io = new IOFile();

  public void docFile() {
    IOFile.inFile(lstProduct, "BT.dat");
  }

  public void ghiFile() {
    IOFile.outFile(lstProduct, "BT.dat");
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
        ghiFile();
        return true;
      }
    }
    return false;
  }
}
