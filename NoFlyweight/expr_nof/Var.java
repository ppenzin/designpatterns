package expr_nof;

import java.io.PrintStream;

public class Var implements Expr {
	
	private String var;
	public Var(String var) {this.var = var;}
	public void print(PrintStream out) {out.print(var);}

}
