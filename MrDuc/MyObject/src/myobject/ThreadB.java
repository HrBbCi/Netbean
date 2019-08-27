package myobject;

public class ThreadB implements Runnable {

  MyObject obj;

  public ThreadB(MyObject obj) {
    this.obj = obj;
  }

  public void run() {
    while (true) {
      obj.showValue();
      if (obj.i == 1000000) {
        break;
      }
    }
    System.out.println("Thread B - Finished");
  }
}
