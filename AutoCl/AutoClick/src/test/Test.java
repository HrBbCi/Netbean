/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

public class Test {

    String xuat(int a[], String str[]) {
        String kq = "";
        for (int i = 0; i < 26; i++) {
            kq += str[i]+": " +a[i]+"\n";
//            System.out.println(str[i]+": " +a[i]+" ");
        }
        return kq;
    }

    void dem(String chuoi) {
        char[] strChuoi = chuoi.toCharArray();
        String str = "a b c d e f g h i j k l m p n o q r s t u v x y w z";
        String str1[] = str.split(" ");
       
        int a[] = new int[26];
        for (int i = 0; i < a.length; i++) {
            a[i] = 0;
        }
        for (int i = 0; i < chuoi.length(); i++) {
            for (int j = 0; j < 26; j++) {
                if (str1[j].equals(String.valueOf(strChuoi[i]))) {
                    a[j] ++;
                }
            }
        }
        
        String kq = xuat(a, str1);
        System.out.println(kq);
    }

    void nhap() {
        String s = "aaavbfl m p n co q r s t u v x y w z";
        dem(s);
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.nhap();
    }
}
