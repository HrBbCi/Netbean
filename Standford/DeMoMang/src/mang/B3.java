
package mang;

import java.util.Scanner;

public class B3 {

    public static void main(String[] args) {
        Scanner ss = new Scanner(System.in);

        int n = 0;
        n = ss.nextInt();
        int A[] = new int[n];
        
        int max = A[0];
        int min = A[0];
       
        for (int i = 0; i < A.length; i++) {
            System.out.printf("A[%d] = ", i);
            A[i] = ss.nextInt();
            
            if (max < A[i]) {
                max = A[i];
            }
            if (A[i] < min) {
                min = A[i];
            }
        }
        
        int i = 0;
        while (A[0] == A[A.length - i - 1] && i < A.length - 1) {
            i++;
        }
        if (i == n - 1) {
            System.out.println("NO MAX AND NO MIN");
            return;
        }
        System.out.println("MAX = " + max);
        System.out.println("MIN= " + min);

    }

}
