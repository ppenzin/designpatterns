package pattpack.expr_intr;

import java.io.*;

/**
 *  This class represents an expression of the "while" language.
 *  Currently, expressions are empty.
 */
public interface Expr {
    /**
     *  Print this expression.
     *  @param out The stream where the expression is printed.
     */
    void print (PrintStream out);
    /**
     *  Evaluate the expression
     *  Needs value sharing in order to work
     */
    public int eval();
}
