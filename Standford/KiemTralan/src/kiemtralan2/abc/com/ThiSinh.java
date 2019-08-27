/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiemtralan2.abc.com;

import java.util.Date;
import java.util.logging.Logger;

/**
 * Viết một lớp có tên là ThiSinh gồm các thuộc tính sau: Số báo danh, Họ tên,
 * Giới tính, Ngày sinh, Quê quán, Tổng điểm, Toán, Lý, Hóa. Trong đó thuộc tính
 * Tổng điểm để lấy tổng điểm của 3 môn thi người dùng nhập vào. (1đ)
 */
public class ThiSinh implements GiaoTiep{

    private int soBD;
    private String hoTen;
    private String gioiTinh;
    private Date ngaySinh;
    private String queQuan;
    private double dToan;
    private double dLy;
    private double dHoa;
    private double tongDiem;

    public ThiSinh() {
     
    }


    public void setSoBD(int soBD) {
        this.soBD = soBD;
    }

    public int getSoBD() {
        return soBD;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public double getdToan() {
        return dToan;
    }

    public void setdToan(double dToan) {
        this.dToan = dToan;
    }

    public double getdLy() {
        return dLy;
    }

    public void setdLy(double dLy) {
        this.dLy = dLy;
    }

    public double getdHoa() {
        return dHoa;
    }

    public void setdHoa(double dHoa) {
        this.dHoa = dHoa;
    }

    public double getTongDiem() {
        return tongDiem;
    }

    public void setTongDiem(double tongDiem) {
        this.tongDiem = tongDiem;
    }

    public ThiSinh(int soBD, String hoTen, String gioiTinh, Date ngaySinh,
            String queQuan, double dToan, double dLy, double dHoa, double tongDiem) {
        this.soBD = soBD;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.queQuan = queQuan;
        this.dToan = dToan;
        this.dLy = dLy;
        this.dHoa = dHoa;
        this.tongDiem = tongDiem;
    }

    public boolean isDatDiemSan() {
        return (dToan + dLy + dHoa) >= 15;
    }

    public boolean isDatDiemLiet() {
        return (dToan == 1) || (dLy == 1) || (dHoa == 1);
    }

    public double getTongDiemChung() {
        return (dHoa + dLy + dToan);
    }

    @Override
    public Object[] toObject(){
         return new Object[]{soBD,hoTen,gioiTinh,ngaySinh,queQuan,dToan,dLy,dHoa};
    }    
    
   
    
 
    
}
