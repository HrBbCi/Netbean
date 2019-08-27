package Project.Controller;

import Project.Model.Student;
import Project.Interface.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import Project.DatabaseAccess;
import Project.Interface.Check;
import Project.Model.Classs;
import Project.Model.Counselor;
import Project.Model.Lecturer;

public class StudentDAO extends Check implements Dao<Student, String> {
  
  public static StudentDAO instance;
  
  public synchronized static StudentDAO getInstance() {
    if (instance == null) {
      instance = new StudentDAO();
    }
    return instance;
  }
  
  @Override
  public List<Student> getAll() {
    List<Student> lstSV = new ArrayList();
    Connection conn = DatabaseAccess.getConnection();
    String strSQL = "SELECT sv.idStudent, sv.Name, sv.Sex, sv.Birthday, sv.Adress, sv.Email, sv.Mobilephone "
            + " ,cls.NameClass,lt.NameLecturer FROM "
            + "((student AS sv INNER JOIN counselors AS csl ON sv.idStudent = csl.idStudent) "
            + " INNER JOIN class AS cls ON cls.NameClass = csl.ClassName) INNER JOIN lecturer AS lt "
            + " ON lt.CounselorClass = cls.NameClass;";
    Statement comm = null;
    ResultSet rs = null;
    try {
      comm = conn.createStatement();
      rs = comm.executeQuery(strSQL);
      Student sv;
      Classs cs;
      Lecturer lt;
      while (rs.next()) {
        sv = new Student();
        sv.setIdStudent(rs.getString("idStudent"));
        sv.setName(rs.getString("Name"));
        sv.setSex(rs.getInt("Sex"));
        sv.setBirthday(rs.getDate("Birthday"));
        sv.setAdress(rs.getString("Adress"));
        sv.setEmail(rs.getString("Email"));
        sv.setMobile(rs.getString("Mobilephone"));
        
        cs = new Classs();
        cs.setName(rs.getString("NameClass"));
        sv.setCs(cs);
        
        lt = new Lecturer();
        lt.setName(rs.getString("NameLecturer"));
        sv.setLt(lt);
        
        lstSV.add(sv);
      }
    } catch (SQLException ex) {
      System.out.println("Lỗi" + ex);
    } finally {
      closeStatement(comm);
      closeResult(rs);
      closeConnection(conn);
    }
    return lstSV;
  }
  
  @Override
  public Student getByID(String id) {
    Connection conn = DatabaseAccess.getConnection();
    Statement comm = null;
    ResultSet rs = null;
    String strSQL = "SELECT sv.idStudent, sv.Name, sv.Sex, sv.Birthday, sv.Adress, sv.Email, sv.Mobilephone "
            + " ,cls.NameClass,lt.NameLecturer FROM "
            + "((student AS sv INNER JOIN COUNSELORS AS csl ON sv.idStudent = csl.idStudent) "
            + " INNER JOIN CLASS AS cls ON cls.NameClass = csl.ClassName) INNER JOIN lecturer AS lt "
            + " ON lt.CounselorClass = cls.NameClass WHERE sv.idStudent = '" + id + "'";
    try {
      comm = conn.createStatement();
      rs = comm.executeQuery(strSQL);
      Student sv = null;
      Classs cs;
      Lecturer lt;
      while (rs.next()) {
        sv = new Student();
        sv.setIdStudent(rs.getString("idStudent"));
        sv.setName(rs.getString("Name"));
        sv.setSex(rs.getInt("Sex"));
        sv.setBirthday(rs.getDate("Birthday"));
        sv.setAdress(rs.getString("Adress"));
        sv.setEmail(rs.getString("Email"));
        sv.setMobile(rs.getString("Mobilephone"));
        
        cs = new Classs();
        cs.setName(rs.getString("NameClass"));
        sv.setCs(cs);
        
        lt = new Lecturer();
        lt.setName(rs.getString("NameLecturer"));
        sv.setLt(lt);
      }
      return sv;
    } catch (SQLException ex) {
      System.err.println("Chi tiết lỗi: " + ex.getMessage());
    } finally {
      closeConnection(conn);
      closeResult(rs);
      closeStatement(comm);
    }
    return null;
  }
  
