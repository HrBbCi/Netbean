/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Hung
 */
public class HoaDon implements  Serializable{
    private int id;
    private NCC ncc;
    private  ArrayList<HangNhap> listHangNhaps;
    private int amout;

    public HoaDon() {
    }

    public HoaDon(int id, NCC ncc, ArrayList<HangNhap> listHangNhaps, int amout) {
        this.id = id;
        this.ncc = ncc;
        this.listHangNhaps = listHangNhaps;
        this.amout = amout;
    }

    public int getId() {
        return id;
    }

    public NCC getNcc() {
        return ncc;
    }

    public ArrayList<HangNhap> getListHangNhaps() {
        return listHangNhaps;
    }

    public int getAmout() {
        return amout;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNcc(NCC ncc) {
        this.ncc = ncc;
    }

    public void setListHangNhaps(ArrayList<HangNhap> listHangNhaps) {
        this.listHangNhaps = listHangNhaps;
    }

    public void setAmout(int amout) {
        this.amout = amout;
    }
    

}