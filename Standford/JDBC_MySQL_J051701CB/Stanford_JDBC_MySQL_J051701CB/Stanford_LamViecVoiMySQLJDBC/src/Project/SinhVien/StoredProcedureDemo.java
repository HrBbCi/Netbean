/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project.SinhVien;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Project.ConnectDatabase.DatabaseAccess;
import Project.Khoa.ChuyenKhoa;
import Project.SinhVien.SinhVien;
import Project.Check.CheckSinhVien;

/**
 *
 * @author HrBbCi
 */
public abstract class StoredProcedureDemo extends CheckSinhVien<SinhVien, String>{
    /** 
     * Lấy toàn bộ sinh viên lưu trong database
     * @return Danh sách sinh viên
     */
    public List<SinhVien> getAllSV() {
        List<SinhVien> lst = new ArrayList<>();
        Connection conn = null;
        CallableStatement cst = null;
        ResultSet rs = null;

        try {
            conn = DatabaseAccess.getConnection();
            String query = "{CALL GetAllSV()}";
            cst = conn.prepareCall(query);
            rs = cst.executeQuery();

            SinhVien sv;
            ChuyenKhoa ck;
            while (rs.next()) {
                sv = new SinhVien();
                sv.setMaSV(getString(rs, 1));
                sv.setHoTen(getString(rs, 2));
                sv.setGioiTinh(getInt(rs, 3));
                sv.setNgaySinh(getDate(rs, 4));
                sv.setDiaChi(getString(rs, 5));
                sv.setDienThoai(getString(rs, 6));
                sv.seteMail(getString(rs, 7));
                
                ck = new ChuyenKhoa();
                ck.setChuyenKhoaID(getInt(rs, 8));
                ck.setMaKhoa(getString(rs, 9));
                ck.setTenKhoa(getString(rs, 10));
                sv.setChuyenKhoaID(ck);
                
                lst.add(sv);
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        } finally {
            closeConnection(conn);
            closeResult(rs);
            closeCallableStatement(cst);
        }

        return lst;
    }
    
    /** 
     * Lấy thông tin chi tiết sinh viên theo mã sinh viên
     * @return {@link SinhVien}
     */
    public SinhVien getSVByMaSV(String maSV) {
        SinhVien sv = null;
        Connection conn = null;
        CallableStatement cst = null;
        ResultSet rs = null;

        try {
            conn = DatabaseAccess.getConnection();
            String query = "{CALL GetSVByMaSV(?)}";
            cst = conn.prepareCall(query);
            cst.setString(1, maSV);
            rs = cst.executeQuery();

            ChuyenKhoa ck;
            while (rs.next()) {
                sv = new SinhVien();
                sv.setMaSV(getString(rs, 1));
                sv.setHoTen(getString(rs, 2));
                sv.setGioiTinh(getInt(rs, 3));
                sv.setNgaySinh(getDate(rs, 4));
                sv.setDiaChi(getString(rs, 5));
                sv.setDienThoai(getString(rs, 6));
                sv.seteMail(getString(rs, 7));
                
                ck = new ChuyenKhoa();
                ck.setChuyenKhoaID(getInt(rs, 8));
                ck.setMaKhoa(getString(rs, 9));
                ck.setTenKhoa(getString(rs, 10));
                sv.setChuyenKhoaID(ck);
                
                return sv;
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        } finally {
            closeConnection(conn);
            closeResult(rs);
            closeCallableStatement(cst);
        }

        return sv;
    }

    public boolean insertSV(SinhVien sv) {
        Connection conn = null;
        CallableStatement cst = null;
        ResultSet rs = null;

        try {
            conn = DatabaseAccess.getConnection();
            String query = "{CALL GetSVByMaSV(?)}";
            cst = conn.prepareCall(query);
            rs = cst.executeQuery();

        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        } finally {
            closeConnection(conn);
            closeResult(rs);
            closeCallableStatement(cst);
        }

        return false;
    }
}
