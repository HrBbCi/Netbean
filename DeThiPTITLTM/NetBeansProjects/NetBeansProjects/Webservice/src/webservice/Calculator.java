/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;
import java.io.Serializable;

/**
 *
 * @author LENPOVO
 */
public class Calculator implements Serializable{
    private double firstnumber;
    private double secondnumber;
    private double result;
    public Calculator(){
    }
    public Calculator(double a, double b){
    firstnumber = a;
    secondnumber = b;
    }
    public double getFirstnumber() {
    return firstnumber;
    }
     public double getResult() {
    return result;
    }
     
     public void setResult(double result) {
    this.result = result;
    }
    
    public void setFirstnumber(double firstnumber) {
    this.firstnumber = firstnumber;
    }
    public double getSecondnumber() {
    return secondnumber;
    }
    public void setSecondnumber(double secondnumber) {
    this.secondnumber = secondnumber;
    }
}
