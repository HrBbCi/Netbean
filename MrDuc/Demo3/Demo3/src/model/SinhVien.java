/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.GiaoTiep;
import java.io.Serializable;

/**
 *
 * @author ThanTrieu@Pro
 */
public class SinhVien implements Serializable, GiaoTiep {

    private int ID;
    private String ten, lop, dc;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getDc() {
        return dc;
    }

    public void setDc(String dc) {
        this.dc = dc;
    }
    
    @Override
    public Object[] toObject() {
        return new Object[]{
          this.getID(), this.getTen(), this.getDc(), this.getLop()
        };
    }
    
}
