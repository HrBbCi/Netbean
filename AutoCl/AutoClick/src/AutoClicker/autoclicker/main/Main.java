package AutoClicker.autoclicker.main;

import javax.swing.SwingUtilities;

import AutoClicker.autoclicker.gui.MainFrame;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(MainFrame::new);
	}
}
