package thuchanh.controller;

import java.util.Random;


public class Randomm {
  public int random(){
    Random rd = new Random();
    int so = rd.nextInt();
    while(so < 100 || so > 200){
       so = rd.nextInt();
    }
    return so;
  }
}
