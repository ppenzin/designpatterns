import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *  This class implements a client of the remote calculator.
 */

public class rmiClient {

    /**
     *  The name of the server URI or simply "remoteCompute" if 
     *  the client executes on the server's host is used to lookup 
     *  the server on a network.
     */
    private static final String name = "remoteCompute";

    /**
     *  Install security manager, lookup remote calculator,
     *  request an addition,difference, and multiplication 
     *  and print the result.
     **/
    public static void main (String [] ignore) {
    	if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
    	
	try {
		
		remoteCompute calculate = (remoteCompute) Naming.lookup (name);
	    long resultAdd = calculate.add (34, 35);
	    System.out.println ("Client: Compute result of addition operation: " + resultAdd);
	    
	    long resultDiff = calculate.diff (890, 675);
	    System.out.println ("Client: Compute result of difference operation: " + resultDiff );
	    
	    long resultMul= calculate.mult (3456, 7654);
	    System.out.println ("Client: Compute result of multiplication operation: " + resultMul );
	    
	    
	    
	    
	    
	}
	catch (Exception e) {
	    System.err.println ("Client exception: " + e.getMessage ());
	    e.printStackTrace ();
	}
    }
}