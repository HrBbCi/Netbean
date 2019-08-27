
package sof203_assignment1_ps04271;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.Number;
/**
 *
 * @author Rjk Rắc Rối PS04271
 */
public class QuanLySinhVien extends javax.swing.JFrame {

    String manv="";
    int loaitaikkhoan=-1;
    int checkdangnhap = 0;
    DefaultListModel b = new DefaultListModel();
    String dvsql="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String urldb = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=quanlysinhvien;user=sa;password=123456";
    String [] title = {"Mã sinh viên","Tên Sinh Viên","Giới tính","Ngày Sinh","CMND","Email","Địa Chỉ","Ngày Nhập Học"};
    DefaultTableModel bang = new DefaultTableModel(title,0);
    ButtonGroup gioitinh1 = new ButtonGroup();
    ButtonGroup gioitinhdttk = new ButtonGroup();
    ButtonGroup ccmail = new ButtonGroup();
    String tennv="";
    String [] linkdinhkem=new String [1000];
    int slfile=0;
    String [] linkdinhkemall = new String[1000];
    int sllink=0;
    ButtonGroup ccall = new ButtonGroup();
    
    
    public QuanLySinhVien() {
        initComponents();
        jFrameDangNhap.setVisible(true);
        this.setLocationRelativeTo(null);
        jFrameDangNhap.setLocationRelativeTo(this);
        jFrametaotaikhoan.setLocationRelativeTo(this);
        tbthongtin.setModel(bang);
        gioitinh1.add(rbdtnu);
        gioitinh1.add(rbdtnam);
        quyen(false);
        jFramedoimatkhau.setLocationRelativeTo(this);
        jFramequanlymk.setLocationRelativeTo(this);
        dungpopup();
        btnlopthemsv.setEnabled(false);
        btnlopxoasv.setEnabled(false);
        jMenuquanlymatkhau.setEnabled(false);
        jMenuthongtinnhanvien.setEnabled(false);
        btngvdong.setEnabled(false);
        btndtdong.setEnabled(false);
        btnldong.setEnabled(false);
        jFramegvtimkiem.setLocationRelativeTo(this);
        gioitinhdttk.add(rbdttknam);
        gioitinhdttk.add(rbdttknu);
        gioitinhdttk.add(rbdttkcahai);
        jFramedttimkiem.setLocationRelativeTo(this);
        jFrameguimailgv1sv.setLocationRelativeTo(this);
        ccmail.add(rbgmdtbcc);ccmail.add(rbgmdtcc);
        jFrameguimailall.setLocationRelativeTo(this);
        ccall.add(rbcc);
        ccall.add(rbbcc);
        jMenudulieu.setEnabled(false);
        jFrameguimailgvnhieusv.setLocationRelativeTo(this);
        txtqlnvemail.setEditable(false);
        jFramequenmatkhau.setLocationRelativeTo(jFrameDangNhap);
        
        
    }
    
            
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrameDangNhap = new javax.swing.JFrame();
        lbdnquenmk = new javax.swing.JLabel();
        txtdntaikhoan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtdndangnhap = new javax.swing.JButton();
        txtdnmatkhau = new javax.swing.JPasswordField();
        txtdnthoat = new javax.swing.JButton();
        PanelDangNhap = new javax.swing.JLabel();
        BackgroundDangNhap = new javax.swing.JLabel();
        jFrametaotaikhoan = new javax.swing.JFrame();
        jLabel14 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        cbtaoloai = new javax.swing.JComboBox<>();
        txttaotkmanv = new javax.swing.JTextField();
        txttaotktennv = new javax.swing.JTextField();
        passtaotkmatkhau = new javax.swing.JPasswordField();
        passtaotknhaplaimk = new javax.swing.JPasswordField();
        btntaotktao = new javax.swing.JButton();
        btntaotkthoat = new javax.swing.JButton();
        jFramedoimatkhau = new javax.swing.JFrame();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        passdmkmkcu = new javax.swing.JPasswordField();
        passdmkmkmoi = new javax.swing.JPasswordField();
        passdmknhaplai = new javax.swing.JPasswordField();
        btndmkdoimk = new javax.swing.JButton();
        puhinh = new javax.swing.JPopupMenu();
        jFramequanlymk = new javax.swing.JFrame();
        jLabel25 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        txtqlmkmkmoi = new javax.swing.JPasswordField();
        cbqlmktaikhoan = new javax.swing.JComboBox<>();
        btnqlmkdoi = new javax.swing.JButton();
        btnqlmkdong = new javax.swing.JButton();
        jFramethongtinnhanvien = new javax.swing.JFrame();
        jLabel42 = new javax.swing.JLabel();
        lbqlnvhinh = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        txtqlnvtennv = new javax.swing.JTextField();
        txtqlnvma = new javax.swing.JTextField();
        cbqlnvchucvu = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbqlnv = new javax.swing.JTable();
        btnqlnvthaydoi = new javax.swing.JButton();
        btnqlnvdong = new javax.swing.JButton();
        btnqlnvxoa = new javax.swing.JButton();
        jLabel88 = new javax.swing.JLabel();
        txtqlnvemail = new javax.swing.JTextField();
        puhinhnv = new javax.swing.JPopupMenu();
        jFramegvtimkiem = new javax.swing.JFrame();
        jLabel43 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        cbgvtkpheptoan = new javax.swing.JComboBox<>();
        txtgvtkmasv = new javax.swing.JTextField();
        txtgvtktensv = new javax.swing.JTextField();
        txtgvtklopsv = new javax.swing.JTextField();
        txtgvtkdiemsv = new javax.swing.JTextField();
        cbgvtknam = new javax.swing.JComboBox<>();
        btngvtktim = new javax.swing.JButton();
        btngvtkdong = new javax.swing.JButton();
        jFramedttimkiem = new javax.swing.JFrame();
        jLabel52 = new javax.swing.JLabel();
        txtdttkmasv = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        txtdttktensv = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        rbdttknam = new javax.swing.JRadioButton();
        rbdttknu = new javax.swing.JRadioButton();
        jLabel55 = new javax.swing.JLabel();
        txtdttkngaysinh = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        txtdttkcmnd = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        txtdttkdiachi = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        txtdttkemail = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        btndttktim = new javax.swing.JButton();
        btndttkdong = new javax.swing.JButton();
        txtdttkthangsinh = new javax.swing.JTextField();
        txtdttknamsinh = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        txtdttknamnhaphoc = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        txtdttkthangnhaphoc = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        txtdttkngaynhaphoc = new javax.swing.JTextField();
        rbdttkcahai = new javax.swing.JRadioButton();
        jFrameguimailgv1sv = new javax.swing.JFrame();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        txtgmgv1svtaikhoan = new javax.swing.JTextField();
        btngmgv1svgui = new javax.swing.JButton();
        btngmgv1svdong = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtgmgv1svghichu = new javax.swing.JTextArea();
        jLabel67 = new javax.swing.JLabel();
        txtgmgv1svmatkhau = new javax.swing.JPasswordField();
        jFrameguimailgvnhieusv = new javax.swing.JFrame();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        txtgmgvnhieusvtaikhoan = new javax.swing.JTextField();
        btngmgvnhieusvgui = new javax.swing.JButton();
        btngmgvnhieusvdong = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtgmgvnhieusvghichu = new javax.swing.JTextArea();
        jLabel70 = new javax.swing.JLabel();
        txtgmgvnhieusvmatkhau = new javax.swing.JPasswordField();
        jFrameguimaildt = new javax.swing.JFrame();
        jLabel71 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        txtgmdttk = new javax.swing.JTextField();
        txtgmdtmk = new javax.swing.JPasswordField();
        jPanel6 = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        txtgmdttieude = new javax.swing.JTextField();
        jLabel76 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtgmdtnoidung = new javax.swing.JTextArea();
        rbgmdtcc = new javax.swing.JRadioButton();
        rbgmdtbcc = new javax.swing.JRadioButton();
        btngmdtfiledinhkem = new javax.swing.JButton();
        lbgmdtfiledinhkem = new javax.swing.JLabel();
        btngmdtgui = new javax.swing.JButton();
        btngmdtdong = new javax.swing.JButton();
        jFrameguimailall = new javax.swing.JFrame();
        jLabel80 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        txttk = new javax.swing.JTextField();
        txtmk = new javax.swing.JPasswordField();
        jPanel9 = new javax.swing.JPanel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        txtguiden = new javax.swing.JTextField();
        txttieude = new javax.swing.JTextField();
        jLabel85 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtnoidung = new javax.swing.JTextArea();
        rbcc = new javax.swing.JRadioButton();
        rbbcc = new javax.swing.JRadioButton();
        btnguifile = new javax.swing.JButton();
        lbtenfile = new javax.swing.JLabel();
        btngui = new javax.swing.JButton();
        btnresetguimail = new javax.swing.JButton();
        btngmdong = new javax.swing.JButton();
        jFramequenmatkhau = new javax.swing.JFrame();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        txtqmktaikhoan = new javax.swing.JTextField();
        btnqmkgui = new javax.swing.JButton();
        btnqmkdong = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btndoimatkhau = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btndangnhap = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lbngay = new javax.swing.JLabel();
        lbgio = new javax.swing.JLabel();
        lbtennv = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        btnguimail = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tdanhsachlop = new javax.swing.JTree();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbthongtin = new javax.swing.JTable();
        tbnhanvien = new javax.swing.JTabbedPane();
        pgiaovien = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtgvmasv = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtgvtensv = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtgvdiemtoan = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtgvdiemtin = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtgvdiemanh = new javax.swing.JTextField();
        btngvsuadiem = new javax.swing.JButton();
        btngvxoadiem = new javax.swing.JButton();
        lbgvhinh = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        lbtop3masv1 = new javax.swing.JLabel();
        lbtop3masv2 = new javax.swing.JLabel();
        lbtop3masv3 = new javax.swing.JLabel();
        lbtop3tensv1 = new javax.swing.JLabel();
        lbtop3tensv2 = new javax.swing.JLabel();
        lbtop3tensv3 = new javax.swing.JLabel();
        lbtop3diemtb1 = new javax.swing.JLabel();
        lbtop3diemtb2 = new javax.swing.JLabel();
        lbtop3diemtb3 = new javax.swing.JLabel();
        btngvxuatexcel = new javax.swing.JButton();
        btngvdong = new javax.swing.JButton();
        btngvtimkiem = new javax.swing.JButton();
        btngvguidiem1sv = new javax.swing.JButton();
        btngvguidiemnhieusv = new javax.swing.JButton();
        pndt = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtdtmasv = new javax.swing.JTextField();
        txtdttensv = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        rbdtnam = new javax.swing.JRadioButton();
        rbdtnu = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        txtdtemailsv = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtdtdiachisv = new javax.swing.JTextField();
        txtdtcmndsv = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btndtthemsv = new javax.swing.JButton();
        btndtsuasv = new javax.swing.JButton();
        btndtxoasv = new javax.swing.JButton();
        btndtdong = new javax.swing.JButton();
        lbhinhdt = new javax.swing.JLabel();
        btndttimkiem = new javax.swing.JButton();
        btndtxuatexcel = new javax.swing.JButton();
        btndtguimail = new javax.swing.JButton();
        txtdtngaysinh = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        txtdtthangsinh = new javax.swing.JTextField();
        jLabel77 = new javax.swing.JLabel();
        txtdtnamsinh = new javax.swing.JTextField();
        txtdtnamnhaphoc = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        txtdtthangnhaphoc = new javax.swing.JTextField();
        jLabel79 = new javax.swing.JLabel();
        txtdtngaynhaphoc = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        txtlmalop = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtlmagv = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtllop = new javax.swing.JTextField();
        txtlnienkhoa = new javax.swing.JTextField();
        cblkhoi = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        btnlthem = new javax.swing.JButton();
        btnlsualop = new javax.swing.JButton();
        btnlxoalop = new javax.swing.JButton();
        pnlthem = new javax.swing.JPanel();
        btnlopthemsv = new javax.swing.JButton();
        txtlthemmasv = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        cblthemmalop = new javax.swing.JComboBox<>();
        pnlxoa = new javax.swing.JPanel();
        btnlopxoasv = new javax.swing.JButton();
        txtlxoamasv = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        cblxoamalop = new javax.swing.JComboBox<>();
        btnlsvchuacolop = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        cbdtnienkhoa = new javax.swing.JComboBox<>();
        btndthiencaclop = new javax.swing.JButton();
        btnldong = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenutaotaikhoan = new javax.swing.JMenuItem();
        jMenuquanlymatkhau = new javax.swing.JMenuItem();
        jMenuthongtinnhanvien = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenudulieu = new javax.swing.JMenu();
        jMenusaoluu = new javax.swing.JMenuItem();
        jMenuphuchoi = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuAboutus = new javax.swing.JMenuItem();

        jFrameDangNhap.setTitle("Đăng nhập...");
        jFrameDangNhap.setAlwaysOnTop(true);
        jFrameDangNhap.setSize(new java.awt.Dimension(480, 280));
        jFrameDangNhap.getContentPane().setLayout(null);

