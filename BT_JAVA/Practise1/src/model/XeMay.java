
package model;


public class XeMay extends PTGT{
    String congsuat;

    public XeMay() {
    }
    
    public XeMay(String congsuat, String ma, String hangsx, String namsx, String giaban, String mau) {
        super(ma, hangsx, namsx, giaban, mau);
        this.congsuat = congsuat;
    }

    @Override
    public String toString() {
        return super.toString() + " - Xe May {Cong suat: " + congsuat + "}"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
