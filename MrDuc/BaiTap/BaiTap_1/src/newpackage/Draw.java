package newpackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import javax.swing.JFrame;

public class Draw extends JFrame{

  public double vY;
  public double vX;
  public double x, y;

  public Draw(double x, double y) {
    this.x = x;
    this.y = y;
    vY = 0;
    vX = 0;
  }

  public void setVY(double v) {
    this.vY = v;
  }

  public void setVX(double v) {
    this.vX = v;
  }

  public void setPoint(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public void doDrawingRED(Graphics g) {
    g.setColor(Color.red);
    g.fillOval((int) (x) - 10, (int) y - 10, 30, 30);
  }

  public Draw() {
  }

  
  
}
