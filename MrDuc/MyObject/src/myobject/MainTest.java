package myobject;

public class MainTest {

  public static void main(String[] args) {
    MyObject object = new MyObject();

    Thread tA = new Thread(new ThreadA(object));
    Thread tB = new Thread(new ThreadB(object));

    tA.start();
    tB.start();
  }
}
