package Mang.com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DemoClassAndObject {

//    //Hàm không có giá trị rả về
//    private static void inThongTin() {
//        System.out.println("Trời đẹp");
//    }
//
//    //Hàm ko có giá trị rả về nhưng có đối số truyền vào
//    // @param n : Đối số truyền vào
//    private static void inThongTin(int n) {
//        for (int i = 1; i <= n; i++) {
//            System.out.println("Trời đẹp "+i);
//        }
//    }
//    //Hàm lấy thông tin
//    private  static  String layTen(){
//        return "ABC";
//    }
//    /**
//     * 
//     * @param a
//     * @param b
//     * @return 
//     */
//    private  static int Tong(int a, int b){
//        return (a+b);
//    }
    public static void main(String[] args) {
        Scanner ss =  new Scanner(System.in);
        
//        int n =10;
//        inThongTin();
//        inThongTin(n);
//        System.out.println(layTen());
//        System.out.println(Tong(n, n));
//        
//        HinhTron hT = new HinhTron();
//        System.out.println("Diện tích HT: "+hT.dienTich());
//        
//        //Khai báo và khởi tạo đối tượng 
//        HinhTron hT1 = new HinhTron(2);
//        System.out.println("Diện tích HT: "+hT1.dienTich());
        
        SinhVien sv1 = new SinhVien();
        SinhVienBussiness svv = new SinhVienBussiness();
   
        svv.taoDuLieuBanDau();
//        svv.themMoi(sv);
  //     svv.displayReport();
    }
}
