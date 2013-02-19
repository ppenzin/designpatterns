package expr_nof;

import java.io.PrintStream;

public class VarLine implements Var {
	
	private VarPrim var;
	private int line;
	public VarLine(VarPrim var, int line) {this.var = var; this.line = line;}
	public void print(PrintStream out) {var.print(out);}

}
