/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

public class ChuanHoaChuoi implements Serializable {

    private String chuoi;

    public ChuanHoaChuoi() {
    }

    public String getChuoi() {
        return chuoi;
    }

    public void setChuoi(String chuoi) {
        this.chuoi = chuoi;
    }

    public ChuanHoaChuoi(String chuoi) {
        this.chuoi = chuoi;
    }

}
