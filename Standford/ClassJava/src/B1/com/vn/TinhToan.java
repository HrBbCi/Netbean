/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B1.com.vn;

/**
 *
 * @author HrBbCi
 */
public class TinhToan {
        TinhToan() {
                
        }
        public int chuViHCN(int a, int b) {
            return ((a + b) * 2);
        }
        public int dienTichHCN(int a, int b){
            return (a*b);
        }
        public double dienTichHThang(int a, int b, int h){
            double s = (a+b)*h/2;
            return s;
        }
        public int chuViHThang(int a, int b, int c, int d){
            return(a+b+c+d);
        }
        
        public double dienTichHTron(int r){
            return (Math.PI*r*r);
        }
        public double chuViHTron(int r){
            return (2*Math.PI*r);
        }
        
        public int gThua(int n){
            if(n < 2)   return 1;
            return ((n)*gThua(n-1));
        }
}
