
package main;

/**
 *
 * @author datvt
 */
public class EvalBoard {
       
        public int height, width;
        public int[][] eBoard;
        public EvalBoard(ChessBoard board)
        {
            height = board.Row;
            width = board.Col;
            eBoard = new int[board.Row][board.Col];
        }
}
