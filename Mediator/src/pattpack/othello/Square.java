package pattpack.othello;

import java.io.*;
import pattpack.color.*;

/**
 *  Square -- liked grid to store chips
 */
public class Square {
    /* No default constructor */
    private Square() {}
    private ColorIF color; /* Which side is up */
    /* The board we belong to */
    private Board director;

    /* Colnstructor that sets the color
    public Square(ColorIF color) {
        this.color = color;
    } */
    /* Colnstructor that sets the color and references */
    public Square(ColorIF color) {
        this.color = color;
    }

    /* Colnstructor that sets the director */
    public Square(Board director) {
        this.director = director;
        this.color = null;
    }

    /* Add the board (director) */
    public void setDirector(Board director) {
        this.director = director;
    }

    /* Get the color */
    public ColorIF getColor() {
        return this.color;
    }

    /* Set the color */
    public void setColor(ColorIF color) {
        this.color = color;
    }


    /* Getter for the neighbors */
    public Square getNeighbor(Direction d) {
        return director.getNeighbor(d, this);
    }

    /* Set a bridge if possible */
    public void setBridge(Direction d, ColorIF color) throws NotByTheRulesException {
        /* Can only set empty squares */
        if (getColor() != null)
            throw (new NotByTheRulesException("Can only set on empty squares."));

        /* We know that the current position is empty
         */
        /* Check that the next position is not off the board */
        Square next = getNeighbor(d);
        try {
            if (next.getColor() == color)
                /* need to check the next one not to be the color we need */
                throw (new NotByTheRulesException("Too close to your own color."));
        } catch (NullPointerException ignore) {
            throw (new NotByTheRulesException("Too close to the side of the board."));
        }

        /* Check for a run on chips of opposite color */
        setBridgeTail(next, d, color);

        /* Finally set the color */
        setColor(color);
    }

    public void setBridgeTail(Square sq, Direction d, ColorIF color)  throws NotByTheRulesException {
        if (sq == null)
            throw (new NotByTheRulesException("Reached an empty space instead of a chip."));
        sq.setColor(color);
    }

    public String toString() {
        if (color == null)
            return(".");
        return(color.toString());
    }
}
