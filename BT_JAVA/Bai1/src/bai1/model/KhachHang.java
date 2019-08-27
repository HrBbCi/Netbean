package bai1.model;

import java.io.Serializable;

public class KhachHang implements Serializable{

    private int maKH;
    private String tenKH;
    private String diaChi;
    private String soDT;
    private MatHang mh;
    private double soTien;
    public KhachHang() {
    }

    
    public KhachHang(int maKH, String tenKH, String diaChi, String soDT) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.diaChi = diaChi;
        this.soDT = soDT;
    }

    public double getSoTien() {
        return soTien;
    }

    public void setSoTien(double soTien) {
        this.soTien = soTien;
    }

    
    public MatHang getMh() {
        return mh;
    }

    public void setMh(MatHang mh) {
        this.mh = mh;
    }
    
    
    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }
    @Override
    public String toString() {
        return "[" + maKH + "-" + tenKH + "-" + diaChi + "-" + soDT + "]";
    }
    
}
