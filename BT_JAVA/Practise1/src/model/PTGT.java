
package model;

import java.io.Serializable;


public class PTGT implements Serializable{
    String ma, hangsx, namsx, giaban, mau;

    public PTGT(String ma, String hangsx, String namsx, String giaban, String mau) {
        this.ma = ma;
        this.hangsx = hangsx;
        this.namsx = namsx;
        this.giaban = giaban;
        this.mau = mau;
    }

    public PTGT() {
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getHangsx() {
        return hangsx;
    }

    public void setHangsx(String hangsx) {
        this.hangsx = hangsx;
    }

    public String getNamsx() {
        return namsx;
    }

    public void setNamsx(String namsx) {
        this.namsx = namsx;
    }

    public String getGiaban() {
        return giaban;
    }

    public void setGiaban(String giaban) {
        this.giaban = giaban;
    }

    public String getMau() {
        return mau;
    }

    public void setMau(String mau) {
        this.mau = mau;
    }

    @Override
    public String toString() {
        return "PTGT: {Ma: " + ma + " Hang: " + hangsx + " Nam: " + namsx + " Gia: " + giaban + " Mau: " + mau + "}" ;
    }
}
