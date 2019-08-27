/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project.DiemThi;

import Project.MonHoc.MonHoc;
import Project.PhongHoc.PhongHoc;
import Project.SinhVien.SinhVien;
import java.util.Date;

/**
 *
 * @author HrBbCi
 */
public class DiemThi {
    private Date ngayThi;
    private float diemThi;
    private PhongHoc phongHocID;
    private MonHoc monHocID;
    private SinhVien sinhVienID;
    private int sinhvienId;
    private int monhocId;
    private int phonghocId;

    public int getSinhvienId() {
        return sinhvienId;
    }

    public void setSinhvienId(int sinhvienId) {
        this.sinhvienId = sinhvienId;
    }

    public int getMonhocId() {
        return monhocId;
    }

    public void setMonhocId(int monhocId) {
        this.monhocId = monhocId;
    }

    public int getPhonghocId() {
        return phonghocId;
    }

    public void setPhonghocId(int phonghocId) {
        this.phonghocId = phonghocId;
    }

    
    public Date getNgayThi() {
        return ngayThi;
    }

    public void setNgayThi(Date ngayThi) {
        this.ngayThi = ngayThi;
    }

    public float getDiemThi() {
        return diemThi;
    }

    public void setDiemThi(float diemThi) {
        this.diemThi = diemThi;
    }

    public PhongHoc getPhongHocID() {
        return phongHocID;
    }

    public void setPhongHocID(PhongHoc phongHocID) {
        this.phongHocID = phongHocID;
    }

    public MonHoc getMonHocID() {
        return monHocID;
    }

    public void setMonHocID(MonHoc monHocID) {
        this.monHocID = monHocID;
    }

    public SinhVien getSinhVienID() {
        return sinhVienID;
    }

    public void setSinhVienID(SinhVien sinhVienID) {
        this.sinhVienID = sinhVienID;
    }
    
    
}
