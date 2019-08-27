
package model;

public class OTo extends PTGT{
    String dongco, soghe;

    public OTo(String dongco, String soghe, String ma, String hangsx, String namsx, String giaban, String mau) {
        super(ma, hangsx, namsx, giaban, mau);
        this.dongco = dongco;
        this.soghe = soghe;
    }

    public OTo() {
    }

    @Override
    public String toString() {
        return super.toString() + " - O To{Dong co: " + dongco + " So ghe: " + soghe + "}"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
