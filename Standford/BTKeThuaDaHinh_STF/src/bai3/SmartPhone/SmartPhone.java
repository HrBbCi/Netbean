/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai3.SmartPhone;

/**
 *
 * @author HrBbCi
 * RAM, Ổ cứng, Chợ phần mềm.
 */
public class SmartPhone extends Mobie{
    private int Ram;
    private int oCung;
    private String choPhanMem;

    public int getRam() {
        return Ram;
    }

    public void setRam(int Ram) {
        this.Ram = Ram;
    }

    public int getoCung() {
        return oCung;
    }

    public void setoCung(int oCung) {
        this.oCung = oCung;
    }

    public String getChoPhanMem() {
        return choPhanMem;
    }

    public void setChoPhanMem(String choPhanMem) {
        this.choPhanMem = choPhanMem;
    }
    
}
