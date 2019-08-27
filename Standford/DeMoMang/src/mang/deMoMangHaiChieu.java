/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mang;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Kien
 */
public class deMoMangHaiChieu {

    public static void main(String[] args) {
        Scanner ss = new Scanner(System.in);
        int m, n;
        m = ss.nextInt();
        n = ss.nextInt();

        int A[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("a[%d][%d] = ", i, j);
                A[i][j] = ss.nextInt();

            }

        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
