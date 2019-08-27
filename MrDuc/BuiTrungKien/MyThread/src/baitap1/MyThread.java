
package baitap1;

public class MyThread extends Thread{

  @Override
  public void run() {
    for(int i = 0 ; i< 20 ;i++){
      try {
        System.out.println("I'm falling..");
        Thread.sleep(500);
      } catch (InterruptedException ex) {
      }
    }
  }
  
}
