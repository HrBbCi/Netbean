/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc.com;

/**
 *
 * @author HrBbCi
 */
public class SinhVien {
    private String maSV;
    private String hoTen;
    private String diaChi;
    private String eMail;
    private String dienThoai;
    public SinhVien(){
      
    }
    public SinhVien(String diaChi){
        this.diaChi=diaChi;
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

    public String geteMail() {
        return eMail;
    }
    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getHoTen() {
        return hoTen;
    }
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDienThoai() {
        return dienThoai;
    }
    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public SinhVien(String maSinhVien, String hoT,
          String dienThoai,String diaC, String eMl) {
        this.maSV = maSinhVien;
        this.hoTen = hoT;
        this.eMail = eMl;
        this.dienThoai= dienThoai;
        this.diaChi =diaC;
    }
    
    public Object[] toObject() {
        return new Object[]{maSV,hoTen,dienThoai,dienThoai,diaChi,eMail};
    }
}
