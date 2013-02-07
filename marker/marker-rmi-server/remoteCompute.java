import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *Interface remoteCompute defines the methods that can be called remotely
 *It defines operations add()/diff()/and mult()
 **/

/**
 * @author indradip
 *
 */
/**remoteCompute interface implements the Remote marker interface
 * Failure to implement the Remote interface would lead to the RMI 
 * runtime's failure to generate the stubs
 ***/

public interface remoteCompute extends Remote{

	 public abstract long add(long x,long y) throws RemoteException;
	 public abstract long diff(long x,long y) throws RemoteException;
	 public abstract long mult(long x,long y) throws RemoteException;
}