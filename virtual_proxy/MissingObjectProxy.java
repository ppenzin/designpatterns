/* MissingObjectProxy.java: Virtual proxy object that would stand in for a
 * MissingObject, if only it existed. Attempting to use this proxy will
 * crash the program.
 *
 * Author:   Heath Harrelson <harrel2@pdx.edu>
 * Created:  2013-02-18
 * Modified: 2013-02-18
 *
 */

import java.net.*;

class MissingObjectProxy implements ExpensiveObjectIF {
	private ExpensiveObjectIF realObject;

	private void loadRealObject () {
		try {
			URL[] classPath = { new URL("file:") };
			URLClassLoader classLoader = new URLClassLoader(classPath);
			Class realObjectClass = classLoader.loadClass("MissingObject");
			realObject = (ExpensiveObjectIF) realObjectClass.newInstance();
		} catch (Exception e) {
			// Couldn't load the class for realObject
			throw new RuntimeException();
		}
	}

	public void action1 () {
		if (realObject == null) {
			loadRealObject();
		}

		realObject.action1();
	}

	public void action2 () {
		if (realObject == null) {
			loadRealObject();
		}

		realObject.action2();
	}
}