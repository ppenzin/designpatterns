/* VirtualProxyDriver.java: Driver program for Virtual Proxy demo.
 *
 * Author:   Heath Harrelson <harrel2@pdx.edu>
 * Modified: 02/18/2013
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

	static void printMenu () {
		TerminalIO.clearScreen();
		TerminalIO.seekTo(10, 10);

		TerminalIO.printHighlighted("Select an Option:");
	}

	static void printPrompt() {
		TerminalIO.seekTo(TerminalIO.screenHeight(), 1);
		TerminalIO.printHighlighted("Selection: ");
	}

	static void setStatus (String statusString) {
		status = statusString;
	}

	static void printStatus () {
		TerminalIO.seekTo(TerminalIO.screenHeight() - 1, 1);
		TerminalIO.printReverseVideo(TerminalIO.padStringToLineLength(" " + status));
	}

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
