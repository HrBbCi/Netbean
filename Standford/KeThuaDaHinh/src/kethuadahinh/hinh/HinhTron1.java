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
public class HinhTron1 extends  Hinh1{

    private double banKinh = 0;

    public HinhTron1(double  banKinh){
        this.banKinh = banKinh;
    }
    
    @Override
    public double dienTich() {
        return (Math.PI*banKinh*banKinh);
    }

    @Override
    public void inThongTin() {
        System.out.println("Diện tích hình tròn : "+dienTich());
    }
    
}
