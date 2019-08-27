
package mang;

import java.util.Arrays;
import java.util.Scanner;

public class B4Mang {

    public static void main(String[] args) {
        Scanner ss = new Scanner(System.in);

        int n = 0;
        n = ss.nextInt();
        int A[] = new int[n];

        for (int i = 0; i < A.length; i++) {
            System.out.printf("A[%d] = ", i);
            A[i] = ss.nextInt();
        }
        Arrays.sort(A);
        
        System.out.println("SX tăng dần: ");
        for(int i = 0; i < A.length; i++){
            System.out.print(A[i] + " ");
        }
        
        System.out.println("");
        System.out.println("SX giảm dần :");
        for(int i = A.length - 1; i>=0;i--){
            System.out.print(A[i] + " ");
        }
        System.out.println("");
    }
}
