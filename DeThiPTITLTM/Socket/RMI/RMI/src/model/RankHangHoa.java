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
public class RankHangHoa extends HangHoa{
    private int soLuong;

    public RankHangHoa() {
    }
    public RankHangHoa(int soLuong) {
        this.soLuong = soLuong;
    }

    public RankHangHoa(int soLuong, int id, String name, String type, float price, String description) {
        super(id, name, type, price, description);
        this.soLuong = soLuong;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
}
