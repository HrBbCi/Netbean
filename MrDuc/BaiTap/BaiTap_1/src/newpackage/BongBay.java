/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;

/**
 *
 * @author Giang Huong
 */
public class BongBay extends Frame {
    int x = 30;
    int y = 150;
    
    public BongBay(){
        super("Bong bay");
        setSize(300,300);
        setVisible(true);
    }
    
    public void DiChuyen(){
        (new Thread(new Runnable() {
            @Override
            public void run() {
                int v = 1;
                int t = 1;
                while(true){
                    try {
                        x = x +v;
                        y = y +t;
                        if(x >300)  v = -1;
                        if(y >300) t = -1;
                        if(x<0) v =1;
                        if(y<0) t=1;
                        repaint();
                        Thread.sleep(10);
                    } catch (Exception e) {
                    }
                }
            }
        })).start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); 
        g.setColor(Color.red);
        g.fillOval(x, y, 20,20);
    }
    public static void main(String[] args) {
        new BongBay().DiChuyen();
    }
}
