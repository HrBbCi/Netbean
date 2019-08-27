/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project.DiemThi;

import Project.ConnectDatabase.DatabaseAccess;
import Project.MonHoc.MonHoc;
import Project.PhongHoc.PhongHoc;
import Project.SinhVien.SinhVien;
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

/**
 *
 * @author HrBbCi
 */
public class BangDiemBussiness implements BangDiemDao {

    public static BangDiemBussiness instance;

    public synchronized static BangDiemBussiness getInstance() {
        if (instance == null) {
            instance = new BangDiemBussiness();
        }
        return instance;
    }

    @Override
    public List<DiemThi> getAll() {
        List<DiemThi> lstDT = new ArrayList();
        Connection conn = DatabaseAccess.getConnection();
        //Viết câu lện Sql 
        String strSQL = "Select MaSV,MaMH,HoTen,DiemThi,TenMonHoc,TenPhong,NgayThi from "
                + " bangdiemm inner join monhoc on bangdiemm.MonHocId=monhoc.IDMonHoc "
                + " inner join phonghoc on bangdiemm.PhongHocId = phonghoc.IDPhongHoc "
                + " inner join sinhvien on bangdiemm.SinhVienId=sinhvien.ID ";
        Statement comm = null;
        ResultSet rs = null;
        try {
            comm = conn.createStatement();
            rs = comm.executeQuery(strSQL);
            SinhVien sv;
            DiemThi dt;
            MonHoc mh;
            PhongHoc ph;
            while (rs.next()) {
                sv = new SinhVien();
                dt = new DiemThi();
                mh = new MonHoc();
                ph = new PhongHoc();

                sv.setMaSV(rs.getString("MaSV"));

                sv.setHoTen(rs.getString("HoTen"));

                dt.setSinhVienID(sv);

                mh.setMaMH(rs.getString("MaMH"));

                dt.setDiemThi(rs.getFloat("DiemThi"));

                mh.setTenMonHoc(rs.getString("TenMonHoc"));

                dt.setMonHocID(mh);

                ph.setTenPhong(rs.getString("TenPhong"));

                dt.setPhongHocID(ph);

                dt.setNgayThi(rs.getDate("NgayThi"));

                lstDT.add(dt);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi" + ex);
        } finally {
            if (comm != null) {
                try {
                    comm.close();
                } catch (SQLException ex) {
                    System.out.println("Lỗi khi đóng statement: " + ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.out.println("Lỗi khi đóng ResultSet: " + ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("closeConnection method error: " + ex);
                }
            }
        }
        return lstDT;
    }

    @Override
    public DiemThi getByIDSinhVien(String masv, String mamh) {
        //Tạo đối tượng kết nối đến db
        Connection conn = DatabaseAccess.getConnection();
        //Viết câu lệnh SQL cần lấy thông tin
        String strSQL = "Select MaSV,HoTen,DiemThi,TenMonHoc,TenPhong,NgayThi,MaMH,MaPhong from "
                + " bangdiemm inner join monhoc on bangdiemm.MonHocId=monhoc.IDMonHoc "
                + " inner join phonghoc on bangdiemm.PhongHocId = phonghoc.IDPhongHoc "
                + " inner join sinhvien on bangdiemm.SinhVienId=sinhvien.ID where MaSV ='" + masv + "' "
                + " and MaMH='" + mamh + "' ";
        try {
            Statement comm = conn.createStatement();
            ResultSet rs = comm.executeQuery(strSQL);
            SinhVien sv;
            DiemThi dt = null;
            MonHoc mh;
            PhongHoc ph;
            while (rs.next()) {
                sv = new SinhVien();
                dt = new DiemThi();
                mh = new MonHoc();
                ph = new PhongHoc();

                sv.setMaSV(rs.getString("MaSV"));

                sv.setHoTen(rs.getString("HoTen"));

                dt.setSinhVienID(sv);

                dt.setDiemThi(rs.getFloat("DiemThi"));

                mh.setTenMonHoc(rs.getString("TenMonHoc"));

                mh.setMaMH(rs.getString("MaMH"));

                dt.setMonHocID(mh);

                ph.setMaPhong(rs.getString("MaPhong"));
                ph.setTenPhong(rs.getString("TenPhong"));

                dt.setPhongHocID(ph);

                dt.setNgayThi(rs.getDate("NgayThi"));

            }
            return dt;
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
    public boolean addNew(DiemThi bd) {
        boolean isThanhCong = false;
        Connection conn = DatabaseAccess.getConnection();
        try {
            DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
            String ngayThi = df.format(bd.getNgayThi());

            if (ngayThi == null) {
                ngayThi = "";
            }

            String strInsert = String.format("Insert into bangdiemm(SinhVienId,MonHocId,NgayThi,DiemThi,PhongHocId) "
                    + "values('%s','%s','%s','%s','%s')", bd.getSinhVienID().getIdsinhvien(),
                    bd.getMonHocID().getMonHocID(), ngayThi, bd.getDiemThi(),bd.getPhongHocID().getPhongHocID());
           
            Statement comm = conn.createStatement();
            isThanhCong = comm.executeUpdate(strInsert) > 0;

        } catch (SQLException ex) {
            Logger.getLogger(BangDiemBussiness.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(BangDiemBussiness.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return isThanhCong;
    }

    @Override
    public boolean upDate(DiemThi bd) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = DatabaseAccess.getConnection();
            st = conn.createStatement();

            DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
            String ngayThi = bd.getNgayThi() != null
                    ? df.format(bd.getNgayThi()) : "";

            String query = "Update bangdiemm,sinhvien,monhoc,phonghoc "
                    + " set DiemThi='" + bd.getDiemThi() + "',"
                    + "NgayThi='" + ngayThi + "', "
                    +"PhongHocId ='"+ bd.getPhongHocID().getPhongHocID()+"' "
                    + "where bangdiemm.MonHocId=monhoc.IDMonHoc and "
                    + " bangdiemm.PhongHocId=phonghoc.IDPhongHoc and MaSV='" 
                    + bd.getSinhVienID().getMaSV() + "' "
                    + "and MaMH='" + bd.getMonHocID().getMaMH() + "';";

            return st.executeUpdate(query) > 0;
        } catch (Exception ex) {
            System.out.println("Lỗi khi update: " + ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (st != null) {
                    st.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
            }
        }

        return false;
    }

    @Override
    public boolean CheckID(int  masv, int maMH) {
        Connection conn = DatabaseAccess.getConnection();
        String strSQL = "Select SinhVienId,MonHocId from bangdiemm";
        try {
            Statement comm = conn.createStatement();
            ResultSet rs = comm.executeQuery(strSQL);
            DiemThi objUs = null;
            while (rs.next()) {
                objUs = new DiemThi();
                objUs.setSinhvienId(rs.getInt("SinhVienId"));
                objUs.setMonhocId(rs.getInt("MonHocId"));
                if (objUs.getSinhvienId()==masv && objUs.getMonhocId()== maMH) {
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

    @Override
    public List<DiemThi> findMaSV(String masv) {
        List<DiemThi> lstSV = new ArrayList();
        Connection conn = DatabaseAccess.getConnection();
        //Viết câu lện Sql 
        String strSQL = "Select MaSV ,HoTen,DiemThi,TenMonHoc,TenPhong,NgayThi from "
                + " bangdiemm inner join monhoc on bangdiemm.MonHocId=monhoc.IDMonHoc "
                + " inner join phonghoc on bangdiemm.PhongHocId = phonghoc.IDPhongHoc "
                + " inner join sinhvien on bangdiemm.SinhVienId=sinhvien.ID where MaSV LIKE '%" + masv + "%' ";
        Statement comm = null;
        ResultSet rs = null;
        try {
            comm = conn.createStatement();
            rs = comm.executeQuery(strSQL);
            SinhVien sv;
            DiemThi dt = null;
            MonHoc mh;
            PhongHoc ph;
            while (rs.next()) {
                sv = new SinhVien();
                dt = new DiemThi();
                mh = new MonHoc();
                ph = new PhongHoc();

                sv.setMaSV(rs.getString("MaSV"));

                sv.setHoTen(rs.getString("HoTen"));

                dt.setSinhVienID(sv);

                dt.setDiemThi(rs.getFloat("DiemThi"));

                mh.setTenMonHoc(rs.getString("TenMonHoc"));

                dt.setMonHocID(mh);

                ph.setTenPhong(rs.getString("TenPhong"));

                dt.setPhongHocID(ph);

                dt.setNgayThi(rs.getDate("NgayThi"));

                lstSV.add(dt);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi" + ex);
        } finally {
            if (comm != null) {
                try {
                    comm.close();
                } catch (SQLException ex) {
                    System.out.println("Lỗi khi đóng statement: " + ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.out.println("Lỗi khi đóng ResultSet: " + ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("closeConnection method error: " + ex);
                }
            }
        }
        return lstSV;
    }

    @Override
    public List<DiemThi> findMaKhoa(String maKhoa) {
        List<DiemThi> lstSV = new ArrayList();
        Connection conn = DatabaseAccess.getConnection();
        //Viết câu lện Sql 
        String strSQL = "Select MaSV ,HoTen,DiemThi,TenMonHoc,TenPhong,NgayThi from "
                + " bangdiemm inner join monhoc on bangdiemm.MonHocId=monhoc.IDMonHoc "
                + " inner join phonghoc on bangdiemm.PhongHocId = phonghoc.IDPhongHoc "
                + " inner join sinhvien on bangdiemm.SinhVienId=sinhvien.ID "
                + "  inner join chuyenkhoa on sinhvien.ChuyenKhoaID=chuyenkhoa.IDChuyenKhoa "
                + "where MaKhoa LIKE '%" + maKhoa + "%' ";
        Statement comm = null;
        ResultSet rs = null;
        try {
            comm = conn.createStatement();
            rs = comm.executeQuery(strSQL);
            SinhVien sv;
            DiemThi dt = null;
            MonHoc mh;
            PhongHoc ph;
            while (rs.next()) {
                sv = new SinhVien();
                dt = new DiemThi();
                mh = new MonHoc();
                ph = new PhongHoc();

                sv.setMaSV(rs.getString("MaSV"));

                sv.setHoTen(rs.getString("HoTen"));

                dt.setSinhVienID(sv);

                dt.setDiemThi(rs.getFloat("DiemThi"));

                mh.setTenMonHoc(rs.getString("TenMonHoc"));

                dt.setMonHocID(mh);

                ph.setTenPhong(rs.getString("TenPhong"));

                dt.setPhongHocID(ph);

                dt.setNgayThi(rs.getDate("NgayThi"));

                lstSV.add(dt);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi" + ex);
        } finally {
            if (comm != null) {
                try {
                    comm.close();
                } catch (SQLException ex) {
                    System.out.println("Lỗi khi đóng statement: " + ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.out.println("Lỗi khi đóng ResultSet: " + ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("closeConnection method error: " + ex);
                }
            }
        }
        return lstSV;
    }

    @Override
    public boolean xoaDiem(String maSV, String maMH) {
        boolean isSuccess = false;
        Connection conn = DatabaseAccess.getConnection();
        String strSQL = "Delete bangdiemm from sinhvien,monhoc,bangdiemm "
                + " where sinhvien.ID=bangdiemm.SinhVienId and monhoc.IDMonHoc=bangdiemm.MonHocId "
                + " and MaSV =? and MaMH=?";

        try {
            System.out.println(maSV);
            PreparedStatement prs = conn.prepareStatement(strSQL);
            prs.setString(1, maSV);
            prs.setString(2, maMH);
            isSuccess = prs.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println("Lỗi xóa: " + ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
            }
        }
        return isSuccess;
    }
     public boolean CheckIDUpdate(int masv) {
        int Ok=0;
        List<DiemThi> lstSV = new ArrayList();
        Connection conn = DatabaseAccess.getConnection();
        String strSQL = "Select SinhVienId from bangdiemm";
        try {
            Statement comm = conn.createStatement();
            ResultSet rs = comm.executeQuery(strSQL);
            DiemThi objUs = null;
            while (rs.next()) {
                objUs = new DiemThi();
                objUs.setSinhvienId(rs.getInt("SinhVienId"));
                lstSV.add(objUs);
                if (objUs.getSinhvienId()!=masv) {
                    Ok++;
                }
                
            }
            if(Ok == lstSV.size()){
                return false;
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
