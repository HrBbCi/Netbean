/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1.TinhToan;

/**
 *
 * @author HrBbCi
 */
public class HinhTron extends TinhToan{
    private double banKinh;

    public HinhTron(double banKinh) {
        this.banKinh = banKinh;
    }

    @Override
    public double dienTich() {
        return (Math.PI*banKinh*banKinh);
    }

    @Override
    public void inThongTin() {
        System.out.println("Diện tích hình tròn: "+dienTich());
    }
    
}
