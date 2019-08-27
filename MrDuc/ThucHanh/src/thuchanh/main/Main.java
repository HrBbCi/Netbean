
package thuchanh.main;

import java.util.Scanner;
import thuchanh.controller.ProductIO;

public class Main {
  public static void main(String[] args) {
    Scanner ss = new Scanner(System.in);
    
    int lc;
    ProductIO pdio = new ProductIO();
    pdio.read("BT.dat");
    do{
      System.out.println("1: Nhập sản phẩm \n2: In sản phẩm \n3: Thoát");
      lc = Integer.parseInt(ss.nextLine());
      switch(lc){
        case 1:
//          pdio.nhapSP();
          break;
        case 2:
//          pdio.xuatSP();
          break;
        case 3: 
          System.out.println("Thoát");
          break;
      }  
    }while(lc != 3);
  }
}
