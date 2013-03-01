import pattpack.color.*;
import pattpack.othello.*;
import java.io.*;
import java.util.Scanner;

/**
 *  Driver for a Mediator pattern example.
 *  Implements the game of Othello in text mode
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    /* Board (mediator of the game) */
    private static Board board;

    /** Function to create classic Othello layout. 8x8 with 4 chips set in the
     *  middle (diagonally) 
     */
    private static Square [][] makeClassicLayout() {
        final int rows = 8;
        final int cols = 8;
        Square [][] squares = new Square[rows][cols];
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                /* Set the color layout */
                if ((row == 3 && col == 3) || (row == 4 && col == 4))
                    squares[col][row] = new Square(White.getInstance(), board);
                else if ((row == 3 && col == 4) || (row == 4 && col == 3))
                    squares[col][row] = new Square(Black.getInstance(), board);
                else
                    squares[col][row] = new Square(null, board);
            }
        }
        return squares;
    }
    /** Usual entry point. */
    public static void main (String [] arg) {
        int col,row;
        /* Initialize and print the board */
        board = new Board(makeClassicLayout());
        System.out.println(board);

        /* Make moves */
        while(true) {
            /* Light */
            System.out.print("Light: ");
            col = scanner.nextInt();
            row = scanner.nextInt();
            try {
                board.getPlayerWhite().move(col, row);
            } catch (NotByTheRulesException e) {
                System.out.println(e.getMessage());
            }
            /* Print board and score */
            System.out.println(board);
            /* Dark */
            System.out.print("Dark: ");
            col = scanner.nextInt();
            row = scanner.nextInt();
            try {
                board.getPlayerBlack().move(col, row);
            } catch (NotByTheRulesException e) {
                System.out.println(e.getMessage());
            }
            /* Print board and score */
            System.out.println(board);
        }
    }
}
