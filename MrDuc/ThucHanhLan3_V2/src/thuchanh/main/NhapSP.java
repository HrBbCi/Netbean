/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thuchanh.main;

import java.util.ArrayList;
import thuchanh.controller.ProductTypeIO;
import thuchanh.model.ProductType;

/**
 *
 * @author HrBbCi
 */
public class NhapSP {
  public static void main(String[] args) {
    ProductTypeIO pd = new ProductTypeIO();
//    pd.nhapProductType();
    ArrayList<ProductType> ls = pd.readAll();
    for(ProductType pd1 : ls){
      System.out.println(pd1.getId());
    }
  }
}
