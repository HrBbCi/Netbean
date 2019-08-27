/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stanford_lamviecvoimysqljdbc_j051701cb.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import stanford_lamviecvoimysqljdbc_j051701cb.DatabaseAccess;
import stanford_lamviecvoimysqljdbc_j051701cb.model.ChuyenKhoa;



/**
 *
 * @author HrBbCi
 */
public class ChuyenKhoaBussiness {
    public  List<ChuyenKhoa> getAllChuyenKhoa(){
        List<ChuyenKhoa> lst = new ArrayList<>();
        Connection conn = DatabaseAccess.getConnection();
        try{
            String query ="SELECT * FROM chuyenkhoa";
            Statement st =conn.createStatement(); 
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                ChuyenKhoa ck = new ChuyenKhoa();
                ck.setChuyenKhoaID(rs.getInt("IDChuyenKhoa"));
                ck.setMaKhoa(rs.getString("MaKhoa"));
                ck.setTenKhoa(rs.getString("TenKhoa"));
                lst.add(ck);
            }
        }catch(Exception ex){
            System.out.println("Lỗi khi lấy CK : " +ex);
        }
        finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Lỗi khi đóng file" +ex);
            }
        }
        return lst;
    }
}
