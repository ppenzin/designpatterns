import pattpack.color.*;
import pattpack.othello.*;
import java.io.*;
import java.util.*;

/**
 *  Driver for a Mediator pattern example.
 *  Implements the game of Othello in text mode
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);

    /** Usual entry point. */
    public static void main (String [] arg) {
        int col,row;
        /* Board (mediator of the game) */
        Board board;

        /* Initialize and print the board */
        board = new Board();
        System.out.println(board);

        /* Make moves */
        while(true) {
            /* Light */
            while (true) {
                try {
                    System.out.print("Light(row,col): ");
                    row = scanner.nextInt();
                    col = scanner.nextInt();
                    board.getPlayerWhite().move(row, col);
                    break;
                } catch (NotByTheRulesException e) {
                    System.out.println(e.getMessage() + " Try again.");
                    continue;
                } catch (InputMismatchException e) {
                    System.out.println("Need an integer pair, separated by whitespace, try again.");
                    scanner.skip(".*");
                    continue;
                }
            }
            /* Print board and score */
            System.out.println(board);
            /* Dark */
            while (true) {
                try {
                    System.out.print("Dark(row,col): ");
                    row = scanner.nextInt();
                    col = scanner.nextInt();
                    board.getPlayerBlack().move(row, col);
                    break;
                } catch (NotByTheRulesException e) {
                    System.out.println(e.getMessage() + " Try again.");
                    continue;
                } catch (InputMismatchException e) {
                    System.out.println("Need an integer pair, separated by whitespace, try again.");
                    scanner.skip(".*");
                    continue;
                }
            }
            /* Print board and score */
            System.out.println(board);
        }
    }
}
