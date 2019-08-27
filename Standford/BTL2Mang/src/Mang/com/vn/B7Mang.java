package Mang.com.vn;

import java.util.Scanner;

public class B7Mang {

    public static void Nhap(int a[][], int m, int n) {
        Scanner ss = new Scanner(System.in);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("A[%d][%d] = ", i, j);
                a[i][j] = ss.nextInt();
            }
        }
        return;
    }

    public static void Xuat(int a[][], int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Scanner ss = new Scanner(System.in);

        int a, b;
        System.out.print("Nhập số hàng, cột của 2 ma trận: ");
        a = ss.nextInt();
        b = ss.nextInt();
        System.out.println("Nhập ma trận A: ");
        int A[][] = new int[a][b];
        Nhap(A, a, b);

        System.out.println("Nhập ma trận B: ");
        int B[][] = new int[a+1][b+1];
        Nhap(B, a, b);

        int C[][] = new int[a][b];
        int i = 0, j = 0;
        for (i = 0; i < a; i++) {
            for (j = 0; j < b; j++) {
                C[i][j] += A[i][j] + B[i][j];
            }
        }

        //Nhân ma trận với 1 số
        int c = 0;
        System.out.print("Nhập c: ");
        c = ss.nextInt();
        int D[][] = new int[a][b];
        for (i = 0; i < a; i++) {
            for (j = 0; j < b; j++) {
                D[i][j] += c * A[i][j];
            }
        }

        //Nhân 2 ma trận
        int E[][] = new int[a][b];
        for (i = 0; i < a; i++) {
            for (j = 0; j < b; j++) {
                for (int k = 0; k < b; k++) {
                    E[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        //Kết quả
        System.out.println("Kết Quả Cộng: ");
        Xuat(C, a, b);
        System.out.println("Kết Quả Nhân: ");
        Xuat(D, a, b);
        System.out.println("Nhân 2 ma trận: ");
        Xuat(E, a, b);

    }
}
