/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class_Object_Excersice_Part_1.Ex_1;

/**
 *
 * @author neo
 */
public class TinhToan {

    public static double tinhChuViHCN(double dai, double rong) {
        if (dai < 0 || rong < 0) return 0;
        return 2 * (dai + rong);
    }

    public static double tinhDienTichHCN(double dai, double rong) {
        if (dai < 0 || rong < 0) return 0;
        return dai * rong;
    }

    public static double tinhDienTichHT(double cao, double dayLon, double dayNho) {
        if (cao < 0 || dayLon < 0 || dayNho < 0) return 0;
        return (dayLon + dayNho) * cao / 2;
    }

    public static double tinhChuViTron(double banKinh) {
        if (banKinh < 0) return 0;
        return 2 * Math.PI * banKinh;
    }
    public static double tinhDienTichTron(double banKinh){
        if (banKinh < 0) return 0;
        return Math.PI*Math.pow(banKinh, 2);
    }
    public static int tinhGiaiThua(int n){
        if (n == 0) return 1;
        
        return n*tinhGiaiThua(n-1);
    }
}
