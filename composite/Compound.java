/* Compound.java: Compound statements (begin .. end blocks) in the while language.
 *
 * Author:   Heath Harrelson <harrel2@pdx.edu>
 * Modified: 2013-02-02
 *
 */

import java.util.*;

public class Compound extends Statement {
	private LinkedList<Statement> statements;

	// Blocks contain zero or more statements
	Compound (Statement... statements) {
		this.statements = new LinkedList<Statement>();

		for (Statement s : statements) {
			this.statements.add(s);
		}
	}

	@Override public String prettyPrint (int depth) {
		StringBuffer code = new StringBuffer();
		code.append(this.indentString("  ", depth) + "begin\n");

		for (Statement s : statements) {
			code.append(s.prettyPrint(depth + 1));
		}

		code.append(this.indentString("  ", depth) + "end\n");

		return code.toString();
	}
}
