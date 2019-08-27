/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc.com;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class SinhVienBussiness {

    public static SinhVienBussiness instance;

    private SinhVienBussiness() {

    }

    /**
     * design pattern Singleton pattern
     *
     * @return
     */
    //Khai báo 1 hàm truy suất đêns các phương thức khi có nhu cầu
    /**
     * syn mỗi thời điểm chỉ có 1 hàm gọi đến getInstance;
     *
     * @return
     */
    public synchronized static SinhVienBussiness getInstance() {
        if (instance == null) {
            instance = new SinhVienBussiness();
        }
        return instance;
    }
    private List<SinhVien> lstSinhVien = new ArrayList();

    public List<SinhVien> getListStudents() {
        return lstSinhVien;
    }

    public List<SinhVien> findStudents(String strHoTen) {
        List<SinhVien> ls = new ArrayList<>();
        SinhVien sv;
        for (int i = 0; i < lstSinhVien.size(); i++) {
            sv = lstSinhVien.get(i);
            if (sv.getHoTen().contains(strHoTen)) {
                ls.add(sv);
            }
        }
        return ls;
    }

    public void taoDuLieuSinhVien() {
        //Tạo ra sinh viên Kiên
        SinhVien objKien = new SinhVien();
        //Gán giá trị cho các thuộc tính
        objKien.setMaSV("SF001");
        objKien.setHoTen("Bùi Trung Kiên");
        objKien.setDiaChi("Hà Nội");
        objKien.setDienThoai("0988333689");
        objKien.seteMail("trungkien@gmail.com");
        //Thêm vào danh sách
        lstSinhVien.add(objKien);
        //Tạo đối tượng sinh viên thứ 2
        SinhVien objHiep = new SinhVien("SF002", "Nguyễn Tuấn Hiệp", "097523658",
                "Hà NỘi", "tuanhiep@gmail.com");
        //Thêm vào danh sách
        lstSinhVien.add(objHiep);
        //Tạo sinh viên 3
        SinhVien objDong = new SinhVien("SF003", "Nguyễn Văn Đồng",
                "0905345688", "Phú Thọ", "dongnv@yahoo.com");
        //Thêm vào danh sách
        lstSinhVien.add(objDong);
        //Tạo sinh viên 4
        SinhVien objHien = new SinhVien("SF004", "Nguyễn Tiến Hiển",
                "090532358", "Bắc Ninh", "tienhien@gmail.com");
        //Thêm vào danh sách
        lstSinhVien.add(objHien);

    }

    public boolean themMoiSinhVien(SinhVien objSinhVien) {
        if (objSinhVien == null) {
            return false;
        }
        
        this.lstSinhVien.add(objSinhVien);
        return true;
    }

    public boolean kiemTra(String maSV) {
        SinhVien temp = new SinhVien();
        for (int i = 0; i < lstSinhVien.size(); i++) {
            temp = this.lstSinhVien.get(i);
            if (temp.getMaSV().equalsIgnoreCase(maSV)) {
                return false;
            }
        }
        return true;
    }

    public boolean editSinhVien(SinhVien sv) {
        if (sv == null) {
            return false;
        }
        SinhVien temp = null;
        for (int i = 0; i < lstSinhVien.size(); i++) {
            temp = lstSinhVien.get(i);
            if (sv.getMaSV() != null) {
            if (temp.getMaSV().equals(sv.getMaSV())) {
                    temp.setDiaChi(sv.getDiaChi());
                    temp.setHoTen(sv.getHoTen());
                    temp.setDienThoai(sv.getDienThoai());
                    temp.seteMail(sv.geteMail());
                    temp.setMaSV(sv.getMaSV());
 //               lstSinhVien.set(i, sv);
                return true;
                  }
            }
        }
        return false;
    }

    public boolean Xoa(String MaSV) {
        if (MaSV == null || MaSV.isEmpty()) {
            return false;
        }
        SinhVien sv = new SinhVien();
        for (int i = 0; i < this.lstSinhVien.size(); i++) {
            sv = this.lstSinhVien.get(i);
            if (sv.getMaSV() != null && sv.getMaSV().equals(MaSV)) {
                this.lstSinhVien.remove(sv);
                return true;
            }
        }
        return false;
    }

    public SinhVien getSinhVienByMa(String maSV) {
        SinhVien sv = new SinhVien();
        for (int i = 0; i < lstSinhVien.size(); i++) {
            sv = this.lstSinhVien.get(i);
            if (sv.getMaSV().equalsIgnoreCase(maSV)) {
                return sv;
            }
        }
        return null;
    }

}
