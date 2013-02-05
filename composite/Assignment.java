/* Assignment.java: Assignment statements in the while language.
 *
 * Author:   Heath Harrelson <harrel2@pdx.edu>
 * Modified: 2013-01-28
 *
 */

public class Assignment extends Statement {
	private String var;
	private Expr expression;

	Assignment (String var, Expr expression) {
		this.var = var;
		this.expression = expression;
	}

	@Override public String prettyPrint (int depth) {
		String code = String.format("%s := %s", var, expression);
		return this.indentString("  ", depth) + code;
	}
}
