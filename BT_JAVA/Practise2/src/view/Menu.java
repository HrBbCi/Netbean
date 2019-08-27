
package view;

import controller.Manager;
import java.util.Scanner;

public class Menu {

    void show() {
        Scanner sc = new Scanner(System.in);
        int choice;
        Manager m = new Manager();
        do {
            System.out.println("=============MENU============");
            System.out.println("1. Nhap them sach");
            System.out.println("2. In DS sach");
            System.out.println("3. Xoa sach");
            System.out.println("4. Tim kiem sach");
            System.out.println("5. Sap xep theo nam XB");
            System.out.println("6. Nhap them ban doc");
            System.out.println("7. In DS ban doc");
            System.out.println("8. Nhap QLMS");
            System.out.println("9. In QLMS");
            System.out.println("0. Thoat");
            System.out.println("=============================");
            System.out.println("Ban chon? ");
            choice = Integer.parseInt(sc.nextLine());
            switch(choice){
                case 1:{
                    m.nhapSach();
                    break;
                }
                case 2:{
                    m.inSach();
                    break;
                }
                case 3:{
                    m.xoaSach();
                    break;
                }
                case 4:{
                    m.timKiem();
                    break;
                }
                case 5:{
                    m.sapXep();
                    break;
                }
                case 6:{
                    m.nhapBd();
                    break;
                }
                case 7:{
                    m.inBd();
                    break;
                }
                case 8:{
                    m.nhapQLMS();
                    break;
                }
                case 9:{
                    m.inQLMS();
                    break;
                }
                case 0:{
                    break;
                }
                default:{
                    System.out.println("Vui long nhap tu 0-9");
                    break;
                }
            }
        } while (choice != 0);
        
    }
    
}
