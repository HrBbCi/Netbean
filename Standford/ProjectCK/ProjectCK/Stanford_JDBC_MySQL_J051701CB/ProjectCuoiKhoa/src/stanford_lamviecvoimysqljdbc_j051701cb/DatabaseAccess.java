package stanford_lamviecvoimysqljdbc_j051701cb;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cuongvv
 */
public class DatabaseAccess {

    private static final String JDBC_DRIVER
            = "com.mysql.jdbc.Driver";
    private static final String DATABASE_PATH
            = "jdbc:mysql://localhost/j051701cb";

    /**
     * Kết nối cơ sở dữ liệu
     *
     * @return {@link Connection}
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(JDBC_DRIVER);

            // Kết nối database với đường dẫn, username, mật khẩu
            // chỉ định
            conn = DriverManager.getConnection(DATABASE_PATH,
                    "root", "kienphuong");
        } catch (Exception ex) {
            System.out.println("Lỗi khi kết nối DB: "
                    + ex.toString());
        }

        return conn;
    }
}
