
package Mang.com;

public class HinhTron {
    private double banKinh = 1;
    public HinhTron(){
        
    }
    public HinhTron(double banKinh){
        this.banKinh = banKinh;
    }
    public double dienTich(){
        return Math.PI*banKinh*banKinh;
    }
    
    
    
}
