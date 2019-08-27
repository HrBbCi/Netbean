import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
/*
* Login.java
*
* Created on September 17, 2012, 8:15 PM
*
* To change this template, choose Tools | Template Manager
* and open the template in the editor.
*/

/**
*
* @author SITUVNX
*/
public class NewClass extends  JFrame{

    JLabel lbl_Username;
    JLabel lbl_Password;
    JTextField txt_Username;
    JPasswordField pwd_Password;
    JButton btn_Login;
    JButton btn_One;
    JButton btn_Two;

    String url;
    Connection con;

    public NewClass() {
        super("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lbl_Username = new JLabel("Username:");
        lbl_Username.setHorizontalAlignment(JLabel.RIGHT);

        lbl_Password = new JLabel("Password:");
        lbl_Password.setHorizontalAlignment(JLabel.RIGHT);

        txt_Username = new JTextField();

        pwd_Password = new JPasswordField();

        btn_Login = new JButton("Login");

        btn_One = new JButton("One");
        btn_One.setEnabled(false);

        btn_Two = new JButton("Two");
        btn_Two.setEnabled(false);

        createConnection();

        setLayout();
        setCenter();
        setListener();
    }

    private static final String JDBC_DRIVER
            = "com.mysql.jdbc.Driver";
    private static final String DATABASE_PATH
            = "jdbc:mysql://localhost/j051701cb";
    public Connection createConnection() {
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

    private void setLayout() {
        GroupLayout layout = new GroupLayout(getContentPane());

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                .addContainerGap()
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, 12)
                .addGroup(
                    layout.createParallelGroup()
                    .addComponent(lbl_Username, 20, 20, 20)
                    .addComponent(txt_Username, 20, 20, 20))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(
                    layout.createParallelGroup()
                    .addComponent(lbl_Password, 20, 20, 20)
                    .addComponent(pwd_Password, 20, 20, 20))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btn_Login)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(
                    layout.createParallelGroup()
                    .addComponent(btn_One)
                    .addComponent(btn_Two))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, 12)
                .addContainerGap());

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(
                    layout.createParallelGroup()
                        .addGroup(
                        layout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(lbl_Username, 100, 100, 100)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_Username, 200, 200, 200)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE))
                    .addGroup(
                        layout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(lbl_Password, 100, 100, 100)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pwd_Password, 200, 200, 200)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE))
                    .addGroup(
                        layout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(btn_Login, 100, 100, 100)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE))
                    .addGroup(
                        layout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(btn_One)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Two)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)))
                .addContainerGap());

        setLayout(layout);
        pack();
        setMinimumSize(getContentPane().getSize());
    }

    private void setListener() {
        btn_Login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (txt_Username.getText().equals("") || new String(pwd_Password.getPassword()).equals("")) {
                    JOptionPane.showMessageDialog(NewClass.this, "Username and password must not empty.", "Invalid", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    ResultSet res = con.createStatement().executeQuery(String.format("select * from UsersX where Username = '%s' and Password = '%s'", txt_Username.getText(), new String(pwd_Password.getPassword())));

                    if (res != null) {
                        if (res.next()) {
                            if (res.getString("Password").equals(new String(pwd_Password.getPassword()))) {
                                JOptionPane.showMessageDialog(NewClass.this, "You has been login successful.", "login successfuly", JOptionPane.INFORMATION_MESSAGE);
                                // Login successful DO SOMETHING HERE

                                btn_One.setEnabled(true);
                                btn_Two.setEnabled(true);
                            } else {
                                JOptionPane.showMessageDialog(NewClass.this, "Password is match case.", "Login failed", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(NewClass.this, "Wrong username or password.", "Login failed", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });
    }

    private void setCenter() {
        int height = this.getSize().height;
        int width = this.getSize().width;
        Toolkit tool = Toolkit.getDefaultToolkit();
        int x = (tool.getScreenSize().width - (width = (tool.getScreenSize().width < width ? tool.getScreenSize().width : width)))/2;
        int y = (tool.getScreenSize().height - (height = (tool.getScreenSize().height < height ? tool.getScreenSize().height : height)))/2;
        this.setLocation(x, y);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewClass().setVisible(true);
            }
        });
    }
}