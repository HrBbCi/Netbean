package test2;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JSlider;


public class Main {

	public static String title = "Squirrel's Auto Clicker";
	public static final int WIDTH = 300;
	public static final int HEIGHT = 250;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(WIDTH,HEIGHT);
		frame.setResizable(false);
		frame.setTitle(title);
		frame.add(new Gui());
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
