package mang;

import java.util.Scanner;


public class B6Mang {
    public static void main(String[] args) {
        Scanner ss = new Scanner(System.in);
        
        String S = "Cong ty Stanford – Dao tao va phat trien cong nghe";
        String A[] = S.split("\\s");
        for(int w =0; w <A.length;w++){
            System.out.printf("A[%d] = %s",w, A[w]);
            System.out.println("");
        }
       
    }
}
