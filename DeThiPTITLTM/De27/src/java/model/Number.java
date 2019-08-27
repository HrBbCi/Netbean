package model;

import java.io.Serializable;

public class Number implements Serializable{
    private int number;

    public Number() {
    }

    
    public Number(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
}
