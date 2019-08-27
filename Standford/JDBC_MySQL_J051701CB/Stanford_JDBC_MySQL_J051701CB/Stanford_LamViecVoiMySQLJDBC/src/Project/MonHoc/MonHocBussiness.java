/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project.MonHoc;

import Project.ConnectDatabase.DatabaseAccess;
import Project.SinhVien.SinhVien;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HrBbCi
 */
public class MonHocBussiness {
    public List<MonHoc> getAllMaMH() {
        List<MonHoc> lst = new ArrayList<>();
        Connection conn = DatabaseAccess.getConnection();
        try {
            String query = "SELECT MaMH FROM monhoc";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                MonHoc mh = new MonHoc();
                mh.setMaMH(rs.getString("MaMH"));
                lst.add(mh);
            }
        } catch (Exception ex) {
            System.out.println("Lỗi khi lấy Mã MH : " + ex);
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
