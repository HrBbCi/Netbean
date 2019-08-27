package mang;

import java.util.Scanner;

public class B2Mang {

    public static void main(String[] args) {
        Scanner ss = new Scanner(System.in);

        int n = 0;
        n = ss.nextInt();

        double A[] = new double[n];

        for (int i = 0; i < A.length; i++) {
            System.out.printf("A[%d] = ", i);
            A[i] = ss.nextDouble();
        }
        int k = 0;
        double x;
        System.out.print("x = ");
        x = ss.nextDouble();

        for (int i = 0; i < A.length; i++) {
            if (x == A[i]) {
                k = i;
                break;
            }
        }
        int i = 0;
        while (x != A[i] && i < A.length -1) {
            i++;
        }
        if (i == A.length - 1) {
            System.out.println("Ko tìm thấy x");
        } else {
            System.out.println("x = " + x + "ở vị trí " + k);
        }

    }
}
