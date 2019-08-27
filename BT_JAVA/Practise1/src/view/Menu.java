
package view;

import controller.Manager;
import java.util.Scanner;

public class Menu {

    void show() {
        Scanner sc = new Scanner(System.in);
        int choice;
        Manager m = new Manager();
        m.docFile();
        do {
            System.out.println("========================");
            System.out.println("1. Nhap PTGT");
            System.out.println("2. Xuat PTGT");
            System.out.println("3. Sua PTGT");
            System.out.println("4. Tim Kiem");
            System.out.println("5. Sap Xep");
            System.out.println("6. Thong Ke");
            System.out.println("7. Xoa PT");
            System.out.println("0. Thoat");
            System.out.println("========================");
            System.out.print("Ban chon?");
            choice = Integer.parseInt(sc.nextLine());
            switch(choice){
                case 0: {
                    break;
                }
                case 1: {
                    int subchoice;
                    do {
                        System.out.println("----------------------");
                        System.out.println("1. Nhap Xe May");
                        System.out.println("2. Nhap Oto");
                        System.out.println("3. Nhap Xe Tai");
                        System.out.println("0. Tro ve");
                        System.out.println("----------------------");
                        System.out.print("Chon?");
                        subchoice = Integer.parseInt(sc.nextLine());
                        switch(subchoice){
                            case 0:{
                                break;
                            }
                            case 1:{
                                m.nhapXeMay();
                                break;
                            }
                            case 2:{
                                m.nhapOTo();
                                break;
                            }
                            case 3:{
                                m.nhapXeTai();
                                break;
                            }
                            default:{
                                System.out.println("Vui long nhap tu 0 - 3");
                                break;
                            }
                        }
                    } while (subchoice != 0);
                    
                    break;
                }
                case 2: {
                    m.xuatPT();
                    break;
                }
                case 3: {
                    m.suaPT();
                    break;
                }
                case 4: {
                    m.timPT();
                    break;
                }
                case 5: {
                    m.sapXep();
                    break;
                }
                case 6: {
                    m.thongKe();
                    break;
                }
                case 7: {
                    m.xoaPT();
                    break;
                }
                default: {
                    System.out.println("Vui long nhap tu 0-6");
                    break;
                }
            }
        } while (choice != 0);
        
    }
    
}
