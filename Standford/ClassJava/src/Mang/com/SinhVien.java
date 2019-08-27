/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mang.com;

public class SinhVien {

    private String maSV, hoTen, diaChi, eMail, soDT;
    public SinhVien(){
        
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

    public String getSoDT() {
        return soDT;
    }
    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public SinhVien(String maSinhVien, String hoT, String soDt,
            String diaC, String eMl ) {
        this.maSV = maSinhVien;
        this.hoTen = hoT;
        this.eMail = eMl;
        this.soDT= soDt;
        this.diaChi =diaC;
    }
    public void display() {
        try {
            System.out.printf("\n%-15s %-20s %-20s %-20s %-20s ",maSV,  hoTen, soDT,
             diaChi,  eMail);
        } catch (NullPointerException e) {
            System.out.printf("Data null!");
        }
    }

}
