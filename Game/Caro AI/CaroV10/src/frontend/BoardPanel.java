/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author cuong
 */
public class BoardPanel extends JPanel implements MouseListener, Runnable {

    public static final int CELL_SIZE = 30;
    public static final int ROW = 30;
    public static final int COL = 30;
    public static final int BOARD_WIDTH = COL * CELL_SIZE + 1;
    public static final int BOARD_HEIGHT = ROW * CELL_SIZE + 1;
    private int currentPlayer = 0; // 0 means that there is no player
    private ArrayList<Point> playerXTrace;
    private ArrayList<Point> playerOTrace;
    // consider the below Point variable
    // is coordinate of last cell which player ticked in the board
    private Point lastStep;
    private boolean clicked; // detect whenever player ticked one cell
//    private ArrayList<String> log;

    public BoardPanel() {
        this.setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
        this.setBackground(new Color(238, 238, 238));

        playerOTrace = new ArrayList<>();
        playerXTrace = new ArrayList<>();
        lastStep = new Point(-1, -1); // initialize with an out-of-range point
        clicked = false;
//        log = new ArrayList<>();

        // important statment
        this.addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GRAY);
        // paint board
        for (int i = 0; i <= ROW; i++) {
            g.drawLine(i * CELL_SIZE, 0, i * CELL_SIZE, BOARD_HEIGHT - 1);
            g.drawLine(0, i * CELL_SIZE, BOARD_WIDTH - 1, i * CELL_SIZE);
            g.drawString(Integer.toString(i), i * CELL_SIZE - 20, BOARD_HEIGHT + 13);
            g.drawString(Integer.toString(i), BOARD_WIDTH + 5, i * CELL_SIZE - 10);
        }
        // draw X or O
        drawPlayerStep(g);
        // print log of game
//        printLog(g);

    }

//    public void printLog(Graphics g) {
//        if (clicked) {
//            String line = "Player " + currentPlayer + " ticked ["
//                    + (lastStep.x + 1)+ ", " + (lastStep.y + 1) + "]";
//
//            log.add(line);
//
//            g.setColor(Color.BLUE);
//            for (int i = 0; i < log.size(); i++) {
//                g.drawString(log.toString(), BOARD_WIDTH + 50, 50 + i * 10);
//            }
//        }
//
//    }

    private void drawPlayerStep(Graphics g) {
        Image img = getPlayeImage(1);
        // draw playerX steps
        for (int i = 0; i < playerXTrace.size(); i++) {
            Point p = playerXTrace.get(i);
            g.drawImage(img, p.x * CELL_SIZE, p.y * CELL_SIZE, null);
        }

        img = getPlayeImage(2);
        //draw playerO steps
        for (int i = 0; i < playerOTrace.size(); i++) {
            Point p = playerOTrace.get(i);
            g.drawImage(img, p.x * CELL_SIZE, p.y * CELL_SIZE, null);
        }
    }

    public synchronized void setCurrentPlayer(int p) {
        //notifyAll();

        currentPlayer = p;
    }

    public Point getLastStep() {
        clicked = false; // set clicked fasle after getting last step
        return lastStep;
    }

    public boolean isClicked() {
        return clicked;
    }

    private Image getPlayeImage(int p) {
        PlayerIcon myPlayerIcon = new PlayerIcon();
        // first player using X icon
        return (p == 1) ? myPlayerIcon.X_Icon : myPlayerIcon.O_Icon;
    }

    private Point getCellPoint(Point p) {
        int x = p.x / CELL_SIZE;
        int y = p.y / CELL_SIZE;
        return new Point(x, y);
    }

    //! AREA OF overriding methods of interface MouseListener
    @Override
    public void mouseClicked(MouseEvent e) {
        Point p = e.getPoint();
        int x = p.x;
        int y = p.y;
        //System.out.println(p);

        // check if player clicks inside the board
        if (x >= 0 && x <= BOARD_WIDTH
                && y >= 0 && y <= BOARD_HEIGHT) {

            Point cellPoint = getCellPoint(p);
            //System.out.println("After moving point: " + cellPoint);

            // check for duplicate step
            for (int i = 0; i < playerXTrace.size(); i++) {
                Point temp = playerXTrace.get(i);
                //System.out.println("previous point: " + temp);
                if (cellPoint.x == temp.x && cellPoint.y == temp.y) {
                    //System.out.println("Done!");
                    return;
                }
            }
            for (int i = 0; i < playerOTrace.size(); i++) {
                Point temp = playerOTrace.get(i);
                if (cellPoint.x == temp.x && cellPoint.y == temp.y) {
                    return;
                }
            }

            if (currentPlayer == 1) {
                playerXTrace.add(cellPoint);
                lastStep = cellPoint;
                clicked = true;
                repaint();

            } else if (currentPlayer == 2) {

                playerOTrace.add(cellPoint);
                lastStep = cellPoint;
                clicked = true;
                repaint();

            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void run() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
