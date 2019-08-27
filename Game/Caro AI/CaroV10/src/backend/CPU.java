package backend;

import java.awt.Point;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;

/**
 *
 * @author cuong
 */
public class CPU extends SwingWorker<Integer, Boolean> {

    private final static int ROW = 15;
    private final static int COL = 15;

    public static int board[][] = new int[ROW][];
    static {
        for (int i = 0; i < ROW; i++) {
            board[i] = new int[COL];
        }
    }
    private Point lastStep;
    private Integer winner;
    private int player;

    public CPU(Point p, int ply, Integer w) {
        lastStep = p;
        winner = w;
        player = ply;
    }

    public void display() {

        System.out.print(" ");
        for (int i = 0; i < ROW; i++) {
            System.out.print(" " + " " + i);
        }
        System.out.println();

        for (int i = 0; i < ROW; i++) {
            //System.out.println();
            System.out.print(i + " ");

            for (int j = 0; j < COL; j++) {
                if (board[i][j] == 1) {
                    System.out.print(" X ");
                } else if (board[i][j] == 2) {
                    System.out.print(" O ");
                }
                else
                System.out.print(" | ");
            }
            System.out.println();

        }

    }

    public boolean mark(int x, int y, int player) {

        if (checkValid(x, y)) {
            board[x][y] = player;
            return true;
        }
        else
            return false;

    }

    public boolean checkValid(int x, int y) {
        if (board[x][y] == 0) {
            return true;
        }
        else return false;
    }

    public int checkWin() {
        int row = checkRow();
        if (row != 0) {
            return row;
        
        }        
        
        int col = checkCol();
        if (col != 0) {
            return col;
        
        }
        int d1 = checkDiag1();
        if (d1 != 0) {
            return d1;
        }
        
        int d2 = checkDiag2();
        if (d2 != 0) {
            return d2;
        }

        return 0;
    }

    public int checkCol() {
        for(int i = 0; i< ROW-4; i++) {
            for(int j = 0; j < COL; j++) {
                int val = board[i][j]*board[i+1][j]*board[i+2][j]*board[i+3][j]*board[i+4][j];
                if(val == 1)
                    return 1;
                else if (val == 32)
                    return 2;
            }
        }
        return 0;
    }

    public int checkRow() {
        for(int i = 0; i< ROW; i++) {
            for(int j = 0; j < COL-4; j++) {
                int val = board[i][j]*board[i][j+1]*board[i][j+2]*board[i][j+3]*board[i][j+4];
                if(val == 1)
                    return 1;
                else if (val == 32)
                    return 2;
            }
        }
        return 0;
    }

    public int checkDiag1() {

        for(int i= 0; i < ROW-4; i++) {
            for(int j=0; j<COL-4; j++) {
                int val = board[i][j]*board[i+1][j+1]*board[i+2][j+2]*board[i+3][j+3]*board[i+4][j+4];
                if(val == 1)
                    return 1;
                else if (val == 32)
                    return 2;
            }
        }
        return 0;
    }
    public int checkDiag2() {

        for(int i=0; i<ROW-4; i++) {
            for(int j=4 ; j<COL-4; j++) {
                int val = board[i][j]*board[i+1][j-1]*board[i+2][j-2]*board[i+3][j-3]*board[i+4][j-4];

                if(val == 1)
                    return 1;
                else if (val == 32)
                    return 2;
            }
        }
        return 0;
    }

//    public static void main(String args[]) {
//        CPU g = new CPU();
//        int turn = 1;
//        while (g.checkWin() == 0) {
//
//            g.display();
//
//            System.out.println("Player " + turn + ": ");
//            Scanner in = new Scanner(System.in);
//            int x = in.nextInt();
//            int y = in.nextInt();
//
//            if (!g.mark(x, y, turn)) {
//                System.out.println("Wrong choice");
//                continue;
//            }
//
//            turn = 3 - turn;
//        }
//
//        g.display();
//        System.out.println("The winner is player " + g.checkWin());
//
//    }

    @Override
    protected Integer doInBackground() throws Exception {
        mark(lastStep.x, lastStep.y, player);
        return checkWin();        
        
    }

    @Override
    protected void done() {
        try {
            winner = get();
            System.out.println("Winner inside: " + winner);
                        
            
        } catch (InterruptedException ex) {
            Logger.getLogger(CPU.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(CPU.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Integer getWinner() {
        return winner;
    }
    
}