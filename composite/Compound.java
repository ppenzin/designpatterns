/* Compound.java: Compound statements (begin .. end blocks) in the while language.
 *
 * Author:   Heath Harrelson <harrel2@pdx.edu>
 * Modified: 2013-01-28
 *
 */

import java.util.*;

public class Compound extends Statement {
	private LinkedList<Statement> statements;

	// The grammar shows blocks including at least two statements
	Compound (Statement s1, Statement s2, Statement... more) {
		statements = new LinkedList<Statement>();

		statements.add(s1);
		statements.add(s2);

		for (Statement s : more) {
			statements.add(s);
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
