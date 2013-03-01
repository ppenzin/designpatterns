package pattpack.othello;

import java.io.*;
import pattpack.color.*;

/**
 *  Player that plays White.
 */
public class PlayerWhite extends Player {
    public PlayerWhite(Board b) { super(b); }
    public ColorIF getColor() { return White.getInstance(); }
}
