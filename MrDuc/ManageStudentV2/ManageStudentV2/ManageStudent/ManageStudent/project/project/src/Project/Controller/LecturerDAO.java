package Project.Controller;

import Project.Model.Lecturer;
import Project.Interface.Check;
import Project.DatabaseAccess;
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

public class LecturerDAO extends Check implements Dao<Lecturer, String> {

  public static LecturerDAO instance;

  public synchronized static LecturerDAO getInstance() {
    if (instance == null) {
      instance = new LecturerDAO();
    }
    return instance;
  }

  @Override
  public List<Lecturer> getAll() {
    List<Lecturer> lst = new ArrayList<>();
    Connection conn = DatabaseAccess.getConnection();
    Statement st = null;
    ResultSet rs = null;
    try {
      String query = "SELECT * FROM lecturer";
      st = conn.createStatement();
      rs = st.executeQuery(query);
      while (rs.next()) {
        Lecturer gp = new Lecturer();
        gp.setIdLecturer(rs.getString("idLecturer"));
        gp.setName(rs.getString("NameLecturer"));
        gp.setSex(rs.getInt("Sex"));
        gp.setBirthday(rs.getDate("Birthday"));
        gp.setAdress(rs.getString("Adress"));
        gp.setCounselorClass(rs.getString("CounselorClass"));
        lst.add(gp);
      }
    } catch (SQLException ex) {
      System.out.println("Error get lecturer  : " + ex);
    } finally {
      closeConnection(conn);
      closeResult(rs);
      closeStatement(st);
    }
    return lst;
  }

  @Override
  public Lecturer getByID(String e) {
    Connection conn = DatabaseAccess.getConnection();
    Statement st = null;
    ResultSet rs = null;
    try {
      String query = "SELECT * FROM lecturer WHERE idLecturer ='" + e + "';";
      st = conn.createStatement();
      rs = st.executeQuery(query);
      Lecturer gp = null;
      while (rs.next()) {
        gp = new Lecturer();
        gp.setIdLecturer(rs.getString("idLecturer"));
        gp.setName(rs.getString("NameLecturer"));
        gp.setSex(rs.getInt("Sex"));
        gp.setBirthday(rs.getDate("Birthday"));
        gp.setAdress(rs.getString("Adress"));
        gp.setCounselorClass(rs.getString("CounselorClass"));
      }
      return gp;
    } catch (SQLException ex) {
      System.out.println("Error get lecturer  : " + ex);
    } finally {
      closeConnection(conn);
      closeResult(rs);
      closeStatement(st);
    }
    return null;
  }

  @Override
  public boolean newAdd(Lecturer lt) {
    boolean isThanhCong = false;
    Connection conn = DatabaseAccess.getConnection();
    Statement st = null;
    
    try {
      DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
      String birthday = df.format(lt.getBirthday());
      if (birthday == null) {
        birthday = "";
      }
      st = conn.createStatement();
      String strInsert = String.format("INSERT INTO lecturer(idLecturer, NameLecturer, "
              + " Sex, Birthday, Adress,CounselorClass) "
              + "VALUES('%s','%s','%s','%s','%s','%s');", lt.getIdLecturer(), lt.getName(), lt.getSex(),
              birthday, lt.getAdress(), lt.getCls().getName());
      isThanhCong = st.executeUpdate(strInsert) > 0;
    } catch (SQLException ex) {
      System.out.println("Error add Lecturer");
    } finally {
      closeConnection(conn);
      closeStatement(st);
    }
    return isThanhCong;
  }

  @Override
  public boolean delete(String t) {
    boolean isSuccess = false;
    Connection conn = DatabaseAccess.getConnection();
    PreparedStatement prs = null;
    String strUp = "DELETE lecturer FROM lecturer WHERE idLecturer = ? ;";
    try {
      prs = conn.prepareStatement(strUp);
      prs.setString(1, t);
      isSuccess = prs.executeUpdate() > 0;
    } catch (SQLException ex) {
      System.out.println("Error Delete Lecturer");
    } finally {
      closeConnection(conn);
      closePre(prs);
    }
    return isSuccess;
  }

