/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mang.com.vn;

import java.util.Scanner;

public class B6Mang {

    public static void main(String[] args) {
        Scanner ss = new Scanner(System.in);

        int a[][] = new int[4][4];

        double S1 = 1, S2 = 1, S3 = 1, S = 0;
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                System.out.printf("A[%d][%d] = ", i, j);
                a[i][j] = ss.nextInt();
            }
        }
        S = a[1][1] * a[2][2] * a[3][3] + a[2][1] * a[3][2] * a[1][3]
                + a[1][2] * a[2][3] * a[3][1] - (a[1][3] * a[2][2] * a[3][1]
                + a[2][1] * a[1][2] * a[3][3] + a[3][2] * a[2][3] * a[1][1]);
        System.out.println(S);
    }
}
