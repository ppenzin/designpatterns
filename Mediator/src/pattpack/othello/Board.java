package pattpack.othello;

import java.io.*;
import pattpack.color.*;

/**
 *  Board
 *  A class to serve as mediator
 */
public class Board {
    /* Default constructor initializes everything */
    public Board() {
        squares = new Square[size][size];
        for (int col = 0; col < size; ++col) {
            for (int row = 0; row < size; ++row) {
                squares[col][row] = new Square(this);
            }
        }
        squares[3][3].setColor(White.getInstance());
        squares[4][4].setColor(White.getInstance());
        squares[3][4].setColor(Black.getInstance());
        squares[4][3].setColor(Black.getInstance());
    }
    /* Grid */
    private Square [][] squares;
    /* Size of the board */
    private final int size = 8;
    /* Players */
    private final PlayerBlack playerBlack = new PlayerBlack(this);
    private final PlayerWhite playerWhite = new PlayerWhite(this);

    /* Find a neighbor of a square */
    public Square getNeighbor(Direction dir, Square sq) {
        try {
            /* We just traverse the whole board (not the most efficient solution) */
            for (int col = 0; col < size; ++col) {
                for (int row = 0; row < size; ++row) {
                    if (squares[col][row] == sq) {
                        return squares[col + dir.xIncr()][row + dir.yIncr()];
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException ignore) { }
        return null;
    }
    /* Roll back set chips from a position */
    private void rollBack(Square sq, Direction dir) {
        // Square to reset
        Square next = sq.getNeighbor(dir);
        /* Try to go as far as we potentially can */
        for (int i = 0; i < (size - 1); ++i) {
            /* No color or no more squares */
            if (next == null || next.getColor() == null) {
                break;
            }
            /* Revert the color */
            if (next.getColor() == Black.getInstance()) {
                next.setColor(White.getInstance());
            } else {
                next.setColor(Black.getInstance());
            }
            /* Advance our next pointer */
            next = next.getNeighbor(dir);
        }
    }
    /* Negotiate a move */
    public void makeMove(int row, int col, Player player) throws NotByTheRulesException {
        /* Square to set the disk */
        Square sq;
        /* Success flag */
        boolean goal = false;

        /* Find the square */
        try {
            sq = squares[row][col];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw (new NotByTheRulesException("Square is not on the board."));
        }

        /* Color to set */
        ColorIF cl = player.getColor();
        /** Check if there are any bridges available */
        for (Direction dir : Direction.values()) {
            // Square to reset
            Square next = sq.getNeighbor(dir);
            /* Try to go as far as we potentially can */
            for (int i = 0; i < (size - 1); ++i) {
                /* No color or no more squares */
                if (next == null || next.getColor() == null) {
                    /* Attempt to roll back */
                    rollBack(sq, dir);
                    break;
                }
                /* Opposite color -- reset */
                if (next.getColor() != cl) {
                    next.setColor(cl);
                } else {
                    /* Goal is reached (should not be in direct proximity) */
                    if (sq.getNeighbor(dir) != next) {
                        sq.setColor(cl);
                        goal = true;
                    }
                    break;
                }
                /* Advance our next pointer */
                next = next.getNeighbor(dir);
            }
        }
        /* No bridges */
        if (!goal)
            throw (new NotByTheRulesException("There must be a bridge."));
    }
    /* Get players */
    public PlayerBlack getPlayerBlack() { return this.playerBlack; }
    public PlayerWhite getPlayerWhite() { return this.playerWhite; }
    /* Print the board and number of chips */
    public String toString() {
        String ret = "";
        /* Color counts */
        int white, black;
        white = black = 0;

        /* Print the board and count chips */
        for (int rowIdx = 0; rowIdx < squares.length; ++rowIdx) {
            Square [] row = squares[rowIdx];
            // First row -- print column numbers 
            if (rowIdx == 0) {
                ret += "  " ;
                for (int colIdx = 0; colIdx < row.length; ++colIdx) {
                    ret += colIdx + " ";
                }
                ret += "\n" ;
            }

            ret += rowIdx + " " ;
            
            for (int colIdx = 0; colIdx < row.length; ++colIdx) {
                Square square = row[colIdx];
                ret += square + " ";
                if (square.getColor() == Black.getInstance())
                    ++black;
                if (square.getColor() == White.getInstance())
                    ++white;
            }
            ret += "\n" ;
        }
        /* Color counts */
        ret += "Black: " + black + " White: " + white;
        return ret;            
    }

}
