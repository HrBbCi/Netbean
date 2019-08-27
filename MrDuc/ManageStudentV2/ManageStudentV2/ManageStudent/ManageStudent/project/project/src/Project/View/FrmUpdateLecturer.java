package Project.View;

import Project.Controller.ClassDAO;
import Project.Model.Lecturer;
import Project.Controller.LecturerDAO;
import Project.Model.Classs;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;

public class FrmUpdateLecturer extends javax.swing.JFrame {

  LecturerDAO ltd = new LecturerDAO();
  private String idLT = "";
  FrmListLecturer frmd = new FrmListLecturer();

  public String getIdLT() {
    return idLT;
  }

  public void setIdLT(String idLT) {
    this.idLT = idLT;
  }

  /**
   * Creates new form FrmUpdateLecturer
   */
  public FrmUpdateLecturer() {
    initComponents();
    setLocationRelativeTo(null);
//    getRootPane().setDefaultButton(btnUp);
//    btnUp.requestFocus();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    buttonGroup1 = new javax.swing.ButtonGroup();
    jPanel1 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    txtID = new javax.swing.JTextField();
    txtName = new javax.swing.JTextField();
    txtAdress = new javax.swing.JTextField();
    rbMale = new javax.swing.JRadioButton();
    rbFeamel = new javax.swing.JRadioButton();
    dateBirthday = new com.toedter.calendar.JDateChooser();
    jLabel6 = new javax.swing.JLabel();
    cboClass = new javax.swing.JComboBox<>();
    btnCan = new javax.swing.JButton();
    btnUp = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Update Lecturer");
    setAlwaysOnTop(true);
    addWindowListener(new java.awt.event.WindowAdapter() {
      public void windowOpened(java.awt.event.WindowEvent evt) {
        formWindowOpened(evt);
      }
    });

    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Information of Lecturer"));

    jLabel1.setText("ID: ");

    jLabel2.setText("Name: ");

    jLabel3.setText("Sex:");

    jLabel4.setText("Birthday:");

    jLabel5.setText("Adress:");

    txtID.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        txtIDKeyPressed(evt);
      }
    });

    txtName.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        txtNameKeyPressed(evt);
      }
    });

    txtAdress.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        txtAdressKeyPressed(evt);
      }
    });

    buttonGroup1.add(rbMale);
    rbMale.setText("Male");
    rbMale.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        rbMaleKeyPressed(evt);
      }
    });

    buttonGroup1.add(rbFeamel);
    rbFeamel.setText("Female");
    rbFeamel.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        rbFeamelKeyPressed(evt);
      }
    });

    dateBirthday.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        dateBirthdayKeyPressed(evt);
      }
    });

    jLabel6.setText("CounselorClass");

    cboClass.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        cboClassKeyPressed(evt);
      }
    });

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jLabel5)
          .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
              .addGap(37, 37, 37)
              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createSequentialGroup()
                  .addComponent(rbMale)
                  .addGap(18, 18, 18)
                  .addComponent(rbFeamel))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(dateBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(cboClass, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1)
          .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(21, 21, 21)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel3)
          .addComponent(rbMale)
          .addComponent(rbFeamel))
        .addGap(15, 15, 15)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(jLabel4)
          .addComponent(dateBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel5)
          .addComponent(txtAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel6)
          .addComponent(cboClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(16, Short.MAX_VALUE))
    );

    btnCan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project/Images/cancel.gif"))); // NOI18N
    btnCan.setText("Cancel");
    btnCan.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnCanActionPerformed(evt);
      }
    });

    btnUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project/Images/book_edit.png"))); // NOI18N
    btnUp.setText("Update");
    btnUp.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnUpActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(btnUp)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnCan)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(btnCan)
          .addComponent(btnUp))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents


  private void btnUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpActionPerformed
    Update();
  }//GEN-LAST:event_btnUpActionPerformed

  private void btnCanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanActionPerformed
    this.dispose();
  }//GEN-LAST:event_btnCanActionPerformed

  private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    if (!idLT.isEmpty()) {
      this.setTitle("Update Lecturer");
      btnUp.setText("Update");
      displayDetails();
    } else {
      this.setTitle("Add Lecturer");
      btnUp.setText("Add");
    }
    displayClass();

  }//GEN-LAST:event_formWindowOpened

  private void txtIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
      txtName.requestFocus();
    }
  }//GEN-LAST:event_txtIDKeyPressed

  private void txtNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
      rbFeamel.requestFocus();

    }
  }//GEN-LAST:event_txtNameKeyPressed

  private void rbMaleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rbMaleKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
      dateBirthday.requestFocus();
    }
  }//GEN-LAST:event_rbMaleKeyPressed

  private void rbFeamelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rbFeamelKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
      dateBirthday.requestFocus();
    }
  }//GEN-LAST:event_rbFeamelKeyPressed

  private void dateBirthdayKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dateBirthdayKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
      txtAdress.requestFocus();
    }
  }//GEN-LAST:event_dateBirthdayKeyPressed

  private void txtAdressKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdressKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
      cboClass.requestFocus();
    }
  }//GEN-LAST:event_txtAdressKeyPressed

  private void cboClassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboClassKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
      Update();
    }
  }//GEN-LAST:event_cboClassKeyPressed

  private void Update() {
    Lecturer lt = new Lecturer();
    if (txtID.getText().isEmpty()) {
      Jop("Please fill ID");
      return;
    }
    if (txtName.getText().isEmpty()) {
      Jop("Please fill name");
      return;
    }
    if (!rbMale.isSelected() && !rbFeamel.isSelected()) {
      Jop("Please fill sex");
      return;
    }
    
    String strClass = (String) cboClass.getSelectedItem();
    Classs cs = new Classs();
    cs.setName(strClass);
    lt.setCls(cs);
    lt.setCounselorClass(strClass);
    lt.setIdLecturer(txtID.getText());
    lt.setName(txtName.getText());
    if (rbMale.isSelected()) {
      lt.setSex(1);
    } else {
      lt.setSex(0);
    }
    lt.setBirthday(dateBirthday.getDate());
    lt.setAdress(txtAdress.getText());

    boolean kq = false;
    if (idLT == null || idLT.isEmpty()) {
      if (LecturerDAO.getInstance().isTest(lt.getIdLecturer())) {
        kq = ltd.newAdd(lt);
      } else {
        Jop("ID existed");
        return;
      }
    } else {
      kq = ltd.edit(lt);
    }
    if (kq) {
      JOptionPane.showMessageDialog(rootPane, "Sucess");
      frmd.display();
      frmd.setVisible(true);
    }
    this.dispose();
  }

  private void Jop(String a) {
    JOptionPane.showMessageDialog(rootPane, a);
  }

  private void displayDetails() {
    Lecturer lt = ltd.getByID(idLT);
    if (lt != null) {
      txtID.setText(lt.getIdLecturer());
      txtID.setEnabled(false);
      txtName.setText(lt.getName());
      txtAdress.setText(lt.getAdress());
      if (lt.getSex() == 1) {
        rbMale.setSelected(true);
      } else {
        rbFeamel.setSelected(true);
      }
      dateBirthday.setDate(lt.getBirthday());
      cboClass.setSelectedItem(lt.getCounselorClass());
    } else {
      System.out.println("LT NULL");
    }
  }


  private void displayClass() {
    List<Classs> lst = new ClassDAO().getAllCLass();
    cboClass.removeAllItems();
    lst.forEach((ck) -> {
      cboClass.addItem(ck.getName());
    });
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
      java.util.logging.Logger.getLogger(FrmUpdateLecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(FrmUpdateLecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(FrmUpdateLecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(FrmUpdateLecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new FrmUpdateLecturer().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnCan;
  private javax.swing.JButton btnUp;
  private javax.swing.ButtonGroup buttonGroup1;
  private javax.swing.JComboBox<String> cboClass;
  private com.toedter.calendar.JDateChooser dateBirthday;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JRadioButton rbFeamel;
  private javax.swing.JRadioButton rbMale;
  private javax.swing.JTextField txtAdress;
  private javax.swing.JTextField txtID;
  private javax.swing.JTextField txtName;
  // End of variables declaration//GEN-END:variables
}
