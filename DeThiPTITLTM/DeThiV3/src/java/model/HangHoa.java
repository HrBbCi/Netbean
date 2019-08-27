
package model;


public class HangHoa  {

    private String idHangHoa;

    private String tenHH;

    private float gia;

    public HangHoa() {
    }

    public HangHoa(String idHangHoa, String tenHH, float gia) {
        this.idHangHoa = idHangHoa;
        this.tenHH = tenHH;
        this.gia = gia;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public String getIdHangHoa() {
        return idHangHoa;
    }

    public void setIdHangHoa(String idHangHoa) {
        this.idHangHoa = idHangHoa;
    }

    public String getTenHH() {
        return tenHH;
    }

    public void setTenHH(String tenHH) {
        this.tenHH = tenHH;
    }

}
