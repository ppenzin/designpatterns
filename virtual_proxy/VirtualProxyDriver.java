/* VirtualProxyDriver.java: Driver program for Virtual Proxy demo.
 *
 * Author:   Heath Harrelson <harrel2@pdx.edu>
 * Created:  2013-02-18
 * Modified: 2013-02-18
 *
 */

import java.io.*;

class VirtualProxyDriver {
	private ExpensiveObjectIF expensiveThing;
	private ExpensiveObjectIF missingThing;

	private String status = "Enter your selection below.";

	public static void main (String[] args) {
		VirtualProxyDriver driverObject = new VirtualProxyDriver();
		driverObject.enterMainLoop();
	}

	public VirtualProxyDriver () {
		expensiveThing = new ExpensiveObjectProxy();
		missingThing   = new MissingObjectProxy();
	}

	/* Enter the program's main loop, which will run until the user tells us
	 * to quit. */
	public void enterMainLoop () {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String optionSelected = "";

		TerminalIO.clearScreen();

		boolean userQuit = false;
		while (!userQuit) {
			printMenu();
			printStatus();
			printPrompt("Selection: ");

			try {
				optionSelected = in.readLine();
			} catch (IOException ioe) { }

			userQuit = doSelection(optionSelected);
		}		
	}

	/* Displays the menu of actions the user can perform. */
	private void printMenu () {
		String[] options = { "Fast operation", "Slow operation", "Slow operation 2",
							 "Missing operation" };
		int menuLine = 10;

		// Print the menu header
		TerminalIO.clearScreen();
		TerminalIO.seekTo(menuLine, 10);
		TerminalIO.printHighlighted("Select an Option:");
		menuLine += 2;

		// Print each menu item
		for (int i = 0; i < options.length; i++, menuLine += 2) {
			TerminalIO.seekTo(menuLine, 12);
			TerminalIO.printPlain(String.format("%d) %s", i + 1, options[i]));
		}

		TerminalIO.seekTo(menuLine, 12);
		TerminalIO.printPlain("Q) Quit the program");
	}

	/* Prints the user input prompt on the last line of the screen. */
	private void printPrompt(String prompt) {
		TerminalIO.seekTo(TerminalIO.screenHeight(), 1);
		TerminalIO.printHighlighted(prompt);
	}

	/* Sets and prints the status string in one call. */
	private void printStatus (String status) {
		this.status = status;
		printStatus();
	}

	/* Prints out the status line. */
	private void printStatus () {
		int lastLine = TerminalIO.screenHeight();

		// clear second-to-last line to prevent status prior to first long
		// operation remaining on the screen (don't know why this happens)
		TerminalIO.seekTo(TerminalIO.screenHeight() - 2, 1);
		TerminalIO.clearLine();

		// clear, then print the status line
		TerminalIO.seekTo(TerminalIO.screenHeight() - 1, 1);
		TerminalIO.clearLine();
		TerminalIO.printReverseVideo(TerminalIO.padStringToLineLength(" " + status));
	}

	/* Performs the action specified by the user's input, returning whether the
	 * user wanted to quit. */
	private boolean doSelection (String selection) {
		if (selection.matches("((^[qQ]$)|^[Qq]uit$)"))
			return true;

		printPrompt("Wait...");

		switch (selection) {
			case "1":
				printStatus("Did fast thing. Please select again.");
				break;
			case "2":
				doSlowThing();
				printStatus("Did action1() on expensive object. Please select again.");
				break;
			case "3":
				doOtherSlowThing();
				printStatus("Did action2() on expensive object. Please select again.");
				break;
			case "4":
				printStatus("Get ready to crash...");
				doMissingThing();
				break;
			default:
				printStatus("Invalid option \"" + selection + "\". Please select again.");
		}

		return false;
	}

	/* Calls action1() on the proxy object. If the expensive object hasn't been
	 * instantiated yet, this will result in a delay. */
	private void doSlowThing () {
		printStatus("Doing action1() on expensive object...");
		expensiveThing.action1();
	}

	/* Calls action2() on the proxy object. If the expensive object hasn't been
	 * instantiated yet, this will result in a delay. */
	private void doOtherSlowThing () {
		printStatus("Doing action2() on expensive object...");
		expensiveThing.action2();
	}

	/* Calls action1() on the proxy for the missing class. This will cause the
	 * program to crash. */
	private void doMissingThing () {
		printStatus("Doing action1() on missing object...");
		missingThing.action1();
	}
}
