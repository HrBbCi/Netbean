package stanford_lamviecvoimysqljdbc_j051701cb;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author cuongvv
 */
public class Stanford_LamViecVoiMySQLJDBC_J051701CB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Test thử có kết nối được đến DB
        Connection conn = DatabaseAccess.getConnection();

        try {
            if (conn != null && !conn.isClosed()) {
                System.out.println("Kết nối database thành công");
            } else {
                System.out.println("Kết nối DB thất bại");
            }
        } catch (SQLException ex) {
        }
    } // could not load main class
}
