package mang;

import java.util.Scanner;

public class B14Mang {

    public static void main(String[] args) {
        Scanner ss = new Scanner(System.in);

        String S = new String();
        System.out.print("Nhập chuỗi: ");
        S = ss.nextLine();
        
        System.out.print("Nhập ký tự: ");
        char x = ss.next().charAt(0);
        
        System.out.print("Nhập ký tự thay thế: ");
        char y = ss.next().charAt(0);
        
        String S1= "";
        for (int i = 0; i < S.length(); i++) {
            if (x == S.charAt(i)) {
                S1 = S.replace(x, y);
            }
            
        }
        int i = 0;
        while(x != S.charAt(i) && i < S.length()-1){
            i++;
        }
        if(i == S.length()-1){
            System.out.println("Ko tìm được ký tự để thay thế");
            return;
        }
        System.out.println("Chuỗi mới: " + S1);

    }
}
