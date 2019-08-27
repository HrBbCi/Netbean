/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project.SinhVien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Project.ConnectDatabase.DatabaseAccess;
import Project.Check.CheckSinhVien;
import Project.Check.CheckSinhVien;
import Project.Khoa.ChuyenKhoa;
import Project.SinhVien.SinhVien;
import Project.Check.CheckSinhVien;

/**
 *
 * @author HrBbCi
 */
public class SinhVienBussiness extends CheckSinhVien<SinhVien, String> {

    public static SinhVienBussiness instance;
     public synchronized static SinhVienBussiness getInstance() {
        if (instance == null) {
            instance = new SinhVienBussiness(); 
        }
        return instance;
    }
    
    @Override
    public List<SinhVien> getAll() {
       List<SinhVien> lstSV = new ArrayList();
        Connection conn = DatabaseAccess.getConnection();
        //Viết câu lện Sql 
        String strSQL = "Select MaSV,HoTen,GioiTinh,NgaySinh, DienThoai, Email, "
                + "DiaChi,TenKhoa,sv.ChuyenKhoaID from sinhvien as sv inner join chuyenkhoa "
                + "as ck on sv.ChuyenKhoaID = ck.IDChuyenKhoa";
        Statement comm = null;
        ResultSet rs = null;
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            comm = conn.createStatement();
            //Khai báo 1 đối tượng để lưu kq từ db 
            rs = comm.executeQuery(strSQL);
            SinhVien sv;
            while (rs.next()) {
                sv = new SinhVien();
                //Gán gái trị
                sv.setMaSV(rs.getString("MaSV"));

                sv.setHoTen(rs.getString("HoTen"));

                sv.setGioiTinh(rs.getInt("GioiTinh"));

//                String ngaySinh = rs.getString("NgaySinh");
//                if(ngaySinh!=null && !ngaySinh.isEmpty()){
//                    try {
//                        sv.setNgaySinh(df.parse(ngaySinh));
//                    } catch (ParseException ex) {
//                        System.out.println(ex);
//                    }
//                }
                sv.setNgaySinh(rs.getDate("NgaySinh"));

                sv.setDienThoai(rs.getString("DienThoai"));

                sv.seteMail(rs.getString("Email"));

                sv.setDiaChi(rs.getString("DiaChi"));

                ChuyenKhoa ck = new ChuyenKhoa();
                ck.setChuyenKhoaID(rs.getInt("ChuyenKhoaID"));
                ck.setTenKhoa(rs.getString("TenKhoa"));
                sv.setChuyenKhoaID(ck);

                lstSV.add(sv);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi" + ex);
        } finally {
            closeStatement(comm);
            closeResult(rs);
        }
        return lstSV;
    }

