package Mang.com.vn;

import java.util.Scanner;

public class B4Mang {

    public static int giaiThua(int n) {
        int tong = 1;
        if (n == 0 || n == 1) {
            return 1;
        }
        for (int i = 2; i <= n; i++) {
            tong *= i;
        }
        return tong;
    }
    public static void lapChapK(int n, int k){
        int tong = (int) Math.pow(n,k);
        System.out.printf("Chỉnh hợp lặp chập K của n phần tử là F(%d, %d) = %d"
                , n , k, tong);
    }
    
    public static void main(String[] args) {
        Scanner ss= new Scanner(System.in);
        
        int n = 0, k = 0;
        System.out.println("Nhập n , k = ");
        n = ss.nextInt();
        k = ss.nextInt();
        
        lapChapK(n, k);
        System.out.println("");
        
        System.out.print("Chỉnh hợp chập k của n : ");
        float cauB = (float)giaiThua(n)/giaiThua(n-k);
        System.out.println(cauB);
        
        System.out.print("Hoán vị n phần tử: ");
        System.out.println(giaiThua(n));
        
        System.out.print("Số các hoán vị vòng quanh : ");
        System.out.println(giaiThua(n-1));
        
        System.out.print("Tổ hợp chập k :");
        float cauD =  (float)cauB/giaiThua(k);
        System.out.println(cauD);
    }
}
