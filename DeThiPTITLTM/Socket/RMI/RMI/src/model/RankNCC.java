/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class RankNCC extends NCC{
    int soLuong;

    public RankNCC() {
    }

    public RankNCC(int soLuong) {
        this.soLuong = soLuong;
    }

    public RankNCC(int soLuong, int id, String name, String address, String phone, String email, String description) {
        super(id, name, address, phone, email, description);
        this.soLuong = soLuong;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
}
