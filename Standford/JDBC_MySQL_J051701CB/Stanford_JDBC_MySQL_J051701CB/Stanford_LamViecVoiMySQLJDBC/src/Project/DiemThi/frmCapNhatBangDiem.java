/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project.DiemThi;

import Project.Khoa.ChuyenKhoa;
import Project.MonHoc.MonHoc;
import Project.MonHoc.MonHocBussiness;
import Project.PhongHoc.PhongHoc;
import Project.PhongHoc.PhongHocBussiness;
import Project.SinhVien.SinhVien;
import Project.SinhVien.SinhVienBussiness;
import java.awt.Component;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

/**
 *
 * @author HrBbCi
 */
public class frmCapNhatBangDiem extends javax.swing.JFrame {

    /**
     * Creates new form frmCapNhatBangDiem
     */
    BangDiemBussiness bdb = new BangDiemBussiness();
    private String maSV = "";
    private String maK = "";
    frmDanhsachdiem frmd = new frmDanhsachdiem();

    public String getMaK() {
        return maK;
    }

    public void setMaK(String maK) {
        this.maK = maK;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public frmCapNhatBangDiem() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cboMaSV = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cboMaMH = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        dateNgayThi = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        txtDiem = new javax.swing.JTextField();
        btnCapNhat = new javax.swing.JButton();
        btnDong = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cboMaPhong = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project/images/Help.png"))); // NOI18N
        jLabel1.setText("Mã sinh viên:");

        cboMaSV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project/images/Help.png"))); // NOI18N
        jLabel2.setText("Mã môn học");

        cboMaMH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project/images/calendar.gif"))); // NOI18N
        jLabel3.setText("Ngày thi:");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project/images/Help.png"))); // NOI18N
        jLabel4.setText("Điểm: ");

        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project/images/book_edit.png"))); // NOI18N
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnDong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project/images/cancel.gif"))); // NOI18N
        btnDong.setText("Đóng");
        btnDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project/images/Help.png"))); // NOI18N
        jLabel5.setText("Mã Phòng:");

        cboMaPhong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCapNhat)
                        .addGap(18, 18, 18)
                        .addComponent(btnDong))
                    .addComponent(txtDiem)
                    .addComponent(dateNgayThi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboMaMH, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboMaSV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboMaPhong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboMaMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cboMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(dateNgayThi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCapNhat)
                    .addComponent(btnDong))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnDongActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        DiemThi dt = new DiemThi();
        SinhVien sv = (SinhVien) cboMaSV.getSelectedItem();
        int a = 1 + cboMaSV.getSelectedIndex();
        sv.setIdsinhvien(a);

        System.out.println("ID SV: " + a);
        dt.setSinhVienID(sv);

        MonHoc mh = (MonHoc) cboMaMH.getSelectedItem();
        int b = 1 + cboMaMH.getSelectedIndex();
        mh.setMonHocID(b);
        System.out.println("ID MH: " + b);
        dt.setMonHocID(mh);

        PhongHoc ph = new PhongHoc();
        int c = 1 + cboMaPhong.getSelectedIndex();
        System.out.println("ID MP: " + c);
        ph.setPhongHocID(c);
        dt.setPhongHocID(ph);

        if((txtDiem.getText()+"").isEmpty() ||(txtDiem.getText()+"")==null){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập điểm");
            return;
        }
        dt.setDiemThi(Float.parseFloat(txtDiem.getText()));
        dt.setNgayThi(dateNgayThi.getDate());

        boolean kq = false;
        if (maSV == null || maSV.isEmpty()) {
            if (BangDiemBussiness.getInstance().CheckID(a, b)) {
                kq = bdb.addNew(dt);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Trùng môn rồi nhé");
            }

        } else {
            if (BangDiemBussiness.getInstance().CheckIDUpdate(a)) {
                kq = bdb.upDate(dt);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Vui lòng kiểm tra lại "
                        + "môn học và mã sinh viên");
            }
        }
        if (kq) {
            JOptionPane.showMessageDialog(rootPane, "Thành Công");
            frmDanhsachdiem.hienThiDanhSachDiem();
            frmd.setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        hienThiMaSV();
        hienThiMaMH();
        hienThiMaP();
        if (!maSV.isEmpty()) {
            this.setTitle("Sửa Điểm Thi");
            btnCapNhat.setText("Sửa");
            hienThiChiTiet();
        } else {
            this.setTitle("Thêm Mới Điểm Thi");
            btnCapNhat.setText("Thêm Mới");
        }
    }//GEN-LAST:event_formWindowOpened

    private class MaSinhVienRender extends BasicComboBoxRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            if (value instanceof SinhVien) {
                SinhVien sv = (SinhVien) value;
                setText(sv.getMaSV());
            }
            return this;
        }

    }

    private void hienThiMaSV() {
        List<SinhVien> lst = new SinhVienBussiness().getAllMaSV();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for (SinhVien sv : lst) {
            model.addElement(sv);
        }
        cboMaSV.setModel(model);
        cboMaSV.setRenderer(new MaSinhVienRender());
    }

    private class MaMonHocRender extends BasicComboBoxRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            if (value instanceof MonHoc) {
                MonHoc mh = (MonHoc) value;
                setText(mh.getMaMH());
            }
            return this;
        }

    }

    private void hienThiMaMH() {
        List<MonHoc> lst = new MonHocBussiness().getAllMaMH();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for (MonHoc mh : lst) {
            model.addElement(mh);
        }
        cboMaMH.setModel(model);
        cboMaMH.setRenderer(new MaMonHocRender());
    }

    private class MaPhongRender extends BasicComboBoxRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            if (value instanceof PhongHoc) {
                PhongHoc sv = (PhongHoc) value;
                setText(sv.getMaPhong());
            }
            return this;
        }

    }

    private void hienThiMaP() {
        List<PhongHoc> lst = new PhongHocBussiness().getAllMaP();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for (PhongHoc sv : lst) {
            model.addElement(sv);
        }
        cboMaPhong.setModel(model);
        cboMaPhong.setRenderer(new MaPhongRender());
    }

    private void hienThiChiTiet() {
        DiemThi dt = bdb.getByIDSinhVien(maSV, maK);
        System.out.println(maSV);
        if (dt != null) {
            System.out.println("Mã SV : " + dt.getSinhVienID().getMaSV());
            switch (dt.getSinhVienID().getMaSV()) {
                case "SF001":
                    cboMaSV.setSelectedIndex(0);
                    break;
                case "SF002":
                    cboMaSV.setSelectedIndex(1);
                    break;
                case "SF003":
                    cboMaSV.setSelectedIndex(2);
                    break;
                case "SF004":
                    cboMaSV.setSelectedIndex(3);
                    break;
                case "SF005":
                    cboMaSV.setSelectedIndex(4);
                    break;
                case "SF006":
                    cboMaSV.setSelectedIndex(5);
                    break;
                case "SF007":
                    cboMaSV.setSelectedIndex(6);
                    break;
                default:
                    cboMaSV.setSelectedIndex(7);
                    break;
            }
            System.out.println(dt.getMonHocID().getMaMH());
            switch (dt.getMonHocID().getMaMH()) {
                case "BAS1144":
                    cboMaMH.setSelectedIndex(0);
                    break;
                case "INT1313":
                    cboMaMH.setSelectedIndex(1);
                    break;
                case "INT1319":
                    cboMaMH.setSelectedIndex(2);
                    break;
                case "INT1330":
                    cboMaMH.setSelectedIndex(3);
                    break;
                case "SKD1101":
                    cboMaMH.setSelectedIndex(4);
                    break;
                default:
                    cboMaMH.setSelectedIndex(5);
                    break;
            }
            switch (dt.getPhongHocID().getMaPhong()) {
                case "101":
                    cboMaMH.setSelectedIndex(0);
                    break;
                case "102":
                    cboMaMH.setSelectedIndex(1);
                    break;
                case "103":
                    cboMaMH.setSelectedIndex(2);
                    break;
                case "104":
                    cboMaMH.setSelectedIndex(3);
                    break;
                case "201":
                    cboMaMH.setSelectedIndex(4);
                    break;
                case "202":
                    cboMaMH.setSelectedIndex(5);
                    break;
                case "203":
                    cboMaMH.setSelectedIndex(6);
                    break;
                default:
                    cboMaMH.setSelectedIndex(7);
                    break;
            }
            dateNgayThi.setDate(dt.getNgayThi());
            txtDiem.setText(dt.getDiemThi() + "");
        } else {
            System.out.println("NULL rồi");
        }
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
            java.util.logging.Logger.getLogger(frmCapNhatBangDiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCapNhatBangDiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCapNhatBangDiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCapNhatBangDiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCapNhatBangDiem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnDong;
    private javax.swing.JComboBox<String> cboMaMH;
    private javax.swing.JComboBox<String> cboMaPhong;
    private javax.swing.JComboBox<String> cboMaSV;
    private com.toedter.calendar.JDateChooser dateNgayThi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtDiem;
    // End of variables declaration//GEN-END:variables
}