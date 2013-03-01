package pattpack.othello;

import java.io.*;
import pattpack.color.*;

/**
 *  Player that plays Black.
 */
public class PlayerBlack extends Player {
    public PlayerBlack(Board b) { super(b); }
    public ColorIF getColor() { return Black.getInstance(); }
}
