package test2;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Gui extends JPanel implements ActionListener{

	private static final long serialVersionUID = 4817097319118986411L;
	public static int clickCount = 0;
	public static int timeClicked = 0;
	public static boolean ShouldClick = false;
	public String clickCountText = "Click Count: ";
	
	Timer loopTimer;
	User user;
	Robot robt;
	
    public Gui() {
    	setFocusable(true);
    	
    	loopTimer = new Timer(10, this);
    	loopTimer.start();
    	  	
    	
    	user = new User();
    	try {
			robt = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
    	
    	addKeyListener(new KeyInput(user));
	}
    
    public void paint(Graphics g){
    	super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setFont(new Font("Arial", Font.PLAIN, 20));
		g2d.setColor(Color.black);
		g2d.drawString(clickCountText+clickCount, 30, 40);
		g2d.drawString("To start clicken press G", 30, 100);
    }
    
    public void updateText(){
    	clickCountText = "Click Count: "+clickCount;
    }

    public void click(){
    	 robt.mousePress(InputEvent.BUTTON1_MASK);
    	 robt.delay(80);
    	 robt.mouseRelease(InputEvent.BUTTON1_MASK);    
    }
 
    
	@Override
	public void actionPerformed(ActionEvent e) {
		if(ShouldClick){
			clickCount += 1;
			updateText();
			System.out.println(ShouldClick);
			click();
		}
		repaint();
	}

}
