
package demojavaswing;

import java.awt.Button;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;


public class DeMoImageIcon extends JFrame{
  
    public DeMoImageIcon(){
        
        setSize(300, 400);
        setLocation(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Them Label
        JLabel l1 = new JLabel("HRBB");
        add(l1);
        //Khoi tao text
        l1.setText("");
        //Chen Hinh anh
        ImageIcon ig = new ImageIcon("E:\\Pictures\\221.jpg");
        l1.setIcon(ig);
//        //Buton
//        JButton b1 = new JButton("0K");
//        add(b1, "North",1);
//        b1.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                l1.setText("Hello World");
//               
//            }
//        });
//        
//        JButton b2 = new JButton("0KI");
//        add(b2, "South",1);
//        b2.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                //l1.setText("Hello1 World1");
//                JOptionPane.showMessageDialog(rootPane, "Ban co muon thoat khong");
//                int click = JOptionPane.showConfirmDialog(rootPane, e);
//                if(click==JOptionPane.YES_OPTION){
//                    System.exit(0);
//                }
//                else{
//                    JOptionPane.showMessageDialog(rootPane, "Ban da huy");
//                }
//            }
//        });
        
       
    }
     
    public static void main(String[] args) {
        DeMoImageIcon d = new DeMoImageIcon();
        d.setVisible(true);
    }
}
