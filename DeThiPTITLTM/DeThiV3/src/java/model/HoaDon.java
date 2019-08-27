package model;


public class HoaDon {

    private NguoiMua nm;
    private HangHoa hh;
    private int soLuong;
    private float tongTien;

    public HoaDon() {
    }

    public HoaDon(NguoiMua nm, HangHoa hh, int soLuong, float tongTien) {
        this.nm = nm;
        this.hh = hh;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
    }

    public NguoiMua getNm() {
        return nm;
    }

    public void setNm(NguoiMua nm) {
        this.nm = nm;
    }

    public HangHoa getHh() {
        return hh;
    }

    public void setHh(HangHoa hh) {
        this.hh = hh;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

}
