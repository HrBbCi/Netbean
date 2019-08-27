/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class_Object_Excersice_Part_1.Ex_2;

/**
 *
 * @author neo
 */
public class SinhVien {
    private String id;
    private String name;
    private String sex;
    private String birthDay;
    private String phoneNumber;
    private String email;
    private String CMND;
    private String address;

    public SinhVien() {
    }
    
    public SinhVien(String id, String name, String sex, String birthDay, String phoneNumber, String email, String CMND, String address) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthDay = birthDay;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.CMND = CMND;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getCMND() {
        return CMND;
    }

    public String getAddress() {
        return address;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
    
    
}
