/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 * 9h13
 *
 * @author HrBbCi
 */
public class CoSo implements Serializable{

    private int so;
    private int coSo;

    public CoSo() {
    }

    public CoSo(int so, int coSo) {
        this.so = so;
        this.coSo = coSo;
    }

    public int getSo() {
        return so;
    }

    public void setSo(int so) {
        this.so = so;
    }

    public int getCoSo() {
        return coSo;
    }

    public void setCoSo(int coSo) {
        this.coSo = coSo;
    }
    
    
}
