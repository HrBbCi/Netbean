package Project.Controller;

import Project.Interface.Check;
import Project.Model.Classs;
import Project.DatabaseAccess;
import Project.Interface.Dao;
import Project.Model.Lecturer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClassDAO extends Check implements Dao<Classs, String> {

  public static ClassDAO instance;

  public synchronized static ClassDAO getInstance() {
    if (instance == null) {
      instance = new ClassDAO();
    }
    return instance;
  }

  @Override
  public List<Classs> getAll() {
    List<Classs> lst = new ArrayList<>();
    Connection conn = DatabaseAccess.getConnection();
    Statement st = null;
    ResultSet rs = null;
    try {
      String query = "SELECT * FROM class;";
      st = conn.createStatement();
      rs = st.executeQuery(query);
      while (rs.next()) {
        Classs lp = new Classs();
        lp.setName(rs.getString("NameClass"));
        lp.setAmount(rs.getInt("Amount"));
        lst.add(lp);
      }
    } catch (SQLException ex) {
      System.out.println("Error get class : " + ex);
    } finally {
      closeConnection(conn);
      closeStatement(st);
      closeResult(rs);
    }
    return lst;
  }

  @Override
  public Classs getByID(String nameClass) {
    Connection conn = DatabaseAccess.getConnection();
    Statement comm = null;
    ResultSet rs = null;
    String query = "SELECT * FROM class "
            + " WHERE NameClass ='" + nameClass + "'";
    try {
      comm = conn.createStatement();
      rs = comm.executeQuery(query);
      Classs lp = null;
      while (rs.next()) {
        lp = new Classs();
        lp.setName(rs.getString("NameClass"));
        lp.setAmount(rs.getInt("Amount"));

      }
      return lp;
    } catch (SQLException ex) {
      System.err.println("Chi tiết lỗi : " + ex.getMessage());
    } finally {
      closeResult(rs);
      closeStatement(comm);
      closeConnection(conn);
    }
    return null;
  }

  @Override
  public boolean newAdd(Classs cls) {
    boolean isThanhCong = false;
    Connection conn = DatabaseAccess.getConnection();
    Statement st = null;
    try {
      st = conn.createStatement();
      String strInsert = String.format("INSERT INTO class(NameClass, Amount) "
              + " VALUES('%s','%s')", cls.getName(), cls.getAmount());
      isThanhCong = st.executeUpdate(strInsert) > 0;
    } catch (SQLException ex) {
      System.out.println("Error add Class");
    } finally {
      closeConnection(conn);
      closeStatement(st);
    }
    return isThanhCong;
  }

  @Override
  public boolean delete(String nameClass) {
    return true;
  }

  @Override
  public boolean edit(Classs lt) {
    Connection conn = null;
    Statement st = null;
    boolean isTC = false;
    try {
      conn = DatabaseAccess.getConnection();
      st = conn.createStatement();
      String query = "UPDATE class "
              + " SET NameClass = '" + lt.getName() + "', "
              + "  Amount = '" + lt.getAmount() + "' ";
      query += " WHERE NameClass = '" + lt.getName() + "';";
      isTC = st.executeUpdate(query) > 0;
    } catch (SQLException ex) {
      System.out.println("Error Update Class: " + ex);
    } finally {
      closeConnection(conn);
      closeStatement(st);
    }
    return isTC;
  }

  @Override
  public List<Classs> find(String... varargs) {
    List<Classs> lstCL = new ArrayList();
    Connection conn = DatabaseAccess.getConnection();
    String strSQL = "SELECT * FROM class WHERE 1 = 1 ";
    String NameClass = varargs[0];
    if (NameClass != null && !NameClass.isEmpty()) {
      strSQL += " AND NameClass LIKE '%" + NameClass + "%' ";
    }
    Statement comm = null;
    ResultSet rs = null;
    try {
      comm = conn.createStatement();
      rs = comm.executeQuery(strSQL);
      Classs lp;
      Lecturer lt;
      while (rs.next()) {
        lp = new Classs();
        lp.setName(rs.getString("NameClass"));
        lp.setAmount(rs.getInt("Amount"));

        lstCL.add(lp);
      }
    } catch (SQLException ex) {
      System.out.println("Error : " + ex);
    } finally {
      closeStatement(comm);
      closeResult(rs);
      closeConnection(conn);
    }
    return lstCL;
  }

  public List<Classs> getAllCLass() {
    List<Classs> lst = new ArrayList<>();
    Connection conn = DatabaseAccess.getConnection();
    Statement st = null;
    ResultSet rs = null;
    try {
      String query = "SELECT NameClass FROM class";
      st = conn.createStatement();
      rs = st.executeQuery(query);
      while (rs.next()) {
        Classs cl = new Classs();
        cl.setName(rs.getString("NameClass"));
        lst.add(cl);
      }
    } catch (SQLException ex) {
      System.out.println("Error get Class : " + ex);
    } finally {
      closeConnection(conn);
      closeResult(rs);
      closeStatement(st);
    }
    return lst;
  }

  public boolean isTest(String nameClass) {
    Connection conn = DatabaseAccess.getConnection();
    Statement st = null;
    ResultSet rs = null;
    try {
      String query = "SELECT NameClass FROM class";
      st = conn.createStatement();
      rs = st.executeQuery(query);
      while (rs.next()) {
        Classs cls = new Classs();
        cls.setName(rs.getString("NameClass"));
        if (nameClass.equals(cls.getName())) {
          return false;
        }
      }
    } catch (SQLException ex) {
      System.out.println("Error get NameClass : " + ex);
    } finally {
      closeConnection(conn);
      closeResult(rs);
      closeStatement(st);
    }
    return true;
  }
}
