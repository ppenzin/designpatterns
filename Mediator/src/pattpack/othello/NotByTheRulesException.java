package pattpack.othello;

/** Exception thrown when a move breaks the rules. */
public class NotByTheRulesException extends Exception {
    /**
     *  Construct an exception.
     *  @param message The message to report to the user.
     */
    public NotByTheRulesException (String message) { super (message); }
}






