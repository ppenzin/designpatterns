package pattpack.color;

import java.io.*;

/**
 *  Black side of the chip (singleton).
 */
public final class Black implements ColorIF {
    private static final Black instance = new Black();
    private Black() {}

    public static Black getInstance() { return instance; }
    public String toString() { return "B"; }
}
