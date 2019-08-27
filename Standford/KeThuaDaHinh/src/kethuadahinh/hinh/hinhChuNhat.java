/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kethuadahinh.hinh;

/**
 *
 * @author HrBbCi
 */
public class hinhChuNhat extends Hinh{
    private double chieuDai;
    private double chieuRong;

    public hinhChuNhat(double chieuDai, double chieuRong) {
        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
    }

    @Override
    public double dienTich() {
        return chieuDai*chieuRong;
    }

    @Override
    public void inThongTin() {
        System.out.println("Diện Tích Hình Chữ Nhật là : "+dienTich());
    }
    
}
