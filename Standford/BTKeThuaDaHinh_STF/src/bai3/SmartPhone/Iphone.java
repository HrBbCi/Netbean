/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai3.SmartPhone;

/**
 *
 * @author HrBbCi
 */
public class Iphone extends SmartPhone{
    SmartPhone sp = new SmartPhone();
    public void iPhone4s(){
        sp.setManHinh("");
        sp.setMau("Black");
        sp.setRam(10);
        sp.setoCung(10);
        
        System.out.println(sp.getManHinh());
        System.out.println(sp.getMau());
        System.out.println(sp.getRam());
        System.out.println(sp.getoCung());
    }
    public void iPhone5s(){
        
    }
    public void iPhone6s(){
        
    }
    
}
