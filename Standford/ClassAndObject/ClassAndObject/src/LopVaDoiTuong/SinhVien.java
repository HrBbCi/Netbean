/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LopVaDoiTuong;

/**
 *
 * @author neo
 */
public class SinhVien {
    private String maSV;
    private String tenSV;
    private String soDT;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    private String diaChi;

    public SinhVien() {
        this.diaChi = "Ha Noi";
    }

    public SinhVien(String diaChi) {
        this.diaChi = diaChi;
    }

    public SinhVien(String maSV, String tenSV, String soDT, String email,String diaChi) {
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.soDT = soDT;
        this.diaChi = diaChi;
        this.email = email;
    }

    
    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    
    
    
}
