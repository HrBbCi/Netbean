package Project.View;

import javax.swing.UIManager;

public class frmMain extends javax.swing.JFrame {

  /**
   * Creates new form frmMain
   */
  public static String a;

  public frmMain() {
    initComponents();
//        setExtendedState(JFrame.MAXIMIZED_BOTH);
    setLocationRelativeTo(null);
   
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
   * content of this method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jMenuBar1 = new javax.swing.JMenuBar();
    jMenu1 = new javax.swing.JMenu();
    menuDangNhap = new javax.swing.JMenuItem();
    menuDangXuat = new javax.swing.JMenuItem();
    menuThoat = new javax.swing.JMenuItem();
    jMenu2 = new javax.swing.JMenu();
    menuQLSV = new javax.swing.JMenuItem();
    menuQLK = new javax.swing.JMenuItem();
    menuQLDT = new javax.swing.JMenuItem();
    menuQLCLass = new javax.swing.JMenuItem();
    menuManageSubject = new javax.swing.JMenuItem();
    menuMNGLecture = new javax.swing.JMenuItem();
    menuLienHe = new javax.swing.JMenu();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Manage Student");
    setPreferredSize(new java.awt.Dimension(1150, 700));
    setResizable(false);
    addWindowListener(new java.awt.event.WindowAdapter() {
      public void windowOpened(java.awt.event.WindowEvent evt) {
        formWindowOpened(evt);
      }
    });

    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project/Images/back1.jpg"))); // NOI18N
    jLabel1.setPreferredSize(new java.awt.Dimension(1150, 766));

    jLabel2.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
    jLabel2.setForeground(new java.awt.Color(0, 0, 204));
    jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel2.setText("MANAGE SYSTEM STUDENT");

    jMenuBar1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 255)));

    jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project/images/Measure.png"))); // NOI18N
    jMenu1.setText("System");

    menuDangNhap.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.SHIFT_MASK));
    menuDangNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project/images/login.png"))); // NOI18N
    menuDangNhap.setText("Log in");
    menuDangNhap.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuDangNhapActionPerformed(evt);
      }
    });
    jMenu1.add(menuDangNhap);

    menuDangXuat.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.SHIFT_MASK));
    menuDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project/images/Logoff.png"))); // NOI18N
    menuDangXuat.setText("Log out");
    menuDangXuat.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuDangXuatActionPerformed(evt);
      }
    });
    jMenu1.add(menuDangXuat);

    menuThoat.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.SHIFT_MASK));
    menuThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project/images/logout.png"))); // NOI18N
    menuThoat.setText("Exit");
    menuThoat.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuThoatActionPerformed(evt);
      }
    });
    jMenu1.add(menuThoat);

    jMenuBar1.add(jMenu1);

    jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project/images/Folder-Scheduled-Tasks-icon.png"))); // NOI18N
    jMenu2.setText("Profession");

    menuQLSV.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK));
    menuQLSV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project/images/user.gif"))); // NOI18N
    menuQLSV.setText("Manage Student");
    menuQLSV.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuQLSVActionPerformed(evt);
      }
    });
    jMenu2.add(menuQLSV);

    menuQLK.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.SHIFT_MASK));
    menuQLK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project/images/007.png"))); // NOI18N
    menuQLK.setText("Manage Users");
    menuQLK.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuQLKActionPerformed(evt);
      }
    });
    jMenu2.add(menuQLK);

    menuQLDT.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.SHIFT_MASK));
    menuQLDT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project/images/register.gif"))); // NOI18N
    menuQLDT.setText("Manage Score");
    menuQLDT.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuQLDTActionPerformed(evt);
      }
    });
    jMenu2.add(menuQLDT);

    menuQLCLass.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK));
    menuQLCLass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project/Images/contacts.gif"))); // NOI18N
    menuQLCLass.setText("Manage Class");
    menuQLCLass.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuQLCLassActionPerformed(evt);
      }
    });
    jMenu2.add(menuQLCLass);

    menuManageSubject.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.SHIFT_MASK));
    menuManageSubject.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project/Images/book_edit.png"))); // NOI18N
    menuManageSubject.setText("Manage Subject");
    menuManageSubject.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuManageSubjectActionPerformed(evt);
      }
    });
    jMenu2.add(menuManageSubject);

    menuMNGLecture.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.SHIFT_MASK));
    menuMNGLecture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project/Images/userOnline.gif"))); // NOI18N
    menuMNGLecture.setText("Manage Lecturer");
    menuMNGLecture.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuMNGLectureActionPerformed(evt);
      }
    });
    jMenu2.add(menuMNGLecture);

    jMenuBar1.add(jMenu2);

    menuLienHe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project/images/changePass.png"))); // NOI18N
    menuLienHe.setText("Contact");
    menuLienHe.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        menuLienHeMouseClicked(evt);
      }
    });
    menuLienHe.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuLienHeActionPerformed(evt);
      }
    });
    jMenuBar1.add(menuLienHe);

    setJMenuBar(jMenuBar1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
      .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(1, 1, 1)
        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 429, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void menuQLSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuQLSVActionPerformed
      FrmListStudent frm = new FrmListStudent();
      frm.setVisible(true);
    }//GEN-LAST:event_menuQLSVActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
      disableMenu();
    }//GEN-LAST:event_formWindowOpened

    private void menuDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDangNhapActionPerformed
      FrmLogin frm = new FrmLogin();
      frm.setVisible(true);
    }//GEN-LAST:event_menuDangNhapActionPerformed

    private void menuThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuThoatActionPerformed
      System.exit(0);
    }//GEN-LAST:event_menuThoatActionPerformed

    private void menuDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDangXuatActionPerformed
      disableMenu();
      FrmLogin frm = new FrmLogin();
      frm.setVisible(true);

    }//GEN-LAST:event_menuDangXuatActionPerformed

    private void menuQLKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuQLKActionPerformed
      FrmListSystem frm = new FrmListSystem();
      frm.setVisible(true);
    }//GEN-LAST:event_menuQLKActionPerformed

    private void menuLienHeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLienHeActionPerformed

    }//GEN-LAST:event_menuLienHeActionPerformed

    private void menuLienHeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuLienHeMouseClicked
      Aboutme tt = new Aboutme();
      tt.setVisible(true);
      tt.setLocationRelativeTo(null);
    }//GEN-LAST:event_menuLienHeMouseClicked

    private void menuQLDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuQLDTActionPerformed
      FrmListScore f = new FrmListScore();
      f.setVisible(true);
    }//GEN-LAST:event_menuQLDTActionPerformed

  private void menuQLCLassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuQLCLassActionPerformed
    FrmListClass f = new FrmListClass();
    f.setVisible(true);
  }//GEN-LAST:event_menuQLCLassActionPerformed

  private void menuManageSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuManageSubjectActionPerformed
    FrmListSubjects f = new FrmListSubjects();
    f.setVisible(true);
  }//GEN-LAST:event_menuManageSubjectActionPerformed

  private void menuMNGLectureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMNGLectureActionPerformed
    FrmListLecturer f = new FrmListLecturer();
    f.setVisible(true);
  }//GEN-LAST:event_menuMNGLectureActionPerformed

  public static void enableMenu() {
    menuDangNhap.setVisible(false);
    menuDangXuat.setVisible(true);

    menuQLDT.setEnabled(true);
    menuQLK.setEnabled(true);
    menuQLSV.setEnabled(true);
    menuQLCLass.setEnabled(true);
    menuMNGLecture.setEnabled(true);
    menuManageSubject.setEnabled(true);
  }

  public static void disableMenu() {
    menuDangNhap.setVisible(true);
    menuDangXuat.setVisible(false);

    menuQLDT.setEnabled(false);
    menuQLK.setEnabled(false);
    menuQLSV.setEnabled(false);
    menuQLCLass.setEnabled(false);
    menuMNGLecture.setEnabled(false);
    menuManageSubject.setEnabled(false);
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
      java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
        new frmMain().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private static javax.swing.JMenu jMenu1;
  private javax.swing.JMenu jMenu2;
  private javax.swing.JMenuBar jMenuBar1;
  private static javax.swing.JMenuItem menuDangNhap;
  private static javax.swing.JMenuItem menuDangXuat;
  private javax.swing.JMenu menuLienHe;
  private static javax.swing.JMenuItem menuMNGLecture;
  private static javax.swing.JMenuItem menuManageSubject;
  private static javax.swing.JMenuItem menuQLCLass;
  private static javax.swing.JMenuItem menuQLDT;
  private static javax.swing.JMenuItem menuQLK;
  private static javax.swing.JMenuItem menuQLSV;
  private static javax.swing.JMenuItem menuThoat;
  // End of variables declaration//GEN-END:variables
}
