
package bai3.SmartPhone;
/*
Cho một lớp cơ sở Mobile bao gồm các đặc tính sau: Màn hình, màu, trọng lượng, hãng
sản xuất, hệ điều hành, giá. Hãy sử dụng kiến thức kế thừa và đa hình đã được học thực
hiện các yêu cầu sau:
*/
public class Mobie {
    private String manHinh;
    private String mau;
    private int trongLuong;
    private String hangSX;
    private String heDH;
    private int gia;

    public String getManHinh() {
        return manHinh;
    }

    public void setManHinh(String manHinh) {
        this.manHinh = manHinh;
    }

    public String getMau() {
        return mau;
    }

    public void setMau(String mau) {
        this.mau = mau;
    }

    public int getTrongLuong() {
        return trongLuong;
    }

    public void setTrongLuong(int trongLuong) {
        this.trongLuong = trongLuong;
    }

    public String getHangSX() {
        return hangSX;
    }

    public void setHangSX(String hangSX) {
        this.hangSX = hangSX;
    }

    public String getHeDH() {
        return heDH;
    }

    public void setHeDH(String heDH) {
        this.heDH = heDH;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
    
}
