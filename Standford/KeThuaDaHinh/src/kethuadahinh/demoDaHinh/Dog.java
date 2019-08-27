/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kethuadahinh.demoDaHinh;

public class Dog extends animal {

    private boolean bietBoi;

    public boolean isBietBoi() {
        return bietBoi;
    }

    public void setBietBoi(boolean bietBoi) {
        this.bietBoi = bietBoi;
    }

    public void Sua() {
        System.out.println("Go Go");
    }

    public void Sua(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println("Go Go" + i);
        }
    }

    @Override
    public String tiengKeu() {
        return "Gâu gâu";
    }
    
}
