/* Assignment: CS5423.801 (Dr. Thomas) SQL Database Program
 * Author: Terrance Harrelson
 * Created:  11/24/2009
 * Modified: 11/24/2009
 *
 * TerminalIO.java: Utility functions used to perform terminal
 *   I/O using teh ANSI terminal escape sequences.
 *
 */

class TerminalIO {
	private static final String ESC = "\033[";
	private static final String NORMAL = ESC + "0m";
	private static final String BOLD = ESC + "1m";
	private static final String CLEAR = ESC + "2J";
	private static final String SEEK_TOP = ESC + "1;1H";

	/* Prints a string to the terminal using bold text by using ANSI
	 * terminal escape sequences. */
	public static void printHighlighted (String text) {
		System.out.print(BOLD + text + NORMAL);
		System.out.flush();
	}

	/* Clears the screen and repositions the cursor at line 0, column 0
	 * using ANSI terminal escape sequences. */
	public static void clearScreen () {
		System.out.print(CLEAR);
		System.out.print(SEEK_TOP);
		System.out.flush();
	}
}
