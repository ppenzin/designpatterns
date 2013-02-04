/* Statement.java: Abstract superclass for statements in the while language.
 *
 * Author:   Heath Harrelson <harrel2@pdx.edu>
 * Modified: 2013-01-28
 *
 */
abstract class Statement {
    abstract String prettyPrint (int depth);

    public isComposite () { return false; }

    protected String indentString (String indentText, int repeat) {
    	if (repeat <= 0) {
    		return "";
    	}

    	String out = "";

    	for (int i = 0; i < repeat; i++) {
    		out += indentText;
    	}

    	return out;
    }
}
