/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project.Users;

import Project.Check.CheckSinhVien;
import Project.Check.CheckUsers;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import Project.ConnectDatabase.DatabaseAccess;
import Project.Khoa.ChuyenKhoa;
import Project.SinhVien.SinhVien;
import Project.SinhVien.SinhVienBussiness;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HrBbCi
 */
public class UsersBussiness extends CheckUsers<Users, String> {

    public boolean isHasUser(Users user) {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseAccess.getConnection();
            st = conn.createStatement();
            String query = "SELECT * FROM user "
                    + " WHERE username = '" + user.getUsername() + "' "
                    + " AND password = '" + user.getPassword() + "' ";
            // SQL Injection error

            return st.executeQuery(query).next();
        } catch (Exception ex) {
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {
            }
        }

        return false;
    }

    public static UsersBussiness instance;

    public synchronized static UsersBussiness getInstance() {
        if (instance == null) {
            instance = new UsersBussiness();
        }
        return instance;
    }

    @Override
    public List<Users> getAll() {
        List<Users> lstUsers = new ArrayList();
        Connection conn = DatabaseAccess.getConnection();

        String strSQL = "Select ID,username, password FROM user";
        Statement comm = null;
        ResultSet rs = null;

        try {
            comm = conn.createStatement();
            //Khai báo 1 đối tượng để lưu kq từ db 
            rs = comm.executeQuery(strSQL);
            Users us;
            while (rs.next()) {
                us = new Users();
                //Gán gái trị
                us.setId(rs.getInt("ID"));

                us.setUsername(rs.getString("username"));

                us.setPassword(rs.getString("password"));

                lstUsers.add(us);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi" + ex);
        } finally {
            closeStatement(comm);
            closeResult(rs);
        }
        return lstUsers;
    }

    @Override
    public Users getByID(String id) {

        return null;
    }

    public Users getByUsers(String username) {
        Connection conn = DatabaseAccess.getConnection();
        //Viết câu lệnh SQL cần lấy thông tin
        String strSQL = "Select username, password from user"
                + " WHERE username = '" + username + "'";
        try {
            Statement comm = conn.createStatement();
            ResultSet rs = comm.executeQuery(strSQL);
            Users objUs = null;
            while (rs.next()) {
                objUs = new Users();
                objUs.setUsername(rs.getString("username"));
                objUs.setPassword(rs.getString("password"));
            }
            return objUs;
        } catch (SQLException ex) {
            System.err.println("Chi tiết lỗi: " + ex.getMessage());
        } finally {
            try {

                conn.close();
            } catch (SQLException ex) {
                System.err.println("Chi tiết lỗi: " + ex.getMessage());
            }
        }
        return null;
    }

    @Override
    public boolean themMoiUsers(Users users) {
        boolean isThanhCong = false;

        Connection conn = DatabaseAccess.getConnection();
        try {
            String strInsert = String.format("Insert Into User(ID,username,password)"
                    + " values('%s','%s','%s')", users.getId(), users.getUsername(), users.getPassword());
            Statement comm = conn.createStatement();
            isThanhCong = comm.executeUpdate(strInsert) > 0;

        } catch (SQLException ex) {
            Logger.getLogger(SinhVienBussiness.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(SinhVienBussiness.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return isThanhCong;
    }

    @Override
    public boolean xoaUsers(String users) {
        boolean isSuccess = false;
        Connection conn = DatabaseAccess.getConnection();
        String strUp = "Delete from user where username =?;";
        try {
            PreparedStatement prs = conn.prepareStatement(strUp);
            prs.setString(1, users);
            isSuccess = prs.executeUpdate() > 0;
        } catch (SQLException ex) {
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
            }
        }
        return isSuccess;
    }

    @Override
    public boolean suaUsers(Users users) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = DatabaseAccess.getConnection();
            st = conn.createStatement();
            String query = "UPDATE user SET username = '" + users.getUsername() + "', "
                    + " password = '" + users.getPassword() + "' "
                    + "WHERE username = '" + users.getUsername() + "'";
            return st.executeUpdate(query) > 0;
        } catch (SQLException ex) {
            System.err.println("Chi tiết lỗi: " + ex.getMessage());
        } finally {
            try {

                conn.close();
            } catch (SQLException ex) {
                System.err.println("Chi tiết lỗi: " + ex.getMessage());
            }
        }
        return false;
    }

    @Override
    public List<Users> findUsers(String users) {
        return null;
    }

    public List<Users> findUsers2(String... varargs) {
        List<Users> lstUS = new ArrayList();
        Connection conn = DatabaseAccess.getConnection();

        String strSQL = "SELECT ID,username,password FROM user ";

        String user = varargs[0];
        if (user != null && !user.isEmpty()) {
            strSQL += " where username LIKE '%" + user + "%'";
        }

        Statement comm = null;
        ResultSet rs = null;
        try {
            comm = conn.createStatement();
            rs = comm.executeQuery(strSQL);
            Users us;
            while (rs.next()) {
                us = new Users();
                //Gán gái trị
                us.setId(rs.getInt("ID"));

                us.setUsername(rs.getString("username"));

                us.setPassword(rs.getString("password"));

                lstUS.add(us);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi" + ex);
        } finally {
            closeStatement(comm);
            closeResult(rs);
        }
        return lstUS;
    }

    public List<Users> findUsers3(String... varargs) {
        List<Users> lstUS = new ArrayList();
        Connection conn = DatabaseAccess.getConnection();
        String username = varargs[0];
        String strSQL = "Select us.ID,MaSV,HoTen,GioiTinh,NgaySinh, DienThoai, Email,"
                + "DiaChi,username from sinhvien as sv inner join user as us on "
                + "sv.ID = us.ID where sv.HoTen LIKE '%" + username + "%' ";

        Statement comm = null;
        ResultSet rs = null;
        try {
            comm = conn.createStatement();
            rs = comm.executeQuery(strSQL);
            Users us;
            while (rs.next()) {
                us = new Users();
                //Gán gái trị
                us.setId(rs.getInt("ID"));

                SinhVien sv = new SinhVien();
               
                sv.setMaSV(rs.getString("MaSV"));

                sv.setHoTen(rs.getString("HoTen"));

                sv.setGioiTinh(rs.getInt("GioiTinh"));

                sv.setNgaySinh(rs.getDate("NgaySinh"));

                sv.setDienThoai(rs.getString("DienThoai"));

                sv.seteMail(rs.getString("Email"));

                sv.setDiaChi(rs.getString("DiaChi"));
                
                us.setSinhVienID(sv);
                
                us.setUsername(rs.getString("username"));
                lstUS.add(us);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi" + ex);
        } finally {
            closeStatement(comm);
            closeResult(rs);
        }
        return lstUS;
    }

    public boolean kiemTra(String username) {
        Connection conn = DatabaseAccess.getConnection();
        String strSQL = "Select username from user";
        try {
            Statement comm = conn.createStatement();
            ResultSet rs = comm.executeQuery(strSQL);
            Users objUs = null;
            while (rs.next()) {
                objUs = new Users();
                objUs.setUsername(rs.getString("username"));
                if (objUs.getUsername().equalsIgnoreCase(username)) {
                    return false;
                }

            }
        } catch (SQLException ex) {
            System.err.println("Chi tiết lỗi: " + ex.getMessage());
        } finally {
            try {

                conn.close();
            } catch (SQLException ex) {
                System.err.println("Chi tiết lỗi: " + ex.getMessage());
            }
        }
        return true;
    }
}
