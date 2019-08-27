
package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import model.*;


public class Manager {

    ArrayList<PTGT> list = new ArrayList<>();
    FileIO file = new FileIO();
    Scanner sc = new Scanner(System.in);

    public Manager() {
    }

    public void docFile() {
        file.readFile(list, "src/controller/PTGT.dat");
    }

    public void ghiFile() {
        file.writeFile(list, "src/controller/PTGT.dat");
    }

    private PTGT find(String key) {
        for (PTGT ptgt : list) {
            if (ptgt.getMa().equals(key)) {
                return ptgt;
            }
        }
        return null;
    }

    public PTGT nhapPT(){
        PTGT p = new PTGT();
        System.out.println("Nhap ma: ");
        while (true) {
            String temp = sc.nextLine();
            if (find(temp) != null) {
                System.out.println("Ma da ton tai.");
            } else {
                p.setMa(temp);
                break;
            }
        }
        System.out.println("Nhap hang sx: ");
        p.setHangsx(sc.nextLine());
        System.out.println("Nhap nam sx (MM/yyyy):");
        while (true) {
            String temp = sc.nextLine();
            if (temp.matches("\\d{2}/\\d{4}")) {
                p.setNamsx(temp);
                break;
            } else {
                System.out.println("Nhap dung dinh dang MM/yyyy");
            }
        }
        System.out.println("Nhap gia ban: ");
        p.setGiaban(sc.nextLine());
        System.out.println("Nhap mau xe: ");
        p.setMau(sc.nextLine());
        return p;
    }

    public void nhapXeMay() {
        PTGT p = nhapPT();
        System.out.println("Nhap cong suat: ");
        String congsuat = sc.nextLine();
        XeMay xm = new XeMay(congsuat, p.getMa(), p.getHangsx(), p.getNamsx(), p.getGiaban(), p.getMau());
        list.add(xm);
        ghiFile();
    }

    public void nhapOTo() {
        PTGT p = nhapPT();
        System.out.println("Nhap dong co: ");
        String dongco = sc.nextLine();
        System.out.println("Nhap so ghe: ");
        String soghe = sc.nextLine();
        OTo ot = new OTo(dongco, soghe, p.getMa(), p.getHangsx(), p.getNamsx(), p.getGiaban(), p.getMau());
        list.add(ot);
        ghiFile();
    }

    public void nhapXeTai() {
        PTGT p = nhapPT();
        System.out.println("Nhap trong tai: ");
        String trongtai = sc.nextLine();
        XeTai xt = new XeTai(trongtai, p.getMa(), p.getHangsx(), p.getNamsx(), p.getGiaban(), p.getMau());
        list.add(xt);
        ghiFile();
    }
    public void xoaPT(){
        System.out.println("Nhap STT can xoa");
        int id = sc.nextInt();
        id--;
        list.remove(id);
        ghiFile();
        System.out.println("Xoa thanh cong.");
    }

    public void timPT() {
        boolean found = false;
        System.out.println("Nhap hang can tim: ");
        String key = sc.nextLine();
        for (PTGT ptgt : list) {
            if (ptgt.getHangsx().toLowerCase().contains(key.toLowerCase())) {
                found = true;
                System.out.println(ptgt.toString());
            }
        }
        if (!found) System.out.println("Khong tim thay phuong tien nao.");
    }

    public void suaPT() {
        System.out.println("Nhap ma xe can sua: ");
        String key = sc.nextLine();
        PTGT x = find(key);
        if (x == null) {
            System.out.println("Khong tim thay.");
            return;
        }
        if (x instanceof XeMay) {
            PTGT p = nhapPT();
            System.out.println("Nhap cong suat: ");
            String congsuat = sc.nextLine();
            XeMay xm = new XeMay(congsuat, p.getMa(), p.getHangsx(), p.getNamsx(), p.getGiaban(), p.getMau());
            list.set(list.indexOf(x), xm);
            ghiFile();
            System.out.println("Sua thanh cong");
        } else if (x instanceof OTo) {
            PTGT p = nhapPT();
            System.out.println("Nhap dong co: ");
            String dongco = sc.nextLine();
            System.out.println("Nhap so ghe: ");
            String soghe = sc.nextLine();
            OTo ot = new OTo(dongco, soghe, p.getMa(), p.getHangsx(), p.getNamsx(), p.getGiaban(), p.getMau());
            list.set(list.indexOf(x), ot);
            ghiFile();
            System.out.println("Sua thanh cong");
        } else if (x instanceof XeTai) {
            PTGT p = nhapPT();
            System.out.println("Nhap trong tai: ");
            String trongtai = sc.nextLine();
            XeTai xt = new XeTai(trongtai, p.getMa(), p.getHangsx(), p.getNamsx(), p.getGiaban(), p.getMau());
            list.set(list.indexOf(x), xt);
            ghiFile();
            System.out.println("Sua thanh cong.");
        }
    }
    
    public void xuatPT() {
        System.out.println("Danh sach PTGT:");
        int k = 1;
        for (PTGT ptgt : list) {
            System.out.println(k + ". " + ptgt.toString());
            k++;
        }
        System.out.println("Tong so phuong tien la: " + list.size());
    }

    public void sapXep() {
        System.out.println("Danh sach sau khi sap xep theo gia ban:");
        Collections.sort(list, new Comparator<PTGT>() {
            @Override
            public int compare(PTGT o1, PTGT o2) {
                return Integer.parseInt(o1.getGiaban()) < Integer.parseInt(o2.getGiaban()) ? -1 : Integer.parseInt(o1.getGiaban()) > Integer.parseInt(o2.getGiaban()) ? 1 : 0;
            }
        });
        xuatPT();
    }

    public void thongKe() {
        ArrayList<String> year = new ArrayList<>();
        for (PTGT ptgt : list) {
            String temp = ptgt.getNamsx().substring(3);
            if (!year.contains(temp)) {
                year.add(temp);
            }
        }
        Collections.sort(year);
        for (String string : year) {
            int soXe = 0, tongGia = 0;
            for (PTGT ptgt : list) {
                if (ptgt.getNamsx().contains(string)) {
                    soXe++;
                    tongGia += Integer.parseInt(ptgt.getGiaban());
                }
            }
            System.out.println("Nam: " + string);
            System.out.println("So xe: " + soXe);
            System.out.println("Gia TB: " + (double) tongGia / soXe);

        }
    }
}
