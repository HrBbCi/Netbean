/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class_Object_Excersice_Part_1.Ex_3;

import java.util.Date;

/**
 *
 * @author neo
 */
public class stanfNguoiDung {
    // Id, FullName, Sex, Birthday,Mobile, Email, Website, UserName, Password, DateCreate,DateLastUpdate,Address, Note
    private String Id;
    private String FullName;
    private boolean Sex;
    private Date Birthday;
    private String Mobile;
    private String Email;
    private String Website;
    private String UserName;
    private String Password;
    private String DateCreate;
    private String DateLastUpdate;
    private String Address;
    private String Note;

    public stanfNguoiDung() {
    }

    public stanfNguoiDung(String Id, String FullName, boolean  Sex, Date Birthday, String Mobile, String Email, String Website, String UserName, String Password, String DateCreate, String DateLastUpdate, String Address, String Note) {
        this.Id = Id;
        this.FullName = FullName;
        this.Sex = Sex;
        this.Birthday = Birthday;
        this.Mobile = Mobile;
        this.Email = Email;
        this.Website = Website;
        this.UserName = UserName;
        this.Password = Password;
        this.DateCreate = DateCreate;
        this.DateLastUpdate = DateLastUpdate;
        this.Address = Address;
        this.Note = Note;
    }

    public String getId() {
        return Id;
    }

    public String getFullName() {
        return FullName;
    }

    public boolean getSex() {
        return Sex;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public String getMobile() {
        return Mobile;
    }

    public String getEmail() {
        return Email;
    }

    public String getWebsite() {
        return Website;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return Password;
    }

    public String getDateCreate() {
        return DateCreate;
    }

    public String getDateLastUpdate() {
        return DateLastUpdate;
    }

    public String getAddress() {
        return Address;
    }

    public String getNote() {
        return Note;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public void setSex(boolean Sex) {
        this.Sex = Sex;
    }

    public void setBirthday(Date Birthday) {
        this.Birthday = Birthday;
    }

    public void setMobile(String Mobile) {
        this.Mobile = Mobile;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setWebsite(String Website) {
        this.Website = Website;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setDateCreate(String DateCreate) {
        this.DateCreate = DateCreate;
    }

    public void setDateLastUpdate(String DateLastUpdate) {
        this.DateLastUpdate = DateLastUpdate;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }
    
    
    
}
