/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mang.com;

import java.util.ArrayList;
import java.util.List;

public class SinhVienBussiness {

    private List<SinhVien> lstSinhVien = new ArrayList();

    public static SinhVienBussiness instance = new SinhVienBussiness();

    //Khai báo 1 hàm truy suất đêns các phương thức khi có nhu cầu
    public static SinhVienBussiness getInstance() {
        return instance;
    }
    public List<SinhVien> layDanhSachSinhVien() {
        return lstSinhVien;
    }

//    public void displayReport() {
//
//        System.out.println("------------------------------------------------------------------------------------");
//        System.out.println("                                Danh sách sinh viên                                       ");
//        System.out.println("------------------------------------------------------------------------------------");
//        System.out.printf("%-15s %-20s %-20s %-20s %-20s", "Mã", "Tên", "Số Điện Thoại", "Địa Chỉ",
//                "Email");
//        for (int i = 0; i < lstSinhVien.size(); i++) {
//            lstSinhVien.get(i).display();
//        }
//        System.out.println("\n------------------------------------------------------------------------------------");
//    }

    public void taoDuLieuBanDau() {
        //Tạo ra sinh viên Kiên
        SinhVien objKien = new SinhVien();
        //Gán giá trị cho các thuộc tính
        objKien.setMaSV("SF001");
        objKien.setHoTen("Bùi Trung Kiên");
        objKien.setDiaChi("Hà Nội");
        objKien.setSoDT("0988333689");
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

    public boolean themMoi(SinhVien objSinhVien) {
        if (objSinhVien != null){
            lstSinhVien.add(objSinhVien);
            return true;
        }
        return false;
    }

    
    public SinhVien layChiTietSinhVienTheoMa(String maSinhVien) {
        SinhVien objSinhVien = null;
        for (SinhVien objSV : lstSinhVien) {
            if (objSV.getMaSV().equals(maSinhVien)) {
                //Lấy thông tin bằng việc gán cho đối tượng
                objSinhVien = objSV;
                break;
            }
        }
        return objSinhVien;
    }
}
