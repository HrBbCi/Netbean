package filetrongjava;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author cuongvv
 */
public class FileTrongJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Liệt kê file, folder trong ổ C
        listFileInFolder("C:\\");
        
        File f = new File("D:\\stanford.txt");

        System.out.println("File có tồn tại: " + f.exists());

        // Tạo file nếu không tồn tại
        if (!f.exists()) {
            try {
                f.createNewFile();
                System.out.println("Đường dẫn tới file: "
                        + f.getAbsolutePath());
            } catch (IOException ex) {
                System.out.println("Lỗi khi tạo file");
            }
        } // if

        // Đổi tên file
        System.out.println("Đổi tên file -> StanfordNew.txt");
        File newFile = new File("D:\\StanfordNew.txt");
        f.renameTo(newFile);
        System.out.println("File mới: " + f.getPath());
    }

    /**
     * Duyệt danh sách file theo đường dẫn chỉ định
     *
     * @param dir Đường dẫn
     */
    public static void listFileInFolder(String dir) {
        // Lấy ra danh sách tập tin cấp 1 của ổ C
        File cDisk = new File(dir);
        // Lấy về danh sách tập tin cấp 1
        String[] arr = cDisk.list();
        for (String fileName : arr) {
            File fileTemp = new File(dir, fileName);

            // Nếu là file
            if (fileTemp.isFile()) {
                System.out.println("File: "
                        + fileTemp.getAbsolutePath());
            } else if (fileTemp.isDirectory()) {
                // Nếu là thư mục
                // C1: Gọi đệ quy để list toàn bộ trong ổ C
//                listFileInFolder(fileTemp.getAbsolutePath());
                // C2: In kết quả
                System.out.println("Folder: " 
                        + fileTemp.getAbsolutePath());
            }
        } // for
    }
}
