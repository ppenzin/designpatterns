/* ExpensiveObject.java: An object that simulates an object that is expensive to
 * create. This is the object that is proxied by the ExpensiveObjectProxy class.
 *
 * Author:   Heath Harrelson <harrel2@pdx.edu>
 * Created:  2013-02-18
 * Modified: 2013-02-18
 *
 */

class ExpensiveObject implements ExpensiveObjectIF {
	public ExpensiveObject () {
		// Simulate extended instantiation / initialization
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ie) { }
	}

	public void action1 () {

	}

	public void action2 () {

	}
}
