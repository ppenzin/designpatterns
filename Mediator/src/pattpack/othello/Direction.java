package pattpack.othello;

import java.io.*;

/* Enum to help us with the direction */
public enum Direction {
    W, NW, N, NE, E, SE, S, SW;

    private static int x_index[] = {-1, -1,  0,  1, 1, 1, 0, -1};
    private static int y_index[] = { 0, -1, -1, -1, 0, 1, 1,  1};

    public int xIncr() {
        return x_index[this.ordinal()];
    }
    public int yIncr() {
        return y_index[this.ordinal()];
    }
}

