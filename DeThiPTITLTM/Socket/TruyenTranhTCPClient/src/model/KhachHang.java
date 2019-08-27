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
public class KhachHang implements  Serializable{
    private int maKhachHang;
    private String tenKhachHang;
    private String soDienThoai;
    private String diaChi;
    private String email;
    private String moTa;

    public KhachHang() {
    }

    public KhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }
    
    public KhachHang(int maKhachHang, String tenKhachHang, String soDienThoai, String diaChi, String email, String moTa) {
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.email = email;
        this.moTa = moTa;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getEmail() {
        return email;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    
}
