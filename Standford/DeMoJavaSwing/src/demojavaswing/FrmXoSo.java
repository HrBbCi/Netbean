/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demojavaswing;

import com.sun.corba.se.spi.oa.OADefault;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Kien
 */
public class FrmXoSo extends javax.swing.JFrame {

    public FrmXoSo() {
        initComponents();
    }
    public static int Random5() {
        Integer a;
        Random rd = new Random();
        do {
            a = rd.nextInt(99999);
        } while (a < 10000 || a > 99999);
        return a;
    }
    public static int Random4() {
        Integer a;
        Random rd = new Random();
        do {
            a = rd.nextInt(9999);
        } while (a < 1000 || a > 9999);
        return a;
    }
    public static int Random3() {
        Integer a;
        Random rd = new Random();
        do {
            a = rd.nextInt(999);
        } while (a < 100 || a > 999);
        return a;
    }
    public static int Random2() {
        Integer a;
        Random rd = new Random();
        do {
            a = rd.nextInt(99);
        } while (a < 10 || a > 99);
        return a;
    }
    int count = 1;
    public void actionPerformed(ActionEvent ae) {
        lbl.setText("Button is clicked " + count + " times!");
        count++;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tblBangKetQua = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtSoDanh = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTienCuocc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtGiaiThuong = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBangLo = new javax.swing.JTable();
        btnQuay = new javax.swing.JButton();
        txtNgayThang = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt0 = new javax.swing.JTextField();
        txt1 = new javax.swing.JTextField();
        txt2 = new javax.swing.JTextField();
        txt3 = new javax.swing.JTextField();
        txt4 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblBangKetQua1 = new javax.swing.JTable();
        jTextField7 = new javax.swing.JTextField();
        txt5 = new javax.swing.JTextField();
        txt6 = new javax.swing.JTextField();
        txt7 = new javax.swing.JTextField();
        txt8 = new javax.swing.JTextField();
        txt9 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnQuayLai = new javax.swing.JButton();
        lbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lô đề");

        tblBangKetQua.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"0"},
                {"1"},
                {"2"},
                {"3"},
                {"4"}
            },
            new String [] {
                "Đầu"
            }
        ));
        tblBangKetQua.setRowHeight(34);
        jScrollPane2.setViewportView(tblBangKetQua);
        if (tblBangKetQua.getColumnModel().getColumnCount() > 0) {
            tblBangKetQua.getColumnModel().getColumn(0).setPreferredWidth(20);
        }

        jLabel1.setText("Số cần đánh:");

        jLabel2.setText("Tiền cược:");

        jLabel3.setText("Giải thưởng:");

        tblBangLo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", "", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBangLo.setRowHeight(30);
        jScrollPane1.setViewportView(tblBangLo);
        if (tblBangLo.getColumnModel().getColumnCount() > 0) {
            tblBangLo.getColumnModel().getColumn(0).setResizable(false);
            tblBangLo.getColumnModel().getColumn(0).setPreferredWidth(80);
        }

        btnQuay.setText("Quay");
        btnQuay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayActionPerformed(evt);
            }
        });

        jLabel4.setText("Số lần quay:");

        jTextField6.setText("Lô tô");

        tblBangKetQua1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"5"},
                {"6"},
                {"7"},
                {"8"},
                {"9"}
            },
            new String [] {
                "Đầu"
            }
        ));
        tblBangKetQua1.setRowHeight(34);
        jScrollPane3.setViewportView(tblBangKetQua1);
        if (tblBangKetQua1.getColumnModel().getColumnCount() > 0) {
            tblBangKetQua1.getColumnModel().getColumn(0).setPreferredWidth(20);
        }

        jTextField7.setText("Lô tô");

        jLabel5.setText("                                        Bảng kết quả đề");

        btnQuayLai.setText("Quay lại");
        btnQuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayLaiActionPerformed(evt);
            }
        });

        lbl.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtGiaiThuong))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                        .addComponent(btnQuay)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt0, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                    .addComponent(txt4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt8)
                                    .addComponent(txt7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txt6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txt5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txt9)
                                    .addComponent(jTextField7)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTienCuocc)
                                    .addComponent(txtSoDanh)))))
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNgayThang, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSoDanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtTienCuocc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt0, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(txt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt9)))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtGiaiThuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnQuay)
                            .addComponent(jLabel4)
                            .addComponent(btnQuayLai)
                            .addComponent(lbl)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txt0, txt1, txt2, txt3, txt4});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnQuayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayActionPerformed

        Date a = new Date();
        txtNgayThang.setText("" + a);

        String strSoCanDanh = "", strTienCuoc = "", strTienThuong = "";
        int soCanDanh = 0, soTienCuoc = 0, soTienThuong = 0;

        strSoCanDanh = txtSoDanh.getText();
        strTienCuoc = txtTienCuocc.getText();

        try {
            soCanDanh = Integer.parseInt(strSoCanDanh);
            soTienCuoc = Integer.parseInt(strTienCuoc);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Nhập lại đi");
            return;
        }

        Random rd = new Random();
        Integer soNgauNhien[] = new Integer[100];
        DefaultTableModel model = (DefaultTableModel) tblBangLo.getModel();
        for (int i = 1; i <= 10; i++) {
            soNgauNhien[i] = Random5();
        }

        model.addRow(new Object[]{
            "Giải đặc biệt", soNgauNhien[1]
        });
        model.addRow(new Object[]{
            "Giải nhất", soNgauNhien[2]
        });
        model.addRow(new Object[]{
            "Giải nhì", soNgauNhien[3], soNgauNhien[4]
        });
        model.addRow(new Object[]{
            "Giải ba", soNgauNhien[5], soNgauNhien[6], soNgauNhien[7],});
        model.addRow(new Object[]{
            "", soNgauNhien[8], soNgauNhien[9], soNgauNhien[10]
        });

        for (int i = 11; i <= 20; i++) {
            soNgauNhien[i] = Random4();
        }
        model.addRow(new Object[]{
            "Giải tư", soNgauNhien[11], soNgauNhien[12], soNgauNhien[13],
            soNgauNhien[14]});

        model.addRow(new Object[]{
            "Giải Năm", soNgauNhien[15], soNgauNhien[16], soNgauNhien[17],});
        model.addRow(new Object[]{
            "", soNgauNhien[18], soNgauNhien[19], soNgauNhien[20]
        });

        for (int i = 21; i <= 23; i++) {
            soNgauNhien[i] = Random3();
        }
        model.addRow(new Object[]{
            "Giải Sáu", soNgauNhien[21], soNgauNhien[22], soNgauNhien[23],});

        for (int i = 24; i <= 27; i++) {
            soNgauNhien[i] = Random2();
        }
        model.addRow(new Object[]{
            "Giải bảy", soNgauNhien[24], soNgauNhien[25], soNgauNhien[26],
            soNgauNhien[27]});
        model.addRow(new Object[]{""});
        model.addRow(new Object[]{""});
        model.addRow(new Object[]{""});

        soNgauNhien.toString();
        String A[] = new String[100];
        Integer Number[] = new Integer[100];
        //Chuyển sang mảng kết quả:

        double tienThuong = 0;
        String Kq[] = {"", "", "", "", "", "", "", "", "", ""};
        for (int i = 1; i <= 27; i++) {

            A[i] = soNgauNhien[i].toString().substring(soNgauNhien[i].toString().length() - 2,
                    soNgauNhien[i].toString().length());
            Number[i] = Integer.parseInt(A[i]);

            if ((A[i].substring(0, 1)).equals("0")) {
                Kq[0] += A[i] + ";";
                txt0.setText(Kq[0]);

            }
            if ((A[i].substring(0, 1)).equals("1")) {
                Kq[1] += A[i] + ";";
                txt1.setText(Kq[1]);
            }
            if ((A[i].substring(0, 1)).equals("2")) {
                Kq[2] += A[i] + ";";
                txt2.setText(Kq[2]);
            }
            if ((A[i].substring(0, 1)).equals("3")) {
                Kq[3] += A[i] + ";";
                txt3.setText(Kq[3]);
            }
            if ((A[i].substring(0, 1)).equals("4")) {
                Kq[4] += A[i] + ";";
                txt4.setText(Kq[4]);
            }
            if ((A[i].substring(0, 1)).equals("5")) {
                Kq[5] += A[i] + ";";
                txt5.setText(Kq[5]);
            }
            if ((A[i].substring(0, 1)).equals("6")) {
                Kq[6] += A[i] + ";";
                txt6.setText(Kq[6]);
            }
            if ((A[i].substring(0, 1)).equals("7")) {
                Kq[7] += A[i] + ";";
                txt7.setText(Kq[7]);
            }
            if ((A[i].substring(0, 1)).equals("8")) {
                Kq[8] += A[i] + ";";
                txt8.setText(Kq[8]);
            }
            if ((A[i].substring(0, 1)).equals("9")) {
                Kq[9] += A[i] + ";";
                txt9.setText(Kq[9]);
            }
        }
        //Tính tiền
        if (soCanDanh == Number[1]) {
            tienThuong = soTienCuoc * 70;
        }
        for (int i = 2; i <= 27; i++) {
            if (soCanDanh == Number[i]) {
                tienThuong += 220000;
            }
        }
        txtGiaiThuong.setText("" + tienThuong);
        actionPerformed(evt);
    }//GEN-LAST:event_btnQuayActionPerformed

    private void btnQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaiActionPerformed
            txt0.setText("");
            txt1.setText("");
            txt2.setText("");
            txt3.setText("");
            txt4.setText("");
            txt5.setText("");
            txt6.setText("");
            txt7.setText("");
            txt8.setText("");
            txt9.setText("");
    }//GEN-LAST:event_btnQuayLaiActionPerformed

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
            java.util.logging.Logger.getLogger(FrmXoSo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmXoSo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmXoSo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmXoSo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException e) {
                    Logger.getLogger(FrmXoSo.class.getName()).log(Level.SEVERE, null, e);
                } catch (InstantiationException ex) {
                    Logger.getLogger(FrmXoSo.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(FrmXoSo.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(FrmXoSo.class.getName()).log(Level.SEVERE, null, ex);
                }
                new FrmXoSo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQuay;
    private javax.swing.JButton btnQuayLai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JLabel lbl;
    private javax.swing.JTable tblBangKetQua;
    private javax.swing.JTable tblBangKetQua1;
    private javax.swing.JTable tblBangLo;
    private javax.swing.JTextField txt0;
    private javax.swing.JTextField txt1;
    private javax.swing.JTextField txt2;
    private javax.swing.JTextField txt3;
    private javax.swing.JTextField txt4;
    private javax.swing.JTextField txt5;
    private javax.swing.JTextField txt6;
    private javax.swing.JTextField txt7;
    private javax.swing.JTextField txt8;
    private javax.swing.JTextField txt9;
    private javax.swing.JTextField txtGiaiThuong;
    private javax.swing.JTextField txtNgayThang;
    private javax.swing.JTextField txtSoDanh;
    private javax.swing.JTextField txtTienCuocc;
    // End of variables declaration//GEN-END:variables
}