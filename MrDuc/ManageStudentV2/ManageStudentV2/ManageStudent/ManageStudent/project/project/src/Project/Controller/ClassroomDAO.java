package Project.Controller;

import Project.Model.Classroom;
import Project.Interface.Check;
import Project.DatabaseAccess;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ClassroomDAO extends Check {

  /*
  Get Name ClassRoom
  */
  public List<Classroom> getAllMaP(){
    List<Classroom> lst = new ArrayList<>();
    Connection conn = DatabaseAccess.getConnection();
    Statement st = null;
    ResultSet rs = null;
    try {
       String query = "SELECT NameClassroom FROM classroom";
       st = conn.createStatement();
       rs = st.executeQuery(query);
      while (rs.next()) {
        Classroom ph = new Classroom();
        ph.setName(rs.getString("NameClassroom"));
        lst.add(ph);
      }
    } catch (SQLException ex) {
      System.out.println("Error SQL: "+ ex);
    } finally {
      closeConnection(conn);
      closeResult(rs);
      closeStatement(st);
    }
    return lst;
  }
}
