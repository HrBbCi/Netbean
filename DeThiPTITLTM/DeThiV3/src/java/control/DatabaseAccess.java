package control;

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
            System.out.println("Lỗi khi kết nối DB: "
                    + ex.toString());
        }
        return conn;
    }
}
