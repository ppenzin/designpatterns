package expr_nof;

import java.io.PrintStream;

public class Var implements Expr {
	
	private final String var;
	Var(String var) {this.var = var;}
	public void print(PrintStream out) {out.print(var);}

}
