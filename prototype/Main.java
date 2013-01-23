import pattpack.account.*;

/**
 *  This class is only a driver to show how to use
 *  an abstract factory.  The factory is about computer
 *  accounts of various classes referred to as <EM>Economy</EM>,
 *  <EM>Standard</EM> and <EM>Professional</EM>.
 *  For the purpose of this exercise, only <EM>Economy</EM>
 *  accounts are implemented.
 */
public class Main {
    /**
     *  Standard entry.  The program reads a single integer.
     *  The integer stands for a login id. Different ranges
     *  of ids give accounts of different classes.
     */
    public static void main (String [] loginIDarray) {
	if (loginIDarray.length != 1) {
	    System.err.println ("Command requires an argument");
	    System.exit (1);
	}
	int loginId = -1;
	try { loginId = Integer.parseInt (loginIDarray [0]); }
	catch (NumberFormatException ex) {
	    System.err.println ("Argument must be an integer");
	    System.exit (1);
	}

	// Note how the following code is independent of the
        // account type: economy, standard or professional. 
	// Both the account and the security manager are
	// created consistently (for each other) by the factory.
        UserPrototypeFactory userFactory = UserPrototypeFactory.getInstance ();
        try {
    	    User user
    	        = userFactory.newUser (loginId);
	    System.out.println (user);
        } catch (InternalErrorException e) {
	    System.err.println (e);
	    System.exit (1);
        }
    }
}
