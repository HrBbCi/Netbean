package Project.Controller;

import Project.Model.Score;
import Project.Interface.Check;
import Project.DatabaseAccess;
import Project.Model.Subjects;
import Project.Model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ScoreDAO extends Check {

    public static ScoreDAO instance;

    public synchronized static ScoreDAO getInstance() {
        if (instance == null) {
            instance = new ScoreDAO();
        }
        return instance;
    }

    public List<Score> getAll() {
        List<Score> lst = new ArrayList<>();
        Connection conn = DatabaseAccess.getConnection();
        String strSQL = "SELECT sd.idStudent,st.Name, sd.idSubject,sb.Credit ,Term, Mark, NameClassroom "
                + " FROM study AS sd INNER JOIN student AS st "
                + " INNER JOIN subject AS sb "
                + " ON st.idStudent = sd.idStudent AND sd.idSubject = sb.idSubject;";
        Statement comm = null;
        ResultSet rs = null;
        try {
            comm = conn.createStatement();
            rs = comm.executeQuery(strSQL);
            Student sv;
            Score sc;
            Subjects sb;
            while (rs.next()) {
                sc = new Score();
                sc.setIdStudent(rs.getString("idStudent"));

                Student st = new Student();
                st.setName(rs.getString("Name"));
                sc.setStudent(st);

                sc.setIdSubject(rs.getString("idSubject"));

                sb = new Subjects();
                sb.setCredit(rs.getInt("Credit"));
                sc.setSubjects(sb);

                sc.setTern(rs.getString("Term"));
                sc.setScoree(rs.getFloat("Mark"));
                sc.setNameClassroom(rs.getString("NameClassroom"));

                lst.add(sc);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi" + ex);
        } finally {
            closeStatement(comm);
            closeResult(rs);
            closeConnection(conn);
        }
        return lst;
    }

    public Score getByID(String idStudent, String idSubject) {
        Connection conn = DatabaseAccess.getConnection();
        String strSQL = "SELECT sd.idStudent,st.Name, sd.idSubject,sb.Credit ,Term, Mark, NameClassroom "
                + " FROM study as sd inner join student as st "
                + " INNER JOIN subject AS sb "
                + " ON st.idStudent = sd.idStudent AND sd.idSubject = sb.idSubject "
                + " WHERE sd.idStudent =  '" + idStudent + "'"
                + " AND sd.idSubject = '" + idSubject + "'";
        Statement comm = null;
        ResultSet rs = null;
        try {
            comm = conn.createStatement();
            rs = comm.executeQuery(strSQL);
            Student sv;
            Score sc = null;
            Subjects sb;
            while (rs.next()) {
                sc = new Score();
                sc.setIdStudent(rs.getString("idStudent"));

                sv = new Student();
                sv.setName(rs.getString("Name"));
                sc.setStudent(sv);

                sc.setIdSubject(rs.getString("idSubject"));
                sb = new Subjects();
                sb.setCredit(rs.getInt("Credit"));
                sc.setSubjects(sb);
                sc.setTern(rs.getString("Term"));
                sc.setScoree(rs.getFloat("Mark"));
                sc.setNameClassroom(rs.getString("NameClassroom"));
            }
            return sc;
        } catch (SQLException ex) {
            System.out.println("Eror: " + ex);
        } finally {
            closeStatement(comm);
            closeResult(rs);
            closeConnection(conn);
        }
        return null;
    }

    public boolean newAdd(Score sc) {
        boolean isThanhCong = false;
        Connection conn = DatabaseAccess.getConnection();
        Statement st = null;
        ResultSet rs = null;
        try {
            String strInsert = String.format("INSERT INTO study(idStudent,idSubject,NameClassroom, Term, Mark) "
                    + "VALUES('%s','%s','%s','%s','%s')", sc.getStudent().getIdStudent(),
                    sc.getSubjects().getIdSubject(), sc.getClassroom().getName(),
                    sc.getTern(), sc.getScoree());
            System.out.println(sc.getSubjects().getIdSubject());
            st = conn.createStatement();
            isThanhCong = st.executeUpdate(strInsert) > 0;

        } catch (SQLException ex) {
            System.out.println("Error add Score : ");
        } finally {
            closeConnection(conn);
            closeStatement(st);
            closeResult(rs);
        }
        return isThanhCong;
    }

    public boolean delete(String idStudent, String idSubject) {
        boolean isSuccess = false;
        Connection conn = DatabaseAccess.getConnection();
        PreparedStatement prs = null;
        String strUp = "DELETE FROM study WHERE "
                + " idStudent = ? AND idSubject = ? ;";
        try {
            prs = conn.prepareStatement(strUp);
            prs.setString(1, idStudent);
            prs.setString(2, idSubject);
            isSuccess = prs.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println("Error Delete Score" + ex.getMessage());
        } finally {
            closeConnection(conn);
            closePre(prs);
        }
        return isSuccess;
    }

    public boolean edit(Score sc) {
        Connection conn = null;
        Statement st = null;
        boolean isTC = false;
        try {
            conn = DatabaseAccess.getConnection();
            st = conn.createStatement();
            String query = "UPDATE study "
                    + " SET NameClassroom = '" + sc.getClassroom().getName() + "', "
                    + " Term = '" + sc.getTern() + "', "
                    + " Mark ='" + sc.getScoree() + "' ";
            query += " WHERE idStudent = '" + sc.getStudent().getIdStudent() + "' and "
                    + "idSubject = '" + sc.getSubjects().getIdSubject() + "';";
            isTC = st.executeUpdate(query) > 0;
        } catch (SQLException ex) {
            System.out.println("Error Update Score: " + ex);
        } finally {
            closeConnection(conn);
            closeStatement(st);
        }
        return isTC;
    }

    public List<Score> find(String... varargs) {
        List<Score> lstSC = new ArrayList();
        Connection conn = DatabaseAccess.getConnection();
        String strSQL = "SELECT sd.idStudent,st.Name, sd.idSubject,sb.Credit ,Term, Mark, NameClassroom "
                + " FROM study AS sd INNER JOIN student AS st "
                + " INNER JOIN subject AS sb "
                + " ON st.idStudent = sd.idStudent AND sd.idSubject = sb.idSubject WHERE 1 = 1 ";
        String idStudent = varargs[0];
        if (idStudent != null && !idStudent.isEmpty()) {
            strSQL += " AND sd.idStudent LIKE '%" + idStudent + "%' ";
        }
        Statement comm = null;
        ResultSet rs = null;
        try {
            comm = conn.createStatement();
            rs = comm.executeQuery(strSQL);
            Subjects sb;
            Score sc;
            Student sv;
            while (rs.next()) {
                sc = new Score();
                sc.setIdStudent(rs.getString("idStudent"));

                sv = new Student();
                sv.setName(rs.getString("Name"));
                sc.setStudent(sv);

                sc.setIdSubject(rs.getString("idSubject"));
                sb = new Subjects();
                sb.setCredit(rs.getInt("Credit"));
                sc.setSubjects(sb);
                sc.setTern(rs.getString("Term"));
                sc.setScoree(rs.getFloat("Mark"));
                sc.setNameClassroom(rs.getString("NameClassroom"));
                lstSC.add(sc);
            }
        } catch (SQLException ex) {
            System.out.println("Error SQL : " + ex);
        } finally {
            closeStatement(comm);
            closeResult(rs);
            closeConnection(conn);
        }
        return lstSC;
    }

    public boolean CheckID(String idStudent, String idSubject) {
        Connection conn = DatabaseAccess.getConnection();
        String strSQL = "SELECT idStudent,idSubject FROM study";
        Statement comm = null;
        ResultSet rs = null;
        try {
            comm = conn.createStatement();
            rs = comm.executeQuery(strSQL);
            Score sc;
            while (rs.next()) {
                sc = new Score();

                Student st = new Student();
                st.setIdStudent(rs.getString("idStudent"));
                sc.setStudent(st);

                Subjects sb = new Subjects();
                sb.setIdSubject(rs.getString("idSubject"));
                sc.setSubjects(sb);

                if (sc.getStudent().getIdStudent().equals(idStudent)
                        && sc.getSubjects().getIdSubject().equals(idSubject)) {
                    return false;
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error : " + ex.getMessage());
        } finally {
            closeConnection(conn);
            closeResult(rs);
            closeStatement(comm);
        }
        return true;
    }

    public Score getAmountScorePass(String idStudent) {
        Connection conn = DatabaseAccess.getConnection();
        String strSQL = "SELECT tu.pass, mau.total FROM "
                + "(SELECT COUNT(idStudent) AS total FROM study where idStudent ='" + idStudent + "' "
                + "GROUP BY idStudent ) AS mau,"
                + "(SELECT count(idStudent) AS pass FROM study WHERE idStudent ='" + idStudent + "' "
                + "AND Mark >= 5 GROUP BY idStudent ) AS tu;";
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(strSQL);
            Score sc = null;
            while (rs.next()) {
                sc = new Score();
                sc.setPass(rs.getInt("tu.pass"));
                sc.setTotal(rs.getInt("mau.total"));
            }
            return sc;
        } catch (SQLException ex) {
            System.out.println("Eror: " + ex);
        } finally {
            closeStatement(st);
            closeResult(rs);
            closeConnection(conn);
        }
        return null;
    }

    public List<Score> find1(String... varargs) {
        List<Score> lstSC = new ArrayList();
        Connection conn = DatabaseAccess.getConnection();
        String strSQL = "SELECT sd.idStudent,st.Name, sd.idSubject,sb.Credit ,Term, Mark, NameClassroom "
                + " FROM study AS sd INNER JOIN student AS st "
                + " INNER JOIN subject AS sb "
                + " ON st.idStudent = sd.idStudent AND sd.idSubject = sb.idSubject WHERE 1 = 1 ";
        String idSubject = varargs[0];
        if (idSubject != null && !idSubject.isEmpty()) {
            strSQL += " AND sd.idSubject LIKE '%" + idSubject + "%' ";
        }
        Statement comm = null;
        ResultSet rs = null;
        try {
            comm = conn.createStatement();
            rs = comm.executeQuery(strSQL);
            Subjects sb;
            Score sc;
            Student sv;
            while (rs.next()) {
                sc = new Score();
                sc.setIdStudent(rs.getString("idStudent"));

                sv = new Student();
                sv.setName(rs.getString("Name"));
                sc.setStudent(sv);

                sc.setIdSubject(rs.getString("idSubject"));
                sb = new Subjects();
                sb.setCredit(rs.getInt("Credit"));
                sc.setSubjects(sb);
                sc.setTern(rs.getString("Term"));
                sc.setScoree(rs.getFloat("Mark"));
                sc.setNameClassroom(rs.getString("NameClassroom"));
                lstSC.add(sc);
            }
        } catch (SQLException ex) {
            System.out.println("Error SQL : " + ex);
        } finally {
            closeStatement(comm);
            closeResult(rs);
            closeConnection(conn);
        }
        return lstSC;
    }
}
