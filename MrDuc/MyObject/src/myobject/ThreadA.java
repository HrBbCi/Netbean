package myobject;

public class ThreadA implements Runnable {

  MyObject object;
  int i = 0;

  public ThreadA(MyObject object) {
    super();
    this.object = object;
  }

  public void run() {
    for (int i = 1000; i <= 1000000; i++) {
      if (i % 1000 == 0) {
        object.setValue(i);
      }
    }
    System.out.println("Thread A - Finished");
  }
}
