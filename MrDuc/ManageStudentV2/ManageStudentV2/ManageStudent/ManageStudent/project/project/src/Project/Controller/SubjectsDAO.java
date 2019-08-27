package Project.Controller;

import Project.Model.Subjects;
import Project.Interface.Check;
import Project.DatabaseAccess;
import Project.Interface.Dao;
import Project.Model.Score;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SubjectsDAO extends Check implements Dao<Subjects, String> {
  
  public static SubjectsDAO instance;
  
  public synchronized static SubjectsDAO getInstance() {
    if (instance == null) {
      instance = new SubjectsDAO();
    }
    return instance;
  }
  
  @Override
  public List<Subjects> getAll() {
    List<Subjects> lstSub = new ArrayList();
    Connection conn = DatabaseAccess.getConnection();
    String strSQL = "SELECT * FROM subject";
    Statement comm = null;
    ResultSet rs = null;
    try {
      comm = conn.createStatement();
      rs = comm.executeQuery(strSQL);
      Subjects sb;
      while (rs.next()) {
        sb = new Subjects();
        sb.setIdSubject(rs.getString("idSubject"));
        sb.setNameSubject(rs.getString("NameSubject"));
        sb.setCredit(rs.getInt("Credit"));
        lstSub.add(sb);
      }
    } catch (SQLException ex) {
      System.out.println("Error getAll subject" + ex);
    } finally {
      closeStatement(comm);
      closeResult(rs);
      closeConnection(conn);
    }
    return lstSub;
  }
  
  @Override
  public Subjects getByID(String id) {
    
    Connection conn = DatabaseAccess.getConnection();
    String strSQL = "SELECT * FROM subject WHERE idSubject = '" + id + "'";
    Statement comm = null;
    ResultSet rs = null;
    try {
      comm = conn.createStatement();
      rs = comm.executeQuery(strSQL);
      Subjects sb = null;
      while (rs.next()) {
        sb = new Subjects();
        sb.setIdSubject(rs.getString("idSubject"));
        sb.setNameSubject(rs.getString("NameSubject"));
        sb.setCredit(rs.getInt("Credit"));
      }
      return sb;
    } catch (SQLException ex) {
      System.out.println("Error getAll subject by ID" + ex);
    } finally {
      closeStatement(comm);
      closeResult(rs);
      closeConnection(conn);
    }
    return null;
  }
  
  @Override
  public boolean newAdd(Subjects sb) {
    boolean isThanhCong = false;
    Connection conn = DatabaseAccess.getConnection();
    Statement st = null;
    try {
      st = conn.createStatement();
      String strInsert = String.format("INSERT INTO subject(idSubject, NameSubject, Credit) "
              + " VALUES('%s','%s','%s');", sb.getIdSubject(), sb.getNameSubject(), sb.getCredit());
      isThanhCong = st.executeUpdate(strInsert) > 0;
    } catch (SQLException ex) {
      System.out.println("Error add Subject");
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
    Statement st = null;
    PreparedStatement prs = null;
    PreparedStatement prs1 = null;
    ResultSet rs = null;
    String strUp = "DELETE FROM subject WHERE "
            + " idSubject = ? ;";
    String strGetID = "SELECT idSubject FROM study;";
    try {
      prs = conn.prepareStatement(strUp);
      prs.setString(1, t);
      isSuccess = prs.executeUpdate() > 0;
      
      st = conn.createStatement();
      rs = st.executeQuery(strGetID);
      while (rs.next()) {
        Score csl = new Score();
        Subjects sd = new Subjects();
        sd.setIdSubject(rs.getString("idSubject"));
        csl.setSubjects(sd);
        if (t.equals(csl.getSubjects().getIdSubject())) {
          String strDel = "DELETE FROM study WHERE idSubject = ?";
          prs1 = conn.prepareStatement(strDel);
          prs1.setString(1, t);
          isSuccess = prs1.executeUpdate() > 0;
        }
      }
    } catch (SQLException ex) {
      System.out.println("Error Delete Subject");
    } finally {
      closeConnection(conn);
      closeResult(rs); 
      closePre(prs);
      closePre(prs1);
      closeStatement(st);
    }
    return isSuccess;
  }
  
  @Override
  public boolean edit(Subjects sb) {
    Connection conn = null;
    Statement st = null;
    boolean isTC = false;
    try {
      conn = DatabaseAccess.getConnection();
      st = conn.createStatement();
      String query = "UPDATE subject "
              + " SET NameSubject = '" + sb.getNameSubject() + "', "
              + " Credit = '" + sb.getCredit() + "' ";
      query += " WHERE idSubject = '" + sb.getIdSubject() + "';";
      isTC = st.executeUpdate(query) > 0;
    } catch (SQLException ex) {
      System.out.println("Error Update Subject: " + ex);
    } finally {
      closeConnection(conn);
      closeStatement(st);
      
    }
    return isTC;
  }
  
  @Override
  public List<Subjects> find(String... varargs) {
    List<Subjects> lstSB = new ArrayList();
    Connection conn = DatabaseAccess.getConnection();
    String strSQL = "SELECT * FROM subject where 1 = 1 ";
    String idSubject = varargs[0];
    if (idSubject != null && !idSubject.isEmpty()) {
      strSQL += " AND idSubject LIKE '%" + idSubject + "%' ";
    }
    String name = varargs[1];
    if (name != null && !name.isEmpty()) {
      strSQL += " AND NameSubject LIKE '%" + name + "%' ";
    }
    Statement comm = null;
    ResultSet rs = null;
    try {
      comm = conn.createStatement();
      rs = comm.executeQuery(strSQL);
      Subjects sb = null;
      while (rs.next()) {
        sb = new Subjects();
        sb.setIdSubject(rs.getString("idSubject"));
        sb.setNameSubject(rs.getString("NameSubject"));
        sb.setCredit(rs.getInt("Credit"));
        lstSB.add(sb);
      }
    } catch (SQLException ex) {
      System.out.println("Error SQL : " + ex);
    } finally {
      closeStatement(comm);
      closeResult(rs);
    }
    return lstSB;
  }
  
  public List<Subjects> getAllMaMH() {
    List<Subjects> lst = new ArrayList<>();
    Statement st = null;
    ResultSet rs = null;
    Connection conn = DatabaseAccess.getConnection();
    try {
      String query = "SELECT idSubject FROM subject";
      st = conn.createStatement();
      rs = st.executeQuery(query);
      while (rs.next()) {
        Subjects mh = new Subjects();
        mh.setIdSubject(rs.getString("idSubject"));
        lst.add(mh);
      }
    } catch (SQLException ex) {
      System.out.println("Error get IDSubject : " + ex);
    } finally {
      closeConnection(conn);
      closeResult(rs);
      closeStatement(st);
    }
    return lst;
  }
  
  public boolean isTest(String id) {
    Connection conn = DatabaseAccess.getConnection();
    Statement st = null;
    ResultSet rs = null;
    try {
      String query = "SELECT idSubject FROM subject";
      st = conn.createStatement();
      rs = st.executeQuery(query);
      while (rs.next()) {
        Subjects sb = new Subjects();
        sb.setIdSubject(rs.getString("idSubject"));
        if (id.equals(sb.getIdSubject())) {
          return false;
        }
      }
    } catch (SQLException ex) {
      System.out.println("Error get ID Subject : " + ex);
    } finally {
      closeConnection(conn);
      closeResult(rs);
      closeStatement(st);
    }
    return true;
  }
}
