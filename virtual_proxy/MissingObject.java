/* MissingObject.java: Defines the class for an object that the MissingObjectProxy
 * will stand in for. The class file for this class should be deleted after 
 * compiling the program.
 *
 * Author:   Heath Harrelson <harrel2@pdx.edu>
 * Modified: 2013-02-18
 *
 */

class MissingObject implements ExpensiveObjectIF {
	public MissingObject () {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ie) { }
	}

	public void action1 () { }

	public void action2 () { }
}