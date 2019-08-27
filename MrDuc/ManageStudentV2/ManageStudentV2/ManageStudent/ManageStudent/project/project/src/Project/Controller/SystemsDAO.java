package Project.Controller;

import Project.Interface.Check;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import Project.DatabaseAccess;
import Project.Interface.Dao;
import Project.Model.Systems;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SystemsDAO extends Check implements Dao<Systems, String> {

  public static SystemsDAO instance;

  public synchronized static SystemsDAO getInstance() {
    if (instance == null) {
      instance = new SystemsDAO();
    }
    return instance;
  }

  public boolean isHasUser(Systems user) {
    Connection conn = null;
    Statement st = null;
    try {
      conn = DatabaseAccess.getConnection();
      st = conn.createStatement();
      String query = "SELECT * FROM system "
              + " WHERE username = '" + user.getUsername() + "' "
              + " AND password = '" + user.getPassword() + "' ";
      return st.executeQuery(query).next();
    } catch (SQLException ex) {
    } finally {
      closeConnection(conn);
      closeStatement(st);
    }

    return false;
  }

  @Override
  public List<Systems> getAll() {
    List<Systems> lstUsers = new ArrayList();
    Connection conn = DatabaseAccess.getConnection();
    String strSQL = "SELECT username, password FROM system";
    Statement comm = null;
    ResultSet rs = null;
    try {
      comm = conn.createStatement();
      rs = comm.executeQuery(strSQL);
      Systems us;
      while (rs.next()) {
        us = new Systems();
        us.setUsername(rs.getString("username"));
        us.setPassword(rs.getString("password"));
        lstUsers.add(us);
      }
    } catch (SQLException ex) {
      System.out.println("Lỗi" + ex);
    } finally {
      closeStatement(comm);
      closeResult(rs);
      closeConnection(conn);
    }
    return lstUsers;
  }

  @Override
  public Systems getByID(String username) {
    Connection conn = DatabaseAccess.getConnection();
    String strSQL = "SELECT username, password FROM system"
            + " WHERE username = '" + username + "'";
    Statement comm = null;
    ResultSet rs = null;
    try {
      comm = conn.createStatement();
      rs = comm.executeQuery(strSQL);
      Systems objUs = null;
      while (rs.next()) {
        objUs = new Systems();
        objUs.setUsername(rs.getString("username"));
        objUs.setPassword(rs.getString("password"));
      }
      return objUs;
    } catch (SQLException ex) {
      System.out.println("Chi tiết lỗi: " + ex.getMessage());
    } finally {
      closeConnection(conn);
      closeResult(rs);
      closeStatement(comm);
    }
    return null;
  }

  @Override
  public boolean newAdd(Systems users) {
    boolean isThanhCong = false;
    Connection conn = DatabaseAccess.getConnection();
    Statement comm = null;
    try {
      String strInsert = String.format("INSERT INTO system(username,password)"
              + " VALUES('%s','%s')", users.getUsername(), users.getPassword());
      comm = conn.createStatement();
      isThanhCong = comm.executeUpdate(strInsert) > 0;
    } catch (SQLException ex) {
      System.out.println("Chi tiết lỗi: " + ex.getMessage());
    } finally {
      closeConnection(conn);
      closeStatement(comm);
    }
    return isThanhCong;
  }

  @Override
  public boolean delete(String users) {
    boolean isSuccess = false;
    Connection conn = DatabaseAccess.getConnection();
    PreparedStatement prs = null;
    String strUp = "DELETE FROM system WHERE username =?;";
    try {
      prs = conn.prepareStatement(strUp);
      prs.setString(1, users);
      isSuccess = prs.executeUpdate() > 0;
    } catch (SQLException ex) {
    } finally {
      closeConnection(conn);
      closePre(prs);
    }
    return isSuccess;
  }

  @Override
  public boolean edit(Systems users) {
    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;

    try {
      conn = DatabaseAccess.getConnection();
      st = conn.createStatement();
      String query = "UPDATE system SET username = '" + users.getUsername() + "', "
              + " password = '" + users.getPassword() + "' "
              + "WHERE username = '" + users.getUsername() + "'";
      return st.executeUpdate(query) > 0;
    } catch (SQLException ex) {
      System.out.println("Chi tiết lỗi: " + ex.getMessage());
    } finally {
      closeConnection(conn);
      closeResult(rs);
      closeStatement(st);
    }
    return false;
  }

  @Override
  public List<Systems> find(String... varargs) {
    List<Systems> lstUS = new ArrayList();
    Connection conn = DatabaseAccess.getConnection();
    String strSQL = "SELECT username,password FROM system ";
    String user = varargs[0];
    if (user != null && !user.isEmpty()) {
      strSQL += " where username LIKE '%" + user + "%'";
    }
    Statement comm = null;
    ResultSet rs = null;
    try {
      comm = conn.createStatement();
      rs = comm.executeQuery(strSQL);
      Systems us;
      while (rs.next()) {
        us = new Systems();
        us.setUsername(rs.getString("username"));
        us.setPassword(rs.getString("password"));
        lstUS.add(us);
      }
    } catch (SQLException ex) {
      System.out.println("Chi tiết lỗi: " + ex.getMessage());
    } finally {
      closeStatement(comm);
      closeResult(rs);
      closeConnection(conn);
    }
    return lstUS;
  }

  public boolean check(String username) {
    Connection conn = DatabaseAccess.getConnection();
    Statement comm = null;
    ResultSet rs = null;
    String strSQL = "SELECT username FROM system";
    try {
      comm = conn.createStatement();
      rs = comm.executeQuery(strSQL);
      Systems objUs = null;
      while (rs.next()) {
        objUs = new Systems();
        objUs.setUsername(rs.getString("username"));
        if (objUs.getUsername().equalsIgnoreCase(username)) {
          return false;
        }

      }
    } catch (SQLException ex) {
      System.out.println("Chi tiết lỗi: " + ex.getMessage());
    } finally {
      closeConnection(conn);
      closeResult(rs);
      closeStatement(comm);
    }
    return true;
  }
}
