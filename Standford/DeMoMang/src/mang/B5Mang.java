
package mang;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B5Mang {

    public static void main(String[] args) {
        Scanner ss = new Scanner(System.in);

//        int n = 16;
//        int A[][] = new int[4][4];
//
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                System.out.printf("A[%d][%d] = ", i, j);
//                A[i][j] = ss.nextInt();
//            }
//
//        }
//        
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                System.out.print(A[i][j] + " ");
//            }
//            System.out.println("");
//        }
        
        Map<String, String> arr = new HashMap();
        arr.put("server", "192.168.200");
        
        arr.put("website", "abc.com");
        
        //Lấy thông tin
        System.out.println("Địa chỉ IP: "+arr.get("server"));
        System.out.println("Địa chỉ website : " +arr.get("website"));
        
    }
}
