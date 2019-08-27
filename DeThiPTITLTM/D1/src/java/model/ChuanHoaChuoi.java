/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author HrBbCi
 */
public class ChuanHoaChuoi implements Serializable{
    private String chuoi;

    public ChuanHoaChuoi() {
    }

    public ChuanHoaChuoi(String chuoi) {
        this.chuoi = chuoi;
    }

    
    public String getChuoi() {
        return chuoi;
    }

    public void setChuoi(String chuoi) {
        this.chuoi = chuoi;
    }
    
}