        lbdnquenmk.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lbdnquenmk.setForeground(new java.awt.Color(0, 0, 204));
        lbdnquenmk.setText("Quên mật khẩu.");
        lbdnquenmk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbdnquenmkMouseClicked(evt);
            }
        });
        jFrameDangNhap.getContentPane().add(lbdnquenmk);
        lbdnquenmk.setBounds(350, 214, 76, 20);

        txtdntaikhoan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jFrameDangNhap.getContentPane().add(txtdntaikhoan);
        txtdntaikhoan.setBounds(250, 100, 180, 30);

        jLabel3.setFont(new java.awt.Font("VNI-Garam", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("Maät khaåu:");
        jFrameDangNhap.getContentPane().add(jLabel3);
        jLabel3.setBounds(170, 140, 64, 30);

        jLabel1.setFont(new java.awt.Font("VNI-Garam", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Taøi khoaûn:");
        jFrameDangNhap.getContentPane().add(jLabel1);
        jLabel1.setBounds(170, 100, 68, 30);

        txtdndangnhap.setFont(new java.awt.Font("VNI-Garam", 1, 12)); // NOI18N
        txtdndangnhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sof203_assignment1_ps04271/login1.png"))); // NOI18N
        txtdndangnhap.setText("Ñaêng nhaäp");
        txtdndangnhap.setPreferredSize(new java.awt.Dimension(89, 20));
        txtdndangnhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdndangnhapActionPerformed(evt);
            }
        });
        jFrameDangNhap.getContentPane().add(txtdndangnhap);
        txtdndangnhap.setBounds(180, 180, 130, 30);

        txtdnmatkhau.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jFrameDangNhap.getContentPane().add(txtdnmatkhau);
        txtdnmatkhau.setBounds(250, 140, 180, 30);

        txtdnthoat.setFont(new java.awt.Font("VNI-Garam", 1, 12)); // NOI18N
        txtdnthoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sof203_assignment1_ps04271/shutdown.png"))); // NOI18N
        txtdnthoat.setText("Thoaùt");
        txtdnthoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdnthoatActionPerformed(evt);
            }
        });
        jFrameDangNhap.getContentPane().add(txtdnthoat);
        txtdnthoat.setBounds(320, 180, 110, 30);

        PanelDangNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sof203_assignment1_ps04271/icon_login.png"))); // NOI18N
        jFrameDangNhap.getContentPane().add(PanelDangNhap);
        PanelDangNhap.setBounds(10, 11, 417, 124);

        BackgroundDangNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sof203_assignment1_ps04271/hinhanh/login-background.jpg"))); // NOI18N
        jFrameDangNhap.getContentPane().add(BackgroundDangNhap);
        BackgroundDangNhap.setBounds(0, -4, 470, 250);

        jFrametaotaikhoan.setAlwaysOnTop(true);
        jFrametaotaikhoan.setName("Tạo tài khoản"); // NOI18N
        jFrametaotaikhoan.setSize(new java.awt.Dimension(450, 300));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setText("TẠO TÀI KHOẢN");

        jLabel34.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel34.setText("Mã nhân viên:");

        jLabel35.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel35.setText("Tên nhân viên:");

        jLabel36.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel36.setText("Mật khẩu:");

        jLabel37.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel37.setText("Nhập lại mật khẩu:");

        jLabel38.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel38.setText("Loại tài khoản:");

        cbtaoloai.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        cbtaoloai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Giáo Viên", "Đào Tạo" }));

        txttaotkmanv.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        txttaotktennv.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        passtaotkmatkhau.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        passtaotknhaplaimk.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btntaotktao.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btntaotktao.setText("Tạo");
        btntaotktao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntaotktaoActionPerformed(evt);
            }
        });

        btntaotkthoat.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btntaotkthoat.setText("Thoát");
        btntaotkthoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntaotkthoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jFrametaotaikhoanLayout = new javax.swing.GroupLayout(jFrametaotaikhoan.getContentPane());
        jFrametaotaikhoan.getContentPane().setLayout(jFrametaotaikhoanLayout);
        jFrametaotaikhoanLayout.setHorizontalGroup(
            jFrametaotaikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrametaotaikhoanLayout.createSequentialGroup()
                .addGroup(jFrametaotaikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jFrametaotaikhoanLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(jFrametaotaikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel35)
                            .addComponent(jLabel34)
                            .addComponent(jLabel36)
                            .addComponent(jLabel37)
                            .addComponent(jLabel38)
                            .addComponent(btntaotktao))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jFrametaotaikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txttaotkmanv)
                            .addComponent(txttaotktennv, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                            .addComponent(passtaotkmatkhau)
                            .addComponent(passtaotknhaplaimk)
                            .addGroup(jFrametaotaikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btntaotkthoat)
                                .addComponent(cbtaoloai, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jFrametaotaikhoanLayout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jLabel14)))
                .addContainerGap(122, Short.MAX_VALUE))
        );
        jFrametaotaikhoanLayout.setVerticalGroup(
            jFrametaotaikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrametaotaikhoanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jFrametaotaikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttaotkmanv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jFrametaotaikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttaotktennv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jFrametaotaikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passtaotkmatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jFrametaotaikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passtaotknhaplaimk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jFrametaotaikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbtaoloai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jFrametaotaikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btntaotktao)
                    .addComponent(btntaotkthoat))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jFramedoimatkhau.setSize(new java.awt.Dimension(282, 300));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel20.setText("Đổi mật khẩu");

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel21.setText("Mật khẩu cũ:");

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel22.setText("Mật khẩu mới:");

        jLabel39.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel39.setText("Nhập lại mật khẩu mới:");

        passdmkmkcu.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        passdmkmkmoi.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        passdmknhaplai.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        btndmkdoimk.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btndmkdoimk.setText("Đổi mật khẩu");
        btndmkdoimk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndmkdoimkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jFramedoimatkhauLayout = new javax.swing.GroupLayout(jFramedoimatkhau.getContentPane());
        jFramedoimatkhau.getContentPane().setLayout(jFramedoimatkhauLayout);
        jFramedoimatkhauLayout.setHorizontalGroup(
            jFramedoimatkhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFramedoimatkhauLayout.createSequentialGroup()
                .addGroup(jFramedoimatkhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jFramedoimatkhauLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel20))
                    .addGroup(jFramedoimatkhauLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jFramedoimatkhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel39)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jFramedoimatkhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btndmkdoimk)
                            .addGroup(jFramedoimatkhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(passdmkmkmoi, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                .addComponent(passdmkmkcu)
                                .addComponent(passdmknhaplai)))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jFramedoimatkhauLayout.setVerticalGroup(
            jFramedoimatkhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFramedoimatkhauLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jFramedoimatkhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(passdmkmkcu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jFramedoimatkhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(passdmkmkmoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jFramedoimatkhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(passdmknhaplai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btndmkdoimk)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        puhinh.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jFramequanlymk.setSize(new java.awt.Dimension(268, 240));

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel25.setText("QUẢN LÝ MẬT KHẨU");

        jLabel40.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel40.setText("Tài khoản:");

        jLabel41.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel41.setText("Mật khẩu mới:");

        btnqlmkdoi.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnqlmkdoi.setText("Đổi");
        btnqlmkdoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnqlmkdoiActionPerformed(evt);
            }
        });

        btnqlmkdong.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnqlmkdong.setText("Đóng");
        btnqlmkdong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnqlmkdongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jFramequanlymkLayout = new javax.swing.GroupLayout(jFramequanlymk.getContentPane());
        jFramequanlymk.getContentPane().setLayout(jFramequanlymkLayout);
        jFramequanlymkLayout.setHorizontalGroup(
            jFramequanlymkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFramequanlymkLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jFramequanlymkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addGroup(jFramequanlymkLayout.createSequentialGroup()
                        .addGroup(jFramequanlymkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel41)
                            .addComponent(jLabel40))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jFramequanlymkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFramequanlymkLayout.createSequentialGroup()
                                .addComponent(btnqlmkdoi, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnqlmkdong))
                            .addComponent(txtqlmkmkmoi)
                            .addComponent(cbqlmktaikhoan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jFramequanlymkLayout.setVerticalGroup(
            jFramequanlymkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFramequanlymkLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jFramequanlymkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(cbqlmktaikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jFramequanlymkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(txtqlmkmkmoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jFramequanlymkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnqlmkdoi)
                    .addComponent(btnqlmkdong))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jFramethongtinnhanvien.setSize(new java.awt.Dimension(425, 430));

        jLabel42.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel42.setText("QUẢN LÝ THÔNG TIN NHÂN VIÊN");

        lbqlnvhinh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sof203_assignment1_ps04271/hinhanh/noimage.png"))); // NOI18N
        lbqlnvhinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbqlnvhinhMouseClicked(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel44.setText("Mã nhân viên:");

        jLabel45.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel45.setText("Tên nhân viên:");

        jLabel46.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel46.setText("Chức vụ:");

        txtqlnvtennv.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        txtqlnvma.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        cbqlnvchucvu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Giáo Viên", "Đào Tạo" }));

        tbqlnv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbqlnv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbqlnvMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbqlnv);

        btnqlnvthaydoi.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnqlnvthaydoi.setText("Thay đổi");
        btnqlnvthaydoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnqlnvthaydoiActionPerformed(evt);
            }
        });

        btnqlnvdong.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnqlnvdong.setText("Đóng");
        btnqlnvdong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnqlnvdongActionPerformed(evt);
            }
        });

        btnqlnvxoa.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnqlnvxoa.setText("Xóa");
        btnqlnvxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnqlnvxoaActionPerformed(evt);
            }
        });

        jLabel88.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel88.setText("Email:");

        txtqlnvemail.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        javax.swing.GroupLayout jFramethongtinnhanvienLayout = new javax.swing.GroupLayout(jFramethongtinnhanvien.getContentPane());
        jFramethongtinnhanvien.getContentPane().setLayout(jFramethongtinnhanvienLayout);
        jFramethongtinnhanvienLayout.setHorizontalGroup(
            jFramethongtinnhanvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFramethongtinnhanvienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jFramethongtinnhanvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jFramethongtinnhanvienLayout.createSequentialGroup()
                        .addGroup(jFramethongtinnhanvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jFramethongtinnhanvienLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lbqlnvhinh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jFramethongtinnhanvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jFramethongtinnhanvienLayout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(jLabel44)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtqlnvma))
                                    .addGroup(jFramethongtinnhanvienLayout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addComponent(jLabel46)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbqlnvchucvu, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jFramethongtinnhanvienLayout.createSequentialGroup()
                                        .addGap(55, 55, 55)
                                        .addComponent(jLabel88)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtqlnvemail))
                                    .addGroup(jFramethongtinnhanvienLayout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jLabel45)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtqlnvtennv))))
                            .addComponent(jLabel42))
                        .addGap(14, 14, 14))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFramethongtinnhanvienLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnqlnvxoa, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnqlnvthaydoi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnqlnvdong, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jFramethongtinnhanvienLayout.setVerticalGroup(
            jFramethongtinnhanvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFramethongtinnhanvienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel42)
                .addGroup(jFramethongtinnhanvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jFramethongtinnhanvienLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbqlnvhinh))
                    .addGroup(jFramethongtinnhanvienLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jFramethongtinnhanvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel44)
                            .addComponent(txtqlnvma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(jFramethongtinnhanvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel45)
                            .addComponent(txtqlnvtennv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jFramethongtinnhanvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel46)
                            .addComponent(cbqlnvchucvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jFramethongtinnhanvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel88)
                            .addComponent(txtqlnvemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jFramethongtinnhanvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnqlnvthaydoi)
                    .addComponent(btnqlnvdong)
                    .addComponent(btnqlnvxoa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jFramegvtimkiem.setSize(new java.awt.Dimension(350, 350));

        jLabel43.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel43.setText("TÌM KIẾM ĐIỂM SINH VIÊN");

        jLabel47.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel47.setText("Mã Sinh Viên:");

        jLabel48.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel48.setText("Tên Sinh Viên:");

        jLabel49.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel49.setText("Lớp Sinh Viên:");

        jLabel50.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel50.setText("Năm Học:");

        jLabel51.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel51.setText("Điểm trung bình:");

        cbgvtkpheptoan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lớn hơn", "Nhỏ hơn", "Bằng" }));

        txtgvtkmasv.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        txtgvtktensv.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        txtgvtklopsv.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        txtgvtkdiemsv.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        btngvtktim.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btngvtktim.setText("Tìm");
        btngvtktim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngvtktimActionPerformed(evt);
            }
        });

        btngvtkdong.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btngvtkdong.setText("Đóng");
        btngvtkdong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngvtkdongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jFramegvtimkiemLayout = new javax.swing.GroupLayout(jFramegvtimkiem.getContentPane());
        jFramegvtimkiem.getContentPane().setLayout(jFramegvtimkiemLayout);
        jFramegvtimkiemLayout.setHorizontalGroup(
            jFramegvtimkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFramegvtimkiemLayout.createSequentialGroup()
                .addGroup(jFramegvtimkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jFramegvtimkiemLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel43))
                    .addGroup(jFramegvtimkiemLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jFramegvtimkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel49)
                            .addGroup(jFramegvtimkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel48)
                                .addComponent(jLabel47, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel50)
                            .addComponent(jLabel51))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jFramegvtimkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFramegvtimkiemLayout.createSequentialGroup()
                                .addComponent(btngvtktim, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btngvtkdong))
                            .addComponent(txtgvtkmasv, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtgvtktensv, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtgvtklopsv, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbgvtknam, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jFramegvtimkiemLayout.createSequentialGroup()
                                .addComponent(cbgvtkpheptoan, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(txtgvtkdiemsv)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jFramegvtimkiemLayout.setVerticalGroup(
            jFramegvtimkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFramegvtimkiemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel43)
                .addGap(18, 18, 18)
                .addGroup(jFramegvtimkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(txtgvtkmasv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jFramegvtimkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(txtgvtktensv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jFramegvtimkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(txtgvtklopsv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jFramegvtimkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(cbgvtknam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jFramegvtimkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(cbgvtkpheptoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtgvtkdiemsv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jFramegvtimkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btngvtktim)
                    .addComponent(btngvtkdong))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jFramedttimkiem.setSize(new java.awt.Dimension(355, 420));

        jLabel52.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel52.setText("Mã Sinh Viên:");

        txtdttkmasv.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel53.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel53.setText("Tên Sinh Viên:");

        txtdttktensv.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel54.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel54.setText("Giới tính:");

        rbdttknam.setText("Nam");

        rbdttknu.setText("Nữ");

        jLabel55.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel55.setText("Ngày sinh:");

        txtdttkngaysinh.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel56.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel56.setText("CMND:");

        txtdttkcmnd.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel57.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel57.setText("Ngày nhập học:");

        txtdttkdiachi.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel58.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel58.setText("Địa chỉ:");

        jLabel59.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel59.setText("Email:");

        txtdttkemail.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel60.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel60.setText("TÌM KIẾM SINH VIÊN");

        btndttktim.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btndttktim.setText("Tìm");
        btndttktim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndttktimActionPerformed(evt);
            }
        });

        btndttkdong.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btndttkdong.setText("Đóng");
        btndttkdong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndttkdongActionPerformed(evt);
            }
        });

        txtdttkthangsinh.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        txtdttknamsinh.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel61.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel61.setText("/");

        jLabel62.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel62.setText("/");

        txtdttknamnhaphoc.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel63.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel63.setText("/");

        txtdttkthangnhaphoc.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel64.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel64.setText("/");

        txtdttkngaynhaphoc.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        rbdttkcahai.setText("Cả hai");

        javax.swing.GroupLayout jFramedttimkiemLayout = new javax.swing.GroupLayout(jFramedttimkiem.getContentPane());
        jFramedttimkiem.getContentPane().setLayout(jFramedttimkiemLayout);
        jFramedttimkiemLayout.setHorizontalGroup(
            jFramedttimkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFramedttimkiemLayout.createSequentialGroup()
                .addGroup(jFramedttimkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jFramedttimkiemLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel60))
                    .addGroup(jFramedttimkiemLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jFramedttimkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel53)
                            .addComponent(jLabel54)
                            .addComponent(jLabel55)
                            .addComponent(jLabel56)
                            .addComponent(jLabel59)
                            .addComponent(jLabel58)
                            .addComponent(jLabel57))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jFramedttimkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jFramedttimkiemLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(btndttktim, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btndttkdong))
                            .addComponent(txtdttkemail)
                            .addComponent(txtdttkdiachi)
                            .addComponent(txtdttkcmnd)
                            .addComponent(txtdttktensv)
                            .addComponent(txtdttkmasv)
                            .addGroup(jFramedttimkiemLayout.createSequentialGroup()
                                .addGroup(jFramedttimkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtdttkngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rbdttknam, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jFramedttimkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jFramedttimkiemLayout.createSequentialGroup()
                                        .addComponent(rbdttknu)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rbdttkcahai)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jFramedttimkiemLayout.createSequentialGroup()
                                        .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtdttkthangsinh, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtdttknamsinh))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFramedttimkiemLayout.createSequentialGroup()
                                .addComponent(txtdttkngaynhaphoc, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtdttkthangnhaphoc, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtdttknamnhaphoc, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 23, Short.MAX_VALUE))
        );
        jFramedttimkiemLayout.setVerticalGroup(
            jFramedttimkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFramedttimkiemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jFramedttimkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdttkmasv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jFramedttimkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdttktensv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jFramedttimkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jFramedttimkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rbdttknu)
                        .addComponent(rbdttkcahai))
                    .addComponent(rbdttknam))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jFramedttimkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdttkngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdttkthangsinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdttknamsinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jFramedttimkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdttkcmnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jFramedttimkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdttkemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jFramedttimkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdttkdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jFramedttimkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jFramedttimkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtdttkngaynhaphoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtdttkthangnhaphoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtdttknamnhaphoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jFramedttimkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btndttktim)
                    .addComponent(btndttkdong))
                .addGap(25, 25, 25))
        );

        jFrameguimailgv1sv.setSize(new java.awt.Dimension(400, 300));

        jLabel65.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel65.setText("Tài khoản gmail:");

        jLabel66.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel66.setText("Mật khẩu:");

        txtgmgv1svtaikhoan.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        btngmgv1svgui.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btngmgv1svgui.setText("Gửi");
        btngmgv1svgui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngmgv1svguiActionPerformed(evt);
            }
        });

        btngmgv1svdong.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btngmgv1svdong.setText("Đóng");
        btngmgv1svdong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngmgv1svdongActionPerformed(evt);
            }
        });

        txtgmgv1svghichu.setColumns(20);
        txtgmgv1svghichu.setRows(5);
        jScrollPane4.setViewportView(txtgmgv1svghichu);

        jLabel67.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel67.setText("Ghi chú:");

        javax.swing.GroupLayout jFrameguimailgv1svLayout = new javax.swing.GroupLayout(jFrameguimailgv1sv.getContentPane());
        jFrameguimailgv1sv.getContentPane().setLayout(jFrameguimailgv1svLayout);
        jFrameguimailgv1svLayout.setHorizontalGroup(
            jFrameguimailgv1svLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrameguimailgv1svLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jFrameguimailgv1svLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel66)
                    .addComponent(jLabel65)
                    .addComponent(jLabel67))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jFrameguimailgv1svLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jFrameguimailgv1svLayout.createSequentialGroup()
                        .addComponent(btngmgv1svgui, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btngmgv1svdong, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                    .addComponent(txtgmgv1svtaikhoan)
                    .addComponent(txtgmgv1svmatkhau))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jFrameguimailgv1svLayout.setVerticalGroup(
            jFrameguimailgv1svLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrameguimailgv1svLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jFrameguimailgv1svLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel65)
                    .addComponent(txtgmgv1svtaikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jFrameguimailgv1svLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel66)
                    .addComponent(txtgmgv1svmatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jFrameguimailgv1svLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel67)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jFrameguimailgv1svLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btngmgv1svgui)
                    .addComponent(btngmgv1svdong))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        jFrameguimailgvnhieusv.setSize(new java.awt.Dimension(400, 300));

        jLabel68.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel68.setText("Tài khoản gmail:");

        jLabel69.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel69.setText("Mật khẩu:");

        txtgmgvnhieusvtaikhoan.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        btngmgvnhieusvgui.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btngmgvnhieusvgui.setText("Gửi");
        btngmgvnhieusvgui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngmgvnhieusvguiActionPerformed(evt);
            }
        });

        btngmgvnhieusvdong.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btngmgvnhieusvdong.setText("Đóng");
        btngmgvnhieusvdong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngmgvnhieusvdongActionPerformed(evt);
            }
        });

        txtgmgvnhieusvghichu.setColumns(20);
        txtgmgvnhieusvghichu.setRows(5);
        jScrollPane5.setViewportView(txtgmgvnhieusvghichu);

        jLabel70.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel70.setText("Ghi chú:");

        javax.swing.GroupLayout jFrameguimailgvnhieusvLayout = new javax.swing.GroupLayout(jFrameguimailgvnhieusv.getContentPane());
        jFrameguimailgvnhieusv.getContentPane().setLayout(jFrameguimailgvnhieusvLayout);
        jFrameguimailgvnhieusvLayout.setHorizontalGroup(
            jFrameguimailgvnhieusvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrameguimailgvnhieusvLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jFrameguimailgvnhieusvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel69)
                    .addComponent(jLabel68)
                    .addComponent(jLabel70))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jFrameguimailgvnhieusvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jFrameguimailgvnhieusvLayout.createSequentialGroup()
                        .addComponent(btngmgvnhieusvgui, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btngmgvnhieusvdong, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                    .addComponent(txtgmgvnhieusvtaikhoan)
                    .addComponent(txtgmgvnhieusvmatkhau))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jFrameguimailgvnhieusvLayout.setVerticalGroup(
            jFrameguimailgvnhieusvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrameguimailgvnhieusvLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jFrameguimailgvnhieusvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68)
                    .addComponent(txtgmgvnhieusvtaikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jFrameguimailgvnhieusvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel69)
                    .addComponent(txtgmgvnhieusvmatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jFrameguimailgvnhieusvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel70)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jFrameguimailgvnhieusvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btngmgvnhieusvgui)
                    .addComponent(btngmgvnhieusvdong))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        jFrameguimaildt.setSize(new java.awt.Dimension(560, 550));

        jLabel71.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel71.setText("Gửi Mail");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tài khoản Email", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel72.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel72.setText("Tài khoản:");

        jLabel73.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel73.setText("Mật khẩu:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel73)
                    .addComponent(jLabel72))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtgmdttk, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                    .addComponent(txtgmdtmk))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtgmdttk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtgmdtmk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nội dung", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel75.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel75.setText("Tiêu đề:");

        jLabel76.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel76.setText("Nội dung:");

        txtgmdtnoidung.setColumns(20);
        txtgmdtnoidung.setRows(5);
        jScrollPane6.setViewportView(txtgmdtnoidung);

        rbgmdtcc.setSelected(true);
        rbgmdtcc.setText("CC");

        rbgmdtbcc.setText("BCC");

        btngmdtfiledinhkem.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btngmdtfiledinhkem.setText("Chọn file đính kèm");
        btngmdtfiledinhkem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngmdtfiledinhkemActionPerformed(evt);
            }
        });

        lbgmdtfiledinhkem.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel76)
                    .addComponent(jLabel75))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(rbgmdtcc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbgmdtbcc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btngmdtfiledinhkem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbgmdtfiledinhkem, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                    .addComponent(jScrollPane6)
                    .addComponent(txtgmdttieude))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbgmdtfiledinhkem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rbgmdtcc)
                        .addComponent(rbgmdtbcc)
                        .addComponent(btngmdtfiledinhkem)))
                .addGap(6, 6, 6)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtgmdttieude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        btngmdtgui.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btngmdtgui.setText("Gửi");
        btngmdtgui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngmdtguiActionPerformed(evt);
            }
        });

        btngmdtdong.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btngmdtdong.setText("Đóng");

        javax.swing.GroupLayout jFrameguimaildtLayout = new javax.swing.GroupLayout(jFrameguimaildt.getContentPane());
        jFrameguimaildt.getContentPane().setLayout(jFrameguimaildtLayout);
        jFrameguimaildtLayout.setHorizontalGroup(
            jFrameguimaildtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrameguimaildtLayout.createSequentialGroup()
                .addGroup(jFrameguimaildtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jFrameguimaildtLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jFrameguimaildtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jFrameguimaildtLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(btngmdtgui, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btngmdtdong, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jFrameguimaildtLayout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(jLabel71)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jFrameguimaildtLayout.setVerticalGroup(
            jFrameguimaildtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrameguimaildtLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel71)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jFrameguimaildtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btngmdtgui)
                    .addComponent(btngmdtdong))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jFrameguimailall.setSize(new java.awt.Dimension(500, 550));

        jLabel80.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel80.setText("Gửi Thư");

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tài khoản Email", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel81.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel81.setText("Tài khoản:");

        jLabel82.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel82.setText("Mật khẩu:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel82)
                    .addComponent(jLabel81))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txttk)
                    .addComponent(txtmk, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nội dung", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel83.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel83.setText("Gửi đến:");

        jLabel84.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel84.setText("Tiêu đề:");

        txtguiden.setToolTipText("<html>Các mail cách nhau bằng dấu \";\"</html>");

        jLabel85.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel85.setText("Nội dung:");

        txtnoidung.setColumns(20);
        txtnoidung.setRows(5);
        jScrollPane7.setViewportView(txtnoidung);

        rbcc.setSelected(true);
        rbcc.setText("CC");

        rbbcc.setText("BCC");

        btnguifile.setText("Gửi kèm file");
        btnguifile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguifileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel85)
                    .addComponent(jLabel84)
                    .addComponent(jLabel83))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtguiden, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                            .addComponent(txttieude))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbcc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbbcc)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(btnguifile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbtenfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtguiden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbcc)
                    .addComponent(rbbcc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttieude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnguifile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbtenfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btngui.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btngui.setText("Gửi");
        btngui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguiActionPerformed(evt);
            }
        });

        btnresetguimail.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnresetguimail.setText("Reset");
        btnresetguimail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetguimailActionPerformed(evt);
            }
        });

        btngmdong.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btngmdong.setText("Đóng");
        btngmdong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngmdongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jFrameguimailallLayout = new javax.swing.GroupLayout(jFrameguimailall.getContentPane());
        jFrameguimailall.getContentPane().setLayout(jFrameguimailallLayout);
        jFrameguimailallLayout.setHorizontalGroup(
            jFrameguimailallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrameguimailallLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jFrameguimailallLayout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addComponent(jLabel80)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrameguimailallLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrameguimailallLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btngui)
                .addGap(72, 72, 72)
                .addComponent(btnresetguimail)
                .addGap(64, 64, 64)
                .addComponent(btngmdong)
                .addGap(54, 54, 54))
        );
        jFrameguimailallLayout.setVerticalGroup(
            jFrameguimailallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrameguimailallLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jFrameguimailallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btngmdong)
                    .addComponent(btnresetguimail)
                    .addComponent(btngui))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jFramequenmatkhau.setTitle("Gửi mật khẩu mới");
        jFramequenmatkhau.setAlwaysOnTop(true);
        jFramequenmatkhau.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jFramequenmatkhau.setSize(new java.awt.Dimension(400, 200));

        jLabel86.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel86.setText("QUÊN MẬT KHẨU");

        jLabel87.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel87.setText("Nhập tài khoản:");

        btnqmkgui.setText("Gửi mật khẩu mới");
        btnqmkgui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnqmkguiActionPerformed(evt);
            }
        });

        btnqmkdong.setText("Đóng");
        btnqmkdong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnqmkdongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jFramequenmatkhauLayout = new javax.swing.GroupLayout(jFramequenmatkhau.getContentPane());
        jFramequenmatkhau.getContentPane().setLayout(jFramequenmatkhauLayout);
        jFramequenmatkhauLayout.setHorizontalGroup(
            jFramequenmatkhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFramequenmatkhauLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jFramequenmatkhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jFramequenmatkhauLayout.createSequentialGroup()
                        .addComponent(jLabel86)
                        .addContainerGap(146, Short.MAX_VALUE))
                    .addGroup(jFramequenmatkhauLayout.createSequentialGroup()
                        .addComponent(jLabel87)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jFramequenmatkhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtqmktaikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFramequenmatkhauLayout.createSequentialGroup()
                                .addComponent(btnqmkgui, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnqmkdong)))
                        .addGap(83, 83, 83))))
        );
        jFramequenmatkhauLayout.setVerticalGroup(
            jFramequenmatkhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFramequenmatkhauLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel86)
                .addGap(31, 31, 31)
                .addGroup(jFramequenmatkhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel87)
                    .addComponent(txtqmktaikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jFramequenmatkhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnqmkgui)
                    .addComponent(btnqmkdong))
                .addContainerGap(270, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản Lý Sinh Viên");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setSize(new java.awt.Dimension(864, 648));

        btndoimatkhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sof203_assignment1_ps04271/doimatkhau.png"))); // NOI18N
        btndoimatkhau.setText("Đổi mật khẩu");
        btndoimatkhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndoimatkhauActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sof203_assignment1_ps04271/Close Window-48.png"))); // NOI18N
        jButton4.setText("Thoát");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btndangnhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sof203_assignment1_ps04271/dangxuat.png"))); // NOI18N
        btndangnhap.setText("Đăng Nhập");
        btndangnhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndangnhapActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel18.setText("Hôm nay là:");

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel19.setText("Bây giờ là:");

        lbngay.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lbngay.setText("Ngày");

        lbgio.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lbgio.setText("Giờ");

        lbtennv.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lbtennv.setText("Tên");

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel23.setText("Xin chào:");

        btnguimail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sof203_assignment1_ps04271/hinhanh/mail.png"))); // NOI18N
        btnguimail.setText("Gửi mail");
        btnguimail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguimailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbtennv, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbngay, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbgio, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(143, 143, 143)
                .addComponent(btnguimail, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btndoimatkhau)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btndangnhap)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btndoimatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton4)
                .addComponent(btndangnhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbngay)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbgio)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbtennv)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(btnguimail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Các Lớp");
        Tdanhsachlop.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        Tdanhsachlop.setMinimumSize(new java.awt.Dimension(61, 16));
        Tdanhsachlop.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                TdanhsachlopValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(Tdanhsachlop);

        tbthongtin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbthongtin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbthongtinMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbthongtin);

        tbnhanvien.setBackground(new java.awt.Color(204, 204, 255));
        tbnhanvien.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tbnhanvien.setForeground(new java.awt.Color(0, 0, 255));
        tbnhanvien.setToolTipText("");
        tbnhanvien.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tbnhanvien.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tbnhanvienStateChanged(evt);
            }
        });
        tbnhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbnhanvienMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setText("Mã Sinh Viên:");

        txtgvmasv.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setText("Tên Sinh Viên:");

        txtgvtensv.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setText("Điểm Toán:");

        txtgvdiemtoan.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setText("Điểm Tin:");

        txtgvdiemtin.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel7.setText("Điểm Anh:");

        txtgvdiemanh.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        btngvsuadiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sof203_assignment1_ps04271/Ball Point Pen-32.png"))); // NOI18N
        btngvsuadiem.setText("Sửa Điểm");
        btngvsuadiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngvsuadiemActionPerformed(evt);
            }
        });

        btngvxoadiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sof203_assignment1_ps04271/Delete.png"))); // NOI18N
        btngvxoadiem.setText("Xóa Điểm");
        btngvxoadiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngvxoadiemActionPerformed(evt);
            }
        });

        lbgvhinh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sof203_assignment1_ps04271/hinhanh/noimage.png"))); // NOI18N

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Top 3 Điểm trung bình", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        lbtop3masv1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        lbtop3masv2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        lbtop3masv3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        lbtop3tensv1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        lbtop3tensv2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        lbtop3tensv3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        lbtop3diemtb1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        lbtop3diemtb2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        lbtop3diemtb3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbtop3masv1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtop3masv2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtop3masv3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbtop3tensv2, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                    .addComponent(lbtop3tensv3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbtop3tensv1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbtop3diemtb2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtop3diemtb3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtop3diemtb1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbtop3tensv1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbtop3diemtb1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(lbtop3tensv2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbtop3diemtb2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbtop3tensv3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbtop3diemtb3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(lbtop3masv1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbtop3masv2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbtop3masv3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        btngvxuatexcel.setText("Xuất file Excel");
        btngvxuatexcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngvxuatexcelActionPerformed(evt);
            }
        });

        btngvdong.setText("Đóng");
        btngvdong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngvdongActionPerformed(evt);
            }
        });

        btngvtimkiem.setText("Tìm kiếm");
        btngvtimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngvtimkiemActionPerformed(evt);
            }
        });

        btngvguidiem1sv.setText("Gửi điểm cho sinh viên này");
        btngvguidiem1sv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngvguidiem1svActionPerformed(evt);
            }
        });

        btngvguidiemnhieusv.setText("Gửi điểm nhiều sinh viên");
        btngvguidiemnhieusv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngvguidiemnhieusvActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pgiaovienLayout = new javax.swing.GroupLayout(pgiaovien);
        pgiaovien.setLayout(pgiaovienLayout);
        pgiaovienLayout.setHorizontalGroup(
            pgiaovienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pgiaovienLayout.createSequentialGroup()
                .addGroup(pgiaovienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pgiaovienLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(lbgvhinh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pgiaovienLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btngvdong)
                        .addGap(18, 18, 18)))
                .addGroup(pgiaovienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pgiaovienLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtgvmasv, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pgiaovienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(pgiaovienLayout.createSequentialGroup()
                            .addComponent(btngvsuadiem)
                            .addGap(18, 18, 18)
                            .addComponent(btngvxoadiem, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btngvguidiemnhieusv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btngvtimkiem)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btngvxuatexcel))
                        .addGroup(pgiaovienLayout.createSequentialGroup()
                            .addGroup(pgiaovienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pgiaovienLayout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtgvtensv, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pgiaovienLayout.createSequentialGroup()
                                    .addGroup(pgiaovienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btngvguidiem1sv, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pgiaovienLayout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtgvdiemtoan, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel6)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtgvdiemtin, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtgvdiemanh, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        pgiaovienLayout.setVerticalGroup(
            pgiaovienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pgiaovienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pgiaovienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pgiaovienLayout.createSequentialGroup()
                        .addComponent(lbgvhinh, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pgiaovienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btngvsuadiem)
                            .addComponent(btngvxoadiem)
                            .addComponent(btngvdong)))
                    .addGroup(pgiaovienLayout.createSequentialGroup()
                        .addGroup(pgiaovienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtgvmasv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pgiaovienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pgiaovienLayout.createSequentialGroup()
                                .addGroup(pgiaovienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtgvtensv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pgiaovienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtgvdiemtoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pgiaovienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtgvdiemtin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtgvdiemanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btngvguidiem1sv))
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(pgiaovienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btngvxuatexcel)
                            .addComponent(btngvtimkiem)
                            .addComponent(btngvguidiemnhieusv))))
                .addContainerGap())
        );

        tbnhanvien.addTab("Giáo Viên", pgiaovien);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel8.setText("Mã Sinh Viên:");

        txtdtmasv.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        txtdttensv.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel9.setText("Tên Sinh Viên:");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel10.setText("Ngày sinh:");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel11.setText("Giới tính:");

        rbdtnam.setText("Nam");

        rbdtnu.setText("Nữ");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel12.setText("Email:");

        txtdtemailsv.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel13.setText("Địa chỉ:");

        txtdtdiachisv.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        txtdtcmndsv.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel16.setText("CMND:");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel17.setText("Ngày nhập học:");

        btndtthemsv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sof203_assignment1_ps04271/themdiem.png"))); // NOI18N
        btndtthemsv.setText("Thêm Sinh Viên");
        btndtthemsv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndtthemsvActionPerformed(evt);
            }
        });

        btndtsuasv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sof203_assignment1_ps04271/Ball Point Pen-32.png"))); // NOI18N
        btndtsuasv.setText("Sửa Sinh Viên");
        btndtsuasv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndtsuasvActionPerformed(evt);
            }
        });

        btndtxoasv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sof203_assignment1_ps04271/Delete.png"))); // NOI18N
        btndtxoasv.setText("Xóa Sinh Viên");
        btndtxoasv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndtxoasvActionPerformed(evt);
            }
        });

        btndtdong.setText("Đóng");
        btndtdong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndtdongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(btndtdong)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btndtthemsv)
                .addGap(18, 18, 18)
                .addComponent(btndtsuasv)
                .addGap(18, 18, 18)
                .addComponent(btndtxoasv)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btndtdong)
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btndtxoasv)
                    .addComponent(btndtsuasv)
                    .addComponent(btndtthemsv))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        lbhinhdt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sof203_assignment1_ps04271/hinhanh/noimage.png"))); // NOI18N
        lbhinhdt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbhinhdtMouseClicked(evt);
            }
        });

        btndttimkiem.setText("Tìm kiếm");
        btndttimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndttimkiemActionPerformed(evt);
            }
        });

        btndtxuatexcel.setText("Xuất Excel");
        btndtxuatexcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndtxuatexcelActionPerformed(evt);
            }
        });

        btndtguimail.setText("Gửi mail");
        btndtguimail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndtguimailActionPerformed(evt);
            }
        });

        txtdtngaysinh.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtdtngaysinh.setToolTipText("<html>Ngày</html>");

        jLabel74.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel74.setText("/");

        txtdtthangsinh.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtdtthangsinh.setToolTipText("<html>Tháng</html>");

        jLabel77.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel77.setText("/");

        txtdtnamsinh.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtdtnamsinh.setToolTipText("<html>Năm</html>");

        txtdtnamnhaphoc.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtdtnamnhaphoc.setToolTipText("<html>Năm</html>");

        jLabel78.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel78.setText("/");

        txtdtthangnhaphoc.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtdtthangnhaphoc.setToolTipText("<html>Tháng</html>");

        jLabel79.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel79.setText("/");

        txtdtngaynhaphoc.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtdtngaynhaphoc.setToolTipText("<html>Ngày</html>");

        javax.swing.GroupLayout pndtLayout = new javax.swing.GroupLayout(pndt);
        pndt.setLayout(pndtLayout);
        pndtLayout.setHorizontalGroup(
            pndtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pndtLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbhinhdt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pndtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pndtLayout.createSequentialGroup()
                        .addGroup(pndtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pndtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pndtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtdtmasv, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtdttensv, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pndtLayout.createSequentialGroup()
                                .addComponent(txtdtngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtdtthangsinh, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pndtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pndtLayout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtdtnamsinh, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pndtLayout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addComponent(jLabel16)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtdtcmndsv, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pndtLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbdtnam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbdtnu)))
                .addGroup(pndtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pndtLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(pndtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)))
                    .addGroup(pndtLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel17)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pndtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pndtLayout.createSequentialGroup()
                        .addComponent(txtdtngaynhaphoc, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtdtthangnhaphoc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtdtnamnhaphoc, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtdtemailsv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txtdtdiachisv, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(61, 61, 61))
            .addGroup(pndtLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pndtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pndtLayout.createSequentialGroup()
                        .addComponent(btndttimkiem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btndtxuatexcel))
                    .addComponent(btndtguimail, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        pndtLayout.setVerticalGroup(
            pndtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pndtLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pndtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pndtLayout.createSequentialGroup()
                        .addGroup(pndtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdtmasv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdtemailsv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pndtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pndtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtdttensv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtdtdiachisv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pndtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pndtLayout.createSequentialGroup()
                                .addGroup(pndtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtdtnamnhaphoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pndtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(rbdtnam)
                                        .addComponent(rbdtnu)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pndtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pndtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtdtngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtdtthangsinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtdtnamsinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel74, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel77, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pndtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtdtngaynhaphoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel79)
                                .addComponent(txtdtthangnhaphoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel78, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pndtLayout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pndtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdtcmndsv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btndtguimail)))
                    .addComponent(lbhinhdt, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pndtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pndtLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pndtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btndttimkiem)
                            .addComponent(btndtxuatexcel))
                        .addContainerGap(46, Short.MAX_VALUE))
                    .addGroup(pndtLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(20, Short.MAX_VALUE))))
        );

        tbnhanvien.addTab("Đào Tạo", pndt);

        txtlmalop.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel15.setText("Mã lớp:");

        jLabel26.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel26.setText("Mã Giáo Viên:");

        txtlmagv.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel27.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel27.setText("Khối:");

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel28.setText("Lớp:");

        jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel29.setText("Niên Khóa:");

        txtllop.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        txtlnienkhoa.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        cblkhoi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cblkhoi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "11", "12" }));

        btnlthem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sof203_assignment1_ps04271/themdiem.png"))); // NOI18N
        btnlthem.setText("Thêm Lớp");
        btnlthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlthemActionPerformed(evt);
            }
        });

        btnlsualop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sof203_assignment1_ps04271/Ball Point Pen-32.png"))); // NOI18N
        btnlsualop.setText("Sửa Lớp");
        btnlsualop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlsualopActionPerformed(evt);
            }
        });

        btnlxoalop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sof203_assignment1_ps04271/Delete.png"))); // NOI18N
        btnlxoalop.setText("Xóa Lớp");
        btnlxoalop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlxoalopActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnlthem)
                .addGap(18, 18, 18)
                .addComponent(btnlsualop)
                .addGap(18, 18, 18)
                .addComponent(btnlxoalop, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnlthem)
                .addComponent(btnlsualop)
                .addComponent(btnlxoalop))
        );

        pnlthem.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thêm học sinh vào lớp", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        btnlopthemsv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sof203_assignment1_ps04271/themdiem.png"))); // NOI18N
        btnlopthemsv.setText("Thêm Sinh Viên");
        btnlopthemsv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlopthemsvActionPerformed(evt);
            }
        });

        txtlthemmasv.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel30.setText("Mã sv:");

        jLabel31.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel31.setText("Lớp:");

        javax.swing.GroupLayout pnlthemLayout = new javax.swing.GroupLayout(pnlthem);
        pnlthem.setLayout(pnlthemLayout);
        pnlthemLayout.setHorizontalGroup(
            pnlthemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlthemLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlthemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlthemLayout.createSequentialGroup()
                        .addGroup(pnlthemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel31)
                            .addComponent(jLabel30))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlthemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cblthemmalop, 0, 83, Short.MAX_VALUE)
                            .addComponent(txtlthemmasv))
                        .addGap(49, 49, 49))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlthemLayout.createSequentialGroup()
                        .addComponent(btnlopthemsv)
                        .addGap(29, 29, 29))))
        );
        pnlthemLayout.setVerticalGroup(
            pnlthemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlthemLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlthemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtlthemmasv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlthemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cblthemmalop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnlopthemsv))
        );

        pnlxoa.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Xóa học sinh khỏi lớp", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        btnlopxoasv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sof203_assignment1_ps04271/themdiem.png"))); // NOI18N
        btnlopxoasv.setText("Xóa Sinh Viên");
        btnlopxoasv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlopxoasvActionPerformed(evt);
            }
        });

        txtlxoamasv.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel32.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel32.setText("Mã sv:");

        jLabel33.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel33.setText("Từ lớp");

        javax.swing.GroupLayout pnlxoaLayout = new javax.swing.GroupLayout(pnlxoa);
        pnlxoa.setLayout(pnlxoaLayout);
        pnlxoaLayout.setHorizontalGroup(
            pnlxoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlxoaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlxoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlxoaLayout.createSequentialGroup()
                        .addGroup(pnlxoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlxoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cblxoamalop, 0, 83, Short.MAX_VALUE)
                            .addComponent(txtlxoamasv))
                        .addGap(49, 49, 49))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlxoaLayout.createSequentialGroup()
                        .addComponent(btnlopxoasv)
                        .addGap(29, 29, 29))))
        );
        pnlxoaLayout.setVerticalGroup(
            pnlxoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlxoaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlxoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtlxoamasv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlxoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cblxoamalop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnlopxoasv))
        );

        btnlsvchuacolop.setText("Hiện các sinh viên chưa có lớp");
        btnlsvchuacolop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlsvchuacolopActionPerformed(evt);
            }
        });

        jLabel24.setText("Trong niên khóa:");

        btndthiencaclop.setText("Hiện các lớp");
        btndthiencaclop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndthiencaclopActionPerformed(evt);
            }
        });

        btnldong.setText("Đóng");
        btnldong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnldongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtlmalop, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel26))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtlmagv, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtllop, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel27)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cblkhoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtlnienkhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnldong)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(btndthiencaclop, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbdtnienkhoa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnlsvchuacolop))
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(pnlthem, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlxoa, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlxoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlthem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btndthiencaclop)
                    .addComponent(btnlsvchuacolop))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(cbdtnienkhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtlmalop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtllop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtlmagv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(cblkhoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtlnienkhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnldong)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tbnhanvien.addTab("Lớp", jPanel4);

        jMenu1.setText("Quản lý");

        jMenutaotaikhoan.setText("Tạo tài khoản");
        jMenutaotaikhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenutaotaikhoanActionPerformed(evt);
            }
        });
        jMenu1.add(jMenutaotaikhoan);

        jMenuquanlymatkhau.setText("Quản lý mật khẩu");
        jMenuquanlymatkhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuquanlymatkhauActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuquanlymatkhau);

        jMenuthongtinnhanvien.setText("Thông tin nhân viên");
        jMenuthongtinnhanvien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuthongtinnhanvienActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuthongtinnhanvien);

        jMenuItem2.setText("Thoát");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenudulieu.setText("Dữ liệu");

        jMenusaoluu.setText("Sao Lưu");
        jMenusaoluu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenusaoluuActionPerformed(evt);
            }
        });
        jMenudulieu.add(jMenusaoluu);

        jMenuphuchoi.setText("Phục hồi");
        jMenuphuchoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuphuchoiActionPerformed(evt);
            }
        });
        jMenudulieu.add(jMenuphuchoi);

        jMenuBar1.add(jMenudulieu);

        jMenu2.setText("About");

        jMenuAboutus.setText("About Us");
        jMenuAboutus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAboutusActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuAboutus);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(tbnhanvien))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tbnhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbnhanvien.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtdndangnhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdndangnhapActionPerformed
        
        String taikhoan = txtdntaikhoan.getText();
        char [] chuoimatkhau = txtdnmatkhau.getPassword();
        String matkhau ="";
        for(int i=0;i<chuoimatkhau.length;i++)
        {
            matkhau += chuoimatkhau[i];
        }
        String matkhaumh = mahoaMD5(matkhau);
        try 
        {
            Class.forName(dvsql);
            Connection conn = DriverManager.getConnection(urldb);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select manv, matkhau, loaitaikhoan,ten from nhanvien where manv like'"+taikhoan+"'");
            String taikhoandb="";
            String matkhaudb="";
            int loaitk=-1;
            while(rs.next())
            {
                taikhoandb = rs.getString(1);
                matkhaudb = rs.getString(2);
                loaitk = rs.getInt(3);
                this.tennv= rs.getString(4);
                break;
            }
            conn.close();
            
            
            if(taikhoan.equals(taikhoandb) && matkhaumh.equals(matkhaudb))
            {
                
                if(loaitk ==0)
                {
                    jFrameDangNhap.setVisible(false);
                    quyen(true);this.manv=taikhoandb; jMenutaotaikhoan.setEnabled(true); jMenuquanlymatkhau.setEnabled(true);jMenuthongtinnhanvien.setEnabled(true);
                    btndangnhap.setText("Đăng xuất");checkdangnhap=1;this.loaitaikkhoan=0;
                    JOptionPane.showMessageDialog(jFrameDangNhap, "Đăng nhập thành công với quyền admin");
                    loadten(); Tdanhsachlop.removeAll();loaddbdaotao(tennv);quyentext(false);jMenudulieu.setEnabled(true);
                    return;
                }
                
                if(loaitk ==1)
                {
                    jFrameDangNhap.setVisible(false);
                    quyen(true);
                    this.manv=taikhoandb;
                    this.loaitaikkhoan=1; 
                    txtgvdiemanh.setEditable(false);
                    txtgvdiemtin.setEditable(false);
                    txtgvdiemtoan.setEditable(false);
                    tbnhanvien.setSelectedIndex(0); tbnhanvien.setEnabledAt(1, false);tbnhanvien.setEnabledAt(2, false);
                    tbnhanvien.setEnabledAt(0, true);
                    jMenutaotaikhoan.setEnabled(false);
                    btndangnhap.setText("Đăng xuất");checkdangnhap=1;
                    txtgvmasv.setEditable(false);
                    txtgvtensv.setEditable(false);
                    JOptionPane.showMessageDialog(jFrameDangNhap, "Đăng nhập thành công với quyền giáo viên");
                    loadten();loaddbgiaovien(this.manv); 
                    quyentext(false);
                    return;
                }
                
                if(loaitk ==2)
                {
                    
                    jMenutaotaikhoan.setEnabled(false);
                    quyen(true);
                    quyentextdt(false);
                    this.loaitaikkhoan=2;this.manv=taikhoandb;
                    loaddbdt(); tbnhanvien.setSelectedIndex(1); tbnhanvien.setEnabledAt(0, false);
                    btndangnhap.setText("Đăng xuất");checkdangnhap=1;
                    JOptionPane.showMessageDialog(jFrameDangNhap, "Đăng nhập thành công với quyền đào tạo");
                    jFrameDangNhap.setVisible(false);
                    txtlmalop.setEditable(false);
                    txtlmagv.setEditable(false);
                    txtllop.setEditable(false);
                    txtlnienkhoa.setEditable(false);
                    cblkhoi.setEnabled(false);
                    loaddbdaotao(tennv);
                    loadbang();
                    loadten();
                    quyentext(false);
                    return;
                }
            }
            else
            {
                JOptionPane.showMessageDialog(jFrameDangNhap, "Tài khoản hoặc mật khẩu không đúng!!!");
                return;
            }
            
            
            
        }
        catch (Exception e)
        {
            System.out.println("Lỗi: "+e);
        }
        
         
    }//GEN-LAST:event_txtdndangnhapActionPerformed

    private void btndangnhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndangnhapActionPerformed
        if(checkdangnhap==0)
        {
            jFrameDangNhap.setVisible(true);
            hh.stop();
            return;
        }
        if(checkdangnhap==1)
        {
            btngvdongActionPerformed(evt);
            btndtdongActionPerformed(evt);
            btnldongActionPerformed(evt);
            checkdangnhap=0;
            quyen(false);
            b.clear();
            jFrameDangNhap.setVisible(true);
            jFramedoimatkhau.setVisible(false);
            jFramedttimkiem.setVisible(false);
            jFramegvtimkiem.setVisible(false);
            jFramequanlymk.setVisible(false);
            jFrametaotaikhoan.setVisible(false);
            jFramethongtinnhanvien.setVisible(false);
            jFrameguimailall.setVisible(false);
            jFrameguimaildt.setVisible(false);
            jFrameguimailgv1sv.setVisible(false);
            jFrameguimailgvnhieusv.setVisible(false);
            btndangnhap.setText("Đăng Nhập");
            txtdnmatkhau.setText("");
            txtdntaikhoan.setText("");
            jMenuquanlymatkhau.setEnabled(false);
            jMenuthongtinnhanvien.setEnabled(false);
            jMenudulieu.setEnabled(false);
            Tdanhsachlop.clearSelection();
            Tdanhsachlop.setModel(null);
            Tdanhsachlop.removeAll();
        }
        
    }//GEN-LAST:event_btndangnhapActionPerformed
