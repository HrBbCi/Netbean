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
public class HinhThang extends TinhToan{
    private double dayLon;
    private double dayNho;
    private double chieuCao;

    public HinhThang(double dayLon, double dayNho, double chieuCao) {
        this.dayLon = dayLon;
        this.dayNho = dayNho;
        this.chieuCao = chieuCao;
    }

    @Override
    public double dienTich() {
        return ((dayLon+dayNho)*chieuCao)/2;
    }

    @Override
    public void inThongTin() {
        System.out.println("Diện tích hình thang: "+dienTich());
    }
    
    
}
