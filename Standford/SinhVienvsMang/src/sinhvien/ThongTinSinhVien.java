
package sinhvien;
public class ThongTinSinhVien {
    private String maSV, hoTen, diaChi, eMail, soDT;
    public ThongTinSinhVien(){
        
    }
    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }
    public String getMaSV() {
        return maSV;
    }

    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String geteMail() {
        return eMail;
    }
    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getHoTen() {
        return hoTen;
    }
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDT() {
        return soDT;
    }
    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public ThongTinSinhVien(String maSinhVien, String hoT, String eMl,
            String diaC, String soDt ) {
        this.maSV = maSinhVien;
        this.hoTen = hoT;
        this.eMail = eMl;
        this.soDT= soDt;
        this.diaChi =diaC;
    }
}