  @Override
  public boolean edit(Lecturer lt) {
    Connection conn = null;
    Statement st = null;
    boolean isTC = false;
    try {
      conn = DatabaseAccess.getConnection();
      st = conn.createStatement();
      DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
      String birthday = lt.getBirthday() != null
              ? df.format(lt.getBirthday()) : "";
      String query = "UPDATE lecturer "
              + " SET NameLecturer = '" + lt.getName() + "', "
              + "  Sex = '" + lt.getSex() + "', "
              + "  Birthday = '" + birthday + "', "
              + "  Adress = '" + lt.getAdress() + "', "
              + "CounselorClass = '" + lt.getCls().getName() + "' ";
      query += " WHERE idLecturer = '" + lt.getIdLecturer() + "';";
      isTC = st.executeUpdate(query) > 0;
    } catch (SQLException ex) {
      System.out.println("Error Update Lecturer: " + ex);
    } finally {
      closeConnection(conn);
      closeStatement(st);
    }
    return isTC;
  }

  @Override
  public List<Lecturer> find(String... varargs) {
    List<Lecturer> lst = new ArrayList();
    Connection conn = DatabaseAccess.getConnection();
    String strSQL = "SELECT * FROM lecturer where 1 = 1 ";
    String idL = varargs[0];
    if (idL != null && !idL.isEmpty()) {
      strSQL += " AND idLecturer LIKE '%" + idL + "%' ";
    }
    String name = varargs[1];
    if (name != null && !name.isEmpty()) {
      strSQL += " AND NameLecturer LIKE '%" + name + "%' ";
    }
    Statement comm = null;
    ResultSet rs = null;
    try {
      comm = conn.createStatement();
      rs = comm.executeQuery(strSQL);
      Lecturer lt;
      while (rs.next()) {
        lt = new Lecturer();
        lt.setIdLecturer(rs.getString("idLecturer"));
        lt.setName(rs.getString("NameLecturer"));
        lt.setSex(rs.getInt("Sex"));
        lt.setBirthday(rs.getDate("Birthday"));
        lt.setAdress(rs.getString("Adress"));
        lt.setCounselorClass(rs.getString("CounselorClass"));
        lst.add(lt);
      }
    } catch (SQLException ex) {
      System.out.println("Error Find" + ex);
    } finally {
      closeConnection(conn);
      closeStatement(comm);
      closeResult(rs);
    }
    return lst;
  }

  public boolean isTest(String idSTD) {
    Connection conn = DatabaseAccess.getConnection();
    Statement st = null;
    ResultSet rs = null;
    try {
      String query = "SELECT idLecturer FROM lecturer";
      st = conn.createStatement();
      rs = st.executeQuery(query);
      while (rs.next()) {
        Lecturer lt = new Lecturer();
        lt.setIdLecturer(rs.getString("idLecturer"));
        if (idSTD.equals(lt.getIdLecturer())) {
          return false;
        }
      }
    } catch (SQLException ex) {
      System.out.println("Error get idLecturert : " + ex);
    } finally {
      closeConnection(conn);
      closeStatement(st);
      closeResult(rs);
    }
    return true;
  }

  public List<Lecturer> getAllID() {
    List<Lecturer> lst = new ArrayList<>();
    Connection conn = DatabaseAccess.getConnection();
    Statement st = null;
    ResultSet rs = null;
    try {
      String query = "SELECT NameLecturer FROM lecturer";
      st = conn.createStatement();
      rs = st.executeQuery(query);
      while (rs.next()) {
        Lecturer gp = new Lecturer();
        gp.setName(rs.getString("NameLecturer"));
        lst.add(gp);
      }
    } catch (SQLException ex) {
      System.out.println("Error get ID lecturer  : " + ex);
    } finally {
      closeConnection(conn);
      closeResult(rs);
      closeStatement(st);
    }
    return lst;
  }
}
