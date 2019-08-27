/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Hung
 */
public class HangNhap implements Serializable{
    private int id;
    private HangHoa hangHoa;
    private int soLuong;
    private float donGia;
    private float tongTien;
    private String chatLuong;
    
    public HangNhap() {
    }

    public HangNhap(int id, HangHoa hangHoa, int soLuong, float donGia, float tongTien, String chatLuong) {
        this.id = id;
        this.hangHoa = hangHoa;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.tongTien = tongTien;
        this.chatLuong = chatLuong;
    }

    public String getChatLuong() {
        return chatLuong;
    }

    public void setChatLuong(String chatLuong) {
        this.chatLuong = chatLuong;
    }

    

    public int getId() {
        return id;
    }

    public HangHoa getHangHoa() {
        return hangHoa;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public float getDonGia() {
        return donGia;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHangHoa(HangHoa hangHoa) {
        this.hangHoa = hangHoa;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }
    
}
