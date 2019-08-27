package thuchanh.controller;

import java.util.ArrayList;
import thuchanh.model.Product;
import thuchanh.model.ProductType;

public class Merge {

  public ProductIO pdio3 = new ProductIO("product.txt");
  public ArrayList<Product> lst3 = pdio3.read();

  public synchronized void Textt(String text1) {
    String arr1[] = text1.split("\n");
    for (String arr11 : arr1) {
      String[] arr2 = arr11.split("-");
      Product pd = new Product();
      pd.setId(arr2[0]);
      pd.setName(arr2[1]);
      pd.setPrice(arr2[2]);
      ProductType pt = new ProductType();
      pt.setId(arr2[3]);
      pd.setPd(pt);
      pdio3.write(pd);
    }
  }
}
