package myobject;

public class MyObject {

  private boolean valid = false;
  int i = 0;

  public synchronized void showValue() {
    try {
      while (!isValid()) {
        wait();
      }
      //pause();  
      System.out.println(i);
      setValid(false);
      notifyAll();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  public synchronized void setValue(int value) {
    try {
      while (isValid()) {
        wait();
      }
      this.i = value;
      setValid(true);
      notifyAll();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  public int getI() {
    return i;
  }

  public void setI(int i) {
    this.i = i;
  }

  public void pause() {
    try {
      Thread.sleep(50);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public boolean isValid() {
    return valid;
  }

  public void setValid(boolean valid) {
    this.valid = valid;
  }
}
