/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project.Khoa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Project.ConnectDatabase.DatabaseAccess;
import Project.Khoa.ChuyenKhoa;
import Project.SinhVien.SinhVien;

/**
 *
 * @author HrBbCi
 */
public class ChuyenKhoaBussiness {

    public static ChuyenKhoaBussiness instance;

    public synchronized static ChuyenKhoaBussiness getInstance() {
        if (instance == null) {
            instance = new ChuyenKhoaBussiness();
        }
        return instance;
    }

    public List<ChuyenKhoa> getAllChuyenKhoa() {
        List<ChuyenKhoa> lst = new ArrayList<>();
        Connection conn = DatabaseAccess.getConnection();
        try {
            String query = "SELECT * FROM chuyenkhoa";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                ChuyenKhoa ck = new ChuyenKhoa();
                ck.setChuyenKhoaID(rs.getInt("IDChuyenKhoa"));
                ck.setMaKhoa(rs.getString("MaKhoa"));
                ck.setTenKhoa(rs.getString("TenKhoa"));
                lst.add(ck);
            }
        } catch (Exception ex) {
            System.out.println("Lỗi khi lấy CK : " + ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Lỗi khi đóng file" + ex);
            }
        }
        return lst;
    }

    
}