  @Override
  public boolean newAdd(Student sv) {
    boolean isThanhCong = false;
    Connection conn = DatabaseAccess.getConnection();
    Statement st = null;
    Statement st1 = null;
    try {
      DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
      String birthday = df.format(sv.getBirthday());
      if (birthday == null) {
        birthday = "";
      }
      st = conn.createStatement();
      st1 = conn.createStatement();
      String strInsert = String.format("INSERT INTO student(idStudent, Name, "
              + " Sex, Birthday, Adress ,Mobilephone,Email) "
              + "VALUES('%s','%s','%s','%s','%s','%s','%s');", sv.getIdStudent(), sv.getName(), sv.getSex(),
              birthday, sv.getAdress(), sv.getMobile(), sv.getEmail());
      isThanhCong = st.executeUpdate(strInsert) > 0;
      String strInsert1 = String.format("INSERT INTO counselors(idStudent, ClassName) "
              + "VALUES('%s','%s');", sv.getIdStudent(), sv.getCs().getName());
      isThanhCong = st1.executeUpdate(strInsert1) > 0;
      
    } catch (SQLException ex) {
      System.out.println("Error add Student");
    } finally {
      closeConnection(conn);
      closeStatement(st);
      closeStatement(st1);
    }
    return isThanhCong;
  }
  
  @Override
  public boolean delete(String maSV) {
    boolean isSuccess = false;
    Connection conn = DatabaseAccess.getConnection();
    Statement st = null;
    PreparedStatement prs = null;
    PreparedStatement prs1 = null;
    String strUp = "DELETE student,counselors FROM student,counselors WHERE "
            + " student.idStudent=counselors.idStudent "
            + " AND student.idStudent = ? ;";
    String strGetID = "SELECT idStudent FROM study;";
    try {
      prs = conn.prepareStatement(strUp);
      prs.setString(1, maSV);
      isSuccess = prs.executeUpdate() > 0;
      
      st = conn.createStatement();
      ResultSet rs = st.executeQuery(strGetID);
      while (rs.next()) {
        Counselor csl = new Counselor();
        Student sd = new Student();
        sd.setIdStudent(rs.getString("idStudent"));
        csl.setSd(sd);
        if (maSV.equals(csl.getSd().getIdStudent())) {
          String strDel = "DELETE study FROM study WHERE idStudent = ?";
          prs1 = conn.prepareStatement(strDel);
          prs1.setString(1, maSV);
          isSuccess = prs1.executeUpdate() > 0;
        }
      }
      
    } catch (SQLException ex) {
      System.out.println("Error Delete Student");
    } finally {
      closeStatement(st);
      closePre(prs);
      closePre(prs1);
    }
    return isSuccess;
    
  }
  
  @Override
  public boolean edit(Student sv) {
    Connection conn = null;
    Statement st = null;
    Statement st1 = null;
    boolean isTC = false;
    try {
      conn = DatabaseAccess.getConnection();
      st = conn.createStatement();
      st1 = conn.createStatement();
      DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
      String birthday = sv.getBirthday() != null
              ? df.format(sv.getBirthday()) : "";
      String query = "UPDATE student "
              + " SET Name = '" + sv.getName() + "', "
              + "  Sex = '" + sv.getSex() + "', "
              + "  Birthday = '" + birthday + "', "
              + "  Adress = '" + sv.getAdress() + "', "
              + "  Mobilephone = '" + sv.getMobile() + "', "
              + "  Email = '" + sv.getEmail() + "' ";
      query += " WHERE idStudent = '" + sv.getIdStudent() + "';";
      isTC = st.executeUpdate(query) > 0;
      
      String query1 = "UPDATE COUNSELORS "
              + " SET ClassName = '" + sv.getCs().getName() + "' "
              + " WHERE idStudent = '" + sv.getIdStudent() + "';";
      isTC = st1.executeUpdate(query1) > 0;
      
    } catch (SQLException ex) {
      System.out.println("Error Update Student: " + ex);
    } finally {
      closeConnection(conn);
      closeStatement(st);
      closeStatement(st1);
    }
    return isTC;
  }
  
