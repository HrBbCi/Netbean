package frontend;

import backend.CPU;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author cuong
 */
public class BoardFrame extends JFrame {

    private BoardPanel panel;

    public static void main(String args[]) {
        BoardFrame frame = new BoardFrame();
        frame.setVisible(true);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            while (true) {

                frame.startGame();
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(BoardFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void startGame() throws InterruptedException {

        panel = new BoardPanel();

        //application.execute(panel);
        this.add(panel);
        this.validate();
        this.pack();

        int player = 1;
        Integer winner = 0;

        while (true) {
            panel.setCurrentPlayer(player);
            if (panel.isClicked()) {
                Point lastStep = panel.getLastStep();
                System.out.println("Player " + player + ": " + lastStep);

                CPU process = new CPU(lastStep, player, winner);

                process.execute();
                Thread.sleep(200);

                winner = process.getWinner();
                System.out.println("Winner after processing: " + winner);
                if (winner != 0) {

                    JOptionPane.showMessageDialog(this,
                            "The winner is player " + player,
                            "We have the winner!",
                            JOptionPane.INFORMATION_MESSAGE);
                    //System.exit(0);

                    return;

                }

                player = 3 - player;
            }

        }

    }

}
