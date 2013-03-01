package pattpack.othello;

import java.io.*;
import pattpack.color.*;

/**
 *  Player interface. Player types should match colors of chip sides
 */
public class Player {
    private Board director;

    /* Constructors */
    protected Player() {}
    public Player(Board director) {
        this.director = director;
    }

    /* Color is overloaded in the concrete classes */
    public ColorIF getColor() { return null; };

    /* Move is negotiated */
    public void move(int col, int row) throws NotByTheRulesException {
        director.makeMove(col, row, this);
    }
}
