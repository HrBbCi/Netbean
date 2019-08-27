/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mang;

import java.util.Arrays;
import java.util.Scanner;

public class deMoMang {

    public static void main(String[] args) {
        Scanner ss = new Scanner(System.in);
        System.out.print("Nhập n: ");
        int n = ss.nextInt();
        //Khai báo
        int a[] = new int[n];

        //Nhập giá trị
        for (int i = 0; i < a.length; i++) {
            System.out.printf("a[%d] = ", i);
            a[i] = ss.nextInt();
        }
        //In thông tin ra màn hình
        System.out.println(Arrays.toString(a));
//        for(int i = 0; i < a.length; i++){
//            System.out.print(a[i]+ " " );
//        }
//        System.out.println("");
//       C2 in ra màn hình 

        
    }
}
