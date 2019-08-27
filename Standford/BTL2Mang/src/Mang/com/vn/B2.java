package Mang.com.vn;

import java.util.Scanner;

public class B2 {

    public static void main(String[] args) {
        Scanner ss = new Scanner(System.in);
        
        int a = 0 , b = 0, c = 0, d = 0;
        
        do{
            a = ss.nextInt();
        }while(a==0);
        b = ss.nextInt();
        c = ss.nextInt();
        d = ss.nextInt();
        int delta = 0 ;
        delta = b*b - 3*a*c;
        if(delta == 0){
            double x1 = (-b + Math.cbrt(b*b*b-27*a*a*d)) /(3*a);
            System.out.println("Phương trình có 1 nghiệm bội: ");
            System.out.println("x = "+  x1);
        }
        else{
           double k = (9*a*b*c - 2*b*b*b - 27*a*a*d)/
                   (2*Math.sqrt(Math.pow(Math.abs(delta),3)));
           if(delta < 0){
               double x2 = 0;
               x2 = (Math.sqrt(Math.abs(delta)))*(Math.cbrt(k + Math.sqrt(k*k+1)) 
                       + Math.cbrt(k - Math.sqrt(k*k+1))) - b;
               System.out.println("PT có 1 nghiệm duy nhất x = "+ x2/(3*a));
           }
           else{
               if(Math.abs(k) > 1){
                   double x31 = 0, x32 = 0;
                   x31 = Math.sqrt(delta) * Math.abs(k)
                       *(Math.cbrt(Math.abs(k) + Math.sqrt(k*k - 1)) 
                       + Math.cbrt(Math.abs(k) - Math.sqrt(k*k - 1)))/(3*a*k);
                   x32 = x31- b/(3*a);
                    System.out.println("PT có 1 nghiệm duy nhất x = " + x32);
               }
               else{
                   double x4 = 0, x5 = 0 , x6 = 0, h = 0 , i = 0;
                   h = (Math.acos(k) * Math.PI) / (3 * 3.14);
                   i = 2*Math.sqrt(delta);
                   x4 = (i*Math.cos(h)-b)/(3*a);
                   x5 = (i*Math.cos(h - 2*Math.PI /3) - b)/(3*a);
                   x6 = (i*Math.cos(h + 2*Math.PI /3) - b)/(3*a);
                   System.out.println("x1 = "+x4);
                   System.out.println("x2 = "+x5);
                   System.out.println("x3 = "+x6);
               }
           }
        }
     
    }
}
