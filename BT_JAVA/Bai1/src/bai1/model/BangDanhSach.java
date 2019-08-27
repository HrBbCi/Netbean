/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1.model;

import java.io.Serializable;

/**
 *
 * @author HrBbCi
 */
public class BangDanhSach implements Serializable{
    private MatHang mh;
    private KhachHang kh;
    private int soLuong;

    public BangDanhSach(MatHang mh, KhachHang kh, int soLuong) {
        this.mh = mh;
        this.kh = kh;
        this.soLuong = soLuong;
    }

    public BangDanhSach() {
    }

    public MatHang getMh() {
        return mh;
    }

    public void setMh(MatHang mh) {
        this.mh = mh;
    }

    public KhachHang getKh() {
        return kh;
    }

    public void setKh(KhachHang kh) {
        this.kh = kh;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
    
}
