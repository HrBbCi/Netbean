/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thuchanh.main;

/**
 *
 * @author HrBbCi
 */
public class FrmGiaoDien extends javax.swing.JFrame {

  /**
   * Creates new form FrmGiaoDien
   */
  public FrmGiaoDien() {
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

    jPopupMenu1 = new javax.swing.JPopupMenu();
    jMenuBar1 = new javax.swing.JMenuBar();
    menuHeThong = new javax.swing.JMenu();
    menuItemGT = new javax.swing.JMenuItem();
    menuItemThoat = new javax.swing.JMenuItem();
    menuSP = new javax.swing.JMenu();
    menuItemThemSP = new javax.swing.JMenuItem();
    menuItemXemSP = new javax.swing.JMenuItem();
    menuItemTimKiem = new javax.swing.JMenuItem();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Sản phẩm");

    menuHeThong.setText("Hệ Thống");

    menuItemGT.setText("Giới thiệu");
    menuItemGT.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuItemGTActionPerformed(evt);
      }
    });
    menuHeThong.add(menuItemGT);

    menuItemThoat.setText("Thoát");
    menuItemThoat.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuItemThoatActionPerformed(evt);
      }
    });
    menuHeThong.add(menuItemThoat);

    jMenuBar1.add(menuHeThong);

    menuSP.setText("Sản phẩm");

    menuItemThemSP.setText("Thêm sản phẩm");
    menuItemThemSP.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuItemThemSPActionPerformed(evt);
      }
    });
    menuSP.add(menuItemThemSP);

    menuItemXemSP.setText("Xem sản phẩm");
    menuItemXemSP.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuItemXemSPActionPerformed(evt);
      }
    });
    menuSP.add(menuItemXemSP);

    menuItemTimKiem.setText("Tìm kiếm");
    menuItemTimKiem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuItemTimKiemActionPerformed(evt);
      }
    });
    menuSP.add(menuItemTimKiem);

    jMenuBar1.add(menuSP);

    setJMenuBar(jMenuBar1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 632, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 342, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void menuItemGTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemGTActionPerformed
    FrmGioiThieu frm = new FrmGioiThieu();
    frm.setVisible(true);
  }//GEN-LAST:event_menuItemGTActionPerformed

  private void menuItemThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemThoatActionPerformed
    System.exit(0);
  }//GEN-LAST:event_menuItemThoatActionPerformed

  private void menuItemThemSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemThemSPActionPerformed
    FrmThemSP frm = new FrmThemSP();
    frm.setVisible(true);
  }//GEN-LAST:event_menuItemThemSPActionPerformed

  private void menuItemXemSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemXemSPActionPerformed
    FrmXemSP frm = new FrmXemSP();
    frm.setVisible(true);
  }//GEN-LAST:event_menuItemXemSPActionPerformed

  private void menuItemTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemTimKiemActionPerformed
    FrmTimKiemSP frm = new FrmTimKiemSP();
    frm.setVisible(true);
  }//GEN-LAST:event_menuItemTimKiemActionPerformed

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
      java.util.logging.Logger.getLogger(FrmGiaoDien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(FrmGiaoDien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(FrmGiaoDien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(FrmGiaoDien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new FrmGiaoDien().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JMenuBar jMenuBar1;
  private javax.swing.JPopupMenu jPopupMenu1;
  private javax.swing.JMenu menuHeThong;
  private javax.swing.JMenuItem menuItemGT;
  private javax.swing.JMenuItem menuItemThemSP;
  private javax.swing.JMenuItem menuItemThoat;
  private javax.swing.JMenuItem menuItemTimKiem;
  private javax.swing.JMenuItem menuItemXemSP;
  private javax.swing.JMenu menuSP;
  // End of variables declaration//GEN-END:variables
}
