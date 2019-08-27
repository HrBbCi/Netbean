/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginmvc;

/**
 *
 * @author LENPOVO
 */
public class LoginMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LoginModel user = new LoginModel();
        LoginView view = new LoginView(user);
        LoginControl control = new LoginControl(user, view);
    }
    
}
