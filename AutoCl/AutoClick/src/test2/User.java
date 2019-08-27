package test2;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class User{
	
	public User(){
		
	}
	
	public void update(){
		
	}
	
	public void draw(Graphics2D g2d){
		
	}

	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_G){
			if(Gui.ShouldClick == true){
				Gui.ShouldClick = false;
			}else{
				Gui.ShouldClick = true;
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		
	}
}
