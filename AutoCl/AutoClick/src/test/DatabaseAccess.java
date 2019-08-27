package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseAccess {

    private static final String JDBC_DRIVER
            = "com.mysql.jdbc.Driver";
    private static final String DATABASE_PATH
            = "jdbc:mysql://localhost/d41qlhanghoa";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DATABASE_PATH,
                    "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
        }
        return conn;
    }

    public static void main(String[] args) {
        Connection conn = DatabaseAccess.getConnection();

        try {
            if (conn != null && !conn.isClosed()) {
                System.out.println("Kết nối database thành công");
            } else {
                System.out.println("Kết nối DB thất bại");
            }
        } catch (SQLException ex) {
        }
    }
}
