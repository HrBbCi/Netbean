package thuchanh.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import thuchanh.model.ProductType;

public class ProductTypeIO {

  public ProductTypeIO() {

  }
  public ArrayList<ProductType> lstProductType = new ArrayList<>();

  public void nhapProductType() {
    ProductType pt = new ProductType("a", "2");
    write(pt);
  }

  public void write(ProductType product) {
    String fileName = "product_type.txt";
    File input = new File(fileName);
    try {
      input.createNewFile();
      PrintWriter pw = new PrintWriter(new FileOutputStream(input,true));
      pw.println(product.getId() + " " + product.getName());
      pw.flush();
      pw.close();
    } catch (IOException ex) {
    }
  }

  public ArrayList<ProductType> readAll() {
    String path = "product_type.txt";
    File f = new File(path);
    try (Scanner sc = new Scanner(f)) {
      String str;
      while (sc.hasNext()) {
        str = sc.nextLine();
        ProductType pt = new ProductType();
        String a[] = str.split(" ");
        pt.setId(a[0]);
        pt.setName(a[1]);
        lstProductType.add(pt);
      }
    } catch (Exception e) {
    }
    return lstProductType;
  }
}
