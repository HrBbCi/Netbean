/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kethuadahinh.view;

import kethuadahinh.demoDaHinh.Dog;
import kethuadahinh.demoDaHinh.Cat;
import kethuadahinh.hinh.HinhTron;
import kethuadahinh.hinh.HinhTron1;
import kethuadahinh.hinh.hinhChuNhat;

/**
 *
 * @author HrBbCi
 */
public class KeThuaDaHinh {
    public static void main(String[] args) {
        Cat ct = new Cat();
        
        ct.setSoMat(2);
        ct.setSoChan(4);
        ct.setMauLong("xám");
        System.out.println("Thông tin mèo: ");
        System.out.println("Số mắt: "+ct.getSoMat());
        System.out.println("Số chân: "+ct.getSoChan());
        System.out.println("Màu lông: "+ct.getMauLong());
        System.out.println("Tiếng kêu: "+ct.tiengKeu());
        Dog dg = new Dog();
        
        dg.setSoMat(2);
        dg.setSoChan(4);
        dg.setMauLong("đen");
        dg.setBietBoi(true);
        System.out.println("Thông tin chó: ");
        System.out.println("Số mắt: "+dg.getSoMat());
        System.out.println("Số chân: "+dg.getSoChan());
        System.out.println("Màu lông: "+dg.getMauLong());
        if(dg.isBietBoi())
            System.out.println("Biết bơi: Có");
        else
            System.out.println("Biết bơi: Không");
        System.out.println("Tiếng kêu :" +dg.tiengKeu());
        dg.Sua();
        
        hinhChuNhat hcn = new hinhChuNhat(4, 3);
        hcn.inThongTin();
        
        HinhTron ht = new HinhTron(3);
        ht.inThongTin();
        
        HinhTron1 h1 = new HinhTron1(2);
        h1.inThongTin();
    }
}
