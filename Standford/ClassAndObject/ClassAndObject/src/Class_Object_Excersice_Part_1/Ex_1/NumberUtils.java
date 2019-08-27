/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class_Object_Excersice_Part_1.Ex_1;

/**
 *
 * @author neo
 */
public class NumberUtils {
    public static int parseInt(String strNum){
        int result = 0;
        if ( strNum.isEmpty() || strNum == null){
            return result;
        }
        
        try {
            result = Integer.parseInt(strNum);
        } catch (NumberFormatException e) {
            return 0;
        }
        
        return result;
    }
    public static float parseFloat(String strNum){
        float result = 0;
        if ( strNum.isEmpty() || strNum == null){
            return result;
        }
        
        try {
            result = Float.parseFloat(strNum);
        } catch (NumberFormatException e) {
            return 0f;
        }
        
        return result;
    }
    // double
    public static double parseDouble(String strNum){
        double result = 0;
        if ( strNum.isEmpty() || strNum == null){
            return result;
        }
        
        try {
            result = Double.parseDouble(strNum);
        } catch (NumberFormatException e) {
            return 0d;
        }
        
        return result;
    }
    
}
