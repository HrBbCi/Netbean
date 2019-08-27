/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo_desktop;

import java.util.Scanner;

public class B4part5 {

    public static void main(String[] args) {

        Scanner ss = new Scanner(System.in);
        int S = ss.nextInt();
//        for(int i = 10000; i<=99999;i++){
//            if(kiemTra(i)){
//                if(Tong(i) == S){
//                    System.out.println(i);
//                }
//            }
//        }
        int Ok =1 ;
        int tong = 0;
        int a = 0;
        for (int i = 10000; i <= 99999; i++) {
            for (int j = 2; j <= Math.sqrt(i); j++) 
                if (i % j == 0) 
                    Ok = 0;
            Ok = 1;
            int n = i;
            if (Ok == 1) {
                while (n > 0) {
                    a = n % 10;
                    tong += a;
                    n /= 10;
                }
                if (tong == S) {
                    System.out.println(i);
                }
            }

        }
    }
//    public static boolean kiemTra(int n){
//        if(n <2 )   return false;
//        for(int i = 2; i<=Math.sqrt(n);i++ ){
//            if(n % i ==0)
//                return false ;
//        }
//        return true;
//    }
//    public static int Tong(int n){
//       	int  a;
//	int S = 0;
//	while(n > 0){
//		a  = n % 10;
//		S += a;
//		n /= 10;
//	}
//	return S;
//    }
}
