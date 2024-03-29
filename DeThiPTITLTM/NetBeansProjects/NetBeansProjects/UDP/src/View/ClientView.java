/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import Model.User;
import Control.ClientControl;
/**
 *
 * @author LENPOVO
 */
public class ClientView extends JFrame implements ActionListener{
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    
    public ClientView()
    {
        super("UDP Login MVC");
        txtUsername = new JTextField(15);
        txtPassword = new JPasswordField(15);
        txtPassword.setEchoChar('*');
        btnLogin = new JButton("Login");
        JPanel content = new JPanel();
        content.setLayout(new FlowLayout());
        content.add(new JLabel("Username:"));
        content.add(txtUsername);
        content.add(new JLabel("Password:"));
        btnLogin.addActionListener(this);
        content.add(txtPassword);
        content.add(btnLogin);

        this.setContentPane(content);
        this.pack();
        this.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        }
        );
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(btnLogin)){
        User user = new User(txtUsername.getText(),txtPassword.getText());
        ClientControl clientCtr = new ClientControl();
        clientCtr.openConnection();                 
        clientCtr.sendData(user);

        String result = clientCtr.receiveData();
                    if(result.equals("ok")) 
                     showMessage("Login succesfully!");
             else
             showMessage("Invalid username and/or password!");
                    clientCtr.closeConnection();
        }
    }
    public void showMessage(String msg){
        JOptionPane.showMessageDialog(this, msg);
    }
}
