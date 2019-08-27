package bai1.TinhToan;

/**
 *
 * @author HrBbCi
 * Xây dựng một lớp cơ sở có tên là TinhToan bao gồm các phương thức DienTich,
InThongTin sau đó tạo ra lớp HinhChuNhat, HinhTron, HinhThang để thực hiện tính
diện tích cho các hình này kế thừa từ lớp TinhToan.
 */
public class TinhToan {
    public double dienTich(){
        return 0;
    }
    public void inThongTin(){
        System.out.println(dienTich());
    }
}
