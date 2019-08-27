package Project.Model;

public class Classs {

  private String name;
  private int amount;
  private Lecturer lt;

  public Lecturer getLt() {
    return lt;
  }

  public void setLt(Lecturer lt) {
    this.lt = lt;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public Classs() {

  }

  public Classs(String name, int amount, Lecturer lt) {
    this.name = name;
    this.amount = amount;
    this.lt = lt;
  }

}
