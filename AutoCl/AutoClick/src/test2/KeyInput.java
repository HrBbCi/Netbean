package test2;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	User user1;
	
	public KeyInput(User user){
		this.user1 = user;
	}
	
	public void keyPressed(KeyEvent e){
		user1.keyPressed(e);
	}
	
	public void keyReleased(KeyEvent e){
		user1.keyReleased(e);
	}
	

	
}
