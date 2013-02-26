package pattpack.expr_intr;

import java.io.*;

/**
 *  This class represents a variable in an expression.
 *  For the purpose of this exercise, literals are represented
 *  as instances of this class.
 *  <P>
 *  This class could very well be a static inner class of the
 *  factory of variables.
 */
public class Variable implements Expr {
    private String name;
    private int value;
    /**
     *  Construct a variable.
     *  @param name The identifier of this variable.
     */
    /* public */ Variable (String name) {
        this.name = name;
        /* Try to interpret is a number */
        try {
            value = Integer.parseInt(name);
        } catch (NumberFormatException e) {
            value = 0;
        }
    }
    /**
     *  Set the value.
     *  @param value New value of this variable.
     */
    public void setValue (int value) { this.value = value; }
    /**
     *  Print this expression.
     *  @param out The stream where the expression is printed.
     */
    public void print (PrintStream out) { out.print (name); }
    /**
     *  Evaluate the expression
     *  Needs value sharing in order to work
     */
    public int eval() {
        return value;
    }
}
