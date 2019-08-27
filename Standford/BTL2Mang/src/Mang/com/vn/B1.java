/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mang.com.vn;

import java.util.Scanner;

public class B1 {
    
    public static void main(String[] args) {
        Scanner ss = new Scanner(System.in);

//        int n = 0, m = 0;
//        System.out.print("Nhập m , n: ");
//        m = ss.nextInt();
//        n = ss.nextInt();
//        int A[][] = new int[m][n];
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.printf("A[%d][%d] = ", i, j);
//                A[i][j] = ss.nextInt();
//            }
//        }
//        
//        int tong = 0, tongD = 0, tongA = 0, tongC = 0, tongL = 0;
//        for(int i = 0 ;i< m;i++){
//            for(int j = 0 ;j<n;j++){
//                tong += A[i][j];
//                if(A[i][j] >= 0){
//                    tongD += A[i][j];
//                }
//                else{
//                    tongA += A[i][j];
//                }
//                if(A[i][j] %2 ==0){
//                    tongC += A[i][j];
//                }
//                else{
//                    tongL += A[i][j];
//                }
//            }
//        }
//        
//        System.out.println("Tồng các phần tử : "+tong);
//        System.out.println("Tổng các phần tử dương : " +tongD);
//        System.out.println("Tổng các phần tử âm : "+ tongA);
//        System.out.println("Tổng các phần tử Chẵn : "+tongC);
//        System.out.println("Tổng các phần tử lẻ : "+tongL);
//        
        String S = "ABC ACB";
        S.toCharArray();
        String SS[] = new String[S.length()];
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == ' ') {
                SS[i] = S.substring(0, i);
                
            }
        }
        for (int i = 0; i < SS.length; i++) {
            System.out.println(SS[i] + " ");
        }
        
    }
}
