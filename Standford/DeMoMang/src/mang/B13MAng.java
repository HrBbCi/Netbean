/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mang;

import java.util.Scanner;

public class B13MAng {

    public static void main(String[] args) {
        Scanner ss = new Scanner(System.in);

        String S = new String();
        S = ss.nextLine();
        char A[] = S.toCharArray();
        int B[] = new int[S.length()];
        int k = 0, dem =0;
        for(int i = 0; i<S.length();i++){
            
            if(A[i] == 'a'){
                B[k++] = i;
                dem++;
            }
        }
        System.out.println("Số lần xuất hiện a: "+dem);
        for(k = 0;k < dem;k++){
            System.out.println("Vị trí chữ số a xuất hiện: "+B[k]+ " ");
        }
    }
}
