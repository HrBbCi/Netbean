
package model;

import java.io.Serializable;

public class BanDoc implements Serializable{
    int maBd;
    String hoTen, diaChi, soDt;

    public BanDoc() {
    }

    public BanDoc(int maBd, String hoTen, String diaChi, String soDt) {
        this.maBd = maBd;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.soDt = soDt;
    }

    public int getMaBd() {
        return maBd;
    }

    public void setMaBd(int maBd) {
        this.maBd = maBd;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDt() {
        return soDt;
    }

    public void setSoDt(String soDt) {
        this.soDt = soDt;
    }

    @Override
    public String toString() {
        return "Ma: " + maBd + " - Ho Ten: " + hoTen + " - Dia chi: " + diaChi + " - SDT: " + soDt; 
    }
    
    
}
