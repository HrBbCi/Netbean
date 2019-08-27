package kiemtralan2.abc.com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.lang.NumberFormatException;
import java.util.Arrays;
import java.util.Collections;
import static java.util.Collections.sort;
import java.util.Comparator;
import kiemtralan2.abc.com.file.FileType;

public class FileAction {

    public FileAction() {
        
    }
    public int dem = 0;
    public static FileAction instance;

    private List<ThiSinh> lstSinhVien = new ArrayList<>();

    public synchronized static FileAction getInstance() {
        if (instance == null) {
            instance = new FileAction();
        }
        return instance;
    }

    public List<ThiSinh> getListStudents() {
        return lstSinhVien;
    }

    public int Demm() {
        return dem;
    }

    public static Date convertToDate(String input) {
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yy");
        try {
            return f.parse(input);
        } catch (ParseException ex) {
            System.err.println("Có lỗi khi chuyển đổi date. Chi tiết: " + ex.getMessage());
        }
        return null;
    }

    public ThiSinh getThiSinhByMa(int soBD) {
        ThiSinh ts = new ThiSinh();
        for (int i = 0; i < lstSinhVien.size(); i++) {
            ts = this.lstSinhVien.get(i);
            if (ts.getSoBD()== soBD) {
                return ts;
            }
        }
        return null;
    }

    public void taoDuLieu(String path) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        File f = new File(path);
        String s = FileType.readString(f);
        
        String[] arr = s.split("\n");
        try { 
            for (int i = 0; i < arr.length; i++) {
                String a[] = arr[i].split(";");
                if (a[2].equals("1")) {
                    a[2] = "Nữ";
                }
                if (a[2].equals("0")) {
                    a[2] = "Nam";
                }
                ThiSinh ts = new ThiSinh();
                ts.setSoBD(Integer.parseInt(a[0]));
                ts.setHoTen(a[1]);
                ts.setGioiTinh(a[2]);
                ts.setNgaySinh(sdf.parse(a[3]));
                ts.setQueQuan(a[4]);
                ts.setdToan(Double.parseDouble(a[5]));
                ts.setdLy(Double.parseDouble(a[6]));
                ts.setdHoa(Double.parseDouble(a[7]));
                ts.setTongDiem(Double.parseDouble(a[5]) + Double.parseDouble(a[6])
                        + Double.parseDouble(a[7]));
                lstSinhVien.add(ts);
                dem++;
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
       
    }

    public boolean themMoiSinhVien(ThiSinh objSinhVien) {
        if (objSinhVien == null) {
            return false;
        }
        this.lstSinhVien.add(objSinhVien);
        return true;
    }

    public boolean kiemTra(int soBD) {
        ThiSinh temp = new ThiSinh();
        for (int i = 0; i < lstSinhVien.size(); i++) {
            temp = this.lstSinhVien.get(i);
            if (temp.getSoBD()==soBD) {
                return false;
            }
        }
        return true;
    }

    public boolean suaSinhVien(ThiSinh sv) {
        if (sv == null) {
            return false;
        }
        ThiSinh temp = null;
        for (int i = 0; i < lstSinhVien.size(); i++) {
            temp = lstSinhVien.get(i);
            if ((sv.getSoBD()+"") != null) {
                if (temp.getSoBD()==sv.getSoBD()) {
                    temp.setHoTen(sv.getHoTen());
                    temp.setNgaySinh(sv.getNgaySinh());
                    temp.setGioiTinh(sv.getGioiTinh());
                    temp.setQueQuan(sv.getQueQuan());
                    temp.setdToan(sv.getdToan());
                    temp.setdLy(sv.getdLy());
                    temp.setdHoa(sv.getdHoa());
                    temp.setTongDiem(sv.getdToan()+sv.getdLy()+sv.getdHoa());
                    return true;
                }
            }
        }
        return false;
    }

    public boolean Xoa(int soBD) {
      
        ThiSinh sv = new ThiSinh();
        for (int i = 0; i < this.lstSinhVien.size(); i++) {
            sv = this.lstSinhVien.get(i);
            if (sv.getSoBD()==soBD) {
                this.lstSinhVien.remove(sv);
                return true;
            }
        }
        return false;
    }

    public List<ThiSinh> findDiemSan() {
        List<ThiSinh> ls = new ArrayList<>();
        ThiSinh sv;
        for (int i = 0; i < lstSinhVien.size(); i++) {
            sv = lstSinhVien.get(i);
            if (sv.isDatDiemSan()) {
                ls.add(sv);
            }
        }
        return ls;
    }

    public List<ThiSinh> findDiemLiet() {
        List<ThiSinh> ls = new ArrayList<>();
        ThiSinh sv;
        for (int i = 0; i < lstSinhVien.size(); i++) {
            sv = lstSinhVien.get(i);
            if (sv.isDatDiemLiet()) {
                ls.add(sv);
            }
        }
        return ls;
    }

    public void sapXepTongDiemTangDan(){
        Collections.sort(lstSinhVien, new Comparator<ThiSinh>() {
            @Override
            public int compare(ThiSinh o1, ThiSinh o2) {
                return (int)(o2.getTongDiemChung()-o1.getTongDiemChung());
            }
        });
    }
    public List<ThiSinh> findTop5() {
        sapXepTongDiemTangDan();
        if(lstSinhVien.size() >5){
        return lstSinhVien.subList(0, 5);
        }
        else{
            return lstSinhVien;
        }
    }

}
