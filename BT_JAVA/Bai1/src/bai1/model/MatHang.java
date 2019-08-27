package bai1.model;

import java.io.Serializable;

public class MatHang implements Serializable{

    private int maH;
    private String tenH;
    private String nhomH;
    private double giaBan;
    private KhachHang kh;
    
    
    public MatHang() {

    }

    public MatHang(int maH, String tenH, String nhomH, double giaBan) {
        this.maH = maH;
        this.tenH = tenH;
        this.nhomH = nhomH;
        this.giaBan = giaBan;
    }

    public KhachHang getKh() {
        return kh;
    }

    public void setKh(KhachHang kh) {
        this.kh = kh;
    }

    
    public int getMaH() {
        return maH;
    }

    public void setMaH(int maH) {
        this.maH = maH;
    }

    public String getTenH() {
        return tenH;
    }

    public void setTenH(String tenH) {
        this.tenH = tenH;
    }

    public String getNhomH() {
        return nhomH;
    }

    public void setNhomH(String nhomH) {
        this.nhomH = nhomH;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    @Override
    public String toString() {
        return "[" + maH + "-" + tenH + "-" + nhomH + "-" + giaBan + "]";
    }

}
