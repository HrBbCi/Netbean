
package baitap1;


public class Main {
  public static void main(String[] args) {
    
    //Extend Thread
    MyThread t = new MyThread();
    t.start();
    try {
      t.join();
    } catch (InterruptedException ex) {
    }
    //Implement Runnable
    MyRunnable mr = new MyRunnable();
    Thread th = new Thread(mr);
    th.start();
  }
}
