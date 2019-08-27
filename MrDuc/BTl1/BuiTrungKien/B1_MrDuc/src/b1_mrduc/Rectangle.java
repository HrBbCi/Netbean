/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b1_mrduc;

public class Rectangle extends Shape {

  private int width = 5;
  private int height = 5;

  @Override
  public void Draw() {
    System.out.println("Hình chữ nhật");
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
          System.out.print("*");
      }
      System.out.println(" ");
    }
  }

}
