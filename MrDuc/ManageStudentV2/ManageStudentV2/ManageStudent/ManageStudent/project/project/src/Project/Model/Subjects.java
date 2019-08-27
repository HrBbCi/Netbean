package Project.Model;

public class Subjects {

  private String idSubject;
  private String nameSubject;
  private int Credit;

  public String getIdSubject() {
    return idSubject;
  }

  public void setIdSubject(String idSubject) {
    this.idSubject = idSubject;
  }

  public String getNameSubject() {
    return nameSubject;
  }

  public void setNameSubject(String nameSubject) {
    this.nameSubject = nameSubject;
  }

  public int getCredit() {
    return Credit;
  }

  public void setCredit(int Credit) {
    this.Credit = Credit;
  }

  public Subjects() {

  }

  public Subjects(String idSubject, String nameSubject, int Credit) {
    this.idSubject = idSubject;
    this.nameSubject = nameSubject;
    this.Credit = Credit;
  }

}
