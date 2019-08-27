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
public class LoginControl {
    LoginModel user;
    LoginView view;
    
    public LoginControl(LoginModel user, LoginView view)
    {
        this.user = user;
        this.view = view;
        while(true)
        {
            view.getUserInfo();
            if(checkLogin())
            {
                view.showMessage("success!");
                break;
            }else
            {
                view.showMessage("wrong username or password!");
            }
        }
    }
    private boolean checkLogin()
    {
        if ((user.getUserName().equals("sa")) 
        &&(user.getPassword().equals("sa") ))
        {
            return true;
        }
        return false;
    }
}
