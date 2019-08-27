/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc.com;

import java.math.BigInteger;
import java.util.Scanner;

public class B2 {

    public static void main(String[] args) {
        Scanner ss = new Scanner(System.in);
        BigInteger a ;
        a=ss.nextBigInteger();
        BigInteger b ;
        b=ss.nextBigInteger();
        BigInteger add;
        add = a.add(b);
        System.out.println(add);
    }
}
