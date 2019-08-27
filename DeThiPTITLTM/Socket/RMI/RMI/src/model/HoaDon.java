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
    private ArrayList<HangNhap> listHangNhaps;
    private float amout;
    private String dateCreater;
    private String prepay;

    public HoaDon() {
    }

    public HoaDon(int id, NCC ncc, ArrayList<HangNhap> listHangNhaps, float amout, String dateCreater, String prepay) {
        this.id = id;
        this.ncc = ncc;
        this.listHangNhaps = listHangNhaps;
        this.amout = amout;
        this.dateCreater = dateCreater;
        this.prepay = prepay;
    }

    public String getDateCreater() {
        return dateCreater;
    }

    public String getPrepay() {
        return prepay;
    }

    public void setDateCreater(String dateCreater) {
        this.dateCreater = dateCreater;
    }

    public void setPrepay(String prepay) {
        this.prepay = prepay;
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

    public float getAmout() {
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

    public void setAmout(float amout) {
        this.amout = amout;
    }
    

}