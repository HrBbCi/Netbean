package abc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HrBbCi
 */
public class dataBaseAcess {
    private static  final String JDBC_DRIVER="com.mysql.jdbc.Driver";
    private static  final String DATABASE_PATH="jdbc:mysql://localhost/databasesv";
    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn =  DriverManager.getConnection(DATABASE_PATH, "root", "kienphuong");
        } catch (Exception ex) {
            System.out.println("Lỗi khi kết nối DB"+ex.toString());
        }
        return conn;
    }
}
