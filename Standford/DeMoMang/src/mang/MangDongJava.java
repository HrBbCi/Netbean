package mang;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MangDongJava {

    public static void main(String[] args) {
        Scanner ss = new Scanner(System.in);
//        ArrayList A = new ArrayList();
//
//        A.add("Kiên");
//        A.add("HRBB Ci");
//        A.add(new Date());
//
//        for (Object obj : A) {
//            System.out.println(obj);
//        }

        //List
        List<String> arr = new ArrayList<String>();
        arr.add("Java");
        arr.add("J2EE");
        for (Object obj : arr) {
            System.out.println(obj);
        }
        System.out.println("");
        //Chèn
        arr.add(1,"Hiper");
        
        // Xóa
       // arr.remove("Java");
        
         for (Object obj : arr) {
            System.out.println(obj);
        }
    }
}
