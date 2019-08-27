
package model;

public class XeTai extends PTGT{
    String trongtai;

    public XeTai() {
    }

    public XeTai(String trongtai, String ma, String hangsx, String namsx, String giaban, String mau) {
        super(ma, hangsx, namsx, giaban, mau);
        this.trongtai = trongtai;
    }

    @Override
    public String toString() {
        return super.toString() + " - Xe Tai{Trong tai: " + trongtai + "}"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
