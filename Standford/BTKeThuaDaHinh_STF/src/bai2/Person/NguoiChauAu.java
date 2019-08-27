/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2.Person;

/**
 *
 * @author HrBbCi
 */
public class NguoiChauAu extends ConNguoi{
    private double chieuCaoTB = 1.75;
    private double canNangTb = 70;

    @Override
    public void tiengNoi() {
        System.out.println("Người châu Âu nói tiếng anh");
    }

    @Override
    public void tetNguyenDan() {
        System.out.println("Tết vào 1/1 dương lịch");
    }
    
    
}
