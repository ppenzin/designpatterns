package pattpack.ast_none;

import pattpack.expr_none.*;
import java.io.*;

/**
 *  This class represents a print statement.
 */

public class Print extends Statement {
    private Variable var;
    /**
     *  Constructor, instances are immutable.
     *  @param var The variable to print.
     */
    public Print (Variable var) {
	this.var = var;
    }
    /**
     *  Print this statement with indentation.
     *  @param out The stream where this statement is printed.
     *  @param indent The amount of indentation of this statement.
     */
    public void print (PrintStream out, int indent) {
	super.print (out, indent);
	out.print ("print ");
	var.print (out);
    }
    /**
     * Interpret the statement
     * Needs some value sharing in order to work
     */
    public void interpret() {
        System.out.println(var.eval());
    }
}
