
package demojavaswing.Chooser;
import java.awt.Panel;
import javax.swing.JFrame;

/**
 *
 * @author HrBbCi
 */
public class JFramee  {
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setSize(1000, 500);
    Panel panel = new Panel();
    frame.add(panel);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}
