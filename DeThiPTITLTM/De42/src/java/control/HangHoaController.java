/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.*;
import db.DB;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.HangHoa;

/**
 *
 * @author HrBbCi
 */
public class HangHoaController implements DAO {

    @Override
    public boolean updateHH(HangHoa h) {
        String SQL = "UPDATE hanghoa SET ten ='" + h.getTenHH() + "', gia='" + h.getGia() + "'";
        SQL += " WHERE idhanghoa='" + h.getIdHangHoa() + "'";
        Connection con = DB.getConnection();
        Statement st = null;
        try {
            st =  con.createStatement();
            return st.executeUpdate(SQL) > 0;
        } catch (SQLException ex) {
        }
        return false;
    }

    @Override
    public HangHoa findByID(String id) {
        String SQL ="Select * from hanghoa where idhanghoa='"+id+"'";
        Connection con = DB.getConnection();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery(SQL);
            HangHoa hh = null;
            while(rs.next()){
                hh = new HangHoa();
                hh.setIdHangHoa(rs.getString("idhanghoa"));
                hh.setTenHH(rs.getString("ten"));
                hh.setGia(rs.getFloat("gia"));
            }
            return hh;
        } catch (SQLException ex) {
        }
        return null;
    }

    @Override
    public List<HangHoa> findByIDList(String id) {
        List<HangHoa> listhh = new ArrayList<>();
        String SQL ="Select * from hanghoa where idhanghoa like '%"+id+"%'";
        Connection con = DB.getConnection();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery(SQL);
            HangHoa hh = null;
            while(rs.next()){
                hh = new HangHoa();
                hh.setIdHangHoa(rs.getString("idhanghoa"));
                hh.setTenHH(rs.getString("ten"));
                hh.setGia(rs.getFloat("gia"));
                listhh.add(hh);
            }
        } catch (SQLException ex) {
        }
        return listhh;
    }

}
