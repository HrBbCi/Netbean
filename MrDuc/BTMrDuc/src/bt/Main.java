package bt;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    Product pd = new Product();

    int lc;
    do {
      System.out.println("1: Nhập\n2: Xuất\n3: Thoát");
      lc = in.nextInt();
      switch (lc) {
        case 1: {
          System.out.print("ID: ");
          int id = in.nextInt();
          in.nextLine();

          System.out.print("Name: ");
          String name = in.nextLine();

          System.out.print("Type: ");
          String type = in.nextLine();

          System.out.print("Price: ");
          float price = in.nextFloat();
          pd.setId(id);
          pd.setName(name);
          pd.setType(type);
          pd.setPrice(price);
          break;
        }
        case 2: {
          System.out.printf("%-15s %-15s %-15s %-15s", "id", "name", "type", "price");
          System.out.println("");
          System.out.printf("%-15s %-15s %-15s %-15s", pd.getId(), pd.getName(), pd.getType(), pd.getPrice());
          System.out.println("");
          break;
        }
        default:
          System.out.println("exit");
          break;
      }
    } while (lc != 3);

    System.out.println("Nhập vào file: ");
    File f = new File("BT.txt");
    pd.write(f);
    System.out.println("Nhập xong");

    if (!f.exists()) {
      System.out.println("Fail");
    }

    String strRead = FileUtils.readString(f);

    System.out.println("File đã đọc: ");
    System.out.println(strRead);

    List<Product> ls = new ArrayList<>();
    String[] arr = strRead.split("\n");
    for(int i = 0 ; i< arr.length ; i ++){
      System.out.println(arr[i]);
    }
    for (int i = 0; i < arr.length; i++) {
      String[] arr1 = arr[i].split("|");
      Product pd2 = new Product();
      pd2.setId(Integer.parseInt(arr1[0]));
      pd2.setName(arr1[1]+"");
      pd2.setType(arr1[2]+"");
      pd2.setPrice(Float.parseFloat(arr1[3]));
      ls.add(pd2);
    }
    for (int i = 0; i < ls.size(); i++) {
      System.out.println("ID: " + ls.get(i).getId());
    }
  }

}
