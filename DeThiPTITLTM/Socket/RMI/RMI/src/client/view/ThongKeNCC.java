/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.view;

import client.controller.ClientCtr;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.RankHangHoa;
import model.RankNCC;

/**
 *
 * @author Admin
 */
public class ThongKeNCC extends javax.swing.JFrame {

    /**
     * Creates new form ThongKeNCC
     */
    RankNCC[] listNCCs;

    public ThongKeNCC() {
        initComponents();
        ClientCtr ctr = new ClientCtr();
        listNCCs = ctr.remoteGetSoLuongNCC();
        showTable();
    }

    private void showTable() {
        DefaultTableModel model = (DefaultTableModel) tblHangHoa.getModel();
        model.setRowCount(0);
        model.getDataVector().removeAllElements();
        if (listNCCs == null) {
//            JOptionPane.showMessageDialog(this, "Không có NCC nào!");
            return;
        }
        for (RankNCC i : listNCCs) {
            Vector tmp = new Vector();
            tmp.add(i.getId());
            tmp.add(i.getName());
            tmp.add(i.getAddress());
            tmp.add(i.getPhone());
            tmp.add(i.getEmail());
            tmp.add(i.getDescription());
            tmp.add(i.getSoLuong());
            model.addRow(tmp);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblHangHoa = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblHangHoa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblHangHoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Ma", "Ten", "DiaChi", "phone", "Email", "description", "soLuong"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHangHoa.setRowHeight(30);
        tblHangHoa.setRowMargin(4);
        tblHangHoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHangHoaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHangHoa);

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jButton1)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblHangHoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHangHoaMouseClicked
                int col = tblHangHoa.getColumnModel().getColumnIndexAtX(evt.getX());
                int row = evt.getY() / tblHangHoa.getRowHeight();
                if (0 <= row && row < listNCCs.length) {
                    RankNCC ncc = listNCCs[row];
                    
                    String s = "";
                    s += "Id:          " + ncc.getId() + "\n";
                    s += "Name:        " + ncc.getName() + "\n";
                    s += "Address:     " + ncc.getAddress() + "\n";
                    s += "Phone:       " + ncc.getPhone() + "\n";
                    s += "Email:       " + ncc.getEmail() + "\n";
                    s += "Description: " + ncc.getDescription() + "\n";
                    s += "soLuong:     " + ncc.getSoLuong() + "\n";
                    JOptionPane.showMessageDialog(this, s);
                }
    }//GEN-LAST:event_tblHangHoaMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new MENU().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ThongKeNCC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongKeNCC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongKeNCC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongKeNCC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThongKeNCC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblHangHoa;
    // End of variables declaration//GEN-END:variables
}