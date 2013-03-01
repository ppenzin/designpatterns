package pattpack.color;

import java.io.*;

/**
 *  White side of the chip (singleton).
 */
public final class White implements ColorIF {
    private static ColorIF instance = new White();
    private White() {}

    public static ColorIF getInstance() { return instance; }
    public String toString() { return "W"; }
}
