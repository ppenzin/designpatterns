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
    public Square(ColorIF color, Board director) {
        this.color = color;
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

    public String toString() {
        if (color == null)
            return(".");
        return(color.toString());
    }
}
