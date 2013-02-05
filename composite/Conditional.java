/* Conditional.java: Conditional (if) expressions in the while language.
 *
 * Author:   Heath Harrelson <harrel2@pdx.edu>
 * Modified: 2013-01-28
 *
 */

public class Conditional extends Statement {
	private Expr test;
	private Statement ifBranch;
	private Statement elseBranch;

	Conditional (Expr test, Statement ifBranch, Statement elseBranch) {
		this.test = test;
		this.ifBranch = ifBranch;
		this.elseBranch = elseBranch;
	}

	@Override public String prettyPrint (int depth) {
		// NOTE: what about printing differently if branches aren't compound?
		StringBuffer code = new StringBuffer();

		code.append(this.indentString("  ", depth));
		code.append(String.format("if %s then%n", test));
		code.append(ifBranch.prettyPrint(depth + 1));
		code.append(this.indentString("  ", depth) + "else\n");
		code.append(elseBranch.prettyPrint(depth + 1));

		return code.toString();
	}
}
