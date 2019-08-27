/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LopVaDoiTuong;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author neo
 */
public class SinhVienBusiness {

    /**
     * Khai báo 1 đối tượng SinhVienBusiness để truy xuất thông tin
     */
    public static SinhVienBusiness service = new SinhVienBusiness();

    public static SinhVienBusiness getInstance() {
        return service;
    }
    /**
     * khai báo 1 danh sách sinh viên
     */
    private List<SinhVien> lstSinhVien = new ArrayList();

    /**
     * Hàm lấy danh sách sinh viên
     *
     * @return Danh sách thông tin vủa các sv
     */
    public List<SinhVien> layDanhSachSinhVien() {
        return lstSinhVien;
    }

    /**
     * Hàm lấy thông tin SV theo mã Sinh viên nhập vào
     *
     * @param maSinhVien
     * @return Đối tượng sinh viên
     */
    public SinhVien layChiTietThongTinSinhVienTheoMaSV(String maSinhVien) {
//        if (maSinhVien == null || maSinhVien.isEmpty()){
//            return null;
//        }
        SinhVien objSinhVien = null;

        for (SinhVien objSV : lstSinhVien) {
            if (objSV.getMaSV().equals(maSinhVien)) {
                objSinhVien = objSV;
                break;
            }

        }
        return objSinhVien;
    }

    /**
     * Hàm thêm mới đối tượng sinh viên vào danh sách
     *
     * @param objSingVien
     * @return false nếu tồn tại đối tượng sinh viên đó trong danh sách return
     * true nếu ngược lại và thêm vào danh sách đối tượng đó
     */
    public boolean themSinhVien(SinhVien objSingVien) {
        if (objSingVien != null) {
            return false;
        }

        // Nếu chưa có danh sách sinh viên trả thi tạo một list để chứa
        if (this.lstSinhVien == null) {
            this.lstSinhVien = new ArrayList<>();
        }
        // thêm sv vào danh sách
        lstSinhVien.add(objSingVien);

        return true;

    }

    /**
     * Hàm dữ liệu mẫu để lấy thông tin hiển thị lên giao diện
     *
     * @param objSingVien
     * @return
     */
    private void taoDuLieuBanDau() {
        // Tạo đối tượng sinh viên Kiên
        SinhVien objHoang = new SinhVien();

        // gán giá trị cho các thuộc tính
        objHoang.setMaSV("JD210895");
        objHoang.setTenSV("Nguyễn Viết Hoàng");
        objHoang.setSoDT("01636241190");
        objHoang.setEmail("nguyenhoang210895@gmail.com");

        // Thêm vào danh sách
        lstSinhVien.add(objHoang);

        // Tạo đối tượng sinh viên Kiên
        SinhVien objKien = new SinhVien("Hải Dương");

        // gán giá trị cho các thuộc tính
        objKien.setMaSV("JD123456");
        objKien.setTenSV("Bùi Trung Kiên");
        objKien.setSoDT("0163555190");
        objKien.setEmail("kien@gmail.com");

        // Thêm vào danh sách
        lstSinhVien.add(objKien);
        // Tạo đối tượng sinh viên Kiên
        SinhVien objDong = new SinhVien("JD543123", "Nguyễn Vắn Đồng", "0163264988", "dongnv@gmail.com", "Nam Định");

        // Thêm vào danh sách
        lstSinhVien.add(objDong);
    }

    /**
     * Hàm Xóa đối tượng Sinh viên theo mã Sing viên nhập vào
     *
     * @param sinhVien
     * @param maSV
     * @return fasle nếu không tìm thấy đối tượng SV có mã SV true nếu tồn tại
     * SV có mã SV và thực hiện xóa đối tượng SV
     */
    public boolean xoaDuLieuSinhVienTuMaSV(String maSV) {
        if (maSV == null || maSV.isEmpty()) return false;
        
        for (SinhVien ilSinhVien : lstSinhVien) {
            if (ilSinhVien.getMaSV().equals(maSV)) {
                lstSinhVien.remove(ilSinhVien);
                return true;
            }
        }
        return false;
    }

    /**
     * Hàm sửa thông tin sinh viên
     *
     * @param objSinhVien
     * 
     * @return fasle nếu không sửa được ( dữ liệu nhập vào sai, không tìm thấy
     * sinh viên cần sửa ..) true nếu sửa thành công
     */
    public boolean suaThongTinSinhVienTheoMaSV(SinhVien objSinhVien) {
        if (objSinhVien == null) {
            return false;
        }

        if (this.lstSinhVien == null || this.lstSinhVien.isEmpty()) {
            return false;
        }

        for (SinhVien ilSinhVien : lstSinhVien) {
            if (ilSinhVien.getMaSV().equals(objSinhVien)) {
                // Cập nhật thông tin sinh viên trong danh sách
                ilSinhVien.setMaSV(objSinhVien.getMaSV());
                ilSinhVien.setTenSV(objSinhVien.getTenSV());
                ilSinhVien.setDiaChi(objSinhVien.getDiaChi());
                ilSinhVien.setSoDT(objSinhVien.getSoDT());
                ilSinhVien.setEmail(objSinhVien.getEmail());
                
                //Thoát khỏi hàm
                break;
            }
        }
        return true;
    }
    
}
