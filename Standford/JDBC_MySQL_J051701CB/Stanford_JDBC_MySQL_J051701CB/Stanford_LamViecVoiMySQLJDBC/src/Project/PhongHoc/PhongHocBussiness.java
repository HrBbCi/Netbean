/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project.PhongHoc;

import Project.ConnectDatabase.DatabaseAccess;
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
public class PhongHocBussiness {
    public List<PhongHoc> getAllMaP() {
        List<PhongHoc> lst = new ArrayList<>();
        Connection conn = DatabaseAccess.getConnection();
        try {
            String query = "SELECT MaPhong FROM phonghoc";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                PhongHoc ph = new PhongHoc();
                ph.setMaPhong(rs.getString("MaPhong"));
                lst.add(ph);
            }
        } catch (Exception ex) {
            System.out.println("Lỗi khi lấy Mã MP : " + ex);
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
