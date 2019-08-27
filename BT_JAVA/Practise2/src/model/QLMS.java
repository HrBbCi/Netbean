
package model;

import java.io.Serializable;
import java.util.ArrayList;

public class QLMS implements Serializable{
    BanDoc b;
    ArrayList<Sach> list;

    public QLMS(BanDoc b, ArrayList<Sach> list) {
        this.b = b;
        this.list = list;
    }

    public BanDoc getB() {
        return b;
    }

    public QLMS() {
        list = new ArrayList<>();
    }

    public void setB(BanDoc b) {
        this.b = b;
    }

    public ArrayList<Sach> getList() {
        return list;
    }

    public void setList(ArrayList<Sach> list) {
        this.list = list;
    }
    
    public boolean isExist(int key){
        for (Sach sach : list) {
            if (sach.getMa() == key) return true;
        }
        return false;
    }
    
//    String toStringList(){
//        String s = "";
//        for (Sach sach : list) {
//            s += sach.toString() + "\n";
//        }
//        return s;
//    }
    @Override
    public String toString() {
        return "Ban doc: " + b + "\n" + "Danh sach sach da muon:\n" + list;
    }
    
    
    
}
