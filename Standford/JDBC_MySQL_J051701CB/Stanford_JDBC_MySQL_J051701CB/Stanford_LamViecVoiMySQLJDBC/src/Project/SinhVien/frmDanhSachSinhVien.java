package Project.SinhVien;

import Project.Khoa.ChuyenKhoa;
import Project.Khoa.ChuyenKhoaBussiness;
import Project.SinhVien.frmCapNhatSinhVienn;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Project.SinhVien.SinhVienBussiness;
import Project.SinhVien.SinhVien;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 * @author cuongvv
 */
public class frmDanhSachSinhVien extends javax.swing.JFrame {

    /**
     * Creates new form frmDanhSachSinhVien
     */
    public frmDanhSachSinhVien() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);

//        IBaseBussiness ok = null;
//        SinhVienBussiness sv ;
//        switch(code) {
//            case    1: ok =new SinhVienBussiness();
//            case 2: ok = new ChuyenkhoaBS();
//        }
//        ok.getAll();
//        
//        List<SinhVien> lst = ok.getAll();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lbltextSinhVien = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDSSV = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblTongSo = new javax.swing.JLabel();
        btnThemMoi = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnDong = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblKhoa = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbDSK = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbDSSVtheoKhoa = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cboTenKhoa = new javax.swing.JComboBox<>();
        btnHienthi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(2147483647, 64));
        setPreferredSize(new java.awt.Dimension(1150, 600));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jTabbedPane1.setMinimumSize(new java.awt.Dimension(500, 500));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1000, 1000));

        jPanel4.setPreferredSize(new java.awt.Dimension(766, 500));

        lbltextSinhVien.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbltextSinhVien.setForeground(new java.awt.Color(255, 0, 0));
        lbltextSinhVien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbltextSinhVien.setText("Thông tin sinh viên");
        lbltextSinhVien.setToolTipText("");
        lbltextSinhVien.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addComponent(lbltextSinhVien, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                .addContainerGap(151, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbltextSinhVien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
        );

        tbDSSV.setBorder(new javax.swing.border.MatteBorder(null));
        tbDSSV.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbDSSV);

        jLabel1.setText("Tổng:");

        lblTongSo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblTongSo.setText("0");

        btnThemMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project/images/add-icon.png"))); // NOI18N
        btnThemMoi.setText("Thêm Mới");
        btnThemMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMoiActionPerformed(evt);
            }
        });

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project/images/book_edit.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project/images/delete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnDong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project/images/cancel.gif"))); // NOI18N
        btnDong.setText("Đóng");
        btnDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTongSo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThemMoi)
                .addGap(18, 18, 18)
                .addComponent(btnSua)
                .addGap(18, 18, 18)
                .addComponent(btnXoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDong)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(lblTongSo))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThemMoi)
                        .addComponent(btnSua)
                        .addComponent(btnXoa)
                        .addComponent(btnDong)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Danh sách", jPanel4);

        lblKhoa.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblKhoa.setForeground(new java.awt.Color(255, 0, 0));
        lblKhoa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblKhoa.setText("Thông tin khoa");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(269, 269, 269)
                .addComponent(lblKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                .addContainerGap(225, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
        );

        tbDSK.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tbDSK);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane3)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Danh sách khoa", jPanel5);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách sinh viên"));

        tbDSSVtheoKhoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Sinh Viên", "Họ tên", "Giới tính", "Ngày sinh", "Điện thoại", "Địa chỉ", "Email"
            }
        ));
        tbDSSVtheoKhoa.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jScrollPane2.setViewportView(tbDSSVtheoKhoa);
        if (tbDSSVtheoKhoa.getColumnModel().getColumnCount() > 0) {
            tbDSSVtheoKhoa.getColumnModel().getColumn(0).setPreferredWidth(5);
        }

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Chọn khoa"));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Tên Khoa :");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        cboTenKhoa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboTenKhoa.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnHienthi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project/images/ZoomHS.png"))); // NOI18N
        btnHienthi.setText("Tìm Kiếm");
        btnHienthi.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnHienthi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHienthiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(cboTenKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHienthi)
                .addContainerGap(149, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cboTenKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHienthi))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Danh sách sinh viên theo khoa", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setTitle("Quản lý sinh viên");
        hienThiDanhSachSV();
        hienThiDanhSachKhoa(ChuyenKhoaBussiness.getInstance().getAllChuyenKhoa());
        hienThiChuyenKhoa();
    }//GEN-LAST:event_formWindowOpened

    private void btnThemMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMoiActionPerformed
        frmCapNhatSinhVienn frm = new frmCapNhatSinhVienn();
        frm.setVisible(true);
    }//GEN-LAST:event_btnThemMoiActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int select = tbDSSV.getSelectedRow();
        // Nếu chưa chọn sinh viên để sửa -> Thông báo
        if (select == -1) {
            JOptionPane.showMessageDialog(this,
                    "Vui lòng chọn sinh viên muốn sửa");
            return;
        }
        String maSV = (String) tbDSSV.getValueAt(select, 0);
        frmCapNhatSinhVienn frm = new frmCapNhatSinhVienn();
        frm.setMaSV(maSV);
        frm.setVisible(true);
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int select = tbDSSV.getSelectedRow();
        if (select == -1) {
            JOptionPane.showMessageDialog(this,
                    "Vui lòng chọn sinh viên muốn xóa");
            return;
        }
        SinhVienBussiness svd = new SinhVienBussiness();
        String maSV = (String) tbDSSV.getValueAt(select, 0);
        if (JOptionPane.showConfirmDialog(this, "Bạn muốn xóa", "Bạn chắc chắn "
                + "muốn xóa", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            boolean kq = svd.xoaSV(maSV);
            if (kq) {
                JOptionPane.showMessageDialog(rootPane, "Thành công");
                hienThiDanhSachSV();
            }
        }

    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnDongActionPerformed

    private void btnHienthiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHienthiActionPerformed
        ChuyenKhoa ck = (ChuyenKhoa) cboTenKhoa.getSelectedItem();
        SinhVien sv = new SinhVien();
        sv.setChuyenKhoaID(ck);
        String tenKhoa = sv.getChuyenKhoaID().getTenKhoa();
        List<SinhVien> lst = SinhVienBussiness.getInstance().getSVTheoChuyenKhoa(tenKhoa);
        hienThiDanhSachSVTheoKhoa(lst);
    }//GEN-LAST:event_btnHienthiActionPerformed

    public static void hienThiDanhSachSV() {
        SinhVienBussiness sb = new SinhVienBussiness();
        hienThiDanhSachSV(sb.getAll());
    }

    public static void hienThiDanhSachSV(List<SinhVien> lstSinhVien) {

        String colTieuDe[] = new String[]{"Mã SV", "Họ Tên", "Giới Tính",
            "Ngày Sinh", "Địa Chỉ", "Điện Thoại", "Email", "Tên Khoa"};

        DefaultTableModel model = new DefaultTableModel(colTieuDe, 0);
        Object objSinhVien[];
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        for (SinhVien sv : lstSinhVien) {
            objSinhVien = new Object[colTieuDe.length];
            objSinhVien[0] = sv.getMaSV();
            objSinhVien[1] = sv.getHoTen();
            if (sv.getGioiTinh() == 1) {
                objSinhVien[2] = "Nam";
            } else {
                objSinhVien[2] = "Nữ";
            }
            if (sv.getNgaySinh() != null) {
                objSinhVien[3] = df.format(sv.getNgaySinh());
            }
            objSinhVien[4] = sv.getDiaChi();
            objSinhVien[5] = sv.getDienThoai();
            objSinhVien[6] = sv.geteMail();
            if (sv.getChuyenKhoaID() != null) {
                objSinhVien[7] = sv.getChuyenKhoaID().getTenKhoa();
            }

            //Thêm vào model
            model.addRow(objSinhVien);
        }
        System.out.println("------" + lstSinhVien.size());
        //Hiển thị thông tin lên JTable 
        tbDSSV.setModel(model);
        lblTongSo.setText(lstSinhVien.size() + "");

    }

    public static void hienThiDanhSachKhoa(List<ChuyenKhoa> lstKhoa) {
        String colTieuDe[] = new String[]{"Mã Khoa", "Tên Khoa"};

        DefaultTableModel model = new DefaultTableModel(colTieuDe, 0);
        Object objKhoa[];
        for (ChuyenKhoa ck : lstKhoa) {
            objKhoa = new Object[colTieuDe.length];
            objKhoa[0] = ck.getMaKhoa();
            objKhoa[1] = ck.getTenKhoa();
            model.addRow(objKhoa);
        }
        System.out.println("------" + lstKhoa.size());
        //Hiển thị thông tin lên JTable 
        tbDSK.setModel(model);

    }

    private class ChuyenKhoaRender extends BasicComboBoxRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value,
                int index, boolean isSelected, boolean cellHasFocus) {
            if (value instanceof ChuyenKhoa) {
                ChuyenKhoa ck = (ChuyenKhoa) value;
                setText(ck.getTenKhoa());
            }
            return this;
        }

    }

    private void hienThiChuyenKhoa() {
        List<ChuyenKhoa> lst = new ChuyenKhoaBussiness().getAllChuyenKhoa();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for (ChuyenKhoa ck : lst) {
            model.addElement(ck);
        }
        cboTenKhoa.setModel(model);
        cboTenKhoa.setRenderer(new ChuyenKhoaRender());
    }

    public static void hienThiDanhSachSVTheoKhoa(List<SinhVien> lstSinhVien) {

        String colTieuDe[] = new String[]{"Mã SV", "Họ Tên", "Giới Tính",
            "Ngày Sinh", "Địa Chỉ", "Điện Thoại", "Email"};

        DefaultTableModel model = new DefaultTableModel(colTieuDe, 0);
        Object objSinhVien[];
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        for (SinhVien sv : lstSinhVien) {
            objSinhVien = new Object[colTieuDe.length];
            objSinhVien[0] = sv.getMaSV();
            objSinhVien[1] = sv.getHoTen();
            if (sv.getGioiTinh() == 1) {
                objSinhVien[2] = "Nam";
            } else {
                objSinhVien[2] = "Nữ";
            }
            if (sv.getNgaySinh() != null) {
                objSinhVien[3] = df.format(sv.getNgaySinh());
            }
            objSinhVien[4] = sv.getDiaChi();
            objSinhVien[5] = sv.getDienThoai();
            objSinhVien[6] = sv.geteMail();

            //Thêm vào model
            model.addRow(objSinhVien);
        }
        System.out.println("------" + lstSinhVien.size());
        //Hiển thị thông tin lên JTable 
        tbDSSVtheoKhoa.setModel(model);

    }

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
            java.util.logging.Logger.getLogger(frmDanhSachSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmDanhSachSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmDanhSachSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmDanhSachSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                }
                new frmDanhSachSinhVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDong;
    private javax.swing.JButton btnHienthi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThemMoi;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboTenKhoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblKhoa;
    private static javax.swing.JLabel lblTongSo;
    private javax.swing.JLabel lbltextSinhVien;
    private static javax.swing.JTable tbDSK;
    private static javax.swing.JTable tbDSSV;
    private static javax.swing.JTable tbDSSVtheoKhoa;
    // End of variables declaration//GEN-END:variables
}