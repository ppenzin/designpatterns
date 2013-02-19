package expr_nof;

import java.io.PrintStream;

public class Div implements Expr {
	
	private Expr left, right;
	public Div(Expr left, Expr right) {this.left = left; this.right = right;}
	public void print(PrintStream out) {
		out.print("(");
		left.print(out);
		out.print(" / ");
		right.print(out);
		out.print(")");
	}

}
