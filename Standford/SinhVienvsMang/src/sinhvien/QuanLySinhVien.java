package sinhvien;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLySinhVien {

    private static String ten ,maSV, diaChi, eMail, sDT;
    private static int sDThoai;
    private static ThongTinSinhVien A[] = new ThongTinSinhVien[4];

    public static void nhapDSSinhVien(int soSinhVien) throws Exception {
        Scanner ss = new Scanner(System.in);
        for (int i = 0; i <= soSinhVien - 1; i++) {
            A[i] = new ThongTinSinhVien();
            System.out.println("Thông tin sinh viên " + (i + 1));
            System.out.print("Mời nhập tên: ");
            ten = ss.nextLine();
            A[i].setHoTen(ten);
            
            if (i < 1) {
                System.out.print("Mời nhập Mã Sinh Viên: ");
                maSV = ss.nextLine();
                A[i].setMaSV(maSV);

            } else {
                for (int j = 0; j < i; j++) {
                    do {
                        System.out.print("Mời nhập Mã Sinh Viên: ");
                        maSV = ss.nextLine();
                    } while (A[j].getMaSV().equals(maSV));
                }
                A[i].setMaSV(maSV);
            }
            
            
            int t =0;
            do{
                System.out.print("Mời nhập Số Điên thoại: ");
                sDT = ss.nextLine();
            try {
               sDThoai = Integer.parseInt(sDT);
               t=1;
            } catch (Exception e) {
                System.out.println("Nhập lại số điện  thoại");
               
            }
            }while(t !=1);
            A[i].setSoDT(sDT);

            System.out.print("Nhập Địa CHỉ: ");
            diaChi = ss.nextLine();
            A[i].setDiaChi(diaChi);

            System.out.print("Nhập email: ");
            eMail = ss.nextLine();
            A[i].seteMail(eMail);

        }
    }

//    public boolean addSinhVien(ThongTinSinhVien thongTinSV, int soSinhVien) {
//        soSinhVien = 2;
//        if (thongTinSV == null) {
//            return false;
//        }
//        for (int i = 0; i <= soSinhVien - 1; i++) {
//            if (this.A[i] == null) {
//                this.A[i] = new ThongTinSinhVien();
//            }
//            this.A[i].getHoTen();
//            this.A[i].getMaSV();
//            this.A[i].getSoDT();
//            this.A[i].getDiaChi();
//            this.A[i].geteMail();
//        }
//        return true;
//    }
    public static void updateSinhVien(ThongTinSinhVien thongTinSV, int soSinhVien) {

        ThongTinSinhVien temp = null;
        for (int i = 0; i <= soSinhVien - 1; i++) {
            temp = QuanLySinhVien.A[i];
            if (temp == null) {
                continue;
            }
            if (thongTinSV.getMaSV() != null && temp.getMaSV() != null) {
                if (thongTinSV.getMaSV().equals(temp.getMaSV())) {
                    temp.setHoTen("Đồng Nát");
                    temp.setMaSV("B15417");
                    temp.setSoDT("016xxx");
                    temp.setDiaChi("Hà Nam");
                    temp.seteMail("a@.com");
                    break;
                }

            }
        }
    }

    public static void deleteSinhVien(String maSVien, int soSinhVien) {
        for (int i = 0; i <= soSinhVien - 1; i++) {
            if (A[i].getMaSV() != null && A[i].getMaSV().equals(maSVien)) {
                int j = i;
                for (j = i; j <= soSinhVien - 1; j++) {
                    A[j] = A[j + 1];
                }
            }

        }
    }

    public static void xuatSinhVien(int soSinhVien) {
        for (int i = 0; i < soSinhVien; i++) {
            System.out.println("\nThông tin sinh viên " + (i + 1));
            System.out.print("Họ Tên: " + A[i].getHoTen());
            System.out.println("");
            System.out.print("Mã Sinh Viên: " + A[i].getMaSV());
            System.out.println("");
            System.out.print("Số Điện thoại : " + A[i].getSoDT());
            System.out.println("");
            System.out.print("Địa Chỉ: " + A[i].getDiaChi());
            System.out.println("");
            System.out.print("Email: " + A[i].geteMail());
            System.out.println("");
        }

    }

}
