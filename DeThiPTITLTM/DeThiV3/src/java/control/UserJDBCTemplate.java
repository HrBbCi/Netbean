package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.HangHoa;

/**
 *
 * @author HrBbCi
 */
public class UserJDBCTemplate {

    public static UserJDBCTemplate instance;

    public synchronized static UserJDBCTemplate getInstance() {
        if (instance == null) {
            instance = new UserJDBCTemplate();
        }
        return instance;
    }

    public boolean create(HangHoa hh) {
        Connection con = DatabaseAccess.getConnection();
        boolean isThanhCong = false;
        Statement st = null;
        try {
            String SQL = String.format("insert into hanghoa(idhanghoa, ten, gia)"
                    + " values('%s','%s','%s')", hh.getIdHangHoa(), hh.getTenHH(), hh.getGia());
            st = con.createStatement();
            isThanhCong = st.executeUpdate(SQL) > 0;
        } catch (SQLException ex) {
            System.out.println("Chi tiết lỗi: " + ex.getMessage());
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException ex) {
            }
        }
        return isThanhCong;
    }

    public boolean updateHangHoa(HangHoa hh) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = DatabaseAccess.getConnection();
            st = conn.createStatement();
            String query = "UPDATE hanghoa SET ten = '" + hh.getTenHH() + "', "
                    + " gia = '" + hh.getGia() + "' "
                    + "WHERE idhanghoa = '" + hh.getIdHangHoa() + "'";
            return st.executeUpdate(query) > 0;
        } catch (SQLException ex) {
            System.out.println("Chi tiết lỗi: " + ex.getMessage());
        } finally {
            try {
                conn.close();
                st.close();
       
            } catch (SQLException ex) {
            }

        }
        return false;
    }

    public boolean delete(String id) {
        boolean isSuccess = false;
        Connection conn = DatabaseAccess.getConnection();
        PreparedStatement prs = null;
        String SQL = "delete from hanghoa where idhanghoa = ?";
        try {
            prs = conn.prepareStatement(SQL);
            prs.setString(1, id);
            isSuccess = prs.executeUpdate() > 0;
        } catch (SQLException ex) {
        } finally {
            try {
                conn.close();
                prs.close();
            } catch (SQLException ex) {
            }

        }
        return isSuccess;
    }

    public HangHoa getHangHoaByID(String id) {
        Connection conn = DatabaseAccess.getConnection();
        String strSQL = "SELECT * FROM hanghoa where idhanghoa= '" + id + "'";
        Statement comm = null;
        ResultSet rs = null;
        try {
            comm = conn.createStatement();
            rs = comm.executeQuery(strSQL);
            HangHoa hh = null;
            while (rs.next()) {
                hh = new HangHoa();
                hh.setIdHangHoa(rs.getString("idhanghoa"));
                hh.setTenHH(rs.getString("ten"));
                hh.setGia(rs.getFloat("gia"));
            }
            return hh;
        } catch (SQLException ex) {
            System.out.println("Lỗi" + ex);
        } finally {
            try {
                conn.close();
                comm.close();
            } catch (SQLException ex) {
            }
        }
        return null;
    }

    public List<HangHoa> listHangHoa(String id) {
        List<HangHoa> listhh = new ArrayList();
        Connection conn = DatabaseAccess.getConnection();
        String strSQL = "SELECT * FROM hanghoa where idhanghoa= '" + id + "'";
        Statement comm = null;
        ResultSet rs = null;
        try {
            comm = conn.createStatement();
            rs = comm.executeQuery(strSQL);
            HangHoa hh;
            while (rs.next()) {
                hh = new HangHoa();
                hh.setIdHangHoa(rs.getString("idhanghoa"));
                hh.setTenHH(rs.getString("ten"));
                hh.setGia(rs.getFloat("gia"));
                listhh.add(hh);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi" + ex);
        } finally {
            try {
                conn.close();
                comm.close();
            } catch (SQLException ex) {
            }
        }
        return listhh;
    }

    public List<HangHoa> listHangHoa() {
        List<HangHoa> listhh = new ArrayList();
        Connection conn = DatabaseAccess.getConnection();
        String strSQL = "SELECT * FROM hanghoa";
        Statement comm = null;
        ResultSet rs = null;
        try {
            comm = conn.createStatement();
            rs = comm.executeQuery(strSQL);
            HangHoa hh;
            while (rs.next()) {
                hh = new HangHoa();
                hh.setIdHangHoa(rs.getString("idhanghoa"));
                hh.setTenHH(rs.getString("ten"));
                hh.setGia(rs.getFloat("gia"));
                listhh.add(hh);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi" + ex);
        } finally {
            try {
                conn.close();
                comm.close();
            } catch (SQLException ex) {
            }
        }
        return listhh;
    }

}
