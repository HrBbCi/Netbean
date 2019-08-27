
package model;

import java.io.Serializable;

public class Sach implements Serializable{

    int ma;
    String ten, tacGia, chuyenNganh, namXB;
    int soLuong;

    public Sach(int ma, String ten, String tacGia, String chuyenNganh, String namXB, int soLuong) {
        this.ma = ma;
        this.ten = ten;
        this.tacGia = tacGia;
        this.chuyenNganh = chuyenNganh;
        this.namXB = namXB;
        this.soLuong = soLuong;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(String chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }

    public String getNamXB() {
        return namXB;
    }

    public void setNamXB(String namXB) {
        this.namXB = namXB;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Sach() {
    }

    @Override
    public String toString() {
        return "Ma: " + ma + " - Ten: " + ten + " - Tac Gia: " + tacGia + " - Chuyen nganh: " + chuyenNganh + " - Nam XB: " + namXB + " - So luong: " + soLuong;
    }
    
    

}
