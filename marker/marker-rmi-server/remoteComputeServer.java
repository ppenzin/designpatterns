import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
	
/**Declaring the Remote Interface Being Implemented**/	
public class remoteComputeServer implements remoteCompute {

	
		public remoteComputeServer() {
	        super();
	    }

	   
	    public long add(long x,long y) throws RemoteException{
	        return x + y;
	    }
		 public long diff(long x,long y) throws RemoteException{
			 return x >=y ? x - y : y - x; 			 
		 }
		 public long mult(long x,long y) throws RemoteException{
			 return x * y;
		 }
	

	    public static void main(String[] args) {
	    	
	    	/**Creating and Installing a Security Manager**/
	        if (System.getSecurityManager() == null) {
	            System.setSecurityManager(new SecurityManager());
	        }
	        try {
	        	/**The remote service is registered to the RMI runtime with this name**/
	            String name = "remoteCompute";
	            
	            /**Making the Remote Object Available to Clients
	             *creates an instance of ComputeEngine and exports it to
	             *the RMI runtime**/
	            
	            remoteComputeServer server = new remoteComputeServer();
	            
	            /**The second argument to exportObject specifies the TCP port to listen
	             *to for incoming client requests**/
	            remoteCompute stub =
	                (remoteCompute) UnicastRemoteObject.exportObject(server, 0);
	            /**Note: Failure to implement Remote would generate the following error:
	            * The method exportObject(Remote, int) in the type UnicastRemoteObject is
	            *not applicable for the arguments (remoteComputeServer, int)
	            **/
	            
	            /**The remote object naming service "RMI registry" enables clients
	             *to obtain a reference to a remote object by name**/
	            Registry registry = LocateRegistry.getRegistry();
	            registry.rebind(name, stub);
	            /**Note: Failure to implement Remote would generate the following error:
		         * The method rebind(String, Remote) in the type Registry is not applicable
		         * for the arguments (String, remoteCompute)
		        **/
	            
	        } catch (Exception e) {
	            System.err.println("remoteComputeServer exception:");
	            e.printStackTrace();
	        }
	    }
	}