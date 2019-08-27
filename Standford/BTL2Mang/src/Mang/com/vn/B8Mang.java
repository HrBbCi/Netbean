/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mang.com.vn;

import java.util.Scanner;

public class B8Mang {

    public static void main(String[] args) {
        Scanner ss = new Scanner(System.in);

        String S = new String();
        System.out.println("Nhập chuỗi họ tên: ");
        S = ss.nextLine();

        String strS = new String();
        strS = S.toUpperCase();
        System.out.println("Chuỗi sau khi viết hoa: " + strS);
    }
}
