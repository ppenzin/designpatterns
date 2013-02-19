package expr_nof;

import java.io.PrintStream;

public class Add implements Expr {
	
	private Expr left, right;
	public Add(Expr left, Expr right) {this.left = left; this.right = right;}
	public void print(PrintStream out) {
		out.print("(");
		left.print(out);
		out.print(" + ");
		right.print(out);
		out.print(")");
	}

}