int checkdtthemsv =0;
    private void btndtthemsvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndtthemsvActionPerformed
        
        if(checkdtthemsv==0)
        {
            
            txtdtmasv.setText("");
            txtdttensv.setText("");
            txtdtcmndsv.setText("");
            txtdtdiachisv.setText("");
            txtdtemailsv.setText("");
            
            txtdtngaynhaphoc.setText("");
            txtdtthangnhaphoc.setText("");
            txtdtnamnhaphoc.setText("");
            txtdtngaysinh.setText("");
            txtdtthangsinh.setText("");
            txtdtnamsinh.setText("");
            btndtsuasv.setEnabled(false);
            btndtxoasv.setEnabled(false);
            btndtthemsv.setText("Lưu");
            tbnhanvien.setEnabledAt(2, false);
            checkdtthemsv=1;
            btndtdong.setEnabled(true);
            quyentextdt(true);
            return;
        }
        if(checkdtthemsv==1)   
        {
        if(checkdaotao()==false){return;}
        try
        {   
            String sinhnhat = txtdtnamsinh.getText()+"/"+ txtdtthangsinh.getText()+"/"+txtdtngaysinh.getText();
            String nhaphoc = txtdtnamnhaphoc.getText()+"/"+ txtdtthangnhaphoc.getText()+"/"+txtdtngaynhaphoc.getText();
            Class.forName(dvsql);
            Connection cnt = DriverManager.getConnection(urldb);
            PreparedStatement psm = cnt.prepareStatement("insert into sinhvien(masv,ten,gioitinh, ngaysinh, cmnd, email, diachi, ngaynhaphoc) values(?,?,?,?,?,?,?,?)");
            psm.setString(1, txtdtmasv.getText());
            psm.setString(2,txtdttensv.getText() );
            int a =0; if(rbdtnam.isSelected()){a=0;}else {a=1;} psm.setInt(3,a);
            psm.setString(4, sinhnhat);
            psm.setString(5, txtdtcmndsv.getText() );
            psm.setString(6,txtdtemailsv.getText() );
            psm.setString(7, txtdtdiachisv.getText() );
            psm.setString(8, nhaphoc );
            psm.execute();
            cnt.close();
            quyentextdt(false);
            btndtsuasv.setEnabled(true);
            btndtxoasv.setEnabled(true);
            tbnhanvien.setEnabledAt(2, true);
            btndtthemsv.setText("Thêm Sinh Viên");
            checkdtthemsv=1;
            btndtdong.setEnabled(false);
            loaddbdt();
            JOptionPane.showMessageDialog(this, "Thêm thành công!");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Thêm thất bại! \n Lỗi: "+e);
        }
        }
    }//GEN-LAST:event_btndtthemsvActionPerformed
