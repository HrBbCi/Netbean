package sinhvien;

public class SinhVien {

    public static void main(String[] args) throws Exception {
        QuanLySinhVien qlsv = new QuanLySinhVien();

        ThongTinSinhVien thongTin = new ThongTinSinhVien();
        int soSinhVien = 3;
        ThongTinSinhVien A[] = new ThongTinSinhVien[soSinhVien];

        qlsv.nhapDSSinhVien(soSinhVien);
        
        thongTin.setMaSV("1");
        qlsv.updateSinhVien(thongTin,soSinhVien);

        System.out.println("Danh sách sinh vAiên sau khi update: ");
        qlsv.xuatSinhVien(soSinhVien);
        System.out.println("");
        
        thongTin.setMaSV("123");
        System.out.println("Danh sách sau khi xóa: ");
        qlsv.deleteSinhVien("123",soSinhVien-1);
        qlsv.xuatSinhVien(soSinhVien-1);
        
        
        
        
        

    }

}
