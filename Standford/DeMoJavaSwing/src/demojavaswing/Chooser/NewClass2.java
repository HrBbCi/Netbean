/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demojavaswing.Chooser;

import javax.swing.JFrame;


public class NewClass2 {
  private javax.swing.JPanel jPanel1;
  private javax.swing.JTabbedPane jTabbedPane1;
  public void initComponents() {
    JFrame fr = new JFrame();
    jTabbedPane1 = new javax.swing.JTabbedPane();
    jPanel1 = new javax.swing.JPanel();


    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 395, Short.MAX_VALUE)
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 272, Short.MAX_VALUE)
    );

    jTabbedPane1.addTab("tab1", jPanel1);
    fr.setVisible(true);
  }
}
