package pattpack.account;

/** Exception thrown when an account usage exceeds its limits. */
public class InternalErrorException extends Exception {
    /**
     *  Construct an exception.
     *  @param message The message to report to the user.
     *    The message should explain which limit of an account usage
     *    is being exceeded.
     */
    public InternalErrorException (String message) { super (message); }
}






