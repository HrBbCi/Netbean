/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mang;

import java.util.Scanner;

public class B12MAng {

    public static void main(String[] args) {
        Scanner ss = new Scanner(System.in);

        String S = new String();
        S = ss.nextLine();

        char A[] = new char[S.length()];
        int dem[] = new int[10];
        dem[0] = S.split("0", -1).length - 1;
        dem[1] = S.split("1", -1).length - 1;
        dem[2] = S.split("2", -1).length - 1;
        dem[3] = S.split("3", -1).length - 1;
        dem[4] = S.split("4", -1).length - 1;
        dem[5] = S.split("5", -1).length - 1;
        dem[6] = S.split("6", -1).length - 1;
        dem[7] = S.split("7", -1).length - 1;
        dem[8] = S.split("8", -1).length - 1;
        dem[9] = S.split("9", -1).length - 1;
        for (int i = 0; i < dem.length; i++) {
            System.out.printf("dem[%d] = %d", i, dem[i]);
            System.out.println("");
        }
    }
}
