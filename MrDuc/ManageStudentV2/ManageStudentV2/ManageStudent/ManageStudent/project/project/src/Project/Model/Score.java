package Project.Model;

public class Score {

  private String idStudent;
  private String idSubject;
  private String nameClassroom;
  private String tern;
  private float scoree;
  private Classroom classroom;
  private Subjects subjects;
  private Student student;
  private int pass;
  private int total;

  public int getPass() {
    return pass;
  }

  public void setPass(int pass) {
    this.pass = pass;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }
  
  public String getIdStudent() {
    return idStudent;
  }

  public void setIdStudent(String idStudent) {
    this.idStudent = idStudent;
  }

  public String getIdSubject() {
    return idSubject;
  }

  public void setIdSubject(String idSubject) {
    this.idSubject = idSubject;
  }

  public String getNameClassroom() {
    return nameClassroom;
  }

  public void setNameClassroom(String nameClassroom) {
    this.nameClassroom = nameClassroom;
  }

  public String getTern() {
    return tern;
  }

  public void setTern(String tern) {
    this.tern = tern;
  }

  public float getScoree() {
    return scoree;
  }

  public void setScoree(float scoree) {
    this.scoree = scoree;
  }

  public Classroom getClassroom() {
    return classroom;
  }

  public void setClassroom(Classroom classroom) {
    this.classroom = classroom;
  }

  public Subjects getSubjects() {
    return subjects;
  }

  public void setSubjects(Subjects subjects) {
    this.subjects = subjects;
  }

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public Score() {

  }

  public Score(String idStudent, String idSubject, String nameClassroom,
          String tern, float scoree, Classroom classroom, Subjects subjects, Student student) {
    this.idStudent = idStudent;
    this.idSubject = idSubject;
    this.nameClassroom = nameClassroom;
    this.tern = tern;
    this.scoree = scoree;
    this.classroom = classroom;
    this.subjects = subjects;
    this.student = student;
  }

}
