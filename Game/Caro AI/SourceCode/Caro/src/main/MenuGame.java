package main;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author datvt
 */
public class MenuGame extends javax.swing.JFrame {

    private InterfaceGame interfa;
    private Level level;
    public static int maxDepth;
    
    public MenuGame(int depth) {
        initComponents();
        setTitle("Gomoku");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon(getClass().getResource("/res/icon.png"));
        Image image = icon.getImage();
        setIconImage(image);
        this.maxDepth = depth;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btHelp = new javax.swing.JButton();
        btAbout = new javax.swing.JButton();
        btExit = new javax.swing.JButton();
        btNewGame = new javax.swing.JButton();
        btOption = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanel1.setBackground(new java.awt.Color(255, 255, 51));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/game-co-caro.jpg"))); // NOI18N

        btHelp.setBackground(new java.awt.Color(255, 204, 0));
        btHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/help.png"))); // NOI18N
        btHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHelpActionPerformed(evt);
            }
        });

        btAbout.setBackground(new java.awt.Color(255, 204, 0));
        btAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/about.png"))); // NOI18N
        btAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAboutActionPerformed(evt);
            }
        });

        btExit.setBackground(new java.awt.Color(255, 204, 0));
        btExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/exit.png"))); // NOI18N
        btExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btExit.setFocusable(false);
        btExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExitActionPerformed(evt);
            }
        });

        btNewGame.setBackground(new java.awt.Color(255, 204, 0));
        btNewGame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/newGame.png"))); // NOI18N
        btNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNewGameActionPerformed(evt);
            }
        });

        btOption.setBackground(new java.awt.Color(255, 204, 0));
        btOption.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/option.png"))); // NOI18N
        btOption.setToolTipText("");
        btOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOptionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btAbout, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btExit, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btNewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btOption, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addComponent(btNewGame)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btOption)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btHelp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btAbout)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btExit)
                .addContainerGap(35, Short.MAX_VALUE))
        );

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

    private void btOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOptionActionPerformed
        level = new Level();
        level.setVisible(true);
    }//GEN-LAST:event_btOptionActionPerformed

    private void btExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btExitActionPerformed

    private void btNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNewGameActionPerformed
        setVisible(false);
        interfa = new InterfaceGame(maxDepth);
        interfa.setVisible(true);
    }//GEN-LAST:event_btNewGameActionPerformed

    private void btHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHelpActionPerformed
        Help help = new Help();
        help.setVisible(true);
    }//GEN-LAST:event_btHelpActionPerformed

    private void btAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAboutActionPerformed
       About about = new About();
       about.setVisible(true);
    }//GEN-LAST:event_btAboutActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAbout;
    private javax.swing.JButton btExit;
    private javax.swing.JButton btHelp;
    private javax.swing.JButton btNewGame;
    private javax.swing.JButton btOption;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
