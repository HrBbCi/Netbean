/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file3.com;

/**
 *
 * @author HrBbCi
 */
public class classSV {

    private String maSV;
    private String hoTen;
    private String diaChi;
    private String gioiTinh;
    private String ngaySinh;
    private String diem1, diem2, diem3;

    public classSV(String maSV, String hoTen, String diaChi, String gioiTinh, String ngaySinh, String diem1, String diem2, String diem3) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
       
        this.ngaySinh = ngaySinh;
        this.diem1 = diem1;
        this.diem2 = diem2;
        this.diem3 = diem3;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

  
    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiem1() {
        return diem1;
    }

    public void setDiem1(String diem1) {
        this.diem1 = diem1;
    }

    public String getDiem2() {
        return diem2;
    }

    public void setDiem2(String diem2) {
        this.diem2 = diem2;
    }

    public String getDiem3() {
        return diem3;
    }

    public void setDiem3(String diem3) {
        this.diem3 = diem3;
    }
    public classSV() {

    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getMaSV() {
        return maSV;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

}
