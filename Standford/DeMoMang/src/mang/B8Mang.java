package mang;

import java.util.Scanner;

public class B8Mang {

    public static void main(String[] args) {
        Scanner ss = new Scanner(System.in);

        int A[][] = new int[4][4];
        int tongDuong = 0, dem = 0;
        int tongAm = 0, dem1 = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf("A[%d][%d] = ", i, j);
                A[i][j] = ss.nextInt();

                if (A[i][j] >= 0) {
                    tongDuong += A[i][j];
                    dem++;
                } else {
                    tongAm += A[i][j];
                    dem1++;
                }
            }

        }
        System.out.println("");
        System.out.print("Các phần tử duong: ");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (A[i][j] >= 0) {

                    System.out.print(A[i][j] + " ");
                }
            }
        }
        System.out.println("");
        System.out.print("Các phần tử âm: ");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (A[i][j] < 0) {

                    System.out.print(A[i][j] + " ");
                }
            }
        }
        System.out.println("");
        System.out.println("Số phần tử  >= 0: " + dem);
        System.out.println("Số phần tử < 0 : " + dem1);
        System.out.println("Tổng Dương: " + tongDuong);
        System.out.println("Tổng âm: " + tongAm);
    }
}