int checkdtsuasv=0;
    private void btndtsuasvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndtsuasvActionPerformed
        if(checkdaotao()==false){return;}
        if(checkdtsuasv==0)
        {
            quyentextdt(true);
            btndtsuasv.setText("Lưu");
            btndtthemsv.setEnabled(false);
            btndtxoasv.setEnabled(false);
            tbnhanvien.setEnabledAt(2, false);
            btndtdong.setEnabled(true);
            checkdtsuasv=1;
            return;
        }
        
        if(checkdtsuasv==1)
        {
        try
        {   
            String sinhnhat = txtdtnamsinh.getText()+"/"+ txtdtthangsinh.getText()+"/"+txtdtngaysinh.getText();
            String nhaphoc = txtdtnamnhaphoc.getText()+"/"+ txtdtthangnhaphoc.getText()+"/"+txtdtngaynhaphoc.getText();
            Class.forName(dvsql);
            Connection cnt = DriverManager.getConnection(urldb);
            PreparedStatement psm = cnt.prepareStatement("update sinhvien set ten = ?, gioitinh=?, ngaysinh=?,cmnd=?,email=?, diachi=?, ngaynhaphoc=? where masv =? ");
            psm.setString(8, txtdtmasv.getText());
            psm.setString(1,txtdttensv.getText() );
            int a =0; if(rbdtnam.isSelected()){a=0;}else {a=1;} psm.setInt(2,a);
            psm.setString(3, sinhnhat);
            psm.setString(4, txtdtcmndsv.getText() );
            psm.setString(5,txtdtemailsv.getText() );
            psm.setString(6, txtdtdiachisv.getText() );
            psm.setString(7, nhaphoc );
            psm.execute();
            cnt.close();
            quyentextdt(false);
            btndtsuasv.setText("Sửa Sinh Viên");
            btndtthemsv.setEnabled(true);
            btndtxoasv.setEnabled(true);
            tbnhanvien.setEnabledAt(2, true);
            btndtdong.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Sửa thành công!");
            checkdtsuasv=0;
            loaddbdt();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Thêm thất bại! \n Lỗi: "+e);
        }
        }
    }//GEN-LAST:event_btndtsuasvActionPerformed

    private void tbthongtinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbthongtinMouseClicked
        loadbang();
    }//GEN-LAST:event_tbthongtinMouseClicked

    private void btndtxoasvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndtxoasvActionPerformed
        
        int [] tt=tbthongtin.getSelectedRows();
        if(tt.length<=0)return;
        
        String sqlquerry = "delete from sinhvien where masv=? and ten =?";
        try
        {
            Class.forName(dvsql);
            Connection cnt = DriverManager.getConnection(urldb);
            PreparedStatement ps = cnt.prepareStatement(sqlquerry);
            
            int n = JOptionPane.showConfirmDialog(this,"Bạn có muốn xóa điểm sinh viên có mã "+txtdtmasv.getText(),"Xác thực",JOptionPane.YES_NO_OPTION);
            if(n==JOptionPane.YES_OPTION)
            {
                for(int i=0;i<tt.length;i++)
                {
                String ma = tbthongtin.getValueAt(tt[i], 0).toString();
                String ten = tbthongtin.getValueAt(tt[i], 1).toString();
                ps.setString(1, ma);
                ps.setString(2, ten);
                ps.execute();
                }
            cnt.close();
            JOptionPane.showMessageDialog(rootPane, "Xóa thành công");
            loaddbdt();
            
            }
            else{cnt.close();return;}
            
            
        }
        catch(Exception e)  
        {
            JOptionPane.showMessageDialog(rootPane, "Lỗi: "+e);
        }
        
    }//GEN-LAST:event_btndtxoasvActionPerformed
int checklthem=0;
    private void btnlthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlthemActionPerformed
        if(checklthem==0)
        {
            txtlmalop.setText("");
            txtlmagv.setText("");
            txtllop.setText("");
            txtlnienkhoa.setText("");
            tbnhanvien.setEnabledAt(1, false);
            quyenchinhlop(true);
            btnlxoalop.setEnabled(false);
            btnlsualop.setEnabled(false);
            btnlthem.setText("Lưu");
            btnlopthemsv.setEnabled(false);
            btnlopxoasv.setEnabled(false);
            checklthem=1;
            btnldong.setEnabled(true);
            return;
        }
        if(checklthem==1)
        {
        if(checklop()==false){return;}
        try
        {   
            Class.forName(dvsql);
            Connection cnt = DriverManager.getConnection(urldb);
            PreparedStatement psm = cnt.prepareStatement("insert into lop(malop,lop,manv,khoi,nienkhoa) values(?,?,?,?,?)");
            psm.setString(1, txtlmalop.getText());
            psm.setString(2,txtllop.getText() );
            psm.setString(4,cblkhoi.getSelectedItem().toString() );
            psm.setString(3, txtlmagv.getText());
            psm.setString(5, txtlnienkhoa.getText() );
            psm.execute();
            cnt.close();
            tbnhanvien.setEnabledAt(1, true);
            quyenchinhlop(false);
            btnlxoalop.setEnabled(true);
            btnlsualop.setEnabled(true);
            btnlthem.setText("Thêm Lớp");
            checklthem=0;
            btnldong.setEnabled(false);
            loaddblop();
            loadbang();
            JOptionPane.showMessageDialog(this, "Thêm thành công!");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Thêm thất bại! \n Lỗi: "+e);
        }
        }
    }//GEN-LAST:event_btnlthemActionPerformed
int checklsua =0;
    private void btnlsualopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlsualopActionPerformed
        if(checklsua==0)
        {
            tbnhanvien.setEnabledAt(1, false);
            quyenchinhlop(true);
            btnlxoalop.setEnabled(false);
            btnlthem.setEnabled(false);
            btnlsualop.setText("Lưu");
            checklsua=1;
            btnlopthemsv.setEnabled(false);
            btnlopxoasv.setEnabled(false);
            btnldong.setEnabled(true);
            return;
        }
        if(checklsua==1)
        {
        
        if(checklop()==false){return;}
        try
        {   
            Class.forName(dvsql);
            Connection cnt = DriverManager.getConnection(urldb);
            PreparedStatement psm = cnt.prepareStatement("update lop set khoi=?, lop=?,manv=?,nienkhoa=? where malop =? ");
            psm.setString(5, txtlmalop.getText());
            psm.setString(1,cblkhoi.getSelectedItem().toString() );
            psm.setString(2, txtllop.getText());
            psm.setString(3, txtlmagv.getText() );
            psm.setString(4,txtlnienkhoa.getText() );
            psm.execute();
            cnt.close();
            tbnhanvien.setEnabledAt(1, true);
            quyenchinhlop(false);
            btnlxoalop.setEnabled(true);
            btnlthem.setEnabled(true);
            btnlsualop.setText("Sửa Lớp");
            loaddblop();
            loadbang();
            checklsua=0;
            btnldong.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Sửa thành công!");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Sửa thất bại! \n Lỗi: "+e);
        }    
        }
    }//GEN-LAST:event_btnlsualopActionPerformed

    private void btnlxoalopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlxoalopActionPerformed
        int [] tt=tbthongtin.getSelectedRows();
        if(tt.length<=0)return;
        
        String sqlquerry = "delete from lop where malop=?";
        try
        {
            Class.forName(dvsql);
            Connection cnt = DriverManager.getConnection(urldb);
            PreparedStatement ps = cnt.prepareStatement(sqlquerry);
             int n = JOptionPane.showConfirmDialog(this,"Bạn có muốn xóa lớp có mã "+txtlmalop.getText(),"Xác thực",JOptionPane.YES_NO_OPTION);
            if(n==JOptionPane.YES_OPTION)
            {
            for(int i=0;i<tt.length;i++)
            {
                String malop = tbthongtin.getValueAt(tt[i], 0).toString();
                ps.setString(1, malop);
                ps.execute();
            }
            
            cnt.close();
            loaddblop();
            loadbang();
            JOptionPane.showMessageDialog(this, "Xóa thành công");
            return;
            }else{cnt.close();}
        }
        catch(Exception e)  
        {
            JOptionPane.showMessageDialog(this, "Xóa thất bại!!! Lỗi: "+e);
        }
    }//GEN-LAST:event_btnlxoalopActionPerformed

    private void tbnhanvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbnhanvienMouseClicked
        
    }//GEN-LAST:event_tbnhanvienMouseClicked

    private void btnlopthemsvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlopthemsvActionPerformed
        if(txtlthemmasv.getText().trim().equals(""))
        {
            int [] t = tbthongtin.getSelectedRows();
            if(t.length<=0){return;}
        try
        {   
            Class.forName(dvsql);
            Connection cnt = DriverManager.getConnection(urldb);
            
            
            for(int i =0;i<t.length;i++)
            {
            PreparedStatement psm = cnt.prepareStatement("insert into diem(malop,masv) values(?,?)");
            psm.setString(1, cblthemmalop.getSelectedItem().toString());
            psm.setString(2, tbthongtin.getValueAt(t[i], 0).toString());
            psm.execute();
            }
            
            cnt.close();
            loadbangtutree();
            JOptionPane.showMessageDialog(this, "Thêm thành công!");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Thêm thất bại! \n Lỗi: "+e);
        }
            return;
        }
        
         try
        {   
            Class.forName(dvsql);
            Connection cnt = DriverManager.getConnection(urldb);
            PreparedStatement psm = cnt.prepareStatement("insert into diem(malop,masv) values(?,?)");
            psm.setString(1, cblthemmalop.getSelectedItem().toString());
            psm.setString(2, txtlthemmasv.getText());
            psm.execute();
            cnt.close();
            loadbangtutree();
            JOptionPane.showMessageDialog(this, "Thêm thành công!");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Thêm thất bại! \n Lỗi: "+e);
        }
        
        
        
    }//GEN-LAST:event_btnlopthemsvActionPerformed
