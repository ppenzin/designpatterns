/* Compound.java: Compound statements (begin .. end blocks) in the while language.
 *
 * Author:   Heath Harrelson <harrel2@pdx.edu>
 * Modified: 2013-02-04
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

		// Because ';' is a statement separator, don't add it to last statement
		Statement lastStatement = statements.getLast();

		for (Statement s : statements) {
			code.append(s.prettyPrint(depth + 1));

			// Add a semicolon to all but the last non-composite substatement
			if (s != lastStatement && !s.isComposite()) {
				code.append(";");
			}

			code.append("\n");
		}

		code.append(this.indentString("  ", depth) + "end");

		return code.toString();
	}

	@Override public boolean isComposite () { return true; }
}
