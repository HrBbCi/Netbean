
package Project.Model;

import java.util.Date;


public class Student {

  private String idStudent;
  private String name;
  private int sex;
  private Date birthday;
  private String adress;
  private String mobile;
  private String email;
  private Classs cs;
  private Lecturer lt;

  public Lecturer getLt() {
    return lt;
  }

  public void setLt(Lecturer lt) {
    this.lt = lt;
  }
  
  
  public Classs getCs() {
    return cs;
  }

  public void setCs(Classs cs) {
    this.cs = cs;
  }
  
  public String getIdStudent() {
    return idStudent;
  }

  public void setIdStudent(String idStudent) {
    this.idStudent = idStudent;
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

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
  
  public Student(){
    
  }

  public Student(String idStudent, String name, int sex, Date birthday, 
          String adress, String mobile, String email, Classs cs, Lecturer lt) {
    this.idStudent = idStudent;
    this.name = name;
    this.sex = sex;
    this.birthday = birthday;
    this.adress = adress;
    this.mobile = mobile;
    this.email = email;
    this.cs = cs;
    this.lt = lt;
  }
  
}