int checkchonlop=0;
    private void tbnhanvienStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tbnhanvienStateChanged
        if(tbnhanvien.getSelectedIndex()==1){checkchonlop=0;loaddbdt();loadbang();return;}
        if(tbnhanvien.getSelectedIndex()==2 && checkchonlop==0)
            {
                loaddblop();
                loadbang();
                checkchonlop=1; btnlopthemsv.setEnabled(false);btnlopxoasv.setEnabled(false);
            }
    }//GEN-LAST:event_tbnhanvienStateChanged

    private void btnlopxoasvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlopxoasvActionPerformed
        if(txtlxoamasv.getText().trim().equals(""))
        {
        int []t = tbthongtin.getSelectedRows();
        if(t.length<=0){return;}
        try
        {   
            Class.forName(dvsql);
            Connection cnt = DriverManager.getConnection(urldb);
            for(int i=0;i<t.length;i++){
            PreparedStatement psm = cnt.prepareStatement("delete from diem where masv like ? and malop like ?");
            psm.setString(2, cblxoamalop.getSelectedItem().toString());
            psm.setString(1, tbthongtin.getValueAt(t[i],0).toString());
            psm.execute();
            }
            cnt.close();
            loadbangtutree();
            JOptionPane.showMessageDialog(this, "Xóa thành công!");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Xóa thất bại! \n Lỗi: "+e);
        }
        return;
        }
        try
        {   
            Class.forName(dvsql);
            Connection cnt = DriverManager.getConnection(urldb);
            PreparedStatement psm = cnt.prepareStatement("delete from diem where masv =? and malop=?");
            psm.setString(2, cblxoamalop.getSelectedItem().toString());
            psm.setString(1, txtlxoamasv.getText());
            psm.execute();
            cnt.close();
            loadbangtutree();
            JOptionPane.showMessageDialog(this, "Xóa thành công!");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Xóa thất bại! \n Lỗi: "+e);
        }
        
    }//GEN-LAST:event_btnlopxoasvActionPerformed

    private void jMenutaotaikhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenutaotaikhoanActionPerformed
        jFrametaotaikhoan.setVisible(true);
    }//GEN-LAST:event_jMenutaotaikhoanActionPerformed

    private void btntaotkthoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntaotkthoatActionPerformed
        jFrametaotaikhoan.setVisible(false);
        txttaotkmanv.setText("");
        txttaotktennv.setText("");
        passtaotkmatkhau.setText("");
        passtaotknhaplaimk.setText("");
    }//GEN-LAST:event_btntaotkthoatActionPerformed

    private void btntaotktaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntaotktaoActionPerformed
        if(txttaotkmanv.getText().length()>10){JOptionPane.showMessageDialog(jFrametaotaikhoan,"Mã nhân viên quá dài" );return;}
        if(txttaotktennv.getText().length()>40){JOptionPane.showMessageDialog(jFrametaotaikhoan,"Tên nhân viên quá dài" );return;}
        if(txttaotkmanv.getText().trim().equals("")){JOptionPane.showMessageDialog(jFrametaotaikhoan,"Mã nhân viên trống" );return;}
        if(txttaotktennv.getText().trim().equals("")){JOptionPane.showMessageDialog(jFrametaotaikhoan,"Mã nhân viên trống" );return;}
        if(passtaotkmatkhau.getText().trim().equals("")){JOptionPane.showMessageDialog(jFrametaotaikhoan,"Mật khẩu nhân viên trống" );return;}
        if(passtaotknhaplaimk.getText().trim().equals("")){JOptionPane.showMessageDialog(jFrametaotaikhoan,"Nhập lại mật khẩu trống" );return;}
        
        char [] chuoimatkhau = passtaotkmatkhau.getPassword();
        char [] chuoinhaplaimatkhau = passtaotknhaplaimk.getPassword();
        
        String matkhau ="";
        String nhaplai="";
        try{
        for(int i=0;i<chuoimatkhau.length;i++)
        {
            matkhau += chuoimatkhau[i];
            nhaplai+=chuoinhaplaimatkhau[i];
        }
        }
        catch(Exception e){JOptionPane.showMessageDialog(jFrametaotaikhoan,"Mật khẩu và nhập lại không khớp" );return;}
        if(!matkhau.equals(nhaplai)){JOptionPane.showMessageDialog(jFrametaotaikhoan,"Mật khẩu và nhập lại không khớp" );return;}
        String matkhaumh = mahoaMD5(matkhau);
        String manv =txttaotkmanv.getText();
        String tennv = txttaotktennv.getText();
        int loaitaikhoan = cbtaoloai.getSelectedIndex();
        try
        {   
            Class.forName(dvsql);
            Connection cnt = DriverManager.getConnection(urldb);
            PreparedStatement psm = cnt.prepareStatement("insert into nhanvien(manv,ten,matkhau,loaitaikhoan) values(?,?,?,?)");
            psm.setString(1,manv);
            psm.setString(2,tennv);
            psm.setString(3,matkhaumh);
            psm.setInt(4,loaitaikhoan);
            psm.execute();
            cnt.close();
            JOptionPane.showMessageDialog(jFrametaotaikhoan, "Tạo tài khoản thành công!");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(jFrametaotaikhoan, "Tạo tài khoản thất bại! \n Lỗi: "+e);
        }
        
    }//GEN-LAST:event_btntaotktaoActionPerformed

    private void TdanhsachlopValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_TdanhsachlopValueChanged
        if(checkdangnhap==0){return;}
        loadbangtutree();
    }//GEN-LAST:event_TdanhsachlopValueChanged

    int checkgvsuadiem=0;
    private void btngvsuadiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngvsuadiemActionPerformed
        if(checkgvsuadiem==0)
        {
            btngvsuadiem.setText("Lưu");
            btngvxoadiem.setEnabled(false);
            txtgvdiemanh.setEditable(true);
            txtgvdiemtin.setEditable(true);
            txtgvdiemtoan.setEditable(true);
            checkgvsuadiem=1;
            btngvdong.setEnabled(true);
            return;
        }
        
        if(checkgvsuadiem==1){
        try{if(Float.parseFloat(txtgvdiemtoan.getText())>10 || Float.parseFloat(txtgvdiemtoan.getText())<0){JOptionPane.showMessageDialog(this, "Điểm Toán không hợp lệ"); return;}}
        catch (Exception e){ JOptionPane.showMessageDialog(this, "Điểm Toán không hợp lệ"+e); return;}
        try{if(Float.parseFloat(txtgvdiemanh.getText())>10 || Float.parseFloat(txtgvdiemanh.getText())<0){JOptionPane.showMessageDialog(this, "Điểm Anh không hợp lệ"); return;}}
        catch (Exception e){ JOptionPane.showMessageDialog(this, "Điểm Toán không hợp lệ"+e); return;}
        try{if(Float.parseFloat(txtgvdiemtin.getText())>10 || Float.parseFloat(txtgvdiemtin.getText())<0){JOptionPane.showMessageDialog(this, "Điểm Tin không hợp lệ"); return;}}
        catch (Exception e){ JOptionPane.showMessageDialog(this, "Điểm Toán không hợp lệ"+e); return;}
        
        try
        {   
            String tt = Tdanhsachlop.getSelectionPath().toString();
            Class.forName(dvsql);
            Connection cnt = DriverManager.getConnection(urldb);
            PreparedStatement psm = cnt.prepareStatement("update diem set diemtoan=?, diemtin=?,diemanh=? where masv =? and malop like (select malop from lop where lop like SUBSTRING('"+tt+"',31,charindex(']','"+tt+"')-31))");
            psm.setFloat(1,Float.parseFloat(txtgvdiemtoan.getText()));
            psm.setFloat(2, Float.parseFloat(txtgvdiemtin.getText()));
            psm.setFloat(3, Float.parseFloat(txtgvdiemanh.getText()) );
            psm.setString(4,txtgvmasv.getText() );
            psm.execute();
            cnt.close();
            checkgvsuadiem=0;
            btngvsuadiem.setText("Sửa điểm");
            btngvxoadiem.setEnabled(true);
            txtgvdiemanh.setEditable(false);
            txtgvdiemtin.setEditable(false);
            txtgvdiemtoan.setEditable(false);
            btngvdong.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Sửa thành công!");
            loadtop3();
            loadbangtutree();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Sửa thất bại! \n Lỗi: "+e);
        }     
        }
        
    }//GEN-LAST:event_btngvsuadiemActionPerformed

    private void btngvxoadiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngvxoadiemActionPerformed
        try
        {   
            int [] tt=tbthongtin.getSelectedRows();
            if(tt.length<=0)return;
            int n = JOptionPane.showConfirmDialog(this,"Bạn có muốn xóa điểm các sinh viên này!!! ","Xác thực",JOptionPane.YES_NO_OPTION);
            if(n==JOptionPane.YES_OPTION)
            {
            Class.forName(dvsql);
            Connection cnt = DriverManager.getConnection(urldb);
            PreparedStatement psm = cnt.prepareStatement("update diem set diemtoan=?, diemtin=?,diemanh=? where masv =? ");
            psm.setFloat(1,0);
            psm.setFloat(2, 0);
            psm.setFloat(3,0 );
            for(int i=0;i<tt.length;i++)
            {
            psm.setString(4,tbthongtin.getValueAt(tt[i], 0).toString() );
            psm.execute();
            }
            JOptionPane.showMessageDialog(this, "Xóa thành công!");
            cnt.close();
            loadtop3();
            loadbangtutree();
            }
            else{return;}
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Xóa thất bại! \n Lỗi: "+e);
        }        
    }//GEN-LAST:event_btngvxoadiemActionPerformed

    private void btndoimatkhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndoimatkhauActionPerformed
        jFramedoimatkhau.setVisible(true);
    }//GEN-LAST:event_btndoimatkhauActionPerformed

    private void btndmkdoimkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndmkdoimkActionPerformed
        char [] chuoimatkhaucu = passdmkmkcu.getPassword();
        char [] chuoimatkhaumoi = passdmkmkmoi.getPassword();
        char [] chuoinhaplai = passdmknhaplai.getPassword();
        String matkhaucu ="";
        String matkhaumoi ="";
        String matkhaunhaplai ="";
        
        for(int i=0;i<chuoimatkhaucu.length;i++)
        {
            matkhaucu += chuoimatkhaucu[i];
        }
        
        for(int i=0;i<chuoimatkhaumoi.length;i++)
        {
            matkhaumoi += chuoimatkhaumoi[i];
        }
        
        for(int i=0;i<chuoinhaplai.length;i++)
        {
            matkhaunhaplai += chuoinhaplai[i];
        }
        String matkhaumh = mahoaMD5(matkhaucu);
        String matkhaumoimh = mahoaMD5(matkhaumoi);
        String nhaplaimh = mahoaMD5(matkhaunhaplai);
        try 
        {
            Class.forName(dvsql);
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=quanlysinhvien","sa","123456");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select manv, matkhau from nhanvien where manv like'"+manv+"'");
            String taikhoandb="";
            String matkhaudb="";
            while(rs.next())
            {
                taikhoandb = rs.getString(1);
                matkhaudb = rs.getString(2);
                break;
            }
            if(this.manv.equals(taikhoandb) && matkhaumh.equals(matkhaudb))
            {
                if(matkhaumoimh.equals(nhaplaimh))
                {
                    st.execute("update nhanvien set matkhau ='"+matkhaumoimh+"' where manv like '"+this.manv+"'");
                    JOptionPane.showMessageDialog(rootPane, "Đổi mật khẩu thành công!!!");
                    jFramedoimatkhau.setVisible(false);
                }
                else{JOptionPane.showMessageDialog(rootPane, "Nhập lại mật khẩu không giống!!!");return;}
            }
            else{JOptionPane.showMessageDialog(rootPane, "Mật khẩu cũ sai!!!");return;}
            
        }catch(Exception e){}
        
    }//GEN-LAST:event_btndmkdoimkActionPerformed

    private void lbhinhdtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbhinhdtMouseClicked
        puhinh.show(evt.getComponent(), evt.getX(), evt.getY());
    }//GEN-LAST:event_lbhinhdtMouseClicked

    private void jMenuAboutusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAboutusActionPerformed
        JOptionPane.showMessageDialog(this, " Teacher's Helper Version 1.0 \n Coder: Rjk Rắc Rối \n Designer: Rjk Rắc Rối \n Hợp tác: 0938793761");
    }//GEN-LAST:event_jMenuAboutusActionPerformed

    private void btngvxuatexcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngvxuatexcelActionPerformed
        xuatexcel();
    }//GEN-LAST:event_btngvxuatexcelActionPerformed

    private void btnlsvchuacolopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlsvchuacolopActionPerformed
         try{
             
        Class.forName(dvsql);
        Connection cnt = DriverManager.getConnection(urldb);
        String sqlquerry = "select masv,ten,(case when gioitinh=0 then 'Nam' else N'Nữ' end),convert(varchar,ngaysinh,103),cmnd,email,diachi,convert(varchar,ngaynhaphoc,103) from sinhvien where masv not in (select masv from diem d join lop l on d.malop = l.malop where l.nienkhoa like '"+cbdtnienkhoa.getSelectedItem().toString()+"')";
        Statement sm = cnt.createStatement();
        ResultSet rs = sm.executeQuery(sqlquerry);
        bang = new DefaultTableModel(title,0);
            Vector sv = null;
            if(rs.isBeforeFirst() == false){JOptionPane.showMessageDialog(rootPane, "Không có học sinh nào");return;}
            while(rs.next())
            {
                sv = new Vector();
                sv.add(rs.getString(1));
                sv.add(rs.getString(2));
                sv.add(rs.getString(3));
                sv.add(rs.getString(4));
                sv.add(rs.getString(5));
                sv.add(rs.getString(6));
                sv.add(rs.getString(7));
                sv.add(rs.getString(8));
                
                bang.addRow(sv);
                
            }
            tbthongtin.setModel(bang);
            tbthongtin.setRowSelectionInterval(0, 0);
            cnt.close();
            btnlopthemsv.setEnabled(true);
                btnlopxoasv.setEnabled(false);
        }
        catch(Exception a){JOptionPane.showMessageDialog(this, "Lỗi: "+a);}
    }//GEN-LAST:event_btnlsvchuacolopActionPerformed

    private void btndthiencaclopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndthiencaclopActionPerformed
        try{
        Class.forName(dvsql);
        Connection cnt = DriverManager.getConnection(urldb);
        String sqlquerry = "select malop,lop,manv,khoi,nienkhoa from lop where nienkhoa like '"+cbdtnienkhoa.getSelectedItem()+"'";
        Statement sm = cnt.createStatement();
        ResultSet rs = sm.executeQuery(sqlquerry);
            String [] title1 = {"Mã Lớp","Lớp","Mã Giáo Viên","Khối","Niên khóa"};
            bang = new DefaultTableModel(title1,0);
            cblthemmalop.removeAllItems();
            cblxoamalop.removeAllItems();
            Vector sv = null;
            if(rs.isBeforeFirst() == false){JOptionPane.showMessageDialog(rootPane, "Chưa có lớp!!!");return;}
            
            while(rs.next())
            {
                sv = new Vector();
                sv.add(rs.getString(1));
                sv.add(rs.getString(2));
                sv.add(rs.getString(3));
                sv.add(rs.getString(4));
                sv.add(rs.getString(5));
                bang.addRow(sv);
                cblthemmalop.addItem(rs.getString(1));
                cblxoamalop.addItem(rs.getString(1));
            }
            tbthongtin.setModel(bang);
            tbthongtin.setRowSelectionInterval(0, 0);
            cnt.close();
            btnlopthemsv.setEnabled(false);
            btnlopxoasv.setEnabled(false);
        }
        catch(Exception a){JOptionPane.showMessageDialog(rootPane, "Lỗi: "+a);}
    }//GEN-LAST:event_btndthiencaclopActionPerformed

    private void jMenuquanlymatkhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuquanlymatkhauActionPerformed
        jFramequanlymk.setVisible(true);
        txtqlmkmkmoi.setText("");
        try{
        Class.forName(dvsql);
        Connection cnt = DriverManager.getConnection(urldb);
        String sqlquerry2 = "select manv from nhanvien";
        Statement sm1 = cnt.createStatement();
        ResultSet rs1 = sm1.executeQuery(sqlquerry2);
        cbqlmktaikhoan.removeAllItems();
            if(rs1.isBeforeFirst() == false){JOptionPane.showMessageDialog(rootPane, "Chưa có tài khoản!!!");return;}
            while(rs1.next())
            {
                cbqlmktaikhoan.addItem(rs1.getString(1));
            }
            cnt.close();
        }
        catch(Exception a){JOptionPane.showMessageDialog(rootPane, "Lỗi: "+a);}
    }//GEN-LAST:event_jMenuquanlymatkhauActionPerformed

    private void btnqlmkdongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnqlmkdongActionPerformed
        jFramequanlymk.setVisible(false);
    }//GEN-LAST:event_btnqlmkdongActionPerformed

    private void btnqlmkdoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnqlmkdoiActionPerformed
        char [] chuoimatkhaumoi = txtqlmkmkmoi.getPassword();
        String matkhaumoi ="";
        for(int i=0;i<chuoimatkhaumoi.length;i++)
        {
            matkhaumoi += chuoimatkhaumoi[i];
        }
        String matkhaumoimh = mahoaMD5(matkhaumoi);
        try 
        {
            Class.forName(dvsql);
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=quanlysinhvien","sa","123456");
            Statement st = conn.createStatement();
            st.execute("update nhanvien set matkhau ='"+matkhaumoimh+"' where manv like '"+cbqlmktaikhoan+"'");
            JOptionPane.showMessageDialog(rootPane, "Đổi mật khẩu thành công!!!");
        }catch(Exception e){JOptionPane.showMessageDialog(rootPane, "Đổi mật khẩu thất bại!!! \n"+e);}
    }//GEN-LAST:event_btnqlmkdoiActionPerformed

    private void jMenuthongtinnhanvienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuthongtinnhanvienActionPerformed
            jFramethongtinnhanvien.setVisible(true);
            txtqlnvma.setEditable(false);
            txtqlnvtennv.setEditable(false);
            cbqlnvchucvu.setEnabled(false);
        loaddbttnv();
        
    }//GEN-LAST:event_jMenuthongtinnhanvienActionPerformed

    private void tbqlnvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbqlnvMouseClicked
        
            try{
                int t = tbqlnv.getSelectedRow();
                if(t<0)return;
                txtqlnvma.setText(tbqlnv.getValueAt(t,0).toString());
                txtqlnvtennv.setText(tbqlnv.getValueAt(t,1).toString());
                cbqlnvchucvu.setSelectedIndex(Integer.parseInt(tbqlnv.getValueAt(t,2).toString()));
                txtqlnvemail.setText(tbqlnv.getValueAt(t,4).toString());
                Class.forName(dvsql);
                Connection cnt = DriverManager.getConnection(urldb);
                String sqlquerry = "select hinhanh from nhanvien where manv like '"+txtqlnvma.getText()+"'";
                Statement sm = cnt.createStatement();
                ResultSet rs = sm.executeQuery(sqlquerry);
            while(rs.next())
            {
               if(rs.getString(1).equals("/sof203_assignment1_ps04271/hinhanh/noimage.png"))
               {lbqlnvhinh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sof203_assignment1_ps04271/hinhanh/noimage.png")));}
               else{lbqlnvhinh.setIcon(load(rs.getString(1), 100, 134));}
               break;
            }
            cnt.close();
        }
        catch(Exception a){JOptionPane.showMessageDialog(this, "Lỗi: "+a);}
            return;
        
        
    }//GEN-LAST:event_tbqlnvMouseClicked
    int checkthaydoinv =0;
    private void btnqlnvthaydoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnqlnvthaydoiActionPerformed
        if(this.checkthaydoinv==0)
        {
            
            txtqlnvtennv.setEditable(true);
            cbqlnvchucvu.setEnabled(true);
            txtqlnvemail.setEditable(true);
            btnqlnvthaydoi.setText("Lưu");
            this.checkthaydoinv =1;
            return;
        }
        
        if(this.checkthaydoinv==1)
        {
            try
        {   
            Class.forName(dvsql);
            Connection cnt = DriverManager.getConnection(urldb);
            PreparedStatement psm = cnt.prepareStatement("update nhanvien set ten=?, loaitaikhoan=?, email=? where manv =? ");
            psm.setString(1, txtqlnvtennv.getText());
            psm.setInt(2, cbqlnvchucvu.getSelectedIndex());
            psm.setString(4, txtqlnvma.getText());
            psm.setString(3, txtqlnvemail.getText());
            psm.execute();
            cnt.close();
            txtqlnvtennv.setEditable(false);
            cbqlnvchucvu.setEnabled(false);
            txtqlnvemail.setEditable(false);
            btnqlnvthaydoi.setText("Thay Đổi");
            this.checkthaydoinv =0;
            JOptionPane.showMessageDialog(jFramethongtinnhanvien, "Sửa Thành Công!!");
            loaddbttnv();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(jFramethongtinnhanvien, "Sửa thất bại! \n Lỗi: "+e);
        }
        }
            
    }//GEN-LAST:event_btnqlnvthaydoiActionPerformed

    private void btnqlnvdongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnqlnvdongActionPerformed
        txtqlnvtennv.setText("");
        txtqlnvtennv.setEditable(false);
        cbqlnvchucvu.setEnabled(false);
        btnqlnvthaydoi.setText("Thay Đổi");
        this.checkthaydoinv =0;
        jFramethongtinnhanvien.setVisible(false);
    }//GEN-LAST:event_btnqlnvdongActionPerformed

    private void btnqlnvxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnqlnvxoaActionPerformed
        int []t = tbqlnv.getSelectedRows();
        if(t.length<=0){return;}
        int n = JOptionPane.showConfirmDialog(this,"Bạn có muốn xóa các nhân viên đã chọn?","Xác thực",JOptionPane.YES_NO_OPTION);
            if(n!=JOptionPane.YES_OPTION){return;}
        
        try
        {   
            Class.forName(dvsql);
            Connection cnt = DriverManager.getConnection(urldb);
            for(int i=0;i<t.length;i++){
            PreparedStatement psm = cnt.prepareStatement("delete from nhanvien where manv =?");
            psm.setString(1, tbqlnv.getValueAt(t[i], 0).toString());
            psm.execute();
            }
            cnt.close();
            loadbangtutree();
            JOptionPane.showMessageDialog(this, "Xóa thành công!");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Xóa thất bại! \n Lỗi: "+e);
        }        
    }//GEN-LAST:event_btnqlnvxoaActionPerformed

    private void lbqlnvhinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbqlnvhinhMouseClicked
        puhinhnv.show(evt.getComponent(), evt.getX(), evt.getY());
    }//GEN-LAST:event_lbqlnvhinhMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
            int n = JOptionPane.showConfirmDialog(this,"Bạn có muốn Thoát?","Xác thực",JOptionPane.YES_NO_OPTION);
            if(n!=JOptionPane.YES_OPTION){return;}
            System.exit(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
            int n = JOptionPane.showConfirmDialog(this,"Bạn có muốn Thoát?","Xác thực",JOptionPane.YES_NO_OPTION);
            if(n!=JOptionPane.YES_OPTION){return;}
            System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btngvdongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngvdongActionPerformed
        btngvsuadiem.setText("Sửa điểm");
        btngvxoadiem.setEnabled(true);
        txtgvmasv.setEditable(false);
        txtgvtensv.setEditable(false);
        txtgvdiemanh.setEditable(false);
        txtgvdiemtin.setEditable(false);
        txtgvdiemtoan.setEditable(false);
        btngvdong.setEnabled(false);
        checkgvsuadiem=0;
        loadbang();
    }//GEN-LAST:event_btngvdongActionPerformed

    private void btndtdongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndtdongActionPerformed
        btndtthemsv.setText("Thêm Sinh Viên");
        btndtsuasv.setText("Sửa Sinh Viên");
        btndtthemsv.setEnabled(true);
        btndtsuasv.setEnabled(true);
        btndtxoasv.setEnabled(true);
        checkdtthemsv=0;
        checkdtsuasv=0;
        txtdtmasv.setEditable(false);
        txtdttensv.setEditable(false);
        txtdtngaysinh.setEditable(false);
        txtdtthangsinh.setEditable(false);
        txtdtnamsinh.setEditable(false);
        txtdtcmndsv.setEditable(false);
        txtdtdiachisv.setEditable(false);
        txtdtemailsv.setEditable(false);
        txtdtemailsv.setEditable(false);
        txtdtngaynhaphoc.setEditable(false);
        txtdtthangnhaphoc.setEditable(false);
        txtdtnamnhaphoc.setEditable(false);
        rbdtnam.setEnabled(false);
        rbdtnu.setEnabled(false);
        btndtdong.setEnabled(false);
        tbnhanvien.setEnabledAt(2, true);
        loadbang();
    }//GEN-LAST:event_btndtdongActionPerformed

    private void btnldongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnldongActionPerformed
        btnlthem.setText("Thêm Lớp");
        btnlsualop.setText("Sửa Lớp");
        btnlxoalop.setEnabled(true);
        btnlthem.setEnabled(true);
        btnlsualop.setEnabled(true);
        checklsua=0;
        checklthem=0;
        txtlmalop.setEditable(false);
        txtllop.setEditable(false);
        txtlmagv.setEditable(false);
        txtlnienkhoa.setEditable(false);
        cblkhoi.setEditable(false);
        loadbang();
        btnldong.setEnabled(false);
        tbnhanvien.setEnabledAt(1, true);
    }//GEN-LAST:event_btnldongActionPerformed

    private void btngvtimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngvtimkiemActionPerformed
        jFramegvtimkiem.setVisible(true);
        txtgvtkmasv.setText("");
        txtgvtktensv.setText("");
        txtgvtklopsv.setText("");
        txtgvtkdiemsv.setText("");
        try{
        Class.forName(dvsql);
        Connection cnt = DriverManager.getConnection(urldb);
        String sqlquerry = "select nienkhoa from lop group by nienkhoa";
        Statement sm = cnt.createStatement();
        ResultSet rs = sm.executeQuery(sqlquerry);
        cbgvtknam.removeAllItems();
            while(rs.next())
            {
                cbgvtknam.addItem(rs.getString(1));
            }
            cnt.close();
        }
        catch(Exception a){JOptionPane.showMessageDialog(this, "Lỗi: "+a);}
    }//GEN-LAST:event_btngvtimkiemActionPerformed

    private void btngvtktimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngvtktimActionPerformed
        if(tbnhanvien.getSelectedIndex()!=0){JOptionPane.showMessageDialog(this, "Hãy chọn tag Giáo Viên!!");return;}
        if(txtgvtkdiemsv.getText().trim().isEmpty() == false){
        try{if(Float.parseFloat(txtgvtkdiemsv.getText())>10 || Float.parseFloat(txtgvtkdiemsv.getText())<0){JOptionPane.showMessageDialog(this, "Điểm không hợp lệ"); return;}}
        catch (Exception e){ JOptionPane.showMessageDialog(this, "Điểm không hợp lệ: "+e); return;}
        }
        String masv ="%";
        String tensv="%";
        String lopsv ="%";
        String namhoc= cbgvtknam.getSelectedItem().toString();
        String diem="";
        if(txtgvtkmasv.getText().trim().isEmpty()==false){masv = "%"+txtgvtkmasv.getText().trim()+"%";}
        if(txtgvtktensv.getText().trim().isEmpty()==false){tensv = "%"+txtgvtktensv.getText().trim()+"%";}
        if(txtgvtklopsv.getText().trim().isEmpty()==false){lopsv = "%"+txtgvtklopsv.getText().trim()+"%";}
        if(txtgvtkdiemsv.getText().trim().isEmpty() == false)
        {
            int t = cbgvtkpheptoan.getSelectedIndex();
            switch (t)
            {
                case 0: diem = "and ((d.diemtoan + d.diemtin + d.diemanh)/3) > "+Float.parseFloat(txtgvtkdiemsv.getText()); break;
                case 1: diem = "and ((d.diemtoan + d.diemtin + d.diemanh)/3) < "+Float.parseFloat(txtgvtkdiemsv.getText()); break;
                case 2: diem = " and ((d.diemtoan + d.diemtin + d.diemanh)/3) = "+Float.parseFloat(txtgvtkdiemsv.getText()); break;
            }
            
        }
        String manv1 =" ";
        if(loaitaikkhoan==1){manv1 =" and l.manv like '"+this.manv+"' ";}
        try{
        Class.forName(dvsql);
        Connection cnt = DriverManager.getConnection(urldb);
        String sqlquerry = "select s.masv, s.ten, d.diemtoan, d.diemtin, d.diemanh, substring(convert(varchar,(d.diemtoan + d.diemtin + d.diemanh)/3),0,4) as dtb from "
                            + "diem d join sinhvien s on d.masv = s.masv "
                            + "join lop l on d.malop= l.malop "
                            + "where d.masv like '"+masv+"' and s.ten like '"+tensv+"' and l.lop like '"+lopsv+"' and l.nienkhoa like '"+namhoc+"' "+diem+txtgvtkdiemsv.getText()+manv1;
        Statement sm = cnt.createStatement();
        ResultSet rs = sm.executeQuery(sqlquerry);
        if(rs.isBeforeFirst() == false){JOptionPane.showMessageDialog(this, "Không tìm thấy!!!");return;}
        String title1[] ={"Mã Sinh Viên","Tên Sinh Viên","Điểm Toán","Điểm Tin","Điểm Anh","Điểm Trung Bình"};
        bang = new DefaultTableModel(title1,0);
            Vector sv = null;
            if(rs.isBeforeFirst() == false){return;}
            while(rs.next())
            {
                sv = new Vector();
                sv.add(rs.getString(1));
                sv.add(rs.getString(2));
                sv.add(rs.getFloat(3));
                sv.add(rs.getFloat(4));
                sv.add(rs.getFloat(5));
                sv.add(rs.getFloat(6));
                bang.addRow(sv);
                
            }
            tbthongtin.setModel(bang);
            tbthongtin.setRowSelectionInterval(0, 0);
            cnt.close();
        }
        catch(Exception a){JOptionPane.showMessageDialog(this, "Lỗi: "+a);}
            
        
    }//GEN-LAST:event_btngvtktimActionPerformed

    private void btngvtkdongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngvtkdongActionPerformed
        jFramegvtimkiem.setVisible(false);
    }//GEN-LAST:event_btngvtkdongActionPerformed

    private void btndttktimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndttktimActionPerformed
        if(tbnhanvien.getSelectedIndex()!=1){JOptionPane.showMessageDialog(this, "Hãy chọn tag Đào tạo!!");return;}
        try
        {
            if(txtdttkngaysinh.getText().trim().isEmpty()==false){if(Integer.parseInt(txtdttkngaysinh.getText())>31 || Integer.parseInt(txtdttkngaysinh.getText())<0){JOptionPane.showMessageDialog(jFramedttimkiem, "Ngày sinh không hợp lệ: ");return;}}
            if(txtdttkthangsinh.getText().trim().isEmpty()==false){if(Integer.parseInt(txtdttkthangsinh.getText())>12 || Integer.parseInt(txtdttkthangsinh.getText())<0){JOptionPane.showMessageDialog(jFramedttimkiem, "Tháng sinh không hợp lệ: ");return;}}
            if(txtdttknamsinh.getText().trim().isEmpty()==false){if(Integer.parseInt(txtdttknamsinh.getText())<0){JOptionPane.showMessageDialog(jFramedttimkiem, "Năm sinh không hợp lệ: ");return;}}
            if(txtdttkngaynhaphoc.getText().trim().isEmpty()==false){if(Integer.parseInt(txtdttkngaynhaphoc.getText())>31 || Integer.parseInt(txtdttkngaynhaphoc.getText())<0){JOptionPane.showMessageDialog(jFramedttimkiem, "Ngày nhập học không hợp lệ: ");return;}}
            if(txtdttkthangnhaphoc.getText().trim().isEmpty()==false){if(Integer.parseInt(txtdttkthangnhaphoc.getText())>12 || Integer.parseInt(txtdttkthangnhaphoc.getText())<0){JOptionPane.showMessageDialog(jFramedttimkiem, "Tháng nhập học hợp lệ: ");return;}}
            if(txtdttknamnhaphoc.getText().trim().isEmpty()==false){if(Integer.parseInt(txtdttknamnhaphoc.getText())<0){JOptionPane.showMessageDialog(jFramedttimkiem, "Năm nhập học không hợp lệ: ");return;}}
        }catch(Exception e){JOptionPane.showMessageDialog(jFramedttimkiem, "Ngày tháng không hợp lệ: "+e);return;}
        String masv="%";
        String tensv="%";
        String cmnd ="%";
        String email="%";
        String diachi="%";
        String gioitinh=" and gioitinh =0 ";
        if(rbdttknu.isSelected()){gioitinh=" and gioitinh =1 ";}
        if(rbdttkcahai.isSelected()){gioitinh=" ";}
        String ngaysinh =" ";
        String thangsinh=" ";
        String namsinh =" ";
        String ngaynhaphoc =" ";
        String thangnhaphoc=" ";
        String namnhaphoc =" ";
        
        if(txtdttkmasv.getText().trim().isEmpty()==false){masv ="%"+txtdttkmasv.getText()+"%";}
        if(txtdttktensv.getText().trim().isEmpty()==false){tensv ="%"+txtdttktensv.getText()+"%";}
        if(txtdttkcmnd.getText().trim().isEmpty()==false){cmnd ="%"+txtdttkcmnd.getText()+"%";}
        if(txtdttkemail.getText().trim().isEmpty()==false){email ="%"+txtdttkemail.getText()+"%";}
        if(txtdttkdiachi.getText().trim().isEmpty()==false){diachi ="%"+txtdttkdiachi.getText()+"%";}
        if(txtdttkngaysinh.getText().trim().isEmpty()==false){ngaysinh =" and DATEPART(dd,ngaysinh) = "+txtdttkngaysinh.getText();}   
        if(txtdttkthangsinh.getText().trim().isEmpty()==false){thangsinh =" and DATEPART(mm,ngaysinh) = "+txtdttkthangsinh.getText();} 
        if(txtdttknamsinh.getText().trim().isEmpty()==false){namsinh =" and DATEPART(yyyy,ngaysinh) = "+txtdttknamsinh.getText();} 
        if(txtdttkngaynhaphoc.getText().trim().isEmpty()==false){ngaynhaphoc =" and DATEPART(dd,ngaynhaphoc) = "+txtdttkngaynhaphoc.getText();} 
        if(txtdttkthangnhaphoc.getText().trim().isEmpty()==false){thangnhaphoc =" and DATEPART(mm,ngaynhaphoc) = "+txtdttkthangnhaphoc.getText();} 
        if(txtdttknamnhaphoc.getText().trim().isEmpty()==false){namnhaphoc =" and DATEPART(yyyy,ngaynhaphoc) = "+txtdttknamnhaphoc.getText();} 
        
        try{
        Class.forName(dvsql);
        Connection cnt = DriverManager.getConnection(urldb);
        String sqlquerry = "select masv,ten,(case when gioitinh=0 then 'Nam' else N'Nữ' end),convert(varchar,ngaysinh,103),cmnd,email,diachi,convert(varchar,ngaynhaphoc,103) from sinhvien ";
        sqlquerry+= "where masv like '"+masv+"' and ten like '"+tensv+"' and cmnd like '"+cmnd+"' and email like '"+email+"' and diachi like '"+diachi+"'  "+ngaysinh+thangsinh+namsinh+ngaynhaphoc+thangnhaphoc+namnhaphoc+gioitinh;
        Statement sm = cnt.createStatement();
        ResultSet rs = sm.executeQuery(sqlquerry);
        bang = new DefaultTableModel(title,0);
            Vector sv = null;
            if(rs.isBeforeFirst() == false){JOptionPane.showMessageDialog(rootPane, "Không tìm thấy!!!");return;}
            while(rs.next())
            {
                sv = new Vector();
                sv.add(rs.getString(1));
                sv.add(rs.getString(2));
                sv.add(rs.getString(3));
                sv.add(rs.getString(4));
                sv.add(rs.getString(5));
                sv.add(rs.getString(6));
                sv.add(rs.getString(7));
                sv.add(rs.getString(8));
                
                bang.addRow(sv);
                
            }
            tbthongtin.setModel(bang);
            tbthongtin.setRowSelectionInterval(0, 0);
            cnt.close();
        }
        catch(Exception a){JOptionPane.showMessageDialog(this, "Lỗi: "+a);}
    }//GEN-LAST:event_btndttktimActionPerformed

    private void btndttimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndttimkiemActionPerformed
       txtdttkmasv.setText("");
       txtdttktensv.setText("");
       txtdttkngaysinh.setText("");
       txtdttkthangsinh.setText("");
       txtdttknamsinh.setText("");
       txtdttkcmnd.setText("");
       txtdttkemail.setText("");
       txtdttkdiachi.setText("");
       txtdttkngaynhaphoc.setText("");
       txtdttkthangnhaphoc.setText("");
       txtdttknamnhaphoc.setText("");
       rbdttknam.setSelected(true);
       jFramedttimkiem.setVisible(true);
    }//GEN-LAST:event_btndttimkiemActionPerformed

    private void btndtxuatexcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndtxuatexcelActionPerformed
        xuatexceldt();
    }//GEN-LAST:event_btndtxuatexcelActionPerformed

    private void txtdnthoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdnthoatActionPerformed
         System.exit(0);
    }//GEN-LAST:event_txtdnthoatActionPerformed

    private void btndttkdongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndttkdongActionPerformed
        jFramedttimkiem.setVisible(false);
    }//GEN-LAST:event_btndttkdongActionPerformed

    private void btngvguidiem1svActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngvguidiem1svActionPerformed
        if(txtgvmasv.getText().isEmpty()){JOptionPane.showMessageDialog(this,"Chưa chọn học sinh!!!");return;}
        txtgmgv1svmatkhau.setText("");
        txtgmgv1svghichu.setText("");
        jFrameguimailgv1sv.setVisible(true);
    }//GEN-LAST:event_btngvguidiem1svActionPerformed

    private void btngmgv1svguiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngmgv1svguiActionPerformed
        
        try{
        String tk= txtgmgv1svtaikhoan.getText();
        char[] mk1 = txtgmgv1svmatkhau.getPassword();
        String mk="";
        for(int i=0;i<mk1.length;i++)
        {
            mk+=mk1[i];
        }
        String diachi="";
        String tieude="Bảng điểm";
        String noidung ="";
        
        String tt = Tdanhsachlop.getSelectionPath().toString();
        Class.forName(dvsql);
        Connection cnt = DriverManager.getConnection(urldb);
        String sqlquerry = "select s.masv,s.ten, s.email, (SUBSTRING('"+tt+"',31,charindex(']','"+tt+"')-31)), (SUBSTRING('"+tt+"',11,9)), d.diemtoan, d.diemtin, d.diemanh, ((d.diemtoan+d.diemtin+d.diemanh)/3) from "
                            + "diem d join sinhvien s on d.masv = s.masv "
                            + "join lop l on d.malop= l.malop "
                            + "where d.masv like '"+txtgvmasv.getText()+"' and l.lop like SUBSTRING('"+tt+"',31,charindex(']','"+tt+"')-31) and l.nienkhoa like SUBSTRING('"+tt+"',11,9)";
        Statement sm = cnt.createStatement();
        ResultSet rs = sm.executeQuery(sqlquerry);
        if(rs.isBeforeFirst() == false){JOptionPane.showMessageDialog(this, "Không tìm thấy sinh viên này");return;}
        bang = new DefaultTableModel(title,0);
            
            if(rs.isBeforeFirst() == false){return;}
            while(rs.next())
            {
                diachi = rs.getString(3);
                noidung +="BẢNG ĐIỂM\n";
                noidung+="Mã sinh viên: "+rs.getString(1)+"\n";
                noidung+="Tên sinh viên: "+rs.getString(2)+"\n";
                noidung+="Lớp: "+rs.getString(4)+"\n";
                noidung+="Niên khóa: "+rs.getString(5)+"\n";
                noidung+="---------------------------------\n";
                noidung+="Điểm Toán: "+rs.getFloat(6)+"\n";
                noidung+="Điểm Tin: "+rs.getFloat(7)+"\n";
                noidung+="Điểm Anh: "+rs.getFloat(8)+"\n";
                noidung+="---------------------------------\n";
                noidung+="Điểm Trung Bình: "+rs.getFloat(9)+"\n\n";
                noidung+="Ghi chú: "+txtgmgv1svghichu.getText();
                break;
            }
            
            guimailgv1sv b = new guimailgv1sv();
            b.tk=tk;
            b.mk=mk;
            b.guitoi=diachi;
            b.tieude=tieude;
            b.noidung=noidung;
            Thread a = new Thread(b);
            a.start();
        }
        catch(Exception a){return;}
        
    }//GEN-LAST:event_btngmgv1svguiActionPerformed

    private void btngvguidiemnhieusvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngvguidiemnhieusvActionPerformed
        if(tbthongtin.getSelectedRowCount()==0){JOptionPane.showMessageDialog(this, "Chưa chọn sinh viên!!!");return;}
        txtgmgvnhieusvmatkhau.setText("");
        txtgmgvnhieusvghichu.setText("");
        jFrameguimailgvnhieusv.setVisible(true);
    }//GEN-LAST:event_btngvguidiemnhieusvActionPerformed

    private void btngmgvnhieusvguiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngmgvnhieusvguiActionPerformed
       try{
        String tk= txtgmgvnhieusvtaikhoan.getText();
        char[] mk1 = txtgmgvnhieusvmatkhau.getPassword();
        String mk="";
        for(int i=0;i<mk1.length;i++)
        {
            mk+=mk1[i];
        }
        String[] diachi = new String[1000];
        String tieude="Bảng điểm";
        String[] noidung=new String[1000];
        int sl= tbthongtin.getSelectedRowCount();
        int thutu []= tbthongtin.getSelectedRows();
        String tt = Tdanhsachlop.getSelectionPath().toString();
        Class.forName(dvsql);
        Connection cnt = DriverManager.getConnection(urldb);
        for(int g =0;g<sl;g++)
        {
        String sqlquerry = "select s.masv,s.ten, s.email, (SUBSTRING('"+tt+"',31,charindex(']','"+tt+"')-31)), (SUBSTRING('"+tt+"',11,9)), d.diemtoan, d.diemtin, d.diemanh, ((d.diemtoan+d.diemtin+d.diemanh)/3) from "
                            + "diem d join sinhvien s on d.masv = s.masv "
                            + "join lop l on d.malop= l.malop "
                            + "where d.masv like '"+tbthongtin.getValueAt(thutu[g], 0).toString()+"' and l.lop like SUBSTRING('"+tt+"',31,charindex(']','"+tt+"')-31) and l.nienkhoa like SUBSTRING('"+tt+"',11,9)";
        Statement sm = cnt.createStatement();
        ResultSet rs = sm.executeQuery(sqlquerry);
            while(rs.next())
            {
                diachi[g] = rs.getString(3);
                noidung[g] +="BẢNG ĐIỂM\n";
                noidung[g]+="Mã sinh viên: "+rs.getString(1)+"\n";
                noidung[g]+="Tên sinh viên: "+rs.getString(2)+"\n";
                noidung[g]+="Lớp: "+rs.getString(4)+"\n";
                noidung[g]+="Niên khóa: "+rs.getString(5)+"\n";
                noidung[g]+="---------------------------------\n";
                noidung[g]+="Điểm Toán: "+rs.getFloat(6)+"\n";
                noidung[g]+="Điểm Tin: "+rs.getFloat(7)+"\n";
                noidung[g]+="Điểm Anh: "+rs.getFloat(8)+"\n";
                noidung[g]+="---------------------------------\n";
                noidung[g]+="Điểm Trung Bình: "+rs.getFloat(9)+"\n\n";
                noidung[g]+="Ghi chú: "+txtgmgvnhieusvghichu.getText();
                break;
            }
        }
            guidiemgvnhieusv c = new guidiemgvnhieusv(tk,mk,diachi,tieude,noidung,sl);
            
            Thread a = new Thread(c);
            a.start();
        }
        catch(Exception a){JOptionPane.showMessageDialog(jFrameguimailgvnhieusv, "Lỗi: "+a);return;}
    }//GEN-LAST:event_btngmgvnhieusvguiActionPerformed

    private void btndtguimailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndtguimailActionPerformed
        if(tbthongtin.getSelectedRowCount()==0){JOptionPane.showMessageDialog(this, "Chưa chọn sinh viên!!!");return;}
        txtgmdtmk.setText("");
        txtgmdtnoidung.setText("");
        txtgmdttieude.setText("");
        lbgmdtfiledinhkem.setText("");
        linkdinhkem = new String[1000];
        slfile=0;
        jFrameguimaildt.setVisible(true);
    }//GEN-LAST:event_btndtguimailActionPerformed

    private void btngmdtguiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngmdtguiActionPerformed
        String tk= txtgmdttk.getText();
        char[] mk1 = txtgmdtmk.getPassword();
        String mk="";
        for(int i=0;i<mk1.length;i++)
        {
            mk+=mk1[i];
        }
        String tieude=txtgmdttieude.getText();
        String noidung= txtgmdtnoidung.getText();
        int sl= tbthongtin.getSelectedRowCount();
        int thutu []= tbthongtin.getSelectedRows();
        String[] diachi = new String[1000];
        for(int i=0;i<sl;i++)
        {
            diachi[i]=tbthongtin.getValueAt(thutu[i], 5).toString();
        }
        int cc=0;
        if(rbgmdtcc.isSelected()){cc=0;}else{cc=1;}
        guimaildt c = new guimaildt(tk,mk,diachi,tieude,noidung,sl,cc,linkdinhkem,slfile);
            
            Thread a = new Thread(c);
            a.start();
        
        
    }//GEN-LAST:event_btngmdtguiActionPerformed

    private void btngmdtfiledinhkemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngmdtfiledinhkemActionPerformed
            chonfiledinhkem();
    }//GEN-LAST:event_btngmdtfiledinhkemActionPerformed

    private void btnguifileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguifileActionPerformed
        chonfiledinhkemall();
    }//GEN-LAST:event_btnguifileActionPerformed

    private void btnguiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguiActionPerformed

        char[] mk1 = txtmk.getPassword();
        String mk="";
        for(int i=0;i<mk1.length;i++)
        {
            mk+=mk1[i];
        }
        String []guitoi = laymangemail(txtguiden.getText());
        String tieude=txttieude.getText();
        String noidung=txtnoidung.getText();
        String tk=txttk.getText();
        int sl = guitoi.length;
        int cc=0;
        if(rbbcc.isSelected()){cc=1;}
        guimailall a = new guimailall(tk,mk, guitoi,tieude,noidung,sl, cc, linkdinhkem, sllink);

        Thread b = new Thread(a);
        b.start();

    }//GEN-LAST:event_btnguiActionPerformed

    private void btnguimailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguimailActionPerformed
        txtmk.setText("");
       txtguiden.setText("");
       txttieude.setText("");
       txtnoidung.setText("");
       rbcc.setSelected(true);
       linkdinhkemall = new String[1000];
       sllink=0;
       lbtenfile.setText("");
       jFrameguimailall.setVisible(true);
    }//GEN-LAST:event_btnguimailActionPerformed

    private void btnresetguimailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetguimailActionPerformed
        txtguiden.setText("");
       txttieude.setText("");
       txtnoidung.setText("");
       rbcc.setSelected(true);
       linkdinhkemall = new String[1000];
       sllink=0;
       lbtenfile.setText("");
    }//GEN-LAST:event_btnresetguimailActionPerformed

    private void btngmdongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngmdongActionPerformed
       jFrameguimailall.setVisible(false);
    }//GEN-LAST:event_btngmdongActionPerformed

    private void jMenusaoluuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenusaoluuActionPerformed
                
        try{
                JFileChooser savefile = new JFileChooser();
                int result = savefile.showSaveDialog(jMenusaoluu);
                if(result != JFileChooser.APPROVE_OPTION){return;}
                String link = savefile.getSelectedFile().toString()+".bak";
                Class.forName(dvsql);
                Connection cnt = DriverManager.getConnection(urldb);
                Statement sm = cnt.createStatement();
                sm.execute("backup database quanlysinhvien to disk = '"+link+"'");
                JOptionPane.showMessageDialog(this, "Sao lưu thành công");
                loaddbdt();loadbang();
                cnt.close();
        }
        catch(Exception h){JOptionPane.showMessageDialog(this, "Sao Lưu thất bại!!!"+h);}
    }//GEN-LAST:event_jMenusaoluuActionPerformed

    private void jMenuphuchoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuphuchoiActionPerformed
        try{
                JFileChooser openfile = new JFileChooser();
                int result = openfile.showSaveDialog(jMenuphuchoi);
                if(result != JFileChooser.APPROVE_OPTION){return;}
                String link = openfile.getSelectedFile().toString();
                String sqlquerry="restore database quanlysinhvien from disk = '"+link+"' with MOVE 'quanlysinhvien' TO 'C:\\Program Files\\Microsoft SQL Server\\MSSQL12.SQLEXPRESS\\MSSQL\\DATA\\quanlysinhvien.mdf', MOVE 'quanlysinhvien_log' TO 'C:\\Program Files\\Microsoft SQL Server\\MSSQL12.SQLEXPRESS\\MSSQL\\DATA\\quanlysinhvien_log.ldf'";
                Class.forName(dvsql);
                Connection cnt = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=master;user=sa;password=123456");
                Statement sm = cnt.createStatement();
                sm.execute(sqlquerry);
                cnt.close();
                JOptionPane.showMessageDialog(this, "Phục hồi thành công!!!");
                loaddbdt();loadbang();
                
        }
        catch(Exception h){JOptionPane.showMessageDialog(this, "Phục hồi thất bại!!!\nLỗi: "+h);}
    }//GEN-LAST:event_jMenuphuchoiActionPerformed

    private void btngmgvnhieusvdongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngmgvnhieusvdongActionPerformed
        jFrameguimailgvnhieusv.setVisible(false);
    }//GEN-LAST:event_btngmgvnhieusvdongActionPerformed

    private void btngmgv1svdongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngmgv1svdongActionPerformed
        jFrameguimailgv1sv.setVisible(false);
    }//GEN-LAST:event_btngmgv1svdongActionPerformed

    private void lbdnquenmkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbdnquenmkMouseClicked
        jFramequenmatkhau.setVisible(true);
    }//GEN-LAST:event_lbdnquenmkMouseClicked

    private void btnqmkguiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnqmkguiActionPerformed
        String ten = txtqmktaikhoan.getText();
        String email="";
        double r = Math.random();
        String t = String.valueOf(r);
        String mkmoi = t.substring(2, 8);
        String mkmahoa = mahoaMD5(mkmoi);
        try
        {
            Class.forName(dvsql);
            Connection cnt = DriverManager.getConnection(urldb);
            ResultSet rs = cnt.createStatement().executeQuery("select email from nhanvien where manv like '"+ten+"'");
            if(rs.isBeforeFirst() == false){JOptionPane.showMessageDialog(jFramequenmatkhau, "Tài khoản không tồn tại");return;}
            while(rs.next())
            {
                email = rs.getString(1);
                break;
            }
            cnt.createStatement().execute("update nhanvien set matkhau = '"+mkmahoa+"' where manv like '"+ten+"'");
            cnt.close();
            Properties ppt = new Properties();
            ppt.put("mail.smtp.auth", "true");
            ppt.put("mail.smtp.starttls.enable", "true");
            ppt.put("mail.smtp.host", "smtp.gmail.com");
            ppt.put("mail.smtp.port", "587");
        
            Session ss = Session.getInstance(ppt,
                new javax.mail.Authenticator()
                {
                    protected PasswordAuthentication getPasswordAuthentication(){
                        return new PasswordAuthentication("assignmentfinalps04271@gmail.com", "0938793761");
                    }
                }
        
            );
            
            Message msg = new MimeMessage(ss);
            msg.setFrom(new InternetAddress("assignmentfinalps04271@gmail.com"));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email) );
            msg.setSubject("Mật khẩu mới của bạn");
            msg.setText("Mật khẩu mới của bạn là: \""+mkmoi+"\" \nHãy đổi thành mật khẩu mới ở lần đăng nhập tiếp theo!!!");
            Transport.send(msg);
            JOptionPane.showMessageDialog(jFramequenmatkhau, "Mật khẩu mới đã được gửi vào mail của bạn!!!");
        }
        catch(Exception e){JOptionPane.showMessageDialog(jFramequenmatkhau, "Lỗi: "+e);}
    }//GEN-LAST:event_btnqmkguiActionPerformed

    private void btnqmkdongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnqmkdongActionPerformed
        jFramequenmatkhau.setVisible(false);
    }//GEN-LAST:event_btnqmkdongActionPerformed

    public void loaddbdt()
    {
        
        try{
        Class.forName(dvsql);
        Connection cnt = DriverManager.getConnection(urldb);
        String sqlquerry = "select masv,ten,(case when gioitinh=0 then 'Nam' else N'Nữ' end),convert(varchar,ngaysinh,103),cmnd,email,diachi,convert(varchar,ngaynhaphoc,103) from sinhvien";
        Statement sm = cnt.createStatement();
        ResultSet rs = sm.executeQuery(sqlquerry);
        bang = new DefaultTableModel(title,0);
            Vector sv = null;
            if(rs.isBeforeFirst() == false){JOptionPane.showMessageDialog(rootPane, "Chưa có học sinh");return;}
            while(rs.next())
            {
                sv = new Vector();
                sv.add(rs.getString(1));
                sv.add(rs.getString(2));
                sv.add(rs.getString(3));
                sv.add(rs.getString(4));
                sv.add(rs.getString(5));
                sv.add(rs.getString(6));
                sv.add(rs.getString(7));
                sv.add(rs.getString(8));
                
                bang.addRow(sv);
                
            }
            tbthongtin.setModel(bang);
            tbthongtin.setRowSelectionInterval(0, 0);
            cnt.close();
            sm.close();
           rs.close();
        }
        catch(Exception a){JOptionPane.showMessageDialog(this, "Lỗi: "+a);}
    }
    
         public void loaddblop()
    {
        
        try{
        Class.forName(dvsql);
        Connection cnt = DriverManager.getConnection(urldb);
        String sqlquerry = "select malop,lop,manv,khoi,nienkhoa from lop";
        String sqlquerry2 = "select nienkhoa from lop group by nienkhoa";
        Statement sm = cnt.createStatement();
        Statement sm1 = cnt.createStatement();
        ResultSet rs = sm.executeQuery(sqlquerry);
        ResultSet rs1 = sm1.executeQuery(sqlquerry2);
            String [] title1 = {"Mã Lớp","Lớp","Mã Giáo Viên","Khối","Niên khóa"};
            bang = new DefaultTableModel(title1,0);
            cblthemmalop.removeAllItems();
            cbdtnienkhoa.removeAllItems();
            Vector sv = null;
            if(rs.isBeforeFirst() == false){JOptionPane.showMessageDialog(rootPane, "Chưa có lớp!!!");return;}
            while(rs1.next())
            {
                cbdtnienkhoa.addItem(rs1.getString(1));
            }
            while(rs.next())
            {
                sv = new Vector();
                sv.add(rs.getString(1));
                sv.add(rs.getString(2));
                sv.add(rs.getString(3));
                sv.add(rs.getString(4));
                sv.add(rs.getString(5));
                bang.addRow(sv);
                cblthemmalop.addItem(rs.getString(1));
                cblxoamalop.addItem(rs.getString(1));
            }
            tbthongtin.setModel(bang);
            tbthongtin.setRowSelectionInterval(0, 0);
            cnt.close();
            sm.close();
           rs.close();
        }
        catch(Exception a){JOptionPane.showMessageDialog(rootPane, "Lỗi: "+a);}
    }
         
         
        public static String mahoaMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
        
        public boolean checkdaotao()
        {
            if(txtdtmasv.getText().length() >=10){JOptionPane.showMessageDialog(this, "Mã sinh viên quá dài!!!");return false;}
            if(txtdttensv.getText().length() >=40){JOptionPane.showMessageDialog(this, "Tên sinh viên quá dài!!!");return false;}
            
            try{Integer.parseInt(txtdtcmndsv.getText());}catch(Exception e){JOptionPane.showMessageDialog(this, "CMND sinh viên không hợp lệ!!!");return false;}
            if(txtdtcmndsv.getText().length() <9 || txtdtcmndsv.getText().length() >12){JOptionPane.showMessageDialog(this, "CMND sinh viên không hợp lệ!!!");return false;}
            
            if(txtdtemailsv.getText().indexOf("@")==-1 || txtdtemailsv.getText().indexOf(".",txtdtemailsv.getText().indexOf("@"))==-1)
            {JOptionPane.showMessageDialog(this, "Email không hợp lệ!!!");return false;}
            if(txtdtemailsv.getText().length() >=50){JOptionPane.showMessageDialog(this, "Email sinh viên quá dài!!!");return false;}
            
           
            return true;
        }
        
        public boolean checklop()
        {
            if(txtlmalop.getText().length()>10){JOptionPane.showMessageDialog(this, "Mã lớp quá dài!!!");return false;}
            if(txtlmagv.getText().length()>10){JOptionPane.showMessageDialog(this, "Mã giáo viên quá dài!!!");return false;}
            if(txtllop.getText().length()>5){JOptionPane.showMessageDialog(this, "Lớp quá dài!!!");return false;}
            if(txtlnienkhoa.getText().length()!=9){JOptionPane.showMessageDialog(this, "Niên khóa quá dài hoặc quá ngắn!!!");return false;}
            if(txtlmalop.getText().equals("")){JOptionPane.showMessageDialog(this, "Mã lớp trống!!!");return false;}
            if(txtlmagv.getText().equals("")){JOptionPane.showMessageDialog(this, "Mã lớp trống!!!");return false;}
            if(txtllop.getText().equals("")){JOptionPane.showMessageDialog(this, "Mã lớp trống!!!");return false;}
            if(txtlnienkhoa.getText().equals("")){JOptionPane.showMessageDialog(this, "Mã lớp trống!!!");return false;}
            
            try{
            if(Integer.parseInt(txtllop.getText().substring(0,2))>12 || Integer.parseInt(txtllop.getText().substring(0,2))<10 || Integer.parseInt(txtllop.getText().substring(0,2))!=Integer.parseInt(cblkhoi.getSelectedItem().toString())){JOptionPane.showMessageDialog(this, "Lớp không hợp lệ!!!");return false;}
            } catch(Exception e){JOptionPane.showMessageDialog(this, "Lớp không hợp lệ!!!");return false;}
            
            try{
                int t = Integer.parseInt(txtlnienkhoa.getText().substring(5,9)) - Integer.parseInt(txtlnienkhoa.getText().substring(0,4));
                if( t!=1 || !"-".equals(txtlnienkhoa.getText().substring(4,5)))
                {JOptionPane.showMessageDialog(this, "Niên khóa không hợp lệ!!!");return false;}
            } catch(Exception e){JOptionPane.showMessageDialog(this, "Niên khóa không hợp lệ!!!");return false;}
            
            return true;
        }
        
        public void loaddbgiaovien(String tentk)
        {
            try
            {
                Class.forName(dvsql);
                Connection cnt = DriverManager.getConnection(urldb);
                String sqlquerry = "select nienkhoa from lop where manv like '"+tentk+"' group by nienkhoa";
                Statement sm = cnt.createStatement();
                ResultSet rs = sm.executeQuery(sqlquerry);
                Tdanhsachlop.removeAll();
                if(rs.isBeforeFirst() == false){JOptionPane.showMessageDialog(this, "Chưa có lớp");return;}
                
                DefaultMutableTreeNode lop = new DefaultMutableTreeNode("Các lớp");
                
                while(rs.next()){
                    DefaultMutableTreeNode nienkhoa = new DefaultMutableTreeNode(rs.getString(1));
                    Statement sm2 = cnt.createStatement();
                    ResultSet rs2 = sm2.executeQuery("select khoi from lop where manv like '"+tentk+"' and nienkhoa like '"+rs.getString(1)+"' group by khoi");
                    
                    while(rs2.next())
                    {
                        
                        DefaultMutableTreeNode lop1 = new DefaultMutableTreeNode("Khối "+rs2.getInt(1));
                        Statement sm1 = cnt.createStatement();
                        ResultSet rs1 = sm1.executeQuery("select lop from lop where manv like '"+tentk+"' and khoi ="+rs2.getInt(1)+" and nienkhoa like '"+rs.getString(1)+"' group by lop");
                        
                        while(rs1.next())
                        {
                            DefaultMutableTreeNode lop2 = new DefaultMutableTreeNode(rs1.getString(1));
                            lop1.add(lop2);
                        }
                        nienkhoa.add(lop1); 
                    }
                    lop.add(nienkhoa);
                }
                    
                    DefaultTreeModel listtree = new DefaultTreeModel(lop);
                    
                    Tdanhsachlop.setModel(listtree);
                    cnt.close();
                    
            
            }
           catch(Exception a){JOptionPane.showMessageDialog(jFrameDangNhap, "Lỗi: "+a);}
        }
        
        public void loadtop3()
        {
            lbtop3masv1.setText(""); lbtop3tensv1.setText(""); lbtop3diemtb1.setText("");
            lbtop3masv2.setText(""); lbtop3tensv2.setText(""); lbtop3diemtb2.setText("");
            lbtop3masv3.setText(""); lbtop3tensv3.setText(""); lbtop3diemtb3.setText("");
            String tt = Tdanhsachlop.getSelectionPath().toString();
            String nv ="%";
            if(loaitaikkhoan==1){nv=this.manv;}
            try
            {   
            Class.forName(dvsql);
            Connection cnt = DriverManager.getConnection(urldb);
            Statement sm = cnt.createStatement();
            ResultSet rs = sm.executeQuery("select top 3 d.masv, s.ten, convert(float,substring(convert(varchar,(d.diemtoan + d.diemtin + d.diemanh)/3),0,4)) as dtb" +
                                            " from diem d join lop l on d.malop = l.malop" +
                                            " join sinhvien s on d.masv = s.masv where l.manv like '"+nv+"' and l.lop like SUBSTRING('"+tt+"',31,charindex(']','"+tt+"')-31) and l.nienkhoa like SUBSTRING('"+tt+"',11,9) order by dtb desc");
            int i =1;
            while(rs.next())
            {
                if(i==1){lbtop3masv1.setText(rs.getString(1)); lbtop3tensv1.setText(rs.getString(2)); lbtop3diemtb1.setText(rs.getString(3));}
                if(i==2){lbtop3masv2.setText(rs.getString(1)); lbtop3tensv2.setText(rs.getString(2)); lbtop3diemtb2.setText(rs.getString(3));}
                if(i==3){lbtop3masv3.setText(rs.getString(1)); lbtop3tensv3.setText(rs.getString(2)); lbtop3diemtb3.setText(rs.getString(3));}
                i+=1;
            }
            cnt.close();
            }
        catch(Exception e)
            {
            JOptionPane.showMessageDialog(this, "Tải top 3 thất bại! \n Lỗi: "+e);
            }        
        }
        
        public void loadbang()
        {
            
            if(tbnhanvien.getSelectedIndex()==0)
        {
            int tt= tbthongtin.getSelectedRow();
            if(tt<0)return;
            txtgvmasv.setText(tbthongtin.getValueAt(tt,0).toString());
            txtgvtensv.setText(tbthongtin.getValueAt(tt,1).toString());
            txtgvdiemtoan.setText(tbthongtin.getValueAt(tt,2).toString());
            txtgvdiemtin.setText(tbthongtin.getValueAt(tt,3).toString());
            txtgvdiemanh.setText(tbthongtin.getValueAt(tt,4).toString());
            try{
                Class.forName(dvsql);
                Connection cnt = DriverManager.getConnection(urldb);
                String sqlquerry = "select hinhanh from sinhvien where masv like '"+tbthongtin.getValueAt(tt, 0).toString()+"'";
                Statement sm = cnt.createStatement();
                ResultSet rs = sm.executeQuery(sqlquerry);
            while(rs.next())
            {
               if(rs.getString(1).equals("/sof203_assignment1_ps04271/hinhanh/noimage.png"))
               {lbgvhinh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sof203_assignment1_ps04271/hinhanh/noimage.png")));}
               else{lbgvhinh.setIcon(load(rs.getString(1), 100, 134));}
               break;
            }
            cnt.close();
        }
        catch(Exception a){JOptionPane.showMessageDialog(this, "Lỗi: "+a);}
            return;
        }
        
        if(tbnhanvien.getSelectedIndex()==1)
        {
        int tt= tbthongtin.getSelectedRow();
        if(tt<0)return;
        txtdtmasv.setText(tbthongtin.getValueAt(tt, 0).toString());
        txtdttensv.setText(tbthongtin.getValueAt(tt, 1).toString());
        if(tbthongtin.getValueAt(tt, 2).toString().equals("Nam")){rbdtnam.setSelected(true);}else {rbdtnu.setSelected(true);}
        
        String sinhnhat = tbthongtin.getValueAt(tt, 3).toString();
        txtdtngaysinh.setText(sinhnhat.substring(0, 2));
        txtdtthangsinh.setText(sinhnhat.substring(3, 5));
        txtdtnamsinh.setText(sinhnhat.substring(6, 10));
        
        txtdtcmndsv.setText(tbthongtin.getValueAt(tt, 4).toString());
        txtdtemailsv.setText(tbthongtin.getValueAt(tt, 5).toString());
        txtdtdiachisv.setText(tbthongtin.getValueAt(tt, 6).toString());
        String nhaphoc = tbthongtin.getValueAt(tt, 3).toString();
        txtdtngaynhaphoc.setText(sinhnhat.substring(0, 2));
        txtdtthangnhaphoc.setText(sinhnhat.substring(3, 5));
        txtdtnamnhaphoc.setText(sinhnhat.substring(6, 10));
        try{
        Class.forName(dvsql);
        Connection cnt = DriverManager.getConnection(urldb);
        String sqlquerry = "select hinhanh from sinhvien where masv like '"+tbthongtin.getValueAt(tt, 0).toString()+"'";
        Statement sm = cnt.createStatement();
        ResultSet rs = sm.executeQuery(sqlquerry);
            while(rs.next())
            {
               if(rs.getString(1).equals("/sof203_assignment1_ps04271/hinhanh/noimage.png"))
               {lbhinhdt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sof203_assignment1_ps04271/hinhanh/noimage.png")));}
               else{lbhinhdt.setIcon(load(rs.getString(1), 100, 134));}
               break;
            }
            cnt.close();
        }
        catch(Exception a){JOptionPane.showMessageDialog(this, "Lỗi: "+a);}
        return;
        }
        
        if(tbnhanvien.getSelectedIndex()==2)
        {
            int tt= tbthongtin.getSelectedRow();
            if(tt<0)return;
            txtlmalop.setText(tbthongtin.getValueAt(tt, 0).toString());
            txtllop.setText(tbthongtin.getValueAt(tt, 1).toString());
            txtlmagv.setText(tbthongtin.getValueAt(tt, 2).toString());
            cblkhoi.setSelectedItem(tbthongtin.getValueAt(tt, 3).toString());
            txtlnienkhoa.setText(tbthongtin.getValueAt(tt, 4).toString());
        }
        }
        public void loadbangtutree()
        {
            
            if(loaitaikkhoan==2 || tbnhanvien.getSelectedIndex()==1 || tbnhanvien.getSelectedIndex()==2 )
            {
                
                
        try{
            String tt = Tdanhsachlop.getSelectionPath().toString();
        Class.forName(dvsql);
        Connection cnt = DriverManager.getConnection(urldb);
        String sqlquerry = "select s.masv,s.ten,(case when s.gioitinh=0 then 'Nam' else N'Nữ' end),convert(varchar,s.ngaysinh,103),s.cmnd,s.email,s.diachi,convert(varchar,s.ngaynhaphoc,103) from "
                            + "diem d join sinhvien s on d.masv = s.masv "
                            + "join lop l on d.malop= l.malop "
                            + "where l.lop like SUBSTRING('"+tt+"',31,charindex(']','"+tt+"')-31) and l.nienkhoa like SUBSTRING('"+tt+"',11,9)";
        Statement sm = cnt.createStatement();
        ResultSet rs = sm.executeQuery(sqlquerry);
        if(rs.isBeforeFirst() == false){JOptionPane.showMessageDialog(this, "Chưa có sinh viên trong lớp này");return;}
        bang = new DefaultTableModel(title,0);
            Vector sv = null;
            if(rs.isBeforeFirst() == false){return;}
            while(rs.next())
            {
                sv = new Vector();
                sv.add(rs.getString(1));
                sv.add(rs.getString(2));
                sv.add(rs.getString(3));
                sv.add(rs.getString(4));
                sv.add(rs.getString(5));
                sv.add(rs.getString(6));
                sv.add(rs.getString(7));
                sv.add(rs.getString(8));
                
                bang.addRow(sv);
                
            }
            tbthongtin.setModel(bang);
            tbthongtin.setRowSelectionInterval(0, 0);
            cnt.close();
            loadtop3();
            loadbang();
            btnlopthemsv.setEnabled(false);
            btnlopxoasv.setEnabled(true);
            checkchonlop=0;
            
        }
        catch(Exception a){return;}
            }
            
            if((loaitaikkhoan==1 || loaitaikkhoan==0) && tbnhanvien.getSelectedIndex()==0 )
            {
            
        try{
            String tt = Tdanhsachlop.getSelectionPath().toString();
            String q =" ";
            if(this.loaitaikkhoan==1){q=" and l.manv like '"+this.manv+"' ";}
        Class.forName(dvsql);
        Connection cnt = DriverManager.getConnection(urldb);
        String sqlquerry = "select s.masv, s.ten, d.diemtoan, d.diemtin, d.diemanh, substring(convert(varchar,(d.diemtoan + d.diemtin + d.diemanh)/3),0,4) as dtb from "
                            + "diem d join sinhvien s on d.masv = s.masv "
                            + "join lop l on d.malop= l.malop "
                            + "where d.malop like (select malop from lop where lop like SUBSTRING('"+tt+"',31,charindex(']','"+tt+"')-31) and nienkhoa like SUBSTRING('"+tt+"',11,9))  "+q;
        Statement sm = cnt.createStatement();
        ResultSet rs = sm.executeQuery(sqlquerry);
        if(rs.isBeforeFirst() == false){JOptionPane.showMessageDialog(this, "Chưa có học sinh!!!");return;}
        String title1[] ={"Mã Sinh Viên","Tên Sinh Viên","Điểm Toán","Điểm Tin","Điểm Anh","Điểm Trung Bình"};
        bang = new DefaultTableModel(title1,0);
            Vector sv = null;
            if(rs.isBeforeFirst() == false){return;}
            while(rs.next())
            {
                sv = new Vector();
                sv.add(rs.getString(1));
                sv.add(rs.getString(2));
                sv.add(rs.getFloat(3));
                sv.add(rs.getFloat(4));
                sv.add(rs.getFloat(5));
                sv.add(rs.getFloat(6));
                bang.addRow(sv);
                
            }
            tbthongtin.setModel(bang);
            tbthongtin.setRowSelectionInterval(0, 0);
            cnt.close();
            loadtop3();
            loadbang();
            
        }
        catch(Exception a){JOptionPane.showMessageDialog(this, "Lỗi: "+a);}
            }
        }
        
        public void quyenchinhlop(boolean a)
        {
            txtlmalop.setEditable(a);
            txtlmagv.setEditable(a);
            txtllop.setEditable(a);
            txtlnienkhoa.setEditable(a);
            cblkhoi.setEnabled(a);
            
            
            
        }
        
        public void quyen(boolean a)
        {
            jMenu1.setEnabled(a);
            tbnhanvien.setEnabledAt(0, a);
            tbnhanvien.setEnabledAt(1, a);
            tbnhanvien.setEnabledAt(2, a);
            btndoimatkhau.setEnabled(a);
            btngvsuadiem.setEnabled(a);
            btngvxoadiem.setEnabled(a);
            btnlsualop.setEnabled(a);
            btnlthem.setEnabled(a);
            btnlxoalop.setEnabled(a);
            btndtsuasv.setEnabled(a);
            btndtthemsv.setEnabled(a);
            btndtxoasv.setEnabled(a);
            btngvxuatexcel.setEnabled(a);
            btnlsvchuacolop.setEnabled(a);
            btndthiencaclop.setEnabled(a);
            btngvtimkiem.setEnabled(a);
            btndttimkiem.setEnabled(a);
            btndtxuatexcel.setEnabled(a);
            btngvguidiem1sv.setEnabled(a);
            btngvguidiemnhieusv.setEnabled(a);
            btndtguimail.setEnabled(a);
            btnguimail.setEnabled(a);
        }
        Timer hh;
        public void loadten()
        {
            lbtennv.setText(this.tennv);
            Date today=new Date(System.currentTimeMillis());
            SimpleDateFormat timeFormat= new SimpleDateFormat("dd/MM/yyyy");
            String s=timeFormat.format(today.getTime());
            lbngay.setText(s);
            hh = new Timer(1000, gio);
            hh.start();
        }
        
        public void dungpopup()
        {
            JMenuItem doihinh = new JMenuItem("Đổi hình");
            JMenuItem xoahinh = new JMenuItem("Xóa hình");
            puhinh.add(doihinh);
            puhinh.add(xoahinh);
            
            doihinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               actiondoihinh(doihinh);
            }
            });
            
            xoahinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               actionxoahinh();
            }
            });
            
            JMenuItem doihinhnv = new JMenuItem("Đổi hình");
            JMenuItem xoahinhnv = new JMenuItem("Xóa hình");
            puhinhnv.add(doihinhnv);
            puhinhnv.add(xoahinhnv);
            
            doihinhnv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               actiondoihinhnv(doihinh);
            }
            });
            
            xoahinhnv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               actionxoahinhnv();
            }
            });
            
            
        }
        
       
        
        
        
        public Icon load(String linkImage, int k, int m) {
    try {
        BufferedImage image = ImageIO.read(new File(linkImage));
 
        int x = k;
        int y = m;
        int ix = image.getWidth();
        int iy = image.getHeight();
        int dx = 0, dy = 0;
 
        if (x / y > ix / iy) {
            dy = y;
            dx = dy * ix / iy;
        } else {
            dx = x;
            dy = dx * iy / ix;
        }
 
        return new ImageIcon(image.getScaledInstance(dx, dy,
                image.SCALE_SMOOTH));
 
    } catch (Exception e) {return null;}
 
    
}
        
        ActionListener gio = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                Date today=new Date(System.currentTimeMillis());
                SimpleDateFormat timeFormat= new SimpleDateFormat("hh:mm:ss");
                String s=timeFormat.format(today.getTime());
                lbgio.setText(s);
            }
        };
        
        public void actiondoihinh(JMenuItem doihinh)
        {
            try{
                JFileChooser savefile = new JFileChooser();
                int result = savefile.showSaveDialog(doihinh);
                if(result != JFileChooser.APPROVE_OPTION){return;}
                String link = savefile.getSelectedFile().toString();
                if((load(link, 100, 134))==null){JOptionPane.showMessageDialog(this, "Hình ảnh không hơp lệ. Lưu thất bại!!!");return;}
                Class.forName(dvsql);
                Connection cnt = DriverManager.getConnection(urldb);
                Statement sm = cnt.createStatement();
                sm.execute("update sinhvien set hinhanh = N'"+link+"' where masv like '"+txtdtmasv.getText()+"'");
                JOptionPane.showMessageDialog(this, "Lưu thành công");
                loaddbdt();loadbang();cnt.close();
        }
        catch(Exception h){JOptionPane.showMessageDialog(this, "Hình ảnh không hơp lệ. Lưu thất bại!!!");}
            
            
        }
        
        public void actionxoahinh()
        {
            try{
                Class.forName(dvsql);
                Connection cnt = DriverManager.getConnection(urldb);
                Statement sm = cnt.createStatement();
                sm.execute("update sinhvien set hinhanh = N'/sof203_assignment1_ps04271/hinhanh/noimage.png' where masv like '"+txtdtmasv.getText()+"'");
                JOptionPane.showMessageDialog(this, "Xóa thành công"); cnt.close();
                loaddbdt();loadbang();cnt.close();
        }
        catch(Exception h){JOptionPane.showMessageDialog(this, "Xóa thất bại!!!");}
            
        }
        
        public void actiondoihinhnv(JMenuItem doihinhnv)
        {
            try{
                JFileChooser savefile = new JFileChooser();
                int result = savefile.showSaveDialog(doihinhnv);
                if(result != JFileChooser.APPROVE_OPTION){return;}
                String link = savefile.getSelectedFile().toString();
                if((load(link, 100, 134))==null){JOptionPane.showMessageDialog(this, "Hình ảnh không hơp lệ. Lưu thất bại!!!");return;}
                Class.forName(dvsql);
                Connection cnt = DriverManager.getConnection(urldb);
                Statement sm = cnt.createStatement();
                sm.execute("update nhanvien set hinhanh = N'"+link+"' where manv like '"+txtqlnvma.getText()+"'");
                JOptionPane.showMessageDialog(this, "Lưu thành công");cnt.close();
                loaddbdt();loadbang();
        }
        catch(Exception h){JOptionPane.showMessageDialog(this, "Hình ảnh không hơp lệ. Lưu thất bại!!!");}
            
            
        }
        
        public void actionxoahinhnv()
        {
            try{
                Class.forName(dvsql);
                Connection cnt = DriverManager.getConnection(urldb);
                Statement sm = cnt.createStatement();
                sm.execute("update nhanvien set hinhanh = N'/sof203_assignment1_ps04271/hinhanh/noimage.png' where manv like '"+txtqlnvma.getText()+"'");
                JOptionPane.showMessageDialog(this, "Xóa thành công");cnt.close();
                loaddbdt();loadbang();
        }
        catch(Exception h){JOptionPane.showMessageDialog(this, "Xóa thất bại!!!");}
            
        }
 
        public void xuatexcel()
        {
            int dong = tbthongtin.getRowCount();
            if(dong<=0){return;}
            try
            {
                JFileChooser savefile = new JFileChooser();
                int result = savefile.showSaveDialog(btngvxuatexcel);
                if(result != JFileChooser.APPROVE_OPTION){return;}
                File fileToSave = savefile.getCurrentDirectory();
                String link = fileToSave.getPath();
                String ten = savefile.getSelectedFile().getName();
                String linksave = link+"\\"+ten+".xls";
                
                WritableWorkbook workbook = Workbook.createWorkbook(new File(linksave));
                WritableSheet sheet = workbook.createSheet("Điểm", 0);
                sheet.addCell(new Label(0, 0, "Mã Sinh Viên"));
                sheet.addCell(new Label(1, 0, "Tên Sinh Viên"));
                sheet.addCell(new Label(2, 0, "Điểm Toán"));
                sheet.addCell(new Label(3, 0, "Điểm Tin"));
                sheet.addCell(new Label(4, 0, "Điểm Anh"));
                sheet.addCell(new Label(5, 0, "Điểm Trung Bình"));
                
                
                for(int i =1; i<=dong;i++)
                {
                    sheet.addCell(new Label(0, i, tbthongtin.getValueAt(i-1, 0).toString()));
                    sheet.addCell(new Label(1, i, tbthongtin.getValueAt(i-1, 1).toString()));
                    sheet.addCell(new Number(2, i, (Float) tbthongtin.getValueAt(i-1, 2)));
                    sheet.addCell(new Number(3, i,(Float) tbthongtin.getValueAt(i-1, 3)));
                    sheet.addCell(new Number(4, i,(Float) tbthongtin.getValueAt(i-1, 4)));
                    sheet.addCell(new Number(5, i, (Float)tbthongtin.getValueAt(i-1, 5)));
                }
                workbook.write();
                workbook.close();
                JOptionPane.showMessageDialog(this, "Xuất file thành công!!!");
            }
            catch(Exception e){JOptionPane.showMessageDialog(this, "Lỗi: "+e);}
            
        }
        
        public void xuatexceldt()
        {
            int dong = tbthongtin.getRowCount();
            if(dong<=0){return;}
            try
            {
                JFileChooser savefile = new JFileChooser();
                int result = savefile.showSaveDialog(btngvxuatexcel);
                if(result != JFileChooser.APPROVE_OPTION){return;}
                File fileToSave = savefile.getCurrentDirectory();
                String link = fileToSave.getPath();
                String ten = savefile.getSelectedFile().getName();
                String linksave = link+"\\"+ten+".xls";
                
                WritableWorkbook workbook = Workbook.createWorkbook(new File(linksave));
                WritableSheet sheet = workbook.createSheet("Sinh Viên", 0);
                sheet.addCell(new Label(0, 0, "Mã Sinh Viên"));
                sheet.addCell(new Label(1, 0, "Tên Sinh Viên"));
                sheet.addCell(new Label(2, 0, "Giới tính"));
                sheet.addCell(new Label(3, 0, "Ngày sinh"));
                sheet.addCell(new Label(4, 0, "CMND"));
                sheet.addCell(new Label(5, 0, "Email"));
                sheet.addCell(new Label(6, 0, "Địa chỉ"));
                sheet.addCell(new Label(7, 0, "Ngày Nhập học"));
                
                for(int i =1; i<=dong;i++)
                {
                    sheet.addCell(new Label(0, i, tbthongtin.getValueAt(i-1, 0).toString()));
                    sheet.addCell(new Label(1, i, tbthongtin.getValueAt(i-1, 1).toString()));
                    sheet.addCell(new Label(2, i, tbthongtin.getValueAt(i-1, 2).toString()));
                    sheet.addCell(new Label(3, i,tbthongtin.getValueAt(i-1, 3).toString()));
                    sheet.addCell(new Label(4, i, tbthongtin.getValueAt(i-1, 4).toString()));
                    sheet.addCell(new Label(5, i, tbthongtin.getValueAt(i-1, 5).toString()));
                    sheet.addCell(new Label(6, i, tbthongtin.getValueAt(i-1, 6).toString()));
                    sheet.addCell(new Label(7, i, tbthongtin.getValueAt(i-1, 7).toString()));
                }
                workbook.write();
                workbook.close();
                JOptionPane.showMessageDialog(this, "Xuất file thành công!!!");
            }
            catch(Exception e){JOptionPane.showMessageDialog(this, "Lỗi: "+e);}
            
        }
        
        public void loaddbdaotao(String tentk)
        {
            try
            {
                Class.forName(dvsql);
                Connection cnt = DriverManager.getConnection(urldb);
                String sqlquerry = "select nienkhoa from lop group by nienkhoa";
                Statement sm = cnt.createStatement();
                ResultSet rs = sm.executeQuery(sqlquerry);
                if(rs.isBeforeFirst() == false){JOptionPane.showMessageDialog(this, "Chưa có lớp");return;}
                
                DefaultMutableTreeNode lop = new DefaultMutableTreeNode("Các lớp");
                
                while(rs.next()){
                    DefaultMutableTreeNode nienkhoa = new DefaultMutableTreeNode(rs.getString(1).toString());
                    Statement sm2 = cnt.createStatement();
                    ResultSet rs2 = sm2.executeQuery("select khoi from lop where nienkhoa like '"+rs.getString(1)+"' group by khoi");
                    while(rs2.next())
                    {
                        DefaultMutableTreeNode lop1 = new DefaultMutableTreeNode("Khối "+rs2.getString(1));
                        Statement sm1 = cnt.createStatement();
                        ResultSet rs1 = sm1.executeQuery("select lop from lop where khoi ="+rs2.getInt(1)+" and nienkhoa like '"+rs.getString(1)+"' group by lop");
                        while(rs1.next())
                        {
                            DefaultMutableTreeNode lop2 = new DefaultMutableTreeNode(rs1.getString(1));
                            lop1.add(lop2);
                        }
                        nienkhoa.add(lop1); 
                    }
                    lop.add(nienkhoa);
                }
                    
                    DefaultTreeModel listtree = new DefaultTreeModel(lop);
                    Tdanhsachlop.setModel(listtree);
                    cnt.close();
                    
            
            }
           catch(Exception a){JOptionPane.showMessageDialog(jFrameDangNhap, "Lỗi: "+a);}
        }
        
        public void loaddbttnv()
        {
            
       try{
        Class.forName(dvsql);
        Connection cnt = DriverManager.getConnection(urldb);
        String sqlquerry = "select manv ,ten, loaitaikhoan, (case when loaitaikhoan =0 then N'Admin' when loaitaikhoan=1 then N'Giáo Viên' when loaitaikhoan=2 then N'Đào Tạo' end) as cv , email from nhanvien";
        Statement sm = cnt.createStatement();
        ResultSet rs = sm.executeQuery(sqlquerry);
        String [] title2 = {"Mã nhân viên","Tên nhân viên","Loại tài khoản","Tên Loại","Email"};
        DefaultTableModel bang1 = new DefaultTableModel(title2,0);
            Vector sv = null;
            if(rs.isBeforeFirst() == false){JOptionPane.showMessageDialog(jFramethongtinnhanvien, "Chưa có nhân viên");return;}
            while(rs.next())
            {
                sv = new Vector();
                sv.add(rs.getString(1));
                sv.add(rs.getString(2));
                sv.add(rs.getInt(3));
                sv.add(rs.getString(4));
                sv.add(rs.getString(5));
                bang1.addRow(sv);
            }
            tbqlnv.setModel(bang1);
            tbqlnv.setRowSelectionInterval(0, 0);
            cnt.close();
        }
        catch(Exception a){JOptionPane.showMessageDialog(this, "Lỗi: "+a);}
        }
        
        public void chonfiledinhkem()
        {
                JFileChooser openfile = new JFileChooser();
                int result = openfile.showOpenDialog(btngmdtfiledinhkem);
                if(result != JFileChooser.APPROVE_OPTION){return;}
                linkdinhkem[slfile]  = openfile.getSelectedFile().toString();
                if(lbgmdtfiledinhkem.getText().isEmpty()){lbgmdtfiledinhkem.setText(openfile.getSelectedFile().getName());}
                else{lbgmdtfiledinhkem.setText(lbgmdtfiledinhkem.getText()+"; "+openfile.getSelectedFile().getName());}
                slfile++;
        }
        
        public void chonfiledinhkemall()
        {
                JFileChooser openfile = new JFileChooser();
                int result = openfile.showOpenDialog(btnguifile);
                if(result != JFileChooser.APPROVE_OPTION){return;}
                linkdinhkemall[sllink]  = openfile.getSelectedFile().toString();
                if(lbtenfile.getText().isEmpty()){lbtenfile.setText(openfile.getSelectedFile().getName());}
                else{lbtenfile.setText(lbtenfile.getText()+";"+openfile.getSelectedFile().getName());}
                sllink++;
        }
        
        public void quyentext(boolean a)
        {
            /*Dao tao*/
            txtgvmasv.setEditable(a);
            txtgvtensv.setEditable(a);
            txtgvdiemanh.setEditable(a);
            txtgvdiemtin.setEditable(a);
            txtgvdiemtoan.setEditable(a);
            
            
            txtdtmasv.setEditable(a);
            txtdttensv.setEditable(a);
            txtdtcmndsv.setEditable(a);
            txtdtngaysinh.setEditable(a);
            txtdtthangsinh.setEditable(a);
            txtdtnamsinh.setEditable(a);
            txtdtemailsv.setEditable(a);
            txtdtdiachisv.setEditable(a);
            txtdtngaynhaphoc.setEditable(a);
            txtdtthangnhaphoc.setEditable(a);
            txtdtnamnhaphoc.setEditable(a);
            rbdtnam.setEnabled(a);
            rbdtnu.setEnabled(a);
            
            txtlmalop.setEditable(a);
            txtllop.setEditable(a);
            txtlmagv.setEditable(a);
            txtlnienkhoa.setEditable(a);
            
        }
        
        public void quyentextdt(boolean a)
        {
            txtdtmasv.setEditable(a);
            txtdttensv.setEditable(a);
            txtdtcmndsv.setEditable(a);
            txtdtngaysinh.setEditable(a);
            txtdtthangsinh.setEditable(a);
            txtdtnamsinh.setEditable(a);
            txtdtemailsv.setEditable(a);
            txtdtdiachisv.setEditable(a);
            txtdtngaynhaphoc.setEditable(a);
            txtdtthangnhaphoc.setEditable(a);
            txtdtnamnhaphoc.setEditable(a);
            rbdtnam.setEnabled(a);
            rbdtnu.setEnabled(a);
        }
        
        public String[] laymangemail(String chu)
    {
     /*Đây là function trả về mảng email*/
    String[] chuoi=new String[1000];
    String e = chu;
    int t=0;
    int t2=0;
    int r=0;
    for(int i=0;r!=-1 ;i++)
    {
        r = e.indexOf(";", r);
        if(r==-1){chuoi[t]=e.substring(t2);break;}
        if(e.substring(t2, r).equals("")==false)
        {
            chuoi[t]=e.substring(t2, r);
            t+=1;
        }
        r+=1;
        t2=r;
    }
    String[] chuoicuoi = new String[t+1];
    for(int i=0; i<=t;i++)
    {
        chuoicuoi[i]=chuoi[i];
    }
        return chuoicuoi;
    }
        
       
        
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLySinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLySinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLySinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLySinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLySinhVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackgroundDangNhap;
    private javax.swing.JLabel PanelDangNhap;
    private javax.swing.JTree Tdanhsachlop;
    private javax.swing.JButton btndangnhap;
    private javax.swing.JButton btndmkdoimk;
    private javax.swing.JButton btndoimatkhau;
    private javax.swing.JButton btndtdong;
    private javax.swing.JButton btndtguimail;
    private javax.swing.JButton btndthiencaclop;
    private javax.swing.JButton btndtsuasv;
    private javax.swing.JButton btndtthemsv;
    private javax.swing.JButton btndttimkiem;
    private javax.swing.JButton btndttkdong;
    private javax.swing.JButton btndttktim;
    private javax.swing.JButton btndtxoasv;
    private javax.swing.JButton btndtxuatexcel;
    private javax.swing.JButton btngmdong;
    private javax.swing.JButton btngmdtdong;
    private javax.swing.JButton btngmdtfiledinhkem;
    private javax.swing.JButton btngmdtgui;
    private javax.swing.JButton btngmgv1svdong;
    private javax.swing.JButton btngmgv1svgui;
    private javax.swing.JButton btngmgvnhieusvdong;
    private javax.swing.JButton btngmgvnhieusvgui;
    private javax.swing.JButton btngui;
    private javax.swing.JButton btnguifile;
    private javax.swing.JButton btnguimail;
    private javax.swing.JButton btngvdong;
    private javax.swing.JButton btngvguidiem1sv;
    private javax.swing.JButton btngvguidiemnhieusv;
    private javax.swing.JButton btngvsuadiem;
    private javax.swing.JButton btngvtimkiem;
    private javax.swing.JButton btngvtkdong;
    private javax.swing.JButton btngvtktim;
    private javax.swing.JButton btngvxoadiem;
    private javax.swing.JButton btngvxuatexcel;
    private javax.swing.JButton btnldong;
    private javax.swing.JButton btnlopthemsv;
    private javax.swing.JButton btnlopxoasv;
    private javax.swing.JButton btnlsualop;
    private javax.swing.JButton btnlsvchuacolop;
    private javax.swing.JButton btnlthem;
    private javax.swing.JButton btnlxoalop;
    private javax.swing.JButton btnqlmkdoi;
    private javax.swing.JButton btnqlmkdong;
    private javax.swing.JButton btnqlnvdong;
    private javax.swing.JButton btnqlnvthaydoi;
    private javax.swing.JButton btnqlnvxoa;
    private javax.swing.JButton btnqmkdong;
    private javax.swing.JButton btnqmkgui;
    private javax.swing.JButton btnresetguimail;
    private javax.swing.JButton btntaotktao;
    private javax.swing.JButton btntaotkthoat;
    private javax.swing.JComboBox<String> cbdtnienkhoa;
    private javax.swing.JComboBox<String> cbgvtknam;
    private javax.swing.JComboBox<String> cbgvtkpheptoan;
    private javax.swing.JComboBox<String> cblkhoi;
    private javax.swing.JComboBox<String> cblthemmalop;
    private javax.swing.JComboBox<String> cblxoamalop;
    private javax.swing.JComboBox<String> cbqlmktaikhoan;
    private javax.swing.JComboBox<String> cbqlnvchucvu;
    private javax.swing.JComboBox<String> cbtaoloai;
    private javax.swing.JButton jButton4;
    private javax.swing.JFrame jFrameDangNhap;
    private javax.swing.JFrame jFramedoimatkhau;
    private javax.swing.JFrame jFramedttimkiem;
    private javax.swing.JFrame jFrameguimailall;
    private javax.swing.JFrame jFrameguimaildt;
    private javax.swing.JFrame jFrameguimailgv1sv;
    private javax.swing.JFrame jFrameguimailgvnhieusv;
    private javax.swing.JFrame jFramegvtimkiem;
    private javax.swing.JFrame jFramequanlymk;
    private javax.swing.JFrame jFramequenmatkhau;
    private javax.swing.JFrame jFrametaotaikhoan;
    private javax.swing.JFrame jFramethongtinnhanvien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuAboutus;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenu jMenudulieu;
    private javax.swing.JMenuItem jMenuphuchoi;
    private javax.swing.JMenuItem jMenuquanlymatkhau;
    private javax.swing.JMenuItem jMenusaoluu;
    private javax.swing.JMenuItem jMenutaotaikhoan;
    private javax.swing.JMenuItem jMenuthongtinnhanvien;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel lbdnquenmk;
    private javax.swing.JLabel lbgio;
    private javax.swing.JLabel lbgmdtfiledinhkem;
    private javax.swing.JLabel lbgvhinh;
    private javax.swing.JLabel lbhinhdt;
    private javax.swing.JLabel lbngay;
    private javax.swing.JLabel lbqlnvhinh;
    private javax.swing.JLabel lbtenfile;
    private javax.swing.JLabel lbtennv;
    private javax.swing.JLabel lbtop3diemtb1;
    private javax.swing.JLabel lbtop3diemtb2;
    private javax.swing.JLabel lbtop3diemtb3;
    private javax.swing.JLabel lbtop3masv1;
    private javax.swing.JLabel lbtop3masv2;
    private javax.swing.JLabel lbtop3masv3;
    private javax.swing.JLabel lbtop3tensv1;
    private javax.swing.JLabel lbtop3tensv2;
    private javax.swing.JLabel lbtop3tensv3;
    private javax.swing.JPasswordField passdmkmkcu;
    private javax.swing.JPasswordField passdmkmkmoi;
    private javax.swing.JPasswordField passdmknhaplai;
    private javax.swing.JPasswordField passtaotkmatkhau;
    private javax.swing.JPasswordField passtaotknhaplaimk;
    private javax.swing.JPanel pgiaovien;
    private javax.swing.JPanel pndt;
    private javax.swing.JPanel pnlthem;
    private javax.swing.JPanel pnlxoa;
    private javax.swing.JPopupMenu puhinh;
    private javax.swing.JPopupMenu puhinhnv;
    private javax.swing.JRadioButton rbbcc;
    private javax.swing.JRadioButton rbcc;
    private javax.swing.JRadioButton rbdtnam;
    private javax.swing.JRadioButton rbdtnu;
    private javax.swing.JRadioButton rbdttkcahai;
    private javax.swing.JRadioButton rbdttknam;
    private javax.swing.JRadioButton rbdttknu;
    private javax.swing.JRadioButton rbgmdtbcc;
    private javax.swing.JRadioButton rbgmdtcc;
    private javax.swing.JTabbedPane tbnhanvien;
    private javax.swing.JTable tbqlnv;
    private javax.swing.JTable tbthongtin;
    private javax.swing.JButton txtdndangnhap;
    private javax.swing.JPasswordField txtdnmatkhau;
    private javax.swing.JTextField txtdntaikhoan;
    private javax.swing.JButton txtdnthoat;
    private javax.swing.JTextField txtdtcmndsv;
    private javax.swing.JTextField txtdtdiachisv;
    private javax.swing.JTextField txtdtemailsv;
    private javax.swing.JTextField txtdtmasv;
    private javax.swing.JTextField txtdtnamnhaphoc;
    private javax.swing.JTextField txtdtnamsinh;
    private javax.swing.JTextField txtdtngaynhaphoc;
    private javax.swing.JTextField txtdtngaysinh;
    private javax.swing.JTextField txtdttensv;
    private javax.swing.JTextField txtdtthangnhaphoc;
    private javax.swing.JTextField txtdtthangsinh;
    private javax.swing.JTextField txtdttkcmnd;
    private javax.swing.JTextField txtdttkdiachi;
    private javax.swing.JTextField txtdttkemail;
    private javax.swing.JTextField txtdttkmasv;
    private javax.swing.JTextField txtdttknamnhaphoc;
    private javax.swing.JTextField txtdttknamsinh;
    private javax.swing.JTextField txtdttkngaynhaphoc;
    private javax.swing.JTextField txtdttkngaysinh;
    private javax.swing.JTextField txtdttktensv;
    private javax.swing.JTextField txtdttkthangnhaphoc;
    private javax.swing.JTextField txtdttkthangsinh;
    private javax.swing.JPasswordField txtgmdtmk;
    private javax.swing.JTextArea txtgmdtnoidung;
    private javax.swing.JTextField txtgmdttieude;
    private javax.swing.JTextField txtgmdttk;
    private javax.swing.JTextArea txtgmgv1svghichu;
    private javax.swing.JPasswordField txtgmgv1svmatkhau;
    private javax.swing.JTextField txtgmgv1svtaikhoan;
    private javax.swing.JTextArea txtgmgvnhieusvghichu;
    private javax.swing.JPasswordField txtgmgvnhieusvmatkhau;
    private javax.swing.JTextField txtgmgvnhieusvtaikhoan;
    private javax.swing.JTextField txtguiden;
    private javax.swing.JTextField txtgvdiemanh;
    private javax.swing.JTextField txtgvdiemtin;
    private javax.swing.JTextField txtgvdiemtoan;
    private javax.swing.JTextField txtgvmasv;
    private javax.swing.JTextField txtgvtensv;
    private javax.swing.JTextField txtgvtkdiemsv;
    private javax.swing.JTextField txtgvtklopsv;
    private javax.swing.JTextField txtgvtkmasv;
    private javax.swing.JTextField txtgvtktensv;
    private javax.swing.JTextField txtllop;
    private javax.swing.JTextField txtlmagv;
    private javax.swing.JTextField txtlmalop;
    private javax.swing.JTextField txtlnienkhoa;
    private javax.swing.JTextField txtlthemmasv;
    private javax.swing.JTextField txtlxoamasv;
    private javax.swing.JPasswordField txtmk;
    private javax.swing.JTextArea txtnoidung;
    private javax.swing.JPasswordField txtqlmkmkmoi;
    private javax.swing.JTextField txtqlnvemail;
    private javax.swing.JTextField txtqlnvma;
    private javax.swing.JTextField txtqlnvtennv;
    private javax.swing.JTextField txtqmktaikhoan;
    private javax.swing.JTextField txttaotkmanv;
    private javax.swing.JTextField txttaotktennv;
    private javax.swing.JTextField txttieude;
    private javax.swing.JTextField txttk;
    // End of variables declaration//GEN-END:variables
}
