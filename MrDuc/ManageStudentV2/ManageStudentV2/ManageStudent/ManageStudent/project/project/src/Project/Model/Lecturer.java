package Project.Model;

import java.util.Date;

public class Lecturer {

  private String idLecturer;
  private String name;
  private int sex;
  private Date birthday;
  private String adress;
  private String counselorClass;

  public String getCounselorClass() {
    return counselorClass;
  }

  public void setCounselorClass(String counselorClass) {
    this.counselorClass = counselorClass;
  }

  private Classs cls;

  public Classs getCls() {
    return cls;
  }

  public void setCls(Classs cls) {
    this.cls = cls;
  }

  public String getIdLecturer() {
    return idLecturer;
  }

  public void setIdLecturer(String idLecturer) {
    this.idLecturer = idLecturer;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getSex() {
    return sex;
  }

  public void setSex(int sex) {
    this.sex = sex;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public String getAdress() {
    return adress;
  }

  public void setAdress(String adress) {
    this.adress = adress;
  }

  public Lecturer() {

  }

  public Lecturer(String idLecturer, String name, int sex, Date birthday, 
          String adress, String counselorClass, Classs cls) {
    this.idLecturer = idLecturer;
    this.name = name;
    this.sex = sex;
    this.birthday = birthday;
    this.adress = adress;
    this.counselorClass = counselorClass;
    this.cls = cls;
  }

}
