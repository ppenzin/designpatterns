package pattpack.account;
import java.util.*;

/**
 * Base class of all accounts.
 */
public abstract class AccountIF implements Cloneable {
    /** The id of this account. */
    protected int loginId;
    /** The number of connection hours used during the current month. */
    protected int connectionHoursThisMonth;
    /** The connection speed in Kbs of this login. */
    protected int connectionSpeedThisLogin;
    /**
     *  Construct an account.
     */
    public AccountIF () { this.loginId = 0; }
    /**
     *  Assign Login ID.
     *  @param loginId The login ID of this user.
     */
    protected void assignLoginId (int loginId) {
        this.loginId = loginId;
    }
    /** Clone method */
//    public Object clone() throws CloneNotSupportedException { return (AccountIF) super.clone(); }
    /** `Customized' clone method
     *  @param loginId login ID for the new user
     */
    protected Object makeNew(int loginId) throws CloneNotSupportedException {
        AccountIF clone = (AccountIF) super.clone(); 
        clone.assignLoginId(loginId);
        return clone;
    }
    /**
     *  Obtain the number of connection hours used during the current month.
     *  @return the number of connection hours used during the current month.
     */
    public int getConnectionHoursThisMonth () { return connectionHoursThisMonth; }
    /**
     *  Obtain the connection speed in Kbs of this login.
     *  @return the connection speed in Kbs of this login.
     */
    public int getConnectionSpeedThisLogin () { return connectionSpeedThisLogin; }
    // mailboxes, storage, comains, etc.
}






