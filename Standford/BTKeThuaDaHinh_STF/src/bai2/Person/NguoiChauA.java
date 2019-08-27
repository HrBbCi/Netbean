/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2.Person;

import java.util.Date;

/**
 *
 * @author HrBbCi
 */
public class NguoiChauA extends ConNguoi{
    private double chieuCaoTB = 1.6;
    private double canNangTb = 60;

    @Override
    public void tiengNoi() {
        System.out.println("Người châu Á nói tiếng Việt");
    }

    @Override
    public void tetNguyenDan() {
        System.out.println("Tết vào mùng 1/1 âm lịch");
    }
    
}
