/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stanford_lamviecvoimysqljdbc_j051701cb.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import stanford_lamviecvoimysqljdbc_j051701cb.DatabaseAccess;
import stanford_lamviecvoimysqljdbc_j051701cb.dao.base.BaseBussiness;
import stanford_lamviecvoimysqljdbc_j051701cb.model.ChuyenKhoa;
import stanford_lamviecvoimysqljdbc_j051701cb.model.SinhVien;



/**
 *
 * @author HrBbCi
 */
public class SinhVienBussiness extends BaseBussiness<SinhVien, String> {

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
        SinhVien sv = null;
        Connection conn = DatabaseAccess.getConnection();
        try {
            String strSQL =" Select MaSV,HoTen,GioiTinh,NgaySinh,DiaChi,Email,"
                    + "DienThoai,ChuyenKhoaID,TenKhoa FROM j051701cb.sinhvien "
                    + "as sv inner join j051701cb.chuyenkhoa as ck on "
                    + "sv.ChuyenKhoaID=ck.IDChuyenKhoa where MaSV ='" + id + "'";
            Statement comm = conn.createStatement();
            ResultSet rs = comm.executeQuery(strSQL);
            while (rs.next()) {
                sv = new SinhVien();
                sv.setMaSV(rs.getString("MaSV"));
                sv.setHoTen(rs.getString("HoTen"));
                sv.setGioiTinh(rs.getInt("GioiTinh"));
                sv.setNgaySinh(rs.getDate("NgaySinh"));
                sv.setDiaChi(rs.getString("DiaChi"));
                sv.seteMail(rs.getString("Email"));
                sv.setDienThoai(rs.getString("DienThoai"));
                ChuyenKhoa ck = new ChuyenKhoa();
                ck.setChuyenKhoaID(rs.getInt("ChuyenKhoaID"));
                ck.setTenKhoa(rs.getString("TenKhoa"));
                sv.setChuyenKhoaID(ck);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi getSV " + ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Lỗi Đóng File " + ex);
            }
        }
        return sv;
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
        boolean isSuccess = false;
        Connection conn = DatabaseAccess.getConnection();
        String strUp = "Update sinhvien Set HoTen=?, GioiTinh=?, NgaySinh=?, "
                + "DiaChi=? ,Email=?, DienThoai=? where MaSV = ?;";
        try {
            PreparedStatement prs = conn.prepareStatement(strUp);
            prs.setString(1, sv.getHoTen());
            prs.setInt(2, sv.getGioiTinh());
            prs.setDate(3, new java.sql.Date(sv.getNgaySinh().getTime()));
            prs.setString(4, sv.getDiaChi());
            prs.setString(5, sv.geteMail());
            prs.setString(6, sv.getDienThoai());
            prs.setString(7, sv.getMaSV());
            isSuccess = prs.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println("Lỗi sửa Sinh Viên " + ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
            }
        }
        return isSuccess;
    }

}
