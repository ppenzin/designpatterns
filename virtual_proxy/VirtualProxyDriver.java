/* VirtualProxyDriver.java: Driver program for Virtual Proxy demo.
 *
 * Author:   Heath Harrelson <harrel2@pdx.edu>
 * Created:  2013-02-18
 * Modified: 2013-02-18
 *
 */

import java.io.*;

class VirtualProxyDriver {
	private static String status = "Enter your selection below.";

	public static void main (String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String optionSelected = "";

		boolean userQuit = false;
		while (!userQuit) {
			printMenu();
			printStatus();
			printPrompt();

			try {
				optionSelected = in.readLine();
			} catch (IOException ioe) { }
			userQuit = doSelection(optionSelected);
		}
	}

	/* Displays the menu of actions the user can perform. */
	static void printMenu () {
		TerminalIO.clearScreen();
		TerminalIO.seekTo(10, 10);

		TerminalIO.printHighlighted("Select an Option:");
	}

	/* Prints the user input prompt on the last line of the screen. */
	static void printPrompt() {
		TerminalIO.seekTo(TerminalIO.screenHeight(), 1);
		TerminalIO.printHighlighted("Selection: ");
	}

	/* Set the text that will be printed on the program's status line. */
	static void setStatus (String statusString) {
		status = statusString;
	}

	/* Prints the status string just above the prompt, full width and with
	 * reversed foreground / background colors. */
	static void printStatus () {
		TerminalIO.seekTo(TerminalIO.screenHeight() - 1, 1);
		TerminalIO.printReverseVideo(TerminalIO.padStringToLineLength(" " + status));
	}

	/* Performs the action specified by the user's input, returning whether the
	 * user wanted to quit. */
	static boolean doSelection (String selection) {
		if (selection.matches("((^[qQ]$)|^[Qq]uit$)"))
			return true;

		switch (selection) {
			case "1":
				setStatus("Did fast thing. Please select again.");
				break;
			case "2":
				setStatus("Did slow thing. Please select again.");
				break;
			case "3":
				setStatus("Should crash here.");
				break;
			default:
				setStatus("Invalid option \"" + selection + "\". Please select again.");
		}

		return false;
	}
}
