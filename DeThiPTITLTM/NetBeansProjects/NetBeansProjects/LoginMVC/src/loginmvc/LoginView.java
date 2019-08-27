/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginmvc;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author LENPOVO
 */
public class LoginView {
    LoginModel user;
    public LoginView(LoginModel user){
    this.user = user;
    }
    public void showMessage(String smg){
    System.out.println(smg);
    }
    
    public void getUserInfo()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Username: ");
        user.setUserName(input.nextLine());
        System.out.print("Password: ");
        user.setPassword(input.nextLine());
        input.close();
    }
}
