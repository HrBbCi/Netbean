/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project.DiemThi;

import java.util.List;

/**
 *
 * @author HrBbCi
 */
public interface BangDiemDao {
    public List<DiemThi> getAll();
    public DiemThi getByIDSinhVien(String masv,String maMH);
    public boolean addNew(DiemThi bd);
    public boolean upDate(DiemThi bd);
    public boolean CheckID(int masv, int maKhoa);
    public List<DiemThi> findMaSV(String masv);
    public List<DiemThi> findMaKhoa(String maKhoa);
    public boolean xoaDiem(String maSV,String maMH);
}
