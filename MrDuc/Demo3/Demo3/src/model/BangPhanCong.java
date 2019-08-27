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
public class BangPhanCong implements Serializable, GiaoTiep {
    private int songay;
    private String congViec;
    private SinhVien s;
    private BaiTapNhom b;

    public int getSongay() {
        return songay;
    }

    public void setSongay(int songay) {
        this.songay = songay;
    }

    public String getCongViec() {
        return congViec;
    }

    public void setCongViec(String congViec) {
        this.congViec = congViec;
    }

    public SinhVien getS() {
        return s;
    }

    public void setS(SinhVien s) {
        this.s = s;
    }

    public BaiTapNhom getB() {
        return b;
    }

    public void setB(BaiTapNhom b) {
        this.b = b;
    }
    
    
    @Override
    public Object[] toObject() {
        return new Object[]{
          this.getS().getID(), this.getS().getTen(), this.getB().getID(), this.getB().getTen(),
            this.congViec, this.getSongay()
        };
    }
    
}
