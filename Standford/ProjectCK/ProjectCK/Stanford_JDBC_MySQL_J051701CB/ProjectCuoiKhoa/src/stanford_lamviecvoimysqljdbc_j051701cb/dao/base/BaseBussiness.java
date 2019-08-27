/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stanford_lamviecvoimysqljdbc_j051701cb.dao.base;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author HrBbCi
 */
public abstract class BaseBussiness<T, E> implements IBaseBussiness<T, E>{

    public void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException ex) {
                System.out.println("Lỗi khi đóng statement: " + ex);
            }
        }
    }
    public void closeResult(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                System.out.println("Lỗi khi đóng ResultSet: " + ex);
            }
        }
    }
}
