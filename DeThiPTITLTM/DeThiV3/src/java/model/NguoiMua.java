package model;

/**
 *
 * @author HrBbCi
 */
public class NguoiMua {
    private String idNguoiMua;
    private String tenNM;

    public NguoiMua() {
    }

    public NguoiMua(String idNguoiMua, String tenNM) {
        this.idNguoiMua = idNguoiMua;
        this.tenNM = tenNM;
    }

    public String getIdNguoiMua() {
        return idNguoiMua;
    }

    public void setIdNguoiMua(String idNguoiMua) {
        this.idNguoiMua = idNguoiMua;
    }

    public String getTenNM() {
        return tenNM;
    }

    public void setTenNM(String tenNM) {
        this.tenNM = tenNM;
    }
    
    
}
