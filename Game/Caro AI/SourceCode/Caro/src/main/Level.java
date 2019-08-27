
package main;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author datvt
 */
public class Level extends javax.swing.JFrame {

    public static final int DEPTH_EASY = 1;
    public static final int DEPTH_MEDIUM = 5;
    public static final int DEPTH_HARD = 11;
    
    public Level() {
        initComponents();
        setTitle("Level");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon(getClass().getResource("/res/icon.png"));
        Image image = icon.getImage();
        setIconImage(image);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btEasy = new javax.swing.JButton();
        btMedium = new javax.swing.JButton();
        btHard = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 102));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Level Play");

        btEasy.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        btEasy.setForeground(new java.awt.Color(255, 0, 0));
        btEasy.setText("Easy");
        btEasy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEasyActionPerformed(evt);
            }
        });

        btMedium.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        btMedium.setForeground(new java.awt.Color(255, 0, 0));
        btMedium.setText("Medium");
        btMedium.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMediumActionPerformed(evt);
            }
        });

        btHard.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        btHard.setForeground(new java.awt.Color(255, 0, 0));
        btHard.setText("Hard");
        btHard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHardActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btMedium)
                            .addComponent(btEasy, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btHard))))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btEasy, btHard, btMedium});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addComponent(btEasy, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btMedium)
                .addGap(29, 29, 29)
                .addComponent(btHard)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btEasy, btHard, btMedium});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btEasyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEasyActionPerformed
        MenuGame.maxDepth = DEPTH_EASY;
        setVisible(false);
    }//GEN-LAST:event_btEasyActionPerformed

    private void btMediumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMediumActionPerformed
       MenuGame.maxDepth = DEPTH_MEDIUM;
        setVisible(false);
    }//GEN-LAST:event_btMediumActionPerformed

    private void btHardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHardActionPerformed
        MenuGame.maxDepth = DEPTH_HARD;
        setVisible(false);
    }//GEN-LAST:event_btHardActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEasy;
    private javax.swing.JButton btHard;
    private javax.swing.JButton btMedium;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