  @Override
  public List<Student> find(String... varargs) {
    List<Student> lstSV = new ArrayList();
    Connection conn = DatabaseAccess.getConnection();
    String strSQL = "SELECT sv.idStudent, sv.Name, sv.Sex, sv.Birthday, sv.Adress, sv.Email, sv.Mobilephone "
            + " ,cls.NameClass,lt.NameLecturer FROM "
            + "((student AS sv INNER JOIN COUNSELORS AS csl ON sv.idStudent = csl.idStudent) "
            + " INNER JOIN CLASS AS cls ON cls.NameClass = csl.ClassName) INNER JOIN lecturer AS lt "
            + " ON lt.CounselorClass = cls.NameClass WHERE 1 = 1 ";
    String idStudent = varargs[0];
    if (idStudent != null && !idStudent.isEmpty()) {
      strSQL += " AND sv.idStudent LIKE '%" + idStudent + "%' ";
    }
    String name = varargs[1];
    if (name != null && !name.isEmpty()) {
      strSQL += " AND sv.Name LIKE '%" + name + "%' ";
    }
    Statement comm = null;
    ResultSet rs = null;
    try {
      comm = conn.createStatement();
      rs = comm.executeQuery(strSQL);
      Student sv;
      Classs cs;
      Lecturer lt;
      while (rs.next()) {
        sv = new Student();
        sv.setIdStudent(rs.getString("idStudent"));
        sv.setName(rs.getString("Name"));
        sv.setSex(rs.getInt("Sex"));
        sv.setBirthday(rs.getDate("Birthday"));
        sv.setAdress(rs.getString("Adress"));
        sv.setEmail(rs.getString("Email"));
        sv.setMobile(rs.getString("Mobilephone"));
        
        cs = new Classs();
        cs.setName(rs.getString("NameClass"));
        sv.setCs(cs);
        
        lt = new Lecturer();
        lt.setName(rs.getString("NameLecturer"));
        sv.setLt(lt);
        lstSV.add(sv);
      }
    } catch (SQLException ex) {
      System.out.println("Lỗi" + ex);
    } finally {
      closeStatement(comm);
      closeResult(rs);
      closeConnection(conn);
    }
    return lstSV;
  }
  
  public boolean isTest(String maSV) {
    Connection conn = DatabaseAccess.getConnection();
    Statement st = null;
    ResultSet rs = null;
    try {
      String query = "SELECT idStudent FROM student";
      st = conn.createStatement();
      rs = st.executeQuery(query);
      while (rs.next()) {
        Student sv = new Student();
        sv.setIdStudent(rs.getString("idStudent"));
        if (maSV.equals(sv.getIdStudent())) {
          return false;
        }
      }
    } catch (SQLException ex) {
      System.out.println("Error get ID STudent : " + ex);
    } finally {
      closeConnection(conn);
      closeResult(rs);
      closeStatement(st);
    }
    return true;
  }
  
  public List<Student> getAllMaSV() {
    List<Student> lst = new ArrayList<>();
    Connection conn = DatabaseAccess.getConnection();
    Statement st = null;
    ResultSet rs = null;
    try {
      String query = "SELECT idStudent FROM student";
      st = conn.createStatement();
      rs = st.executeQuery(query);
      while (rs.next()) {
        Student sv = new Student();
        sv.setIdStudent(rs.getString("idStudent"));
        lst.add(sv);
      }
    } catch (SQLException ex) {
      System.out.println("Error get ID STUDENT : " + ex);
    } finally {
      closeConnection(conn);
      closeResult(rs);
      closeStatement(st);
    }
    return lst;
    
  }
  
  public boolean checkSDT(String sdt) {
    if (!sdt.matches("\\d{9}")) {      
      return false;
    }
    return true;
  }
}
