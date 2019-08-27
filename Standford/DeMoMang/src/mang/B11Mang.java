/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mang;

import java.util.Scanner;

public class B11Mang {
    public static void main(String[] args) {
        Scanner ss = new Scanner(System.in);
        
        String S = new String();
        System.out.print("Nhập chuỗi: ");
        S = ss.nextLine();
        
        char A[] = S.toCharArray();
        
        System.out.print("Đảo ngược: ");
        for(int i = A.length-1; i>=0 ; i--){
            System.out.print(A[i]);
        }
        System.out.println("");
    }
}
