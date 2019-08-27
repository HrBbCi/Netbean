/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stanford_lamviecvoimysqljdbc_j051701cb.model;

import java.util.Date;
import stanford_lamviecvoimysqljdbc_j051701cb.model.ChuyenKhoa;

/**
 *
 * @author HrBbCi
 */
public class SinhVien {
    private String maSV;
    private String hoTen;
    private int gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private String dienThoai;
    private String eMail;
    private ChuyenKhoa ChuyenKhoaID;

    public ChuyenKhoa getChuyenKhoaID() {
        return ChuyenKhoaID;
    }

    public void setChuyenKhoaID(ChuyenKhoa ChuyenKhoaID) {
        this.ChuyenKhoaID = ChuyenKhoaID;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
    
    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

}
