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
public class TruyenTranh implements Serializable{
    private int maSach;
    private  String tenSach;
    private  String nhaXuatBan;
    private  String theLoai;
    private  String tacGia;
    private  String moTa;

    public TruyenTranh() {
        
    }

    public TruyenTranh(int maSach, String tenSach, String nhaXuatBan, String theLoai, String tacGia, String moTa) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.nhaXuatBan = nhaXuatBan;
        this.theLoai = theLoai;
        this.tacGia = tacGia;
        this.moTa = moTa;
    }

    public int getMaSach() {
        return maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public String getTacGia() {
        return tacGia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    
    
    
}
