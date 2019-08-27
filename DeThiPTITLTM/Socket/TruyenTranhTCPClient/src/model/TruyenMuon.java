/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Hung
 */
public class TruyenMuon implements Serializable{
    private int maTruyenMuon;
    private int maSach;
    private int maKhachHang;
    private float giaThue;
    private String ngayMuon;
    private String ngayTra;

    public TruyenMuon() {
    }

    public TruyenMuon(int maTruyenMuon, int maSach, int maKhachHang, float giaThue, String ngayMuon, String ngayTra) {
        this.maTruyenMuon = maTruyenMuon;
        this.maSach = maSach;
        this.maKhachHang = maKhachHang;
        this.giaThue = giaThue;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
    }

    public int getMaTruyenMuon() {
        return maTruyenMuon;
    }

    public int getMaSach() {
        return maSach;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public float getGiaThue() {
        return giaThue;
    }

    public String getNgayMuon() {
        return ngayMuon;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public void setMaTruyenMuon(int maTruyenMuon) {
        this.maTruyenMuon = maTruyenMuon;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public void setGiaThue(float giaThue) {
        this.giaThue = giaThue;
    }

    public void setNgayMuon(String ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
    }
    
}
