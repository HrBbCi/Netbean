import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Draw extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btInc;
	private JButton btDec;
	private JRadioButton rbRed;
	private JRadioButton rbGreen;
	private JRadioButton rbBlue;

	private Graphics2D g2d;
	
	private void doDrawing(Graphics g) {
		this.g2d = (Graphics2D) g;
//		g2d.setPaint(Color.black);
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHints(rh);
		g2d.fillOval(350, 400, 50, 50);
	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		doDrawing(g);
	}

	public Draw() {
		setLayout(null);
		setBorder(null);
		
		this.btInc = new JButton("+");
		this.btInc.setBounds(29, 26, 89, 23);
		add(this.btInc);
		
		this.btDec = new JButton("-");
		this.btDec.setBounds(614, 26, 89, 23);
		add(this.btDec);
		
		this.rbRed = new JRadioButton("Red");
		this.rbRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rbRed.isSelected())
					g2d.setPaint(Color.red);
				paintComponent(g2d);
			}
		});
		
		this.rbRed.setBounds(274, 26, 109, 23);
		add(this.rbRed);
		
		this.rbGreen = new JRadioButton("Green");
		this.rbGreen.setBounds(274, 49, 109, 23);
		add(this.rbGreen);
		
		this.rbBlue = new JRadioButton("Blue");
		this.rbBlue.setBounds(274, 73, 109, 23);
		add(this.rbBlue);
	}
}
