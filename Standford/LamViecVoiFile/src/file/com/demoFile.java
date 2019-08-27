package file.com;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class demoFile {

    public static void main(String[] args) {
        //Liệt kê file ổ C
        listFileInFolder("C:\\");
        System.out.println("");
        File f = new File("D:\\abc1.txt");

        System.out.println("File tồn tại " + f.exists());

        //Tạo file nếu ko tồn tại
        if (!f.exists()) {
            try {
                f.createNewFile();
                System.out.println("" + f.getAbsolutePath());

            } catch (IOException ex) {
                System.out.println("ERROR");
            }
        }
        //Đổi tên
//        System.out.println("Đổi tên FIle -> love.txt");
//        File newF = new File("D:\\love.txt");

//        f.renameTo(newF);
//        System.out.println("File mới: "+f.getPath());
    }

    public static void listFileInFolder(String dir) {
        //Lấy danh sachs 
        File cDisk = new File(dir);
        //Lây danh sách tập tin cấp 1
        String[] ar = cDisk.list();
        for (String fileN : ar) {
            File fileT = new File(dir, fileN);
            //Nếu là file
            if (fileT.isFile()) {
                System.out.println("File: " + fileT.getAbsolutePath());
            } else if (fileT.isDirectory()) {
                //Nếu là thư mục 
                //C1 : Gọi đệ quy để list toàn bộ file
                //listFileInFolder(fileT.getAbsolutePath());
                //C2:In kết quả
                System.out.println("Folder : " + fileT.getAbsolutePath());
            }
        }
    }
}