    @Override
    public SinhVien getByID(String id) {
        //Tạo đối tượng kết nối đến db
        Connection conn = DatabaseAccess.getConnection();
        //Viết câu lệnh SQL cần lấy thông tin
        String strSQL = "Select MaSV, HoTen, DienThoai, Email, GioiTinh, NgaySinh, "
                + " DiaChi, TenKhoa, sv.ChuyenKhoaID from SinhVien AS sv "
                + " INNER JOIN chuyenkhoa as ck "
                + " ON sv.ChuyenKhoaID = ck.IDChuyenKhoa "
                + " WHERE MaSV = '" + id + "'";
        try {
        //Tạo 1 đối tượng để thực hiện công việc
            Statement comm = conn.createStatement();
        //Khai báo 1 đối tượng để lưu kết quả lấy được từ db về
            ResultSet rs = comm.executeQuery(strSQL);
        //Duyệt từng dòng để đưa ra danh sách
            SinhVien objSinhVien = null;
     //       DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            while (rs.next()) {
        //Khởi tạo
                objSinhVien = new SinhVien();
        //Gán giá trị cho các thuộc tính lấy được từ db
                objSinhVien.setMaSV(rs.getString("MaSV"));
                objSinhVien.setHoTen(rs.getString("HoTen"));
                objSinhVien.setGioiTinh(rs.getInt("GioiTinh"));
                objSinhVien.setNgaySinh(rs.getDate("NgaySinh"));
                objSinhVien.setDienThoai(rs.getString("DienThoai"));
                objSinhVien.seteMail(rs.getString("Email"));
                objSinhVien.setDiaChi(rs.getString("DiaChi"));
            // Lay thong tin chuyen khoa
                ChuyenKhoa ck = new ChuyenKhoa();
                ck.setChuyenKhoaID(rs.getInt("ChuyenKhoaID"));
                ck.setTenKhoa(rs.getString("TenKhoa"));
                objSinhVien.setChuyenKhoaID(ck);
            }
            return objSinhVien;
        } catch (SQLException ex) {
            System.err.println("Chi tiết lỗi: " + ex.getMessage());
        } finally {
            try {
        //Đóng kết nối
                conn.close();
            } catch (SQLException ex) {
                System.err.println("Chi tiết lỗi: " + ex.getMessage());
            }
        }
        return null;
    }

    @Override
    public boolean themMoi(SinhVien sv) {

        boolean isThanhCong = false;

        //Khai báo 1 đối tượng kết nối
        Connection conn = DatabaseAccess.getConnection();
        try {

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String ngaySinh = df.format(sv.getNgaySinh());

            if (ngaySinh == null) {
                ngaySinh = "";
            }
            String strInsert = String.format("Insert Into SinhVien(MaSV, HoTen, "
                    + " DienThoai, Email, DiaChi ,GioiTinh, NgaySinh,ChuyenKhoaID ) "
                    + "values('%s','%s','%s','%s','%s','%s','%s','%s')",
                    sv.getMaSV(), sv.getHoTen(), sv.getDienThoai(), sv.geteMail(),
                    sv.getDiaChi(), sv.getGioiTinh(), ngaySinh, sv.getChuyenKhoaID().getChuyenKhoaID());

            Statement comm = conn.createStatement();

            //Thực hiện công việc sau đó trả về kết quả để nhận biết xem thành công hay thất bại
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
    public boolean xoaSV(String maSV) {
        boolean isSuccess = false;
        Connection conn = DatabaseAccess.getConnection();
        String strUp = "Delete from sinhvien where MaSV =?;";
        try {
            PreparedStatement prs = conn.prepareStatement(strUp);
            prs.setString(1, maSV);
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
    public boolean suaSV(SinhVien sv) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = DatabaseAccess.getConnection();
            st = conn.createStatement();
            
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String ngaySinh = sv.getNgaySinh() != null ? 
                    df.format(sv.getNgaySinh()) : "";
            String query = "UPDATE sinhvien "
                    + " SET HoTen = '" + sv.getHoTen() + "', "
                    + "  GioiTinh = '" + sv.getGioiTinh()+ "', "
                    + "  NgaySinh = '" + ngaySinh + "', "
                    + "  DiaChi = '" + sv.getDiaChi()+ "', "
                    + "  DienThoai = '" + sv.getDienThoai()+ "', "
                    + "  Email = '" + sv.geteMail();
            if(sv.getChuyenKhoaID()!= null) {
                query += "',  ChuyenKhoaID = '" 
                        + sv.getChuyenKhoaID().getChuyenKhoaID() + "' ";
            }
            // Điều kiện udpate
            query += " WHERE MaSV = '" + sv.getMaSV() + "'";
            
            // Thực hiện truy vấn
            return st.executeUpdate(query) > 0;
        } catch (Exception ex) {
            System.out.println("Lỗi khi update: " + ex);
        } finally {
            try {
                if (conn != null) conn.close();
                if (st != null) st.close();
                if (rs != null)rs.close();
            } catch (SQLException ex) {
            }
        }

        return false;
    }

    @Override
    public List<SinhVien> findStudents(String maSV) {
        return null;
    }
    
    /**
     * 0 - MaSV
     * 1 - HoTen
     * @param varargs
     * @return 
     */
    public List<SinhVien> findStudents2(String... varargs) {
        List<SinhVien> lstSV = new ArrayList();
        Connection conn = DatabaseAccess.getConnection();
        //Viết câu lện Sql 
        String strSQL = "Select MaSV,HoTen,GioiTinh,NgaySinh, DienThoai, Email, "
                + "DiaChi,TenKhoa,sv.ChuyenKhoaID from sinhvien as sv inner join chuyenkhoa "
                + "as ck on sv.ChuyenKhoaID = ck.IDChuyenKhoa "
                + " WHERE 1 = 1 ";
        
        String maSV = varargs[0];
        if(maSV != null && !maSV.isEmpty()) {
            strSQL += " AND MaSV LIKE '%" + maSV + "%' ";
        }
        
        String hoTen = varargs[1];
        if(hoTen != null && !hoTen.isEmpty()) {
            strSQL += " AND HoTen LIKE '%" + hoTen + "%' ";
        }
        Statement comm = null;
        ResultSet rs = null;
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            comm = conn.createStatement();
            //Khai báo 1 đối tượng để lưu kq từ db 
            rs = comm.executeQuery(strSQL);
            SinhVien sv;
            while (rs.next()) {
                sv = new SinhVien();
                //Gán gái trị
                sv.setMaSV(rs.getString("MaSV"));

                sv.setHoTen(rs.getString("HoTen"));

                sv.setGioiTinh(rs.getInt("GioiTinh"));

//                String ngaySinh = rs.getString("NgaySinh");
//                if(ngaySinh!=null && !ngaySinh.isEmpty()){
//                    try {
//                        sv.setNgaySinh(df.parse(ngaySinh));
//                    } catch (ParseException ex) {
//                        System.out.println(ex);
//                    }
//                }
                sv.setNgaySinh(rs.getDate("NgaySinh"));

                sv.setDienThoai(rs.getString("DienThoai"));

                sv.seteMail(rs.getString("Email"));

                sv.setDiaChi(rs.getString("DiaChi"));

                ChuyenKhoa ck = new ChuyenKhoa();
                ck.setChuyenKhoaID(rs.getInt("ChuyenKhoaID"));
                ck.setTenKhoa(rs.getString("TenKhoa"));
                sv.setChuyenKhoaID(ck);

                lstSV.add(sv);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi" + ex);
        } finally {
            closeStatement(comm);
            closeResult(rs);
        }
        return lstSV;
    }
    
    public List<SinhVien> getSVTheoChuyenKhoa(String tenKhoa) {
        
        List<SinhVien> lstSV = new ArrayList();
        Connection conn = DatabaseAccess.getConnection();
        //Viết câu lện Sql 
        String query = "Select MaSV,HoTen,GioiTinh,NgaySinh,DiaChi,Email,"
                    + "DienThoai,ChuyenKhoaID,TenKhoa FROM j051701cb.sinhvien "
                    + "as sv inner join j051701cb.chuyenkhoa as ck on "
                    + "sv.ChuyenKhoaID=ck.IDChuyenKhoa where TenKhoa = '"+tenKhoa+"'";
        Statement comm = null;
        ResultSet rs = null;
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            comm = conn.createStatement();
            //Khai báo 1 đối tượng để lưu kq từ db 
            rs = comm.executeQuery(query);
            SinhVien sv;
            while (rs.next()) {
                sv = new SinhVien();
                //Gán gái trị
                sv.setMaSV(rs.getString("MaSV"));

                sv.setHoTen(rs.getString("HoTen"));

                sv.setGioiTinh(rs.getInt("GioiTinh"));

                sv.setNgaySinh(rs.getDate("NgaySinh"));

                sv.setDienThoai(rs.getString("DienThoai"));

                sv.seteMail(rs.getString("Email"));

                sv.setDiaChi(rs.getString("DiaChi"));

                ChuyenKhoa ck = new ChuyenKhoa();
                ck.setChuyenKhoaID(rs.getInt("ChuyenKhoaID"));
                ck.setTenKhoa(rs.getString("TenKhoa"));
                sv.setChuyenKhoaID(ck);

                lstSV.add(sv);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi" + ex);
        } finally {
            closeStatement(comm);
            closeResult(rs);
        }
        return lstSV;
    }
    public List<SinhVien> getAllMaSV() {
        List<SinhVien> lst = new ArrayList<>();
        Connection conn = DatabaseAccess.getConnection();
        try {
            String query = "SELECT MaSV FROM sinhvien";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                SinhVien sv = new SinhVien();
                sv.setMaSV(rs.getString("MaSV"));
                lst.add(sv);
            }
        } catch (Exception ex) {
            System.out.println("Lỗi khi lấy Mã SV : " + ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Lỗi khi đóng file" + ex);
            }
        }
        return lst;
    }
    
    
}

