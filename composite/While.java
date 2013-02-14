/* While.java: While loops in the while language.
 *
 * Author:   Heath Harrelson <harrel2@pdx.edu>
 * Modified: 2013-02-04
 *
 */

public class While extends Statement {
	private Expr test;
	private Statement body;

	While (Expr test, Statement body) {
		this.test = test;
		this.body = body;
	}

	@Override public String prettyPrint (int depth) {
		StringBuffer code = new StringBuffer();

		code.append(this.indentString("  ", depth));
		code.append(String.format("while %s do%n", test));
		code.append(body.prettyPrint(depth + 1));

		return code.toString();
	}
}
