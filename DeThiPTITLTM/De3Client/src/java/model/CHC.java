package model;

import java.io.Serializable;

public class CHC implements Serializable {

    private String chuoi;

    public CHC(String chuoi) {
        this.chuoi = chuoi;
    }

    public CHC() {
    }

    public String getChuoi() {
        return chuoi;
    }

    public void setChuoi(String chuoi) {
        this.chuoi = chuoi;
    }

}
