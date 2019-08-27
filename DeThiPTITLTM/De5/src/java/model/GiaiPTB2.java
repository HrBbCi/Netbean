
package model;

import java.io.Serializable;


public class GiaiPTB2 implements Serializable {
    private float a;
    private float b;
    private float c;
    private float delTa;
    private float x1;
    private float x2;
    private String kq;
    public GiaiPTB2() {
    }

    public GiaiPTB2(float a, float b, float c, float delTa, float x1, float x2,String kq) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.delTa = delTa;
        this.x1 = x1;
        this.x2 = x2;
        this.kq = kq;
    }

    public String getKq() {
        return kq;
    }

    public void setKq(String kq) {
        this.kq = kq;
    }
    

    public float getDelTa() {
        return delTa;
    }

    public void setDelTa(float delTa) {
        this.delTa = delTa;
    }

    public float getX1() {
        return x1;
    }

    public void setX1(float x1) {
        this.x1 = x1;
    }

    public float getX2() {
        return x2;
    }

    public void setX2(float x2) {
        this.x2 = x2;
    }

    

    
    public float getA() {
        return a;
    }

    public void setA(float a) {
        this.a = a;
    }

    public float getB() {
        return b;
    }

    public void setB(float b) {
        this.b = b;
    }

    public float getC() {
        return c;
    }

    public void setC(float c) {
        this.c = c;
    }
    
    
}
