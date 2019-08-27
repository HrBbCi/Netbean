/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mang;

import java.util.Scanner;

public class B15MAng {

    public static void main(String[] args) {
        Scanner ss = new Scanner(System.in);

        String S = "Cong ty Stanford – Dao tao va phat trien cong nghe”";
        if (S.contains("Stanford")) {
            System.out.println("Stanford");
        } else {
            System.out.println("NO");
        }
        
        char A[] = S.toCharArray();
        int dem = 0, k = 1;
        int B[] = new int[S.length()];
        
        for (int i = 0; i < S.length(); i++) {
            if ('t' == A[i]) {
                B[k++] = i;
                dem++;
            }
        }
       
        System.out.println("Chữ t đầu tiên: " + B[1]);
        System.out.println("Chữ t cuối : " + B[dem]);
          
    }
}
