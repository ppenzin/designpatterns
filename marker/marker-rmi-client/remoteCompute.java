
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
 * runtime's failure to recognize the remote methods declared by 
 * the remoteCompute interface and hence throw remoteException in 
 * remoteComputeServer**/
public interface remoteCompute extends Remote {
	 public long add(long x,long y) throws RemoteException;
	 public long diff(long x,long y) throws RemoteException;
	 public long mult(long x,long y) throws RemoteException;
}