package pattpack.othello;

import java.io.*;
import pattpack.color.*;

/**
 *  Board
 *  A class to serve as mediator
 */
public class Board {
    /* No default constructor */
    private Board() {}
    /* Grid */
    private Square [][] squares;
    /* Width and height */
    private int rows;
    private int cols;
    /* Players */
    final PlayerBlack playerBlack = new PlayerBlack(this);
    final PlayerWhite playerWhite = new PlayerWhite(this);

    /* Constructor that takes the layout */
    public Board(Square [][] squares) {
        this.cols = squares.length;
        this.rows = squares[0].length;
        this.squares = squares;
    }
    /* Find a neighbor of a square */
    public Square getNeighbor(Direction dir, Square sq) {
        try {
            /* We just traverse the whole board (not the most efficient solution) */
            for (int col = 0; col < cols; ++col) {
                for (int row = 0; row < rows; ++row) {
                    return squares[col + dir.xIncr()][row + dir.yIncr()];
                }
            }
        } catch (ArrayIndexOutOfBoundsException ignore) { }
        return null;
    }
    /* Negotiate a move */
    public void makeMove(int col, int row, Player player) throws NotByTheRulesException {
        /** Check with the rules */
        /* Can only set empty squares */
        if (squares[col][row].getColor() != null)
            throw (new NotByTheRulesException("Can only set on empty squares."));
        /* Check if there are any bridges available */
        squares[col][row].setColor(player.getColor());
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
        for (Square [] row : squares) {
            for (Square square : row) {
                ColorIF color = square.getColor();
                if (color != null) {
                    ret += color;
                    /* Count number of chips by color */
                    if (color == White.getInstance())
                        ++white;
                    else
                        ++black;
                } else
                    ret += ".";
                ret += " ";
            }
            ret += "\n" ;
        }
        /* Color counts */
        ret += "Black: " + black + " White: " + white;
        return ret;            
    }

}
