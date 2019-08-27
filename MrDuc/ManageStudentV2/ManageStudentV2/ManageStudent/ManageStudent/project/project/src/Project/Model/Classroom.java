package Project.Model;

public class Classroom {

  private String name;
  private int numberSeater;
  private String position;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getNumberSeater() {
    return numberSeater;
  }

  public void setNumberSeater(int numberSeater) {
    this.numberSeater = numberSeater;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public Classroom() {

  }

  public Classroom(String name, int numberSeater, String position) {
    this.name = name;
    this.numberSeater = numberSeater;
    this.position = position;
  }


}
