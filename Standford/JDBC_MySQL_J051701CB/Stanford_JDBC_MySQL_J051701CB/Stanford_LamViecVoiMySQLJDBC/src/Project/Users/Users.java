/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project.Users;

import Project.SinhVien.SinhVien;

/**
 *
 * @author HrBbCi
 */
public class Users {
    private int id;
    private String username;
    private String password;

    private SinhVien SinhVienID;

    public SinhVien getSinhVienID() {
        return SinhVienID;
    }

    public void setSinhVienID(SinhVien SinhVienID) {
        this.SinhVienID = SinhVienID;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
