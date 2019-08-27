package frontend;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author cuong
 */
public class PlayerIcon {
    
    public Image X_Icon;
    public Image O_Icon;
    public int WIDTH = BoardPanel.CELL_SIZE - 2;
    public int HEIGHT = BoardPanel.CELL_SIZE - 2;
    
    public PlayerIcon() {
        X_Icon = new ImageIcon("./src/img/x.png").getImage();
        O_Icon = new ImageIcon("./src/img/o.png").getImage();
        // scale icon
        X_Icon = new ImageIcon(X_Icon.getScaledInstance(WIDTH, HEIGHT, X_Icon.SCALE_SMOOTH)).getImage();
        O_Icon = new ImageIcon(O_Icon.getScaledInstance(WIDTH, HEIGHT, O_Icon.SCALE_SMOOTH)).getImage();
    }
    
}
