package mang;

import java.util.Scanner;

public class B1 {

    public static void main(String[] args) {
        Scanner ss = new Scanner(System.in);
        
        int n = 0;
        n = ss.nextInt();
        float A[] = new float[n];

        float tong = 0, tongAm = 0, tongDuong = 0, 
                tongChan = 0, tongLe = 0;
        for (int i = 0; i < A.length; i++) {
            System.out.printf("A[%d] = ", i);
            A[i] = ss.nextFloat();

            tong += A[i];
            if (A[i] < 0) {
                tongAm += A[i];
            } else {
                tongDuong += A[i];
            }
            if (i % 2 == 0) {
                tongChan += A[i];
            } else {
                tongLe += A[i];
            }

        }
        float tb = (float) tong / n;
        System.out.print(tong + " " + tongAm + " " + tongDuong +
                " " + tongChan + " " + tongLe + " " + tb);
        System.out.println("");
    }
}
