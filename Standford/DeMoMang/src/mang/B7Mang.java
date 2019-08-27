
package mang;

import java.util.Arrays;
import java.util.Scanner;

public class B7Mang {
     public static void main(String[] args) {
        Scanner ss = new Scanner(System.in);

        int A[] = {10, 20, 90, 50, 100, 60, 30, 80, 70, 40};
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
