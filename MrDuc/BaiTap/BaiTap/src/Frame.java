import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	private Draw panel;

	public Frame() {
		setTitle("Draw");
		setSize(800, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.panel = new Draw();
		getContentPane().add(this.panel, BorderLayout.CENTER);
		setVisible(true);
	}
}
