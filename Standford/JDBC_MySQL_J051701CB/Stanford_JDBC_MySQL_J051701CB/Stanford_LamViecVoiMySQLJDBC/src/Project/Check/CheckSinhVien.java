/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project.Check;

import Project.SinhVien.SinhVienDao;
import Project.Users.UsersDao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 *
 * @author HrBbCi
 */
public abstract class CheckSinhVien<T, E> implements SinhVienDao<T, E>{

    public String getString(ResultSet rs, String columnName) {
        if (rs == null) {
            throw new IllegalArgumentException("ResultSet required not null");
        }

        try {
            return rs.getString(columnName);
        } catch (SQLException ex) {
            System.out.println("getString columnName method error: " + ex);
        }

        return "";
    }

    public String getString(ResultSet rs, int columnIndex) {
        if (rs == null) {
            throw new IllegalArgumentException("ResultSet required not null");
        }

        try {
            return rs.getString(columnIndex);
        } catch (SQLException ex) {
            System.out.println("getString columnIndex method error: " + ex);
        }

        return "";
    }

    /**
     * If the value is SQL NULL, the value returned is 0
     */
    public int getInt(ResultSet rs, String columnName) {
        if (rs == null) {
            throw new IllegalArgumentException("ResultSet required not null");
        }

        try {
            return rs.getInt(columnName);
        } catch (SQLException ex) {
            System.out.println("getInt columnName method error: " + ex);
        }

        return 0;
    }

    /**
     * If the value is SQL NULL, the value returned is 0
     */
    public int getInt(ResultSet rs, int columnIndex) {
        if (rs == null) {
            throw new IllegalArgumentException("ResultSet required not null");
        }

        try {
            return rs.getInt(columnIndex);
        } catch (SQLException ex) {
            System.out.println("getInt columnIndex method error: " + ex);
        }

        return 0;
    }

    public Date getDate(ResultSet rs, String columnName) {
        if (rs == null) {
            throw new IllegalArgumentException("ResultSet required not null");
        }

        try {
            return rs.getDate(columnName);
        } catch (SQLException ex) {
            System.out.println("getInt columnIndex method error: " + ex);
        }

        return new Date();
    }

    public Date getDate(ResultSet rs, int columnIndex) {
        if (rs == null) {
            throw new IllegalArgumentException("ResultSet required not null");
        }

        try {
            return rs.getDate(columnIndex);
        } catch (SQLException ex) {
            System.out.println("getInt columnIndex method error: " + ex);
        }

        return new Date();
    }

    public void closeCallableStatement(CallableStatement cst) {
        if (cst != null) {
            try {
                cst.close();
            } catch (SQLException ex) {
                System.out.println("closeCallableStatement method error: " + ex);
            }
        }
    }
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
    
    public void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println("closeConnection method error: " + ex);
            }
        }
    }
}
