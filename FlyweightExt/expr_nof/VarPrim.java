package expr_nof;

import java.io.PrintStream;

public class VarPrim implements Var{
	
	private final String var;
	VarPrim(String var) {this.var = var;}
	public void print(PrintStream out) {out.print(var);}

}
