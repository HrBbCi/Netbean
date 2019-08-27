
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author HrBbCi
 */
public class Regax {

    public static void main(String[] args) {
        Regax rg = new Regax();

        String str = "abca`dsa3";
        if (rg.getSpecialCharacterCount(str) == 0) {
            System.out.println("ký tự đặc biệt");
        }
    }

    public int getSpecialCharacterCount(String s) {
        if (s == null || s.trim().isEmpty()) {
            return 0;
        }
        Pattern p = Pattern.compile("[^A-Za-z0-9]");
        Matcher m = p.matcher(s);
        // boolean b = m.matches();
        boolean b = m.find();
        if (b == true) {
            return 0;
        }
        return 1;
    }
}
