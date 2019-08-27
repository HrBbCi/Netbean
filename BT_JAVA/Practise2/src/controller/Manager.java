
package controller;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import model.*;


public class Manager {

    Scanner sc = new Scanner(System.in);
    FileIO file = new FileIO();
    ArrayList<Sach> listSach = new ArrayList<>();
    ArrayList<BanDoc> listBd = new ArrayList<>();
    ArrayList<QLMS> listQlms = new ArrayList<>();
    private final String pathSach = "src/controller/SACH.DAT";
    private final String pathBd = "src/controller/BD.DAT";
    private final String pathQlms = "src/controller/QLMS.DAT";
    String[] major = {"Khoa hoc tu nhien", "Van hoa - nghe thuat", "Dien tu vien thong", "Cong nghe thong tin"};
    int idSach = 10000;
    int idBd = 20000;

    public Manager() {
        docFile();
        getID();
    }

    void getID() {
        if (!listSach.isEmpty()) {
            for (Sach sach : listSach) {
                if (idSach <= sach.getMa()) {
                    idSach = sach.getMa() + 1;
                }
            }
        }

        if (!listBd.isEmpty()) {
            for (BanDoc bd : listBd) {
                if (idBd <= bd.getMaBd()) {
                    idBd = bd.getMaBd() + 1;
                }
            }
        }
    }

    void docFile() {
        file.readFile(listSach, pathSach);
        file.readFile(listBd, pathBd);
        file.readFile(listQlms, pathQlms);
    }

    void ghiFile() {
        file.writeFile(listSach, pathSach);
        file.writeFile(listBd, pathBd);
        file.writeFile(listQlms, pathQlms);
    }

    private void checkDate(String date) throws Validate {
        if (!date.matches("\\d{2}/\\d{4}")) {
            throw new Validate("Nhap dung dang MM/yyyy");
        }
    }

    public void checkPhone(String phone) throws Validate {
        if (!phone.matches("\\d{10}|\\d{11}")) {
            throw new Validate("SDT nhap vao khong dung dinh dang.");
        }
    }

    public void nhapSach() {
        Sach s = new Sach();
        s.setMa(idSach++);
        System.out.println("Nhap ten sach: ");
        s.setTen(sc.nextLine());
        System.out.println("Nhap tac gia: ");
        s.setTacGia(sc.nextLine());
        System.out.println("Chon chuyen nganh: ");
        for (int i = 0; i < major.length; i++) {
            System.out.println(i + 1 + ". " + major[i]);
        }
        int choice;
        do {
            System.out.print("Chon: ");
            choice = Integer.parseInt(sc.nextLine());
        } while (choice > 4 || choice < 1);
        s.setChuyenNganh(major[choice - 1]);
        while (true) {
            try {
                System.out.println("Nhap nam xuat ban: ");
                String temp = sc.nextLine();
                checkDate(temp);
                s.setNamXB(temp);
                break;
            } catch (Validate e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Nhap so luong: ");
        s.setSoLuong(Integer.parseInt(sc.nextLine()));
        listSach.add(s);
        ghiFile();
        System.out.println("Them sach thanh cong!");
    }

    public void inSach() {
        System.out.println("Danh sach sach hien co: ");
        for (Sach sach : listSach) {
            System.out.println(sach);
        }
    }

    public Sach find(int key) {
        for (Sach sach : listSach) {
            if (sach.getMa() == key) {
                return sach;
            }
        }
        return null;
    }

    public void xoaSach() {
        System.out.println("Nhap ma sach can xoa: ");
        int key = Integer.parseInt(sc.nextLine());
        Sach s = find(key);
        if (s == null) {
            System.out.println("Khong ton tai sach co ma " + key);
            return;
        }
        listSach.remove(s);
        ghiFile();
    }

    public void timKiem() {
        System.out.println("Nhap chuyen nganh sach: ");
        String key = sc.nextLine();
        for (Sach sach : listSach) {
            if (sach.getChuyenNganh().toLowerCase().contains(key.toLowerCase())) {
                System.out.println(sach.toString());
            }
        }
    }

    public void sapXep() {
        Comparator c = (Comparator<Sach>) (Sach o1, Sach o2) -> {
            String x = o1.getNamXB().substring(3) + o1.getNamXB();
            String y = o2.getNamXB().substring(3) + o2.getNamXB();
            return x.compareTo(y);
        };
        Collections.sort(listSach, c);
        inSach();
    }

    public void nhapBd() {
        BanDoc b = new BanDoc();
        b.setMaBd(idBd++);
        System.out.println("Nhap ten ban doc: ");
        b.setHoTen(sc.nextLine());
        System.out.println("Nhap dia chi: ");
        b.setDiaChi(sc.nextLine());
        while (true) {
            try {
                System.out.println("Nhap SDT (10-11 so): ");
                String temp = sc.nextLine();
                checkPhone(temp);
                b.setSoDt(temp);
                break;
            } catch (Validate e) {
                System.out.println(e.getMessage());
            }
        }
        listBd.add(b);
        ghiFile();
        System.out.println("Them ban doc thanh cong!");
    }

    public void inBd() {
        System.out.println("Danh sach ban doc: ");
        for (BanDoc bd : listBd) {
            System.out.println(bd);
        }
    }

    public void xoaBd(int key) {
        key--;
        listBd.remove(key);
        ghiFile();
    }

    public void nhapQLMS() {

        for (BanDoc b : listBd) {
            QLMS q = new QLMS();
            ArrayList<Sach> list = new ArrayList<>();
            System.out.println("Nhap thong tin muon sach cho ban doc:" + b);
            inSach();

            System.out.println("Nhap so luong sach can muon: ");
            int num;
            do {
                num = Integer.parseInt(sc.nextLine());
                if (num < 1 || num > listSach.size()) {
                    System.out.println("So luong nhap vao khong hop le.");
                }
            } while (num < 1 || num > listSach.size());

            for (int i = 1; i <= num; i++) {

                while (true) {
                    System.out.println("Nhap ma sach thu " + i);
                    int temp = Integer.parseInt(sc.nextLine());
                    if (q.isExist(temp)) {
                        System.out.println("Sach nay da duoc muon.");
                    } else {
                        if (find(temp) == null) {
                            System.out.println("Khong ton tai sach co ma " + temp);
                        } else {
                            list.add(find(temp));
                            break;
                        }
                    }
                }
            }

            q.setB(b);
            q.setList(list);
            listQlms.add(q);
            ghiFile();
            System.out.println("Cap nhat thanh cong!");
        }

    }

    public void inQLMS() {
        listQlms.forEach((q) -> {
            System.out.println(q);
        });
    }

}
