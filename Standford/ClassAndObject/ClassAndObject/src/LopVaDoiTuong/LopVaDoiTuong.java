/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LopVaDoiTuong;

/**
 *
 * @author neo
 */
public class LopVaDoiTuong {
    /*
    Định nghĩa hàm
    */
    /*    Hàm không có giá trị trả về và không có tham số
    *@param n : số lần in ra
    */
    private static void inThongTin(int n){
        for (int i = 0; i < n; i++) {
            System.out.println("I love you " + i);
        }
        
    }
    /**
     * Hàm tính tổng
     * @param a đối số thứ 1 
     * @param b đối số thứ 2
     * @return trả về tổng hai số
     */
    private static int tongHaiSo(int a, int b){
        return (a+b);
    }
    /*Hàm lấy thông tin không có đối số vào
    @return Tên công ty
    */
    private static String layTenCongTy(){
        return "JavaNeo.com";
    }
    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {
        // Gọi hàm
        // In ra 100 câu I love you
        // Gọi hamg 
        inThongTin(1000000);
    }
}
